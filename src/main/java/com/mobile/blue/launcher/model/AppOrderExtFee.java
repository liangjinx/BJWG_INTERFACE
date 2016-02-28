package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AppOrderExtFee implements Serializable {
    private Long orderId;

    private BigDecimal payMoney;

    private Integer num;

    private BigDecimal slaughterFee;

    private BigDecimal divisionFee;

    private Byte divisionType;

    private Byte divisionMode;

    private BigDecimal packageFee;

    private Integer spec;

    private BigDecimal weight;

    private Integer packageNum;

    private String remark;

    private static final long serialVersionUID = 1L;

    public AppOrderExtFee(Long orderId, BigDecimal payMoney, Integer num, BigDecimal slaughterFee, BigDecimal divisionFee, Byte divisionType, Byte divisionMode, BigDecimal packageFee, Integer spec, BigDecimal weight, Integer packageNum, String remark) {
        this.orderId = orderId;
        this.payMoney = payMoney;
        this.num = num;
        this.slaughterFee = slaughterFee;
        this.divisionFee = divisionFee;
        this.divisionType = divisionType;
        this.divisionMode = divisionMode;
        this.packageFee = packageFee;
        this.spec = spec;
        this.weight = weight;
        this.packageNum = packageNum;
        this.remark = remark;
    }

    public AppOrderExtFee() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getSlaughterFee() {
        return slaughterFee;
    }

    public void setSlaughterFee(BigDecimal slaughterFee) {
        this.slaughterFee = slaughterFee;
    }

    public BigDecimal getDivisionFee() {
        return divisionFee;
    }

    public void setDivisionFee(BigDecimal divisionFee) {
        this.divisionFee = divisionFee;
    }

    public Byte getDivisionType() {
        return divisionType;
    }

    public void setDivisionType(Byte divisionType) {
        this.divisionType = divisionType;
    }

    public Byte getDivisionMode() {
        return divisionMode;
    }

    public void setDivisionMode(Byte divisionMode) {
        this.divisionMode = divisionMode;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public Integer getSpec() {
        return spec;
    }

    public void setSpec(Integer spec) {
        this.spec = spec;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(Integer packageNum) {
        this.packageNum = packageNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}