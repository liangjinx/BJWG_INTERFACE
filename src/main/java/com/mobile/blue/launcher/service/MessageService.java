package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface MessageService {

	List<Map<String, Object>> messageList(long userId, byte type, HttpServletRequest request, int nextPage);

	int messageCount(long userId);

	int addMessage(long userId, String orderMessage, int i, long orderId, byte relationType);

	String deleteMessage(long userId, long messageId);

	String updateMessage(long userId, long messageId);

	String getVideo(String phone, long userId);

}
