package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.BankCardDao;
import com.mobile.blue.launcher.dao.mapper.AppUserBankCardMapper;
import com.mobile.blue.launcher.model.AppUserBankCard;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample.Criteria;

@Service("bankCardDao")
public class BankCardDaoImpl implements BankCardDao {
	@Autowired
	private AppUserBankCardMapper appBankCardMapper;

	@Override
	public List<AppUserBankCard> bankCardList(AppUserBankCardExample example, Criteria criteria) {
		List<AppUserBankCard> list = appBankCardMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int addBankCard(AppUserBankCard card) {
		return appBankCardMapper.insertSelective(card);
	}

	@Override
	public int countCard(AppUserBankCardExample example, Criteria criteria) {
		int count = appBankCardMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int deleteBankCard(long cardId) {
		return appBankCardMapper.deleteByPrimaryKey(cardId);
	}

}
