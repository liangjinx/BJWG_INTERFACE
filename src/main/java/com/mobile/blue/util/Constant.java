package com.mobile.blue.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author kelvin.tie
 */
public class Constant {

	public static final String CREATE_BY_API = "API_CREATE";
	public static final String UPDATE_BY_API = "API_UPDATE";
	public static final String CREATE_BY_SCHEDULE_API = "API_SCHEDULE_CREATE";
	public static final String UPDATE_BY_SCHEDULE_API = "API_SCHEDULE_UPDATE";
	public static final String GROUP_UPLOAD_IMAGE_PATH = "GROUP_UPLOAD_IMAGE_PATH";
	public static final String API1_LINK_IMAGE_PATH = "API1_LINK_IMAGE_PATH";
	public static final String API2_LINK_IMAGE_PATH = "API2_LINK_IMAGE_PATH";
	public static final String CMS_LINK_IMAGE_PATH = "CMS_LINK_IMAGE_PATH";
	public static final String USER_ICON_UPLOAD_PATH = "USER_ICON_UPLOAD_PATH";
	public static final String IMAGE_SERVER_LINK_IMAGE_PATH = "IMAGE_SERVER_LINK_IMAGE_PATH";
	public static final String API_APP_DB_PATH = "API_APP_DB_PATH";

	public static final String DMP_API_KEY = "DMP_API_KEY";
	public static final String DMP_CAMPAIGN_SERVICE_URL = "DMP_CAMPAIGN_SERVICE_URL";
	public static final String DMP_POINT_SERVICE_URL = "DMP_POINT_SERVICE_URL";
	public static final String DMP_USER_SERVICE_URL = "DMP_USER_SERVICE_URL";

	public static final String EXECUTE_SCHEDULE = "EXECUTE_SCHEDULE";

	public static final String RESOURS_NOT_FOUND = "RESOURS_NOT_FOUND";

	public static final String REQUEST_PARAM_ERROR = "REQUEST_PARAM_ERROR";

	public static final String VALIDATION_EMAIL = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";

	public static final String VALIDATION_MOBILE = "^[1-9]{1}[0-9]*$";

	public static final String SPLITE_STRING = "-";

	public static final String WEATHER_TABLE = "Weather";

	public static boolean ISUPDATE = false;

	public static final String CITYS_TABLE = "CITYS";

	public static final String CITYS = "WEATHERCITYS";

	public static final Map<String, String> GOOGLE_PLAY_MAP = new HashMap<String, String>();

	static {
		GOOGLE_PLAY_MAP.put("教育", "EDUCATION");
		GOOGLE_PLAY_MAP.put("社交", "SOCIAL");
		GOOGLE_PLAY_MAP.put("健康塑身", "HEALTH_AND_FITNESS");
		GOOGLE_PLAY_MAP.put("娱乐", "ENTERTAINMENT");
		GOOGLE_PLAY_MAP.put("音乐", "MUSIC_AND_AUDIO");
		GOOGLE_PLAY_MAP.put("运动", "SPORTS");
		GOOGLE_PLAY_MAP.put("摄影", "PHOTOGRAPHY");
		GOOGLE_PLAY_MAP.put("旅游与本地出行", "TRAVEL_AND_LOCAL");
		GOOGLE_PLAY_MAP.put("通讯", "COMMUNICATION");
		GOOGLE_PLAY_MAP.put("工具", "TOOLS");
		GOOGLE_PLAY_MAP.put("药品", "MEDICAL");
		GOOGLE_PLAY_MAP.put("视频与媒体", "MEDIA_AND_VIDEO");
		GOOGLE_PLAY_MAP.put("购物", "SHOPPING");
		GOOGLE_PLAY_MAP.put("小部件", "APP_WIDGETS");
		GOOGLE_PLAY_MAP.put("生活时尚", "LIFESTYLE");
		GOOGLE_PLAY_MAP.put("软件与演示", "LIBRARIES_AND_DEMO");
		GOOGLE_PLAY_MAP.put("财务", "FINANCE");
		GOOGLE_PLAY_MAP.put("图书与工具书", "BOOKS_AND_REFERENCE");
		GOOGLE_PLAY_MAP.put("新闻杂志", "NEWS_AND_MAGAZINES");
		GOOGLE_PLAY_MAP.put("交通运输", "TRANSPORTATION");
		GOOGLE_PLAY_MAP.put("个性化", "PERSONALIZATION");
	}

	public static Long[] NEW_SCAN_COUNT = new Long[] { 5321l, 5323l, 123l, 6309l, 7120l, 5536l, 7624l, 1000l, 770l,
			2364l, 1521l, 1960l, 3456l, 659l, 997l, 8875l, 3329l, 6609l, 1093l, 12863l, 9854l, 653l, 7084l };

	public static Map<Long, Long> FENGWENRENSHU = new HashMap<Long, Long>();

	public static final int NEWS_PAGE_SIZE = 6;// 新闻分页大小

	public static String getImageURL(Date createTime, String appUrl, String imageUrl) {
		// 5min 取得image serverPath ,否則 cep api path
		if (createTime == null) {
			return appUrl;
		}
		if (DateUtil.getCurrentDate().compareTo(DateUtil.getAfterMin(createTime, 10)) == -1) {
			return appUrl;
		} else {
			return imageUrl;
		}
	}

	public static String getAPIImageUrl(String imageUrl) {

		if (StringUtils.isBlank(imageUrl)) {
			return null;
		}
		String imagePath = PropertiesUtil.getProperty(API1_LINK_IMAGE_PATH);
		if (imagePath.indexOf("app1") != -1) {
			imagePath = PropertiesUtil.getProperty(API1_LINK_IMAGE_PATH);
		} else if (imagePath.indexOf("app2") != -1) {
			imagePath = PropertiesUtil.getProperty(API2_LINK_IMAGE_PATH);
		}

		return imagePath + imageUrl;

	}

	public static String getCMSImageUrl(String imageUrl) {

		if (StringUtils.isBlank(imageUrl)) {
			return null;
		}

		String imagePath = PropertiesUtil.getProperty(CMS_LINK_IMAGE_PATH);

		return imagePath + imageUrl;

	}

	public static String getImageServerImageUrl(String imageUrl) {

		if (StringUtils.isBlank(imageUrl)) {
			return null;
		}

		String imagePath = PropertiesUtil.getProperty(IMAGE_SERVER_LINK_IMAGE_PATH);

		return imagePath + imageUrl;

	}

	/**
	 * 獲取一個userId
	 * 
	 * @return
	 */
	public static String getUserId() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString().replaceAll("-", "");
	}

	public static String getTempUserId() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString().replaceAll("-", "").replace(uuid.toString().substring(0, 6), "000000");
	}

	/**
	 * 獲取一個sessionId
	 * 
	 * @return
	 */
	public static String getSessionId() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString();
	}

	// 根据mobile的位数添加areaCode
	public static String returnAreaCode(String info, String areaCode) {
		if (StringUtils.isBlank(areaCode)) {
			String result = "852";
			if (info.length() == 8) {
				return "852";
			} else if (info.length() == 11) {
				return "86";
			} else if (info.length() == 7) {
				return "60";
			} else if (info.length() == 10) {
				return "886";
			} else {
				return result;
			}
		}
		return areaCode;
	}

	// 获取默认icon图片
	public static String getDefaultIcon() {
		return getImageServerImageUrl(PropertiesUtil.getProperty("default_icon"));
	}

	// 跟mysql String排序一样
	public static int compareByString(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
		int index = 0, len1 = arr1.length, len2 = arr2.length;
		int len = len1 < len2 ? len1 : len2;
		while (index < len) {
			char c1 = arr1[index], c2 = arr2[index];
			char c1_ = (char) (c1 <= 'a' ? c1 - ('a' - 'A') : c1);
			char c2_ = (char) (c2 <= 'a' ? c2 - ('a' - 'A') : c2);
			if (c1_ == c2_) {
				if (c1 != c2)
					return c1 - c2;
			} else
				return c1_ - c2_;
			index++;
		}
		if (len1 == len2)
			return 0;
		else if (len1 > len2)
			return arr1[len];
		else
			return -arr2[len];
	}

}
