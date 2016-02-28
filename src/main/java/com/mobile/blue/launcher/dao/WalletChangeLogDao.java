package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppWalletChangeLog;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample.Criteria;

public interface WalletChangeLogDao {

	int addChangeLog(AppWalletChangeLog changelog);

	List<AppWalletChangeLog> selectByExample(AppWalletChangeLogExample example, Criteria criteria);

	int countWalletChange(AppWalletChangeLogExample example, Criteria criteria);

}
