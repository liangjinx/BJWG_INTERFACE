package com.mobile.blue.util;

/**
 * More web service 系统错误状态码 2015-7-16
 */
public class CodeStatus {
	// success
	public static final int SUCCESS = 0;

	// 系统繁忙，请稍后重试
	public static final int SYSTEM_ERROR = 101;

	// 输入参数错误
	public static final int INPUT_PARAM_ERROR = 102;

	// 用户回话已经过期
	public static final int USER_SESSION_EXCEPTION = 103;

	// 用户已经存在
	public static int EXIST_MOBILE_EXCEPTION = 104;

	// 验证码错误
	public static int ACTCODE_EXCEPTION = 105;

	// 密码错误
	public static int WRONG_PASSWORD_EXCEPTION = 106;

	// 用户不存在
	public static int USER_NOTEXIST_EXCEPTION = 107;

	// 验证码发送失败，请重新发送
	public static final int NOT_VERIFY_ACTIVATION_EXCEPTION = 108;

	// 验证已经通过，无需在验证
	public static final int VERIFY_ACTIVATION_PASS_EXCEPTION = 109;

	// 输入的反馈文字过长（150个中文字）
	public static final int INPUT_LENGTH_EXCEPTION = 110;

	// 更新的版本为找到
	public static final int VERSION_UPDATE_EXCEPTION = 111;

	// 资源类型错误
	public static final int SOURCE_TYPE_EXCEPTION = 112;

	// 资源不存在
	public static final int SOURCE_NOT_EXIST_EXCEPTION = 113;

	// 该资源文件已经使用过，没有赠送流量
	public static final int BILL_EXIST_EXCEPTION = 114;

	// 用户账单不存在
	public static final int BILL_NOT_EXIST_EXCEPTION = 115;

	// 今天已经签到，请明天再来
	public static final int SIGN_EXIST_EXCEPTION = 116;

	// 账单过期
	public static final int BILL_EXPIRE_EXCEPTION = 117;

	// 流量分配不对
	public static final int COIN_USE_NOT_MATCH_EXCEPTION = 118;

	// 刮刮卡不存在
	public static final int SCRATCH_NOT_EXIST_EXCEPTION = 119;

	// 流量币不够 刮刮卡使用
	public static final int FLOW_COIN_NOT_ENOUGH_EXCEPTION = 120;

	// 绑定的账号不存在，请绑定后重新登录
	public static final int BIIND_ACCOUNT_NOT_EXIST_EXCEPTION = 121;

	// 第三方绑定的类型不存在
	public static final int BIIND_ACCOUNT_TYPE_NOT_EXIST_EXCEPTION = 122;
}
