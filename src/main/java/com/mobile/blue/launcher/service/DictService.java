package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

public interface DictService {

	List<Map<String, Object>> selectGrowUp(String dictGroupRecord, int day);

	String queryRepayWay(String thickType);

	String queryReturnsWay();

}
