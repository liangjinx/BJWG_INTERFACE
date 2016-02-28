package com.mobile.blue.launcher.videoAPI;

import java.util.HashMap;
import java.util.Map;

public class TokenControllerTest extends PublicControllerTest {
	// ��ȡtoken�������
	public void getAccessToken() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("phone", "15695718489");
		Map<String, Object> map = paramsInit("token/getAccessToken", paramsMap);
		doPost(map);
	}

}
