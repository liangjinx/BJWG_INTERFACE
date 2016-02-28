package com.mobile.blue.launcher.service;

import java.util.List;

import com.mobile.blue.launcher.model.AppUserExt;

public interface UserExtService {

	int insertUserExt(Long userId);

	int updateUserExt(long userId, byte type, int number);

	int selectUserExtCount(long userId);

	int insertUserExt(long userId, long projectId, int number, byte type);

	List<AppUserExt> selectUserExt(long userId);

}
