package com.homaer.fundsrv.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.tools.fs.ConfigurationUtil;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.http.HttpRequestSimple;
import com.homaer.fundsrv.module.ib.FinanceInfo;
import com.homaer.fundsrv.module.ib.HistoryDayInfo;
import com.homaer.fundsrv.service.StockQueryService;

@Service(value = "sinaStockQueryService")
public class SinaStockQueryServiceImpl implements StockQueryService {

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.SERVICE_LOGGER);

	public static final String SINA_APIS_URL = ConfigurationUtil
			.getValue("SINA_APIS_URL");

	public List<HmStockInfo> query(List<String> stock) throws Exception{
		List<HmStockInfo> list = new ArrayList<HmStockInfo>();
		if(CollectionUtils.isEmpty(stock)){
			return list;
		}
		LoggerUtils.info(LOGGER, "Sina Stock Query:" + stock);
		StringBuilder builder = new StringBuilder("");
		for (String s : stock) {
			builder.append("gb_" + s.toLowerCase() + ",");
		}
		HttpRequestSimple http = HttpRequestSimple.getInstance();
		String sc = builder.toString();
		LoggerUtils.info(LOGGER, SINA_APIS_URL + sc.substring(0, sc.length() - 1) + "新浪查询语句");
		String res = http.getSendHttp(
				SINA_APIS_URL + sc.substring(0, sc.length() - 1), "gbk");
		String[] arr = res.split(";");

		for (int i = 0; i < arr.length - 1; i++) {
			String symbol = stock.get(i);
			HmStockInfo info = new HmStockInfo();
			info.setSymbol(symbol);
			if (StringUtils.isNotBlank(arr[i])
					&& StringUtils.contains(arr[i], ",")) {
				String rs = arr[i].substring(arr[i].indexOf("\"") + 1,
						arr[i].lastIndexOf("\""));
				String[] rss = rs.split(",");
				if (null != rss && rss.length > 26) {
					info.setName(rss[0]);
					info.setPrice(rss[1]);
					// info.setChange(rss[4]);
					BigDecimal tmp = new BigDecimal(rss[4]);
					if(tmp.compareTo(BigDecimal.ZERO)>0){
						info.setChange("+"+tmp.setScale(2,BigDecimal.ROUND_DOWN));
					}else{
						info.setChange(""+tmp.setScale(2,BigDecimal.ROUND_DOWN));
					}
					info.setChange_per(rss[2]);
					
					info.setOpen(rss[5]);
					info.setDaysHigh(rss[6]);
					info.setDaysLow(rss[7]);
					info.setYearHigh(rss[8]);
					info.setYearLow(rss[9]);
					info.setEarningsShare(rss[13]);
					info.setPreviousClose(rss[26]);
					
				} else {
					info.setName(symbol);
					info.setPrice("0.00");
					info.setChange("0.00");
					info.setChange_per("0.00");
				}
			} else {
				info.setName(symbol);
				info.setPrice("0.00");
				info.setChange("0.00");
				info.setChange_per("0.00");
			}
			list.add(info);
			LOGGER.info(info.getYearHigh() + "---" + info.getYearLow() + "---");
		}
		return list;
	}
	
	public FinanceInfo queryFinace(String symbol) throws Exception
	{
		return null;
	}
	
	/**
	 * 查询历史K线数据--日K
	 * @param symbol
	 * @return
	 * @throws Exception
	 */
	public List<HistoryDayInfo> queryHistory(String symbol) throws Exception
	{
		return null;
	}
}
