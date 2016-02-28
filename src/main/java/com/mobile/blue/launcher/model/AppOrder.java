package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppOrder implements Serializable {
	private static final long serialVersionUID = 698880046200901730L;

	private Long orderId;

    private String orderCode;

    private Date ctime;

    private Byte type;

    private Byte status;

    private Short num;

    private BigDecimal price;

    private BigDecimal totalMoney;

    private Date payTime;

    private Long userId;

    private String remark;

    private String productName;

    private Byte payType;

    private Long relationId;

    private String relationName;

    private Date overTime;

    private String productImg;

    private Long subOrderId;

    private Date confirmTime;

    private String prepayOrderCode;

    private Byte isShow;

    public AppOrder(Long orderId, String orderCode, Date ctime, Byte type, Byte status, Short num, BigDecimal price, BigDecimal totalMoney, Date payTime, Long userId, String remark, String productName, Byte payType, Long relationId, String relationName, Date overTime, String productImg, Long subOrderId, Date confirmTime, String prepayOrderCode, Byte isShow) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.ctime = ctime;
        this.type = type;
        this.status = status;
        this.num = num;
        this.price = price;
        this.totalMoney = totalMoney;
        this.payTime = payTime;
        this.userId = userId;
        this.remark = remark;
        this.productName = productName;
        this.payType = payType;
        this.relationId = relationId;
        this.relationName = relationName;
        this.overTime = overTime;
        this.productImg = productImg;
        this.subOrderId = subOrderId;
        this.confirmTime = confirmTime;
        this.prepayOrderCode = prepayOrderCode;
        this.isShow = isShow;
    }

    public AppOrder() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName == null ? null : relationName.trim();
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public Long getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getPrepayOrderCode() {
        return prepayOrderCode;
    }

    public void setPrepayOrderCode(String prepayOrderCode) {
        this.prepayOrderCode = prepayOrderCode == null ? null : prepayOrderCode.trim();
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }
}