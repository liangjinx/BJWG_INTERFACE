package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppPreorderKey implements Serializable {
	private static final long serialVersionUID = 2867430827827186633L;

	private Long projectId;

    private Long userId;

    public AppPreorderKey(Long projectId, Long userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public AppPreorderKey() {
        super();
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}