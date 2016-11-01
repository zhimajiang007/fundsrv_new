package com.homaer.fundsrv.module.ib;

/**
 * 持仓数据类。
 * 
 * 可直接继承Contract?先分开写。 2016年3月3日
 * 
 * @author changhai.wang
 */
public class PositionsInfo implements java.io.Serializable
{
	private static final long serialVersionUID = -5748323733200384842L;

	private String account; // 资金账户
	private int conId;
	private String symbol; // 股票代码
	private String name; // 股票名称
	private String secType;
	private String expiry;
	private double strike;
	private String right;
	private String multiplier;
	private String primaryExch;
	private String exchange;
	private String currency;
	private String localSymbol;
	private String tradingClass;
	private Integer position; // 持仓数量
	private Double avgCost; // 持仓均价
	
	private Double currentPrice;	// 市价
	
	private Double symbolCost; // 股票市值
	
	private String riseFallCost; //涨跌额
	
	private String riseFall; // 涨跌百分比
	
	private String todayRiseFallCost; // 今日涨跌额
	
	private String todayRiseFall;// 今日涨跌百分比
	
	private String tickerId;
		
	public String getTodayRiseFallCost() {
		return todayRiseFallCost;
	}

	public void setTodayRiseFallCost(String todayRiseFallCost) {
		this.todayRiseFallCost = todayRiseFallCost;
	}

	public String getTodayRiseFall() {
		return todayRiseFall;
	}

	public void setTodayRiseFall(String todayRiseFall) {
		this.todayRiseFall = todayRiseFall;
	}

	public String getTickerId()
	{
		return tickerId;
	}

	public void setTickerId(String tickerId)
	{
		this.tickerId = tickerId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getSymbolCost()
	{
		return symbolCost;
	}

	public void setSymbolCost(Double symbolCost)
	{
		this.symbolCost = symbolCost;
	}
	
	public String getRiseFallCost()
	{
		return riseFallCost;
	}

	public void setRiseFallCost(String riseFallCost)
	{
		this.riseFallCost = riseFallCost;
	}

	public String getRiseFall()
	{
		return riseFall;
	}

	public void setRiseFall(String riseFall)
	{
		this.riseFall = riseFall;
	}

	public Double getCurrentPrice()
	{
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice)
	{
		this.currentPrice = currentPrice;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public int getConId()
	{
		return conId;
	}

	public void setConId(int conId)
	{
		this.conId = conId;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	public String getSecType()
	{
		return secType;
	}

	public void setSecType(String secType)
	{
		this.secType = secType;
	}

	public String getExpiry()
	{
		return expiry;
	}

	public void setExpiry(String expiry)
	{
		this.expiry = expiry;
	}

	public double getStrike()
	{
		return strike;
	}

	public void setStrike(double strike)
	{
		this.strike = strike;
	}

	public String getRight()
	{
		return right;
	}

	public void setRight(String right)
	{
		this.right = right;
	}

	public String getMultiplier()
	{
		return multiplier;
	}

	public void setMultiplier(String multiplier)
	{
		this.multiplier = multiplier;
	}

	public String getPrimaryExch()
	{
		return primaryExch;
	}

	public void setPrimaryExch(String primaryExch)
	{
		this.primaryExch = primaryExch;
	}

	public String getExchange()
	{
		return exchange;
	}

	public void setExchange(String exchange)
	{
		this.exchange = exchange;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getLocalSymbol()
	{
		return localSymbol;
	}

	public void setLocalSymbol(String localSymbol)
	{
		this.localSymbol = localSymbol;
	}

	public String getTradingClass()
	{
		return tradingClass;
	}

	public void setTradingClass(String tradingClass)
	{
		this.tradingClass = tradingClass;
	}

	public Integer getPosition()
	{
		return position;
	}

	public void setPosition(Integer position)
	{
		this.position = position;
	}

	public Double getAvgCost()
	{
		return avgCost;
	}

	public void setAvgCost(Double avgCost)
	{
		this.avgCost = avgCost;
	}

}
