package com.mobile.blue.launcher.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.FriendDao;
import com.mobile.blue.launcher.model.AppFriend;
import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.launcher.model.Example.AppFriendExample;
import com.mobile.blue.launcher.model.Example.AppFriendExample.Criteria;
import com.mobile.blue.launcher.service.FriendService;
import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.CommConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.SysConstant;
import com.mobile.blue.util.constant.TypeConstant;

@Service("friendService")
public class FriendServiceImpl implements FriendService {
	private List<AppFriend> list = null;
	@Autowired
	private FriendDao friendDao;

	@Autowired
	private UserBasicService userBasicService;
	@Autowired
	private SysconfigService sysconfigService;

	/**
	 * 查询好友列表
	 */
	@Override
	public String selectFriends(HttpServletRequest request,long userId) {
		AppFriendExample freindsExample = new AppFriendExample();
		Criteria criteria = freindsExample.createCriteria();
		Map<String, Object> map = new HashMap<String, Object>();
		String value = sysconfigService.queryByCode(SysConstant.NEW_FREINDS_FILTER_TIME);
		if (value != null) {
			value = DateUtil.format(DateUtil.getBeforeDate(new Date(), Integer.parseInt(value)),
					BasicConstant.DATE_PATTERN);
		} else {
			value = DateUtil.format(DateUtil.getBeforeDate(new Date(), Integer.parseInt("10")),
					BasicConstant.DATE_PATTERN);
		}
		/**
		 * value表示的是多长时间以内，新朋友请求没有处理的消息，value 是时间分割点
		 */
		criteria.andMyUserIdEqualTo(userId);// 哪个用户的好友请求
		criteria.andStatusEqualTo(CommConstant.ADD_FREINDS_0);// 还没有同意的好友列表
		criteria.andSendTimeGreaterThanOrEqualTo(DateUtil.parseDate(value));// 时间分割点
		map.put("newFriendCount", friendDao.countByExample(freindsExample, criteria));
		map.put("newFriend",newFriendRefresh(request, userId,1));
		map.put("oldFriend",lodFriendRefresh(request, userId,1) );// 根据用户的朋友的id查询朋友的详细信息，并返回
		return ResultUtil.getResultJson(map, Status.success.getStatus(), Status.success.getMsg());
	}

	/**
	 * 搜索新朋好友
	 */
	@Override
	public String searchNewFriendS(HttpServletRequest request,long userId, String value,int nextpage) {
		List<Long> searchFriend = new ArrayList<Long>();
		AppFriendExample freindsExample = new AppFriendExample();
		Criteria criteria = freindsExample.createCriteria();
		// 先查询不是我好友的人，不包括给我发送消息了，我可以看到的人
		List<Byte> listvalue = new ArrayList<Byte>();// 是我好友的人和已经给我发送了消息，但我没有处理消息的人
		listvalue.add(CommConstant.ADD_FREINDS_1);
		listvalue.add(CommConstant.ADD_FREINDS_0);
		criteria.andMyUserIdEqualTo(userId);
		criteria.andStatusIn(listvalue);// 表示是我好友的人
		// criteria.andAddTypeEqualTo(TypeConstant.FREINDS_ADD_TYPE_2);//邀请添加的
		list = friendDao.selectFriends(freindsExample, criteria);// 查询到已经是我好友的id
		for (AppFriend friend : list) {// 表示已经是我的好友
			searchFriend.add(friend.getFreindId());
		}
		// 查找还不是我好友的人的信息，返回
		List<AppUser> notfriendlist=userBasicService.searchFriends(request,searchFriend, value,nextpage);
		Map<String, Object> notfriendMap=null;
		List<Map<String, Object>> newfriendMap=new ArrayList<Map<String, Object>>();
		if(notfriendlist!=null && notfriendlist.size()>0){
			for(AppUser user:notfriendlist){
				notfriendMap=new HashMap<String, Object>();
				notfriendMap.put("userId", user.getUserId());
				notfriendMap.put("username", user.getUsername());
				notfriendMap.put("nickname", user.getNickname());
				notfriendMap.put("sex", user.getSex());
				notfriendMap.put("phone", user.getPhone());
				notfriendMap.put("headImg", user.getHeadImg());
				notfriendMap.put("inviteCode", user.getInviteCode());
				notfriendMap.put("qrCode", user.getQrCode());
				newfriendMap.add(notfriendMap);
			}
		}
		return ResultUtil.getResultJson(newfriendMap, Status.success.getStatus(),
				Status.success.getMsg());
	}

	/**
	 * 添加好友,根据是类型保存用户信息
	 */
	@Override
	public int addFriend(Long myUserId, Date SendagreeTime, Long friendId, int type, String message) {
		// 我的列表中添加好友
		AppFriend friend = new AppFriend();
		AppFriend friendAdd = new AppFriend();
		if (type == TypeConstant.FREINDS_ADD_TYPE_2) {
			friend.setAddType(TypeConstant.FREINDS_ADD_TYPE_2);
			friendAdd.setAddType(TypeConstant.FREINDS_ADD_TYPE_2);
			friend.setAgreeTime(SendagreeTime);
			friendAdd.setAgreeTime(SendagreeTime);
			friend.setStatus(CommConstant.ADD_FREINDS_1);
			friendAdd.setStatus(CommConstant.ADD_FREINDS_1);
		}
		if (type == TypeConstant.FREINDS_ADD_TYPE_1) {
			if (userBasicService.selectUserById(friendId) ==null) {
				return 0;
			}
			friend.setAddType(TypeConstant.FREINDS_ADD_TYPE_1);
			friend.setStatus(CommConstant.ADD_FREINDS_2);
			friendAdd.setAddType(TypeConstant.FREINDS_ADD_TYPE_1);
			friendAdd.setStatus(CommConstant.ADD_FREINDS_0);
		}
		friend.setSendRemark(message);
		friendAdd.setSendRemark(message);
		friend.setMyUserId(myUserId);
		friend.setFreindId(friendId);
		friendAdd.setMyUserId(friendId);
		friendAdd.setFreindId(myUserId);
		friend.setSendTime(SendagreeTime);
		friendAdd.setSendTime(SendagreeTime);
		friendDao.insertSelective(friend);
		// 向好友发消息
		return friendDao.insertSelective(friendAdd);
	}

	/**
	 * 删除好友信息
	 */
	@Override
	public String deleteFriend(long userId, long friendId) {
		if (friendDao.deleteFriend(userId, friendId) == 1)
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		else
			return ResultUtil.getResultJson(Status.freindsIdNullity.getStatus(), Status.freindsIdNullity.getMsg());
	}

	@Override
	public String updateFriendStatus(long userId, long friendId, byte status) {
		AppFriend friend = new AppFriend();
		friend.setMyUserId(userId);
		friend.setFreindId(friendId);
		friend.setStatus(status);
		friendDao.updateFriendStatus(friend);
		return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public int selectFriendCount(long friendId, long userid) {
		AppFriendExample freindsExample = new AppFriendExample();
		Criteria criteria = freindsExample.createCriteria();
		criteria.andFreindIdEqualTo(friendId);
		criteria.andMyUserIdEqualTo(userid);
		return friendDao.countByExample(freindsExample, criteria);
	}
	/**
	 * 表示新朋友，表示还没有同意的好友列表
	 */
	@Override
	public List<Map<String, Object>> newFriendRefresh(HttpServletRequest request, long userId, int nextPage) {
		List<Long> friendListNew = new ArrayList<Long>();
		AppFriendExample freindsExample = new AppFriendExample();
		Criteria criteria = freindsExample.createCriteria();
		String value = sysconfigService.queryByCode(SysConstant.NEW_FREINDS_FILTER_TIME);
		if (value != null) {
			value = DateUtil.format(DateUtil.getBeforeDate(new Date(), Integer.parseInt(value)),
					BasicConstant.DATE_PATTERN);
		} else {
			value = DateUtil.format(DateUtil.getBeforeDate(new Date(), Integer.parseInt("10")),
					BasicConstant.DATE_PATTERN);
		}
		/**
		 * value表示的是多长时间以内，新朋友请求没有处理的消息，value 是时间分割点
		 */
		criteria.andMyUserIdEqualTo(userId);// 哪个用户的好友请求
		criteria.andStatusEqualTo(CommConstant.ADD_FREINDS_0);// 还没有同意的好友列表
		criteria.andSendTimeGreaterThanOrEqualTo(DateUtil.parseDate(value));// 时间分割点
		list = friendDao.selectFriends(freindsExample, criteria);// 表示查询新朋友列表
		for (AppFriend friend : list) {
			friendListNew.add(friend.getFreindId());
		}
		List<Map<String, Object>> returnnewfriend=new ArrayList<Map<String, Object>>();
		List<AppUser> NewfriendList=userBasicService.selectById(request,friendListNew,nextPage,false);
		Map<String, Object> newfriendMap=null;
		if(NewfriendList!=null && NewfriendList.size()>0){
			for(AppUser user:NewfriendList){
				newfriendMap=new HashMap<String, Object>();
				newfriendMap.put("userId", user.getUserId());
				newfriendMap.put("username", user.getUsername());
				newfriendMap.put("nickname", user.getNickname());
				newfriendMap.put("sex", user.getSex());
				newfriendMap.put("phone", user.getPhone());
				newfriendMap.put("headImg", user.getHeadImg());
				newfriendMap.put("inviteCode", user.getInviteCode());
				newfriendMap.put("qrCode", user.getQrCode());
				returnnewfriend.add(newfriendMap);
			}
		}
		return returnnewfriend;
	}
	/**
	 * 表示老朋友，已经同意为好友的好友列表
	 */
	@Override
	public List<Map<String, Object>> lodFriendRefresh(HttpServletRequest request, long userId, int nextPage) {
		List<Long> friendList = new ArrayList<Long>();
		AppFriendExample freindsExample = new AppFriendExample();
		Criteria criteria = freindsExample.createCriteria();
		criteria.andMyUserIdEqualTo(userId);// 表示哪个人
		criteria.andStatusEqualTo(CommConstant.ADD_FREINDS_1);// 表示已经同意的好友
		list = friendDao.selectFriends(freindsExample, criteria);// 查询的是已经是我好友的人
		for (AppFriend friend : list) {
			friendList.add(friend.getFreindId());
		}
		List<AppUser> oldFriendlist=userBasicService.selectById(request,friendList,nextPage,true);
		List<Map<String, Object>> returnoldfriend=new ArrayList<Map<String, Object>>();
		Map<String, Object> oldfriendMap=null;
		if(oldFriendlist!=null && oldFriendlist.size()>0){
			for(AppUser user:oldFriendlist){
				oldfriendMap=new HashMap<String, Object>();
				oldfriendMap.put("userId", user.getUserId());
				oldfriendMap.put("username", user.getUsername());
				oldfriendMap.put("nickname", user.getNickname());
				oldfriendMap.put("sex", user.getSex());
				oldfriendMap.put("phone", user.getPhone());
				oldfriendMap.put("headImg", user.getHeadImg());
				oldfriendMap.put("inviteCode", user.getInviteCode());
				oldfriendMap.put("qrCode", user.getQrCode());
				returnoldfriend.add(oldfriendMap);
			}
		}
		return returnoldfriend;
	}
}
