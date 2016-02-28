package com.mobile.blue.launcher.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.launcher.service.WalletService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.XmlParseUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.view.RequestOrderVo;

import net.sf.json.JSONObject;

@Controller
public class PayController {
	@Autowired
	private WalletService walletService;
	@Autowired
	private SysconfigService sysconfigService;

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 返回支付信息，如支付宝合作身份者ID 支付宝收款帐户
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getPayValue", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object getPayValue(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return ResultUtil.getResultJson(sysconfigService.queryList(), Status.success.getStatus(),
				Status.success.getMsg());
	}

	// 处理支付宝回调的url
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/notify", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody void notify(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		log.info("notify");
		PrintWriter out = response.getWriter();
		Map<String, String> params = new HashMap<String, String>();
		zhifuParam(request.getParameterMap(), params);
		out.write(walletService.notifys(params));
	}

	// .............................................................................end
	// 支付宝模块
	// ...........................微信支付模块...............................//
	@RequestMapping(value = "/WXnotify", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object wXnotify(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws IOException {
		String restult = IOUtils.toString(request.getInputStream());
		Document doc_notify_data = null;
		try {
			doc_notify_data = DocumentHelper.parseText(restult);
		} catch (DocumentException e) {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
		JSONObject jsonObject = XmlParseUtil.parseAlipayNotifyData(doc_notify_data);
		try {
			return walletService.weixinnotify(jsonObject);
		} catch (Exception e) {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
	}

	// 微信支付
	@RequestMapping(value = "/addorderforWX", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object addorderforWX(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestBody RequestOrderVo order) throws IOException {
		try {
			return walletService.addorderforWX(request.getRemoteAddr(), order);
		} catch (Exception e) {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
	}

	@RequestMapping(value = "/getPayResult", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object getPayResult(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String orderId) throws IOException {
		try {
			return walletService.getPayResult(orderId);
		} catch (Exception e) {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
	}

	// ...........................微信支付模块...............................//
	// ...........................银联支付模块...............................//
	@RequestMapping(value = "/requestForYL", method = { RequestMethod.POST, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object requestForYL(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			 @RequestBody RequestOrderVo order) throws IOException {
		try {
			return walletService.requestForYL(order.getOrderCode());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/ylNotify", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object ylNotify(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws IOException {
		String restult = IOUtils.toString(request.getInputStream());
		Document doc_notify_data = null;
		try {
			doc_notify_data = DocumentHelper.parseText(restult);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = XmlParseUtil.parseAlipayNotifyData(doc_notify_data);

		try {
			return walletService.ylNotify(jsonObject);
		} catch (Exception e) {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
	}

	// ...........................银联支付模块...............................//
	// 得到支付的参数
	private void zhifuParam(Map<String, Object> requestParams, Map<String, String> params) {
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < values.length; i++) {
				sb.append((i == values.length - 1) ? values[i].replaceAll(" ", "+")
						: values[i].replaceAll(" ", "+") + ",");
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, sb.toString());
		}
	}
}
