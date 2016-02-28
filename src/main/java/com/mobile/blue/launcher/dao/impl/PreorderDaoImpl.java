package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.PreorderDao;
import com.mobile.blue.launcher.dao.mapper.AppPreorderMapper;
import com.mobile.blue.launcher.model.AppPreorder;
import com.mobile.blue.launcher.model.Example.AppPreorderExample;
import com.mobile.blue.launcher.model.Example.AppPreorderExample.Criteria;
import com.mobile.blue.util.DateUtil;

@Service("preorderDao")
public class PreorderDaoImpl implements PreorderDao {
	@Autowired
	private AppPreorderMapper appPreorderMapper;

	@Override
	public int countByExample(AppPreorderExample example, Criteria criteria) {
		int count = appPreorderMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int updatePreOrder(long userId, long projectId, int number) {
		AppPreorder preorder = new AppPreorder();
		preorder.setUserId(userId);
		preorder.setNum(number);
		preorder.setProjectId(projectId);
		preorder.setCtime(DateUtil.getCurrentDate());
		int flag = appPreorderMapper.updateByPrimaryKeySelective(preorder);
		return flag;
	}

	@Override
	public int insertPreorder(long userId, long projectId, int number) {
		AppPreorder preorder = new AppPreorder();
		preorder.setUserId(userId);
		preorder.setNum(number);
		preorder.setProjectId(projectId);
		preorder.setCtime(DateUtil.getCurrentDate());
		int flag = appPreorderMapper.insertSelective(preorder);
		return flag;
	}

	@Override
	public int deleteUserPreorder(long userId, long projectId) {
		AppPreorder preorder = new AppPreorder();
		preorder.setUserId(userId);
		preorder.setProjectId(projectId);
		int value = appPreorderMapper.deleteByPrimaryKey(preorder);
		System.out.println(value);
		return value;
	}

	@Override
	public List<AppPreorder> selectByexample(AppPreorderExample example, Criteria criteria) {
		List<AppPreorder> list=appPreorderMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
