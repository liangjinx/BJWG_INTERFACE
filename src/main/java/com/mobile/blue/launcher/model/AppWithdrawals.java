package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppWithdrawals implements Serializable{
	private static final long serialVersionUID = -636713715485850519L;

	private Long withwradalsId;

    private BigDecimal money;

    private Date ctime;

    private String accountName;

    private String bankCode;

    private String bank;

    private String idCard;

    private Long userId;

    private String username;

    private Byte status;

    private String auditingMan;

    private Long auditingManId;

    private Date auditingTime;

    private String remark;

    private Long walletId;

    private Long cardId;

    private Byte cardType;

    public AppWithdrawals(Long withwradalsId, BigDecimal money, Date ctime, String accountName, String bankCode, String bank, String idCard, Long userId, String username, Byte status, String auditingMan, Long auditingManId, Date auditingTime, String remark, Long walletId, Long cardId, Byte cardType) {
        this.withwradalsId = withwradalsId;
        this.money = money;
        this.ctime = ctime;
        this.accountName = accountName;
        this.bankCode = bankCode;
        this.bank = bank;
        this.idCard = idCard;
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.auditingMan = auditingMan;
        this.auditingManId = auditingManId;
        this.auditingTime = auditingTime;
        this.remark = remark;
        this.walletId = walletId;
        this.cardId = cardId;
        this.cardType = cardType;
    }

    public AppWithdrawals() {
        super();
    }

    public Long getWithwradalsId() {
        return withwradalsId;
    }

    public void setWithwradalsId(Long withwradalsId) {
        this.withwradalsId = withwradalsId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAuditingMan() {
        return auditingMan;
    }

    public void setAuditingMan(String auditingMan) {
        this.auditingMan = auditingMan == null ? null : auditingMan.trim();
    }

    public Long getAuditingManId() {
        return auditingManId;
    }

    public void setAuditingManId(Long auditingManId) {
        this.auditingManId = auditingManId;
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Byte getCardType() {
        return cardType;
    }

    public void setCardType(Byte cardType) {
        this.cardType = cardType;
    }

}