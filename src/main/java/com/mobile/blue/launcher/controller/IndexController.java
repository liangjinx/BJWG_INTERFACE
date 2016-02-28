package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.PublicService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Controller
public class IndexController {
	@Autowired
	private PublicService publicService;

	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object index(HttpServletRequest request, ModelMap model, long userId) throws Exception {
		if (userId != 0) {
			return publicService.getIndex(userId);
		} else {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
	}

	@RequestMapping(value = "/projectXX", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object projectXX(HttpServletRequest request, ModelMap model, long projectId) throws Exception {
		if (projectId != 0) {
			return publicService.ThisProject(request,projectId);
		}
		return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
	}
}
