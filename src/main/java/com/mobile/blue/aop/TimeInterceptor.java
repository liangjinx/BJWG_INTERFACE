package com.mobile.blue.aop;

import java.text.DecimalFormat;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

/**
 * 
 * @author More
 */

@Component("timeInterceptor")
public class TimeInterceptor implements MethodInterceptor {

	// private Log controllerTimelog =
	// LogFactory.getLog("CONTROLLER_FUNCTION_TIME_LOG");

	private Log requestParameterLog = LogFactory.getLog("REQUEST_PARAMETER_LOG");

	@Around(value = "execution(public * com.mobile.blue.launcher.controller.*.*(..)) ")
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		long procTime = System.currentTimeMillis();
		try {
			Object result = methodInvocation.proceed();
			return result;
		} finally {
			String sec = new DecimalFormat("0.000").format(((System.currentTimeMillis() - procTime) / 1000D));
			requestParameterLog.info(sec + " sec [" + methodInvocation.getMethod().getName() + "]");
		}
	}
}
