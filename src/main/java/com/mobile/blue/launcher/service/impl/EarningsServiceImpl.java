package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.EarningsDao;
import com.mobile.blue.launcher.model.AppBulletin;
import com.mobile.blue.launcher.model.AppMyEarnings;
import com.mobile.blue.launcher.model.AppPresentFreinds;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample;
import com.mobile.blue.launcher.model.Example.AppMyEarningsExample.Criteria;
import com.mobile.blue.launcher.service.BulletinService;
import com.mobile.blue.launcher.service.DictService;
import com.mobile.blue.launcher.service.EarningsService;
import com.mobile.blue.launcher.service.FriendService;
import com.mobile.blue.launcher.service.OrderService;
import com.mobile.blue.launcher.service.PresentFreindsService;
import com.mobile.blue.launcher.service.ProjectService;
import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.CommConstant;
import com.mobile.blue.util.constant.DictConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.SysConstant;

@Service("earningsService")
public class EarningsServiceImpl implements EarningsService {
	List<AppMyEarnings> list = null;
	@Autowired
	private EarningsDao earningsDao;
	@Autowired
	private ProjectService projectService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private SysconfigService sysconfigService;

	@Autowired
	private DictService dictService;

	@Autowired
	private FriendService friendService;
	@Autowired
	private BulletinService bulletinService;
	@Autowired
	private PresentFreindsService presentFreindsService;

	@Override
	public List<Map<String, Object>> selectInvestList(long userId, HttpServletRequest request, int nextPage) {
		AppMyEarningsExample example = null;
		Criteria criteria = null;
		List<Map<String, Object>> listInvest = new ArrayList<Map<String, Object>>();
		PageParameter page = (PageParameter) request.getSession().getAttribute("myearningslist");
		if (page == null) {
			example = new AppMyEarningsExample();
			criteria = example.createCriteria();
			page = new PageParameter(0, BasicConstant.limit_page_size);
			criteria.andUserIdEqualTo(userId);
			example.setDistinct(true);
			example.setOrderByClause("begin_time desc");
			int count = earningsDao.countByExample(example, criteria);
			page.setCount(count);
		} else {
			if (nextPage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextPage);
		}
		example = new AppMyEarningsExample();
		criteria = example.createCriteria();
		example.setOrderByClause("begin_time desc");
		criteria.andUserIdEqualTo(userId);
		list = earningsDao.selectByExample(example, criteria);
		Map<String, Object> map = null;
		if (list != null && list.size() > 0) {
			request.getSession().setAttribute("myearningslist", page);
			for (AppMyEarnings earning : list) {
				map = new HashMap<String, Object>();
				Map<String, Object> orderMap = orderService.selectByUserIdAndProjectId(userId,
						earning.getPaincbuyProjectId());
				map.put("userId", userId);
				map.put("num", earning.getNum()-earning.getPresentNum());
				map.put("total_money", orderMap.get("total_money") == null ? 0 : orderMap.get("total_money"));
				BigDecimal big = new BigDecimal(
						DateUtil.daysBetween(earning.getBeginTime(), DateUtil.getCurrentDate()) / 1.5);
				map.put("schedule", big.intValue() + "%");
				map.put("projectName", earning.getPaincbuyProjectName());
				map.put("projectId", earning.getPaincbuyProjectId());
				listInvest.add(map);
			}
		}
		return listInvest;
	}

	@Override
	public Map<String, Object> selectInvestOne(long userId, long projectId) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andPaincbuyProjectIdEqualTo(projectId);
		list = earningsDao.selectByExample(example, criteria);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list == null || list.size() <= 0) {
			return map;
		}
		Map<String, Object> projectMap = projectService.selectById(list.get(0).getPaincbuyProjectId());
		if (projectMap == null || projectMap.size() < 1) {
			return map;
		}
		Map<String, Object> orderMap = orderService.selectByUserIdAndProjectId(userId, projectId);
		map.put("rate", list.get(0).getRate());
		map.put("earningsId", list.get(0).getEarningsId());// DateUtil.format(list.get(0).getBeginTime(),
															// BasicConstant.DATE_PATTERN)
		map.put("beginTime", list.get(0).getBeginTime() == null ? null : list.get(0).getBeginTime().getTime());
		map.put("endTime", list.get(0).getEndTime() == null ? null : list.get(0).getEndTime().getTime());
		map.put("projectSum", projectMap.get("num"));
		map.put("leftNum", projectMap.get("left_num"));
		map.put("paincbuyProjectId", projectId);
		map.put("myProjectSum", orderMap.get("num"));
		map.put("orderCode", orderMap.get("order_code"));
		map.put("totalMoney", orderMap.get("total_money"));
		map.put("orderId", orderMap.get("order_id"));
		map.put("dealStatus", list.get(0).getDealStatus());
		map.put("presentNum", list.get(0).getPresentNum());
		map.put("dealType", list.get(0).getDealType());
		map.put("num", list.get(0).getNum());
		return map;
	}

	@Override
	public int selectPigcount(long userId) {
		return orderService.selectByUserId(userId);
	}

	@Override
	public String selectMyPig(long userId) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andEndTimeGreaterThanOrEqualTo(DateUtil.getCurrentDate());
		criteria.andDealStatusEqualTo(new Integer(0).byteValue());
		list = earningsDao.selectByExample(example, criteria);// 查询该用户的没有结束的收益状态
		Map<String, Object> map = null;
		if (list.size() <= 0) {
			return "";
		}
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for (AppMyEarnings earning : list) {
			map = new HashMap<String, Object>();
			map.put("returnWaySelectLastTime",
					DateUtil.getBeforeDate(earning.getEndTime(),
							Integer.parseInt(sysconfigService.queryByCode(SysConstant.CONFIRM_REWARDS_BEFORE_N_DAYS)))
					.getTime());
			map.put("projectName", earning.getPaincbuyProjectName());
			map.put("projectId", earning.getPaincbuyProjectId());
			map.put("num", earning.getNum());
			map.put("raisingDay", DateUtil.daysBetween(earning.getBeginTime(), DateUtil.getCurrentDate()));
			map.put("breedingPeriod", sysconfigService.selectStatus(SysConstant.GROW_UP_LEVEL,
					Integer.parseInt(map.get("raisingDay").toString())));
			map.put("growUp", dictService.selectGrowUp(DictConstant.DICT_GROUP_RECORD,
					Integer.parseInt(map.get("raisingDay").toString())));
			map.put("deal_type", earning.getDealType());
			map.put("before_deal_type", earning.getBeforeDealType());
			map.put("earningId", earning.getEarningsId());
			// 添加成长记录
			listMap.add(map);
		}
		return ResultUtil.getResultJson(listMap, Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public String sendFriendPig(long userId, long friendId, long earningsId, int number) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		if (friendService.selectFriendCount(friendId, userId) != 1)
			return ResultUtil.getResultJson(Status.freindsIdNullity.getStatus(), Status.freindsIdNullity.getMsg());
		criteria.andUserIdEqualTo(userId);
		criteria.andEarningsIdEqualTo(earningsId);
		list = earningsDao.selectByExample(example, criteria);
		if (list.size() <= 0) {
			return ResultUtil.getResultJson(Status.urlNullity.getStatus(), Status.urlNullity.getMsg());
		} else if (list.get(0).getNum() == 1 || list.get(0).getNum() < number) {
			return ResultUtil.getResultJson(Status.saleNumNotEnough.getStatus(), Status.saleNumNotEnough.getMsg());
		}
		// 修改我的猪仔数量
		AppMyEarnings earnings = new AppMyEarnings();
		earnings.setPresentNum(number);
		earnings.setEarningsId(earningsId);
		earningsDao.updateEarnings(earnings);
		// 修改好友的猪仔数量
		criteria.andUserIdEqualTo(friendId);
		criteria.andEarningsIdEqualTo(earningsId);
		List<AppMyEarnings> friendearnigns = earningsDao.selectByExample(example, criteria);
		if (friendearnigns==null || friendearnigns.size() < 1) {
			list.get(0).setUserId(friendId);
			list.get(0).setNum(number);
			list.get(0).setPresentNum(0);
			list.get(0).setEarningsId(null);
			earningsDao.insertEarnings(list.get(0));
		} else {
			earnings.setNum(friendearnigns.get(0).getNum() + number);
			earnings.setEarningsId(earningsId);
			if (earningsDao.updateEarnings(earnings) < 1) {
				return ResultUtil.getResultJson(Status.saveFail.getStatus(), Status.saveFail.getMsg());
			}
		}
		// 添加赠送记录 userId,friendId,earningsId,number,1,
		AppPresentFreinds presend = new AppPresentFreinds();
		presend.setPresentUserId(userId);
		presend.setPresentedUserId(friendId);
		presend.setPresentNum(number);
		presend.setType(Byte.parseByte("1"));
		presend.setPresentedRelationId(earningsId);
		// 查询好友的收益id
		criteria.andUserIdEqualTo(friendId);
		criteria.andPaincbuyProjectIdEqualTo(list.get(0).getPaincbuyProjectId());
		presend.setPresentedRelationId(earningsDao.selectByExample(example, criteria).get(0).getEarningsId());
		presend.setPrice(
				new BigDecimal(projectService.selectById(list.get(0).getPaincbuyProjectId()).get("price").toString()));
		presentFreindsService.insertSendFriendPig(presend);
		return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
	}

	/**
	 * 所有项目的收益
	 */
	@Override
	public double selectEarnings(long userId) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		list = earningsDao.selectByExample(example, criteria);
		String day = sysconfigService.queryByCode(SysConstant.GROW_UP_DAYS);
		if (day == null) {
			ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}
		double moneys = 0;
		if (list == null || list.size() <= 0) {
			return moneys;
		} else {
			for (AppMyEarnings earnings : list) {
				double d = DateUtil.daysBetween(DateUtil.getAfterDate(earnings.getBeginTime(), 1),
						DateUtil.getCurrentDate());
				moneys = moneys + earnings.getExpectEarning().doubleValue() * d / Integer.parseInt(day);
			}
		}
		BigDecimal b3 = new BigDecimal(moneys);
		return b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	@Override
	public List<Map<String, Object>> myearningslist(long userId) {
		AppMyEarningsExample example = null;
		Criteria criteria = null;
		example = new AppMyEarningsExample();
		criteria = example.createCriteria();
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap = null;
		criteria.andUserIdEqualTo(userId);
		criteria.andDealStatusEqualTo(Byte.parseByte("0"));
		list = earningsDao.selectByExample(example, criteria);
		if (list == null || list.size() <= 0) {
			return null;
		}
		String day = sysconfigService.queryByCode(SysConstant.GROW_UP_DAYS);
		for (AppMyEarnings earnings : list) {
			double d = DateUtil.daysBetween(DateUtil.getAfterDate(earnings.getBeginTime(), 1),
					DateUtil.getCurrentDate());
			returnmap = new HashMap<String, Object>();
			returnmap.put("projectId", earnings.getPaincbuyProjectId());
			returnmap.put("projectName", earnings.getPaincbuyProjectName());
			returnmap.put("rate", earnings.getRate());
			returnmap.put("expect", earnings.getExpectEarning());
			returnmap.put("earnings", earnings.getExpectEarning().doubleValue() * d / Integer.parseInt(day));
			returnmap.put("money", earnings.getMoney());
			returnmap.put("num",
					orderService.selectByUserIdAndProjectId(userId, earnings.getPaincbuyProjectId()).get("num"));
			returnmap.put("days", DateUtil.daysBetween(earnings.getBeginTime(), DateUtil.getCurrentDate()));
			returnlist.add(returnmap);
		}
		return returnlist;
	}

	@Override
	public Map<String, Object> selectIndex(long userId) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		Map<String, Object> returnmap = null;
		returnmap = new HashMap<String, Object>();
		returnmap.put("preProject", projectService.selectCanPreProjectOne());
		// 以上是最新的可以抢购的项目
		// 下面是猪仔总数
		criteria.andUserIdEqualTo(userId);
		criteria.andDealStatusEqualTo(Byte.valueOf("0"));
		int count = earningsDao.countByExample(example, criteria);
		returnmap.put("num", count);
		returnmap.put("currDate", DateUtil.getCurrentDate().getTime());
		// 下面是收益
		String day = sysconfigService.queryByCode(SysConstant.GROW_UP_DAYS);
		criteria.andDealStatusEqualTo(Byte.valueOf("0"));
		criteria.andUserIdEqualTo(userId);
		list = earningsDao.selectByExample(example, criteria);
		if (list == null || list.size() <= 0) {
			returnmap.put("earnings", 0);
			returnmap.put("groupStatus", 0);
		} else {
			AppMyEarnings earning = list.get(0);
			returnmap.put("earnings", earning.getExpectEarning().doubleValue()
					* DateUtil.daysBetween(earning.getBeginTime(), DateUtil.getCurrentDate()) / Integer.parseInt(day));
			// 下面是成长状态，最近一期的成长状态
			returnmap.put("groupStatus",
					Double.parseDouble(DateUtil.daysBetween(earning.getBeginTime(), DateUtil.getCurrentDate()) + "")
							/ Double.parseDouble(day));
		}
		List<AppBulletin> li = bulletinService.selectbullet();
		if (li != null && li.size() > 0) {
			AppBulletin bulletin = li.get(0);
			returnmap.put("bulletin", bulletin.getContent());
			returnmap.put("title", bulletin.getTitle());
		} else {
			returnmap.put("bulletin", "");
			returnmap.put("title", "");
		}
		return returnmap;
	}

	@Override
	public String earningsRanking(HttpServletRequest request, long userId, int nextPage) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		String day = sysconfigService.queryByCode(SysConstant.GROW_UP_DAYS);
		PageParameter page = (PageParameter) request.getSession().getAttribute("earningsRanking");
		if (page == null) {
			page = new PageParameter(0, BasicConstant.limit_page_size);
			criteria.andUserIdEqualTo(userId);
			int count = earningsDao.countByExample(example, criteria);
			page.setCount(count);
		} else {
			if (nextPage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextPage);
		}
		criteria.andUserIdEqualTo(userId);
		example.setPage(page);
		list = earningsDao.selectByExample(example, criteria);
		if (list == null || list.size() <= 0) {
			return null;
		}
		request.getSession().setAttribute("earningsRanking", page);
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap = null;
		for (AppMyEarnings earnings : list) {
			double d = DateUtil.daysBetween(DateUtil.getAfterDate(earnings.getBeginTime(), 1),
					DateUtil.getCurrentDate());
			returnmap = new HashMap<String, Object>();
			returnmap.put("projectId", earnings.getPaincbuyProjectId());
			returnmap.put("projectName", earnings.getPaincbuyProjectName());
			returnmap.put("rate", earnings.getRate());
			returnmap.put("earnings", earnings.getExpectEarning().doubleValue() * d / Integer.parseInt(day) + "%");
			returnlist.add(returnmap);
		}
		return ResultUtil.getResultJson(returnlist, Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public String updateReturnWay(byte beforeDealType, byte dealType, long earningId, long userId) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andEarningsIdEqualTo(earningId);
		list = earningsDao.selectByExample(example, criteria);
		if (list == null || list.size() <= 0) {
			return ResultUtil.getResultJson(Status.myJoinedProjectNotExist.getStatus(),
					Status.myJoinedProjectNotExist.getMsg());
		}
		String ndays = sysconfigService.queryByCode(SysConstant.CONFIRM_REWARDS_BEFORE_N_DAYS);
		Date befdate = DateUtil.getBeforeDate(list.get(0).getEndTime(), Integer.parseInt(ndays));
		if (befdate.getTime() < DateUtil.getCurrentDate().getTime()) {
			return ResultUtil.getResultJson(Status.cannotModifyRepayType.getStatus(),
					Status.cannotModifyRepayType.getMsg());
		}
		if (list.get(0).getDealStatus() == CommConstant.DEAL_STATUS_1) {
			return ResultUtil.getResultJson(Status.repayAlreadyDealed.getStatus(), Status.repayAlreadyDealed.getMsg());
		}
		if (orderService.selectByUserIdAndProjectId(userId, list.get(0).getPaincbuyProjectId()) == null) {
			return ResultUtil.getResultJson(Status.cannotModifyRepayTypeBeforeCancelOrder.getStatus(),
					Status.cannotModifyRepayTypeBeforeCancelOrder.getMsg());
		}
		return ResultUtil.getResultJson(
				earningsDao.updateReturnWay(beforeDealType, dealType, earningId) == 1 ? null : null,
				Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public AppMyEarnings selectByearningsId(Long presentRelationId) {
		AppMyEarningsExample example = new AppMyEarningsExample();
		Criteria criteria = example.createCriteria();
		criteria.andEarningsIdEqualTo(presentRelationId);
		return earningsDao.selectByExample(example, criteria).get(0);
	}
}
