package com.homaer.fundsrv.biz.api.ib.v161;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.SocketException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.biz.framework.api.OsType;
import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.homaer.fundsrv.service.IbService;
import com.homaer.fundsrv.service.StockQueryService;
import com.homaer.service.ticker.bo.TickerBo;
import com.homaer.service.ticker.model.TickerInfoModel;

/**
 * 查询账户资产。全部资产、美元资产等等
 * 
 * 2016年3月10日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/getAccountValues", version = { "1.6.1" }, osType = { OsType.IOS, OsType.ANDROID})
public class IbAccountValueApi extends AbstractApi<IbResponse, IbRequest>
{
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private IbService ibService;
	
	@Autowired
	private TickerBo ticketServer;
	
	@Autowired
	private StockQueryService stockQueryService;

	@Override
	public IbResponse execute(IbRequest request)
	{
		IbResponse response = new IbResponse();
		MarketData objMarket = new MarketData();
		
		// 参数判断
		if (StringUtils.isEmpty(request.getAccount())) {
			logger.info("getAccountValues传入Account为空！");
			return response;
		}
		
		try
		{
			BigDecimal stockMarketValue = new BigDecimal("0");// 账户股票市值
			// BigDecimal unrealizedPnl = new BigDecimal("0");// 账户盈亏额
			objMarket = ibService.getAccountValues(request.getAccount());
			
			// 查询持仓数据更新股票市值及盈亏金额
			List<PositionsInfo> lstPositions = new ArrayList<PositionsInfo>();
			lstPositions = ibService.reqPositions(request.getAccount());
			if (CollectionUtils.isEmpty(lstPositions))
			{
				System.out.println(request.getAccount() + "持仓查询为空");
			} else
			{
				for (int i = 0; i < lstPositions.size(); i++)
				{
					PositionsInfo objPosition = lstPositions.get(i);
					

					if (objPosition.getAvgCost() <= 0 ) {
						lstPositions.remove(i);
						System.out.println("删除一条无效持仓111111" + objPosition.getSymbol());
						continue;
					}					
				}
				
				for (int i = 0; i < lstPositions.size(); i++)
				{
					PositionsInfo objPosition = lstPositions.get(i);
					
					if (objPosition.getAvgCost() <= 0 ) {
						System.out.println("删除一条无效持仓111" + objPosition.getName());
						lstPositions.remove(i);
						continue;
					}	
					
					// yahoo查询当前股价及股票名称
					List<String> lstSymbol = new ArrayList<String>();
					lstSymbol.add(objPosition.getSymbol());
					List<HmStockInfo> lstStockInfo = new ArrayList<HmStockInfo>();
					lstStockInfo = stockQueryService.query(lstSymbol);
					if (!CollectionUtils.isEmpty(lstStockInfo))
					{
						objPosition.setName(lstStockInfo.get(0).getName());
						objPosition.setCurrentPrice(Double.parseDouble(lstStockInfo.get(0).getPrice()));
					}else {
						objPosition.setName("--");
						objPosition.setCurrentPrice(0.0);
					}

					BigDecimal position = new BigDecimal(Double.toString(objPosition.getPosition()));
					BigDecimal CurrentPrice = new BigDecimal(Double.toString(objPosition.getCurrentPrice()));
					BigDecimal AvgCost = new BigDecimal(Double.toString(objPosition.getAvgCost()));
					
					// 股票市值
					lstPositions.get(i).setSymbolCost(Double.parseDouble(position.multiply(CurrentPrice).setScale(2, BigDecimal.ROUND_DOWN) + ""));
					
					stockMarketValue = stockMarketValue.add(new BigDecimal(lstPositions.get(i).getSymbolCost()));
					
					// 股票涨跌额
					String riseFallCost =  position.multiply(CurrentPrice.subtract(AvgCost)) + "";
					if (riseFallCost.indexOf(".") >= 0 && riseFallCost.length() >= riseFallCost.indexOf(".") + 3)
					{
						riseFallCost = riseFallCost.substring(0, riseFallCost.indexOf(".") + 3);
					}
					lstPositions.get(i).setRiseFallCost(riseFallCost);
					// unrealizedPnl = unrealizedPnl.add(new BigDecimal(lstPositions.get(i).getRiseFallCost()));
					
					// 股票涨跌百分比
					String riseFall = String.format("%.6f", (objPosition.getCurrentPrice() - objPosition.getAvgCost())/objPosition.getAvgCost()) + "";
					if (riseFall.indexOf(".") >= 0 && riseFall.length() >= riseFall.indexOf(".") + 5)
					{
						riseFall = riseFall.substring(0, riseFall.indexOf(".") + 5);
					}
					
//					double d = Double.parseDouble(riseFall);
//					NumberFormat nFromat = NumberFormat.getPercentInstance();
//					nFromat.setMaximumFractionDigits(2);
//					String rates = nFromat.format(d +"");

					if (null == riseFall) {
						System.out.println("空值赋0====");
						riseFall = "0";
					}
					lstPositions.get(i).setRiseFall(riseFall);
					
					System.out.println("成本价处理前=========" + lstPositions.get(i).getAvgCost());
					// 处理成本价小数点2位
					if (!StringUtils.isEmpty(lstPositions.get(i).getAvgCost()) && lstPositions.get(i).getAvgCost() > 0) {
						String avgCost = lstPositions.get(i).getAvgCost() + "";
						BigDecimal bigAvgCost= new BigDecimal(avgCost).setScale(2, BigDecimal.ROUND_DOWN);
						  System.out.println(bigAvgCost);
						  lstPositions.get(i).setAvgCost(Double.parseDouble(bigAvgCost + ""));
					}

					// 查询tickerId
					TickerInfoModel model = new TickerInfoModel();
					model = ticketServer.getTickerInfo(objPosition.getSymbol());
					if (null != model) {
						objPosition.setTickerId(model.getTickerId());
					}
					else
					{
						logger.info(objPosition.getSymbol() + "查询tickerId为空!");
					}
					
					// 交易记录查询,返回交易记录数量
					List<BrokerOrder> lstOrder = new ArrayList<BrokerOrder>();
					lstOrder = ibService.reqOrder(request.getAccount());
					if (!CollectionUtils.isEmpty(lstOrder))
					{
						response.setOrderCount(lstOrder.size() + "");
					}else {
						response.setOrderCount("0");
					}
					
					// 日志方便查看
					System.out.println("第" + (i + 1) + "股票");
					System.out.println(lstPositions.get(i).getAccount());
					System.out.println(lstPositions.get(i).getName());
					System.out.println(lstPositions.get(i).getSymbol());
					System.out.println(lstPositions.get(i).getPosition());
					System.out.println(lstPositions.get(i).getAvgCost());
					System.out.println(lstPositions.get(i).getSymbolCost());
					System.out.println(lstPositions.get(i).getRiseFallCost());
					System.out.println(lstPositions.get(i).getRiseFall() + "-----");
				}
			}
			
			if (null != objMarket) {
				objMarket.setStockMarketValue(stockMarketValue + "");
				// objMarket.setUnrealizedPnl(unrealizedPnl + "");
				objMarket.setNetLiquidationByCurrency(stockMarketValue.add(new BigDecimal(objMarket.getCashBalance())) + "");
				
				// 计算账户涨跌百分比
				// 当前涨跌额
				BigDecimal realizedPnl = new BigDecimal("0");
				BigDecimal unrealizedPnl = new BigDecimal("0");
				
				if (StringUtils.isEmpty(objMarket.getNetLiquidationByCurrency())) {
				}else {
					if (!StringUtils.isEmpty(objMarket.getRealizedPnl())) {
						realizedPnl = new BigDecimal(objMarket.getRealizedPnl());
					}
					if (!StringUtils.isEmpty(objMarket.getUnrealizedPnl())) {
						unrealizedPnl = new BigDecimal(objMarket.getUnrealizedPnl());
					}
					objMarket.setRealizedPnl(realizedPnl.add(unrealizedPnl) + "");
					
					realizedPnl = new BigDecimal(objMarket.getRealizedPnl());
					
					// 当前总资产
					BigDecimal netLiquidationByCurrency = new BigDecimal(objMarket.getNetLiquidationByCurrency());
					// 初始资产
					BigDecimal accountInitial = netLiquidationByCurrency.subtract(realizedPnl);
					// 当前涨跌百分比
					BigDecimal accountRiseFall = realizedPnl.divide(accountInitial, 6, RoundingMode.DOWN);
					System.out.println("涨跌百分比"+accountRiseFall);

			        NumberFormat percent = NumberFormat.getPercentInstance();
			        percent.setMaximumFractionDigits(2);

			        System.out.println("涨跌百分比"+percent.format(accountRiseFall.doubleValue()));
			        
			        objMarket.setAccountRiseFallCost(objMarket.getRealizedPnl());
			        objMarket.setAccountRiseFall(percent.format(accountRiseFall.doubleValue()));
			        objMarket.setAccountInitial(accountInitial + "");
				}
				System.out.println(objMarket.getStockMarketValue() + "股票市值");
				System.out.println(objMarket.getUnrealizedPnl() + "当前股票盈亏");
				System.out.println(objMarket.getNetLiquidationByCurrency() + "股票账户总资产");
				System.out.println(objMarket.getAccountRiseFallCost() + "股票账户总盈亏");
				System.out.println(objMarket.getAccountRiseFall() + "股票账户总盈亏百分比");
				System.out.println(objMarket.getAccountInitial() + "资金账户初始金额");
			}
			
		} catch (SocketException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setMarketData(objMarket);
		// response.setLstMarket(lstMarket);
		return response;
	}

}
