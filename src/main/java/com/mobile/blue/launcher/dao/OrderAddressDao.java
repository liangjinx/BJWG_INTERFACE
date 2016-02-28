package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppOrderAddress;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample.Criteria;

public interface OrderAddressDao {

	List<AppOrderAddress> selectByExample(AppOrderAddressExample example, Criteria criteria);

	int insertOrder(Long order, AppUserAddress add, String remak);

	int updateorderAddress(Long orderId, AppUserAddress address);

}
