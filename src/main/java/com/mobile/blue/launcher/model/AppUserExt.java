package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.util.Date;

public class AppUserExt implements Serializable {
	private static final long serialVersionUID = -750730589711747674L;

	private Long userId;

    private Long lastButtinId;

    private Byte settingType;

    private Date settingTime;

    private Integer settingValue;

    public AppUserExt(Long userId, Long lastButtinId, Byte settingType, Date settingTime, Integer settingValue) {
        this.userId = userId;
        this.lastButtinId = lastButtinId;
        this.settingType = settingType;
        this.settingTime = settingTime;
        this.settingValue = settingValue;
    }

    public AppUserExt() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLastButtinId() {
        return lastButtinId;
    }

    public void setLastButtinId(Long lastButtinId) {
        this.lastButtinId = lastButtinId;
    }

    public Byte getSettingType() {
        return settingType;
    }

    public void setSettingType(Byte settingType) {
        this.settingType = settingType;
    }

    public Date getSettingTime() {
        return settingTime;
    }

    public void setSettingTime(Date settingTime) {
        this.settingTime = settingTime;
    }

    public Integer getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(Integer settingValue) {
        this.settingValue = settingValue;
    }

}