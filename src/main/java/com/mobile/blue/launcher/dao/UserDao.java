package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.launcher.model.Example.AppUserExample;
import com.mobile.blue.launcher.model.Example.AppUserExample.Criteria;

public interface UserDao {

	int countByExample(AppUserExample example, Criteria criteria);

	List<AppUser> selectByExample(AppUserExample userExample, Criteria criteria);

	int saveUser(AppUser user);

	int updateUserByUserIdOrPhone(AppUser user);

}
