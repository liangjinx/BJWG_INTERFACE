package com.mobile.blue.exception;

import com.mobile.blue.util.CodeStatus;

/**
 * 
 * @author More 2015-7-16
 */
public class LauncherAPIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7065579710316348767L;

	private int errorCode = CodeStatus.SYSTEM_ERROR;

	public int getErrorCode() {
		return errorCode;
	}

	public LauncherAPIException() {
		super();
	}

	public LauncherAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public LauncherAPIException(String message) {
		super(message);
	}

	public LauncherAPIException(Throwable cause) {
		super(cause);
	}

}
