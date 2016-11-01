package com.homaer.fundsrv.biz.api.ib;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.biz.framework.api.OsType;
import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.exception.HbErrorCodeEnum;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.homaer.fundsrv.service.IbService;
import com.homaer.fundsrv.service.StockQueryService;
import com.homaer.service.ticker.bo.TickerBo;
import com.homaer.service.ticker.model.TickerInfoModel;

/**
 * 持仓查询接口。
 * @author changhai.wang
 * 
 */
@Api(value = "/ib/reqPositions", version = { "1.0.0", "1.1.0" }, osType = { OsType.ALL})
public class IbReqPositions extends AbstractApi<IbResponse, IbRequest> {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private IbService ibService;
	
	@Autowired
	private TickerBo ticketServer;
	
	@Autowired
	private StockQueryService stockQueryService;

	@Override
	public IbResponse execute(IbRequest request) {
		IbResponse response = new IbResponse();
		
		// 参数判断
		if (StringUtils.isEmpty(request.getAccount())) {
			logger.info("reqPositions传入参数有误！");
			return response;
		}
		try {
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

					if (null == rates) {
						rates = null;
					}
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
			response.setLstPositions(lstPositions);
			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//			Calendar calendar = Calendar.getInstance();
//			sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//
//			response.setUsaTime(sdf.format(calendar.getTime()));
//			response.setOpeningState("已开盘");
			
		} catch (Exception ex) {
			LoggerUtils.error(logger, ex);
			response.setCode(ex.getMessage());
			response.setErrorMsg(HbErrorCodeEnum.valueOfByCode(ex.getMessage()).getMessage());
		}
		return response;
	}

}
