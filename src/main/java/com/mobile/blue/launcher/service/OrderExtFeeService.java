package com.mobile.blue.launcher.service;

import java.math.BigDecimal;

import com.mobile.blue.launcher.model.AppOrderExtFee;

public interface OrderExtFeeService {
	/**
	 * 
	 * @param orderId 
	 * @param pay_money
	 * @param num
	 * @param slaughter_fee
	 * @param division_fee
	 * @param division_type
	 * @param division_mode
	 * @param package_fee
	 * @param spec
	 * @param weight
	 * @param package_num
	 * @return
	 */
	int addOrderExtFee(Long orderId, BigDecimal pay_money, int num, BigDecimal slaughter_fee, BigDecimal division_fee,
			int division_type, int division_mode, BigDecimal package_fee, int spec,int weight,int package_num);

	int deleteByorderId(String string);

	AppOrderExtFee selectByorderId(Long orderId);

	int updateOrderExtfee(AppOrderExtFee orderextfee);

}
