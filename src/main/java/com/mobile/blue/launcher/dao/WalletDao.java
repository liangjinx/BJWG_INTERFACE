package com.mobile.blue.launcher.dao;

import java.math.BigDecimal;
import java.util.List;

import com.mobile.blue.launcher.model.AppWallet;
import com.mobile.blue.launcher.model.Example.AppWalletExample;
import com.mobile.blue.launcher.model.Example.AppWalletExample.Criteria;

public interface WalletDao {
	BigDecimal walletMoney(AppWalletExample example, Criteria criteria);

	int countByExample(AppWalletExample example, Criteria criteria);

	int updateWalletPassword(long userId, String newPassword);

	List<AppWallet> selectByExample(AppWalletExample example, Criteria criteria);

	int updateWall(AppWallet wall);

	int insertWallet(Long userId);

}
