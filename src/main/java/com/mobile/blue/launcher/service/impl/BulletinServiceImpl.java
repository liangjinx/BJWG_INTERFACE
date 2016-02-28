package com.mobile.blue.launcher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.BulletinDao;
import com.mobile.blue.launcher.model.AppBulletin;
import com.mobile.blue.launcher.model.Example.AppBulletinExample;
import com.mobile.blue.launcher.model.Example.AppBulletinExample.Criteria;
import com.mobile.blue.launcher.service.BulletinService;

@Service("bulletinService")
public class BulletinServiceImpl implements BulletinService {
	List<AppBulletin> list = null;
	@Autowired
	private BulletinDao bulletinDao;

	@Override
	public List<AppBulletin> selectbullet() {
		AppBulletinExample example = new AppBulletinExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("ctime desc");
		list = bulletinDao.selectByExample(example, criteria);
		for (AppBulletin message : list) {
			message.setContent(message.getContent().replaceAll("</?[p|P][^>]*>", ""));
		}
		return list;
	}

}
