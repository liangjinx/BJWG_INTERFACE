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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.service.UserAddressService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Controller
public class UserAddressController {
	private Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private UserAddressService userAddressService;

	/**
	 * 查询用户的地址列表
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectUserAdds", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object SelectUserAdds(HttpServletRequest request, ModelMap model, long userId,int nextPage)
			throws Exception {
		logger.info("request:"+request.getSession().getId());
		return ResultUtil.getResultJson(userAddressService.selectUserAllAdress(request,nextPage,userId), Status.success.getStatus(),
				Status.success.getMsg());
	}


	/**
	 * 增加用户收货地址
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addUserAddress", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object addUserAddress(HttpServletRequest request, ModelMap model,
			@RequestBody AppUserAddress address) throws Exception {
		if (address.getUserId() == 0 || address.getAddress() == null || address.getContactMan() == null
				|| address.getContactPhone() == null || address.getProvince() == null || address.getCity() == null) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return userAddressService.addUserAddress(address);
	}

	/**
	 * @param request
	 * @param model
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateUserAddress", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object updateUserAddress(HttpServletRequest request, ModelMap model,
			@RequestBody AppUserAddress address) throws Exception {
		// 表示每个字段都要传值
		if (address.getAddressId() == 0) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return userAddressService.updateUserAddress(address);
	}

	/**
	 * 删除用户的收货地址信息
	 * 
	 * @param request
	 * @param model
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteUserAddress", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object deleteUserAddress(HttpServletRequest request, ModelMap model, long addressId)
			throws Exception {
		// 表示每个字段都要传值
		if (addressId == 0) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		return userAddressService.deleteUserAddress(addressId);
	}
}
