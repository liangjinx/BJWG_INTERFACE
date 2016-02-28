package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.UserExtDao;
import com.mobile.blue.launcher.dao.mapper.AppUserExtMapper;
import com.mobile.blue.launcher.model.AppUserExt;
import com.mobile.blue.launcher.model.Example.AppUserExtExample;
import com.mobile.blue.launcher.model.Example.AppUserExtExample.Criteria;
import com.mobile.blue.util.DateUtil;

@Service("userExtDao")
public class UserExtDaoImpl implements UserExtDao {
	@Autowired
	private AppUserExtMapper appUserExtMapper;

	@Override
	public int insertUserExt(AppUserExt userExt) {
		return appUserExtMapper.insertSelective(userExt);
	}

	@Override
	public int updateUserExt(long userId, byte type, int number) {
		AppUserExt userExt = new AppUserExt();
		if (number != 0) {
			userExt.setSettingValue(number);
		} else {
			userExt.setSettingValue(0);
		}
		userExt.setUserId(userId);
		userExt.setSettingType(type);
		userExt.setSettingTime(DateUtil.getCurrentDate());
		return appUserExtMapper.updateByPrimaryKeySelective(userExt);
	}

	@Override
	public int selectUserExtCount(AppUserExtExample example, Criteria criteria) {
		int count = appUserExtMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public List<AppUserExt> selectByExample(AppUserExtExample example, Criteria criteria) {
		List<AppUserExt> list=appUserExtMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
