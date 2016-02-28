package com.mobile.blue.launcher.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mobile.blue.launcher.model.AppTestUserFenye;

public interface TestDao {

	List<AppTestUserFenye> select( HttpServletRequest request,int currentpage);

}
