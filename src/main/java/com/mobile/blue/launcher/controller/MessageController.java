package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.MessageService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(value = "/messageList", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	// type 1 表示系统消息，2，表示猪场公告
	public @ResponseBody Object messageList(HttpServletRequest request, ModelMap model, long userId, byte type,
			int nextPage) throws Exception {
		if (userId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return ResultUtil.getResultJson(messageService.messageList(userId, type, request, nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}

	@RequestMapping(value = "/deleteMessage", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	//
	public @ResponseBody Object deleteMessage(HttpServletRequest request, ModelMap model, long userId, long messageId)
			throws Exception {
		if (userId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return messageService.deleteMessage(userId, messageId);
	}

	@RequestMapping(value = "/updateMessage", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object updateMessage(HttpServletRequest request, ModelMap model, long userId, long messageId)
			throws Exception {
		if (userId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return messageService.updateMessage(userId, messageId);
	}

	@RequestMapping(value = "/getVideo", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object getVideo(HttpServletRequest request, ModelMap model, String phone, long userId)
			throws Exception {
		log.info("tiaoshi getvideo");
		return messageService.getVideo(phone, userId);
	}
}
