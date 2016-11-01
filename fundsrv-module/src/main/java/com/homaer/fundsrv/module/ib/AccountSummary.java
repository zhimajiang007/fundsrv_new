package com.homaer.fundsrv.module.ib;

public class AccountSummary {

	/** 数据请求的代号 */
	private int    reqId; 
	
	/** 账户代号 */
	private String account;
	
	/** 数据请求标签 */
	private String tag;
	
	/** 标签值 */
	private String value;
	
	/** 标签货币 */
	private String currency;

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
}
