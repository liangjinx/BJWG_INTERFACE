package com.mobile.blue.launcher.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FriendService {

	String selectFriends(HttpServletRequest request,long userId);

	String searchNewFriendS(HttpServletRequest request, long userId, String value,int nextpage);

	int addFriend(Long myUserId, Date SendagreeTime, Long friendId, int type, String message);

	String deleteFriend(long userId, long friendId);

	String updateFriendStatus(long userId, long friendId, byte status);

	int selectFriendCount(long friendId, long userId);

	List<Map<String, Object>> newFriendRefresh(HttpServletRequest request, long userId, int nextPage);

	List<Map<String, Object>> lodFriendRefresh(HttpServletRequest request, long userId, int nextPage);
}
