package com.mobile.blue.view;

import com.mobile.blue.util.CodeStatus;

public class ResultVO<T> {

	private int status = CodeStatus.SUCCESS;
	private String message = "";
	/* JSON 返回做了+ -分數 主鍵ID */
	private T result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return message;
	}

	public void setErrorMessage(String errorMessage) {
		this.message = errorMessage;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
