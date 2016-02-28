package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.OrderDao;
import com.mobile.blue.launcher.dao.mapper.AppOrderMapper;
import com.mobile.blue.launcher.model.AppOrder;
import com.mobile.blue.launcher.model.Example.AppOrderExample;
import com.mobile.blue.launcher.model.Example.AppOrderExample.Criteria;
import com.mobile.blue.view.OrderRankingVo;

@Service("orderDao")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private AppOrderMapper apporderMappser;

	@Override
	public List<AppOrder> selectByExample(AppOrderExample example, Criteria criteria) {
		List<AppOrder> list = apporderMappser.selectByExample(example);
		criteria.getAllCriteria().clear();
		return list;
	}

	// 删除订单就是修改为不显示状态
	@Override
	public int deleteOrder(long orderId) {
		AppOrder order = new AppOrder();
		order.setOrderId(orderId);
		order.setIsShow(new Integer(0).byteValue());
		return apporderMappser.updateByPrimaryKeySelective(order);
	}

	@Override
	public int updateOrder(AppOrder order) {
		return apporderMappser.updateByPrimaryKeySelective(order);
	}

	@Override
	public int insertOrder(AppOrder order) {
		if (order == null) {
			return 0;
		}
		if (order.getSubOrderId() == null || order.getSubOrderId() == 0) {
			order.setSubOrderId(-1l);
		}
		return apporderMappser.insertSelective(order);
	}

	@Override
	public int countByExample(AppOrderExample example, Criteria criteria) {
		int count=apporderMappser.countByExample(example);
		criteria.getAllCriteria().clear();
		return count;
	}

	@Override
	public int countByRanking(AppOrderExample example, Criteria criteria) {
		int count=apporderMappser.countByRanking(example);
		return count;
	}

	@Override
	public List<OrderRankingVo> selectByRanking(AppOrderExample example, Criteria criteria) {
		List<OrderRankingVo> list = apporderMappser.selectByRanking(example);
		criteria.getAllCriteria().clear();
		return list;
	}

}
