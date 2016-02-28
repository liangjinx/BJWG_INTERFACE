package com.mobile.blue.util;

import com.google.gson.Gson;
import com.mobile.blue.view.ResultVO;

public class ResultUtil {

	public static Object getResultJson(Object object) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		return resultVo;
	}

	public static String getResultJson(int status, String errorMessage) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setStatus(status);
		resultVo.setErrorMessage(errorMessage);

		Gson json = new Gson();
		return json.toJson(resultVo);
	}

	public static String getResultJson(Object object, int status, String errorMessage) {
		ResultVO<Object> resultVo = new ResultVO<Object>();
		resultVo.setResult(object);
		resultVo.setStatus(status);
		resultVo.setErrorMessage(errorMessage);
		Gson json = new Gson();
		return json.toJson(resultVo);
	}
}
