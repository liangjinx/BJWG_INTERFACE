package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.BankPersonInfoDao;
import com.mobile.blue.launcher.dao.mapper.AppBankPersonInfoMapper;
import com.mobile.blue.launcher.model.AppBankPersonInfo;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample.Criteria;

@Service("bankPersonInfoDao")
public class BankPersonInfoDaoImpl implements BankPersonInfoDao {
	@Autowired
	private AppBankPersonInfoMapper appBankPersonInfoMapper;

	@Override
	public int countCard(AppBankPersonInfoExample example, Criteria criteria) {
		int count = appBankPersonInfoMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public List<AppBankPersonInfo> bankCardList(AppBankPersonInfoExample example, Criteria criteria) {
		List<AppBankPersonInfo> list = appBankPersonInfoMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
