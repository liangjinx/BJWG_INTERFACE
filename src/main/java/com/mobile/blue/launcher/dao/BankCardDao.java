package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppUserBankCard;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample.Criteria;

public interface BankCardDao {

	List<AppUserBankCard> bankCardList(AppUserBankCardExample example, Criteria criteria);

	int addBankCard(AppUserBankCard card);

	int countCard(AppUserBankCardExample example, Criteria criteria);

	int deleteBankCard(long cardId);

}
