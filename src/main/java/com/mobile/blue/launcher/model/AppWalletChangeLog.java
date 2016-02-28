package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppWalletChangeLog implements Serializable {
	private static final long serialVersionUID = -8702029705391805565L;

	private Long walletChangeId;

    private Long walletId;

    private Long userId;

    private BigDecimal beforeMoney;

    private BigDecimal changeMoney;

    private BigDecimal afterMoney;

    private Byte changeType;

    private Date changeTime;

    private Long relationId;

    private Byte relationType;

    public AppWalletChangeLog(Long walletChangeId, Long walletId, Long userId, BigDecimal beforeMoney, BigDecimal changeMoney, BigDecimal afterMoney, Byte changeType, Date changeTime, Long relationId, Byte relationType) {
        this.walletChangeId = walletChangeId;
        this.walletId = walletId;
        this.userId = userId;
        this.beforeMoney = beforeMoney;
        this.changeMoney = changeMoney;
        this.afterMoney = afterMoney;
        this.changeType = changeType;
        this.changeTime = changeTime;
        this.relationId = relationId;
        this.relationType = relationType;
    }

    public AppWalletChangeLog() {
        super();
    }

    public Long getWalletChangeId() {
        return walletChangeId;
    }

    public void setWalletChangeId(Long walletChangeId) {
        this.walletChangeId = walletChangeId;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBeforeMoney() {
        return beforeMoney;
    }

    public void setBeforeMoney(BigDecimal beforeMoney) {
        this.beforeMoney = beforeMoney;
    }

    public BigDecimal getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(BigDecimal changeMoney) {
        this.changeMoney = changeMoney;
    }

    public BigDecimal getAfterMoney() {
        return afterMoney;
    }

    public void setAfterMoney(BigDecimal afterMoney) {
        this.afterMoney = afterMoney;
    }

    public Byte getChangeType() {
        return changeType;
    }

    public void setChangeType(Byte changeType) {
        this.changeType = changeType;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
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
}