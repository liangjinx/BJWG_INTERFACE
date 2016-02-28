package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.CouponDao;
import com.mobile.blue.launcher.dao.mapper.AppCouponMapper;
import com.mobile.blue.launcher.model.AppCoupon;
import com.mobile.blue.launcher.model.Example.AppCouponExample;
import com.mobile.blue.launcher.model.Example.AppCouponExample.Criteria;

@Service("couponDao")
public class CouponDaoImpl implements CouponDao {
	@Autowired
	private AppCouponMapper appCouponMapper;

	@Override
	public List<AppCoupon> selectByExample(AppCouponExample example, Criteria criteria) {
		List<AppCoupon> list = appCouponMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countCoupon(AppCouponExample example, Criteria criteria) {
		int count = appCouponMapper.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int updateCoupon(AppCoupon coupon) {
		int count = appCouponMapper.updateByPrimaryKeySelective(coupon);
		return count;
	}

	@Override
	public int insertCoupon(AppCoupon coupon) {
		return appCouponMapper.insertSelective(coupon);
	}
}
