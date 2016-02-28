package com.mobile.blue.launcher.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.model.AppUserAddress;

@Service("userAddressService")
public interface UserAddressService {

	List<AppUserAddress> selectUserAllAdress(HttpServletRequest request,int nextPage,long userId) throws Exception;

	String updateUserAddress(AppUserAddress address);

	String selectProvinceList();

	String selectCityInProvince(long cityCode);

	String addUserAddress(AppUserAddress address);

	String deleteUserAddress(long addressId);

	AppUserAddress selectUserDefault(long userId);

	AppUserAddress selectUserAddressById(long addressId);

}
