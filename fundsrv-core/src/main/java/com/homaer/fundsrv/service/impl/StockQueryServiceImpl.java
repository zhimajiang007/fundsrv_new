package com.homaer.fundsrv.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.tools.fs.ConfigurationUtil;
import com.homaer.common.utils.SpringContextUtil;
import com.homaer.fundsrv.module.ib.FinanceInfo;
import com.homaer.fundsrv.module.ib.HistoryDayInfo;
import com.homaer.fundsrv.service.StockQueryService;


@Service(value = "stockQueryService")
public class StockQueryServiceImpl implements StockQueryService {

	private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
	                                                                                  
	private static String[] stockqueryapis = new String[] { "sinaStockQueryService", "yahooStockQueryService" };

	private static int _stockqueryapis = stockqueryapis.length;

	static {
		map.put("stockqueryapi", ConfigurationUtil.getValue("STOCK_QUERY_SERVICE"));
	}

	@Override
	public List<HmStockInfo> query(List<String> stock) {
		List<HmStockInfo> list = new ArrayList<HmStockInfo>();
		String stockqueryapi = map.get("stockqueryapi");
		StockQueryService service = null;
		int i = 0;
		try {
			service = (StockQueryService) SpringContextUtil.getBean(stockqueryapi);
			list = service.query(stock);
			if (CollectionUtils.isEmpty(list)) {
				System.out.println(stockqueryapi + "---股价查询为空---");
				for (i = 0; i < _stockqueryapis; i++) {
					String s = stockqueryapis[i];
					if (StringUtils.equals(s, stockqueryapi)) {
						continue;
					}
					service = (StockQueryService) SpringContextUtil.getBean(s);
					list = service.query(stock);
					if (CollectionUtils.isNotEmpty(list)) {
						map.put("stockqueryapi", s);
						break;
					}
				}
				System.out.println(stockqueryapi + "---股价查询数据---");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				for (; i < _stockqueryapis; i++) {
					String s = stockqueryapis[i];
					if (StringUtils.equals(s, stockqueryapi)) {
						continue;
					}
					service = (StockQueryService) SpringContextUtil.getBean(s);
					list = service.query(stock);

					if (CollectionUtils.isNotEmpty(list)) {
						map.put("stockqueryapi", s);
						break;
					}
				}
			} catch (Exception e) {
				
			}

		}

		return list;
	}
	
	public FinanceInfo queryFinace(String symbol) throws Exception
	{
		StockQueryService service = null;
		service = (StockQueryService) SpringContextUtil.getBean("yahooStockQueryService");
		return service.queryFinace(symbol);
	}
	
	/**
	 * 查询历史K线数据--日K
	 * @param symbol
	 * @return
	 * @throws Exception
	 */
	public List<HistoryDayInfo> queryHistory(String symbol) throws Exception
	{
		StockQueryService service = null;
		service = (StockQueryService) SpringContextUtil.getBean("yahooStockQueryService");
		return service.queryHistory(symbol);
	}

}
