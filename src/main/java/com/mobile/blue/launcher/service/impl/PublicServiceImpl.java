package com.mobile.blue.launcher.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.service.EarningsService;
import com.mobile.blue.launcher.service.OrderService;
import com.mobile.blue.launcher.service.ProjectService;
import com.mobile.blue.launcher.service.PublicService;
import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.VerifyCodeConstant;
import com.mobile.blue.view.RequestUserVO;

/**
 * 公用的service
 * 
 * @author Administrator
 *
 */
@Service("publicService")
public class PublicServiceImpl implements PublicService {
	private static Log logger = LogFactory.getLog(PublicServiceImpl.class);
	@Autowired
	UserBasicService userBasicService;
	@Autowired
	private EarningsService earningsService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private OrderService orderService;

	@Override
	// param[0] 是手机号码，param[1]是验证码，param[2]是password|userId，param[3] 是邀请码
	public String compileVerify(HttpServletRequest request, int type, String... param) throws Exception {
		logger.info("手机号码"+param[0]);
		logger.info("request.getsession"+request.getSession().getId());
		Object valu = request.getSession().getAttribute(param[0]);
		if (valu == null) {
			return ResultUtil.getResultJson(Status.verifyCodeTimeout.getStatus(), Status.verifyCodeTimeout.getMsg());
		}
		// if (valu==param[1]) {// 表示已经发送过验证码，并且验证码有效
		// return ResultUtil.getResultJson(Status.verifyCodeTimeout.getStatus(),
		// Status.verifyCodeTimeout.getMsg());
		// } else {
		if (Integer.parseInt(valu.toString()) == Integer.parseInt(param[1].trim())) {// 表示验证码正确
			if (type == VerifyCodeConstant.VERIFY_CODE_REGISTER)// 表示注册的时候发送的验证码
				return userBasicService.register(param[0], param[2], param[3], request);
			else if (type == VerifyCodeConstant.VERIFY_CODE_BINDING) {// 表示绑定手机号的时候发送的验证码
				// 调用更改手机号的服务
				RequestUserVO user = new RequestUserVO();
				user.setPhone(param[0]);
				user.setUserId(Long.parseLong(param[2]));
				return userBasicService.updateUser(user);
			} else if (type == VerifyCodeConstant.VERIFY_CODE_PASSWORD) {
				RequestUserVO user = new RequestUserVO();
				user.setPhone(param[0]);
				user.setPassword(param[2]);
				return userBasicService.updateUser(user);
			} else if (type == VerifyCodeConstant.VERIFY_CODE_PHONECHANGE_OLD) {
				if (userBasicService.SelectByPhone(param[0]) > 0) {
					return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
				}
			}
		} else
			return ResultUtil.getResultJson(Status.verifyCodeInvalid.getStatus(), Status.verifyCodeInvalid.getMsg());
		// }
		return null;
	}

	@Override
	public String getIndex(long userId) {
		return ResultUtil.getResultJson(earningsService.selectIndex(userId), Status.success.getStatus(),
				Status.success.getMsg());
	}

	@Override
	public String ThisProject(HttpServletRequest request,long projectId) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		Map<String, Object> map = projectService.selectById(projectId);
		if (map == null || map.size() < 1) {
			return ResultUtil.getResultJson(Status.urlNullity.getStatus(), Status.urlNullity.getMsg());
		}
		returnmap.put("project", map);
		returnmap.put("ranking", orderService.selectByprojectIdList(request,1,projectId));
		return ResultUtil.getResultJson(returnmap, Status.success.getStatus(), Status.success.getMsg());
	}
}
