package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppMessage;
import com.mobile.blue.launcher.model.Example.AppMessageExample;
import com.mobile.blue.launcher.model.Example.AppMessageExample.Criteria;

public interface MessageDao {

	List<AppMessage> selectByExample(AppMessageExample example, Criteria criteria);

	int countByExample(AppMessageExample example, Criteria criteria);

	int addMessage(long userId, String orderMessage, int messageTyoe, long orderId, byte relationType);

	int deleteMessage(AppMessage message);

	int updateMessage(AppMessage message);

}
