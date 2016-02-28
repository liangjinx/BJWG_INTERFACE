package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.util.Date;

public class AppBulletin implements Serializable {
	private static final long serialVersionUID = 7265462901556953136L;

	private Long bulletinId;

    private String title;

    private String content;

    private Date ctime;

    private Short type;

    private Byte status;

    public AppBulletin(Long bulletinId, String title, String content, Date ctime, Short type, Byte status) {
        this.bulletinId = bulletinId;
        this.title = title;
        this.content = content;
        this.ctime = ctime;
        this.type = type;
        this.status = status;
    }

    public AppBulletin() {
        super();
    }

    public Long getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(Long bulletinId) {
        this.bulletinId = bulletinId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}