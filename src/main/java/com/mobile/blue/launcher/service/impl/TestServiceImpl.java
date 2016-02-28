package com.mobile.blue.launcher.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.TestDao;
import com.mobile.blue.launcher.model.AppTestUserFenyeExample;
import com.mobile.blue.launcher.model.AppTestUserFenyeExample.Criteria;
import com.mobile.blue.launcher.service.Tesstpage;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
@Service("tesstpage")
public class TestServiceImpl implements Tesstpage {
	@Autowired 
	private TestDao testDao;
	@Override
	public String select(HttpServletRequest request,int SorN) {
		AppTestUserFenyeExample example =new AppTestUserFenyeExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameLike("%158%");
		return ResultUtil.getResultJson(testDao.select(request,SorN), Status.success.getStatus(),
				Status.success.getMsg());
	}

}
