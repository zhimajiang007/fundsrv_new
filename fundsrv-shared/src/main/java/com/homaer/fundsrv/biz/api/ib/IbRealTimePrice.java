package com.homaer.fundsrv.biz.api.ib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.exception.HbErrorCodeEnum;
import com.homaer.fundsrv.service.IbService;

/**
 * ib委托交易（买单/卖单）
 * 
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/realTimePrice", version = { "1.0.0" })
public class IbRealTimePrice extends AbstractApi<IbResponse, IbRequest> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private IbService ibService;

	@Override
	public IbResponse execute(IbRequest request) {
		IbResponse response = new IbResponse();

		if (StringUtils.isEmpty(request.getSymbol())) {
			response.setCode("0000");
			response.setErrorMsg("所传参数有误！");
		} else {
			try {
				ibService.getRealTime(request.getAccount(), request.getSymbol());
				
			} catch (Exception ex) {
				LoggerUtils.error(LOGGER, ex);
				response.setCode(ex.getMessage());
				response.setErrorMsg(HbErrorCodeEnum.valueOfByCode(
						ex.getMessage()).getMessage());
			}

		}
		return response;
	}

}
