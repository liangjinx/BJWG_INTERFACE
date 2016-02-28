package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppProject;
import com.mobile.blue.launcher.model.Example.AppProjectExample;
import com.mobile.blue.launcher.model.Example.AppProjectExample.Criteria;

public interface ProjectDao {

	List<AppProject> selectByExample(AppProjectExample example, Criteria criteria);

	int updateProject(AppProject project);

}
