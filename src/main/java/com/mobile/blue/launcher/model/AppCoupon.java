package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppCoupon implements Serializable {
	private static final long serialVersionUID = 3776000607937951778L;

	private Long myCouponId;

    private String couponName;

    private BigDecimal couponMoney;

    private Long couponId;

    private Date beginTime;

    private Date endTime;

    private String couponCode;

    private Long relationId;

    private Byte relationType;

    private Long userId;

    private String couponImg;

    private Byte status;

    private Date lastUseTime;

    private BigDecimal canUseMoney;

    private Date ctime;

    private String remark;

    public AppCoupon(Long myCouponId, String couponName, BigDecimal couponMoney, Long couponId, Date beginTime, Date endTime, String couponCode, Long relationId, Byte relationType, Long userId, String couponImg, Byte status, Date lastUseTime, BigDecimal canUseMoney, Date ctime, String remark) {
        this.myCouponId = myCouponId;
        this.couponName = couponName;
        this.couponMoney = couponMoney;
        this.couponId = couponId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.couponCode = couponCode;
        this.relationId = relationId;
        this.relationType = relationType;
        this.userId = userId;
        this.couponImg = couponImg;
        this.status = status;
        this.lastUseTime = lastUseTime;
        this.canUseMoney = canUseMoney;
        this.ctime = ctime;
        this.remark = remark;
    }

    public AppCoupon() {
        super();
    }

    public Long getMyCouponId() {
        return myCouponId;
    }

    public void setMyCouponId(Long myCouponId) {
        this.myCouponId = myCouponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Byte getRelationType() {
        return relationType;
    }

    public void setRelationType(Byte relationType) {
        this.relationType = relationType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCouponImg() {
        return couponImg;
    }

    public void setCouponImg(String couponImg) {
        this.couponImg = couponImg == null ? null : couponImg.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Date lastUseTime) {
        this.lastUseTime = lastUseTime;
    }

    public BigDecimal getCanUseMoney() {
        return canUseMoney;
    }

    public void setCanUseMoney(BigDecimal canUseMoney) {
        this.canUseMoney = canUseMoney;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}