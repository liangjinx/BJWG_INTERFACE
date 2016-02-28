package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface CouponService {

	List<Map<String, Object>> selectCouponByUserId(long userId, HttpServletRequest request, int nextPage);

	String selectCouponOne(long userId, long couponId);

	String sendFriendProk(long userId, long friendId, long couponId, double money);

}
