package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.OrderExtFeeDao;
import com.mobile.blue.launcher.dao.mapper.AppOrderExtFeeMapper;
import com.mobile.blue.launcher.model.AppOrderExtFee;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample.Criteria;
@Service("orderExtFeeDao")
public class OrderExtFeeDaoImpl implements OrderExtFeeDao {
	@Autowired
	private AppOrderExtFeeMapper appOrderExtFeeMapper;
	@Override
	public int insertOrderExtFee(AppOrderExtFee orderExtFee) {
		return appOrderExtFeeMapper.insertSelective(orderExtFee);
	}
	@Override
	public int deleteByorderId(String orderId) {
		return appOrderExtFeeMapper.deleteByPrimaryKey(Long.parseLong(orderId));
	}
	@Override
	public List<AppOrderExtFee> selectByorderId(AppOrderExtFeeExample example, Criteria criteria) {
		List<AppOrderExtFee> list=appOrderExtFeeMapper.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}
	@Override
	public int updateOrderExtfee(AppOrderExtFee orderextfee) {
		return appOrderExtFeeMapper.updateByPrimaryKeySelective(orderextfee);
	}

}
