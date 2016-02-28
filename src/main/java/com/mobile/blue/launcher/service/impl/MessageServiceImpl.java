package com.mobile.blue.launcher.service.impl;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mobile.blue.launcher.dao.MessageDao;
import com.mobile.blue.launcher.model.AppBulletin;
import com.mobile.blue.launcher.model.AppMessage;
import com.mobile.blue.launcher.model.Example.AppMessageExample;
import com.mobile.blue.launcher.model.Example.AppMessageExample.Criteria;
import com.mobile.blue.launcher.service.BulletinService;
import com.mobile.blue.launcher.service.MessageService;
import com.mobile.blue.launcher.videoAPI.MySecureProtocolSocketFactory;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	List<AppMessage> list = null;
	private Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private BulletinService bulletinService;

	@Override
	public List<Map<String, Object>> messageList(long userId, byte type,HttpServletRequest request, int nextPage) {
		AppMessageExample example = new AppMessageExample();
		Criteria criteria = example.createCriteria();
		if (type == 1) {
			PageParameter page=(PageParameter) request.getSession().getAttribute("message");
			if(page==null){
				page = new PageParameter(0,BasicConstant.limit_page_size);
				criteria.andUserIdEqualTo(userId);
				example.setOrderByClause("ctime desc");
				int count=messageDao.countByExample(example, criteria);
				page.setCount(count);
			}else{
				if(nextPage>page.getTotal()){
					return null;
				}
				page.setCurrent(nextPage);
			}
			example.setOrderByClause("ctime desc");
			criteria.andUserIdEqualTo(userId);
			example.setPage(page);
			list = messageDao.selectByExample(example, criteria);
			List<Map<String, Object>> returnlist=new ArrayList<Map<String, Object>>();
			if(list!=null && list.size()>0){
				request.getSession().setAttribute("message", page);
				Map<String, Object> returnmap=null;
				for(AppMessage message:list){
					returnmap=new HashMap<String, Object>();
					returnmap.put("messageId",message.getMessageId());
					returnmap.put("userId",message.getUserId());
					returnmap.put("ctime",message.getCtime()==null?null:message.getCtime().getTime());
					returnmap.put("content",message.getContent());
					returnmap.put("messageType",message.getMessageType());
					returnmap.put("relationId",message.getRelationId());
					returnmap.put("relationType",message.getRelationType());
					returnmap.put("status",message.getStatus());
					returnlist.add(returnmap);
				}
			}
			return returnlist;
		} else {
			List<AppBulletin> bulletList=bulletinService.selectbullet();
			List<Map<String, Object>> returnlistbullet=new ArrayList<Map<String, Object>>();
			Map<String, Object> returnmap=null;
			if(bulletList!=null && bulletList.size()>0){
				returnmap=new HashMap<String, Object>();
				for(AppBulletin bullet:bulletList){
					returnmap=new HashMap<String, Object>();
					returnmap.put("bulletinId",bullet.getBulletinId());
					returnmap.put("title",bullet.getTitle());
					returnmap.put("content",bullet.getContent());
					returnmap.put("ctime",bullet.getCtime()==null?null:bullet.getCtime().getTime());
					returnmap.put("type",bullet.getType());
					returnmap.put("status",bullet.getStatus());
					returnlistbullet.add(returnmap);
				}
			}
			return returnlistbullet;
		}

	}

	/**
	 * 输出所有消息的个数，包括钱包钱，猪仔个数，收益，消息个数
	 */
	@Override
	public int messageCount(long userId) {
		AppMessageExample example = new AppMessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusEqualTo(new Integer(0).byteValue());
		return messageDao.countByExample(example, criteria);
	}

	@Override
	public int addMessage(long userId, String orderMessage, int messageTyoe, long orderId, byte relationType) {
		logger.info("message:"+orderMessage);
		return messageDao.addMessage(userId, orderMessage, messageTyoe, orderId, relationType);
	}

	@Override
	public String deleteMessage(long userId, long messageId) {
		AppMessage message = new AppMessage();
		message.setUserId(userId);
		message.setMessageId(messageId);
		messageDao.deleteMessage(message);
		return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
	}

	@Override
	public String updateMessage(long userId, long messageId) {
		AppMessage message = new AppMessage();
		message.setMessageId(messageId);
		message.setStatus(new Integer(1).byteValue());
		messageDao.updateMessage(message);
		return ResultUtil.getResultJson(Status.success.getStatus(), Status.success.getMsg());
	} 

	// 从网上获取视频信息
	@Override
	public String getVideo(String phone, long userId) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("phone", "13537837527");
		paramsMap.put("userId", userId);
		// paramsMap.put("type",1);
		Map<String, Object> map = paramsInit("token/getAccessToken", paramsMap);
		String returntorken = "";
		if (BasicConstant.getAccessToken != null && !BasicConstant.getAccessToken.equals("")) {
			returntorken = BasicConstant.getAccessToken;
			System.out.println(returntorken);
		}
		returntorken = doPost(map);
		if (returntorken != null && !returntorken.equals("")) {
			BasicConstant.getAccessToken = returntorken;
			return ResultUtil.getResultJson(returntorken, Status.success.getStatus(), Status.success.getMsg());
		}
		return ResultUtil.getResultJson(Status.urlNullity.getStatus(), Status.urlNullity.getMsg());
	}

	protected Map<String, Object> paramsInit(String method, Map<String, Object> paramsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 对数据加密
		long time = System.currentTimeMillis() / 1000;
		String appkey = "a6b317361dc84c178689b1819a4cfa9e";
		String secret = "b8d1de5a918b8c78c5dc7f07af0f49ad";

		List<String> paramList = new ArrayList<String>();
		for (Iterator<String> it = paramsMap.keySet().iterator(); it.hasNext();) {
			String key1 = it.next();
			String param = key1 + ":" + paramsMap.get(key1);
			paramList.add(param);
		}
		String[] params = paramList.toArray(new String[paramList.size()]);
		Arrays.sort(params);
		StringBuilder paramString = new StringBuilder();
		for (String param : params) {
			paramString.append(param).append(",");
		}
		paramString.append("method").append(":").append(method).append(",");
		paramString.append("time").append(":").append(time).append(",");
		paramString.append("secret").append(":").append(secret);
		String sign = null;
		try {
			sign = DigestUtils.md5Hex(paramString.toString().trim().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 加密结束
		Map<String, Object> systemMap = new HashMap<String, Object>();
		systemMap.put("ver", "1.0");
		systemMap.put("sign", sign);
		systemMap.put("key", appkey);
		systemMap.put("time", time);

		map.put("system", systemMap);
		map.put("method", method);
		map.put("params", paramsMap);
		map.put("id", "123456");
		return map;
	}

	private String doPost(Map<String, Object> map) {
		String json = JSON.toJSONString(map);
		ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
		Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod("https://open.ys7.com:443/api/method");
		try {
			RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
			method.setRequestEntity(entity);
			client.executeMethod(method);
			logger.info("token/getAccessToken");
			InputStream inputStream = method.getResponseBodyAsStream();
			String restult = IOUtils.toString(inputStream);
			logger.info("token/getAccessToken" + restult);
			// 对返回值做处理
			JSONObject resultJson = JSON.parseObject(restult).getJSONObject("result");
			int code = Integer.parseInt(resultJson.getString("code"));
			if (code == 200) {
				restult = resultJson.getJSONObject("data").getString("accessToken");
			}
			// 对返回值做处理 end
			return restult;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return "";
	}

	// 从网上获取视频信息 end
}
