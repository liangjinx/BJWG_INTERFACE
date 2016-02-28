package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppSysConfig;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample.Criteria;

public interface SysconfigDao {

	List<AppSysConfig> selectByExample(AppSysConfigExample sysConfigExample, Criteria criteria);

}
