package com.mobile.blue.launcher.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.OrderAddressDao;
import com.mobile.blue.launcher.model.AppOrderAddress;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample;
import com.mobile.blue.launcher.model.Example.AppOrderAddressExample.Criteria;
import com.mobile.blue.launcher.service.AreaService;
import com.mobile.blue.launcher.service.OrderAddressService;

@Service("orderAddressService")
public class OrderAddressServiceImpl implements OrderAddressService {
	private Log logger = LogFactory.getLog(this.getClass());
	List<AppOrderAddress> list = null;
	@Autowired
	private OrderAddressDao orderAddressDao;
	@Autowired
	private AreaService areaService;

	@Override
	public Map<String, Object> selectAddressByOrderId(Long orderId) {
		logger.info("orderId:"+orderId);
		AppOrderAddressExample example = new AppOrderAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		list = orderAddressDao.selectByExample(example, criteria);
		Map<String, Object> map = null;
		if (list!=null && list.size() > 0) {
			map = new HashMap<String, Object>();
			if(list.get(0).getProvince()!=null){
				map.put("province", areaService.selectById(list.get(0).getProvince()).getName());
			}else{
				map.put("province","");
			}
			if(list.get(0).getCity()!=null){
				map.put("city", areaService.selectById(list.get(0).getCity()).getName());
			}else{
				map.put("city","");
			}
			map.put("address", list.get(0).getAddress());
		}
		return map;
	}


	@Override
	public int insertAddress(Long order,AppUserAddress adr, String remark) {
		return orderAddressDao.insertOrder(order,adr, remark);
	}


	@Override
	public int updateorderAddress(Long orderId, AppUserAddress address) {
		// TODO Auto-generated method stub
		return orderAddressDao.updateorderAddress(orderId,address);
	}

}
