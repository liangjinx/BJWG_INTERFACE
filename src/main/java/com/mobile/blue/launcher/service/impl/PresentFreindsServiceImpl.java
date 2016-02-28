package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.PresentFreindsDao;
import com.mobile.blue.launcher.model.AppPresentFreinds;
import com.mobile.blue.launcher.service.PresentFreindsService;
import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.util.DateUtil;
@Service("presentFreindsService")
public class PresentFreindsServiceImpl implements PresentFreindsService {
	@Autowired
	private PresentFreindsDao presentFreindsDao;
	@Autowired
	private UserBasicService userBasicService;
	@Override
	public int insertSendFriendPig(AppPresentFreinds presend) {
		presend.setPresentUser(userBasicService.selectUserById(presend.getPresentId()).getNickname());
		presend.setPresentedUser(userBasicService.selectUserById(presend.getPresentedUserId()).getNickname());
		presend.setTotalMoney(presend.getPrice().multiply(new BigDecimal(presend.getPresentNum())));
		presend.setCtime(DateUtil.getCurrentDate());
		return presentFreindsDao.insertSendFriendPig(presend);
	}

}
