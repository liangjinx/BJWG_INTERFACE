package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppMyEarnings implements Serializable {
	private static final long serialVersionUID = -6835162770750942200L;

	private Long earningsId;

    private Long userId;

    private Integer num;

    private BigDecimal rate;

    private Date beginTime;

    private Integer days;

    private Date endTime;

    private BigDecimal money;

    private BigDecimal expectEarning;

    private Long paincbuyProjectId;

    private String paincbuyProjectName;

    private Integer presentNum;

    private Byte dealType;

    private Byte dealStatus;

    private Date dealTime;

    private Date overTime;

    private Integer overDays;

    private String remark;

    private Byte beforeDealType;

    public AppMyEarnings(Long earningsId, Long userId, Integer num, BigDecimal rate, Date beginTime, Integer days, Date endTime, BigDecimal money, BigDecimal expectEarning, Long paincbuyProjectId, String paincbuyProjectName, Integer presentNum, Byte dealType, Byte dealStatus, Date dealTime, Date overTime, Integer overDays, String remark, Byte beforeDealType) {
        this.earningsId = earningsId;
        this.userId = userId;
        this.num = num;
        this.rate = rate;
        this.beginTime = beginTime;
        this.days = days;
        this.endTime = endTime;
        this.money = money;
        this.expectEarning = expectEarning;
        this.paincbuyProjectId = paincbuyProjectId;
        this.paincbuyProjectName = paincbuyProjectName;
        this.presentNum = presentNum;
        this.dealType = dealType;
        this.dealStatus = dealStatus;
        this.dealTime = dealTime;
        this.overTime = overTime;
        this.overDays = overDays;
        this.remark = remark;
        this.beforeDealType = beforeDealType;
    }

    public AppMyEarnings() {
        super();
    }

    public Long getEarningsId() {
        return earningsId;
    }

    public void setEarningsId(Long earningsId) {
        this.earningsId = earningsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getExpectEarning() {
        return expectEarning;
    }

    public void setExpectEarning(BigDecimal expectEarning) {
        this.expectEarning = expectEarning;
    }

    public Long getPaincbuyProjectId() {
        return paincbuyProjectId;
    }

    public void setPaincbuyProjectId(Long paincbuyProjectId) {
        this.paincbuyProjectId = paincbuyProjectId;
    }

    public String getPaincbuyProjectName() {
        return paincbuyProjectName;
    }

    public void setPaincbuyProjectName(String paincbuyProjectName) {
        this.paincbuyProjectName = paincbuyProjectName == null ? null : paincbuyProjectName.trim();
    }

    public Integer getPresentNum() {
        return presentNum;
    }

    public void setPresentNum(Integer presentNum) {
        this.presentNum = presentNum;
    }

    public Byte getDealType() {
        return dealType;
    }

    public void setDealType(Byte dealType) {
        this.dealType = dealType;
    }

    public Byte getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Integer getOverDays() {
        return overDays;
    }

    public void setOverDays(Integer overDays) {
        this.overDays = overDays;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getBeforeDealType() {
        return beforeDealType;
    }

    public void setBeforeDealType(Byte beforeDealType) {
        this.beforeDealType = beforeDealType;
    }
}