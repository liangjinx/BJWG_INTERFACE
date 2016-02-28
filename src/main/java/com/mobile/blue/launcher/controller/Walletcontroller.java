package com.mobile.blue.launcher.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.blue.launcher.service.BankCardService;
import com.mobile.blue.launcher.service.WalletChangeLogService;
import com.mobile.blue.launcher.service.WalletService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.view.RequestBankCardVo;

@Controller
public class Walletcontroller {

	@Autowired
	private BankCardService bankCardService;
	@Autowired
	private WalletService walletService;
	@Autowired
	private WalletChangeLogService walletChangeLogService;

	private Logger log = Logger.getLogger(this.getClass());

	// —————银行卡管理—————————————————————————————————/
	@RequestMapping(value = "/bankCardList", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object bankCardList(HttpServletRequest request, ModelMap model, long userId, int nextPage)
			throws Exception {
		return ResultUtil.getResultJson(bankCardService.bankCardList(request, userId, nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}

	@RequestMapping(value = "/addBankCard", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object addBankCard(HttpServletRequest request, ModelMap model,
			@RequestBody RequestBankCardVo card) throws Exception {
		return ResultUtil.getResultJson(bankCardService.addBankCard(card), Status.success.getStatus(),
				Status.success.getMsg());
	}

	@RequestMapping(value = "/deleteBankCard", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object deleteBankCard(HttpServletRequest request, ModelMap model, long cardId)
			throws Exception {
		log.info("deleteBankCard");
		if (bankCardService.deleteBankCard(cardId) > 0) {
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.bankCardIdNullity.getStatus(), Status.bankCardIdNullity.getMsg());
	}

	/**
	 * 钱包消费记录
	 * 
	 * @param request
	 * @param model
	 * @param userId
	 * @param cardId
	 * @param money
	 * @param remark
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/walletHistory", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object walletHistory(HttpServletRequest request, ModelMap model, long userId, int nextPage)
			throws Exception {
		return ResultUtil.getResultJson(walletChangeLogService.selectWallatHistory(userId, request, nextPage),
				Status.success.getStatus(), Status.success.getMsg());
	}

	// —————钱包管理—————————————————————————————————/
	@RequestMapping(value = "/updateWalletPassword", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object updateWalletPassword(HttpServletRequest request, ModelMap model, long userId,
			String newPassword) throws Exception {
		return ResultUtil.getResultJson(walletService.updateWalletPassword(userId, newPassword),
				Status.success.getStatus(), Status.success.getMsg());
	}

	// 提现
	@RequestMapping(value = "/withdrawMoney", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@Transactional
	public @ResponseBody Object withdrawMoney(HttpServletRequest request, ModelMap model, long userId, long cardId,
			double money, String remark) throws Exception {
		return ResultUtil.getResultJson(walletService.withdrawMoney(userId, cardId, money, remark),
				Status.success.getStatus(), Status.success.getMsg());
	}

}
