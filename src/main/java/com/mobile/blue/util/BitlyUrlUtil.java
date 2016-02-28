package com.mobile.blue.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rosaloves.bitlyj.Bitly;
import com.rosaloves.bitlyj.Bitly.Provider;
import com.rosaloves.bitlyj.ShortenedUrl;

public class BitlyUrlUtil {
	private static Log logger = LogFactory.getLog(BitlyUrlUtil.class);

	public static String LongToShrtURL(String longUrl, String BITLY_USER, String BITLY_API_KEY) {
		Provider bitly = Bitly.as(BITLY_USER, BITLY_API_KEY);
		String shortenedUrlString = null;
		logger.info("Long URL : " + longUrl);
		System.out.println("Long URL : " + longUrl);

		try {
			ShortenedUrl shortenedUrl = bitly.call(Bitly.shorten(longUrl));
			shortenedUrlString = shortenedUrl.getShortUrl();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info("Shortened URL : " + shortenedUrlString);
		System.out.println("Shortened URL : " + shortenedUrlString);
		return shortenedUrlString;
	}

	public static String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h",

			"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",

			"u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",

			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",

			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",

			"U", "V", "W", "X", "Y", "Z" };

	public static String build(String url) {
		if (url == null) {
			return null;
		}
		// 先得到url的32个字符的md5码
		String md5 = EncryptMD5Util.getMD5(url);

		// 将32个字符的md5码分成4段处理，每段8个字符
		for (int i = 0; i < 4; i++) {

			int offset = i * 8;

			String sub = md5.substring(offset, offset + 8);

			long sub16 = Long.parseLong(sub, 16); // 将sub当作一个16进制的数，转成long

			// & 0X3FFFFFFF，去掉最前面的2位，只留下30位
			sub16 &= 0X3FFFFFFF;

			StringBuilder sb = new StringBuilder();
			// 将剩下的30位分6段处理，每段5位
			for (int j = 0; j < 6; j++) {
				// 得到一个 <= 61的数字
				long t = sub16 & 0x0000003D;
				sb.append(chars[(int) t]);

				sub16 >>= 5; // 将sub16右移5位
			}

			System.out.println(sb.toString());
			return sb.toString();
		}

		return null;
	}

	public static void main(String[] args) {
		build("90fca0b37ca449269810ad4f88ab7597");
	}
}
