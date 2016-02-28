package com.mobile.blue.launcher.dao;

import java.util.List;

import com.mobile.blue.launcher.model.AppOrder;
import com.mobile.blue.launcher.model.Example.AppOrderExample;
import com.mobile.blue.launcher.model.Example.AppOrderExample.Criteria;
import com.mobile.blue.view.OrderRankingVo;

public interface OrderDao {

	List<AppOrder> selectByExample(AppOrderExample example, Criteria criteria);

	int deleteOrder(long orderId);

	int updateOrder(AppOrder order);

	int insertOrder(AppOrder order);

	int countByExample(AppOrderExample example, Criteria criteria);

	int countByRanking(AppOrderExample example, Criteria criteria);

	List<OrderRankingVo> selectByRanking(AppOrderExample example, Criteria criteria);

}
