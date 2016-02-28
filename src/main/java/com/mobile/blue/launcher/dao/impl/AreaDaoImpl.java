package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.AreaDao;
import com.mobile.blue.launcher.dao.mapper.AppAreaMapper;
import com.mobile.blue.launcher.model.AppArea;
import com.mobile.blue.launcher.model.Example.AppAreaExample;
import com.mobile.blue.launcher.model.Example.AppAreaExample.Criteria;

@Service("areaDao")
public class AreaDaoImpl implements AreaDao {
	@Autowired
	private AppAreaMapper appAreaMapper;

	@Override
	public List<AppArea> selectByExample(AppAreaExample example, Criteria criteria) {
		List<AppArea> list = appAreaMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countByExample(AppAreaExample appareaExample,Criteria criteria) {
		int count =appAreaMapper.countByExample(appareaExample);
		criteria.getAllCriteria().clear();
		return count;
	}

}
