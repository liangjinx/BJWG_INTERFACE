package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample.Criteria;

public interface UseraddressDao {

	int insertSelective(AppUserAddress addredd);

	List<AppUserAddress> selectByExample(AppUserAddressExample userAddressExample, Criteria criteria);

	int countByExample(AppUserAddressExample userAddressExample, Criteria criteria);

	int updateUserAddress(AppUserAddress address);

	int deleteUserAddress(long addressId);
}
