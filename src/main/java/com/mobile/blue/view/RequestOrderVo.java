package com.mobile.blue.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class RequestOrderVo implements Serializable {
	private static final long serialVersionUID = -8394448838426719988L;
	private Long orderId;
	private Long userId;
	private Long relationId;
	private Byte status;
	private Short num;
	private BigDecimal price;
	private BigDecimal totalMoney;
	private Date payTime;
	private String remark;
	private Date confirmTime;
	private Byte isShow;
	private byte type;
	private byte payType;
	private String orderCode;
	private String projectName;
	private Date overTime;
	private long addressId;
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "RequestOrderVo [orderId=" + orderId + ", userId=" + userId + ", relationId=" + relationId + ", status="
				+ status + ", num=" + num + ", price=" + price + ", totalMoney=" + totalMoney + ", payTime=" + payTime
				+ ", remark=" + remark + ", confirmTime=" + confirmTime + ", isShow=" + isShow + ", type=" + type
				+ ", payType=" + payType + ", orderCode=" + orderCode + ", projectName=" + projectName + ", overTime="
				+ overTime + ", addressId=" + addressId + "]";
	}

	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public byte getPayType() {
		return payType;
	}

	public void setPayType(byte payType) {
		this.payType = payType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Byte getIsShow() {
		return isShow;
	}

	public void setIsShow(Byte isShow) {
		this.isShow = isShow;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

}
