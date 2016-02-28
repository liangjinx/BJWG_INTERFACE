package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppUserAddress implements Serializable {
	private static final long serialVersionUID = 5514410133392162934L;

	private Long addressId;

    private String contactMan;

    private String contactPhone;

    private Long province;

    private Long city;

    private String address;

    private Byte isDefault;

    private Long userId;

    public AppUserAddress(Long addressId, String contactMan, String contactPhone, Long province, Long city, String address, Byte isDefault, Long userId) {
        this.addressId = addressId;
        this.contactMan = contactMan;
        this.contactPhone = contactPhone;
        this.province = province;
        this.city = city;
        this.address = address;
        this.isDefault = isDefault;
        this.userId = userId;
    }

    public AppUserAddress() {
        super();
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}