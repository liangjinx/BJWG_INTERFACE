package com.mobile.blue.launcher.service;

public interface PreorderService {

	String saveUserPreSet(long userId, long projectId, byte type, boolean isCancel, int number);
	/**
	 * 查询用户设置的抢购项目的数量
	 * @param userId
	 * @param paincbuyProjectId
	 * @return
	 */
	int selectByUserIdAndProjectId(long userId, Long paincbuyProjectId);

}
