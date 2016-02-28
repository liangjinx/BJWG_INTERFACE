package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.DictDetailDao;
import com.mobile.blue.launcher.dao.mapper.AppDictDefatlMapper;
import com.mobile.blue.launcher.model.AppDictDefatl;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample.Criteria;
import com.mobile.blue.view.BankNameVo;

@Service("dictDetailDao")
public class DictDetailDaoImpl implements DictDetailDao {
	@Autowired
	private AppDictDefatlMapper appDictDefatlMapper;

	@Override
	public List<AppDictDefatl> selectselectGrowdefatl(AppDictDefatlExample example, Criteria criteria) {
		List<AppDictDefatl> list = appDictDefatlMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public List<BankNameVo> selectBankNamelist(AppDictDefatlExample example, Criteria criteria) {
		List<BankNameVo> list = appDictDefatlMapper.selectBankNamelist(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countByExample(AppDictDefatlExample example, Criteria criteria) {
		int count =appDictDefatlMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

}
