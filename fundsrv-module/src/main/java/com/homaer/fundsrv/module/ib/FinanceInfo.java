package com.homaer.fundsrv.module.ib;

/**
 * @author changhai.wang
 */
public class FinanceInfo implements java.io.Serializable
{
	private static final long serialVersionUID = -5748323733200384842L;

	private String symbol; // BABA
	private String averageDailyVolume; // 13282900 日均成交量
	private String change; // +0.04 涨跌幅
	private String daysLow; // 77.71 日最低
	private String daysHigh;// 79.12 日最高
	private String yearLow;// 57.20 一年最低
	private String yearHigh;// 95.06 一年最高
	private String marketCapitalization;// 193.26B 股票总市值
	private String lastTradePriceOnly;// 79.01 最后成交价格
	private String daysRange;// 77.71 - 79.12 日浮动范围
	private String name;// Alibaba Group Holding Limited A 股票全称
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getAverageDailyVolume() {
		return averageDailyVolume;
	}
	public void setAverageDailyVolume(String averageDailyVolume) {
		this.averageDailyVolume = averageDailyVolume;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getDaysLow() {
		return daysLow;
	}
	public void setDaysLow(String daysLow) {
		this.daysLow = daysLow;
	}
	public String getDaysHigh() {
		return daysHigh;
	}
	public void setDaysHigh(String daysHigh) {
		this.daysHigh = daysHigh;
	}
	public String getYearLow() {
		return yearLow;
	}
	public void setYearLow(String yearLow) {
		this.yearLow = yearLow;
	}
	public String getYearHigh() {
		return yearHigh;
	}
	public void setYearHigh(String yearHigh) {
		this.yearHigh = yearHigh;
	}
	public String getMarketCapitalization() {
		return marketCapitalization;
	}
	public void setMarketCapitalization(String marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}
	public String getLastTradePriceOnly() {
		return lastTradePriceOnly;
	}
	public void setLastTradePriceOnly(String lastTradePriceOnly) {
		this.lastTradePriceOnly = lastTradePriceOnly;
	}
	public String getDaysRange() {
		return daysRange;
	}
	public void setDaysRange(String daysRange) {
		this.daysRange = daysRange;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
