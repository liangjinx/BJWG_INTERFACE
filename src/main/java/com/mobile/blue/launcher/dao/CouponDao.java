package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppCoupon;
import com.mobile.blue.launcher.model.Example.AppCouponExample;
import com.mobile.blue.launcher.model.Example.AppCouponExample.Criteria;

public interface CouponDao {

	List<AppCoupon> selectByExample(AppCouponExample example, Criteria criteria);

	int countCoupon(AppCouponExample example, Criteria criteria);

	int updateCoupon(AppCoupon coupon);

	int insertCoupon(AppCoupon coupon);

}
