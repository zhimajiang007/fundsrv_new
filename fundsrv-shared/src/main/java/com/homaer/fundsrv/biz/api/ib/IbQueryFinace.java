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
import com.homaer.fundsrv.module.ib.FinanceInfo;
import com.homaer.fundsrv.service.StockQueryService;

/**
 * 雅虎接口测试
 * 
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/queryFinace", version = { "1.0.0", "1.1.0" })
public class IbQueryFinace extends AbstractApi<IbResponse, IbRequest> {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private StockQueryService stockQueryService;

	@Override
	public IbResponse execute(IbRequest request) {
		IbResponse response = new IbResponse();
		FinanceInfo objInfo = new FinanceInfo();
		// 参数判断
		if (StringUtils.isEmpty(request.getSymbol())) {
			logger.info("testYahoo传入参数有误！");
			return response;
		}
		
		try {
			objInfo = stockQueryService.queryFinace(request.getSymbol());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setFinanceInfo(objInfo);
		
		return response;
	}

}
