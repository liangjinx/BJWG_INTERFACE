package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppMyEarnings;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample.Criteria;

public interface EarningsDao {

	List<AppMyEarnings> selectByExample(AppMyEarningsExample earningsExample, Criteria criteria);

	int countByExample(AppMyEarningsExample earningsExample, Criteria criteria);

	int updateReturnWay(byte beforeDealType, byte dealType, long earningId);

	int updateEarnings(AppMyEarnings earnings);

	int insertEarnings(AppMyEarnings appMyEarnings);

}
