package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.OrderService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.view.RequestOrderVo;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/selectOrder", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	// type 1,表示未付款，4 表示待收货 ,0 表示全部
	public @ResponseBody Object selectOrder(HttpServletRequest request, ModelMap model, long userId, byte type,
			int nextPage) throws Exception {
		if (userId == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		return ResultUtil.getResultJson(orderService.selectOrderByUserId(userId, type, request, nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}

	@Transactional
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Object addOrder(HttpServletRequest request, ModelMap model, @RequestBody RequestOrderVo order)
			throws Exception {
		if (order.getUserId() == null || order.getRelationId() == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		Object ordercode = orderService.addOrder(order);
		if (ordercode == null) {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
		return ResultUtil.getResultJson(ordercode, Status.success.getStatus(), Status.success.getMsg());
	}

	/**
	 * update order
	 * 
	 * order type 表示类型，1，表示删除订单，2表示取消订单
	 */
	@Transactional
	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	public @ResponseBody Object updateOrder(HttpServletRequest request, ModelMap model,
			@RequestBody RequestOrderVo order) throws Exception {
		if (order == null || order.getOrderId() == 0)
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		if (orderService.updateOrderBasic(order) >= 1) {
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.saveFail.getStatus(), Status.saveFail.getMsg());
	}

	// 项目购买排行
	@RequestMapping(value = "/ranking", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object ranking(HttpServletRequest request, ModelMap model, long projectId, int nextPage)
			throws Exception {
		if (projectId != 0) {
			return orderService.selectByprojectIdList(request, nextPage, projectId);
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}
	//得到用户的默认收货地址
	@RequestMapping(value = "/getOrderAddr", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object getOrderAddr(HttpServletRequest request, ModelMap model, long userId )
			throws Exception {
		if (userId != 0) {
			return ResultUtil.getResultJson(orderService.getOrderAddr(request,userId),Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}
}
