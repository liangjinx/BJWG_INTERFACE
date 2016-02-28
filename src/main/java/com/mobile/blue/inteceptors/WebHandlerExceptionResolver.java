package com.mobile.blue.inteceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.mobile.blue.exception.LauncherAPIException;
import com.mobile.blue.util.CodeStatus;
import com.mobile.blue.util.I18nUtil;
import com.mobile.blue.util.Json;
import com.mobile.blue.view.ResultVO;

/**
 * 所有spring 抛出的异常捕捉类
 * 
 */
public class WebHandlerExceptionResolver implements HandlerExceptionResolver {
	public static String ERROR_CODE_PARAMETER_NAME = "errorCode";
	public static String ERROR_MESSAGE_PARAMETER_NAME = "errorMessage";

	private final static Log logger = LogFactory.getLog(WebHandlerExceptionResolver.class);

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		String viewName = WebHandlerExceptionResolver.getErrorInfo(request, response, exception);

		int errorCode = (Integer) request.getAttribute(ERROR_CODE_PARAMETER_NAME);
		String errorMessage = (String) request.getAttribute(ERROR_MESSAGE_PARAMETER_NAME);

		ModelAndView view = new ModelAndView(viewName);

		ResultVO<Object> result = new ResultVO<Object>();

		result.setStatus(errorCode);
		result.setErrorMessage(errorMessage);
		result.setResult(null);

		view.addObject("message", Json.toJson(result));

		return view;
	}

	public static void log(HttpServletRequest request) {
		Object obj = request.getAttribute("message");
		if (obj == null) {
			return;
		}
		String message = obj.toString();
		String url = request.getRequestURL().toString();
		if (message.startsWith("{")) {
			Exception e = new Exception("json url:" + url + " data:" + StringUtils.substring(message, 50));
			logger.error(message, e);
		}
	}

	public static String getErrorInfo(HttpServletRequest request, HttpServletResponse response, Throwable exception) {
		logger.info("exception:" + exception.getMessage(), exception);

		String errorCode = String.valueOf(CodeStatus.SYSTEM_ERROR);
		request.setAttribute(ERROR_CODE_PARAMETER_NAME, errorCode);
		request.setAttribute(ERROR_MESSAGE_PARAMETER_NAME, exception.getMessage());
		request.setAttribute("result", "");

		if (exception instanceof LauncherAPIException) {
			errorCode = String.valueOf(((LauncherAPIException) exception).getErrorCode());
			if (CodeStatus.SYSTEM_ERROR == ((LauncherAPIException) exception).getErrorCode()) {
				request.setAttribute("result", null);
				request.setAttribute(ERROR_CODE_PARAMETER_NAME, errorCode);
				request.setAttribute(ERROR_MESSAGE_PARAMETER_NAME,
						I18nUtil.getMessage(CodeStatus.SYSTEM_ERROR, null, null));
			} else {
				request.setAttribute(ERROR_CODE_PARAMETER_NAME, errorCode);
				request.setAttribute(ERROR_MESSAGE_PARAMETER_NAME, "");
				request.setAttribute("result", "");
			}
		}
		if (exception instanceof IllegalArgumentException) {
			errorCode = String.valueOf(CodeStatus.INPUT_PARAM_ERROR);
			request.setAttribute(ERROR_CODE_PARAMETER_NAME, errorCode);
			request.setAttribute(ERROR_MESSAGE_PARAMETER_NAME, "");
			request.setAttribute("result", null);
		}

		response.setStatus(HttpServletResponse.SC_OK);

		return "message.json";

	}

}
