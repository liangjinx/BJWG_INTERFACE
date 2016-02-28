package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppArea implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5489642264062414791L;

	private Long areaId;

	private String name;

	private Long parent;

	private Integer zipcode;

	private Long baiduCode;

    public AppArea(Long areaId, String name, Long parent, Integer zipcode, Long baiduCode) {
        this.areaId = areaId;
        this.name = name;
        this.parent = parent;
        this.zipcode = zipcode;
        this.baiduCode = baiduCode;
    }

    public AppArea() {
        super();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Long getBaiduCode() {
        return baiduCode;
    }

    public void setBaiduCode(Long baiduCode) {
        this.baiduCode = baiduCode;
    }

}