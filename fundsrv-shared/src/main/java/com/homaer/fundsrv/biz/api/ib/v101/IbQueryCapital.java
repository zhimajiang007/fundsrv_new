package com.homaer.fundsrv.biz.api.ib.v101;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

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
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.homaer.fundsrv.service.IbService;
import com.homaer.fundsrv.service.StockQueryService;

/**
 * 查询用户可用资金+即时股价
 * 
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/queryCapital", version = { "1.0.1" }, osType = { OsType.ANDROID })
public class IbQueryCapital extends AbstractApi<IbResponse, IbRequest>
{
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private IbService ibService;

	@Autowired
	private StockQueryService stockQueryService;

	@Override
	public IbResponse execute(IbRequest request)
	{
		IbResponse response = new IbResponse();
		String cashBalance;

		// 参数判断
		if (StringUtils.isEmpty(request.getAccount())) {
			logger.info("queryCapital传入参数有误！");
			return response;
		}
		
		try
		{
			if (StringUtils.isEmpty(request.getSymbol()))
			{
				response.setCode("0000");
				response.setErrorMsg("所传参数有误！");
			} else
			{
				// 获取美国时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
				sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
				response.setUsaTime(sdf.format(calendar.getTime()));

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

				cashBalance = ibService.getCashBalance(request.getAccount());
				response.setCashBalance(cashBalance);
				
				// 设置佣金比例
				response.setCommissionRate(IbResponse.IB_COMMISSIONRATE);
				// 设置佣金最小值
				response.setCommissionMin(IbResponse.IB_COMMISSION_MIN);

				// 查询即时股价
				List<String> lstSymbol = new ArrayList<String>();
				lstSymbol.add(request.getSymbol());
				List<HmStockInfo> lstStockInfo = new ArrayList<HmStockInfo>();
				lstStockInfo = stockQueryService.query(lstSymbol);
				
				if (!CollectionUtils.isEmpty(lstStockInfo)) {
					lstStockInfo.get(0).setChange_per(lstStockInfo.get(0).getChange_per() + "%");
					response.setHmStockInfo(lstStockInfo.get(0));
				}
				else {
					response.setHmStockInfo(null);
				}

				// 查询是否持仓，返回持仓数量，默认0
				int position = 0;
				// isState 1,买入操作;2,卖出操作，查询持仓
				if (2 == request.getIsState() && !StringUtils.isEmpty(request.getSymbol()))
				{
					List<PositionsInfo> lstPositions = new ArrayList<PositionsInfo>();
					lstPositions = ibService.reqPositions(request.getAccount());
					// 日志查看方便，先留着
					if (CollectionUtils.isEmpty(lstPositions))
					{
						logger.info(request.getAccount() + "持仓查询为空");
					} else
					{
						for (int i = 0; i < lstPositions.size(); i++)
						{
							if (request.getSymbol().equalsIgnoreCase(lstPositions.get(i).getSymbol()))
							{
								position = lstPositions.get(i).getPosition();
							}
						}
					}
				}
				response.setPosition(position);

				// 以下为调试阶段查看参数，后期可删除
				if (!CollectionUtils.isEmpty(lstStockInfo))
				{
					for (int i = 0; i < lstStockInfo.size(); i++)
					{
						HmStockInfo stockInfo = lstStockInfo.get(i);
						logger.info(stockInfo.getName() + "-------");
						logger.info(stockInfo.getPrice());
						logger.info(stockInfo.getSymbol());
						logger.info(stockInfo.getChange());
						logger.info(stockInfo.getChange_per());
					}
				} else
				{
					logger.info("查询股票价格为空============");
				}
			}
		} catch (Exception ex)
		{
			LoggerUtils.error(logger, ex);
			response.setCode(ex.getMessage());
			response.setErrorMsg(HbErrorCodeEnum.valueOfByCode(ex.getMessage()).getMessage());
		}
		return response;
	}

}
