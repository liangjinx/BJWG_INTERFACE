package com.mobile.blue.launcher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.BankPersonInfoDao;
import com.mobile.blue.launcher.model.AppBankPersonInfo;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample.Criteria;
import com.mobile.blue.launcher.service.BankPersonInfoService;

@Service("bankPersonInfoService")
public class BankPersonInfoServiceImpl implements BankPersonInfoService {
	@Autowired
	private BankPersonInfoDao bankPersonInfoDao;
	List<AppBankPersonInfo> list = null;

	@Override
	public List<AppBankPersonInfo> selectByUserId(long userId) {
		AppBankPersonInfoExample example = new AppBankPersonInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		list = bankPersonInfoDao.bankCardList(example, criteria);
		return list;
	}

}
