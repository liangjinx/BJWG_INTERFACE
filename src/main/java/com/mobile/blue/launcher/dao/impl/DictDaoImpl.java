package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.DictDao;
import com.mobile.blue.launcher.dao.mapper.AppDictMapper;
import com.mobile.blue.launcher.model.AppDict;
import com.mobile.blue.launcher.model.Example.AppDictExample;
import com.mobile.blue.launcher.model.Example.AppDictExample.Criteria;

@Service("dictDao")
public class DictDaoImpl implements DictDao {
	@Autowired
	private AppDictMapper appDictMapper;

	@Override
	public List<AppDict> selectByExamlpe(AppDictExample example, Criteria criteria) {
		List<AppDict> list = appDictMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
