package com.homaer.fundsrv.module.ib;

import java.util.Date;


public class BrokerOrder implements java.io.Serializable{
	
	private static final long serialVersionUID = -3004057369035172411L;
	// 订单操作--买
	public static final Integer ACTIONINDEX_BOT = 1;
	// 订单操作--卖
	public static final Integer ACTIONINDEX_SLD = 2;
	
	private Integer orderId;
	
	private String userId;
	
	private int clientId;
	
	private int permId;
	// 股票代码
    private String symbol;
    // 资金账户
    private String account;
    // 数量
    private Integer totalQuantity;
    // 价格--市价单委托价格为0.0
    private Double limitPrice;

    private Float percentOfAccount;

    private Float stopPercent;

    private Long closeByDate;

    private Integer numContracts;

    private String sentTime;

    private Date closed;
    
    private Double openingPrice;
    private Double closingPrice;
    private Double realizedPnl;

	private String exchange = "SMART";
	private String type = "STK";
	private String currency = "USD";
	
	private Integer parantId;
	
	// 有效期--DAY,当日有效；GTC,永久有效
	private String timeForce;
    // 订单操作--1,买；2,卖
	private Integer action;
	// 订单完成时间--仅记录分段成交最后一笔的时间
	private String finishTime;
		
	// 订单状态标识--
/*	已完成交易的操作状态
	BOT:买入
	SLD:卖出
	已提交交易的操作状态
	BUY:买入
	SELL:卖出*/
	private String actionIndex;
	// 订单状态 status=Submitted 提交已订单；status=Cancelled 已取消订单；Filled 已完成交易 ；PendingSubmit
	// PreSubmitted订单被持有和监控；PendingCancel;Inactive,被系统取消，没有交易许可，交易要求-----可能是账户没钱
	private String status;
	// LMT(限价单) or MKT(市价单)
	private String orderType;
	// 已完成交易数量---filled + remaining = totalQuantity
	private Integer filled;
	// 剩余未完成交易数量---filled + remaining = totalQuantity
	private Integer remaining;
	// 平均成交价格
	private String avgFillPrice;
	// 最后一次成交价格--分N段成交，N>=1
	private String lastFillPrice;
	// 订单佣金
	private String commission;
	
	// 以下为显示描述
	private String actionIndexDescribe; // 交易操作描述--买入/卖出
	
	private String orderTypeDescribe; // 订单类型描述--限价委托/市价委托
	
	private String totalQuantityDescribe; // 显示数量
	
	private String statusDescribe;// 订单状态--已完成/未完成/撤销
	
	private String timeDescribe;// 显示时间
	
	private String priceDescribe;// 显示价格
	
	private String orderDescribe; // 订单描述--委托已提交/等待成交
	
	public String getOrderDescribe() {
		return orderDescribe;
	}

	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}

	public String getTimeDescribe() {
		return timeDescribe;
	}

	public void setTimeDescribe(String timeDescribe) {
		this.timeDescribe = timeDescribe;
	}

	public String getPriceDescribe() {
		return priceDescribe;
	}

	public void setPriceDescribe(String priceDescribe) {
		this.priceDescribe = priceDescribe;
	}

	public String getActionIndexDescribe() {
		return actionIndexDescribe;
	}

	public void setActionIndexDescribe(String actionIndexDescribe) {
		this.actionIndexDescribe = actionIndexDescribe;
	}

	public String getOrderTypeDescribe() {
		return orderTypeDescribe;
	}

	public void setOrderTypeDescribe(String orderTypeDescribe) {
		this.orderTypeDescribe = orderTypeDescribe;
	}

	public String getTotalQuantityDescribe() {
		return totalQuantityDescribe;
	}

	public void setTotalQuantityDescribe(String totalQuantityDescribe) {
		this.totalQuantityDescribe = totalQuantityDescribe;
	}

	public String getStatusDescribe() {
		return statusDescribe;
	}

	public void setStatusDescribe(String statusDescribe) {
		this.statusDescribe = statusDescribe;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public Integer getFilled() {
		return filled;
	}

	public void setFilled(Integer filled) {
		this.filled = filled;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	public String getAvgFillPrice() {
		return avgFillPrice;
	}

	public void setAvgFillPrice(String avgFillPrice) {
		this.avgFillPrice = avgFillPrice;
	}

	public String getLastFillPrice() {
		return lastFillPrice;
	}

	public void setLastFillPrice(String lastFillPrice) {
		this.lastFillPrice = lastFillPrice;
	}

	public String getOrderType()
	{
		return orderType;
	}

	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getPermId() {
		return permId;
	}

	public void setPermId(int permId) {
		this.permId = permId;
	}

	public String getActionIndex() {
		return actionIndex;
	}

	public void setActionIndex(String actionIndex) {
		this.actionIndex = actionIndex;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public String getTimeForce() {
		return timeForce;
	}

	public void setTimeForce(String timeForce) {
		this.timeForce = timeForce;
	}
	
	public Integer getParantId() {
		return parantId;
	}
	public void setParantId(Integer parantId) {
		this.parantId = parantId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Float getPercentOfAccount() {
		return percentOfAccount;
	}
	public void setPercentOfAccount(Float percentOfAccount) {
		this.percentOfAccount = percentOfAccount;
	}
	public Float getStopPercent() {
		return stopPercent;
	}
	public void setStopPercent(Float stopPercent) {
		this.stopPercent = stopPercent;
	}
	public Long getCloseByDate() {
		return closeByDate;
	}
	public void setCloseByDate(Long closeByDate) {
		this.closeByDate = closeByDate;
	}
	public Integer getNumContracts() {
		return numContracts;
	}
	public void setNumContracts(Integer numContracts) {
		this.numContracts = numContracts;
	}
	
	public String getSentTime() {
		return sentTime;
	}

	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}

	public Date getClosed() {
		return closed;
	}
	public void setClosed(Date closed) {
		this.closed = closed;
	}
	public Double getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(Double openingPrice) {
		this.openingPrice = openingPrice;
	}
	public Double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(Double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public Double getRealizedPnl() {
		return realizedPnl;
	}
	public void setRealizedPnl(Double realizedPnl) {
		this.realizedPnl = realizedPnl;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Double getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(Double limitPrice) {
		this.limitPrice = limitPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
