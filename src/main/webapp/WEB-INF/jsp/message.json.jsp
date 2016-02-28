<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%response.setHeader("Access-Control-Allow-Origin","*");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:out value="${message }" escapeXml="false"/>