package com.mobile.blue.launcher.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.WalletDao;
import com.mobile.blue.launcher.dao.mapper.AppWalletMapper;
import com.mobile.blue.launcher.model.AppWallet;
import com.mobile.blue.launcher.model.Example.AppWalletExample;
import com.mobile.blue.launcher.model.Example.AppWalletExample.Criteria;
import com.mobile.blue.util.constant.LoginConstants;
import com.mobile.blue.util.util.MD5;

@Service("walletDao")
public class WalletDaoOmpl implements WalletDao {
	@Autowired
	private AppWalletMapper appWalletMapper;

	@Override
	public BigDecimal walletMoney(AppWalletExample example, Criteria criteria) {
		List<AppWallet> list = appWalletMapper.selectByExample(example);
		if (list == null || list.size() <= 0) {
			return new BigDecimal("0");
		}
		BigDecimal count = list.get(0).getMoney();
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int countByExample(AppWalletExample example, Criteria criteria) {
		int count = appWalletMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int updateWalletPassword(long userId, String newPassword) {
		AppWallet wallet = new AppWallet();
		wallet.setUserId(userId);
		wallet.setPayPassword(newPassword);
		return appWalletMapper.updateByPrimaryKeySelective(wallet);
	}

	@Override
	public List<AppWallet> selectByExample(AppWalletExample example, Criteria criteria) {
		List<AppWallet> list = appWalletMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int updateWall(AppWallet wall) {
		return appWalletMapper.updateByPrimaryKeySelective(wall);
	}

	@Override
	public int insertWallet(Long userId) {
		AppWallet wallet=new AppWallet();
		wallet.setUserId(userId);
		wallet.setMoney(new BigDecimal("0"));
		wallet.setStatus(Byte.parseByte("1"));
		wallet.setPayPassword(MD5.GetMD5Code("123456")+LoginConstants.LOGIN_PASSWORD_PARAM);
		return appWalletMapper.insertSelective(wallet);
	}

}
