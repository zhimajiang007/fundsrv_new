package com.homaer.fundsrv.dataobject;

public class FundUserDto {
    private Long id;

    private String userId;

    private Integer type;

    private String fundUser;

    private String fundUsername;

    private Integer status;

    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFundUser() {
        return fundUser;
    }

    public void setFundUser(String fundUser) {
        this.fundUser = fundUser == null ? null : fundUser.trim();
    }

    public String getFundUsername() {
        return fundUsername;
    }

    public void setFundUsername(String fundUsername) {
        this.fundUsername = fundUsername == null ? null : fundUsername.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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
        FundUserDto other = (FundUserDto) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFundUser() == null ? other.getFundUser() == null : this.getFundUser().equals(other.getFundUser()))
            && (this.getFundUsername() == null ? other.getFundUsername() == null : this.getFundUsername().equals(other.getFundUsername()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFundUser() == null) ? 0 : getFundUser().hashCode());
        result = prime * result + ((getFundUsername() == null) ? 0 : getFundUsername().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}