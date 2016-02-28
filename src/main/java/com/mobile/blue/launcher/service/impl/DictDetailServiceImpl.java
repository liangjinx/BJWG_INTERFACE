package com.mobile.blue.launcher.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.DictDetailDao;
import com.mobile.blue.launcher.model.AppDictDefatl;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample;
import com.mobile.blue.launcher.model.Example.AppDictDefatlExample.Criteria;
import com.mobile.blue.launcher.service.DictDetailService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.view.BankNameVo;

@Service("dictDetailService")
public class DictDetailServiceImpl implements DictDetailService {
	List<AppDictDefatl> list = null;
	@Autowired
	private DictDetailDao dictDetailDao;

	@Override
	public List<Map<String, Object>> selectGrowUp(long id, int day) {
		AppDictDefatlExample example = new AppDictDefatlExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictIdEqualTo(id);
		list = dictDetailDao.selectselectGrowdefatl(example, criteria);
		if (list.size() <= 0) {
			return null;
		}
		List<Map<String, Object>> remakeList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (AppDictDefatl dictdefatl : list) {
			map = new HashMap<String, Object>();
			if (Integer.parseInt(dictdefatl.getValue()) < day) {
				map.put("remark", dictdefatl.getRemark());
				if (Integer.parseInt(dictdefatl.getValue()) < 0) {
					int beforeDay = Integer.parseInt(dictdefatl.getValue().replaceAll("-", "")) + day;
					// 表示在用户购买之前的小猪生长情况，出生到被购买
					Date date= DateUtil.getBeforeDate(DateUtil.getCurrentDate(), beforeDay);
					map.put("time", date.getTime());
				} else {
					// 表示用户在购买之后的小猪生长情况
					Date date= DateUtil.getBeforeDate(DateUtil.getCurrentDate(),
							day - Integer.parseInt(dictdefatl.getValue()));
					map.put("time",date.getTime());
				}
				remakeList.add(map);
			}
		}
		return remakeList;
	}

	@Override
	public List<Map<String, Object>> queryReturnsWay(Long dictId) {
		AppDictDefatlExample example = new AppDictDefatlExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictIdEqualTo(dictId);
		List<AppDictDefatl> list=dictDetailDao.selectselectGrowdefatl(example, criteria);
		List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap=null;
		if(list!=null && list.size()>0){
			for(AppDictDefatl dictdefatl:list){
				returnmap=new HashMap<String, Object>();
				returnmap.put("dictDetailId",dictdefatl.getDictDetailId());
				returnmap.put("value", dictdefatl.getValue());
				returnmap.put("name", dictdefatl.getName());
				returnlist.add(returnmap);
			}
		}
		return returnlist;
	}

	@Override
	public String selectvalueByName(String bankName) {
		AppDictDefatlExample example = new AppDictDefatlExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(bankName);
		example.setDistinct(true);
		list=dictDetailDao.selectselectGrowdefatl(example, criteria);
		if(list==null || list.size()<=0){
			return null;
		}
		System.out.println(list.get(0).getValue());
		return list.get(0).getValue();
	}
	/**
	 * 查询银行卡列表
	 */
	@Override
	public List<Map<String, Object>> selectBankNamelist() {
		AppDictDefatlExample example = new AppDictDefatlExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%银行%");
		List<BankNameVo> banklist=dictDetailDao.selectBankNamelist(example,criteria);
		List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap=null;
		if(banklist==null || banklist.size()<=0){
			return null;
		}
		for(BankNameVo dictdefatl:banklist){
			returnmap=new HashMap<String, Object>();
			returnmap.put("bankName",dictdefatl.getBankName());
			returnmap.put("value",dictdefatl.getValue());
			returnlist.add(returnmap);
		}
		return returnlist;
	}

	@Override
	public Map<String, Object> verifyBankcard(String bankCardNumber) {
		AppDictDefatlExample example = new AppDictDefatlExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(bankCardNumber);
		list=dictDetailDao.selectselectGrowdefatl(example, criteria);
		if(list==null || list.size()<0){
			return null;
		}
		Map<String, Object> returnmap=new HashMap<String,Object>();
		returnmap.put("bankName",list.get(0).getName());
		returnmap.put("type",list.get(0).getValue());
		return returnmap;
	}

	@Override
	public String getvalueById(long fentiwayId) {
		AppDictDefatlExample example = new AppDictDefatlExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictDetailIdEqualTo(fentiwayId);
		list=dictDetailDao.selectselectGrowdefatl(example, criteria);
		return list.get(0).getValue();
	}
}
