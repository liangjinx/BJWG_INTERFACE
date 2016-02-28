package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppDictDefatl;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample.Criteria;
import com.mobile.blue.view.BankNameVo;

public interface DictDetailDao {

	List<AppDictDefatl> selectselectGrowdefatl(AppDictDefatlExample example, Criteria criteria);

	List<BankNameVo> selectBankNamelist(AppDictDefatlExample example, Criteria criteria);

	int countByExample(AppDictDefatlExample example, Criteria criteria);

}
