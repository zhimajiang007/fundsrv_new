package com.homaer.fundsrv.dataobject;

import java.util.Date;

public class JpushDeviceDto {
    private String registrationId;

    private String deviceToken;

    private String userId;

    private String osType;

    private Date gmtCreate;

    private Date gmtModified;
    
    private String actionIndex;

    public String getActionIndex() {
		return actionIndex;
	}

	public void setActionIndex(String actionIndex) {
		this.actionIndex = actionIndex;
	}

	public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId == null ? null : registrationId.trim();
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken == null ? null : deviceToken.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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
        JpushDeviceDto other = (JpushDeviceDto) that;
        return (this.getRegistrationId() == null ? other.getRegistrationId() == null : this.getRegistrationId().equals(other.getRegistrationId()))
            && (this.getDeviceToken() == null ? other.getDeviceToken() == null : this.getDeviceToken().equals(other.getDeviceToken()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOsType() == null ? other.getOsType() == null : this.getOsType().equals(other.getOsType()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegistrationId() == null) ? 0 : getRegistrationId().hashCode());
        result = prime * result + ((getDeviceToken() == null) ? 0 : getDeviceToken().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOsType() == null) ? 0 : getOsType().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }
}