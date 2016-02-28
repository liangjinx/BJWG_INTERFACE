package com.mobile.blue.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * http request common class
 * 
 * @author edwin.zhou
 * 
 */
public class HttpClientUtils {

	public static final String DEFAULT_CHARSET = "UTF-8";

	private static String APPLICATION_JSON = "application/json;charset=utf-8";

	private static final int CONNECTION_TIMEOUT = NumberUtils.toInt(PropertiesUtil.getProperty("CONNECTION.TIMEOUT"),
			30000);
	private static final int SO_TIMEOUT = NumberUtils.toInt(PropertiesUtil.getProperty("SO.TIMEOUT"), 40000);

	public static String getMethodRequest(String url, String charSet) throws Exception {

		StringBuilder result = new StringBuilder();

		HttpParams httpParams = new BasicHttpParams();
		// 设置连接超时时间(单位毫秒)
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
		// 设置读数据超时时间(单位毫秒)
		HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);

		HttpClient httpclient = new DefaultHttpClient(httpParams);

		// Prepare a request object
		HttpGet httpget = new HttpGet(url);

		httpget.setHeader("Content-Type", "application/json");

		httpget.setHeader("Accept", "application/json");

		// Execute the request
		HttpResponse response = httpclient.execute(httpget);

		// Examine the response status
		// System.out.println(response.getStatusLine());
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			throw new Exception("Execute a request failed: response status code " + statusCode);
		}

		// Get hold of the response entity
		HttpEntity entity = response.getEntity();

		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {

				BufferedReader reader = new BufferedReader(new InputStreamReader(instream, charSet));

				String line = null;
				while ((line = reader.readLine()) != null) {

					result.append(line);
				}

			} catch (IOException ex) {

				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;

			} catch (RuntimeException ex) {

				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httpget.abort();
				throw ex;

			} finally {

				// Closing the input stream will trigger connection release
				instream.close();

			}

			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}

		return result.toString();
	}

	public static String postMethodRequest(String url, Map<String, String> params) throws Exception {

		StringBuilder result = new StringBuilder();

		HttpParams httpParams = new BasicHttpParams();
		// 设置连接超时时间(单位毫秒)
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
		// 设置读数据超时时间(单位毫秒)
		HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);

		HttpClient httpclient = new DefaultHttpClient(httpParams);

		// Prepare a request object
		HttpPost httppost = new HttpPost(url);

		if (params != null && !params.isEmpty()) {
			Set<Map.Entry<String, String>> paramsSet = params.entrySet();
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			for (Map.Entry<String, String> entry : paramsSet) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}

			httppost.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));

			// httppost.setHeader("Content-type", "application/json");
			// //header设置
		}

		// Execute the request
		HttpResponse response = httpclient.execute(httppost);

		// Examine the response status
		// System.out.println(response.getStatusLine());
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			throw new Exception("Execute a request failed: response status code " + statusCode);
		}

		// Get hold of the response entity
		HttpEntity entity = response.getEntity();

		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {

				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

				String line = null;
				while ((line = reader.readLine()) != null) {

					result.append(line);
				}

			} catch (IOException ex) {

				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;

			} catch (RuntimeException ex) {

				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httppost.abort();
				throw ex;

			} finally {

				// Closing the input stream will trigger connection release
				instream.close();

			}

			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}

		return result.toString();
	}

	public static String postMethodRequest(String url, Map<String, String> params, int connectionTimeout, int soTimeout)
			throws Exception {

		StringBuilder result = new StringBuilder();

		HttpParams httpParams = new BasicHttpParams();
		// 设置连接超时时间(单位毫秒)
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
		// 设置读数据超时时间(单位毫秒)
		HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);

		HttpClient httpclient = new DefaultHttpClient(httpParams);
		// Prepare a request object
		HttpPost httppost = new HttpPost(url);

		if (params != null && !params.isEmpty()) {
			Set<Map.Entry<String, String>> paramsSet = params.entrySet();
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			for (Map.Entry<String, String> entry : paramsSet) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}

			httppost.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
		}

		// Execute the request
		HttpResponse response = httpclient.execute(httppost);

		// Examine the response status
		// System.out.println(response.getStatusLine());
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			throw new Exception("Execute a request failed: response status code " + statusCode);
		}

		// Get hold of the response entity
		HttpEntity entity = response.getEntity();

		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {

				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

				String line = null;
				while ((line = reader.readLine()) != null) {

					result.append(line);
				}

			} catch (IOException ex) {

				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;

			} catch (RuntimeException ex) {

				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httppost.abort();
				throw ex;

			} finally {

				// Closing the input stream will trigger connection release
				instream.close();

			}

			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}

		return result.toString();
	}

	public static String postMethodRequestByJson(String url, String jsonString) throws Exception {
		StringBuilder result = new StringBuilder();

		HttpParams httpParams = new BasicHttpParams();
		// 设置连接超时时间(单位毫秒)
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
		// 设置读数据超时时间(单位毫秒)
		HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);

		HttpClient httpclient = new DefaultHttpClient(httpParams);

		// Prepare a request object
		HttpPost httppost = new HttpPost(url);

		// add by simon start
		httpclient = WebClientDevWrapper.wrapClient(httpclient);
		List<Header> headers = new ArrayList<Header>();
		headers.add(new BasicHeader("Content-Type", APPLICATION_JSON));
		headers.add(new BasicHeader("Accept", APPLICATION_JSON));
		httpclient.getParams().setParameter("http.default-headers", headers);
		StringEntity stringEntity = new StringEntity(jsonString, DEFAULT_CHARSET);
		httppost.setEntity(stringEntity);
		// add by simon end

		/*
		 * if (params != null && !params.isEmpty()) { Set<Map.Entry<String,
		 * String>> paramsSet = params.entrySet(); List<NameValuePair> nvps =
		 * new ArrayList<NameValuePair>();
		 * 
		 * for (Map.Entry<String, String> entry : paramsSet) { nvps.add(new
		 * BasicNameValuePair(entry.getKey(), entry.getValue())); }
		 * 
		 * httppost.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
		 * }
		 */

		// Execute the request
		HttpResponse response = httpclient.execute(httppost);

		// Examine the response status
		// System.out.println(response.getStatusLine());
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			System.out.println(response);
			throw new Exception("Execute a request failed: response status code " + statusCode);
		}

		// Get hold of the response entity
		HttpEntity entity = response.getEntity();

		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {

				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

				String line = null;
				while ((line = reader.readLine()) != null) {

					result.append(line);
				}

			} catch (IOException ex) {

				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;

			} catch (RuntimeException ex) {

				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httppost.abort();
				throw ex;

			} finally {

				// Closing the input stream will trigger connection release
				instream.close();

			}

			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}

		// return result.toString();
		// System.out.println("------>"+result.toString());
		return URLDecoder.decode(result.toString(), DEFAULT_CHARSET);
	}

	public static String postMethodRequestByJson2(String url, String jsonString) throws Exception {
		StringBuilder result = new StringBuilder();

		HttpParams httpParams = new BasicHttpParams();
		// 设置连接超时时间(单位毫秒)
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
		// 设置读数据超时时间(单位毫秒)
		HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);

		HttpClient httpclient = new DefaultHttpClient(httpParams);

		// Prepare a request object
		HttpPost httppost = new HttpPost(url);

		// add by simon start
		httpclient = WebClientDevWrapper.wrapClient(httpclient);
		List<Header> headers = new ArrayList<Header>();
		headers.add(new BasicHeader("Content-Type", APPLICATION_JSON));
		headers.add(new BasicHeader("Accept", APPLICATION_JSON));
		httpclient.getParams().setParameter("http.default-headers", headers);
		StringEntity stringEntity = new StringEntity(jsonString, DEFAULT_CHARSET);
		httppost.setEntity(stringEntity);
		// add by simon end

		/*
		 * if (params != null && !params.isEmpty()) { Set<Map.Entry<String,
		 * String>> paramsSet = params.entrySet(); List<NameValuePair> nvps =
		 * new ArrayList<NameValuePair>();
		 * 
		 * for (Map.Entry<String, String> entry : paramsSet) { nvps.add(new
		 * BasicNameValuePair(entry.getKey(), entry.getValue())); }
		 * 
		 * httppost.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
		 * }
		 */

		// Execute the request
		HttpResponse response = httpclient.execute(httppost);

		// Examine the response status
		// System.out.println(response.getStatusLine());
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			System.out.println(response);
			throw new Exception("Execute a request failed: response status code " + statusCode);
		}

		// Get hold of the response entity
		HttpEntity entity = response.getEntity();

		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {

				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

				String line = null;
				while ((line = reader.readLine()) != null) {

					result.append(line);
				}

			} catch (IOException ex) {

				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;

			} catch (RuntimeException ex) {

				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httppost.abort();
				throw ex;

			} finally {

				// Closing the input stream will trigger connection release
				instream.close();

			}

			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}

		// return result.toString();
		// System.out.println("------>"+result.toString());
		// return URLDecoder.decode(result.toString(),DEFAULT_CHARSET);
		return result.toString();
	}

	public static void main(String[] args) throws Exception {

		/*
		 * JSONStringer js = new JSONStringer(); js.object();
		 * js.key("clientId").value(
		 * "REFBQ2xpZW50SWREQUFDbGllbnRJZERBQUNsaWVudElkREFBQ2xpZW50SWREQUFDbGllbnRJZERBQ"
		 * ); js.key("timeStamp").value("1405656911573");
		 * js.key("serverId").value("InternetGateway010101");
		 * js.key("signature").value(
		 * "NDAwMjAwMDIwMDAxMDAyX2FuZHJvaWRfMS4wLjA=20001MIICHzCC");
		 * js.endObject(); System.out.println("result:" +
		 * HttpClientUtils.postMethodRequestByJson2(
		 * "https://iot-apigw.ais.co.th:14200/v1/loginByB2B.json",
		 * js.toString()));
		 */

		Map<String, String> params = new HashMap<String, String>();
		params.put("clientOS", "wp7");
		params.put("lang", "zh");
		System.out.println("result:"
				+ HttpClientUtils.postMethodRequest("http://120.25.2.222/buuluu_webservice/sendActivation.do", params));
				// System.out.println("result:" +
				// HttpClientUtils.getMethodRequest("http://www.cherrypicks.com"));

		/**
		 * Assert.hasText(lang, null); Assert.notNull(device,null);
		 * Assert.hasText(deviceVerNum, null); Assert.hasText(imei, null);
		 * Assert.hasText(mac, null); Assert.hasText(imsi,null);
		 * Assert.hasText(countryCode, null); Assert.hasText(tel, null);
		 * Assert.hasText(pwd, null);
		 */
		// Map<String, String> params = new HashMap<String, String>();
		// params.put("lang", "en_US");
		// params.put("device", "1");
		// params.put("deviceVerNum", "1.0.0");
		// params.put("imei", "asc");
		// params.put("mac", "adf");
		// params.put("imsi", "adsf");
		// params.put("countryCode", "86");
		// params.put("tel", "1234555999");
		// params.put("pwd", "1234");
		// params.put("log", "1234");
		// params.put("lat", "1234");
		// params.put(" pushStatus", "1");
		// System.out.println("result:" +
		// HttpClientUtils.postMethodRequest("http://localhost:8080/buuluu_api_webservice/register.do",
		// params));
		//
		//
		// categoryid=1&classid=1&order=apkSizeRaw&orderType=asc&page=1
		// String subject ="abc";
		// String msg = "accc";
		// params.put("subject", subject);
		// params.put("recipient", "495928221@qq.com");
		// params.put("cc", "");
		// params.put("msg", msg);
		// params.put("templateid", "system");
		// System.out.println("result:" +
		// HttpClientUtils.postMethodRequest("http://58.96.173.161:8081/notifyCentreServer/email",
		// params));

	}
}
