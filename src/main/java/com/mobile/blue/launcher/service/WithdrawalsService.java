package com.mobile.blue.launcher.service;

import java.util.List;

import com.mobile.blue.launcher.model.AppWithdrawals;

public interface WithdrawalsService {

	int addWithdrawal(long userId, double money, String accountName, String bankCode, String bank, String remark,
			long walletId, long cardId, String cardType);

	List<AppWithdrawals> selectWithdrawall(long userId);
}
