package com.mobile.blue.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author edwin.zhou
 * 
 */
@Component
public class LoginFilter implements Filter {

	private Log logger = LogFactory.getLog(this.getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	// @Autowired
	// private UserSessionService userSessionService;
	//
	//
	// @Override
	// public void init(FilterConfig filterConfig) throws ServletException {
	// this.logger.info("init");
	// }
	//
	// @Override
	// public void doFilter(ServletRequest req, ServletResponse resp,
	// FilterChain chain) throws IOException, ServletException {
	// HttpServletRequest request = (HttpServletRequest) req;
	// String userId = request.getParameter("userId");
	//
	// String session = request.getParameter("session");
	//
	// String uri = RequestUtil.getRequestUri(request);
	// if (StringUtils.isEmpty(uri)) {
	// throw new FilterException("Get request URI is null.");
	// }
	//
	// ApiUser apiUser = new ApiUser();
	// apiUser.setId(userId);
	// apiUser.setSession(session);
	//
	// userSessionService.checkUserSession(apiUser);
	//
	// if(request.getCharacterEncoding() == null){
	// request.setCharacterEncoding("UTF-8");
	// }
	//
	// chain.doFilter(request, resp);
	// }
	//
	// @Override
	// public void destroy() {
	//
	// this.logger.info("destory");
	// }

}
