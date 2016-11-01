package com.homaer.fundsrv.dataobject;

import com.homaer.common.tools.data.Base2String;

public class BrokerOrderDto extends Base2String {
    /**
	 * 
	 */
	private static final long serialVersionUID = -657183481128380960L;

	private String orderId;

    private String clientid;

    private Integer permid;

    private String symbol;

    private String account;

    private Integer totalquantity;

    private Double limitprice;

    private String sentTime;

    private String timeForce;

    private Integer action;

    private String finishTime;

    private String actionIndex;

    private String status;

    private String orderType;

    private String createTime;

    private Integer filled;

    private Integer remaining;

    private String avgFillPrice;

    private String lastFillPrice;

    private String commission;

    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public Integer getPermid() {
        return permid;
    }

    public void setPermid(Integer permid) {
        this.permid = permid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(Integer totalquantity) {
        this.totalquantity = totalquantity;
    }

    public Double getLimitprice() {
        return limitprice;
    }

    public void setLimitprice(Double limitprice) {
        this.limitprice = limitprice;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime == null ? null : sentTime.trim();
    }

    public String getTimeForce() {
        return timeForce;
    }

    public void setTimeForce(String timeForce) {
        this.timeForce = timeForce == null ? null : timeForce.trim();
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public String getActionIndex() {
        return actionIndex;
    }

    public void setActionIndex(String actionIndex) {
        this.actionIndex = actionIndex == null ? null : actionIndex.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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
        this.avgFillPrice = avgFillPrice == null ? null : avgFillPrice.trim();
    }

    public String getLastFillPrice() {
        return lastFillPrice;
    }

    public void setLastFillPrice(String lastFillPrice) {
        this.lastFillPrice = lastFillPrice == null ? null : lastFillPrice.trim();
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission == null ? null : commission.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BrokerOrderDto other = (BrokerOrderDto) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getClientid() == null ? other.getClientid() == null : this.getClientid().equals(other.getClientid()))
            && (this.getPermid() == null ? other.getPermid() == null : this.getPermid().equals(other.getPermid()))
            && (this.getSymbol() == null ? other.getSymbol() == null : this.getSymbol().equals(other.getSymbol()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getTotalquantity() == null ? other.getTotalquantity() == null : this.getTotalquantity().equals(other.getTotalquantity()))
            && (this.getLimitprice() == null ? other.getLimitprice() == null : this.getLimitprice().equals(other.getLimitprice()))
            && (this.getSentTime() == null ? other.getSentTime() == null : this.getSentTime().equals(other.getSentTime()))
            && (this.getTimeForce() == null ? other.getTimeForce() == null : this.getTimeForce().equals(other.getTimeForce()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getActionIndex() == null ? other.getActionIndex() == null : this.getActionIndex().equals(other.getActionIndex()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFilled() == null ? other.getFilled() == null : this.getFilled().equals(other.getFilled()))
            && (this.getRemaining() == null ? other.getRemaining() == null : this.getRemaining().equals(other.getRemaining()))
            && (this.getAvgFillPrice() == null ? other.getAvgFillPrice() == null : this.getAvgFillPrice().equals(other.getAvgFillPrice()))
            && (this.getLastFillPrice() == null ? other.getLastFillPrice() == null : this.getLastFillPrice().equals(other.getLastFillPrice()))
            && (this.getCommission() == null ? other.getCommission() == null : this.getCommission().equals(other.getCommission()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getClientid() == null) ? 0 : getClientid().hashCode());
        result = prime * result + ((getPermid() == null) ? 0 : getPermid().hashCode());
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getTotalquantity() == null) ? 0 : getTotalquantity().hashCode());
        result = prime * result + ((getLimitprice() == null) ? 0 : getLimitprice().hashCode());
        result = prime * result + ((getSentTime() == null) ? 0 : getSentTime().hashCode());
        result = prime * result + ((getTimeForce() == null) ? 0 : getTimeForce().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getActionIndex() == null) ? 0 : getActionIndex().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFilled() == null) ? 0 : getFilled().hashCode());
        result = prime * result + ((getRemaining() == null) ? 0 : getRemaining().hashCode());
        result = prime * result + ((getAvgFillPrice() == null) ? 0 : getAvgFillPrice().hashCode());
        result = prime * result + ((getLastFillPrice() == null) ? 0 : getLastFillPrice().hashCode());
        result = prime * result + ((getCommission() == null) ? 0 : getCommission().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}