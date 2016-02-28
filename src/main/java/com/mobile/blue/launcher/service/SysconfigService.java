package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

public interface SysconfigService {

	String queryByCode(String code);

	String getUrl(Object systemConfig, String invitecode);

	String selectStatus(String string, int day);

	List<Map<String, Object>> selectDivisionWay();

	Map<String, Object> queryList();

	String returnWayExplain(byte returTtype);

	String expensesList();

	Map<String, Object> queryWxAppidAndAppKey();

	List<Map<String, Object>> selectByCode(String packageSpecs);

}
