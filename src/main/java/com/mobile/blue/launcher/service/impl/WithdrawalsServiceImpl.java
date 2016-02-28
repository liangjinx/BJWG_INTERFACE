package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.WithdrawalsDao;
import com.mobile.blue.launcher.model.AppBankPersonInfo;
import com.mobile.blue.launcher.model.AppWithdrawals;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample.Criteria;
import com.mobile.blue.launcher.service.BankPersonInfoService;
import com.mobile.blue.launcher.service.WithdrawalsService;
import com.mobile.blue.util.DateUtil;

@Service("withdrawalsService")
public class WithdrawalsServiceImpl implements WithdrawalsService {
	List<AppWithdrawals> list = null;
	@Autowired
	private WithdrawalsDao withdrawalsDao;
	@Autowired
	private BankPersonInfoService bankPersonInfoService;

	@Override
	public int addWithdrawal(long userId, double money, String accountName, String bankCode, String bank, String remark,
			long walletId, long cardId, String cardType) {
		AppWithdrawals withdrawal = new AppWithdrawals();
		withdrawal.setCardType(Byte.parseByte(cardType));
		withdrawal.setCardId(cardId);
		withdrawal.setWalletId(walletId);
		withdrawal.setRemark(remark);
		withdrawal.setStatus(Byte.parseByte("1"));
		List<AppBankPersonInfo> listBankPerson = bankPersonInfoService.selectByUserId(userId);
		withdrawal.setUsername(listBankPerson.get(0).getName());
		withdrawal.setUserId(userId);
		withdrawal.setIdCard(listBankPerson.get(0).getIdCard());
		withdrawal.setBank(bank);
		withdrawal.setBankCode(bankCode);
		withdrawal.setAccountName(accountName);
		withdrawal.setCtime(DateUtil.getCurrentDate());
		withdrawal.setMoney(new BigDecimal(money));
		return withdrawalsDao.addWithdrawal(withdrawal);
	}

	@Override
	public List<AppWithdrawals> selectWithdrawall(long userId) {
		AppWithdrawalsExample example = new AppWithdrawalsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andCtimeGreaterThanOrEqualTo(DateUtil.getCurrentDate());
		list = withdrawalsDao.selectByExample(example, criteria);
		if (list == null || list.size() < 1) {
			return null;
		}
		return list;
	}

}
