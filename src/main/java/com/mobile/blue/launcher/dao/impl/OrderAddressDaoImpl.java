package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.OrderAddressDao;
import com.mobile.blue.launcher.dao.mapper.AppOrderAddressMapper;
import com.mobile.blue.launcher.model.AppOrderAddress;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample.Criteria;

@Service("orderAddressDao")
public class OrderAddressDaoImpl implements OrderAddressDao {
	@Autowired
	private AppOrderAddressMapper appOrderAddressMapper;

	@Override
	public List<AppOrderAddress> selectByExample(AppOrderAddressExample example, Criteria criteria) {
		List<AppOrderAddress> list = appOrderAddressMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	@Override
	public int insertOrder(Long order,AppUserAddress add, String remak) {
		AppOrderAddress orderad = new AppOrderAddress();
		orderad.setAddress(add.getAddress());
		orderad.setCity(add.getCity());
		orderad.setLinkMan(add.getContactMan());
		orderad.setLinkPhone(add.getContactPhone());
		orderad.setProvince(add.getProvince());
		orderad.setUserId(add.getUserId());
		orderad.setRemark(remak);
		orderad.setOrderId(order);
		return appOrderAddressMapper.insertSelective(orderad);
	}

	@Override
	public int updateorderAddress(Long orderId, AppUserAddress add) {
		AppOrderAddress orderad = new AppOrderAddress();
		orderad.setAddress(add.getAddress());
		orderad.setCity(add.getCity());
		orderad.setLinkMan(add.getContactMan());
		orderad.setLinkPhone(add.getContactPhone());
		orderad.setProvince(add.getProvince());
		orderad.setUserId(add.getUserId());
		orderad.setOrderId(orderId);
		return appOrderAddressMapper.updateByPrimaryKeySelective(orderad);
	}

}
