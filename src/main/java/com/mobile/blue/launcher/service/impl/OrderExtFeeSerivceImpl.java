package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.OrderExtFeeDao;
import com.mobile.blue.launcher.model.AppOrderExtFee;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample;
import com.mobile.blue.launcher.model.Example.AppOrderExtFeeExample.Criteria;
import com.mobile.blue.launcher.service.OrderExtFeeService;
@Service("orderExtFeeService")
public class OrderExtFeeSerivceImpl implements OrderExtFeeService {
	@Autowired
	private OrderExtFeeDao orderExtFeeDao;
	@Override
	public int addOrderExtFee(Long orderId, BigDecimal pay_money, int num, BigDecimal slaughter_fee,
			BigDecimal division_fee, int division_type, int division_mode, BigDecimal package_fee, int spec, int weight,
			int package_num) {
		AppOrderExtFee extfee=new AppOrderExtFee();
		extfee.setPayMoney(pay_money);
		extfee.setNum(num);
		extfee.setSlaughterFee(slaughter_fee);
		extfee.setDivisionFee(division_fee);
		extfee.setDivisionType(Byte.parseByte(division_type+""));
		extfee.setDivisionMode(Byte.parseByte(division_mode+""));
		extfee.setPackageFee(package_fee);
		extfee.setSpec(spec);
		extfee.setWeight(new BigDecimal(weight));
		extfee.setPackageNum(package_num);
		extfee.setOrderId(orderId);
		return orderExtFeeDao.insertOrderExtFee(extfee);
	}
	@Override
	public int deleteByorderId(String orderId) {
		return orderExtFeeDao.deleteByorderId(orderId);
	}
	@Override
	public AppOrderExtFee selectByorderId(Long orderId) {
		AppOrderExtFeeExample example=new AppOrderExtFeeExample();
		Criteria criteria=example.createCriteria();
		return orderExtFeeDao.selectByorderId(example,criteria).get(0);
	}
	@Override
	public int updateOrderExtfee(AppOrderExtFee orderextfee) {
		return orderExtFeeDao.updateOrderExtfee(orderextfee);
	}

}
