package com.mobile.blue.view;

import java.util.HashMap;
import java.util.Map;

public class PayVO {
	/**
	 * 接口名称 固定值。 mobile.securitypay.pay
	 */
	private String service;
	/**
	 * 合作者身份ID 签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
	 */
	private String partner;
	/**
	 * 参数编码字符集 商户网站使用的编码格式，固定为utf-8
	 */
	private String input_charset;
	/**
	 * 签名方式 签名类型，目前仅支持RSA。
	 */
	private String sign_type;
	/**
	 * 签名
	 */
	private String sign;
	/**
	 * 服务器异步通知页面路径 支付宝服务器主动通知商户网站里指定的页面http路径。
	 */
	private String notify_url;
	/**
	 * 客户端号 标识客户端。
	 */
	private String app_id;
	/**
	 * 客户端来源 标识客户端来源。参数值内容约定如下：appenv=”system=客户端平台名^version=业务系统版本”
	 */
	private String appenv;
	/**
	 * 商户网站唯一订单号 支付宝合作商户网站唯一订单号。
	 */
	private String out_trade_no;
	/**
	 * 商品名称 商品的标题/交易标题/订单标题/订单关键字等。该参数最长为128个汉字。
	 */
	private String subject;
	/**
	 * 支付类型 支付类型。默认值为：1（商品购买）。
	 */
	private String payment_type;
	/**
	 * 卖家支付宝账号 卖家支付宝账号（邮箱或手机号码格式）或其对应的支付宝唯一用户号（以2088开头的纯16位数字）。
	 */
	private String seller_id;
	/**
	 * 总金额 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	private String total_fee;

	/**
	 * 商品详情
	 * 
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	private String body;
	/**
	 * 商品类型 具体区分本地交易的商品类型。 1：实物交易； 0：虚拟交易。 默认为1（实物交易）。
	 */
	private String goods_type;
	/**
	 * 是否发起实名校验 T：发起实名校验； F：不发起实名校验。
	 */
	private String rn_check;
	/**
	 * 未付款交易的超时时间
	 * 
	 * 设置未付款交易的超时时间，一旦超时，该笔交易就会自动被关闭。当用户输入支付密码、点击确认付款后（即创建支付宝交易后）开始计时。取值范围：1m～
	 * 15d，或者使用绝对时间（示例格式：2014-06-13
	 * 16:00:00）。m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。该参数数值不接受小数点，如1.5h，可转换为90m。
	 */
	private String it_b_pay;
	/**
	 * 授权令牌
	 * 
	 * 开放平台返回的包含账户信息的token（授权令牌，商户在一定时间内对支付宝某些服务的访问权限）。通过授权登录后获取的alipay_open_id，
	 * 作为该参数的value，登录授权账户即会为支付账户。
	 */
	private String extern_token;
	/**
	 * 商户业务扩展参数 业务扩展参数，支付宝特定的业务需要添加该字段，json格式。 商户接入时和支付宝协商确定。
	 */
	private String out_context;

	// private List<String> list=new ArrayList<String>();
	private Map<String, Object> map = new HashMap<String, Object>();

	public String getService() {
		return service == null ? "mobile.securitypay.pay" : service;
	}

	public void setService(String service) {
		this.service = service;
		if (service != null && !"".equals(service)) {
			map.put("service", service);
		}
	}

	public String getPartner() {
		return partner == null ? "" : partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
		if (partner != null && !"".equals(partner)) {
			map.put("partner", partner);
		}
	}

	public String getInput_charset() {
		return input_charset == null ? "utf-8" : input_charset;
	}

	public void setInput_charset(String input_charset) {
		this.input_charset = input_charset;
		if (input_charset != null && !"".equals(input_charset)) {
			map.put("input_charset", input_charset);
		}
	}

	public String getSign_type() {
		return sign_type == null ? "RSA" : sign;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
		if (sign_type != null && !"".equals(sign_type)) {
			map.put("sign_type", sign_type);
		}
	}

	public String getSign() {
		return sign == null ? "" : sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
		if (sign != null && !"".equals(sign)) {
			map.put("sign", sign);
		}
	}

	public String getNotify_url() {
		return notify_url == null ? "http://notify.msp.hk/notify.htm" : notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
		if (notify_url != null && !"".equals(notify_url)) {
			map.put("notify_url", notify_url);
		}
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
		if (app_id != null && !"".equals(app_id)) {
			map.put("app_id", app_id);
		}
	}

	public String getAppenv() {
		return appenv;
	}

	public void setAppenv(String appenv) {
		this.appenv = appenv;
		if (appenv != null && !"".equals(appenv)) {
			map.put("appenv", appenv);
		}
	}

	public String getOut_trade_no() {
		return out_trade_no == null ? "" : out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		if (out_trade_no != null && !"".equals(out_trade_no)) {
			map.put("out_trade_no", out_trade_no);
		}
	}

	public String getSubject() {
		return subject == null ? "测试" : subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
		if (subject != null && !"".equals(subject)) {
			map.put("subject", subject);
		}
	}

	public String getPayment_type() {
		return payment_type == null ? "1:" : payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
		if (payment_type != null && !"".equals(payment_type)) {
			map.put("payment_type", payment_type);
		}
	}

	public String getSeller_id() {
		return seller_id == null ? "0" : seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
		if (seller_id != null && !"".equals(seller_id)) {
			map.put("seller_id", seller_id);
		}
	}

	public String getTotal_fee() {
		return total_fee == null ? "10" : total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
		if (total_fee != null && !"".equals(total_fee)) {
			map.put("total_fee", total_fee);
		}
	}

	public String getBody() {
		return body == null ? "测试测试" : body;
	}

	public void setBody(String body) {
		this.body = body;
		if (body != null && !"".equals(body)) {
			map.put("body", body);
		}
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
		if (goods_type != null && !"".equals(goods_type)) {
			map.put("goods_type", goods_type);
		}
	}

	public String getRn_check() {
		return rn_check;
	}

	public void setRn_check(String rn_check) {
		this.rn_check = rn_check;
		if (rn_check != null && !"".equals(rn_check)) {
			map.put("rn_check", rn_check);
		}
	}

	public String getIt_b_pay() {
		return it_b_pay;
	}

	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
		if (it_b_pay != null && !"".equals(it_b_pay)) {
			map.put("it_b_pay", it_b_pay);
		}
	}

	public String getExtern_token() {
		return extern_token;
	}

	public void setExtern_token(String extern_token) {
		this.extern_token = extern_token;
		if (extern_token != null && !"".equals(extern_token)) {
			map.put("extern_token", extern_token);
		}
	}

	public String getOut_context() {
		return out_context;
	}

	public void setOut_context(String out_context) {
		this.out_context = out_context;
		if (out_context != null && !"".equals(out_context)) {
			map.put("out_context", out_context);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (String key : map.keySet()) {
			sb.append(key + "=" + map.get(key));
		}
		return sb.toString();
	}

}
