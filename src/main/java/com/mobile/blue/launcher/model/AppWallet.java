package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AppWallet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2248430864452219949L;

	private Long walletId;

    private Long userId;

    private BigDecimal money;

    private Byte status;

    private String payPassword;

    private String json;

    public AppWallet(Long walletId, Long userId, BigDecimal money, Byte status, String payPassword, String json) {
        this.walletId = walletId;
        this.userId = userId;
        this.money = money;
        this.status = status;
        this.payPassword = payPassword;
        this.json = json;
    }

    public AppWallet() {
        super();
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }
}