package com.homaer.fundsrv.dataobject;

import java.math.BigDecimal;

public class UserStockLogDto {
    private Long logId;

    private Long userStockId;

    private String userId;

    private String fundAct;

    private String opactid;

    private String type;

    private BigDecimal stockMoney;

    private String currency;

    private BigDecimal remainder;

    private BigDecimal fundAmount;

    private BigDecimal buyPrice;

    private BigDecimal sellPrice;

    private Integer opstatus;

    private String payDate;

    private Integer readStatus;

    private String gmtDate;

    private String gmtModify;

    private String gmtSuccess;

    private String gmtFail;

    private Integer state;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getUserStockId() {
        return userStockId;
    }

    public void setUserStockId(Long userStockId) {
        this.userStockId = userStockId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFundAct() {
        return fundAct;
    }

    public void setFundAct(String fundAct) {
        this.fundAct = fundAct == null ? null : fundAct.trim();
    }

    public String getOpactid() {
        return opactid;
    }

    public void setOpactid(String opactid) {
        this.opactid = opactid == null ? null : opactid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getStockMoney() {
        return stockMoney;
    }

    public void setStockMoney(BigDecimal stockMoney) {
        this.stockMoney = stockMoney;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getRemainder() {
        return remainder;
    }

    public void setRemainder(BigDecimal remainder) {
        this.remainder = remainder;
    }

    public BigDecimal getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(BigDecimal fundAmount) {
        this.fundAmount = fundAmount;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getOpstatus() {
        return opstatus;
    }

    public void setOpstatus(Integer opstatus) {
        this.opstatus = opstatus;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getGmtDate() {
        return gmtDate;
    }

    public void setGmtDate(String gmtDate) {
        this.gmtDate = gmtDate == null ? null : gmtDate.trim();
    }

    public String getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify == null ? null : gmtModify.trim();
    }

    public String getGmtSuccess() {
        return gmtSuccess;
    }

    public void setGmtSuccess(String gmtSuccess) {
        this.gmtSuccess = gmtSuccess == null ? null : gmtSuccess.trim();
    }

    public String getGmtFail() {
        return gmtFail;
    }

    public void setGmtFail(String gmtFail) {
        this.gmtFail = gmtFail == null ? null : gmtFail.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        UserStockLogDto other = (UserStockLogDto) that;
        return (this.getLogId() == null ? other.getLogId() == null : this.getLogId().equals(other.getLogId()))
            && (this.getUserStockId() == null ? other.getUserStockId() == null : this.getUserStockId().equals(other.getUserStockId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFundAct() == null ? other.getFundAct() == null : this.getFundAct().equals(other.getFundAct()))
            && (this.getOpactid() == null ? other.getOpactid() == null : this.getOpactid().equals(other.getOpactid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStockMoney() == null ? other.getStockMoney() == null : this.getStockMoney().equals(other.getStockMoney()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getRemainder() == null ? other.getRemainder() == null : this.getRemainder().equals(other.getRemainder()))
            && (this.getFundAmount() == null ? other.getFundAmount() == null : this.getFundAmount().equals(other.getFundAmount()))
            && (this.getBuyPrice() == null ? other.getBuyPrice() == null : this.getBuyPrice().equals(other.getBuyPrice()))
            && (this.getSellPrice() == null ? other.getSellPrice() == null : this.getSellPrice().equals(other.getSellPrice()))
            && (this.getOpstatus() == null ? other.getOpstatus() == null : this.getOpstatus().equals(other.getOpstatus()))
            && (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
            && (this.getReadStatus() == null ? other.getReadStatus() == null : this.getReadStatus().equals(other.getReadStatus()))
            && (this.getGmtDate() == null ? other.getGmtDate() == null : this.getGmtDate().equals(other.getGmtDate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getGmtSuccess() == null ? other.getGmtSuccess() == null : this.getGmtSuccess().equals(other.getGmtSuccess()))
            && (this.getGmtFail() == null ? other.getGmtFail() == null : this.getGmtFail().equals(other.getGmtFail()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId() == null) ? 0 : getLogId().hashCode());
        result = prime * result + ((getUserStockId() == null) ? 0 : getUserStockId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFundAct() == null) ? 0 : getFundAct().hashCode());
        result = prime * result + ((getOpactid() == null) ? 0 : getOpactid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStockMoney() == null) ? 0 : getStockMoney().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getRemainder() == null) ? 0 : getRemainder().hashCode());
        result = prime * result + ((getFundAmount() == null) ? 0 : getFundAmount().hashCode());
        result = prime * result + ((getBuyPrice() == null) ? 0 : getBuyPrice().hashCode());
        result = prime * result + ((getSellPrice() == null) ? 0 : getSellPrice().hashCode());
        result = prime * result + ((getOpstatus() == null) ? 0 : getOpstatus().hashCode());
        result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
        result = prime * result + ((getReadStatus() == null) ? 0 : getReadStatus().hashCode());
        result = prime * result + ((getGmtDate() == null) ? 0 : getGmtDate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getGmtSuccess() == null) ? 0 : getGmtSuccess().hashCode());
        result = prime * result + ((getGmtFail() == null) ? 0 : getGmtFail().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}