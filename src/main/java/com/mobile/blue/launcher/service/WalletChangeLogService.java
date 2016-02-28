package com.mobile.blue.launcher.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface WalletChangeLogService {

	int addChangeLog(Long walletId, long userId, BigDecimal beforeMoney, double changeMoney, BigDecimal afterMoney,
			Long relationId);

	List<Map<String, Object>> selectWallatHistory(long walletId,HttpServletRequest request,int nextPage);

}
