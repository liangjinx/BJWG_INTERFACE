package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.util.Date;

public class AppFriend implements Serializable {
	private static final long serialVersionUID = 361776927849476888L;

	private Long myUserId;

    private Long freindId;

    private Byte addType;

    private Date sendTime;

    private String sendRemark;

    private Byte status;

    private Date agreeTime;

    public AppFriend(Long myUserId, Long freindId, Byte addType, Date sendTime, String sendRemark, Byte status, Date agreeTime) {
        this.myUserId = myUserId;
        this.freindId = freindId;
        this.addType = addType;
        this.sendTime = sendTime;
        this.sendRemark = sendRemark;
        this.status = status;
        this.agreeTime = agreeTime;
    }

    public AppFriend() {
        super();
    }

    public Long getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(Long myUserId) {
        this.myUserId = myUserId;
    }

    public Long getFreindId() {
        return freindId;
    }

    public void setFreindId(Long freindId) {
        this.freindId = freindId;
    }

    public Byte getAddType() {
        return addType;
    }

    public void setAddType(Byte addType) {
        this.addType = addType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendRemark() {
        return sendRemark;
    }

    public void setSendRemark(String sendRemark) {
        this.sendRemark = sendRemark == null ? null : sendRemark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }
}