package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.util.Date;

public class AppBankPersonInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2354601550217883188L;

	private Long personId;

    private String name;

    private String idCard;

    private Date ctime;

    private Long userId;

    public AppBankPersonInfo(Long personId, String name, String idCard, Date ctime, Long userId) {
        this.personId = personId;
        this.name = name;
        this.idCard = idCard;
        this.ctime = ctime;
        this.userId = userId;
    }

    public AppBankPersonInfo() {
        super();
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}