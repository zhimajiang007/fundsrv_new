package com.homaer.fundsrv.biz.api.ib;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.ib.HistoryDayInfo;
import com.homaer.fundsrv.service.StockQueryService;

/**
 * 雅虎接口测试
 * 
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/queryHistory", version = { "1.0.0", "1.1.0" })
public class IbqueryHistory extends AbstractApi<IbResponse, IbRequest> {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private StockQueryService stockQueryService;

	@Override
	public IbResponse execute(IbRequest request) {
		IbResponse response = new IbResponse();
		@SuppressWarnings("unused")
    List<HistoryDayInfo> lstHistoryDayInfos = new ArrayList<HistoryDayInfo>();
		// 参数判断
		if (StringUtils.isEmpty(request.getSymbol())) {
			logger.info("testYahoo传入参数有误！");
			return response;
		}
		
		try {
			lstHistoryDayInfos = stockQueryService.queryHistory(request.getSymbol());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// response.setls
		return response;
	}

}
