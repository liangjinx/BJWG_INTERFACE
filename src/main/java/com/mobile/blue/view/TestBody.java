package com.mobile.blue.view;

import java.io.Serializable;

public class TestBody implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5102226043500240356L;
	 private Long orderId;
	 private Long userId;
	 private Long relationId;
	 private Byte status;
	 private Short num;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
