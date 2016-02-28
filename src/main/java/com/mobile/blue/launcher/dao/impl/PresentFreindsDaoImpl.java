package com.mobile.blue.launcher.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.PresentFreindsDao;
import com.mobile.blue.launcher.dao.mapper.AppPresentFreindsMapper;
import com.mobile.blue.launcher.model.AppPresentFreinds;
@Service("presentFreindsDao")
public class PresentFreindsDaoImpl implements PresentFreindsDao {
	@Autowired
	private AppPresentFreindsMapper appPresentFreindsMapper;
	@Override
	public int insertSendFriendPig(AppPresentFreinds presend) {
		return appPresentFreindsMapper.insertSelective(presend);
	}

}
