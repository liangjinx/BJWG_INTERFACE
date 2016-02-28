package com.mobile.blue.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mobile.blue.util.EncryptMD5Util;

public class PayWXVO {
	/**
	 * 公众账号ID 微信分配的公众账号ID（企业号corpid即为此appId）
	 */
	private String appid;
	/**
	 * 签名 签名，详见签名生成算法
	 */
	private String sign;
	/**
	 * 商户号 微信支付分配的商户号
	 */

	private String mch_id;
	/**
	 * 设备号 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	 */

	private String device_info;

	/**
	 * 随机字符串 随机字符串，不长于32位。推荐随机数生成算法
	 */
	private String nonce_str;

	/**
	 * 商品描述 商品或支付单简要描述
	 */
	private String body;

	/**
	 * 商品详情 商品名称明细列表
	 */
	private String detail;
	/**
	 * 附加数据 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	 */
	private String attach;

	/**
	 * 商户订单号 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	 */
	private String out_trade_no;

	/**
	 * 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 */
	private String fee_type;

	/**
	 * 总金额 订单总金额，单位为分，详见支付金额
	 */
	private int total_fee;
	/**
	 * 终端IP PP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 */
	private String spbill_create_ip;
	/**
	 * 交易起始时间
	 * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	 */
	private String time_start;
	/**
	 * 交易结束时间
	 * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
	 * 注意：最短失效时间间隔必须大于5分钟
	 */
	private String time_expire;
	/**
	 * 商品标记 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
	 */
	private String goods_tag;
	/**
	 * 通知地址 接收微信支付异步通知回调地址
	 */
	private String notify_url;
	/**
	 * 交易类型 取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
	 */
	private String trade_type;
	/**
	 * 商品ID trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	 */
	private String product_id;
	/**
	 * 指定支付方式 no_credit--指定不能使用信用卡支付
	 */
	private String limit_pay;
	/**
	 * 用户标识
	 * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【
	 * 企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
	 */
	private String openid;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
		if (appid != null && !"".equals(appid)) {
			map.put("appid", appid);
		}
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
		if (mch_id != null && !"".equals(mch_id)) {
			map.put("mch_id", mch_id);
		}
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
		if (device_info != null && !"".equals(device_info)) {
			map.put("device_info", device_info);
		}
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
		if (nonce_str != null && !"".equals(nonce_str)) {
			map.put("nonce_str", nonce_str);
		}
	}

	/**
	 * 签名 签名，详见签名生成算法
	 */
	public String getSign() {
		return sign;
	}

	public void setSign(String signkey) {
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);// 排序
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = (String) map.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				sb.append(key + "=" + value);
			} else {
				sb.append(key + "=" + value + "&");
			}
		}
		sign = EncryptMD5Util.sign(sb.toString(), signkey, "utf-8").toUpperCase();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
		if (body != null && !"".equals(body)) {
			map.put("body", body);
		}
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
		if (detail != null && !"".equals(detail)) {
			map.put("detail", detail);
		}
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
		if (attach != null && !"".equals(attach)) {
			map.put("attach", attach);
		}
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		if (out_trade_no != null && !"".equals(out_trade_no)) {
			map.put("out_trade_no", out_trade_no);
		}
	}

	public String getFee_type() {
		return fee_type == null ? "CNY" : fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
		if (fee_type != null && !"".equals(fee_type)) {
			map.put("fee_type", fee_type);
		}
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
		if (total_fee != 0) {
			map.put("total_fee", total_fee);
		}
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
		if (spbill_create_ip != null && !"".equals(spbill_create_ip)) {
			map.put("spbill_create_ip", spbill_create_ip);
		}
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
		if (time_start != null && !"".equals(time_start)) {
			map.put("time_start", time_start);
		}
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
		if (time_expire != null && !"".equals(time_expire)) {
			map.put("time_expire", time_expire);
		}
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
		if (goods_tag != null && !"".equals(goods_tag)) {
			map.put("goods_tag", goods_tag);
		}
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
		if (notify_url != null && !"".equals(notify_url)) {
			map.put("notify_url", notify_url);
		}
	}

	public String getTrade_type() {
		return trade_type == null ? "APP" : trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
		if (trade_type != null && !"".equals(trade_type)) {
			map.put("trade_type", trade_type);
		}
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
		if (product_id != null && !"".equals(product_id)) {
			map.put("product_id", product_id);
		}
	}

	public String getLimit_pay() {
		return limit_pay == null ? "no_credit" : limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
		if (limit_pay != null && !"".equals(limit_pay)) {
			map.put("limit_pay", limit_pay);
		}
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
		if (openid != null && !"".equals(openid)) {
			map.put("openid", openid);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		for (String key : map.keySet()) {
			sb.append("<" + key + ">" + "=" + map.get(key) + "</" + key + ">");
		}
		sb.append("</xml>");
		return sb.toString();
	}

}
