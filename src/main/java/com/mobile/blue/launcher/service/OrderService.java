package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mobile.blue.launcher.model.AppOrder;
import com.mobile.blue.view.RequestOrderVo;

public interface OrderService {

	Map<String, Object> selectByUserIdAndProjectId(long userId, long projectId);

	List<Map<String, Object>> selectOrderByUserId(long userId, byte type,HttpServletRequest request,int nextpage);

	String oneOrderByOrderId(long userId, long orderId);

	int updateOrderBasic(RequestOrderVo order);

	Object addOrder(RequestOrderVo order) throws Exception;

	short selectByUserId(long userId);

	AppOrder selectByorderId(long orderId);

	List<Map<String, Object>> selectByprojectIdList(HttpServletRequest request,int nextPage,long projectId);

	Map<String, Object> addOrderByPeiSong(long fengeWayId, long fentiwayId, int guige, long userId, long relationId);

	AppOrder selectByorderCode(String orderCode);

	Map<String, Object> getOrderAddr(HttpServletRequest request, long userId);

}
