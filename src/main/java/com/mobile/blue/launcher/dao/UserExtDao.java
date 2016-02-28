package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppUserExt;
import com.mobile.blue.launcher.model.Example.AppUserExtExample;
import com.mobile.blue.launcher.model.Example.AppUserExtExample.Criteria;

public interface UserExtDao {

	int insertUserExt(AppUserExt userExt);

	int updateUserExt(long userId, byte type, int number);

	int selectUserExtCount(AppUserExtExample example, Criteria criteria);

	List<AppUserExt> selectByExample(AppUserExtExample example, Criteria criteria);

}
