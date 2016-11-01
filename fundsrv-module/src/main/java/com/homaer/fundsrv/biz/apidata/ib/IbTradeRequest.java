package com.homaer.fundsrv.biz.apidata.ib;

import com.homaer.biz.framework.api.ApiRequest;

public class IbTradeRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 证券代码
	 */
	private String symbol;
	
	/**
	 * 证券类型:STK;OPT;FUT;IND;FOP;CASH;BAG
	 */
	private String secType;
	
	/**
	 * 过期日:使用格式 YYYYMM
	 */
	private String expiry;
	
	/**
	 * 订单交易所
	 */
	private String exchange;
	
	/**
	 * 交易币种
	 */
	private String currency;
	
	/**
	 * 订单动作 1-买; 2-卖
	 */
	private int actionIndex = 1;

	/**
	 * 订单数量
	 */
	private int totalQuantity;
	
	/**
	 * 确认定单类型，例如："LMT",详情请看IB “支持的定单类型” 部分
	 */
	private String orderType;
	
	private float lmtPrice;
	private String account;

	

	

	

	

	

	

	

	public int getActionIndex() {
		return actionIndex;
	}

	public void setActionIndex(int actionIndex) {
		this.actionIndex = actionIndex;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getSecType() {
		return secType;
	}

	public void setSecType(String secType) {
		this.secType = secType;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public float getLmtPrice() {
		return lmtPrice;
	}

	public void setLmtPrice(float lmtPrice) {
		this.lmtPrice = lmtPrice;
	}
}