package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppPresentFreinds implements Serializable {
    private Long presentId;

    private Long presentUserId;

    private String presentUser;

    private Long presentedUserId;

    private String presentedUser;

    private Integer presentNum;

    private BigDecimal price;

    private BigDecimal totalMoney;

    private Date ctime;

    private Byte type;

    private Long presentRelationId;

    private Long presentedRelationId;

    private static final long serialVersionUID = 1L;

    public AppPresentFreinds(Long presentId, Long presentUserId, String presentUser, Long presentedUserId, String presentedUser, Integer presentNum, BigDecimal price, BigDecimal totalMoney, Date ctime, Byte type, Long presentRelationId, Long presentedRelationId) {
        this.presentId = presentId;
        this.presentUserId = presentUserId;
        this.presentUser = presentUser;
        this.presentedUserId = presentedUserId;
        this.presentedUser = presentedUser;
        this.presentNum = presentNum;
        this.price = price;
        this.totalMoney = totalMoney;
        this.ctime = ctime;
        this.type = type;
        this.presentRelationId = presentRelationId;
        this.presentedRelationId = presentedRelationId;
    }

    public AppPresentFreinds() {
        super();
    }

    public Long getPresentId() {
        return presentId;
    }

    public void setPresentId(Long presentId) {
        this.presentId = presentId;
    }

    public Long getPresentUserId() {
        return presentUserId;
    }

    public void setPresentUserId(Long presentUserId) {
        this.presentUserId = presentUserId;
    }

    public String getPresentUser() {
        return presentUser;
    }

    public void setPresentUser(String presentUser) {
        this.presentUser = presentUser == null ? null : presentUser.trim();
    }

    public Long getPresentedUserId() {
        return presentedUserId;
    }

    public void setPresentedUserId(Long presentedUserId) {
        this.presentedUserId = presentedUserId;
    }

    public String getPresentedUser() {
        return presentedUser;
    }

    public void setPresentedUser(String presentedUser) {
        this.presentedUser = presentedUser == null ? null : presentedUser.trim();
    }

    public Integer getPresentNum() {
        return presentNum;
    }

    public void setPresentNum(Integer presentNum) {
        this.presentNum = presentNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getPresentRelationId() {
        return presentRelationId;
    }

    public void setPresentRelationId(Long presentRelationId) {
        this.presentRelationId = presentRelationId;
    }

    public Long getPresentedRelationId() {
        return presentedRelationId;
    }

    public void setPresentedRelationId(Long presentedRelationId) {
        this.presentedRelationId = presentedRelationId;
    }
}