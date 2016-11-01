package com.homaer.fundsrv.service.impl;

import java.net.SocketException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.tools.math.DateUtils;
import com.homaer.common.tools.math.Util;
import com.homaer.fundsrv.module.ib.AccountSummary;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.module.ib.OrderStatus;
import com.homaer.fundsrv.module.ib.PortfolioInfo;
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.homaer.fundsrv.cache.ServiceCacheUtil;
import com.homaer.fundsrv.dataobject.BrokerOrderDto;
import com.homaer.fundsrv.ib.IbBroker;
import com.homaer.fundsrv.service.BrokerOrderService;
import com.homaer.fundsrv.service.IbService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class IbServiceImpl implements IbService
{
	// private static int oId = 607875150;
//	private static int oId = Integer.parseInt(InitContants.TWS_ORID + (new Date().getTime() + "").substring(6));

	@Autowired
	private IbBroker ibBroker;
	
	@Autowired
	private BrokerOrderService brokerOrderService;

	@Resource(name = "serviceCacheUtil")
	public ServiceCacheUtil serviceCacheUtil;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public int OrderPlace(String userId, String symbol, String secType, String expiry, String exchange, String currency, int action, int totalQuantity,
			String orderType, double lmtPrice, String account, String timeForce) throws SocketException
	{

		// 处理价格小数2位
		DecimalFormat df = new DecimalFormat("0.00");
		if (StringUtils.isEmpty(lmtPrice))
		{
			lmtPrice = 0.00;
		} else
		{
			lmtPrice = new Double(df.format(lmtPrice));
		}

		int orderId;
		// 订单id，从数据库取值MAX+1
		orderId = brokerOrderService.getMaxId() + 1;

		BrokerOrder order = new BrokerOrder();
		order.setUserId(userId);
		order.setOrderId(orderId);
		order.setSymbol(symbol);
		order.setExchange(exchange);
		order.setCurrency(currency);
		order.setTotalQuantity(totalQuantity);
		order.setLimitPrice(lmtPrice);
		order.setAccount(account);
		order.setTimeForce(timeForce);
		order.setAction(action);
		order.setOrderType(orderType);

		try
		{
			if (BrokerOrder.ACTIONINDEX_BOT == order.getAction())
			{
				ibBroker.buyOrder(order);
			} else if (BrokerOrder.ACTIONINDEX_SLD == order.getAction())
			{
				ibBroker.sellOrder(order);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return orderId;
	}

	@Override
	public OrderStatus getOrderStatus(int orderId, String account)
	{

		// 当状态改变时，会出发wrapper中的orderStatus方法，orderStatus接收到最新状态入库
		// 从库中加载返回
		return null;
	}

	@Override
	public void cancelOrder(int orderId, String account) throws SocketException
	{
		// 取消订单
		try
		{
			try
			{
				ibBroker.cancelOrder(orderId, account);
			} catch (SocketException e)
			{
				e.printStackTrace();
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public MarketData getAccountValues(String account) throws SocketException, InterruptedException
	{
		// 获取账户值集合信息
		return ibBroker.getAccountValues(account);
	}
	
	@Override
	public void reqAccountSummary(String account) throws SocketException, InterruptedException
	{
		ibBroker.reqAccountSummary(account);
	}
	
	@Override
	public String getCashBalance(String account) throws SocketException, InterruptedException
	{
		// 获取账户可流动资金
		return ibBroker.getCashBalance(account);
	}

	@Override
	public List<PortfolioInfo> getAccountPortfolios(String account)
	{
		// 获取账户组合集合信息
		return null;
	}

	@Override
	public List<AccountSummary> getAccountSummary(String account)
	{

		// 获取账户摘要集合信息
		return null;
	}

	@Override
	public int changeOrder(String userId, int orderId, int totalQuantity, double lmtPrice) throws SocketException
	{
		// 先根据订单id加载出订单信息
		BrokerOrder order = new BrokerOrder();
		order.setOrderId(orderId);
		order.setUserId(userId);
		order.setTotalQuantity(totalQuantity);
		order.setLimitPrice(lmtPrice);
		try
		{
			ibBroker.buyOrder(order);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return orderId;
	}

	/**
	 * 生成唯一的orderId
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String genOrderId()
	{
		StringBuilder str = new StringBuilder();
		String dateStr = DateUtils.getDateString(new Date(), "yyyyMMddHHmmssSSS");
		str.append(dateStr.substring(2, 14)).append(dateStr.substring(0, 2)).append(dateStr.substring(14)).append(Util.getRandomNumber(999, 3));
		return str.toString();
	}

	public List<BrokerOrder> reqOrder(String account) throws SocketException, InterruptedException
	{
		List<BrokerOrder> lstOrder = new ArrayList<BrokerOrder>();
		
		List<BrokerOrderDto> lstOrderDto = new ArrayList<BrokerOrderDto>();
		
		BrokerOrderDto objDto = new BrokerOrderDto();
		objDto.setAccount(account);
		lstOrderDto = brokerOrderService.getBrokerOrderDtoList(objDto);
		if (!CollectionUtils.isEmpty(lstOrderDto)) {
			for (int i = 0; i < lstOrderDto.size(); i++) {
				BrokerOrder order = new BrokerOrder();
				order.setOrderId(Integer.parseInt(lstOrderDto.get(i).getOrderId()));
				order.setAccount(lstOrderDto.get(i).getAccount());// 资金账户
				order.setActionIndex(lstOrderDto.get(i).getActionIndex());// 交易操作状态（BOT/SLD,BUY/SELL）
				order.setSymbol(lstOrderDto.get(i).getSymbol());// 股票代码
				order.setTotalQuantity(lstOrderDto.get(i).getTotalquantity());// 数量
				order.setLimitPrice(lstOrderDto.get(i).getLimitprice());// 价格
				order.setSentTime(lstOrderDto.get(i).getSentTime());// 提交时间
				order.setFinishTime(lstOrderDto.get(i).getFinishTime());// 完成时间
				order.setStatus(lstOrderDto.get(i).getStatus());// 订单状态
				order.setFilled(lstOrderDto.get(i).getFilled());
				order.setRemaining(lstOrderDto.get(i).getRemaining());
				order.setAvgFillPrice(lstOrderDto.get(i).getAvgFillPrice());
				order.setLastFillPrice(lstOrderDto.get(i).getLastFillPrice());
				order.setCommission(lstOrderDto.get(i).getCommission());
				order.setOrderType(lstOrderDto.get(i).getOrderType());
				
				// 添加订单属性描述，前端直接展示
				if ("BUY".equalsIgnoreCase(lstOrderDto.get(i).getActionIndex()) || "BOT".equalsIgnoreCase(lstOrderDto.get(i).getActionIndex())) {
					order.setActionIndexDescribe("买入");
				}else if ("SELL".equalsIgnoreCase(lstOrderDto.get(i).getActionIndex()) || "SLD".equalsIgnoreCase(lstOrderDto.get(i).getActionIndex())) {
					order.setActionIndexDescribe("卖出");
				}
				if ("LMT".equalsIgnoreCase(lstOrderDto.get(i).getOrderType())) {
					order.setOrderTypeDescribe("限价委托");
				}else if ("MKT".equalsIgnoreCase(lstOrderDto.get(i).getOrderType()) ){
					order.setOrderTypeDescribe("市价委托");
				}
				order.setTotalQuantityDescribe(lstOrderDto.get(i).getTotalquantity() + "");
				
				lstOrder.add(order);
			}
		}
		
		return lstOrder;
	}

	public List<PositionsInfo> reqPositions(String account) throws SocketException, InterruptedException
	{
		return ibBroker.reqPositions(account);
	}
	
	public HmStockInfo getRealTime(String account, String symbol) throws SocketException, InterruptedException
	{
		return ibBroker.getRealTime(account, symbol);
	}
	
	public void reqOpenOrders() throws SocketException
	{
		ibBroker.reqAllOpenOrders();
	}


}
