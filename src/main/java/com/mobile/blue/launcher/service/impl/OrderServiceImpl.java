package com.mobile.blue.launcher.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mobile.blue.launcher.dao.OrderDao;
import com.mobile.blue.launcher.model.AppOrder;
import com.mobile.blue.launcher.model.AppOrderExtFee;
import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppOrderExample;
import com.mobile.blue.launcher.model.Example.AppOrderExample.Criteria;
import com.mobile.blue.launcher.service.AreaService;
import com.mobile.blue.launcher.service.EarningsService;
import com.mobile.blue.launcher.service.MessageService;
import com.mobile.blue.launcher.service.OrderAddressService;
import com.mobile.blue.launcher.service.OrderExtFeeService;
import com.mobile.blue.launcher.service.OrderService;
import com.mobile.blue.launcher.service.ProjectService;
import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.launcher.service.UserAddressService;
import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.OrderConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.SysConstant;
import com.mobile.blue.util.util.RandomUtils;
import com.mobile.blue.view.OrderRankingVo;
import com.mobile.blue.view.RequestOrderVo;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	List<AppOrder> list = null;
	private Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderAddressService orderAddressService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserBasicService userBasicService;
	@Autowired
	private SysconfigService sysconfigService;
	@Autowired
	private EarningsService earningsService;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private AreaService areaServicel;
	@Autowired
	private OrderExtFeeService orderExtFeeService;
	@Autowired
	private ProjectService projectService;

	@Override
	public Map<String, Object> selectByUserIdAndProjectId(long userId, long projectId) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andRelationIdEqualTo(projectId);
		criteria.andStatusGreaterThanOrEqualTo(OrderConstant.ORDER_STATUS_3);
		criteria.andTypeEqualTo(OrderConstant.ORDER_TYPE_1);
		list = orderDao.selectByExample(example, criteria);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.size() > 0) {
			map.put("order_code", list.get(0).getOrderCode());
			map.put("num", list.get(0).getNum());
			map.put("total_money", list.get(0).getTotalMoney());
			map.put("order_id", list.get(0).getOrderId());
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> selectOrderByUserId(long userId, byte type, HttpServletRequest request,
			int nextpage) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		PageParameter page = (PageParameter) request.getSession().getAttribute("orderByuserId");
		if (page == null) {
			page = new PageParameter(0, BasicConstant.limit_page_size);
			if (type != 0) {
				criteria.andStatusEqualTo(type);
			}
			example.setOrderByClause("ctime desc");
			criteria.andUserIdEqualTo(userId);
			criteria.andIsShowEqualTo(new Integer(1).byteValue());
			int count = orderDao.countByExample(example, criteria);
			page.setCount(count);
		} else {
			if (nextpage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextpage);
		}
		if (type != 0) {
			criteria.andStatusEqualTo(type);
		}
		example.setOrderByClause("ctime desc");
		criteria.andUserIdEqualTo(userId);
		criteria.andIsShowEqualTo(new Integer(1).byteValue());
		example.setPage(page);
		list = orderDao.selectByExample(example, criteria);
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		if (list != null && list.size() > 0) {
			request.getSession().setAttribute("orderByuserId", page);
			Map<String, Object> map = null;
			for (AppOrder order : list) {
				map = new HashMap<String, Object>();
				map.put("projectName", order.getRelationName());
				map.put("projectId", order.getRelationId());
				map.put("price", order.getPrice());
				map.put("num", order.getNum());
				map.put("totalMoney", order.getTotalMoney());
				map.put("status", order.getStatus());
				map.put("ctime", order.getCtime() == null ? 0 : order.getCtime().getTime());
				map.put("orderId", order.getOrderId());
				map.put("orderCode", order.getOrderCode());
				map.put("type", order.getType());
				map.put("payTime", order.getPayTime() == null ? 0 : order.getPayTime().getTime());
				map.put("userId", order.getUserId());
				map.put("remark", order.getRemark());
				map.put("payType", order.getPayType());
				map.put("overTime", order.getOverTime() == null ? 0 : order.getOverTime().getTime());
				map.put("productImg", order.getProductImg());
				map.put("subOrderId", order.getSubOrderId());
				map.put("confirmTime", order.getConfirmTime() == null ? 0 : order.getConfirmTime().getTime());
				map.put("prepayOrderCode", order.getPrepayOrderCode());
				returnlist.add(map);
			}
		}
		return returnlist;
	}

	@Override
	public String oneOrderByOrderId(long userId, long orderId) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andUserIdEqualTo(userId);
		list = orderDao.selectByExample(example, criteria);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		for (AppOrder order : list) {
			if (order.getType().intValue() == OrderConstant.ORDER_TYPE_2
					|| order.getType().intValue() == OrderConstant.ORDER_TYPE_3) {
				Map<String, Object> map = orderAddressService.selectAddressByOrderId(order.getOrderId());
				if (map != null) {
					returnMap.put("province", map.get("province"));
					returnMap.put("city", map.get("city"));
					returnMap.put("address", map.get("province").toString() + map.get("city") + map.get("address"));
				}
			}
		}
		return ResultUtil.getResultJson(returnMap, Status.success.getStatus(), Status.success.getMsg());
	}

	@SuppressWarnings("static-access")
	@Override
	public Object addOrder(RequestOrderVo orders) throws Exception {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		if (orders.getType() == 2 || orders.getType() == 3) {
			Map<String, Object> orderMap = earningsService.selectInvestOne(orders.getUserId(), orders.getRelationId());
			String vlaue = null;
			if (orderMap != null) {
				vlaue = earningsService.updateReturnWay(Byte.parseByte(orderMap.get("dealType").toString()),
						Byte.parseByte("3"), Long.parseLong(orderMap.get("earningsId").toString()), orders.getUserId());
			}
			if (vlaue != null) {
				JSONObject json = new JSONObject();
				json = (JSONObject) json.parse(vlaue);
				if (Integer.parseInt(json.getShort("status").toString()) == 1) {

				} else {
					return vlaue;
				}
			}
			if(orders.getType() == 2){
				orders.setStatus(Byte.parseByte("1"));
			}
			if(orders.getType() == 3){
				orders.setStatus(Byte.parseByte("4"));
			}
		}
		// 以上表示老订单
		Map<String, Object> map = projectService.selectById(orders.getRelationId());
		if (map == null || map.size() < 0) {
			return null;
		}
		if (orders.getUserId() == 0) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		if (orders.getPrice() == null) {
			orders.setPrice(new BigDecimal(map.get("price").toString()));
		}
		if (orders.getProjectName() == null || "".equals(orders.getProjectName())) {
			orders.setProjectName(map.get("name").toString());
		}
		orders.setIsShow(Byte.parseByte("1"));
		AppOrder order = getOrder(orders, 2);
		int flag = 0;
		if (orderDao.insertOrder(order) > 0) {
			if (orders.getType() == 2) {
				// 表示屠宰配送
				/**
				 * 1，修改订单表,增加子订单 2，修改订单费用扩展表 3，增加订单收获地址
				 */
				criteria.andUserIdEqualTo(orders.getUserId());
				criteria.andRelationIdEqualTo(orders.getRelationId());
				criteria.andOrderCodeEqualTo(order.getOrderCode());
				List<AppOrder> li = orderDao.selectByExample(example, criteria);
				if (li != null && li.size() > 0) {
					order.setSubOrderId(li.get(0).getOrderId());
					flag = orderDao.updateOrder(order);
				}
				criteria.andUserIdEqualTo(orders.getUserId());
				criteria.andRelationIdEqualTo(orders.getRelationId());
				list = orderDao.selectByExample(example, criteria);
				AppUserAddress adr = userAddressService.selectUserAddressById(orders.getAddressId());
				if (adr != null) {
					adr.setUserId(orders.getUserId());
					if (list == null || list.size() <= 0) {
						if (orderAddressService.insertAddress(list.get(0).getOrderId(), adr, orders.getRemark()) > 0) {
							logger.info("insert order address success buy type 2");
							flag = 1;
						}
					}
				}
			} else if (orders.getType() == 3) {
				// 表示领取活猪,
				/**
				 * 1,收益表，修改收益的回报方式 2，添加收货地址信息
				 */
				criteria.andUserIdEqualTo(orders.getUserId());
				criteria.andRelationIdEqualTo(orders.getRelationId());
				list = orderDao.selectByExample(example, criteria);
				if (list != null && list.size() > 0) {
					AppUserAddress address = userAddressService.selectUserAddressById(orders.getAddressId());
					if (orderAddressService.selectAddressByOrderId(list.get(0).getOrderId()) == null) {
						if (orderAddressService.insertAddress(list.get(0).getOrderId(), address,
								orders.getRemark()) > 0) {
							logger.info("insert order address success  buy type 3");
							flag = 1;
						}
					} else {
						flag = orderAddressService.updateorderAddress(list.get(0).getOrderId(), address);
					}

				}
			} else if (orders.getType() == 1) {
				// 表示的是抢购生成的订单，需要修改项目表中项目剩余的数量
				order.setNum(orders.getNum());
				int type = 1;
				flag = projectService.updateProject(orders.getRelationId(), orders.getNum(), type);
			}
			if (flag == 1) {

				// 发送消息,生成订单成功
				criteria.andUserIdEqualTo(order.getUserId());
				criteria.andOrderCodeEqualTo(order.getOrderCode());
				order = orderDao.selectByExample(example, criteria).get(0);
				String ss = "";
				switch (order.getStatus()) {
				case -1:
					ss = "已取消";
					break;
				case 1:
					ss = "未付款";
					break;
				case 2:
					ss = "付款中";
					break;
				case 3:
					ss = "已付款";
					break;
				case 4:
					ss = "已选择处理方式";
					break;
				case 5:
					ss = "已确认收货";
					break;
				default:
					ss = "新增";
				}
				String msg = "您的订单编号为【" + order.getOrderCode() + "】 的" + ss + "的订单" + ss + "成功";
				messageService.addMessage(order.getUserId(), msg, 1, order.getOrderId(), new Integer(1).byteValue());
			}
			Map<String, Object> returnmap = new HashMap<String, Object>();
			returnmap.put("ctime", order.getCtime() == null ? null : order.getCtime().getTime());
			returnmap.put("orderCode", order.getOrderCode());
			returnmap.put("projectName", map.get("name"));
			returnmap.put("projectId", map.get("paincbuy_project_id"));
			returnmap.put("imgs", map.get("imgs"));
			returnmap.put("num", map.get("num"));
			returnmap.put("price", map.get("price"));
			returnmap.put("total_money", map.get("total_money"));
			return returnmap;
		} else {
			// 删除订单扩展表的信息
			if (list != null && list.size() > 0) {
				orderExtFeeService.deleteByorderId(list.get(0).getOrderId() + "");
			}
		}
		return null;
	}

	@Override
	public int updateOrderBasic(RequestOrderVo order) {
		logger.info("order:"+order.toString());
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		if (orderDao.updateOrder(getOrder(order, 1)) >= 1) {
			if (order.getType() == 2 || order.getType() == 3) {
				// 表示屠宰配送
				criteria.andOrderIdEqualTo(order.getOrderId());
				Map<String, Object> orderMap = earningsService.selectInvestOne(order.getUserId(),
						orderDao.selectByExample(example, criteria).get(0).getRelationId());
				earningsService.updateReturnWay(Byte.parseByte(orderMap.get("dealType").toString()),
						Byte.parseByte("0"), Long.parseLong(orderMap.get("earningsId").toString()), order.getUserId());
			}
			if (order.getStatus() == -1) {
				int type = 0;
				criteria.andOrderCodeEqualTo(order.getOrderCode());
				projectService.updateProject(orderDao.selectByExample(example, criteria).get(0).getRelationId(),
						order.getNum(), type);
			}
			// AppOrder aa = orderDao.selectByExample(example, criteria).get(0);
			String ss = "";
			switch (order.getStatus()) {
			case -1:
				ss = "已取消";
				break;
			case 1:
				ss = "未付款";
				break;
			case 2:
				ss = "付款中";
				break;
			case 3:
				ss = "已付款";
				break;
			case 4:
				ss = "已选择处理方式";
				break;
			case 5:
				ss = "已确认收货";
				break;
			default:
				ss = "新加";
			}
			String msg = "您的订单编号为【" + order.getOrderCode() + "】 的" + ss + "的订单" + ss + "成功";
			messageService.addMessage(order.getUserId(), msg, order.getStatus(), order.getOrderId(),
					new Integer(1).byteValue());
			return 1;
		}
		return 0;
	}

	private AppOrder getOrder(RequestOrderVo ordervo, int type) {
		AppOrder order = new AppOrder();
		order.setOrderId(ordervo.getOrderId());
		order.setUserId(ordervo.getUserId());
		order.setRelationId(ordervo.getRelationId());
		order.setStatus(ordervo.getStatus());
		order.setNum(ordervo.getNum());
		order.setPrice(ordervo.getPrice());
		order.setTotalMoney(ordervo.getTotalMoney());
		order.setPayTime(ordervo.getPayTime());
		order.setRemark(ordervo.getRemark());
		order.setConfirmTime(ordervo.getConfirmTime());
		order.setIsShow(ordervo.getIsShow());
		order.setType(ordervo.getType());
		order.setOrderCode(ordervo.getOrderCode());
		order.setRelationName(ordervo.getProjectName());
		if (type == 2) {
			// 表示增加订单
			order.setCtime(DateUtil.getCurrentDate());
			order.setOrderCode(DateUtil.format(DateUtil.getCurrentDate(), "yyMMddmmss") + RandomUtils.getNum(6));
		}
		return order;
	}

	@Override
	public short selectByUserId(long userId) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusEqualTo(new Integer(3).byteValue());
		list = orderDao.selectByExample(example, criteria);
		if (list == null || list.size() <= 0) {
			return 0;
		}
		short number = 0;
		for (AppOrder order : list) {
			number = (short) (number + order.getNum());
		}
		return number;
	}

	@Override
	public AppOrder selectByorderId(long orderId) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return orderDao.selectByExample(example, criteria).get(0);
	}

	@Override
	public List<Map<String, Object>> selectByprojectIdList(HttpServletRequest request, int nextPage, long projectId) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		PageParameter page = (PageParameter) request.getSession().getAttribute(projectId + "");
		if (page == null) {
			page = new PageParameter(0, BasicConstant.limit_page_size);
			example.setDistinct(true);
			example.setOrderByClause("num desc");
			criteria.andRelationIdEqualTo(projectId);
			criteria.andTypeEqualTo(Byte.valueOf("1"));
			int count = orderDao.countByRanking(example, criteria);
			page.setCount(count);
		} else {
			if (nextPage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextPage);
		}
		example.setDistinct(true);
		example.setOrderByClause("num desc");
		criteria.andRelationIdEqualTo(projectId);
		criteria.andTypeEqualTo(Byte.valueOf("1"));
		example.setPage(page);
		List<OrderRankingVo> orderlist = orderDao.selectByRanking(example, criteria);
		logger.info("orderlist:" + orderlist.size());
		request.getSession().setAttribute(projectId + "", page);
		logger.info("page:" + page.toString());
		Map<String, Object> returnmap = null;
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		if (orderlist != null && orderlist.size() > 0) {
			AppUser user = null;
			for (OrderRankingVo order : orderlist) {
				logger.info("order_user_id:" + order.getUser_id());
				user = userBasicService.selectUserById(order.getUser_id());
				if (user != null) {
					returnmap = new HashMap<String, Object>();
					returnmap.put("headImg", user.getHeadImg());
					returnmap.put("nickname", user.getNickname());
					returnmap.put("num", order.getCount());
					returnlist.add(returnmap);
				}
			}
		}
		return returnlist;
	}

	@Override
	public Map<String, Object> addOrderByPeiSong(long fengeWayId, long fentiwayId, int guige, long userId,
			long relationId) {
		AppUserAddress useraddr = userAddressService.selectUserDefault(userId);
		Map<String, Object> datamap = getFeiyong(fengeWayId, fentiwayId, guige, userId, relationId);
		String addrString = "";
		if (useraddr.getProvince() != null) {
			addrString = areaServicel.selectValueByid(useraddr.getProvince());
		} else if (useraddr.getCity() != null) {
			addrString = areaServicel.selectValueByid(useraddr.getCity());
		}
		datamap.put("address", addrString + useraddr.getAddress());
		datamap.put("addressId", useraddr.getAddressId());
		datamap.put("contactMan", useraddr.getContactMan());
		datamap.put("phone", useraddr.getContactPhone());
		// 增加订单额外费用
		int fengti = 1;
		if (fengeWayId == 18) {
			if (fentiwayId == 43) {
				fengti = 1;
			}
			if (fentiwayId == 44) {
				fengti = 2;
			}
			if (fentiwayId == 45) {
				fengti = 3;
			}
		}
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andRelationIdEqualTo(relationId);
		list = orderDao.selectByExample(example, criteria);
		AppOrderExtFee extfee = orderExtFeeService.selectByorderId(list.get(0).getOrderId());
		if (extfee == null) {
			orderExtFeeService.addOrderExtFee(list.get(0).getOrderId(),
					new BigDecimal(datamap.get("totalMoney").toString()),
					Integer.parseInt(datamap.get("num").toString()),
					new BigDecimal(datamap.get("singleSendMoney").toString()),
					new BigDecimal(datamap.get("singleDivisionMoney").toString()), fengeWayId == 18 ? 1 : 2, fengti,
					new BigDecimal(datamap.get("singlePackageMoney").toString()), guige,
					Integer.parseInt(datamap.get("weight").toString()) / 500,
					Integer.parseInt(datamap.get("packageNum").toString()));
		} else {
			extfee = new AppOrderExtFee();
			extfee.setOrderId(list.get(0).getOrderId());
			extfee.setPayMoney(new BigDecimal(datamap.get("totalMoney").toString()));
			extfee.setNum(Integer.parseInt(datamap.get("num").toString()));
			extfee.setSlaughterFee(new BigDecimal(datamap.get("singleSendMoney").toString()));
			extfee.setDivisionFee(new BigDecimal(datamap.get("singleDivisionMoney").toString()));
			extfee.setDivisionType(Byte.parseByte((fengeWayId == 18 ? 1 : 2) + ""));
			extfee.setDivisionMode(Byte.parseByte(fengti + ""));
			extfee.setPackageFee(new BigDecimal(datamap.get("singlePackageMoney").toString()));
			extfee.setSpec(guige);
			extfee.setWeight(new BigDecimal(datamap.get("weight").toString()).divide(new BigDecimal("500")));
			extfee.setPackageNum(Integer.parseInt(datamap.get("packageNum").toString()));
			orderExtFeeService.updateOrderExtfee(extfee);
		}
		return datamap;
	}

	private Map<String, Object> getFeiyong(long fengeWayId, long fentiwayId, int guige, long userId, long relationId) {
		Map<String, Object> earmap = earningsService.selectInvestOne(userId, relationId);
		// 一个收益表中一个收益的总只数
		int sum = Integer.parseInt(earmap.get("num").toString())
				- Integer.parseInt(earmap.get("presentNum").toString());
		BigDecimal fenfei = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		BigDecimal danwight = new BigDecimal(sysconfigService.queryByCode(SysConstant.PER_WEIGHT));
		BigDecimal tuzaisendfei = new BigDecimal(sysconfigService.queryByCode(SysConstant.SLAUGHTER_EXPRESS_FEE));
		BigDecimal singlePackageMoney = new BigDecimal(0);
		int packageNum = 0;
		if (fengeWayId == 18 && fentiwayId != 0) {
			// 表示的是粗分割
			fenfei = new BigDecimal(sysconfigService.queryByCode(SysConstant.DIVISION_THICK_FEE));
			dataMap.put("fengeWay", "粗分割");
		}
		if (fengeWayId == 19 && guige != 0) {
			// 表示的是细分割
			fenfei = new BigDecimal(sysconfigService.queryByCode(SysConstant.DIVISION_THIN_FEE));
			BigDecimal baozhuangfei = new BigDecimal(sysconfigService.queryByCode(SysConstant.PACKAGE_FEE));
			// 单只包装数
			packageNum = danwight.multiply(BigDecimal.valueOf(500))
					.divide(new BigDecimal(guige + ""), 2, BigDecimal.ROUND_HALF_UP).intValue();
			if (danwight.multiply(BigDecimal.valueOf(500)).intValue() % guige > 0) {
				packageNum++;
			}
			// 单只真空包装费 =单只重量（斤==500g）/包装规格（克）*包装费
			singlePackageMoney = BigDecimal.valueOf(packageNum).multiply(baozhuangfei);
			dataMap.put("fengeWay", "精细分割");
		}
		dataMap.put("num", sum);
		// 总分割费
		dataMap.put("divisionMoney", fenfei.multiply(BigDecimal.valueOf(sum)));
		// 单只分割费
		dataMap.put("singleDivisionMoney", fenfei);
		// 总配送费
		dataMap.put("sendMoney", tuzaisendfei.multiply(BigDecimal.valueOf(sum)));
		// 单只屠宰配送费
		dataMap.put("singleSendMoney", tuzaisendfei);
		// 总包装费
		dataMap.put("packageMoney", singlePackageMoney.multiply(BigDecimal.valueOf(sum)));
		// 单包装费
		dataMap.put("singlePackageMoney", singlePackageMoney);
		// 总费用 分割费+配送费+包装费
		dataMap.put("totalMoney", fenfei.add(tuzaisendfei).add(singlePackageMoney));
		// 单只重量
		dataMap.put("weight", danwight.multiply(BigDecimal.valueOf(500)));
		// 总盒数
		dataMap.put("packageNum", packageNum);
		return dataMap;
	}

	@Override
	public AppOrder selectByorderCode(String orderCode) {
		AppOrderExample example = new AppOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderCodeEqualTo(orderCode);
		return orderDao.selectByExample(example, criteria).get(0);
	}

	@Override
	public Map<String, Object> getOrderAddr(HttpServletRequest request, long userId) {
		AppUserAddress useraddr = userAddressService.selectUserDefault(userId);
		Map<String, Object> datamap = new HashMap<String, Object>();
		String addrString = "";
		if (useraddr.getProvince() != null) {
			addrString = areaServicel.selectValueByid(useraddr.getProvince());
		} else if (useraddr.getCity() != null) {
			addrString = areaServicel.selectValueByid(useraddr.getCity());
		}
		datamap.put("address", addrString + useraddr.getAddress());
		datamap.put("addressId", useraddr.getAddressId());
		datamap.put("contactMan", useraddr.getContactMan());
		datamap.put("phone", useraddr.getContactPhone());
		return datamap;
	}
}
