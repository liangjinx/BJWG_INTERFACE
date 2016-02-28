package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.UserDao;
import com.mobile.blue.launcher.dao.mapper.AppUserMapper;
import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.launcher.model.Example.AppUserExample;
import com.mobile.blue.launcher.model.Example.AppUserExample.Criteria;

@Service("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private AppUserMapper appUserMapper;

	@Override
	public int countByExample(AppUserExample userExample, Criteria criteria) {
		int count = appUserMapper.countByExample(userExample);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public List<AppUser> selectByExample(AppUserExample userExample, Criteria criteria) {
		List<AppUser> list = appUserMapper.selectByExample(userExample);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int saveUser(AppUser user) {
		return appUserMapper.insertSelective(user);
	}

	@Override
	public int updateUserByUserIdOrPhone(AppUser user) {
		return appUserMapper.updateByPrimaryKeySelective(user);
	}
}
