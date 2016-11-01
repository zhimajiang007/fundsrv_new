package com.homaer.fundsrv.biz.api.ib;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.service.IbService;
import com.homaer.fundsrv.service.StockQueryService;
import com.homaer.service.ticker.bo.TickerBo;

/**
 * CRM提前查询账户资产。全部资产、美元资产
 * 
 * 2016年3月10日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/accValueForCrm", version = { "1.0.0" })
public class IbAccValueForCrmApi extends AbstractApi<IbResponse, IbRequest>
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
			objMarket = ibService.getAccountValues(request.getAccount());
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
		return response;
	}

}
