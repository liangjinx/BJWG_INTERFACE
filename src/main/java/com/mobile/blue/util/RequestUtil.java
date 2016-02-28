package com.mobile.blue.util;

import java.util.Enumeration;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mobile.blue.util.constant.BasicConstant;

/**
 * 请求公用类
 * 
 * @author edwin.zhou
 */
public class RequestUtil {

	 private static Log logger = LogFactory.getLog(RequestUtil.class);
	public static int getPageid(HttpServletRequest request, String name) {
		int pageid = NumberUtils.toInt(request.getParameter(name));
		if (pageid <= 0) {
			return 1;
		}
		return pageid;
	}

	public static String getUrl(HttpServletRequest request) {
		StringBuffer sb = request.getRequestURL();
		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			sb.append('?').append(queryString);
		}
		return sb.toString();
	}

	public static String getReferer(HttpServletRequest request) {
		return request.getHeader("referer");
	}

	public static String getRequestUri(HttpServletRequest request) {
		return request.getRequestURI();
	}

	private static final java.util.regex.Pattern IS_LICIT_IP_PATTERN = java.util.regex.Pattern
			.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$");

	public static boolean isLicitIp(final String ip) {
		if (StringUtils.isEmpty(ip)) {
			return false;
		}

		Matcher m = IS_LICIT_IP_PATTERN.matcher(ip);
		if (!m.find()) {
			return false;
		}
		return true;
	}

	public static boolean isSsl(HttpServletRequest request) {
		boolean isSsl = "true".equalsIgnoreCase(request.getHeader("ssl"));
		return isSsl;
	}

	public static String getProtocol(HttpServletRequest request) {
		boolean isSsl = RequestUtil.isSsl(request);
		String protocol;
		if (isSsl) {
			protocol = "https";
		} else {
			protocol = "http";
		}
		return protocol;
	}

	public static String getRedirect(HttpServletRequest request, String url) {
		if (StringUtils.isEmpty(url)) {
			throw new NullPointerException("url parameters can not be null.");
		}
		if (url.startsWith("http")) {
			return url;
		}
		boolean isSsl = RequestUtil.isSsl(request);
		if (!isSsl) {
			return url;
		}
		if (!url.startsWith("/")) {
			String path = request.getServletPath();
			int index = path.lastIndexOf('/');
			if (index != -1) {
				url = path.substring(0, index + 1) + url;
			}
		}
		String serverName = request.getServerName();

		return "https://" + serverName + url;
	}

	@SuppressWarnings("unchecked")
	public static void printHeaders(HttpServletRequest request) {
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + ":" + value);
		}
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	public static int getCurrindex(HttpServletRequest request,String index_goumai_ranking){
		logger.info("当前对象是："+request.getSession());
		String index=request.getSession().getAttribute(index_goumai_ranking)==null?"1":request.getSession().getAttribute(index_goumai_ranking).toString();
		logger.info(index_goumai_ranking+"缓存保存的分页当前的页码是:"+index);
		request.getSession().setAttribute(index_goumai_ranking, Integer.parseInt(index)+BasicConstant.limit_page_size);
		logger.info("修改后的index值是"+request.getSession().getAttribute(index_goumai_ranking));
		request.getSession().setMaxInactiveInterval(BasicConstant.VERIF_CODE_time*60);
		
		return Integer.parseInt(index);
	}
}
