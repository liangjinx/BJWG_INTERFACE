package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppBankPersonInfo;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample;
import com.mobile.blue.launcher.model.Example.AppBankPersonInfoExample.Criteria;

public interface BankPersonInfoDao {

	int countCard(AppBankPersonInfoExample example, Criteria criteria);

	List<AppBankPersonInfo> bankCardList(AppBankPersonInfoExample example, Criteria criteria);

}
