package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mobile.blue.launcher.model.AppMyEarnings;

public interface EarningsService {

	List<Map<String, Object>> selectInvestList(long userID, HttpServletRequest request, int nextPage);

	Map<String, Object> selectInvestOne(long userId, long projectId);

	int selectPigcount(long userId);

	String selectMyPig(long userId);

	String sendFriendPig(long userId, long friendId, long earningsId, int number);

	double selectEarnings(long userId);

	List<Map<String, Object>> myearningslist(long userId);

	Map<String, Object> selectIndex(long userId);

	String earningsRanking(HttpServletRequest request, long userId, int nextPage);

	String updateReturnWay(byte beforeDealType, byte dealType, long earningId, long userId);

	AppMyEarnings selectByearningsId(Long presentRelationId);

}
