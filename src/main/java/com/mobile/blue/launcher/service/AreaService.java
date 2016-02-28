package com.mobile.blue.launcher.service;

import java.util.List;

import com.mobile.blue.launcher.model.AppArea;

public interface AreaService {

	List<AppArea> selectProvinceList();

	String selectQuanAddressList(long city, long province);

	List<AppArea> selectCityInProvince(long provinceCode);

	String selectValueByid(Long province);

	AppArea selectById(Long areaId);

}
