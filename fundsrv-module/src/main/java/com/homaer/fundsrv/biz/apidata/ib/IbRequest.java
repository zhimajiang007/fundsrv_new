package com.homaer.fundsrv.biz.apidata.ib;

import com.homaer.biz.framework.api.ApiRequest;

public class IbRequest extends ApiRequest {


	/**
	 * 
	 * 2016年3月14日
	 * @author changhai.wang
	 */
	private static final long serialVersionUID = 6295600082285471450L;

	/**
	 * 订单动作 1-买; 2-卖
	 */
	private int actionIndex = 1;

	private int orderId;

	private String symbol;

	private int totalQuantity;

	private String secType;

	private String expiry;

	private String exchange;

	private String currency;

	private String orderType;

	private String lmtPrice;
	
	// 有效期--0224，wch		DAY,当日有效；GTC,永久有效
	private String timeForce;
	
	private int isState; // 1,买入操作;2,卖出操作，查询持仓
	
	public int getIsState()
	{
		return isState;
	}

	public void setIsState(int isState)
	{
		this.isState = isState;
	}

	public String getTimeForce() {
		return timeForce;
	}

	public void setTimeForce(String timeForce) {
		this.timeForce = timeForce;
	}

	public int getActionIndex() {
		return actionIndex;
	}

	public void setActionIndex(int actionIndex) {
		this.actionIndex = actionIndex;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public String getLmtPrice() {
		return lmtPrice;
	}

	public void setLmtPrice(String lmtPrice) {
		this.lmtPrice = lmtPrice;
	}	
}