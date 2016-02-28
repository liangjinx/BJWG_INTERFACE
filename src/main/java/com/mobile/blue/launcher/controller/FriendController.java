package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.FriendService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.TypeConstant;

@Controller
public class FriendController {
	/**
	 * 好友列表
	 */
	@Autowired
	private FriendService friendService;

	@RequestMapping(value = "/userFriends", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object Friends(HttpServletRequest request, ModelMap model, long userId) throws Exception {
		if (userId != 0) {
			return friendService.selectFriends(request,userId);
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	/**
	 * 搜索好友
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @param likevalue
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchFriend", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object searchFriend(HttpServletRequest request, ModelMap model, long userId, String likevalue,int nextPage) throws Exception {
		if (userId == 0 || likevalue == null || "".equals(likevalue))
			return ResultUtil.getResultJson(Status.paramFormatError.getStatus(), Status.paramFormatError.getMsg());
		return friendService.searchNewFriendS(request, userId, likevalue,nextPage);
	}

	/**
	 * 增加朋友
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @param friendId
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addFriend", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object addFriend(HttpServletRequest request, ModelMap model, long userId, long friendId,
			String message) throws Exception {
		if (userId != 0 && friendId != 0) {
			if (friendService.addFriend(userId, DateUtil.getCurrentDate(), friendId, TypeConstant.FREINDS_ADD_TYPE_1,
					message) <= 0) {
				return ResultUtil.getResultJson(Status.freindsNotExist.getStatus(), Status.freindsNotExist.getMsg());
			} else {
				return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
			}
		}
		return ResultUtil.getResultJson(Status.paramFormatError.getStatus(), Status.paramFormatError.getMsg());
	}

	/**
	 * 删除好友
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @param friendId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteFriend", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object deleteFriend(HttpServletRequest request, ModelMap model, long userId, long friendId)
			throws Exception {
		if (friendId == 0) {
			return ResultUtil.getResultJson(Status.paramFormatError.getStatus(), Status.paramFormatError.getMsg());
		} else
			return friendService.deleteFriend(userId, friendId);
	}

	/**
	 * 更新好友
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @param friendId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	// status 1,表示同意，2表示不同意
	@RequestMapping(value = "/updateFriendStatus", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object updateFriendStatus(HttpServletRequest request, ModelMap model, long userId,
			long friendId, byte status) throws Exception {
		return friendService.updateFriendStatus(userId, friendId, status);
	}

	/**
	 * 新朋友刷新
	 */
	@RequestMapping(value = "/newFriendRefresh", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object newFriendRefresh(HttpServletRequest request, ModelMap model, long userId, int nextPage) throws Exception {
		return ResultUtil.getResultJson(friendService.newFriendRefresh(request,userId,nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}

	/**
	 * 老朋友刷新
	 */
	@RequestMapping(value = "/oldFriendRefresh", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object oldFriendRefresh(HttpServletRequest request, ModelMap model, long userId, int nextPage) throws Exception {
		return ResultUtil.getResultJson(friendService.lodFriendRefresh(request,userId,nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}
}
