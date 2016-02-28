package com.mobile.blue.util.util;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 
 * @author Takamachi660
 * 
 */
public final class IpConvert {
	private IpConvert() {
	}

	public static BigInteger StringToBigInt(String ipInString) {
		ipInString = ipInString.replace(" ", "");
		byte[] bytes;
		if (ipInString.contains(":"))
			bytes = ipv6ToBytes(ipInString);
		else
			bytes = ipv4ToBytes(ipInString);
		return new BigInteger(bytes);
	}

	public static String BigIntToString(BigInteger ipInBigInt) {
		byte[] bytes = ipInBigInt.toByteArray();
		byte[] unsignedBytes = Arrays.copyOfRange(bytes, 1, bytes.length);
		try {
			String ip = InetAddress.getByAddress(unsignedBytes).toString();
			return ip.substring(ip.indexOf('/') + 1).trim();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	private static byte[] ipv6ToBytes(String ipv6) {
		byte[] ret = new byte[17];
		ret[0] = 0;
		int ib = 16;
		boolean comFlag = false;
		if (ipv6.startsWith(":"))
			ipv6 = ipv6.substring(1);
		String groups[] = ipv6.split(":");
		for (int ig = groups.length - 1; ig > -1; ig--) {
			if (groups[ig].contains(".")) {
				byte[] temp = ipv4ToBytes(groups[ig]);
				ret[ib--] = temp[4];
				ret[ib--] = temp[3];
				ret[ib--] = temp[2];
				ret[ib--] = temp[1];
				comFlag = true;
			} else if ("".equals(groups[ig])) {
				int zlg = 9 - (groups.length + (comFlag ? 1 : 0));
				while (zlg-- > 0) {
					ret[ib--] = 0;
					ret[ib--] = 0;
				}
			} else {
				int temp = Integer.parseInt(groups[ig], 16);
				ret[ib--] = (byte) temp;
				ret[ib--] = (byte) (temp >> 8);
			}
		}
		return ret;
	}

	private static byte[] ipv4ToBytes(String ipv4) {
		byte[] ret = new byte[5];
		ret[0] = 0;
		int position1 = ipv4.indexOf(".");
		int position2 = ipv4.indexOf(".", position1 + 1);
		int position3 = ipv4.indexOf(".", position2 + 1);
		ret[1] = (byte) Integer.parseInt(ipv4.substring(0, position1));
		ret[2] = (byte) Integer.parseInt(ipv4.substring(position1 + 1, position2));
		ret[3] = (byte) Integer.parseInt(ipv4.substring(position2 + 1, position3));
		ret[4] = (byte) Integer.parseInt(ipv4.substring(position3 + 1));
		return ret;
	}
}
