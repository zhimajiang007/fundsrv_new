package com.homaer.fundsrv.biz.api.ib.v161;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.exception.HbErrorCodeEnum;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.service.IbService;
import com.homaer.biz.framework.api.OsType;

/**
 * 查询委托交易记录（已完成交易/未完成交易/已撤销交易/）
 * 
 * 2016年3月17日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/tradeLog", version = { "1.6.1" }, osType = { OsType.ANDROID }) 
public class IbTradeLog extends AbstractApi<IbResponse, IbRequest> {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);

	@Autowired
	private IbService ibService;

	@Override
	public IbResponse execute(IbRequest request) {
		IbResponse response = new IbResponse();

		// 参数判断
		if (StringUtils.isEmpty(request.getAccount())) {
			logger.info("tradeLog传入参数有误！");
			return response;
		}

		try {
			List<BrokerOrder> lstOrder = new ArrayList<BrokerOrder>();
			List<BrokerOrder> lstSubOrder = new ArrayList<BrokerOrder>();
			List<BrokerOrder> lstFilOrder = new ArrayList<BrokerOrder>();
			if (StringUtils.isBlank(request.getAccount())) {
				response.setLstFilOrder(lstFilOrder);
				response.setLstSubOrder(lstSubOrder);
				return response;
			}
			lstOrder = ibService.reqOrder(request.getAccount());

			if (!CollectionUtils.isEmpty(lstOrder)) {
				for (int i = 0; i < lstOrder.size(); i++) {

					// 显示数量totalQuantityDescribe
					lstOrder.get(i).setTotalQuantityDescribe(lstOrder.get(i).getTotalQuantity() + "");
					
					if ("Submitted".equalsIgnoreCase(lstOrder.get(i).getStatus()) || "PreSubmitted".equalsIgnoreCase(lstOrder.get(i).getStatus())
							|| "MyStatus".equalsIgnoreCase(lstOrder.get(i).getStatus())
							|| "PendingSubmit".equalsIgnoreCase(lstOrder.get(i).getStatus())) {
							
							lstOrder.get(i).setStatusDescribe("撤销");
							lstOrder.get(i).setTimeDescribe(lstOrder.get(i).getSentTime());
							lstOrder.get(i).setPriceDescribe(lstOrder.get(i).getLimitPrice() + "");
						
						// 针对分段成交，提交1000股，已成交800股的情况
						if ("Submitted".equalsIgnoreCase(lstOrder.get(i).getStatus()) && lstOrder.get(i).getFilled() > 0
								&& lstOrder.get(i).getTotalQuantity() > lstOrder.get(i).getFilled()) {
							// 未完成订单处理
							lstOrder.get(i).setTotalQuantityDescribe(lstOrder.get(i).getFilled() + "/" + lstOrder.get(i).getTotalQuantity());
							lstSubOrder.add(lstOrder.get(i));
							
							// 已完成订单处理
							lstOrder.get(i).setTotalQuantityDescribe(lstOrder.get(i).getFilled() + "");
							lstOrder.get(i).setStatusDescribe("已完成");
							lstOrder.get(i).setPriceDescribe(lstOrder.get(i).getAvgFillPrice());
							lstFilOrder.add(lstOrder.get(i));
						}
						else {
							lstSubOrder.add(lstOrder.get(i));
						}
					}
					else if ("Filled".equalsIgnoreCase(lstOrder.get(i).getStatus()) || "Cancelled".equalsIgnoreCase(lstOrder.get(i).getStatus())
							|| "PendingCancel".equalsIgnoreCase(lstOrder.get(i).getStatus())) {
						if ("PendingCancel".equalsIgnoreCase(lstOrder.get(i).getStatus())) {
							lstOrder.get(i).setStatus("Cancelled");
						}
						// 显示订单状态statusDescribe
						if ("Cancelled".equalsIgnoreCase(lstOrder.get(i).getStatus())) {
							lstOrder.get(i).setStatusDescribe("已撤销");
						}
						else {
							lstOrder.get(i).setStatusDescribe("已完成");
						}
						// 显示时间
						lstOrder.get(i).setTimeDescribe(lstOrder.get(i).getFinishTime());
						// 显示价格
						lstOrder.get(i).setPriceDescribe(lstOrder.get(i).getAvgFillPrice());
						
						lstFilOrder.add(lstOrder.get(i));
					}

					System.out.println("第" + (i + 1) + "条记录");
					System.out.println(lstOrder.get(i).getOrderId());
					System.out.println(lstOrder.get(i).getAccount());// 资金账户
					System.out.println(lstOrder.get(i).getActionIndex());// 交易操作状态（BOT/SLD,BUY/SELL）
					System.out.println(lstOrder.get(i).getSymbol());// 股票代码
					System.out.println(lstOrder.get(i).getTotalQuantity());// 数量
					System.out.println(lstOrder.get(i).getLimitPrice());// 价格
					System.out.println(lstOrder.get(i).getSentTime() + "提交时间");// 提交时间
					System.out.println(lstOrder.get(i).getFinishTime() + "完成时间");// 完成时间
					System.out.println(lstOrder.get(i).getStatus());// 订单状态
					System.out.println(lstOrder.get(i).getFilled());
					System.out.println(lstOrder.get(i).getRemaining());
					System.out.println(lstOrder.get(i).getAvgFillPrice());
					System.out.println(lstOrder.get(i).getLastFillPrice());
					System.out.println(lstOrder.get(i).getCommission());
				}
			}
			else {
				System.out.println("数据为空");
			}

			// response.setLstOrder(lstOrder);
			response.setLstFilOrder(lstFilOrder);
			response.setLstSubOrder(lstSubOrder);

		}
		catch (Exception ex) {
			LoggerUtils.error(logger, ex);
			response.setCode(ex.getMessage());
			response.setErrorMsg(HbErrorCodeEnum.valueOfByCode(ex.getMessage()).getMessage());
		}
		return response;
	}

}
