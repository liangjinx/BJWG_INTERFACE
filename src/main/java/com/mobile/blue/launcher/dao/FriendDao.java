package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppFriend;
import com.mobile.blue.launcher.model.Example.AppFriendExample;
import com.mobile.blue.launcher.model.Example.AppFriendExample.Criteria;

public interface FriendDao {

	int insertSelective(AppFriend friend);

	List<AppFriend> selectFriends(AppFriendExample freindsExample, Criteria criteria);

	int countByExample(AppFriendExample freindsExample, Criteria criteria);

	int deleteFriend(long userId, long friendId);

	int updateFriendStatus(AppFriend friend);

}
