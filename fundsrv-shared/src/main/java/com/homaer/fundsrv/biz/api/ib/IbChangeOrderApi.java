package com.homaer.fundsrv.biz.api.ib;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.service.IbService;

@Api(value = "/ib/changeOrder", version = { "1.0.0" })
public class IbChangeOrderApi extends AbstractApi<IbResponse, IbRequest>{

	@SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.API_LOGGER);
	
	@Autowired
	private IbService ibService;
	
	@Override
	public IbResponse execute(IbRequest request) {
		try {
			ibService.changeOrder(request.getUserId(), request.getOrderId(), request.getTotalQuantity(), Float.parseFloat(request.getLmtPrice()));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}