package com.homaer.fundsrv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.tools.fs.ConfigurationUtil;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.http.HttpRequestSimple;
import com.homaer.fundsrv.module.ib.FinanceInfo;
import com.homaer.fundsrv.module.ib.HistoryDayInfo;
import com.homaer.fundsrv.service.StockQueryService;

/**
 * 雅虎即时股价查询。
 * 
 * 2016年3月17日
 * @author changhai.wang
 */
@Service(value = "yahooStockQueryService")
public class YahooStockQueryServiceImpl implements StockQueryService
{

	protected static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtils.SERVICE_LOGGER);

	public static final String YAHOO_APIS_URL = ConfigurationUtil.getValue("YAHOO_APIS_URL");

	public static final String YAHOO_APIS_YQL_QUOTES = ConfigurationUtil.getValue("YAHOO_APIS_YQL_QUOTES");
	
	public static final String YAHOO_APIS_YQL_FINANCE_QUOTES = ConfigurationUtil.getValue("YAHOO_APIS_YQL_FINANCE_QUOTES");

	public static final String YAHOO_APIS_YQL_HISTORY = ConfigurationUtil.getValue("YAHOO_APIS_YQL_HISTORY");

	public List<HmStockInfo> query(List<String> stock) throws Exception
	{
		List<HmStockInfo> list = new ArrayList<HmStockInfo>();
		if (CollectionUtils.isEmpty(stock))
		{
			return list;
		}
		LoggerUtils.info(LOGGER, "Yahoo Stock Query:" + stock);
		StringBuilder builder = new StringBuilder("");
		for (String s : stock)
		{
			builder.append(s.toUpperCase() + ",");
		}
		HttpRequestSimple http = HttpRequestSimple.getInstance();
		String sc = builder.insert(0, "\"").append("\"").toString();
		String res = null;

		try
		{
			String url = YAHOO_APIS_URL + java.net.URLEncoder.encode(String.format(YAHOO_APIS_YQL_QUOTES, sc), "UTF-8");

			res = http.getSendHttp(url, "GBK");
			if (StringUtils.isBlank(res))
			{
				return list;
			}
			LoggerUtils.info(LOGGER, res);
			JSONObject query = JSONObject.parseObject(res).getJSONObject("query");
			int count = query.getIntValue("count");
			if (1 == count)
			{
				HmStockInfo info = new HmStockInfo();
				JSONObject obj = query.getJSONObject("results").getJSONObject("quote");
				info.setSymbol(obj.getString("symbol"));
				info.setName(obj.getString("Name"));
				if (StringUtils.isNotBlank(obj.getString("LastTradePriceOnly")))
				{
					info.setPrice(obj.getString("LastTradePriceOnly"));
				}
				if (StringUtils.isNotBlank(obj.getString("Change")))
				{
					info.setChange(obj.getString("Change"));
				} else
				{
					info.setChange("0.00");
				}
				if (StringUtils.isNotBlank(obj.getString("ChangeinPercent")))
				{
					info.setChange_per(obj.getString("ChangeinPercent").replace("%", ""));
				} else
				{
					info.setChange_per("0.00");
				}
				list.add(info);
				return list;
			}
			JSONArray arr = query.getJSONObject("results").getJSONArray("quote");

			for (int i = 0; i < arr.size(); i++)
			{
				HmStockInfo info = new HmStockInfo();
				JSONObject obj = arr.getJSONObject(i);
				info.setSymbol(obj.getString("symbol"));
				info.setName(obj.getString("Name"));
				if (StringUtils.isNotBlank(obj.getString("LastTradePriceOnly")))
				{
					info.setPrice(obj.getString("LastTradePriceOnly"));
				}
				if (StringUtils.isNotBlank(obj.getString("Change")))
				{
					info.setChange(obj.getString("Change"));
				} else
				{
					info.setChange("0.00");
				}
				if (StringUtils.isNotBlank(obj.getString("ChangeinPercent")))
				{
					info.setChange_per(obj.getString("ChangeinPercent").replace("%", ""));
				} else
				{
					info.setChange_per("0.00");
				}
				list.add(info);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}
	
	public FinanceInfo queryFinace(String symbol) throws Exception
	{
		FinanceInfo objInfo = new FinanceInfo();
		
		if (StringUtils.isEmpty(symbol)) {
			return null;
		}
		LoggerUtils.info(LOGGER, "Yahoo Stock Finance Query:" + symbol);
		
		String res = null;
		HttpRequestSimple http = HttpRequestSimple.getInstance();
		
		StringBuilder builder = new StringBuilder("");
		
		builder.append(symbol.toUpperCase());

		String sc = builder.insert(0, "\"").append("\"").toString();

		try
		{
			String url = YAHOO_APIS_URL + java.net.URLEncoder.encode(String.format(YAHOO_APIS_YQL_FINANCE_QUOTES, sc), "UTF-8");

			res = http.getSendHttp(url, "GBK");
			if (StringUtils.isBlank(res))
			{
				return null;
			}
			LoggerUtils.info(LOGGER, res);
			JSONObject query = JSONObject.parseObject(res).getJSONObject("query");
			int count = query.getIntValue("count");
			if (1 == count)
			{
				JSONObject obj = query.getJSONObject("results").getJSONObject("quote");
				objInfo.setSymbol(obj.getString("symbol"));
				objInfo.setName(obj.getString("Name"));
				if (StringUtils.isNotBlank(obj.getString("LastTradePriceOnly")))
				{
					objInfo.setLastTradePriceOnly(obj.getString("LastTradePriceOnly"));
				}
				if (StringUtils.isNotBlank(obj.getString("Change")))
				{
					objInfo.setChange(obj.getString("Change"));
				} else
				{
					objInfo.setChange("0.00");
				}
				if (StringUtils.isNotBlank(obj.getString("AverageDailyVolume")))
				{
					objInfo.setAverageDailyVolume(obj.getString("AverageDailyVolume"));
				}
				if (StringUtils.isNotBlank(obj.getString("DaysLow")))
				{
					objInfo.setDaysLow(obj.getString("DaysLow"));
				}
				if (StringUtils.isNotBlank(obj.getString("DaysHigh")))
				{
					objInfo.setDaysHigh(obj.getString("DaysHigh"));
				}
				if (StringUtils.isNotBlank(obj.getString("YearLow")))
				{
					objInfo.setYearLow(obj.getString("YearLow"));
				}
				if (StringUtils.isNotBlank(obj.getString("YearHigh")))
				{
					objInfo.setYearHigh(obj.getString("YearHigh"));
				}
				
				if (StringUtils.isNotBlank(obj.getString("MarketCapitalization")))
				{
					objInfo.setMarketCapitalization(obj.getString("MarketCapitalization"));
				}
				if (StringUtils.isNotBlank(obj.getString("DaysRange")))
				{
					objInfo.setDaysRange(obj.getString("DaysRange"));
				}
			}
	
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return objInfo;
	}
	
	/**
	 * 查询历史K线数据--日K
	 * @param symbol
	 * @return
	 * @throws Exception
	 */
	public List<HistoryDayInfo> queryHistory(String symbol) throws Exception
	{
		List<HistoryDayInfo> lstInfo = new ArrayList<HistoryDayInfo>();
		
		if (StringUtils.isEmpty(symbol)) {
			return null;
		}
		LoggerUtils.info(LOGGER, "Yahoo Stock HistoryDayInfo Query:" + symbol);
		
		String res = null;
		HttpRequestSimple http = HttpRequestSimple.getInstance();
		
		StringBuilder builder = new StringBuilder("");
		StringBuilder endbuilder = new StringBuilder("");
		StringBuilder startbuilder = new StringBuilder("");
		
		builder.append(symbol.toUpperCase());
		endbuilder.append("2016-04-18");
		startbuilder.append("2016-04-12");

		String sc = builder.insert(0, "\"").append("\"").toString();
		String endSc = endbuilder.insert(0, "\"").append("\"").toString();
		String startSc = startbuilder.insert(0, "\"").append("\"").toString();

		try
		{
			String url = YAHOO_APIS_URL + java.net.URLEncoder.encode(String.format(YAHOO_APIS_YQL_HISTORY, sc, endSc, startSc), "UTF-8");

			res = http.getSendHttp(url, "GBK");
			if (StringUtils.isBlank(res))
			{
				return null;
			}
			LoggerUtils.info(LOGGER, res);
			JSONObject query = JSONObject.parseObject(res).getJSONObject("query");
			JSONArray arr = query.getJSONObject("results").getJSONArray("quote");

			for (int i = 0; i < arr.size(); i++)
			{
				HistoryDayInfo info = new HistoryDayInfo();
				JSONObject obj = arr.getJSONObject(i);
				info.setSymbol(obj.getString("Symbol"));
				
				if (StringUtils.isNotBlank(obj.getString("Date")))
				{
					info.setDate(obj.getString("Date"));
				}
				
				if (StringUtils.isNotBlank(obj.getString("Open")))
				{
					info.setOpen(obj.getString("Open"));
				}
				if (StringUtils.isNotBlank(obj.getString("High")))
				{
					info.setHigh(obj.getString("High"));
				}
				if (StringUtils.isNotBlank(obj.getString("Low")))
				{
					info.setLow(obj.getString("Low"));
				}
				if (StringUtils.isNotBlank(obj.getString("Close")))
				{
					info.setClose(obj.getString("Close"));
				}
				if (StringUtils.isNotBlank(obj.getString("Volume")))
				{
					info.setVolume(obj.getString("Volume"));
				}
				if (StringUtils.isNotBlank(obj.getString("Adj_Close")))
				{
					info.setAdjClose(obj.getString("Adj_Close"));
				}
				lstInfo.add(info);
			}
	
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return lstInfo;
	}
}
