package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.ProjectDao;
import com.mobile.blue.launcher.dao.mapper.AppProjectMapper;
import com.mobile.blue.launcher.model.AppProject;
import com.mobile.blue.launcher.model.Example.AppProjectExample;
import com.mobile.blue.launcher.model.Example.AppProjectExample.Criteria;

@Service("projectDao")
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private AppProjectMapper appProjectMapper;

	@Override
	public List<AppProject> selectByExample(AppProjectExample example, Criteria criteria) {
		List<AppProject> list = appProjectMapper.selectByExampleWithBLOBs(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int updateProject(AppProject project) {
		return appProjectMapper.updateByPrimaryKeySelective(project);
	}

}
