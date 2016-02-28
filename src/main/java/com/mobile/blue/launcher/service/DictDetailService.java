package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

public interface DictDetailService {

	List<Map<String, Object>> selectGrowUp(long id, int day);

	List<Map<String, Object>> queryReturnsWay(Long dictId);

	String selectvalueByName(String bank);

	List<Map<String, Object>> selectBankNamelist();

	Map<String, Object> verifyBankcard(String bankCardNumber);

	String getvalueById(long fentiwayId);

}
