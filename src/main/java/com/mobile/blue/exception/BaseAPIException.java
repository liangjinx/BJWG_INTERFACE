package com.mobile.blue.exception;

import com.mobile.blue.util.CodeStatus;

/**
 * 
 * @author kelvin.tie
 */
public class BaseAPIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7065579710316348767L;

	private int errorCode = CodeStatus.SYSTEM_ERROR;

	public int getErrorCode() {
		return errorCode;
	}

	public BaseAPIException() {
		super();
	}

	public BaseAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseAPIException(String message) {
		super(message);
	}

	public BaseAPIException(Throwable cause) {
		super(cause);
	}

}
