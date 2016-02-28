package com.mobile.blue.launcher.model;

import java.io.Serializable;

public class AppDictDefatl implements Serializable {
	private static final long serialVersionUID = 5829539071702062932L;

	private Long dictDetailId;

    private Long dictId;

    private String name;

    private String code;

    private String value;

    private String remark;

    public AppDictDefatl(Long dictDetailId, Long dictId, String name, String code, String value, String remark) {
        this.dictDetailId = dictDetailId;
        this.dictId = dictId;
        this.name = name;
        this.code = code;
        this.value = value;
        this.remark = remark;
    }

    public AppDictDefatl() {
        super();
    }

    public Long getDictDetailId() {
        return dictDetailId;
    }

    public void setDictDetailId(Long dictDetailId) {
        this.dictDetailId = dictDetailId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}