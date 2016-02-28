package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppOrderAddress implements Serializable {
	private static final long serialVersionUID = 4460530575930561396L;

	private Long orderId;

    private Long userId;

    private Long province;

    private Long city;

    private String address;

    private String linkMan;

    private String linkPhone;

    private String remark;

    public AppOrderAddress(Long orderId, Long userId, Long province, Long city, String address, String linkMan, String linkPhone, String remark) {
        this.orderId = orderId;
        this.userId = userId;
        this.province = province;
        this.city = city;
        this.address = address;
        this.linkMan = linkMan;
        this.linkPhone = linkPhone;
        this.remark = remark;
    }

    public AppOrderAddress() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}