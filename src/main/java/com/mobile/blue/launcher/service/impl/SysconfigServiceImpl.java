package com.mobile.blue.launcher.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.SysconfigDao;
import com.mobile.blue.launcher.model.AppSysConfig;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample;
import com.mobile.blue.launcher.model.Example.AppSysConfigExample.Criteria;
import com.mobile.blue.launcher.service.SysconfigService;
import com.mobile.blue.util.DateUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.SysConstant;
import com.mobile.blue.util.util.FileUtils;

@Service("sysconfigService")
public class SysconfigServiceImpl implements SysconfigService {
	@Autowired
	private SysconfigDao sysconfigDao;
	private List<AppSysConfig> list = null;
	@Override
	public String queryByCode(String code) {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		criteria.andCodeEqualTo(code);
		list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		if (list != null)
			return list.get(0).getValue();
		return null;
	}

	@Override
	public String getUrl(Object systemConfig, String invitecode) {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		List<String> codeList = Arrays.asList(SysConstant.PROJECT_IMG_ACCESS_URL,
				SysConstant.PROJECT_IMG_UPLOAD_ROOT_PATH, SysConstant.QR_CODE_URL, SysConstant.PROJECT_ACCESS_URL);
		criteria.andCodeIn(codeList);
		List<AppSysConfig> list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		String url = null, projectUrl = null, imgpath = null, accessUrl = null;
		for (AppSysConfig syscon : list) {
			if (SysConstant.PROJECT_IMG_ACCESS_URL.equals(syscon.getCode())) {
				url = syscon.getValue();// 图片项目的访问地址
			} else if (SysConstant.QR_CODE_URL.equals(syscon.getCode())) {
				accessUrl = syscon.getValue();// 用户邀请码二维码访问地址
			} else if (SysConstant.PROJECT_ACCESS_URL.equals(syscon.getCode())) {
				projectUrl = syscon.getValue();// 项目访问地址
			} else if (SysConstant.PROJECT_IMG_UPLOAD_ROOT_PATH.equals(syscon.getCode())) {
				imgpath = syscon.getValue();// 图片存储的根路径
			}
		}
		String filePath = File.separatorChar + DateUtil.getCurrentDateStr(BasicConstant.DATE_PATH_FILE)
				+ File.separatorChar;
		String imgName = "qr_" + System.currentTimeMillis() + ".jpg";
		FileUtils.createQRCodeFile(projectUrl + accessUrl + invitecode, imgpath + filePath, imgName, "jpg");
		if ("yes".equals(systemConfig)) {
			url = url + "resources";
		}
		return url + filePath + imgName;

	}

	@Override
	public String selectStatus(String ParentName, int day) {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		criteria.andParentCodeEqualTo(ParentName);
		list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		String name = "";
		for (AppSysConfig config : list) {
			String[] days = config.getValue().split("~");
			if (day >= Integer.parseInt(days[0])) {
				if (day <= Integer.parseInt(days[1])) {
					name = config.getName();
					break;
				}
			}
		}
		return name;
	}

	@Override
	public List<Map<String, Object>> selectDivisionWay() {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		List<String> configList = new ArrayList<String>();
		configList.add(SysConstant.DIVISION_THICK_FEE);
		configList.add(SysConstant.DIVISION_THIN_FEE);
		configList.add(SysConstant.PACKAGE_FEE);
		criteria.andCodeIn(configList);
		List<AppSysConfig> list=sysconfigDao.selectByExample(sysConfigExample, criteria);
		List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap=null;
		if(list!=null && list.size()>0){
			for(AppSysConfig config:list){
				returnmap=new HashMap<String, Object>();
				returnmap.put("id",config.getId()); 
				returnmap.put("name", config.getName());
				returnmap.put("value", config.getValue());
				returnmap.put("remark", config.getRemark());
				returnlist.add(returnmap);
			}
		}
		return returnlist;
	}

	// 得到支付宝支付参数
	@Override
	public Map<String, Object> queryList() {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		List<String> configList = new ArrayList<String>();
		configList.add(SysConstant.ALIPAY_PARTNER);
		configList.add(SysConstant.ALIPAY_PARTNER_KEY);
		configList.add(SysConstant.ALIPAY_SELLER);
		criteria.andCodeIn(configList);
		list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		Map<String, Object> returnmap = new HashMap<String, Object>();
		for (AppSysConfig sysConfig : list) {
			if (SysConstant.ALIPAY_PARTNER.equals(sysConfig.getCode())) {
				returnmap.put("partner", sysConfig.getValue());
			} else if (SysConstant.ALIPAY_SELLER.equals(sysConfig.getCode())) {
				returnmap.put("seller_email", sysConfig.getValue());
			} else {
				returnmap.put("signkey", sysConfig.getValue());
			}
		}
		returnmap.put("notify_url", "http://pctest.bajiewg.com:9999/notify");
		returnmap.put("sign_type", "RSA");
		returnmap.put("input_charset", "utf-8");
		return returnmap;
	}

	@Override
	public String returnWayExplain(byte returTtype) {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		String code = "";
		switch (returTtype) {
		case 1:
			code = SysConstant.REPAY_TYPE_1;
			break;
		case 2:
			code = SysConstant.REPAY_TYPE_2;
			break;
		case 3:
			code = SysConstant.REPAY_TYPE_3;
			break;
		default:
			code = SysConstant.REPAY_TYPE_4;
			break;
		}
		criteria.andCodeEqualTo(code);
		list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		if (list.size() <= 0) {
			return null;
		}
		return list.get(0).getRemark();
	}

	@Override
	public String expensesList() {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		criteria.andCodeEqualTo(SysConstant.FEE_DETAIL_DESCRIPTION);
		list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		return list.get(0).getRemark();
	}

	// 得到微信支付的参数
	@Override
	public Map<String, Object> queryWxAppidAndAppKey() {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		List<String> configList = new ArrayList<String>();
		configList.add(SysConstant.WX_APP_ID);
		configList.add(SysConstant.WX_APP_SECRET);
		configList.add(SysConstant.WX_APP_PARTNER_KEY);
		configList.add(SysConstant.WX_APP_PARTNER);
		criteria.andCodeIn(configList);
		list = sysconfigDao.selectByExample(sysConfigExample, criteria);
		Map<String, Object> returnmap = new HashMap<String, Object>();
		for (AppSysConfig sysConfig : list) {
			if (SysConstant.WX_APP_ID.equals(sysConfig.getCode())) {
				returnmap.put("appId", sysConfig.getValue());
			} else if (SysConstant.WX_APP_PARTNER_KEY.equals(sysConfig.getCode())) {
				returnmap.put("appPartnerKey", sysConfig.getValue());
			} else if (SysConstant.WX_APP_PARTNER.equals(sysConfig.getCode())) {
				returnmap.put("mch_id", sysConfig.getValue());
			} else {
				returnmap.put("appSecret", sysConfig.getValue());
			}
		}
		returnmap.put("notify_url", "/getWXPayValue");
		// returnmap.put("sign_type", "MD5");
		returnmap.put("input_charset", "utf-8");
		return returnmap;
	}

	@Override
	public List<Map<String, Object>> selectByCode(String packageSpecs) {
		AppSysConfigExample sysConfigExample = new AppSysConfigExample();
		Criteria criteria = sysConfigExample.createCriteria();
		List<String> configList = new ArrayList<String>();
		configList.add(packageSpecs);
		criteria.andCodeIn(configList);
		List<AppSysConfig> list=sysconfigDao.selectByExample(sysConfigExample, criteria);
		List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
		Map<String, Object> returnmap=null;
		if(list!=null && list.size()>0){
			for(AppSysConfig config:list){
				returnmap=new HashMap<String, Object>();
				returnmap.put("id",config.getId()); 
				returnmap.put("name", config.getName());
				returnmap.put("value", config.getValue());
				returnmap.put("remark", config.getRemark());
				returnlist.add(returnmap);
			}
		}
		return returnlist;
	}
}
