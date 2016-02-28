<%@page import="com.mobile.blue.util.CodeStatus,com.mobile.blue.view.ResultVO,com.mobile.blue.util.Json,org.apache.commons.lang.math.NumberUtils"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%
	String viewName = com.mobile.blue.inteceptors.WebHandlerExceptionResolver.getErrorInfo(request,response,exception);

Object errorCode = request.getAttribute(com.mobile.blue.inteceptors.WebHandlerExceptionResolver.ERROR_CODE_PARAMETER_NAME);
Object errorMessage = request.getAttribute(com.mobile.blue.inteceptors.WebHandlerExceptionResolver.ERROR_MESSAGE_PARAMETER_NAME);

ResultVO<Object> result = new ResultVO<Object>();
result.setStatus(NumberUtils.toInt(String.valueOf(errorCode), CodeStatus.SYSTEM_ERROR));
result.setErrorMessage(String.valueOf(errorMessage));
result.setResult(null);

request.setAttribute("message", Json.toJson(result));
%>
<%@include file="message.json.jsp" %>
