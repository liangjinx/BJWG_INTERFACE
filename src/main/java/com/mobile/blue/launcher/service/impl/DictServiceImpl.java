package com.mobile.blue.launcher.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.DictDao;
import com.mobile.blue.launcher.model.AppDict;
import com.mobile.blue.launcher.model.Example.AppDictExample;
import com.mobile.blue.launcher.model.Example.AppDictExample.Criteria;
import com.mobile.blue.launcher.service.DictDetailService;
import com.mobile.blue.launcher.service.DictService;
import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.SysConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Service("dictService")
public class DictServiceImpl implements DictService {
	List<AppDict> list = null;
	@Autowired
	private DictDao dictDao;
	@Autowired
	private DictDetailService dictDetailService;
	@Autowired
	private SysconfigService sysconfigService;

	@Override
	public List<Map<String, Object>> selectGrowUp(String dictGroupRecord, int day) {
		AppDictExample example = new AppDictExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(dictGroupRecord);
		list = dictDao.selectByExamlpe(example, criteria);
		List<Map<String, Object>> map = dictDetailService.selectGrowUp(list.get(0).getDictId(), day);
		return map;
	}

	@Override
	public String queryReturnsWay() {
		AppDictExample example = new AppDictExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictIdEqualTo(12l);
		list = dictDao.selectByExamlpe(example, criteria);
		return ResultUtil.getResultJson(dictDetailService.queryReturnsWay(list.get(0).getDictId()),
				Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public String queryRepayWay(String thickType) {
		AppDictExample example = new AppDictExample();
		Criteria criteria = example.createCriteria();
		Map<String, Object> map = new HashMap<String, Object>();
		criteria.andCodeEqualTo(thickType);
		list = dictDao.selectByExamlpe(example, criteria);
		map.put("DivisionWay", sysconfigService.selectDivisionWay()); 	
		map.put("ReturnsWay", dictDetailService.queryReturnsWay(list.get(0).getDictId()));
		map.put("Standard",sysconfigService.selectByCode(SysConstant.PACKAGE_SPECS));
		return ResultUtil.getResultJson(map, Status.success.getStatus(), Status.success.getMsg());
	}

}
