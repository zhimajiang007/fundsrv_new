package com.homaer.fundsrv.module.ib;

/**
 * 账户资产详情。
 * 
 * 2016年3月8日
 * @author changhai.wang
 */
public class MarketData implements java.io.Serializable{

	private static final long serialVersionUID = 8280970571059347988L;
	
	private String account;
	// 账户总资金，可用资金+股票市值
	private String netLiquidationByCurrency;
	// 账户未实现盈亏额
	private String unrealizedPnl;
	// 账户以实现盈亏额
	private String realizedPnl;
	// 可用资金(包括委托中的订单价值)
	private String cashBalance;
	
	private String currency;
	
	// 股票市值
	private String stockMarketValue;	
	// 账户初始资金
	private String accountInitial;
	// 账户股票涨跌额
	private String accountRiseFallCost;
	// 账户股票涨跌百分比
	private String accountRiseFall;
	
	/**
	 * 可用资金，不包含委托中冻结资金
	 */
	private String expendableCash;
	private String totalCashBalance;
	
	private String accruedCash;

	private String optionMarketValue;
	
	private String futureOptionValue;
	private String futuresPNL;
	
	private String exchangeRate;
	private String fundValue;
	
	private String needFresh; // 是否需要刷新，0：不需要刷新；1，需要刷新
	
	public String getNeedFresh() {
		return needFresh;
	}
	public void setNeedFresh(String needFresh) {
		this.needFresh = needFresh;
	}
	public String getRealizedPnl() {
		return realizedPnl;
	}
	public void setRealizedPnl(String realizedPnl) {
		this.realizedPnl = realizedPnl;
	}
	public String getExpendableCash()
	{
		return expendableCash;
	}
	public void setExpendableCash(String expendableCash)
	{
		this.expendableCash = expendableCash;
	}
	public String getFutureOptionValue()
	{
		return futureOptionValue;
	}
	public void setFutureOptionValue(String futureOptionValue)
	{
		this.futureOptionValue = futureOptionValue;
	}
	public String getFuturesPNL()
	{
		return futuresPNL;
	}
	public void setFuturesPNL(String futuresPNL)
	{
		this.futuresPNL = futuresPNL;
	}

	public String getUnrealizedPnl() {
		return unrealizedPnl;
	}
	public void setUnrealizedPnl(String unrealizedPnl) {
		this.unrealizedPnl = unrealizedPnl;
	}
	
	public String getExchangeRate()
	{
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate)
	{
		this.exchangeRate = exchangeRate;
	}
	public String getFundValue()
	{
		return fundValue;
	}
	public void setFundValue(String fundValue)
	{
		this.fundValue = fundValue;
	}

	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getCurrency()
	{
		return currency;
	}
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}
	public String getNetLiquidationByCurrency()
	{
		return netLiquidationByCurrency;
	}
	public void setNetLiquidationByCurrency(String netLiquidationByCurrency)
	{
		this.netLiquidationByCurrency = netLiquidationByCurrency;
	}
	public String getCashBalance()
	{
		return cashBalance;
	}
	public void setCashBalance(String cashBalance)
	{
		this.cashBalance = cashBalance;
	}
	public String getTotalCashBalance()
	{
		return totalCashBalance;
	}
	public void setTotalCashBalance(String totalCashBalance)
	{
		this.totalCashBalance = totalCashBalance;
	}
	public String getAccruedCash()
	{
		return accruedCash;
	}
	public void setAccruedCash(String accruedCash)
	{
		this.accruedCash = accruedCash;
	}
	public String getStockMarketValue()
	{
		return stockMarketValue;
	}
	public void setStockMarketValue(String stockMarketValue)
	{
		this.stockMarketValue = stockMarketValue;
	}
	public String getOptionMarketValue()
	{
		return optionMarketValue;
	}
	public void setOptionMarketValue(String optionMarketValue)
	{
		this.optionMarketValue = optionMarketValue;
	}
	public String getAccountInitial() {
		return accountInitial;
	}
	public void setAccountInitial(String accountInitial) {
		this.accountInitial = accountInitial;
	}
	public String getAccountRiseFallCost() {
		return accountRiseFallCost;
	}
	public void setAccountRiseFallCost(String accountRiseFallCost) {
		this.accountRiseFallCost = accountRiseFallCost;
	}
	public String getAccountRiseFall() {
		return accountRiseFall;
	}
	public void setAccountRiseFall(String accountRiseFall) {
		this.accountRiseFall = accountRiseFall;
	}
	
}
