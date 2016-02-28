package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.launcher.service.impl.PublicServiceImpl;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.VerifyCodeConstant;
import com.mobile.blue.util.util.Verification;
import com.mobile.blue.view.RequestUserVO;

@Controller
public class UserController {
	private Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private UserBasicService userBasicService;

	@Autowired
	private PublicServiceImpl publicService;

	@RequestMapping(value = "/register", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object register(HttpServletRequest request, ModelMap model, String phone, int verify_code,
			String password, String invite_code) throws Exception {
		logger.info("requeset.session():register:"+request.getSession().getId());
		request.setCharacterEncoding("utf-8");
		// 注册的时候发送的注册请求，需要验证验证码
		if (phone == null || verify_code == 0 || password == null) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return publicService.compileVerify(request, VerifyCodeConstant.VERIFY_CODE_REGISTER, phone, verify_code + "",
				password, invite_code);
	}

	@RequestMapping(value = "/sendVerifycation", produces = {
			"application/json;charset=UTF-8" }, method = RequestMethod.GET)
	// @RequestMapping(value = "/sendVerifycation", method = RequestMethod.GET)
	@Transactional
	// type 表示发送验证码的类型，2 表示注册，3,表示修改密码发送验证码 5，更新手机绑定
	public @ResponseBody Object getVerification(HttpServletRequest request, int type, ModelMap model, String phone)
			throws Exception {
		logger.info("requeset.session():sendVerifycation:"+request.getSession().getId());
		if (phone != null)
			if (Verification.isPhone(phone)) {
				return userBasicService.sendVerification(request, phone, type);
			} else {
				return ResultUtil.getResultJson(Status.mobilePhoneNullity.getStatus(),
						Status.mobilePhoneNullity.getMsg());
			}
		else
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object login(HttpServletRequest request, ModelMap model, String username, String password)
			throws Exception {
		if (username == null || password == null) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return userBasicService.userLogin(request, username, password);
	}

	// 前端传值
	@RequestMapping(value = "/updateUserBasic", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object updateUser(HttpServletRequest request, ModelMap model, @RequestBody RequestUserVO user)
			throws Exception {
		return userBasicService.updateUser(user);
	}

	/**
	 * 更换绑定手机号码 绑定手机号发送的验证码 1 类型-更换手机号发送的确认旧手机的验证码4
	 */
	@RequestMapping(value = "/updatePhone", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody String updatePhone(HttpServletRequest request, ModelMap model, long userId, String phone,
			String verifyCode, byte type) throws Exception {
		if (phone != null && verifyCode != null)
			return publicService.compileVerify(request, type, phone, verifyCode, userId + "");
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	/**
	 * 找回密码
	 * 
	 * @param request
	 * @param model
	 * @param phone
	 * @param verifyCode
	 * @param password
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/findPassword", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody String findPassword(HttpServletRequest request, ModelMap model, String phone,
			String verifyCode, String password) throws Exception {
		if (phone != null && verifyCode != null)
			return publicService.compileVerify(request, VerifyCodeConstant.VERIFY_CODE_PASSWORD, phone, verifyCode,
					password);
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	@RequestMapping(value = "/loadImg", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody String loadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			ModelMap model) throws Exception {
		if (request.getHeader("userId") != null) {
			return userBasicService.loadImg(file, request);
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}

	// _-----------------------------------------------------------------------------------------------------------------------------//
	@RequestMapping(value = "/countMessage", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody String countMessage(HttpServletRequest request, ModelMap model, long userId) throws Exception {
		return userBasicService.selectcountAll(userId);
	}

	/**
	 * 验证旧密码
	 * 
	 * @param request
	 * @param model
	 * @param type
	 * @param userId
	 * @param lodPassword
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/verifyPassword", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	// type 1,确认旧支付密码验证，2 表示支付修改密码验证 ，3表示支付密码支付的时候验证
	public @ResponseBody Object VerifyPassword(HttpServletRequest request, ModelMap model, byte type, long userId,
			String oldPassword) throws Exception {
		return userBasicService.VerifyPassword(type, userId, oldPassword);

	}

	@RequestMapping(value = "/selecePersonInfo", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object selecePersonInfo(HttpServletRequest request, ModelMap model, long userId)
			throws Exception {
		return userBasicService.selecePersonInfo(userId);
	}
}
