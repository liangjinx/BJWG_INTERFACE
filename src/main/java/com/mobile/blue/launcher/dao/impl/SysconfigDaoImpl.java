package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.SysconfigDao;
import com.mobile.blue.launcher.dao.mapper.AppSysConfigMapper;
import com.mobile.blue.launcher.model.AppSysConfig;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample.Criteria;

@Service("sysconfigDao")
public class SysconfigDaoImpl implements SysconfigDao {
	@Autowired
	private AppSysConfigMapper appSysconfigMapper;

	@Override
	public List<AppSysConfig> selectByExample(AppSysConfigExample sysConfigExample, Criteria criteria) {
		List<AppSysConfig> list = appSysconfigMapper.selectByExample(sysConfigExample);
		criteria.getAllCriteria().clear();
		if (list.size() <= 0) {
			return null;
		}
		for (AppSysConfig config : list) {
			config.setRemark(config.getRemark().replaceAll("<p>|</p>", ""));
		}
		return list;
	}
}
