package com.mobile.blue.launcher.videoAPI;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;

import net.sf.json.JSONObject;

public class TimeController extends HttpServlet {

	public TimeController() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	private static final String TEST_HOST = "https://open.ys7.com:443/api/";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NameValuePair> pairsList = new ArrayList<NameValuePair>();
		/** ������(�������軻���Լ���appkey) */
		pairsList.add(new NameValuePair("appKey", "25b4ce8945cb409ba8adcadaa04a8dc4"));

		sendHttpRequest(pairsList, "time/get");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected static JSONObject sendHttpRequest(List<NameValuePair> pairsList, String method) {
		ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
		Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
		HttpClient httpClient = new HttpClient();

		PostMethod postMethod = new PostMethod(TEST_HOST + method);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		NameValuePair[] valuePairs = pairsList.toArray(new NameValuePair[0]);
		postMethod.setRequestBody(valuePairs);
		JSONObject object = null;

		try {
			httpClient.executeMethod(postMethod);
			InputStream inputStream = postMethod.getResponseBodyAsStream();
			String returnReult = IOUtils.toString(inputStream);

			System.out.println(returnReult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return object;
	}

	public void init() throws ServletException {

	}

}
