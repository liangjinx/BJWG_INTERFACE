package com.mobile.blue.launcher.service;

import java.util.List;

import com.mobile.blue.launcher.model.AppBankPersonInfo;

public interface BankPersonInfoService {

	List<AppBankPersonInfo> selectByUserId(long userId);

}
