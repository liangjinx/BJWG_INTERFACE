package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.util.Date;

public class AppMessage implements Serializable {
	private static final long serialVersionUID = 7224305462409063844L;

	private Long messageId;

    private Long userId;

    private Date ctime;

    private String content;

    private Byte messageType;

    private Long relationId;

    private Byte relationType;

    private Byte status;

    public AppMessage(Long messageId, Long userId, Date ctime, String content, Byte messageType, Long relationId, Byte relationType, Byte status) {
        this.messageId = messageId;
        this.userId = userId;
        this.ctime = ctime;
        this.content = content;
        this.messageType = messageType;
        this.relationId = relationId;
        this.relationType = relationType;
        this.status = status;
    }

    public AppMessage() {
        super();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}