package com.mobile.blue.util.constant;

public class BasicConstant {
	/**
	 * 与逻辑有关的常量
	 */
	// 短信验证有关的地址，账号，密码
	public static final String SEND_NOTE_URL = "http://222.73.117.158/msg/index.jsp";
	public static final String SEND_NOTE_ACCOUNT = "vipszrm";
	public static final String SEND_NOTE_PSWD = "Tch123456";

	public static final String IS_TEST_COUNTO_USER = "yes";// 是否是公司的测试用户
	public static final String SYSTEM_CONFIG = "systemConfig";// 缓存保存的个人信息

	public static final int VERIF_CODE_LENGTH = 6;// 验证码的位数
	public static final int VERIF_CODE_time = 3;// 验证码有效时间
	public static final int VERIFICTION_length = 12;// 验证码有效时间
	public static final String VERIF_CODE = "verif";// 保存验证码的key
	public static final String VERIF_TYPE_REGISTER_ENGLISH = "reg";// 验证码的类型
	public static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";// 日期格式
	public static final String DATE_PATH_FILE = "yyyy-MM-dd";// 保存文件的日期格式
	public static final long DEFAULT_LAST_BUTTION_ID = 0l;
	/**
	 * 与请求url有关的
	 */
	public static String getAccessToken = "";// 表示请求的是发送手机验证码

	/**
	 * 
	 * 与返回值类型有关的常量
	 */
	public static final String PHONE = "phone";// 手机号码
	public static final String BACK_VERIFY_CODE = "verify_code";// 临时作为缓存使用一下
	public static final String CREATE_TIME = "time";// 创建时间
	public static final String USER_ID = "user_id";// 创建时间

	// 与支付有关的
	public static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	public static final String service = "create_direct_pay_by_user";
	public static final String sign_type = "MD5";
	public static final String show_url = "http://www.alipay.com/";// 展示地址，即在支付页面时，商品名称旁边的“详情”的链接地址。
	public static final String input_charset = "utf-8";

	// 银联支付有关
	public static final String zhifu_verify_file = "E\\:\\cp\\cp.cer";
	public static final String zhifu_verify_filePath = "/opt/secss";
	public static final String zhifu_sign_filePath = "E\\:\\cer\\003.pfx";
	public static final String zhifu_sign_file_password = "123456";
	public static final String zhifu_sign_cert_type = "PKCS12";
	public static final String zhifu_invalid_fields = "Signature,CertId";
	public static final String zhifu_signature_field = "Signature";
	public static final String log4j_name = "CONSOLE";
	public static final String private_key = "‎^029d39857b7337ecc6a7a4472bc15d86";
	public static final String private_key_zhifuBao = "‎MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALLi4QQP2ET6t58eV6MgPWWdWy0rqEccfwd026AVAxgEVEGY2zoOUa2N52CkT+EGZCJaVumVVe/DVdhK4CffvRNSOSpZhQ9XO8py1I8yDOvD1BYKu3klqH3aH6fNbGabJSNG9cpMjdeOYi85PrMCeJA0pb/JdXWMTVE4t7efPzRBAgMBAAECgYEAoIC0iGJ3F50k993PoAujSvMfBa5wNC27RENzc3Sm6/umZZzyxmpmmqQCAFItYafMXI5WAQr+qjvHYGP+L4iuKZGJIVe9asL7KRIawhaMQ2SZ16ciX0ztOyb6kAfMuWEoHr0ZPKELuSv8pToCtu50sIign4NGurXe9JuL4u9c4WECQQDeLgwYXhv/lh3xp14h4IgZhrleAE/xhB2+vXWcWxSYOKn+NMx5VaFz5cW2dwigHs/WumAK1eIfq/hQR1jcVz0NAkEAzh3BplgBMZsV7zXCOUUQ1Huu4jyVKsnLUVEvwIheW9XB1fwLegn+HhU1lA4laWECSIMa1h1BZmf0xevn14RPBQJAMatDovLu+W1a1lofLh2e723x5LTXKlvptmlucHzgFsOcJSsyhvGAvYMhdxAXSox41D0oGWQFQCVWxsOcdu29xQJAZqUA9BLtfUOrV7Yg5B5V9Esn23iqHGXj/7n7mtkOjJNV9XeQS5VAXMDZLsMgtGrgFTZdHfXxxMrOZeZGTdiQ9QJAXGbLamU0CSxcCcdWSRr1PurnppMWTihNlfUiqDugRYafHwDgZTeOVrCJA8a70cshW3ywAnF6Azm2lyBqYAJmwQ==";
	public static final String public_key = "df";
	public static final int limit_page_size = 5;
	// 银行卡有关的
}
