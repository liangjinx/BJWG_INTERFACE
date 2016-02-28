package com.mobile.blue.launcher.model;

import java.util.Date;

public class AppPreorder extends AppPreorderKey {
	private static final long serialVersionUID = 4243204197862963267L;

	private Date ctime;

    private Integer num;

    public AppPreorder(Long projectId, Long userId, Date ctime, Integer num) {
        super(projectId, userId);
        this.ctime = ctime;
        this.num = num;
    }

    public AppPreorder() {
        super();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}