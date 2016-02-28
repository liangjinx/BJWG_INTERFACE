package com.mobile.blue.launcher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.UserExtDao;
import com.mobile.blue.launcher.model.AppUserExt;
import com.mobile.blue.launcher.model.Example.AppUserExtExample;
import com.mobile.blue.launcher.model.Example.AppUserExtExample.Criteria;
import com.mobile.blue.launcher.service.UserExtService;
import com.mobile.blue.util.constant.BasicConstant;

@Service("userExtService")
public class UserExtServiceImpl implements UserExtService {
	List<AppUserExt> list = null;
	@Autowired
	private UserExtDao userExtDao;

	@Override
	public int insertUserExt(Long userId) {
		AppUserExt userext = new AppUserExt();
		userext.setUserId(userId);
		userext.setLastButtinId(BasicConstant.DEFAULT_LAST_BUTTION_ID);
		return userExtDao.insertUserExt(userext);
	}

	@Override
	public int updateUserExt(long userId, byte type, int number) {
		return userExtDao.updateUserExt(userId, type, number);
	}

	@Override
	public int selectUserExtCount(long userId) {
		AppUserExtExample example = new AppUserExtExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return userExtDao.selectUserExtCount(example, criteria);
	}

	@Override
	public int insertUserExt(long userId, long projectId, int number, byte type) {
		AppUserExt userext = new AppUserExt();
		userext.setUserId(userId);
		userext.setLastButtinId(BasicConstant.DEFAULT_LAST_BUTTION_ID);
		userext.setSettingType(type);
		userext.setSettingValue(number);
		return userExtDao.insertUserExt(userext);
	}

	@Override
	public List<AppUserExt> selectUserExt(long userId) {
		AppUserExtExample example = new AppUserExtExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return userExtDao.selectByExample(example,criteria);
	}

}
