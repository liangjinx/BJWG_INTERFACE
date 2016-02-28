package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppPreorder;
import com.mobile.blue.launcher.model.Example.AppPreorderExample;
import com.mobile.blue.launcher.model.Example.AppPreorderExample.Criteria;

public interface PreorderDao {

	int countByExample(AppPreorderExample example, Criteria criteria);

	int updatePreOrder(long userId, long projectId, int number);

	int insertPreorder(long userId, long projectId, int number);

	int deleteUserPreorder(long userId, long projectId);

	List<AppPreorder> selectByexample(AppPreorderExample example, Criteria criteria);

}
