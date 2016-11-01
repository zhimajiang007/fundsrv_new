package com.homaer.fundsrv.biz.api.ib.v160;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.biz.framework.api.OsType;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.exception.HbErrorCodeEnum;
import com.homaer.fundsrv.service.BrokerOrderService;
import com.homaer.fundsrv.service.IbService;

/**
 * ib委托交易（买单/卖单）
 * 0506
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/trade", version = { "1.6.0" }, osType = { OsType.ANDROID, OsType.IOS}) 
public class IbTradeApi extends AbstractApi<IbResponse, IbRequest> {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private IbService ibService;

	@Autowired
	private BrokerOrderService brokerOrderService;

	@Override
	public IbResponse execute(IbRequest request) {
		IbResponse response = new IbResponse();

		// 参数判断
		if (StringUtils.isEmpty(request.getAccount())) {
			logger.info("trade传入参数有误！");
			return response;
		}

		Integer traderIsNew = request.getTraderIsNew();
		if (0 == traderIsNew && 11 != request.getTraderStatus() && 8 != request.getTraderStatus()) {
			response.setCode("0000");
			response.setErrorMsg("用户当前状态不可交易！");
			return response;
		}
		if (1 == traderIsNew && 4 != request.getTraderStatus() && 7 != request.getTraderStatus()) {
			response.setCode("0000");
			response.setErrorMsg("用户当前状态不可交易！");
			return response;
		}

		// 参数判断 股票代码||订单类型||资金账户||订单有效期
		if (StringUtils.isEmpty(request.getSymbol()) || StringUtils.isEmpty(request.getOrderType()) || StringUtils.isEmpty(request.getAccount())
				|| StringUtils.isEmpty(request.getTimeForce()) || ("LMT".equalsIgnoreCase(request.getOrderType()) && StringUtils.isEmpty(request.getLmtPrice()))) {
			response.setCode("0000");
			response.setErrorMsg("所传参数有误！");
		}
		else {
			try {
				int orderId = ibService.OrderPlace(request.getUserId(), request.getSymbol(), "", "", "SMART", "USD",
						request.getActionIndex(), request.getTotalQuantity(), request.getOrderType(), Float.parseFloat(request.getLmtPrice()), request.getAccount(),
						request.getTimeForce());
				response.setOrderId(orderId);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Calendar calendar = Calendar.getInstance();
				sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
				
				// 判断时间是否开盘
				int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int minute = calendar.get(Calendar.MINUTE);
				// 美股交易时间9:30--16:00
				if (1 == dayOfWeek || 7 == dayOfWeek) {
					// 周六日
					response.setOpeningState("未开盘");
				}
				else if (9 > hour || 16 < hour){
					response.setOpeningState("未开盘");
				}
				else if (9 == hour && minute < 30) {
					response.setOpeningState("未开盘");
				}
				else {
					response.setOpeningState("已开盘");
				}
				
				response.setUsaTime(sdf.format(calendar.getTime()) + " EDT");
				
				// 判断时间是否开盘
//				response.setOpeningState("已开盘");
//				response.setUsaTime(sdf.format(calendar.getTime()));

			}
			catch (Exception ex) {
				LoggerUtils.error(logger, ex);
				response.setCode(ex.getMessage());
				response.setErrorMsg(HbErrorCodeEnum.valueOfByCode(ex.getMessage()).getMessage());
			}
		}

		return response;
	}

}
