package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.EarningsDao;
import com.mobile.blue.launcher.dao.mapper.AppMyEarningsMapper;
import com.mobile.blue.launcher.model.AppMyEarnings;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample.Criteria;

@Service("earningsDao")
public class EarningsDaoImpl implements EarningsDao {
	@Autowired
	private AppMyEarningsMapper appMyEarningsMapper;

	@Override
	public List<AppMyEarnings> selectByExample(AppMyEarningsExample earningsExample, Criteria criteria) {
		List<AppMyEarnings> list = appMyEarningsMapper.selectByExample(earningsExample);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countByExample(AppMyEarningsExample earningsExample, Criteria criteria) {
		int count = appMyEarningsMapper.countByExample(earningsExample);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int updateReturnWay(byte beforeDealType, byte dealType, long earningId) {
		AppMyEarnings earning = new AppMyEarnings();
		earning.setBeforeDealType(beforeDealType);
		earning.setDealType(dealType);
		earning.setEarningsId(earningId);
		return appMyEarningsMapper.updateByPrimaryKeySelective(earning);
	}

	@Override
	public int updateEarnings(AppMyEarnings earnings) {
		return appMyEarningsMapper.updateByPrimaryKeySelective(earnings);
	}

	@Override
	public int insertEarnings(AppMyEarnings appMyEarnings) {
		return appMyEarningsMapper.insertSelective(appMyEarnings);
	}
}
