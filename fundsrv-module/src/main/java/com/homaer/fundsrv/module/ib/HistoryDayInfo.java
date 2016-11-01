package com.homaer.fundsrv.module.ib;

/**
 * @author changhai.wang
 */
public class HistoryDayInfo implements java.io.Serializable
{

	private static final long serialVersionUID = 751654603666386017L;
	
	private String symbol; // BABA
	private String date; // 日期
	private String open; // 开票价
	private String high; // 最高价
	private String low;// 最低价
	private String close;// 收盘价
	private String volume;// 成交量
	private String adjClose;// 调整收盘价
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getAdjClose() {
		return adjClose;
	}
	public void setAdjClose(String adjClose) {
		this.adjClose = adjClose;
	}
	
	
	
}
