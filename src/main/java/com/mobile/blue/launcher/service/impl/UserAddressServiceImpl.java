package com.mobile.blue.launcher.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.UseraddressDao;
import com.mobile.blue.launcher.model.AppUserAddress;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample;
import com.mobile.blue.launcher.model.Example.AppUserAddressExample.Criteria;
import com.mobile.blue.launcher.service.AreaService;
import com.mobile.blue.launcher.service.UserAddressService;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
	private List<AppUserAddress> list = null;
	@Autowired
	private UseraddressDao useraddressDao;
	@Autowired
	private AreaService areaService;

	// 查询用户的所有的收货地址信息
	@Override
	public List<AppUserAddress> selectUserAllAdress(HttpServletRequest request,int nextPage,long userId) throws Exception {
		AppUserAddressExample userAddressExample = new AppUserAddressExample();
		Criteria criteria = userAddressExample.createCriteria();
		// 查询所有的用户收货地址
		PageParameter page=(PageParameter) request.getSession().getAttribute("shouhuodizhi");
		if(page==null){
			page = new PageParameter(0,BasicConstant.limit_page_size);
			criteria.andUserIdEqualTo(userId);
			int count=useraddressDao.countByExample(userAddressExample, criteria);
			page.setCount(count);
		}else{
			if(nextPage>page.getTotal()){
				return null;
			}
			page.setCurrent(nextPage);
		}
		criteria.andUserIdEqualTo(userId);
		userAddressExample.setPage(page);
		list = useraddressDao.selectByExample(userAddressExample, criteria);// 查询用户的所有信息
		if (list.size() <= 0) {
		}
		request.getSession().setAttribute("shouhuodizhi", page);
		for (AppUserAddress userAddress : list) {
			userAddress.setAddress(
					areaService.selectQuanAddressList(userAddress.getCity() == null ? 0 : userAddress.getCity(),
							userAddress.getProvince() == null ? 0 : userAddress.getProvince())
					+ userAddress.getAddress());
		}
		return list;
	}

	/**
	 * 更新对一个收货地址信息的修改
	 */
	@Override
	public String updateUserAddress(AppUserAddress address) {
		AppUserAddressExample userAddressExample = new AppUserAddressExample();
		Criteria criteria = userAddressExample.createCriteria();
		if (address.getIsDefault() != 0) {
			// 表示修改用户的默认地址
			if (useraddressDao.updateUserAddress(address) == 1) {
				List<Long> addressIdList = new ArrayList<Long>();
				addressIdList.add(address.getAddressId());
				criteria.andAddressIdNotIn(addressIdList);
				criteria.andUserIdEqualTo(address.getUserId());
				list = useraddressDao.selectByExample(userAddressExample, criteria);
				for (AppUserAddress addr : list) {
					addr.setIsDefault(new Integer(0).byteValue());
					useraddressDao.updateUserAddress(addr);
				}
				return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
			}
		} else if (useraddressDao.updateUserAddress(address) == 1)
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
	}

	// 省份列表
	@Override
	public String selectProvinceList() {
		return ResultUtil.getResultJson(areaService.selectProvinceList(), Status.success.getStatus(),
				Status.success.getMsg());
	}

	// 省对应城市的列表
	@Override
	public String selectCityInProvince(long provinceCode) {
		return ResultUtil.getResultJson(areaService.selectCityInProvince(provinceCode), Status.success.getStatus(),
				Status.success.getMsg());
	}

	// 增加用户的收货地址
	@Override
	public String addUserAddress(AppUserAddress userId) {
		if (useraddressDao.insertSelective(userId) == 1)
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
	}

	@Override
	public String deleteUserAddress(long addressId) {
		if (useraddressDao.deleteUserAddress(addressId) == 1)
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
	}

	@Override
	public AppUserAddress selectUserDefault(long userId) {
		AppUserAddressExample userAddressExample = new AppUserAddressExample();
		Criteria criteria = userAddressExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andIsDefaultEqualTo(Byte.parseByte("1"));
		list=useraddressDao.selectByExample(userAddressExample, criteria);
		if(list==null || list.size()<=0){
			criteria.andUserIdEqualTo(userId);
			list=useraddressDao.selectByExample(userAddressExample, criteria);
		}
		return list.get(0);
	}

	@Override
	public AppUserAddress selectUserAddressById(long addressId) {
		AppUserAddressExample userAddressExample = new AppUserAddressExample();
		Criteria criteria = userAddressExample.createCriteria();
		criteria.andAddressIdEqualTo(addressId);
		list=useraddressDao.selectByExample(userAddressExample, criteria);
		if(list==null || list.size()<=0){
			return null;
		}
		return list.get(0);
	}
}
