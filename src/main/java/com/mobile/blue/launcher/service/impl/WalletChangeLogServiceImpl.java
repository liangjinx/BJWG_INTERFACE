package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.WalletChangeLogDao;
import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.launcher.model.AppWallet;
import com.mobile.blue.launcher.model.AppWalletChangeLog;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample;
import com.mobile.blue.launcher.model.Example.AppWalletChangeLogExample.Criteria;
import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.launcher.service.WalletChangeLogService;
import com.mobile.blue.launcher.service.WalletService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.constant.BasicConstant;

@Service("walletChangeLogService")
public class WalletChangeLogServiceImpl implements WalletChangeLogService {
	@Autowired
	private WalletChangeLogDao walletChangeLogDao;
	@Autowired
	private UserBasicService userBasicService;
	@Autowired
	private WalletService walletService;

	@Override
	public int addChangeLog(Long walletId, long userId, BigDecimal beforeMoney, double changeMoney,
			BigDecimal afterMoney, Long relationId) {
		AppWalletChangeLog changelog = new AppWalletChangeLog();
		changelog.setWalletId(walletId);
		changelog.setUserId(userId);
		changelog.setBeforeMoney(beforeMoney);
		changelog.setChangeMoney(new BigDecimal(changeMoney));
		changelog.setAfterMoney(afterMoney);
		changelog.setChangeType(Byte.valueOf("1"));
		changelog.setChangeTime(DateUtil.getCurrentDate());
		changelog.setRelationId(relationId);
		changelog.setRelationType(Byte.valueOf("3"));
		return walletChangeLogDao.addChangeLog(changelog);
	}

	@Override
	public List<Map<String, Object>> selectWallatHistory(long userId, HttpServletRequest request, int nextPage) {
		AppWalletChangeLogExample example = new AppWalletChangeLogExample();
		Criteria criteria = example.createCriteria();
		AppWallet wallet = walletService.selectWalletByUserId(userId);
		PageParameter page = (PageParameter) request.getSession().getAttribute("selectWallatHistory");
		if (page == null) {
			page = new PageParameter(0, BasicConstant.limit_page_size);
			criteria.andWalletIdEqualTo(wallet.getUserId());
			example.setDistinct(true);
			int count = walletChangeLogDao.countWalletChange(example, criteria);
			page.setCount(count);
		} else {
			if (nextPage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextPage);
		}
		criteria.andWalletIdEqualTo(wallet.getWalletId());
		example.setPage(page);
		request.getSession().setAttribute("selectWallatHistory", page);
		List<AppWalletChangeLog> list = walletChangeLogDao.selectByExample(example, criteria);
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap = null;
		if (list != null && list.size() >= 1) {
			for (AppWalletChangeLog walletChangeLog : list) {
				returnmap = new HashMap<String, Object>();
				AppUser user = userBasicService.selectUserById(walletChangeLog.getUserId());
				returnmap.put("userName", "");
				if (user != null) {
					returnmap.put("userName", user.getUsername());
				}

				returnmap.put("changeBef", walletChangeLog.getBeforeMoney());
				returnmap.put("changeMoy", walletChangeLog.getChangeMoney());
				returnmap.put("changeAft", walletChangeLog.getAfterMoney());
				returnmap.put("changTime",
						walletChangeLog.getChangeTime() == null ? null : walletChangeLog.getChangeTime().getTime());
				returnmap.put("relationId", walletChangeLog.getRelationId());
				returnmap.put("relationType", walletChangeLog.getRelationType());
				returnlist.add(returnmap);
			}
		}
		return returnlist;
	}

}
