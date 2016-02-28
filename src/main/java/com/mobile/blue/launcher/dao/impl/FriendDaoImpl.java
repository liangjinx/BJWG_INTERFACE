package com.mobile.blue.launcher.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.FriendDao;
import com.mobile.blue.launcher.dao.mapper.AppFriendMapper;
import com.mobile.blue.launcher.model.AppFriend;
import com.mobile.blue.launcher.model.Example.AppFriendExample;
import com.mobile.blue.launcher.model.Example.AppFriendExample.Criteria;

@Service("friendDao")
public class FriendDaoImpl implements FriendDao {
	@Autowired
	private AppFriendMapper appFriendMapper;

	@Override
	public int insertSelective(AppFriend friend) {
		return appFriendMapper.insertSelective(friend);
	}

	@Override
	public List<AppFriend> selectFriends(AppFriendExample freindsExample, Criteria criteria) {
		List<AppFriend> list = appFriendMapper.selectByExample(freindsExample);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countByExample(AppFriendExample freindsExample, Criteria criteria) {
		int count = appFriendMapper.countByExample(freindsExample);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int deleteFriend(long userId, long friendId) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("myUserId", userId);
		map.put("freindId", friendId);
		return appFriendMapper.delete(map);
	}

	@Override
	public int updateFriendStatus(AppFriend friend) {
		return appFriendMapper.updateByPrimaryKeySelective(friend);
	}

}
