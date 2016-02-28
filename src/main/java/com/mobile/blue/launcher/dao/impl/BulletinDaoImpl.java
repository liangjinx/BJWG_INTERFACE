package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.BulletinDao;
import com.mobile.blue.launcher.dao.mapper.AppBulletinMapper;
import com.mobile.blue.launcher.model.AppBulletin;
import com.mobile.blue.launcher.model.Example.AppBulletinExample;
import com.mobile.blue.launcher.model.Example.AppBulletinExample.Criteria;

@Service("bulletinDao")
public class BulletinDaoImpl implements BulletinDao {
	@Autowired
	private AppBulletinMapper appBulletinMapper;

	@Override
	public List<AppBulletin> selectByExample(AppBulletinExample example, Criteria criteria) {
		List<AppBulletin> list = appBulletinMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
