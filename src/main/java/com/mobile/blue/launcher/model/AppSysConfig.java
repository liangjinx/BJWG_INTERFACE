package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppSysConfig implements Serializable {
	private static final long serialVersionUID = -8224369130906476100L;

	private Long id;

    private String name;

    private String code;

    private String parentName;

    private String parentCode;

    private String value;

    private String remark;

    public AppSysConfig(Long id, String name, String code, String parentName, String parentCode, String value, String remark) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentName = parentName;
        this.parentCode = parentCode;
        this.value = value;
        this.remark = remark;
    }

    public AppSysConfig() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}