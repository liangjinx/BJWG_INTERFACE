package com.mobile.blue.launcher.dao.mapper;

import com.mobile.blue.annotation.MyBatisRepository;
import com.mobile.blue.launcher.model.AppCoupon;
import com.mobile.blue.launcher.model.Example.AppCouponExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@MyBatisRepository
public interface AppCouponMapper {
	int countByExample(AppCouponExample example);

	int deleteByPrimaryKey(Long myCouponId);

	int insert(AppCoupon record);

	int insertSelective(AppCoupon record);

	List<AppCoupon> selectByExample(AppCouponExample example);

	AppCoupon selectByPrimaryKey(Long myCouponId);

	int updateByPrimaryKeySelective(AppCoupon record);

	int updateByPrimaryKey(AppCoupon record);
}