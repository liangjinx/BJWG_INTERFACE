package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppWithdrawals;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample;
import com.mobile.blue.launcher.model.Example.AppWithdrawalsExample.Criteria;

public interface WithdrawalsDao {

	int addWithdrawal(AppWithdrawals withdrawal);

	List<AppWithdrawals> selectByExample(AppWithdrawalsExample example, Criteria criteria);

}
