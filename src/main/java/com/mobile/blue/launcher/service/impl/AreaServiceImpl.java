package com.mobile.blue.launcher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.AreaDao;
import com.mobile.blue.launcher.model.AppArea;
import com.mobile.blue.launcher.model.Example.AppAreaExample;
import com.mobile.blue.launcher.model.Example.AppAreaExample.Criteria;
import com.mobile.blue.launcher.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
	List<AppArea> list = null;
	@Autowired
	private AreaDao areaDao;

	/**
	 * 根据城市id 查询省份，返回省份的名字加城市的名字
	 * 
	 * @param cityList
	 * @return
	 */
	@Override
	public String selectQuanAddressList(long cityId, long province) {
		AppAreaExample AppareaExample = new AppAreaExample();
		Criteria criteria = AppareaExample.createCriteria();
		List<AppArea> list2 = new ArrayList<AppArea>();
		if (cityId != 0) {
			criteria.andAreaIdEqualTo(cityId);
			list = areaDao.selectByExample(AppareaExample, criteria);
		}
		if (province != 0) {
			criteria.andAreaIdEqualTo(province);
			list2 = areaDao.selectByExample(AppareaExample, criteria);
		}
		String address = "";
		if (list2!=null && list2.size() > 0) {
			address = address + list2.get(0).getName();
		}
		if (list!=null && list.size() > 0) {
			address = address + list.get(0).getName();
		}
		return address;
	}

	/**
	 * 查询所有城市列表
	 */
	@Override
	public List<AppArea> selectProvinceList() {
		AppAreaExample AppareaExample = new AppAreaExample();
		Criteria criteria = AppareaExample.createCriteria();
		criteria.andParentEqualTo(0l);
		list=areaDao.selectByExample(AppareaExample, criteria);
		return list;
	}

	@Override
	public List<AppArea> selectCityInProvince(long provinceCode) {
		AppAreaExample AppareaExample = new AppAreaExample();
		Criteria criteria = AppareaExample.createCriteria();
		criteria.andParentEqualTo(provinceCode);
		list = areaDao.selectByExample(AppareaExample, criteria);
		return list;
	}

	@Override
	public String selectValueByid(Long province) {
		AppAreaExample AppareaExample = new AppAreaExample();
		Criteria criteria = AppareaExample.createCriteria();
		criteria.andAreaIdEqualTo(province);
		list = areaDao.selectByExample(AppareaExample, criteria);
		return list.get(0).getName();
	}

	@Override
	public AppArea selectById(Long areaId) {
		AppAreaExample AppareaExample = new AppAreaExample();
		Criteria criteria = AppareaExample.createCriteria();
		criteria.andAreaIdEqualTo(areaId);
		list = areaDao.selectByExample(AppareaExample, criteria);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
