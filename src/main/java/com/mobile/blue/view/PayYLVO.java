package com.mobile.blue.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.mobile.blue.util.payyl.SDKUtil;

public class PayYLVO {
	private String customerInfo;
	private String encryptCertId;
	/**
	 * 版本号 固定填写5.0.0
	 */
	private String version;
	/**
	 * 编码方式 填写报文使用的字符编码，支持UTF-8与GBK编码
	 */
	private static String encoding;
	/**
	 * 证书ID 填写签名私钥证书的Serial Number，该值可通过SDK获取
	 */
	private String certId;
	/**
	 * 签名方法 01：表示采用RSA
	 */
	private String signMethod;
	/**
	 * 签名 填写对报文摘要的签名，可通过SDK生成签名
	 */
	/* private String signature; */
	/**
	 * 交易类型 取值：
	 * 00：查询交易，01：消费，02：预授权，03：预授权完成，04：退货，05：圈存，11：代收，12：代付，13：账单支付，14：转账（保留），
	 * 21：批量交易，22：批量查询，31：消费撤销，32：预授权撤销，33：预授权完成撤销，71：余额查询，72：实名认证-建立绑定关系，73：
	 * 账单查询，74：解除绑定关系，75：查询绑定关系，77：发送短信验证码交易，78：开通查询交易，79：开通交易，94：IC卡脚本通知
	 */
	private String txnType;
	/**
	 * 交易子类 依据实际交易类型填写。
	 */
	private String txnSubType;
	/**
	 * 产品类型 取值：000101：基金业务之股票基金；000102：基金业务之货币基金；000201：B2C网关支付；000301：无跳转（商户侧）；
	 * 000302：评级支付；000401：代付；000501：代收；000601：账单支付；000801：无跳转（机构侧）；000901：绑定支付；
	 * 000902: Token支付；001001：订购；000202：B2B 除以上产品外其他接口默认送000000，对账文件下载接口必送000000
	 */
	private String bizType;
	/**
	 * 接入类型 0：商户直连接入1：收单机构接入
	 */
	private String accessType;
	/**
	 * 渠道类型 05：语音 07：互联网 08：移动
	 */
	private String channelType;
	/**
	 * 商户代码 已被批准加入银联互联网系统的商户代码
	 */
	private String merId;
	/**
	 * 商户订单号 商户订单号，仅能用大小写字母与数字，不能用特殊字符
	 */
	private String orderId;
	/**
	 * 后台通知地址
	 * 用于接收后台通知报文，必须上送完整的互联网可访问地址，支持HTTP与HTTPS协议（如：https://xxx.xxx.xxx....），
	 * 地址中不能包含~
	 */
	private String backUrl;
	/**
	 * 交易币种 币种格式必须为3位代码，境内客户取值：156（人民币）
	 */
	private String currencyCode;
	/**
	 * 交易金额 单位为分，不能带小数点，样例：1元送100
	 */
	private String txnAmt;
	/**
	 * 订单发送时间 必须使用当前背景时间（年年年年月月日日时时分分秒秒）24小时制，样例：20151123152540
	 */
	private String txnTime;
	/**
	 * 支付超时时间 超过此时间客户查询结果为非成功的交易，持卡人可能被扣账，系统会自动退款，大约5个工作日金额返还到持卡人账户（
	 * 一般在网银支付情况下会出现超时后持卡人可能被扣账情况），此时间建议取支付时的北京时间加15分钟
	 */
	private String payTimeout;
	/**
	 * 账号 银行卡号。请求时使用加密公钥对交易账号加密，并做Base64编码后上送；应答时如需返回，则使用签名私钥进行解密。前台交易可由银联页面采集，
	 * 也可由商户上送并返显，如需锁定返显卡号，应通过保留域（reserved）上送卡号锁定标识
	 */
	private String accNo;
	/**
	 * 请求方自定义域 商户自定义保留域，交易应答时会原样返回
	 */
	private String reqReserved;
	/**
	 * 订单描述 描述订单信息，显示在银联支付控件或客户端支付界面中
	 */
	private String orderDesc;
	public static Map<String, String> map = new HashMap<String, String>();

	@SuppressWarnings("unchecked")
	public static Map<String, String> param() {
		Entry<String, String> obj = null;
		Map<String, String> submitFromData = new HashMap<String, String>();
		for (Iterator<?> it = map.entrySet().iterator(); it.hasNext();) {
			obj = (Entry<String, String>) it.next();
			String value = obj.getValue();
			if (StringUtils.isNotBlank(value)) {
				// 对value值进行去除前后空处理
				submitFromData.put(obj.getKey(), value.trim());
			}
		}
		SDKUtil.sign(submitFromData, encoding);
		return submitFromData;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = (version == null || "".equals(version)) ? "5.0.0" : version;
		map.put("version", this.version);
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = (encoding == null || "".equals(encoding)) ? "UTF-8" : encoding;
		map.put("encoding", this.encoding);
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
		if (certId != null && !"".equals(certId)) {
			map.put("certId", certId);
		}
	}

	public String getSignMethod() {
		return signMethod;
	}

	public void setSignMethod(String signMethod) {
		this.signMethod = (signMethod == null || "".equals(signMethod)) ? "01" : signMethod;
		map.put("signMethod", this.signMethod);
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = (txnType == null || "".equals(txnType)) ? "01" : txnType;
		map.put("txnType", this.txnType);
	}

	public String getTxnSubType() {
		return txnSubType == null ? "01" : txnSubType;
	}

	public void setTxnSubType(String txnSubType) {
		this.txnSubType = (txnSubType == null || "".equals(txnSubType)) ? "01" : txnSubType;
		map.put("txnSubType", this.txnSubType);
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = (bizType == null || "".equals(bizType)) ? "000201" : bizType;
		map.put("bizType", this.bizType);
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = (accessType == null || "".equals(accessType)) ? "0" : accessType;
		map.put("accessType", this.accessType);
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = (channelType == null || "".equals(channelType)) ? "08" : channelType;
		map.put("channelType", this.channelType);
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
		if (merId != null && !"".equals(merId)) {
			map.put("merId", merId);
		}
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
		if (orderId != null && !"".equals(orderId)) {
			map.put("orderId", orderId);
		}
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
		if (backUrl != null && !"".equals(backUrl)) {
			map.put("backUrl", backUrl);
		}
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = (currencyCode == null || "".equals(currencyCode)) ? "156" : currencyCode;
		map.put("currencyCode", this.currencyCode);
	}

	public String getTxnAmt() {
		return txnAmt;
	}

	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
		if (txnAmt != null && !"".equals(txnAmt)) {
			map.put("txnAmt", txnAmt);
		}
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
		if (txnTime != null && !"".equals(txnTime)) {
			map.put("txnTime", txnTime);
		}
	}

	public String getPayTimeout() {
		return payTimeout;
	}

	public void setPayTimeout(String payTimeout) {
		this.payTimeout = payTimeout;
		if (payTimeout != null && !"".equals(payTimeout)) {
			map.put("payTimeout", payTimeout);
		}
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
		if (accNo != null && !"".equals(accNo)) {
			map.put("accNo", accNo);
		}
	}

	public String getReqReserved() {
		return reqReserved;
	}

	public void setReqReserved(String reqReserved) {
		this.reqReserved = reqReserved;
		if (reqReserved != null && !"".equals(reqReserved)) {
			map.put("reqReserved", reqReserved);
		}
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
		if (orderDesc != null && !"".equals(orderDesc)) {
			map.put("orderDesc", orderDesc);
		}
	}

	public String getEncryptCertId() {
		return encryptCertId;
	}

	public void setEncryptCertId(String encryptCertId) {
		this.encryptCertId = encryptCertId;
		if (encryptCertId != null && !"".equals(encryptCertId)) {
			map.put("encryptCertId", encryptCertId);
		}
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
		if (customerInfo != null && !"".equals(customerInfo)) {
			map.put("customerInfo", customerInfo);
		}
	}
}
