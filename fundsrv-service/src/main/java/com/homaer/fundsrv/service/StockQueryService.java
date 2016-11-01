package com.homaer.fundsrv.service;

import java.util.List;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.fundsrv.module.ib.FinanceInfo;
import com.homaer.fundsrv.module.ib.HistoryDayInfo;

/**
 * 雅虎即时股价查询。
 * 
 * 2016年3月17日
 * @author changhai.wang
 */
public interface StockQueryService {

	/**
	 * 雅虎即时股价查询。
	 * @param stock
	 * @return
	 * @throws Exception
	 * 2016年3月17日
	 * @author changhai.wang
	 */
	public List<HmStockInfo> query(List<String> stock) throws Exception;
	
	/**
	 * 雅虎一年股价查询。
	 * @param stock
	 * @return
	 * @throws Exception
	 * 2016年3月17日
	 * @author changhai.wang
	 */
	public FinanceInfo queryFinace(String symbol) throws Exception;
	
	/**
	 * 查询历史K线数据--日K
	 * @param symbol
	 * @return
	 * @throws Exception
	 */
	public List<HistoryDayInfo> queryHistory(String symbol) throws Exception;
}
