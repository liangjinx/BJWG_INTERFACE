package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppBulletin;
import com.mobile.blue.launcher.model.Example.AppBulletinExample;
import com.mobile.blue.launcher.model.Example.AppBulletinExample.Criteria;

public interface BulletinDao {

	List<AppBulletin> selectByExample(AppBulletinExample example, Criteria criteria);

}
