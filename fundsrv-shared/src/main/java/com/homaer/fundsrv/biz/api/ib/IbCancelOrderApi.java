package com.homaer.fundsrv.biz.api.ib;

import java.net.SocketException;

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
import com.homaer.fundsrv.service.IbService;

/**
 * 交易订单取消。
 * 
 * 所需参数	orderId、account
 * 示例	biz_data={\"orderId\":\"284284398\",\"account\":\"\"}"
 * 2016年3月17日
 * @author changhai.wang
 */
@Api(value = "/ib/cancelOrder", version = { "1.0.0", "1.1.0" }, osType = { OsType.ALL})
public class IbCancelOrderApi extends AbstractApi<IbResponse, IbRequest>
{
	@Autowired
	private IbService ibService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Override
	public IbResponse execute(IbRequest request)
	{
		IbResponse response = new IbResponse();
		
		// 参数判断
		if (StringUtils.isEmpty(request.getAccount()) || StringUtils.isEmpty(request.getOrderId()) || 0 >= request.getOrderId()) {
			logger.info("cancelOrder传入参数有误！");
			return response;
		}
		
		try
		{
			ibService.cancelOrder(request.getOrderId(), request.getAccount());
		} catch (SocketException e)
		{
			e.printStackTrace();
		}
		return response;
	}

}
