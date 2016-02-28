package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.MessageDao;
import com.mobile.blue.launcher.dao.mapper.AppMessageMapper;
import com.mobile.blue.launcher.model.AppMessage;
import com.mobile.blue.launcher.model.Example.AppMessageExample;
import com.mobile.blue.launcher.model.Example.AppMessageExample.Criteria;
import com.mobile.blue.util.DateUtil;

@Service("messageDao")
public class MessageDaoImpl implements MessageDao {
	private Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private AppMessageMapper appMessageMapper;

	@Override
	public List<AppMessage> selectByExample(AppMessageExample example, Criteria criteria) {
		List<AppMessage> list = appMessageMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countByExample(AppMessageExample example, Criteria criteria) {
		int count = appMessageMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int addMessage(long userId, String orderMessage, int messageTyoe, long orderId, byte relationType) {
		AppMessage message = new AppMessage();
		message.setUserId(userId);
		message.setCtime(DateUtil.getCurrentDate());
		message.setContent(orderMessage);
		message.setMessageType(new Integer(messageTyoe).byteValue());
		message.setRelationId(orderId);
		message.setRelationType(relationType);
		message.setStatus(new Integer(0).byteValue());
		logger.info("message:"+message.getContent());
		return appMessageMapper.insertSelective(message);
	}

	@Override
	public int deleteMessage(AppMessage message) {
		return appMessageMapper.deleteByPrimaryKey(message.getMessageId());
	}

	@Override
	public int updateMessage(AppMessage message) {
		return appMessageMapper.updateByPrimaryKeySelective(message);
	}

}
