package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.UseraddressDao;
import com.mobile.blue.launcher.dao.mapper.AppUserAddressMapper;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample.Criteria;

@Service("useraddressDao")
public class UserAddressDaoImpl implements UseraddressDao {
	@Autowired
	AppUserAddressMapper appUserAddressMapper;

	@Override
	public int insertSelective(AppUserAddress addredd) {
		return appUserAddressMapper.insertSelective(addredd);
	}

	@Override
	public List<AppUserAddress> selectByExample(AppUserAddressExample userAddressExample, Criteria criteria) {
		List<AppUserAddress> list = appUserAddressMapper.selectByExample(userAddressExample);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int countByExample(AppUserAddressExample userAddressExample, Criteria criteria) {
		int value = appUserAddressMapper.countByExample(userAddressExample);
		criteria.getAllCriteria().clear();
		return value;
	}

	@Override
	public int updateUserAddress(AppUserAddress address) {
		return appUserAddressMapper.updateByPrimaryKey(address);
	}

	@Override
	public int deleteUserAddress(long addressId) {
		return appUserAddressMapper.deleteByPrimaryKey(addressId);
	}

}
