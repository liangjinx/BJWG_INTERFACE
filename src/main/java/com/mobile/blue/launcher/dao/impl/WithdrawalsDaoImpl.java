package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.WithdrawalsDao;
import com.mobile.blue.launcher.dao.mapper.AppWithdrawalsMapper;
import com.mobile.blue.launcher.model.AppWithdrawals;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample.Criteria;

@Service("withdrawalsDao")
public class WithdrawalsDaoImpl implements WithdrawalsDao {
	@Autowired
	private AppWithdrawalsMapper appWithdrawalsMapper;

	@Override
	public int addWithdrawal(AppWithdrawals withdrawal) {
		return appWithdrawalsMapper.insertSelective(withdrawal);
	}

	@Override
	public List<AppWithdrawals> selectByExample(AppWithdrawalsExample example, Criteria criteria) {
		List<AppWithdrawals> list = appWithdrawalsMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
