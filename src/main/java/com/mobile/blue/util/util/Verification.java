package com.mobile.blue.util.util;

public class Verification {
	/**
	 * 验证手机号码是否是11位的手机号码
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		return phone.matches("^([1-9]\\d*)$");
	}

	/**
	 * 密码验证，是6到20个字符的以数字或字符开头的只含数字和字母的密码
	 * 
	 * @param password
	 * @return
	 */
	// public static boolean isPassword(String password){
	// return password.matches("^[0-9_a-zA-Z]{6,20}$");
	// }
	/**
	 * 验证邀请码，邀请码是以rm开头，的12到18位只包含字母或数字的字符
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isInviteCode(String password) {
		return password.matches("^rm[0-9_a-zA-Z]{10}$");
	}
}
