package com.mobile.blue.launcher.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppFriend;
import com.mobile.blue.launcher.model.Example.AppFriendExample;

@Component
@MyBatisRepository
public interface AppFriendMapper {
	int countByExample(AppFriendExample example);

	int insert(AppFriend record);

	int insertSelective(AppFriend record);

	List<AppFriend> selectByExample(AppFriendExample example);

	int delete(Map<String, Long> map);

	int updateByPrimaryKeySelective(AppFriend record);

}