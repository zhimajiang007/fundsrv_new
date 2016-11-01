package com.homaer.fundsrv.biz.api.ib;

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
 * 
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/reqOpenOrder", version = { "1.0.0", "1.1.0" }, osType = { OsType.ALL})
public class IbReqOpenOrderApi extends AbstractApi<IbResponse, IbRequest> {

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
		
		try {
			ibService.reqOpenOrders();
			
	
		} catch (Exception ex) {
			LoggerUtils.error(logger, ex);
			response.setCode(ex.getMessage());
			response.setErrorMsg(HbErrorCodeEnum.valueOfByCode(ex.getMessage()).getMessage());
		}
		return response;
	}

}
