package com.homaer.fundsrv.biz.api.ib.v101;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

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
@Api(value = "/ib/myIbAsset", version = { "1.1.0" }, osType = { OsType.WAP, OsType.PC })
public class IbMyAsset extends AbstractApi<IbResponse, IbRequest>
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
		List<PositionsInfo> lstPositions = new ArrayList<PositionsInfo>();

		// 参数判断
		if (StringUtils.isEmpty(request.getAccount())) {
			logger.info("getAccountValues传入Account为空！");
			return response;
		}
		
		try
		{
			BigDecimal stockMarketValue = new BigDecimal("0");// 股票市值
			BigDecimal unrealizedPnl = new BigDecimal("0");// 盈亏额
			objMarket = ibService.getAccountValues(request.getAccount());
			
			// 查询持仓数据更新股票市值及盈亏金额
			lstPositions = ibService.reqPositions(request.getAccount());
			if (CollectionUtils.isEmpty(lstPositions))
			{
				System.out.println(request.getAccount() + "持仓查询为空");
			} else
			{
				for (int i = 0; i < lstPositions.size(); i++)
				{
					PositionsInfo objPosition = lstPositions.get(i);
					
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

					// 股票市值
					lstPositions.get(i).setSymbolCost((objPosition.getPosition() *  objPosition.getCurrentPrice()));
					stockMarketValue = stockMarketValue.add(new BigDecimal(lstPositions.get(i).getSymbolCost()));
					
					// 股票涨跌额
					BigDecimal CurrentPrice = new BigDecimal(Double.toString(objPosition.getCurrentPrice()));
					BigDecimal AvgCost = new BigDecimal(Double.toString(objPosition.getAvgCost()));
					BigDecimal position = new BigDecimal(Double.toString(objPosition.getPosition()));
					String riseFallCost =  position.multiply(CurrentPrice.subtract(AvgCost)) + "";
					if (riseFallCost.indexOf(".") >= 0 && riseFallCost.length() >= riseFallCost.indexOf(".") + 3)
					{
						riseFallCost = riseFallCost.substring(0, riseFallCost.indexOf(".") + 3);
					}
					lstPositions.get(i).setRiseFallCost(riseFallCost);
					unrealizedPnl = unrealizedPnl.add(new BigDecimal(lstPositions.get(i).getRiseFallCost()));
					
					// 股票涨跌百分比
					String riseFall = String.format("%.6f", (objPosition.getCurrentPrice() - objPosition.getAvgCost())/objPosition.getAvgCost()) + "";
					if (riseFall.indexOf(".") >= 0 && riseFall.length() >= riseFall.indexOf(".") + 5)
					{
						riseFall = riseFall.substring(0, riseFall.indexOf(".") + 5);
					}
					
					double d = Double.parseDouble(riseFall);
					NumberFormat nFromat = NumberFormat.getPercentInstance();
					nFromat.setMaximumFractionDigits(2);
					String rates = nFromat.format(d);

					lstPositions.get(i).setRiseFall(rates);

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
					System.out.println(lstPositions.get(i).getSymbol());
					System.out.println(lstPositions.get(i).getPosition());
					System.out.println(lstPositions.get(i).getAvgCost());
					System.out.println(lstPositions.get(i).getSymbolCost());
					System.out.println(lstPositions.get(i).getRiseFallCost());
					System.out.println(lstPositions.get(i).getRiseFall());
				}
			}
			
			if (null != objMarket) {
				objMarket.setStockMarketValue(stockMarketValue + "");
				objMarket.setUnrealizedPnl(unrealizedPnl + "");
				objMarket.setNetLiquidationByCurrency(stockMarketValue.add(new BigDecimal(objMarket.getCashBalance())) + "");
				
				System.out.println(objMarket.getStockMarketValue() + "股票市值");
				System.out.println(objMarket.getUnrealizedPnl() + "股票盈亏");
				System.out.println(objMarket.getNetLiquidationByCurrency() + "股票账户总资产");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// PC显示资金更新时间，如周一~周五显示当前日期，周六周日显示周五日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println(sdf.format(calendar.getTime()));

		// 判断时间是否开盘
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(calendar.getTime());
		
		if (1 == dayOfWeek) {
			// 周日
			calendar2.add(Calendar.DATE, -2);
			response.setPcTime(sdf2.format(calendar2.getTime()));
		}
		else if (7 == dayOfWeek) {
			// 周六
			calendar2.add(Calendar.DATE, -1);
			response.setPcTime(sdf2.format(calendar2.getTime()));
		}
		else {
			response.setPcTime(sdf2.format(calendar2.getTime()));
		}

		response.setMarketData(objMarket);
		
		// 临时测试数据，之后一定删除
//		lstPositions.add(lstPositions.get(0));
//		lstPositions.get(1).setRiseFall("1.2");
//		lstPositions.get(1).setRiseFallCost("33");
		
		response.setLstPositions(lstPositions);

		return response;
	}

}
