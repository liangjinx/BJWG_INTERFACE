package com.mobile.blue.launcher.service;

import java.util.Map;

import com.mobile.blue.launcher.model.AppUserAddress;

public interface OrderAddressService {

	Map<String, Object> selectAddressByOrderId(Long orderId);

	int insertAddress(Long order, AppUserAddress adr, String remark);

	int updateorderAddress(Long orderId, AppUserAddress address);

}
