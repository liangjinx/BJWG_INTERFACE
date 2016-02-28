package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppDict implements Serializable{
	
	private static final long serialVersionUID = 8545911386950788854L;

	private Long dictId;

    private String name;

    private String code;

    private String value;

    public AppDict(Long dictId, String name, String code, String value) {
        this.dictId = dictId;
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public AppDict() {
        super();
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}