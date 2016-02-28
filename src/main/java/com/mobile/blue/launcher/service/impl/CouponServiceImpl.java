package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.CouponDao;
import com.mobile.blue.launcher.model.AppCoupon;
import com.mobile.blue.launcher.model.Example.AppCouponExample;
import com.mobile.blue.launcher.model.Example.AppCouponExample.Criteria;
import com.mobile.blue.launcher.service.CouponService;
import com.mobile.blue.launcher.service.FriendService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.CommConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Service("couponService")
public class CouponServiceImpl implements CouponService {
	List<AppCoupon> list = null;
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private FriendService friendService;
	@Override
	public List<Map<String, Object>> selectCouponByUserId(long userId,HttpServletRequest request, int nextPage) {
		AppCouponExample example = new AppCouponExample();
		Criteria criteria = example.createCriteria();
		PageParameter page=(PageParameter) request.getSession().getAttribute("selectCouponByUserId");
		if(page==null){
			page = new PageParameter(0,BasicConstant.limit_page_size);
			criteria.andUserIdEqualTo(userId);
			criteria.andEndTimeGreaterThanOrEqualTo(DateUtil.getCurrentDate());
			criteria.andStatusNotEqualTo(CommConstant.COUPON_STATUS_2);
			int count=couponDao.countCoupon(example, criteria);
			page.setCount(count);
		}else{
			if(nextPage>page.getTotal()){
				return null;
			}
			page.setCurrent(nextPage);
		}
		criteria.andUserIdEqualTo(userId);
		criteria.andEndTimeGreaterThanOrEqualTo(DateUtil.getCurrentDate());
		criteria.andStatusNotEqualTo(CommConstant.COUPON_STATUS_2);
		example.setPage(page);
		list = couponDao.selectByExample(example, criteria);
		List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
		if(list!=null || list.size()>0){
			request.getSession().setAttribute("selectCouponByUserId", page);
			Map<String, Object> returnmap=null;
			for(AppCoupon coupon:list){
				returnmap=new HashMap<String, Object>();
				returnmap.put("couponName", coupon.getCouponName());
				returnmap.put("couponMoney", coupon.getCouponMoney());
				returnmap.put("couponId", coupon.getCouponId());
				returnmap.put("beginTime", coupon.getBeginTime().getTime());
				returnmap.put("endTime", coupon.getEndTime().getTime());
				returnmap.put("userId", coupon.getUserId());
				returnmap.put("status", coupon.getStatus());
				returnmap.put("remark", coupon.getRemark());
				returnlist.add(returnmap);
			}
		}
		return returnlist;
	}

	@Override
	public String selectCouponOne(long userId, long couponId) {
		AppCouponExample example = new AppCouponExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andCouponIdEqualTo(couponId);
		list = couponDao.selectByExample(example, criteria);
		List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
		if(list!=null || list.size()>0){
			Map<String, Object> returnmap=null;
			for(AppCoupon coupon:list){
				returnmap=new HashMap<String, Object>();
				returnmap.put("myCouponId", coupon.getMyCouponId());
				returnmap.put("couponName", coupon.getCouponName());
				returnmap.put("couponMoney", coupon.getCouponMoney());
				returnmap.put("couponId", coupon.getCouponId());
				returnmap.put("beginTime", coupon.getBeginTime().getTime());
				returnmap.put("endTime", coupon.getEndTime().getTime());
				returnmap.put("couponCode", coupon.getCouponCode());
				returnmap.put("relationId", coupon.getRelationId());
				returnmap.put("relationType", coupon.getRelationType());
				returnmap.put("userId", coupon.getUserId());
				returnmap.put("couponImg", coupon.getCouponImg());
				returnmap.put("status", coupon.getStatus());
				returnmap.put("lastUseTime", coupon.getLastUseTime());
				returnmap.put("canUseMoney", coupon.getCanUseMoney());
				returnmap.put("remark", coupon.getRemark());
				returnmap.put("ctime", coupon.getCtime());
				returnlist.add(returnmap);
			}
		}
		return ResultUtil.getResultJson(returnlist, Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public String sendFriendProk(long userId, long friendId, long couponId, double money) {
		AppCouponExample example = new AppCouponExample();
		Criteria criteria = example.createCriteria();
		if (friendService.selectFriendCount(friendId, userId) != 1)
			return ResultUtil.getResultJson(Status.freindsIdNullity.getStatus(), Status.freindsIdNullity.getMsg());
		else {
			// 查询卷的可用数量可不可以
			criteria.andUserIdEqualTo(userId);
			criteria.andCouponIdEqualTo(couponId);
			list = couponDao.selectByExample(example, criteria);
			if (list==null || list.size() <= 0) {
				return ResultUtil.getResultJson(Status.couponNotExist.getStatus(), Status.couponNotExist.getMsg());
			}
			// 修改卷的数量
			if (list.get(0).getCanUseMoney().doubleValue() < money) {
				return ResultUtil.getResultJson(Status.moneyNotEnough.getStatus(), Status.moneyNotEnough.getMsg());
			}
			// 修改我的卷值
			AppCoupon coupon = list.get(0);
			coupon.setUserId(userId);
			coupon.setCouponId(couponId);
			coupon.setCanUseMoney(new BigDecimal(list.get(0).getCanUseMoney().doubleValue() - money));
			if(couponDao.updateCoupon(coupon)<=0){
				return ResultUtil.getResultJson(306, "修改我的卷值失败");
			}
			// 修改haoyou的卷值，
			// 查询好友是否有该卷
			criteria.andUserIdEqualTo(friendId);
			criteria.andCouponIdEqualTo(couponId);
			List<AppCoupon> friendcoupon = couponDao.selectByExample(example, criteria);
			int value=0;
			if (friendcoupon==null || friendcoupon.size() <= 0) {
				// 表示好友没有该卷
				coupon.setMyCouponId(null);
				coupon.setRelationType(new Integer(2).byteValue());
				coupon.setUserId(friendId);
				coupon.setStatus(new Integer(1).byteValue());
				coupon.setCanUseMoney(new BigDecimal(money));
				value=couponDao.insertCoupon(coupon);
			}else{
				//表示好友有该卷
				coupon = friendcoupon.get(0);
				coupon.setCanUseMoney(new BigDecimal(list.get(0).getCanUseMoney().doubleValue() + money));
				value=couponDao.updateCoupon(coupon);
			}
			if(value<=0){
				return ResultUtil.getResultJson(306, "修改好友卷值失败");
			}
			// 发送消息给朋友
		}
		return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
	}

}
