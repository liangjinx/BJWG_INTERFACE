package com.mobile.blue.launcher.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mobile.blue.launcher.dao.UserDao;
import com.mobile.blue.launcher.model.AppBankPersonInfo;
import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.launcher.model.Example.AppUserExample;
import com.mobile.blue.launcher.model.Example.AppUserExample.Criteria;
import com.mobile.blue.launcher.service.BankCardService;
import com.mobile.blue.launcher.service.BankPersonInfoService;
import com.mobile.blue.launcher.service.EarningsService;
import com.mobile.blue.launcher.service.FriendService;
import com.mobile.blue.launcher.service.MessageService;
import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.launcher.service.UserBasicService;
import com.mobile.blue.launcher.service.UserExtService;
import com.mobile.blue.launcher.service.WalletService;
import com.mobile.blue.util.CompressPic;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.HttpSender;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.RequestUtil;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.CommConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.util.constant.SysConstant;
import com.mobile.blue.util.constant.TypeConstant;
import com.mobile.blue.util.constant.VerifyCodeConstant;
import com.mobile.blue.util.util.IpConvert;
import com.mobile.blue.util.util.RandomUtils;
import com.mobile.blue.util.util.Verification;
import com.mobile.blue.view.RequestUserVO;

@Service("userBasicService")
public class UserBasicServiceImpl implements UserBasicService {
	private List<AppUser> list = null;
	private static Log logger = LogFactory.getLog(UserBasicServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Autowired
	private SysconfigService sysconfigService;

	@Autowired
	private FriendService friendService;

	@Autowired
	private UserExtService userExtService;

	@Autowired
	private WalletService walletService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private BankCardService bankCardService;

	@Autowired
	private BankPersonInfoService bankPersonInfoService;
	@Autowired
	private EarningsService earningsService;

	/**
	 * 发送验证码
	 */
	@Override
	public String sendVerification(HttpServletRequest request, String phone, int type) throws Exception {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		if (type == VerifyCodeConstant.VERIFY_CODE_REGISTER) {
			criteria.andPhoneEqualTo(phone);
			int count = userDao.countByExample(userExample, criteria);
			if (count == 1) {
				return ResultUtil.getResultJson(Status.userExistedNullity.getStatus(),
						Status.userExistedNullity.getMsg());
			}
		}

		// 注册发送验证码的时候，该用户是第一次，则表示可以注册，否则不可以注册
		/**
		 * 用标识符表示注册，用手机号码保存发送给用户的验证码,验证是否发送过验证码，如果有发送验证码，则直接返回，没有则生成验证码发送到手机
		 */
		int Verif_code = Integer.parseInt(RandomUtils.getNum(BasicConstant.VERIF_CODE_LENGTH));// 生成验证码
		String meg = "[润明八戒王国]尊敬的用户，欢迎注册八戒王国oneline平台，注册验证码为" + Verif_code + ",此验证码" + BasicConstant.VERIF_CODE_time
				+ "分钟内有效，本短信免费。";
		try {
			HttpSender.batchSend(BasicConstant.SEND_NOTE_URL, BasicConstant.SEND_NOTE_ACCOUNT,
					BasicConstant.SEND_NOTE_PSWD, phone, meg, true, null, null);
		} catch (Exception e) {
			return ResultUtil.getResultJson(Status.verifyCodeSendFail.getStatus(), Status.verifyCodeSendFail.getMsg());
		} // 发送消息
		logger.info("request.getsession" + request.getSession().getId());
		request.getSession().setAttribute(phone, Verif_code);
		request.getSession().setMaxInactiveInterval(BasicConstant.VERIF_CODE_time * 60);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(BasicConstant.PHONE, phone);
		map.put(BasicConstant.BACK_VERIFY_CODE, Verif_code);
		map.put(BasicConstant.CREATE_TIME, System.currentTimeMillis());
		return ResultUtil.getResultJson(map, Status.success.getStatus(), Status.success.getMsg());
	}

	/**
	 * 保存用户信息到服务器
	 */

	@Override
	public String register(String phone, String password, String invite_code, HttpServletRequest request)
			throws Exception {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		// 验证用户名和密码是不是唯一的
		if (Verification.isPhone(phone)) {
			criteria.andUsernameEqualTo(phone);
		}
		criteria.andPasswordEqualTo(password);
		int isSole = userDao.countByExample(userExample, criteria);
		if (!(isSole == 0)) {
			return ResultUtil.getResultJson(Status.userExistedNullity.getStatus(), Status.userExistedNullity.getMsg());
		}
		// 有没有邀请码都会执行的代码
		int flag = 0;
		AppUser user = saveUserInfo(phone, password, request,
				request.getSession().getAttribute(BasicConstant.IS_TEST_COUNTO_USER));
		flag = userDao.saveUser(user);
		criteria.andPhoneEqualTo(phone);
		list = userDao.selectByExample(userExample, criteria);// 得到该用户的userid
		user = list.get(0);
		if (!"".equals(invite_code)) {
			String addFriendRetrun = "";
			if ((addFriendRetrun = RegisterAddFriend(invite_code, user)) != "false")
				return addFriendRetrun;
		}
		// 设置用户的预抢默认设置
		flag = userExtService.insertUserExt(user.getUserId());
		if (flag == 1) {
			flag = walletService.addWallet(user.getUserId());
		}
		if (flag == 1) {
			// 所有都执行成功的时候的返回值
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(BasicConstant.PHONE, phone);
			map.put(BasicConstant.USER_ID, user.getUserId());
			request.getSession().removeAttribute(phone);
			return ResultUtil.getResultJson(map, Status.success.getStatus(), Status.success.getMsg());
		} else {
			return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
		}

	}

	// 注册的时候添加好友
	private String RegisterAddFriend(String invite_code, AppUser user) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		if (invite_code != null) {// 表示有邀请码
			// 查询该邀请码的用户，并添加该用户为邀请码的朋友,查询邀请码是否正确
			criteria.andInviteCodeEqualTo(invite_code);
			list = userDao.selectByExample(userExample, criteria);
			if (list == null) {
				return ResultUtil.getResultJson(Status.inviteCodeNullity.getStatus(),
						Status.inviteCodeNullity.getMsg());
			}
			// 将其添加为好友
			friendService.addFriend(user.getUserId(), user.getRegisterTime(), list.get(0).getUserId(),
					TypeConstant.FREINDS_ADD_TYPE_2, "");
		}
		return "false";
	}

	// 设置用户的信息，在注册的时候，保存基本信息
	private AppUser saveUserInfo(String phone, String password, HttpServletRequest request, Object systemConfig) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		AppUser user = new AppUser();
		user.setSex((byte) 1);
		user.setUsername(phone);
		user.setPhone(phone);
		user.setHeadImg(sysconfigService.queryByCode(SysConstant.DEFAULT_HEADIMG));// 查询用户默认的图像
		user.setNickname(phone.substring(0, 3) + "*****" + phone.substring(8));
		user.setPassword(password);
		user.setRegisterIp(Long.parseLong(IpConvert.StringToBigInt(RequestUtil.getIpAddr(request)).toString()));
		user.setRegisterTime(new Date());
		user.setStatus((byte) 1);
		int count = 0;
		String inviteCode = "";
		do {
			inviteCode = CommConstant.INVITECODE_PREFIX + RandomUtils
					.getNumAndWord(BasicConstant.VERIFICTION_length - CommConstant.INVITECODE_PREFIX.length());
			criteria.andInviteCodeEqualTo(inviteCode);
			count = userDao.countByExample(userExample, criteria);
		} while (count != 0);
		user.setInviteCode(inviteCode);
		// 设置二维码的保存地址和访问信息，有问题，待修复
		user.setQrCode(sysconfigService.getUrl(systemConfig, user.getInviteCode()));
		return user;
	}

	/**
	 * 用户登录
	 */
	@Override
	public String userLogin(HttpServletRequest request, String username, String password) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		// 手机号和用户名登录
		if (Verification.isPhone(username))
			criteria.andPhoneEqualTo(username);
		else
			criteria.andUsernameEqualTo(username);

		criteria.andPasswordEqualTo(password);
		list = userDao.selectByExample(userExample, criteria);
		if (list.size() > 0) {// 表示登录成功
			AppUser user = new AppUser();
			user.setLastLoginIp(Long.parseLong(IpConvert.StringToBigInt(RequestUtil.getIpAddr(request)).toString()));
			user.setLastLoginTime(DateUtil.getCurrentDate());
			userDao.updateUserByUserIdOrPhone(user);
			Map<String, Object> returnmap = new HashMap<String, Object>();
			returnmap.put("userId", list.get(0).getUserId());
			returnmap.put("username", list.get(0).getUsername());
			returnmap.put("nickname", list.get(0).getNickname());
			returnmap.put("password", list.get(0).getPassword());
			returnmap.put("sex", list.get(0).getSex());
			returnmap.put("phone", list.get(0).getPhone());
			returnmap.put("headImg", list.get(0).getHeadImg());
			returnmap.put("inviteCode", list.get(0).getInviteCode());
			returnmap.put("qrCode", list.get(0).getQrCode());
			return ResultUtil.getResultJson(returnmap, Status.success.getStatus(), Status.success.getMsg());
		} else
			return ResultUtil.getResultJson(Status.usernameorPasswordIncorrect.getStatus(),
					Status.usernameorPasswordIncorrect.getMsg());
	}

	/**
	 * 修改用户的信息，不包括图像， 当有手机号码的时候，用手机号码进行判断，没有手机号码的时候，用用户id判断，都没有的时候，则返回错误信息
	 */
	@Override
	public String updateUser(RequestUserVO requestUser) {
		if (requestUser == null) {
			return ResultUtil.getResultJson(Status.userExistedNullity.getStatus(), Status.userExistedNullity.getMsg());
		}
		// 手机号码和用户id都没有，不能修改用户信息
		if (requestUser.getUserId() == null && requestUser.getPhone() == null) {
			return ResultUtil.getResultJson(Status.missParam.getStatus(), Status.missParam.getMsg());
		}
		AppUser user = SetUser(requestUser);
		if (userDao.updateUserByUserIdOrPhone(user) >= 1)
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		return ResultUtil.getResultJson(Status.serverError.getStatus(), Status.serverError.getMsg());
	}

	// 查询朋友信息
	@Override
	public List<AppUser> selectById(HttpServletRequest request, List<Long> freindId, int nextpage,
			boolean isoldfriend) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		if (freindId.size() <= 0)
			return null;
		PageParameter page = (PageParameter) request.getSession()
				.getAttribute(isoldfriend + "friend" + freindId.size());
		if (page == null) {
			page = new PageParameter(0, BasicConstant.limit_page_size);
			criteria.andUserIdIn(freindId);
			int count = userDao.countByExample(userExample, criteria);
			page.setCount(count);
		} else {
			if (nextpage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextpage);
		}
		criteria.andUserIdIn(freindId);
		userExample.setPage(page);
		list = userDao.selectByExample(userExample, criteria);
		request.getSession().setAttribute(isoldfriend + "friend" + freindId.size(), page);
		return list;
	}

	// 搜索不是好友的朋友列表,是模糊查询
	@Override
	public List<AppUser> searchFriends(HttpServletRequest request, List<Long> list, String serachValue, int nextpage) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();

		PageParameter page = (PageParameter) request.getSession().getAttribute("searchFriends" + serachValue);
		if (page == null) {
			page = new PageParameter(0, BasicConstant.limit_page_size);
			userExample.setDistinct(true);
			if (list.size() <= 0) {
			} else {
				criteria.andUserIdNotIn(list);
			}
			String serachString1 = "%" + serachValue + "%";
			if (Verification.isPhone(serachValue)) {
				logger.info("查询的手机号码是" + serachValue);
				criteria.andPhoneLike(serachString1);
			} else {
				// criteria.andNicknameLike(serachValue);
				criteria.andUsernameLike(serachString1);
				logger.info("查询的用户名或昵称是" + serachValue);
			}
			int count = userDao.countByExample(userExample, criteria);
			page.setCount(count);
		} else {
			if (nextpage > page.getTotal()) {
				return null;
			}
			page.setCurrent(nextpage);
		}
		userExample.setDistinct(true);
		if (list.size() <= 0) {
		} else {
			criteria.andUserIdNotIn(list);
		}
		String serachString1 = "%" + serachValue + "%";
		if (Verification.isPhone(serachValue)) {
			logger.info("查询的手机号码是" + serachValue);
			criteria.andPhoneLike(serachString1);
		} else {
			// criteria.andNicknameLike(serachValue);
			criteria.andUsernameLike(serachString1);
			logger.info("查询的用户名或昵称是" + serachValue);
		}
		logger.info("page:" + page.toString());
		userExample.setPage(page);
		List<AppUser> listUser = userDao.selectByExample(userExample, criteria);
		request.getSession().setAttribute("searchFriends" + serachValue, page);
		return listUser;
	}

	// 保存用户的基本信息，一般修改用户息息的时候使用
	private AppUser SetUser(RequestUserVO requestUser) {
		AppUser user = new AppUser();
		user.setPassword(requestUser.getPassword());
		user.setUserId(requestUser.getUserId());
		user.setUsername(requestUser.getUsername());
		user.setNickname(requestUser.getNickname());
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		user.setSex(requestUser.getSex());
		user.setCity(requestUser.getCity());
		user.setCountry(requestUser.getCountry());
		user.setProvince(requestUser.getProvince());
		user.setPhone(requestUser.getPhone());
		return user;
	}

	@Override
	public String selectcountAll(long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("money", walletService.walletMoney(userId));
		map.put("messageCount", messageService.messageCount(userId));
		map.put("countCard", bankCardService.countCard(userId));
		map.put("pigCount", earningsService.selectPigcount(userId));
		map.put("myEarnings", earningsService.selectEarnings(userId));
		return ResultUtil.getResultJson(map, Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public String VerifyPassword(byte type, long userId, String oldpassword) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		if (type == 1) {
			logger.info("oldpassword" + oldpassword);
			criteria.andUserIdEqualTo(userId);
			criteria.andPasswordEqualTo(oldpassword);
			if (userDao.countByExample(userExample, criteria) > 0)
				return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
			return ResultUtil.getResultJson(Status.passwordInvalid.getStatus(), Status.passwordInvalid.getMsg());
		}
		if (walletService.VerifyPassword(userId, oldpassword, type) > 0) {
			return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.passwordInvalid.getStatus(), Status.passwordInvalid.getMsg());
	}

	@Override
	public String selecePersonInfo(long userId) {
		List<AppBankPersonInfo> personinfoList = bankPersonInfoService.selectByUserId(userId);
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap = null;
		if (personinfoList != null && personinfoList.size() > 0) {
			for (AppBankPersonInfo bankPerson : personinfoList) {
				returnmap = new HashMap<String, Object>();
				returnmap.put("personId", bankPerson.getPersonId());
				returnmap.put("name", bankPerson.getName());
				returnmap.put("idCard", bankPerson.getIdCard());
				returnmap.put("ctime", bankPerson.getCtime() == null ? null : bankPerson.getCtime().getTime());
				returnmap.put("userId", bankPerson.getUserId());
				returnlist.add(returnmap);
			}
		}
		return ResultUtil.getResultJson(returnlist, Status.success.getStatus(), Status.success.getMsg());
	}

	/**
	 * 上传图像
	 */
	@Override
	public String loadImg(MultipartFile file, HttpServletRequest request) throws Exception {
		String filetype = sysconfigService.queryByCode(SysConstant.UPLOAD_FILE_LIMIT_TYPE);
		String[] types = filetype.split(",");
		boolean falg = false;
		String fileTypes = null;
		for (int i = 0; i < types.length; i++) {
			fileTypes = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1,
					file.getOriginalFilename().length());
			if (fileTypes.contains(types[i])) {
				falg = true;
				break;
			}
		}
		if (!falg) {
			return ResultUtil.getResultJson(Status.fileOnlySuffix.getStatus(), Status.fileOnlySuffix.getMsg());
		}
		AppUser user = new AppUser();
		user.setUserId(Long.parseLong(request.getHeader("userId")));

		String fileAccessPath = "/" + DateUtil.getCurrentDateStr(BasicConstant.DATE_PATH_FILE) + "//headImgFile/";
		String uploadPath = sysconfigService.queryByCode(SysConstant.PROJECT_IMG_UPLOAD_ROOT_PATH) + fileAccessPath;
		// fileAccessPath =
		// sysconfigService.queryByCode(SysConstant.PROJECT_IMG_ACCESS_URL) +
		// fileAccessPath;
		fileAccessPath = "http://120.25.102.41:8181/resources/" + fileAccessPath;
		String newFileName = System.currentTimeMillis() + "." + fileTypes;
		logger.info("uploadPath:" + uploadPath + ",newFileName:" + newFileName);
		logger.info("fileAccessPath:" + fileAccessPath + ",newFileName:" + newFileName);
		//保存图片，对图片进行处理
		CompressPic com = new CompressPic();
	    CommonsMultipartFile cf= (CommonsMultipartFile)file; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		com.compressPic(fi.getStoreLocation(), uploadPath, newFileName, 120, 120, false);
		//保存图片，对图片进行处理 end
		user.setHeadImg(fileAccessPath + newFileName);
		Map<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put("url", user.getHeadImg());
		returnmap.put("userId", user.getUserId());
		if (userDao.updateUserByUserIdOrPhone(user) >= 1)
			return ResultUtil.getResultJson(returnmap, Status.success.getStatus(), Status.success.getMsg());
		return ResultUtil.getResultJson(Status.headimgNullity.getStatus(), Status.headimgNullity.getMsg());
	}

	@Override
	public AppUser selectUserById(Long userId) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		list = userDao.selectByExample(userExample, criteria);
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public int SelectByPhone(String string) {
		AppUserExample userExample = new AppUserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(string);
		return userDao.countByExample(userExample, criteria);
	}

}
