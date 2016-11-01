package com.homaer.fundsrv.dataobject;

import java.math.BigDecimal;

import com.homaer.common.tools.data.Base2String;

public class BrokerInfoDto extends Base2String{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4373768622778416390L;

	private Integer id;

    private String userId;

    private Integer type;

    private String traderAccount;

    private String email;

    private String emailPassword;

    private String userName;

    private String userPassword;

    private String moneyAccount;

    private String moneyArea;

    private String moneyAddress;

    private String moneyBankArea;

    private String moneyBankCity;

    private String moneyBankSwift;

    private String moneyBankAba;

    private String moneyBankName;

    private String moneyBankAddress;

    private String inviteCode;

    private BigDecimal moneyNum;

    private Integer status;

    private String failReason;

    private String customerId;

    private String birthday;

    private Integer isNew;

    private Integer postNum;

    private Integer realPostNum;

    private String createTime;

    private String modifyTime;

    private String verifyTime;

    private String openTime;

    private String moneyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTraderAccount() {
        return traderAccount;
    }

    public void setTraderAccount(String traderAccount) {
        this.traderAccount = traderAccount == null ? null : traderAccount.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword == null ? null : emailPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(String moneyAccount) {
        this.moneyAccount = moneyAccount == null ? null : moneyAccount.trim();
    }

    public String getMoneyArea() {
        return moneyArea;
    }

    public void setMoneyArea(String moneyArea) {
        this.moneyArea = moneyArea == null ? null : moneyArea.trim();
    }

    public String getMoneyAddress() {
        return moneyAddress;
    }

    public void setMoneyAddress(String moneyAddress) {
        this.moneyAddress = moneyAddress == null ? null : moneyAddress.trim();
    }

    public String getMoneyBankArea() {
        return moneyBankArea;
    }

    public void setMoneyBankArea(String moneyBankArea) {
        this.moneyBankArea = moneyBankArea == null ? null : moneyBankArea.trim();
    }

    public String getMoneyBankCity() {
        return moneyBankCity;
    }

    public void setMoneyBankCity(String moneyBankCity) {
        this.moneyBankCity = moneyBankCity == null ? null : moneyBankCity.trim();
    }

    public String getMoneyBankSwift() {
        return moneyBankSwift;
    }

    public void setMoneyBankSwift(String moneyBankSwift) {
        this.moneyBankSwift = moneyBankSwift == null ? null : moneyBankSwift.trim();
    }

    public String getMoneyBankAba() {
        return moneyBankAba;
    }

    public void setMoneyBankAba(String moneyBankAba) {
        this.moneyBankAba = moneyBankAba == null ? null : moneyBankAba.trim();
    }

    public String getMoneyBankName() {
        return moneyBankName;
    }

    public void setMoneyBankName(String moneyBankName) {
        this.moneyBankName = moneyBankName == null ? null : moneyBankName.trim();
    }

    public String getMoneyBankAddress() {
        return moneyBankAddress;
    }

    public void setMoneyBankAddress(String moneyBankAddress) {
        this.moneyBankAddress = moneyBankAddress == null ? null : moneyBankAddress.trim();
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public BigDecimal getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(BigDecimal moneyNum) {
        this.moneyNum = moneyNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    public Integer getRealPostNum() {
        return realPostNum;
    }

    public void setRealPostNum(Integer realPostNum) {
        this.realPostNum = realPostNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime == null ? null : verifyTime.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(String moneyTime) {
        this.moneyTime = moneyTime == null ? null : moneyTime.trim();
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
        BrokerInfoDto other = (BrokerInfoDto) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTraderAccount() == null ? other.getTraderAccount() == null : this.getTraderAccount().equals(other.getTraderAccount()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getEmailPassword() == null ? other.getEmailPassword() == null : this.getEmailPassword().equals(other.getEmailPassword()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getMoneyAccount() == null ? other.getMoneyAccount() == null : this.getMoneyAccount().equals(other.getMoneyAccount()))
            && (this.getMoneyArea() == null ? other.getMoneyArea() == null : this.getMoneyArea().equals(other.getMoneyArea()))
            && (this.getMoneyAddress() == null ? other.getMoneyAddress() == null : this.getMoneyAddress().equals(other.getMoneyAddress()))
            && (this.getMoneyBankArea() == null ? other.getMoneyBankArea() == null : this.getMoneyBankArea().equals(other.getMoneyBankArea()))
            && (this.getMoneyBankCity() == null ? other.getMoneyBankCity() == null : this.getMoneyBankCity().equals(other.getMoneyBankCity()))
            && (this.getMoneyBankSwift() == null ? other.getMoneyBankSwift() == null : this.getMoneyBankSwift().equals(other.getMoneyBankSwift()))
            && (this.getMoneyBankAba() == null ? other.getMoneyBankAba() == null : this.getMoneyBankAba().equals(other.getMoneyBankAba()))
            && (this.getMoneyBankName() == null ? other.getMoneyBankName() == null : this.getMoneyBankName().equals(other.getMoneyBankName()))
            && (this.getMoneyBankAddress() == null ? other.getMoneyBankAddress() == null : this.getMoneyBankAddress().equals(other.getMoneyBankAddress()))
            && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
            && (this.getMoneyNum() == null ? other.getMoneyNum() == null : this.getMoneyNum().equals(other.getMoneyNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFailReason() == null ? other.getFailReason() == null : this.getFailReason().equals(other.getFailReason()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getPostNum() == null ? other.getPostNum() == null : this.getPostNum().equals(other.getPostNum()))
            && (this.getRealPostNum() == null ? other.getRealPostNum() == null : this.getRealPostNum().equals(other.getRealPostNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getVerifyTime() == null ? other.getVerifyTime() == null : this.getVerifyTime().equals(other.getVerifyTime()))
            && (this.getOpenTime() == null ? other.getOpenTime() == null : this.getOpenTime().equals(other.getOpenTime()))
            && (this.getMoneyTime() == null ? other.getMoneyTime() == null : this.getMoneyTime().equals(other.getMoneyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTraderAccount() == null) ? 0 : getTraderAccount().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getEmailPassword() == null) ? 0 : getEmailPassword().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getMoneyAccount() == null) ? 0 : getMoneyAccount().hashCode());
        result = prime * result + ((getMoneyArea() == null) ? 0 : getMoneyArea().hashCode());
        result = prime * result + ((getMoneyAddress() == null) ? 0 : getMoneyAddress().hashCode());
        result = prime * result + ((getMoneyBankArea() == null) ? 0 : getMoneyBankArea().hashCode());
        result = prime * result + ((getMoneyBankCity() == null) ? 0 : getMoneyBankCity().hashCode());
        result = prime * result + ((getMoneyBankSwift() == null) ? 0 : getMoneyBankSwift().hashCode());
        result = prime * result + ((getMoneyBankAba() == null) ? 0 : getMoneyBankAba().hashCode());
        result = prime * result + ((getMoneyBankName() == null) ? 0 : getMoneyBankName().hashCode());
        result = prime * result + ((getMoneyBankAddress() == null) ? 0 : getMoneyBankAddress().hashCode());
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getMoneyNum() == null) ? 0 : getMoneyNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFailReason() == null) ? 0 : getFailReason().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getPostNum() == null) ? 0 : getPostNum().hashCode());
        result = prime * result + ((getRealPostNum() == null) ? 0 : getRealPostNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getVerifyTime() == null) ? 0 : getVerifyTime().hashCode());
        result = prime * result + ((getOpenTime() == null) ? 0 : getOpenTime().hashCode());
        result = prime * result + ((getMoneyTime() == null) ? 0 : getMoneyTime().hashCode());
        return result;
    }
}