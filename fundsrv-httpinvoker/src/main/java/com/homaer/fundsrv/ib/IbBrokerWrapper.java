package com.homaer.fundsrv.ib;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import cn.jpush.api.push.model.Platform;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.cache.CacheManager;
import com.homaer.common.tools.jpush.JPushTool;
import com.homaer.common.tools.math.DateUtils;
import com.homaer.common.utils.SpringContextUtil;
import com.homaer.fundsrv.dataobject.BrokerOrderDto;
import com.homaer.fundsrv.dataobject.JpushDeviceDto;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.homaer.fundsrv.service.AccountCapitalService;
import com.homaer.fundsrv.service.BrokerOrderService;
import com.homaer.fundsrv.service.JpushDeviceService;
import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.UnderComp;

public class IbBrokerWrapper implements EWrapper
{

	private CacheManager cacheManager = (CacheManager) SpringContextUtil.getBean("cacheManager");
	
	private BrokerOrderService brokerOrderService = (BrokerOrderService) SpringContextUtil.getBean("brokerOrderServiceImpl");
	private AccountCapitalService accountCapitalService = (AccountCapitalService) SpringContextUtil.getBean("accountCapitalServiceImpl");
	private JpushDeviceService jpushDeviceService = (JpushDeviceService) SpringContextUtil.getBean("jpushDeviceServiceImpl");

	ConcurrentHashMap<String, String> accountValues = new ConcurrentHashMap<String, String>();
	ConcurrentHashMap<String, Integer> portfolio = new ConcurrentHashMap<String, Integer>();
	String accountUpdateTime;
	public ConcurrentHashMap<Integer, Double> lastPrices = new ConcurrentHashMap<Integer, Double>();
	public ConcurrentHashMap<String, Double> portfolioPnl = new ConcurrentHashMap<String, Double>();
	@SuppressWarnings("unused")
	private int tickType;

	private int nextOrderId;
	
	@Autowired
	private JPushTool pushTool = (JPushTool) SpringContextUtil.getBean("pushTool");

	public IbBrokerWrapper(ConcurrentHashMap<String, String> accountValues, ConcurrentHashMap<String, Integer> portfolio, String accountUpdateTime,
			ConcurrentHashMap<Integer, Double> lastPrices, ConcurrentHashMap<String, Double> portfolioPnl)
	{
		this.accountValues = accountValues;
		this.portfolio = portfolio;
		this.accountUpdateTime = accountUpdateTime;
		this.lastPrices = lastPrices;
		this.portfolioPnl = portfolioPnl;
	}

	

	/**
	 * 返回订单状态--此时该订单一定存在/网络原因，未必
	 * 更新如下属性：status、filled、remaining、avgFillPrice、lastFillPrice
	 */
	@SuppressWarnings("unchecked")
  @Override
	public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId,
			double lastFillPrice, int clientId, String whyHeld)
	{
		System.out.println("订单状态----orderStatus: orderId=" + orderId + "; status=" + status + "; filled=" + filled + "; remaining=" + remaining
				+ "; avgFillPrice=" + avgFillPrice + "; permId=" + permId + "; parentId=" + parentId + "; lastFillPrice=" + lastFillPrice
				+ "; clientId=" + clientId + "; whyHeld=" + whyHeld);
		
		// 修改缓存中订单的状态
		List<BrokerOrder> lstOrder = new ArrayList<BrokerOrder>();
		Map<String, BrokerOrder> orderIdMap = new HashMap<String, BrokerOrder>();
		orderIdMap = (Map<String, BrokerOrder>) cacheManager.get("orderIdMap");
		BrokerOrder orderCache;
		
		if (!CollectionUtils.isEmpty(orderIdMap))
		{
			if (null != orderIdMap.get(orderId + "")) {
				orderCache = orderIdMap.get(orderId + "");
				// 判断是否更新订单状态，是否Jpush推送消息
					BrokerOrder objOrderOld = orderIdMap.get(orderId + "");
					if (!StringUtils.isEmpty(objOrderOld.getStatus()) && !objOrderOld.getStatus().equalsIgnoreCase(status)) {
						System.out.println(objOrderOld.getStatus() + "----订单状态已发生改变----" + status);
						List<String> registrationIds = new ArrayList<String>();

						String actionIndex = "";
						String message = "";
						
						if ("Filled".equalsIgnoreCase(status) || "Cancelled".equalsIgnoreCase(status))
						{
							List<JpushDeviceDto> lstJpush = jpushDeviceService.getJpushDeviceDtoListByOrderId(orderId + "");

							if (!CollectionUtils.isEmpty(lstJpush)) {
								for (int i = 0; i < lstJpush.size(); i++) {
									System.out.println(lstJpush.get(i).getRegistrationId());
									if (!StringUtils.isEmpty(lstJpush.get(i).getRegistrationId())) {
										registrationIds.add(lstJpush.get(i).getRegistrationId());
										actionIndex = lstJpush.get(i).getActionIndex();
									}
								}
								
								Map<String, String> extras = new HashMap<String, String>();
	
								Calendar cal = Calendar.getInstance();
								cal.setTime(new Date());
								cal.add(Calendar.MINUTE, 1);
								String pushtime = DateUtils.getDateString(cal.getTime(), "yyyy-MM-dd HH:mm:ss");
								// 处理不同消息
								if ("Filled".equalsIgnoreCase(status)){
									if (!StringUtils.isEmpty(actionIndex) && ("BOT".equalsIgnoreCase(actionIndex) || "BUY".equalsIgnoreCase(actionIndex))) {
										message = "您委托的 " + filled + "股" + objOrderOld.getSymbol() + "买单已成交，成本价" + avgFillPrice;
									}
									else {
										message = "您委托的 " + filled + "股" + objOrderOld.getSymbol() + "卖单已成交，卖出价" + avgFillPrice;
									}
								}
								else {
									// 撤销订单
									if (!StringUtils.isEmpty(actionIndex) && ("BOT".equalsIgnoreCase(actionIndex) || "BUY".equalsIgnoreCase(actionIndex))) {
										message = "您委托的 " + remaining + "股" + objOrderOld.getSymbol() + "买单已被撤销，查看详情";
									}
									else {
										message = "您委托的 " + remaining + "股" + objOrderOld.getSymbol() + "卖单已被撤销，查看详情";
									}
								}
								
								if ("Filled".equalsIgnoreCase(status)) {
									// 我的资产页
									extras.put("myAssetPage", "myAssetPage");
								}
								else {
									// 交易记录页面
									extras.put("tradeLogPage", "tradeLogPage");
								}
	
								System.out.println("推送消息===" + message);
								try {
									pushTool.pushMessage(pushtime, Platform.android_ios(), null, null, registrationIds, 1, message, "荷马金融", message,
											extras, true);
								}
								catch (Exception e) {
									System.out.println("jpush报错！！！");
									System.out.println(e.getMessage());
								}
								
							}else {
								System.out.println("kongkongkong");
							}
						}
						// 您委托的“xx”股“股票代码”“买单/卖单”已被撤销，查看详情
						
					}
					
				// 要更新资金账户下的交易记录状态
				lstOrder = (List<BrokerOrder>) cacheManager.get(orderIdMap.get(orderId + "").getAccount());
				if (!CollectionUtils.isEmpty(lstOrder)) {
					for (int i = 0; i < lstOrder.size(); i++) {
						if (orderId == lstOrder.get(i).getOrderId()) {
							BrokerOrder order = lstOrder.get(i);
							
							// 修改订单相关信息
							order.setStatus(status);
							order.setFilled(filled);
							order.setRemaining(remaining);
							order.setAvgFillPrice(avgFillPrice + "");
							order.setLastFillPrice(lastFillPrice + "");
							System.out.println(order.getTotalQuantity() + "已完成交易数量" + filled + ",剩余未成交" + remaining);
							if ("Cancelled".equalsIgnoreCase(status) && StringUtils.isEmpty(order.getFinishTime())) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Calendar calendar = Calendar.getInstance();
								sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
								order.setFinishTime(sdf.format(calendar.getTime()));
							}
							lstOrder.set(i, order);
							
							// 更新数据库记录
							BrokerOrderDto orderDto = new BrokerOrderDto();
							
							orderDto.setOrderId(order.getOrderId() + "");
							orderDto.setAccount(order.getAccount());
							orderDto.setActionIndex(order.getActionIndex());
							orderDto.setClientid(order.getClientId() + "");
							orderDto.setSymbol(order.getSymbol());
							orderDto.setPermid(order.getPermId());
							orderDto.setOrderType(order.getOrderType());
							orderDto.setTotalquantity(order.getTotalQuantity());
							// orderDto.setLimitprice(order.getLimitPrice());
							orderDto.setCommission(order.getCommission());
							orderDto.setTimeForce(order.getTimeForce());
							orderDto.setFinishTime(order.getFinishTime());
							orderDto.setSentTime(order.getSentTime());
							
							orderDto.setStatus(status);
							orderDto.setFilled(filled);
							orderDto.setRemaining(remaining);
							orderDto.setAvgFillPrice(avgFillPrice + "");
							orderDto.setLastFillPrice(lastFillPrice + "");
							
							brokerOrderService.doUpdate(orderDto);
							
							break;
						}
					}
					cacheManager.set(orderIdMap.get(orderId + "").getAccount(), 0, lstOrder);
				}
				orderCache.setStatus(status);

				orderIdMap.put(orderId + "", orderCache);
				cacheManager.set("orderIdMap", 0, orderIdMap);
			}
			else {
				System.out.println("orderIdMap中未找到该订单----" + orderId);
			}
		}else {
			System.out.println("缓存中获取orderIdMap为空");
		}
	}

	/**
	 * 获取订单详细信息，每次返回修改订单佣金
	 * 依据orderIdMap是否存在该订单判断是否入库
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void openOrder(int orderId, Contract contract, Order order, OrderState orderState)
	{
		BrokerOrder brokerOrder;
		List<BrokerOrder> lstOrder;
		// 缓存/数据库中是否存在该记录，若存在直接更新，不存在保存到库
		boolean isHave = false;

		System.out.println("openOrder方法入缓存--------" + contract.m_symbol + "======" + order.m_orderId + "---" + order.m_action + "---" + order.m_lmtPrice + "---" + order.m_clientId + "---"
				+ order.m_totalQuantity + "---" + order.m_account + "---" + order.m_permId + "---" + orderState.m_status + orderState.m_commission + "订单佣金--------------" + order.m_parentId + "=====");

		if (StringUtils.isEmpty(order.m_account) || StringUtils.isEmpty(orderState.m_status) || 0 == order.m_totalQuantity)
		{
			return;
		}
		
		Map<String, BrokerOrder> orderIdMap = new HashMap<String, BrokerOrder>();
		orderIdMap = (Map<String, BrokerOrder>) cacheManager.get("orderIdMap");
		
		// 判断是否更新订单状态，是否Jpush推送消息

		
		
		
		
		// 查询缓存数据，判断是保存还是更新，更新只修改订单佣金
		brokerOrder = null;
		
		lstOrder = (List<BrokerOrder>) cacheManager.get(order.m_account);
		
		if (CollectionUtils.isEmpty(orderIdMap)) {
			System.out.println("orderIdMap为空#");
			orderIdMap = new HashMap<String, BrokerOrder>();
		}
		else {
			if (null != orderIdMap.get(order.m_orderId + "") && null == orderIdMap.get(order.m_orderId + "").getActionIndex()) {
				
				System.out.println("第一次补充信息=");
			}
			brokerOrder = orderIdMap.get(order.m_orderId + "");
		}
		// openOrder方法入缓存
		// 将交易记录存入缓存
		if (null == brokerOrder) {
			brokerOrder = new BrokerOrder();
		}
		else {
			isHave = true;
		}
		brokerOrder.setOrderId(order.m_orderId);
		brokerOrder.setPermId(order.m_permId);
		brokerOrder.setClientId(order.m_clientId);
		brokerOrder.setAccount(order.m_account);
		// brokerOrder.setfinishedTime(execution.m_time);
		brokerOrder.setActionIndex(order.m_action);
		brokerOrder.setTotalQuantity(order.m_totalQuantity);
		// contract.description();
		brokerOrder.setLimitPrice(order.m_lmtPrice);
		// brokerOrder.setStatus(orderState.m_status);
		brokerOrder.setSymbol(contract.m_symbol);
		brokerOrder.setCommission(orderState.m_commission + "");
		brokerOrder.setOrderType(order.m_orderType);
		brokerOrder.setTimeForce(order.m_tif);

		if (CollectionUtils.isEmpty(lstOrder))
		{
			lstOrder = new ArrayList<BrokerOrder>();
			// 设置时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
			brokerOrder.setSentTime(sdf.format(calendar.getTime()));
			lstOrder.add(brokerOrder);
		} else
		{
			boolean isUse = true;

			for (int i = 0; i < lstOrder.size(); i++)
			{
				if (lstOrder.get(i).getOrderId().equals(brokerOrder.getOrderId()))
				{
					isUse = false;
					brokerOrder.setSentTime(lstOrder.get(i).getSentTime());
					lstOrder.set(i, brokerOrder);
				}
			}
			if (isUse)
			{
				// 设置时间格式
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar calendar = Calendar.getInstance();
				sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
				brokerOrder.setSentTime(sdf.format(calendar.getTime()));
				lstOrder.add(brokerOrder);
			}
		}
		
		System.out.println(brokerOrder.getStatus() + "zhaungtai22222");
		orderIdMap.put(brokerOrder.getOrderId() + "", brokerOrder);
		
		// 缓存/数据库中已有该订单
		if (isHave) {
			
		}
		// 缓存/数据库没有该订单
		else {
			int maxOrderId = brokerOrderService.getMaxId();
			if (maxOrderId < order.m_orderId) {
				BrokerOrderDto orderDto = new BrokerOrderDto();
				
				orderDto.setOrderId(order.m_orderId + "");
				orderDto.setAccount(order.m_account);
				orderDto.setActionIndex(order.m_action);
				orderDto.setClientid(order.m_clientId + "");
				orderDto.setSymbol(contract.m_symbol);
				orderDto.setPermid(order.m_permId);
				orderDto.setOrderType(order.m_orderType);
				// orderDto.setStatus(orderState.m_status);
				orderDto.setTotalquantity(order.m_totalQuantity);
				// orderDto.setLimitprice(order.m_lmtPrice);
				orderDto.setCommission(orderState.m_commission + "");
				orderDto.setTimeForce(order.m_tif);
				orderDto.setSentTime(brokerOrder.getSentTime());
				
				brokerOrderService.doUpdate(orderDto);
			}
		}
		
		cacheManager.set("orderIdMap", 0, orderIdMap);
		cacheManager.set(order.m_account, 0, lstOrder);
	}

	@Override
	public void openOrderEnd()
	{
		System.out.println("openOrderEnd is called");
	}

	@SuppressWarnings("unchecked")
  @Override
	public void updateAccountValue(String key, String value, String currency, String accountName)
	{
		Map<String, String> accountCurrencyMap = new HashMap<String, String>();
		@SuppressWarnings("unused")
    Map<String, String> curMap = new HashMap<String, String>();
		Map<String, String> accountValueMap = new HashMap<String, String>();

		// 将资金账户存入
		if (null != cacheManager.get("accountCurrencyMap"))
		{
			accountCurrencyMap = (Map<String, String>) cacheManager.get("accountCurrencyMap");
		}

		accountCurrencyMap.put(accountName + "-" + currency, accountName + "-" + currency);
		cacheManager.set("accountCurrencyMap", 0, accountCurrencyMap);

		// 很可能只需要这一小段代码，测试之后可删除其他
		if ("BASE".equalsIgnoreCase(currency) && ("CashBalance".equalsIgnoreCase(key) || "NetLiquidationByCurrency".equalsIgnoreCase(key) 
				|| "UnrealizedPnL".equalsIgnoreCase(key) || "RealizedPnL".equalsIgnoreCase(key)))
		{
			System.out.println("4updateAccountValue: key=" + key + ";value=" + value + "；currency=" + currency + ";accountName=" + accountName);

			// 保存到数据库/更新缓存
			MarketData objCacheMarket = (MarketData) cacheManager.get(accountName + "MarketData");
			if (null == objCacheMarket) {
				objCacheMarket = new MarketData();
			}
			MarketData markerData = new MarketData();
			markerData.setAccount(accountName);
			if ("CashBalance".equalsIgnoreCase(key)) {
				markerData.setCashBalance(value);
				objCacheMarket.setCashBalance(value);
			}else if ("NetLiquidationByCurrency".equalsIgnoreCase(key)) {
				markerData.setNetLiquidationByCurrency(value);
				objCacheMarket.setNetLiquidationByCurrency(value);
			}
			else if ("UnrealizedPnL".equalsIgnoreCase(key)) {
				markerData.setUnrealizedPnl(value);
				objCacheMarket.setUnrealizedPnl(value);
			}
			else if ("RealizedPnL".equalsIgnoreCase(key)) {
				markerData.setRealizedPnl(value);
				objCacheMarket.setRealizedPnl(value);
			}
			
			System.out.println(markerData.getAccount() + "aaaa" + markerData.getNetLiquidationByCurrency() + "bbbb" + markerData.getUnrealizedPnl() + "cccc" + markerData.getRealizedPnl());
			accountCapitalService.doCreateOrUpdate(markerData);
			cacheManager.set(accountName + "MarketData", 0, objCacheMarket);
		}
		
		// 目前把美元可流动资金单独存到缓存，用于下单做(数量*股价<=可流动资金)计算
		if ("BASE".equalsIgnoreCase(currency) && "CashBalance".equalsIgnoreCase(key))
		{
			cacheManager.set(accountName + "-CashBalance", 0, value);
		}

		// 将资产类型存入---总资产/美金资产/人民币资产等等
		if (null != cacheManager.get("accountValueMap"))
		{
			accountValueMap = (Map<String, String>) cacheManager.get("accountValueMap");
		}
		// System.out.println(accountName + "-" + currency + "-" + key + "===================================");
		accountValueMap.put(accountName + "-" + currency + "-" + key, value);

		cacheManager.set("accountValueMap", 0, accountValueMap);
	}

	/**
	 * 返回交易所的成交详情。1个订单可能在N个交易所分成M次成交，N>=1，M>=1
	 * tradeLog请求时，每条记录返回一次
	 */
	@SuppressWarnings("unchecked")
  @Override
	public void execDetails(int reqId, Contract contract, Execution execution)
	{
		// 问题：当IB订单已成交，推送时断网，暂时没找到查询已完成交易的方法；解决方法：统计每个订单的分段交易详情
		BrokerOrder order;
		@SuppressWarnings("unused")
    List<BrokerOrder> lstOrder;
		
		System.out.println("分段成交记录=====" + execution.m_orderId + "--" + execution.m_acctNumber + execution.m_avgPrice + "-----" + execution.m_price + "价格比对");

		// 仅更新缓存中的FinishTime
		Map<String, BrokerOrder> orderIdMap = new HashMap<String, BrokerOrder>();
		orderIdMap = (Map<String, BrokerOrder>) cacheManager.get("orderIdMap");
		lstOrder = (List<BrokerOrder>) cacheManager.get(execution.m_acctNumber);
		
		// 缓存中还未存在该订单的成交记录，先创建订单放入缓存，具体信息让openOrder方法补充
		order = new BrokerOrder();
		order.setOrderId(execution.m_orderId);
		order.setAccount(execution.m_acctNumber);
		if (!StringUtils.isEmpty(execution.m_time)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

			try {
				sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
				order.setFinishTime(sdf.format(sdf2.parse(execution.m_time)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("unused")
    boolean isHave = false;
		if (CollectionUtils.isEmpty(orderIdMap)) {
			System.out.println("orderIdMap为空33333333333");
			orderIdMap = new HashMap<String, BrokerOrder>();
			System.out.println(order.getStatus() + "zhaungtai3333");
			orderIdMap.put(order.getOrderId() + "", order);
		}
		else {
			if (null == orderIdMap.get(order.getOrderId() + "")) {
				System.out.println(order.getStatus() + "zhaungtai4444");

				orderIdMap.put(order.getOrderId() + "", order);
			}
			else {
				isHave = true;
				BrokerOrder bOrder = orderIdMap.get(order.getOrderId() + "");
				if (!StringUtils.isEmpty(execution.m_time)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

					try {
						sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
						bOrder.setFinishTime(sdf.format(sdf2.parse(execution.m_time)));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				System.out.println(bOrder.getStatus() + "zhaungtai555");
				orderIdMap.put(order.getOrderId() + "", bOrder);
			}
		}
		
//		if (!isHave) {
//			
//			int maxOrderId = brokerOrderService.getMaxId();
//			if (maxOrderId < execution.m_orderId) {
//			BrokerOrderDto orderDto = new BrokerOrderDto();
//			
//			orderDto.setOrderId(execution.m_orderId + "");
//			orderDto.setAccount(execution.m_acctNumber);
////			orderDto.setActionIndex(order.);
//			orderDto.setClientid(execution.m_clientId + "");
//			orderDto.setSymbol(contract.m_symbol);
//			orderDto.setPermid(execution.m_permId);
//			orderDto.setOrderType("CHANGE");
//			orderDto.setStatus("Submitted");
////			orderDto.setTotalquantity(order.m_totalQuantity);
////			orderDto.setLimitprice(order.m_lmtPrice);
////			orderDto.setCommission(orderState.m_commission + "");
//			
//			brokerOrderService.doUpdate(orderDto);
//			}
//		}
		
		cacheManager.set("orderIdMap", 0, orderIdMap);
		// lstorder 不再判断，跟orderIdMap走算了
//		if (CollectionUtils.isEmpty(lstOrder))
//		{
//			System.out.println("lstOrder为空33333333333");
//			lstOrder = new ArrayList<BrokerOrder>();
//			lstOrder.add(order);
//		}
		
		
		
//		order.setActionIndex(execution.m_side);
//		order.setTotalQuantity(execution.m_cumQty);
//		// contract.description();
//		order.setLimitPrice(execution.m_price);
//		// order.setStatus("Filled");
//		order.setSymbol(contract.m_symbol);
//		order.setClientId(execution.m_clientId);
//		order.setPermId(execution.m_permId);
//		
//		orderIdMap.put(brokerOrder.getOrderId() + "", brokerOrder);
//		cacheManager.set("orderIdMap", 0, orderIdMap);
//		
//		if (CollectionUtils.isEmpty(lstOrder))
//		{
//			System.out.println("lstOrder为空33333333333333333");
//			lstOrder = new ArrayList<BrokerOrder>();
//			// 设置时间格式
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Calendar calendar = Calendar.getInstance();
//			sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//			// 20160322  16:53:37
//			brokerOrder.setSentTime(sdf.format(calendar.getTime()));
//			lstOrder.add(brokerOrder);
//		} else
		
		// 将成交记录存入缓存

//		
//		// order.setFinishTime(execution.m_time);

//		

//
//		if (StringUtils.isEmpty(execution.m_acctNumber))
//		{
//			return;
//		}

//		lstOrder = (List<BrokerOrder>) cacheManager.get(execution.m_acctNumber);
//		if (CollectionUtils.isEmpty(lstOrder))
//		{
//			lstOrder = new ArrayList<BrokerOrder>();
//			lstOrder.add(order);
//		} else
//		{
//			boolean isUse = true;
//
//			for (int i = 0; i < lstOrder.size(); i++)
//			{
//				if (lstOrder.get(i).getOrderId().equals(order.getOrderId()))
//				{
//					isUse = false;
//					lstOrder.set(i, order);
//				}
//			}
//			if (isUse)
//			{
//				lstOrder.add(order);
//			}
//		}
//
//		cacheManager.set(execution.m_acctNumber, 0, lstOrder);
	}

	@Override
	public void execDetailsEnd(int reqId)
	{
		System.out.println("execDetailsEnd: reqId=" + reqId);
	}

	@Override
	public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size)
	{

		System.out.println("updateMktDepth:tickerId" + tickerId + ";position=" + ";operation=" + operation + ";side=" + side + ";price=" + price
				+ ";size=" + size);
	}

	@Override
	public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size)
	{
		System.out.println("updateMktDepthL2:tickerId" + tickerId + ";position=" + ";operation=" + operation + ";side=" + side + ";marketMaker="
				+ marketMaker + ";price=" + price + ";size=" + size);
	}

	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange)
	{

		System.out.println("updateNewsBulletin: msgId=" + msgId + ";msgType=" + msgType + ";message=" + message + "origExchange=" + origExchange);
	}

	@Override
	public void managedAccounts(String accountsList)
	{

		System.out.println("accountsList:" + accountsList);
	}

	@Override
	public void receiveFA(int faDataType, String xml)
	{

		System.out.println("receiveFA: faDataType=" + faDataType + ";xml=" + xml);
	}

	@Override
	public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP,
			boolean hasGaps)
	{

		System.out.println("historicalData: reqId=" + reqId + ";date=" + date + ";open=" + open + ";high=" + high + ";low=" + low + ";close=" + close
				+ ";volume=" + volume + ";count=" + count + ";wap=" + WAP + ";hasGaps=" + hasGaps);
	}

	@Override
	public void scannerParameters(String xml)
	{
		System.out.println("scannerParameters: xml=" + xml);
	}

	@Override
	public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr)
	{

		System.out.println("scannerData: reqId=" + reqId);
	}

	@Override
	public void scannerDataEnd(int reqId)
	{
		System.out.println("scannerDataEnd: reqId=" + reqId);
	}

	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count)
	{

		System.out.println("realtimeBar: reqId=" + reqId + ";time=" + time + ";open=" + open + ";high=" + high + ";low=" + low + ";close=" + close
				+ ";volume=" + volume + ";wap=" + wap + ";count=" + count);
	}

	@Override
	public void currentTime(long time)
	{

		System.out.println("currentTime:" + time);
	}

	@Override
	public void fundamentalData(int reqId, String data)
	{

		System.out.println("fundamentalData: reqId=" + reqId + ";data=" + data);
	}

	@Override
	public void deltaNeutralValidation(int reqId, UnderComp underComp)
	{
		System.out.println("deltaNeutralValidation: reqId=" + reqId);
	}

	@Override
	public void tickSnapshotEnd(int reqId)
	{
		System.out.println("tickSnapshotEnd: reqId=" + reqId);
	}

	@Override
	public void marketDataType(int reqId, int marketDataType)
	{
		System.out.println("marketDataType: reqId=" + reqId + ";marketDataType=" + marketDataType);
	}

	@Override
	public void commissionReport(CommissionReport commissionReport)
	{
		System.out.println("commissionReport...");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void position(String account, Contract contract, int pos, double avgCost)
	{
		PositionsInfo position;
		List<PositionsInfo> lstPositions;
		
//		if (0 == pos) {
//			return;
//		}
		if ("USD".equalsIgnoreCase(contract.m_symbol) || "USD".equalsIgnoreCase(contract.m_localSymbol)) {
			System.out.println("USD单独过滤掉，不再处理！！");
			return;
		}

		// 将持仓情况存入缓存
		position = new PositionsInfo();
		position.setAccount(account);
		position.setConId(contract.m_conId);
		position.setSymbol(contract.m_symbol);
		position.setSecType(contract.m_secType);
		position.setExpiry(contract.m_expiry);
		position.setStrike(contract.m_strike);
		position.setRight(contract.m_right);
		position.setMultiplier(contract.m_multiplier);
		position.setPrimaryExch(contract.m_primaryExch);
		position.setExchange(contract.m_exchange);
		position.setCurrency(contract.m_currency);
		position.setLocalSymbol(contract.m_localSymbol);
		position.setTradingClass(contract.m_tradingClass);
		position.setPosition(pos);
		position.setAvgCost(avgCost);

		if (StringUtils.isEmpty(position.getAccount()) || StringUtils.isEmpty(position.getSymbol()))
		{
			return;
		}

		lstPositions = (List<PositionsInfo>) cacheManager.get(position.getAccount() + "-newPositions");
		if (CollectionUtils.isEmpty(lstPositions))
		{
			lstPositions = new ArrayList<PositionsInfo>();
			if (pos > 0) {
				lstPositions.add(position);
			}
		} else
		{
			boolean isUse = true;

			System.out.println("账户==" + account + "----" + position.getSymbol() + "持仓数量==========" + position.getPosition());
			for (int i = 0; i < lstPositions.size(); i++)
			{
				if (lstPositions.get(i).getSymbol().equalsIgnoreCase(position.getSymbol()))
				{
					isUse = false;
					if (0 == position.getPosition()) {
						System.out.println("持仓数量为零===" + position.getSymbol() + "----" + position.getPosition());
						lstPositions.remove(i);
					}else {
						lstPositions.set(i, position);
					}
				}
			}
			if (isUse && position.getPosition() > 0 && pos > 0)
			{
				System.out.println("添加持仓记录" + position.getSymbol() + "----" + position.getPosition());
				lstPositions.add(position);
			}
		}

		cacheManager.set(position.getAccount() + "-newPositions", 0, lstPositions);
		cacheManager.set(position.getAccount() + "-PositionsTime", 0, new Date());
	}

	@SuppressWarnings("unchecked")
  @Override
	public void positionEnd(String account)
	{
		System.out.println("positionEnd缓存更新持仓时间==" + new Date());

		MarketData objMarket = new MarketData();
		List<MarketData> lstMarket = new ArrayList<MarketData>();
		
		lstMarket = accountCapitalService.getAccountCapitalList(objMarket);
		if (!CollectionUtils.isEmpty(lstMarket)) {
			
			for (int i = 0; i < lstMarket.size(); i++)
			{
				account = lstMarket.get(i).getAccount();
				List<PositionsInfo> lstPositionNew = new ArrayList<PositionsInfo>();

		    	if (null != cacheManager.get(account + "-newPositions")) {
		    		lstPositionNew = (List<PositionsInfo>) cacheManager.get(account + "-newPositions");
		    		System.out.println(account + "--positionEnd持股数量==" + lstPositionNew.size() );
				}else {
					System.out.println(account + "positionEnd最新持仓数据获取为空" + new Date());
				}
		    	cacheManager.set(account + "-oldPositions2", 0, lstPositionNew);
			}
		}
		
		
	}

	@Override
	public void accountSummary(int reqId, String account, String tag, String value, String currency)
	{
		System.out.println("accountSummary: reqId=" + reqId + ";account=" + account + ";tag=" + tag + ";value=" + value + ";currency=" + currency + "---------" + new Date());
		
		if (tag.equalsIgnoreCase("NetLiquidation") || "TotalCashValue".equalsIgnoreCase(tag)) {
			MarketData markerData = new MarketData();
			MarketData objCacheMarket = (MarketData) cacheManager.get(account + "MarketData");
			if (null == objCacheMarket) {
				objCacheMarket = new MarketData();
			}
			markerData.setAccount(account);
			if ("TotalCashValue".equalsIgnoreCase(tag)) {
				markerData.setCashBalance(value);
				objCacheMarket.setCashBalance(value);
			}else if ("NetLiquidation".equalsIgnoreCase(tag)) {
				markerData.setNetLiquidationByCurrency(value);
				objCacheMarket.setNetLiquidationByCurrency(value);
			}
			
			System.out.println("获取到账户资产数据" + new Date() + "==" + account + "==" + markerData.getNetLiquidationByCurrency() + "===========" + markerData.getCashBalance() );
//			if ("U9103505".equalsIgnoreCase(account) || "U9072788".equalsIgnoreCase(account)) {
				System.out.println("更新账户资产数据" + new Date() + "====" + markerData.getNetLiquidationByCurrency() + "===========" + markerData.getCashBalance() );
				accountCapitalService.doCreateOrUpdate(markerData);
				cacheManager.set(account + "MarketData", 0, objCacheMarket);
//			}
			
			
		}
		
	
	}

	@Override
	public void accountSummaryEnd(int reqId)
	{
		System.out.println("accountSummaryEnd: reqId=" + reqId);
	}

	@Override
	public void verifyMessageAPI(String apiData)
	{
		System.out.println("verifyMessageAPI: apiData=" + apiData);
	}

	@Override
	public void verifyCompleted(boolean isSuccessful, String errorText)
	{
		System.out.println("verifyCompleted: isSuccessful=" + isSuccessful + ";errorText=" + errorText);
	}

	@Override
	public void displayGroupList(int reqId, String groups)
	{
		System.out.println("displayGroupList: reqId=" + reqId + ";groups=" + groups);
	}

	@Override
	public void displayGroupUpdated(int reqId, String contractInfo)
	{
		System.out.println("displayGroupUpdated: reqId=" + reqId + ";contractInfo=" + contractInfo);
	}

	/**
	 * 获取持仓记录。
	 * 
	 * @param account
	 * @return 2016年3月4日
	 * @author changhai.wang
	 */
	@SuppressWarnings("unchecked")
	public List<PositionsInfo> getPositions(String account)
	{
		List<PositionsInfo> lstPositions;

		lstPositions = (List<PositionsInfo>) cacheManager.get(account + "-newPositions");
		
		if (!CollectionUtils.isEmpty(lstPositions)) {
			for (int i = 0; i < lstPositions.size(); i++) {
				System.out.println("持仓延时查询结果" + (i + 1) + "=====" + lstPositions.get(i).getSymbol());
			}
		}
		
		// 保存到库
		
		return lstPositions;
	}

	/**
	 * 获取成交交易记录。
	 * 
	 * @param account
	 * @return 2016年3月4日
	 * @author changhai.wang
	 */
	@SuppressWarnings("unchecked")
	public List<BrokerOrder> getExecutionOrder(String account)
	{
		List<BrokerOrder> lstOrder;

		lstOrder = (List<BrokerOrder>) cacheManager.get(account);
		if (CollectionUtils.isEmpty(lstOrder))
		{
			System.out.println(account + "为空");
		} else
		{
			System.out.println(account + "个数" + lstOrder.size());
		}
		return lstOrder;
	}

	@SuppressWarnings("unchecked")
  public List<MarketData> getMarketValue(String account)
	{
		List<MarketData> lstMarket = new ArrayList<MarketData>();
		// 遍历资金账户-资产类型map
		Map<String, String> accountCurrencyMap = new HashMap<String, String>();
		Map<String, String> accountValueMap = new HashMap<String, String>();

		accountCurrencyMap = (Map<String, String>) cacheManager.get("accountCurrencyMap");
		accountValueMap = (Map<String, String>) cacheManager.get("accountValueMap");
		if (CollectionUtils.isEmpty(accountCurrencyMap)) {
			
		}
		else {
			for (Map.Entry<String, String> entry : accountCurrencyMap.entrySet())
			{
				System.out.println("key= " + entry.getKey());
				if (entry.getKey().indexOf("null") < 0)
				{
					// 构建实体，以便保存数据
					MarketData objData = new MarketData();
					objData.setAccount(entry.getKey().split("-")[0]);
					objData.setCurrency(entry.getKey().split("-")[1]);
					objData.setNetLiquidationByCurrency(accountValueMap.get(entry.getKey() + "-NetLiquidationByCurrency"));
					objData.setCashBalance(accountValueMap.get(entry.getKey() + "-CashBalance"));
					objData.setTotalCashBalance(accountValueMap.get(entry.getKey() + "-TotalCashBalance"));
					objData.setAccruedCash(accountValueMap.get(entry.getKey() + "-AccruedCash"));
					objData.setStockMarketValue(accountValueMap.get(entry.getKey() + "-StockMarketValue"));
					objData.setOptionMarketValue(accountValueMap.get(entry.getKey() + "-OptionMarketValue"));
					
					objData.setFutureOptionValue(accountValueMap.get(entry.getKey() + "-FutureOptionValue"));
					objData.setFuturesPNL(accountValueMap.get(entry.getKey() + "-FuturesPNL"));
					objData.setUnrealizedPnl(accountValueMap.get(entry.getKey() + "-UnrealizedPnL"));
					objData.setRealizedPnl(accountValueMap.get(entry.getKey() + "-RealizedPnL"));
					objData.setExchangeRate(accountValueMap.get(entry.getKey() + "-ExchangeRate"));
					objData.setFundValue(accountValueMap.get(entry.getKey() + "-FundValue"));
					
					lstMarket.add(objData);
				}

			}
		}
		
		return lstMarket;
	}

	public String getCashBalance(String account)
	{
		String cashBalance;

		cashBalance = (String) cacheManager.get(account + "-CashBalance");
		if (null == cashBalance) {
			cashBalance = "0";
			// 从数据库取值
			MarketData objMarket = new MarketData();
			List<MarketData> lstMarket = new ArrayList<MarketData>();
			objMarket.setAccount(account);
			lstMarket = accountCapitalService.getAccountCapitalList(objMarket);
			if (!CollectionUtils.isEmpty(lstMarket) && lstMarket.size() > 0) {
				cashBalance = lstMarket.get(0).getCashBalance();
			}
			if (StringUtils.isEmpty(cashBalance)) {
				cashBalance = "0";
			}
			else {
				cacheManager.set(account + "-CashBalance", 0, cashBalance);
			}
		}
		return cashBalance;
	}
	
	public HmStockInfo getMktData(int tickerId, String symbol)
	{
		// change = (last - close)
		HmStockInfo objHmStock;
		String last = (String) cacheManager.get("tickerId_last" + tickerId);
		String close = (String) cacheManager.get("tickerId_close" + tickerId);
		System.out.println("即时股价Ib" + symbol + "--" + tickerId + "---" + last + "---" + close);
		if (StringUtils.isEmpty(last)) {
			last = "0.0";
			return null;
		}
		if (StringUtils.isEmpty(close)) {
			close = "0.0";
			return null;
		}
		System.out.println("即时股价Ib" + symbol + "--" + tickerId + "---" + last + "---" + close);
		
		BigDecimal bigLast = new BigDecimal(last);
		BigDecimal bigClose = new BigDecimal(close);
		MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
		
		BigDecimal change = bigLast.subtract(bigClose).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal change_per;
		BigDecimal zero = new BigDecimal(0).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		if (change.equals(zero)) {
			change_per = new BigDecimal(0);
		}
		else {
			change_per = change.divide(bigClose, mc).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		}
		
		objHmStock = new HmStockInfo();
		objHmStock.setSymbol(symbol);
		objHmStock.setPrice(last);
		objHmStock.setChange(change + "");
		objHmStock.setChange_per(change_per + "");
		System.out.println("即时股价Ib" + objHmStock.getChange() + "-----" + objHmStock.getChange_per());
		return objHmStock;
	}
	
	public int getNextOrderId()
	{
		return nextOrderId;
	}

	public void setNextOrderId(int nextOrderId)
	{
		this.nextOrderId = nextOrderId;
	}

	public ConcurrentHashMap<String, Double> getPortfolioPnl()
	{
		return portfolioPnl;
	}

	public void setTickType(int tickType)
	{
		this.tickType = tickType;
	}

	@Override
	public void error(Exception e)
	{
		System.out.println("error:" + e);

	}

	@Override
	public void error(String str)
	{
		System.out.println("error:" + str);
	}

	@Override
	public void error(int id, int errorCode, String errorMsg)
	{
		System.out.println("error: id=" + id + "; errorCode=" + errorCode + "; errorMsg=" + errorMsg);
	
		// 连接中断
		if (502 == errorCode) {
			// 将连接中断标识存入缓存
			String connectFailNum = "0";
			int num = 0;
			if (null != cacheManager.get("CONNECT_FAIL")) {
				connectFailNum = (String) cacheManager.get("CONNECT_FAIL");
				num = Integer.parseInt(connectFailNum) + 1;
				cacheManager.set("CONNECT_FAIL", 0, num + "");
			}
			else {
				cacheManager.set("CONNECT_FAIL", 0, "1");
			}
			System.out.println("连接中断次数：" + connectFailNum);
		}
	}

	@Override
	public void connectionClosed()
	{
		System.out.println("connection is closed");
	}

	@Override
	public void tickPrice(int tickerId, int tickType, double price, int canAutoExecute)
	{
		// 将价格保存到缓存
		// tickType:9 close
        // tickType:4 last
		// change = (last - close)
		if (4 == tickType) {
			cacheManager.set("tickerId_last" + tickerId, 0, price + "");
		}
		else if (9 == tickType) {
			cacheManager.set("tickerId_close" + tickerId, 0, price + "");
		}
		
        System.out.println("tickPrice:" + tickerId + "-mm--" + tickType + "-mm--" + price + "-mm--" + canAutoExecute);

		System.out.println("tickPrice:" + tickerId + tickType + price + canAutoExecute);
	}

	@Override
	public void tickSize(int tickerId, int field, int size)
	{
		System.out.println("tickSize:" + tickerId + "-" + field + "-" + size);
	}

	@Override
	public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma,
			double vega, double theta, double undPrice)
	{

		System.out.println("tickOptionComputation:tickerId=" + tickerId + ";field=" + field + ";impliedVol=" + impliedVol + "delta;=" + delta
				+ ";optPrice=" + optPrice + ";pvDividend=" + pvDividend + ";gamma=" + gamma + ";vega=" + vega + ";theta=" + theta + ";undPrice="
				+ undPrice);
	}

	@Override
	public void tickGeneric(int tickerId, int tickType, double value)
	{
		System.out.println("tickGeneric: tickerId=" + tickerId + ";tickType=" + tickType + ";value=" + value);
	}

	@Override
	public void tickString(int tickerId, int tickType, String value)
	{
		System.out.println("tickString: tickerId=" + tickerId + ";tickType=" + tickType + ";value=" + value);
	}

	@Override
	public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays,
			String futureExpiry, double dividendImpact, double dividendsToExpiry)
	{
		System.out.println("tickEFP:tickerId=" + tickerId + ";tickType=" + tickType + ";basisPoints=" + basisPoints + ";formattedBasisPoints="
				+ formattedBasisPoints + ";impliedFuture=" + impliedFuture + ";holdDays=" + holdDays + ";futureExpiry=" + futureExpiry
				+ ";dividendImpact=" + dividendImpact + ";dividendsToExpiry=" + dividendsToExpiry);
	}
	
	
	@Override
	public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL,
			double realizedPNL, String accountName)
	{
		System.out.println("updatePortfolio:");
	}

	@Override
	public void updateAccountTime(String timeStamp)
	{

		System.out.println("timeStamp" + timeStamp);
	}

	@Override
	public void accountDownloadEnd(String accountName)
	{

		System.out.println("accountName：" + accountName);
	}

	@Override
	public void nextValidId(int orderId)
	{
		System.out.println("orderId4444444444：" + orderId);
	}

	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails)
	{
		System.out.println("contractDetails: reqId=" + reqId);
	}

	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails)
	{
		System.out.println("bondContractDetails: reqId=" + reqId);
	}

	@Override
	public void contractDetailsEnd(int reqId)
	{
		System.out.println("contractDetailsEnd: reqId=" + reqId);
	}


}
