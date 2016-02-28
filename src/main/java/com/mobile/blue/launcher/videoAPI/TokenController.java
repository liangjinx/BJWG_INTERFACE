package com.mobile.blue.launcher.videoAPI;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TokenController extends HttpServlet {

	public TokenController() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("phone", "13480664571");
		Map<String, Object> map = paramsInit("token/getAccessToken", paramsMap);
		doPost(map, response);
	}

	protected Map<String, Object> paramsInit(String method, Map<String, Object> paramsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		long time = System.currentTimeMillis() / 1000;

		/** ������(�������軻���Լ���appkey��secret) */
		String key = "25b4ce8945cb409ba8adcadaa04a8dc4";
		// //
		String secret = "e9de98d5b1dab981d6739be3c22339c6";
		StringBuilder paramString = new StringBuilder();
		List<String> paramList = new ArrayList<String>();
		for (Iterator<String> it = paramsMap.keySet().iterator(); it.hasNext();) {
			String key1 = it.next();
			String param = key1 + ":" + paramsMap.get(key1);
			paramList.add(param);
		}
		String[] params = paramList.toArray(new String[paramList.size()]);
		Arrays.sort(params);
		for (String param : params) {
			paramString.append(param).append(",");
		}
		paramString.append("method").append(":").append(method).append(",");
		paramString.append("time").append(":").append(time).append(",");
		paramString.append("secret").append(":").append(secret);
		System.out.println(paramString.toString().trim());

		String sign = null;
		try {
			sign = DigestUtils.md5Hex(paramString.toString().trim().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Map<String, Object> systemMap = new HashMap<String, Object>();
		systemMap.put("ver", "1.0");
		systemMap.put("sign", sign);
		systemMap.put("key", key);
		systemMap.put("time", time);

		map.put("system", systemMap);
		map.put("method", method);
		map.put("params", paramsMap);
		map.put("id", "123456");
		return map;
	}

	protected void doPost(Map<String, Object> map, HttpServletResponse response) {
		String json = JSON.toJSONString(map);
		ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
		Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
		HttpClient client = new HttpClient();
		// ʹ��POST����
		PostMethod method = new PostMethod("https://open.ys7.com:443/api/method");

		try {
			RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
			method.setRequestEntity(entity);
			client.executeMethod(method);

			InputStream inputStream = method.getResponseBodyAsStream();
			String restult = IOUtils.toString(inputStream);
			/* System.out.println(restult); */

			response.setHeader("Content-type", "text/html;charset=UTF-8");
			BufferedWriter bw = new BufferedWriter(response.getWriter());
			bw.write(restult);
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ�����
			method.releaseConnection();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {

	}

}
