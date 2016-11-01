package com.homaer.fundsrv.module.ib;

public class AccountValue {

	/** 账户值类型   CashBalance - 账户现金余额    DayTradesRemaining - 剩余交易日     EquityWithLoanValue - 含借贷值股权    InitMarginReq - 当前初始保证金要求     MaintMarginReq - 当前维持保证金   NetLiquidation - 净清算值*/
	private String key;
	
	/** 与标签相关的值 */
	private String value;
	
	/** 货币类型  */
	private String currency;
	
	/** 说明信息应用的账户。适用于金融顾问子账户信息 */
	private String accountName;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
