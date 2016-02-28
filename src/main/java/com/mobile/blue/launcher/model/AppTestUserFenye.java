package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.util.Date;

public class AppTestUserFenye implements Serializable {
    private Long userId;

    private String username;

    private String nickname;

    private String password;

    private String email;

    private Byte sex;

    private String phone;

    private Date registerTime;

    private Long registerIp;

    private Date lastLoginTime;

    private Long lastLoginIp;

    private Byte status;

    private String headImg;

    private String province;

    private String city;

    private String country;

    private Byte source;

    private String inviteCode;

    private String qrCode;

    private static final long serialVersionUID = 1L;

    public AppTestUserFenye(Long userId, String username, String nickname, String password, String email, Byte sex, String phone, Date registerTime, Long registerIp, Date lastLoginTime, Long lastLoginIp, Byte status, String headImg, String province, String city, String country, Byte source, String inviteCode, String qrCode) {
        this.userId = userId;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.phone = phone;
        this.registerTime = registerTime;
        this.registerIp = registerIp;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.status = status;
        this.headImg = headImg;
        this.province = province;
        this.city = city;
        this.country = country;
        this.source = source;
        this.inviteCode = inviteCode;
        this.qrCode = qrCode;
    }

    public AppTestUserFenye() {
        super();
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Long getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(Long registerIp) {
        this.registerIp = registerIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(Long lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }
}