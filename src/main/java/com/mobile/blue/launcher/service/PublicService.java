package com.mobile.blue.launcher.service;

import javax.servlet.http.HttpServletRequest;

public interface PublicService {

	String compileVerify(HttpServletRequest request, int type, String[] param) throws Exception;

	String getIndex(long userId);

	String ThisProject(HttpServletRequest request,long projectId);

}
