package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppOrderExtFee;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample.Criteria;

public interface OrderExtFeeDao {

	int insertOrderExtFee(AppOrderExtFee orderExtFee);

	int deleteByorderId(String orderId);

	List<AppOrderExtFee> selectByorderId(AppOrderExtFeeExample example, Criteria criteria);

	int updateOrderExtfee(AppOrderExtFee orderextfee);

}
