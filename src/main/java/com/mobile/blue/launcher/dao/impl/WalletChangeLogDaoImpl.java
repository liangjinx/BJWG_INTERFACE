package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.WalletChangeLogDao;
import com.mobile.blue.launcher.dao.mapper.AppWalletChangeLogMapper;
import com.mobile.blue.launcher.model.AppWalletChangeLog;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample.Criteria;

@Service("walletChangeLogDao")
public class WalletChangeLogDaoImpl implements WalletChangeLogDao {
	@Autowired
	private AppWalletChangeLogMapper appWalletChangeLogMapper;

	@Override
	public int addChangeLog(AppWalletChangeLog changelog) {
		return appWalletChangeLogMapper.insertSelective(changelog);
	}

	@Override
	public List<AppWalletChangeLog> selectByExample(AppWalletChangeLogExample example, Criteria criteria) {
		List<AppWalletChangeLog> list=appWalletChangeLogMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countWalletChange(AppWalletChangeLogExample example, Criteria criteria) {
		 int count=appWalletChangeLogMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

}
