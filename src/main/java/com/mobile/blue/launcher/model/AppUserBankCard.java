package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppUserBankCard implements Serializable {
	private static final long serialVersionUID = 8043902199832196240L;

	private Long cardId;

    private String cardNo;

    private String accountName;

    private Byte cardType;

    private String bankCode;

    private String bank;

    private String idCard;

    private Long userId;

    private String link;

    private Long province;

    private Long city;

    public AppUserBankCard(Long cardId, String cardNo, String accountName, Byte cardType, String bankCode, String bank, String idCard, Long userId, String link, Long province, Long city) {
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.accountName = accountName;
        this.cardType = cardType;
        this.bankCode = bankCode;
        this.bank = bank;
        this.idCard = idCard;
        this.userId = userId;
        this.link = link;
        this.province = province;
        this.city = city;
    }

    public AppUserBankCard() {
        super();
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Byte getCardType() {
        return cardType;
    }

    public void setCardType(Byte cardType) {
        this.cardType = cardType;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}