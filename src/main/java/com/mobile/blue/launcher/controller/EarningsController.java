package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.CouponService;
import com.mobile.blue.launcher.service.EarningsService;
import com.mobile.blue.launcher.service.PreorderService;
import com.mobile.blue.launcher.service.ProjectService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Controller
public class EarningsController {
	@Autowired
	private EarningsService earningsService;
	@Autowired
	private PreorderService preorderService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private CouponService couponService;

	/**
	 * 投资列表
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/investList", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object investList(HttpServletRequest request, ModelMap model, long userId,int nextPage)
			throws Exception {
		if (userId != 0) {
			return ResultUtil.getResultJson(earningsService.selectInvestList(userId,request,nextPage),
					Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	/**
	 * 投资详情
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/invest", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object invest(HttpServletRequest request, ModelMap model, long userId, long projectId)
			throws Exception {
		if (userId != 0 && projectId != 0) {
			return ResultUtil.getResultJson(earningsService.selectInvestOne(userId, projectId), Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	// -------------------------------------------------------------------------------------------//
	// 对用户预抢表的设置和查询操作
	@RequestMapping(value = "/updateUserPreSet", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object saveUserPreSet(HttpServletRequest request, ModelMap model, long userId, long projectId,
			byte type, boolean isCancel, int number) throws Exception {
		if (userId != 0) {
			return preorderService.saveUserPreSet(userId, projectId, type, isCancel, number);
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	@RequestMapping(value = "/selectPreOrder", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object selectPreOrder(HttpServletRequest request, ModelMap mode,long userId) throws Exception {
		return projectService.searchProjects(userId);
	}

	// -------------------------------------------------------------------------------------------//
	// 对用户的猪肉卷进行的操作
	@RequestMapping(value = "/selectProk", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object selectProk(HttpServletRequest request, ModelMap model, long userId, int nextPage)
			throws Exception {
		if (userId == 0){
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return ResultUtil.getResultJson(couponService.selectCouponByUserId(userId, request, nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}

	@RequestMapping(value = "/selectProkOne", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object selectProkOne(HttpServletRequest request, ModelMap model, long userId, long couponId)
			throws Exception {
		if (userId == 0 || couponId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return couponService.selectCouponOne(userId, couponId);
	}

	@RequestMapping(value = "/sendFriendProk", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object sendFriendProk(HttpServletRequest request, ModelMap model, long userId, long friendId,
			long couponId, double money) throws Exception {
		if (userId == 0 || friendId == 0 || couponId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return couponService.sendFriendProk(userId, friendId, couponId, money);
	}

	// -------------------------对猪仔的操作------------------------------------------------------------------//
	@RequestMapping(value = "/selectMyPig", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object selectMyPig(HttpServletRequest request, ModelMap model, long userId)
			throws Exception {
		if (userId == 0){
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return earningsService.selectMyPig(userId);
	}

	@RequestMapping(value = "/sendFriendPig", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object sendFriendPig(HttpServletRequest request, ModelMap model, long userId, long friendId,
			long touzhiId, int number) throws Exception {
		if (userId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return earningsService.sendFriendPig(userId, friendId, touzhiId, number);
	}
	// .........................................................................................................
	// 收益列表
	@RequestMapping(value = "/myearningslist", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object myearningslist(HttpServletRequest request, ModelMap model, long userId) throws Exception {
		return ResultUtil.getResultJson(earningsService.myearningslist( userId),
				Status.success.getStatus(), Status.success.getMsg());
	}

	// 收益历史记录
	@RequestMapping(value = "/earningsRanking", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object earningsRanking(HttpServletRequest request, ModelMap model, long userId,
			int nextPage) throws Exception {
		return earningsService.earningsRanking(request, userId, nextPage);
	}
}
