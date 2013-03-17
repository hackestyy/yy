package com.cssrc.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyUtil {
	public MyUtil() {
	}

	public static boolean nullOrBlank(String param) {
		return param == null || param.length() == 0 || param.trim().equals("");
	}

	// 通过selected 得到“100101010”这样的字符串
	public static String getRoleString(String[] roles) {
		char[] temp = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0' };
		for (int i = 0; i < roles.length; i++) {
			temp[Integer.parseInt(roles[i])] = '1';
		}
		String s = "";
		s = String.valueOf(temp);
		return s;
	}

	// 通过“100101010”这样的字符串得到selected一样的字符串数组如{"1","2","3"}
	public static String[] getRoles(String s) {
		String[] roles = new String[10];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				roles[i] = String.valueOf(i);
			}
		}
		return roles;
	}

	// 通过ttypeselected 得到“100101010”这样的字符串
	public static String getTTypeString(String[] ttypeselected) {
		char[] temp = { '0', '0', '0', '0', '0', '0' };
		for (int i = 0; i < ttypeselected.length; i++) {
			temp[Integer.parseInt(ttypeselected[i])] = '1';
		}
		String s = "";
		s = String.valueOf(temp);
		return s;
	}

	// 通过ctypeselected 得到“100101010”这样的字符串
	public static String getGrantsString(String[] grantsselected) {
		char[] temp = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0' };
		for (int i = 0; i < grantsselected.length; i++) {
			temp[Integer.parseInt(grantsselected[i])] = '1';
		}
		String s = "";
		s = String.valueOf(temp);
		return s;
	}

	// 通过tchnoselected 得到“100101010”这样的字符串
	public static String getTchnoString(String[] tchnoselected) {
		char[] temp = { '0', '0', '0' };
		for (int i = 0; i < tchnoselected.length; i++) {
			temp[Integer.parseInt(tchnoselected[i])] = '1';
		}
		String s = "";
		s = String.valueOf(temp);
		return s;
	}

	// 通过“100101010”这样的字符串得到selected一样的字符串数组如{"1","2","3"}
	public static String[] getTtypeselected(String s) {
		String[] ttype = new String[6];
		if (null == s) {
			return ttype;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				ttype[i] = String.valueOf(i);
			}
		}
		return ttype;
	}

	// 通过“100101010”这样的字符串得到selected一样的字符串数组如{"1","2","3"}
	public static String[] getGrantsselected(String s) {
		String[] grants = new String[13];
		if (null == s) {
			return grants;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				grants[i] = String.valueOf(i);
			}
		}
		return grants;
	}

	// 通过“100101010”这样的字符串得到selected一样的字符串数组如{"1","2","3"}
	public static String[] getTchnoselected(String s) {
		String[] tchno = new String[3];
		if (null == s) {
			return tchno;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				tchno[i] = String.valueOf(i);
			}
		}
		return tchno;
	}

	public static String encryptPassword(String repassword) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(repassword.getBytes());
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return String.valueOf(str);
		} catch (NoSuchAlgorithmException ex) {
			ex.toString();
			return null;
		}

	}

	/**
	 * 在CZX的悬臂由于角度默认为360°，所以在得到不同的个数和值的时候要把360°去掉。
	 * 
	 * @param oldList
	 *            List
	 * @return List
	 */
	public static List getNewList(List oldList) {
		List newList = new ArrayList();
		for (int i = 0; i < oldList.size(); i++) {
			Double temp = (Double) oldList.get(i);
			if (temp.doubleValue() != 360) {
				newList.add(oldList.get(i));
			}
		}
		return newList;
	}

	public static String generatePassword(int length) {
		Random r = new Random();
		String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
		char[] src = source.toCharArray();
		char[] buf = new char[length];
		int rnd;
		for (int i = 0; i < length; i++) {
			rnd = Math.abs(r.nextInt()) % src.length;
			buf[i] = src[rnd];
		}
		return new String(buf);
	}

	// 通过IP地址得到机器MAC地址
	public static String getMacAddressIP(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A" + remotePcIP);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 0; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
		}
		return macAddress;
	}

	// 截短字符串，用以在网页上的正常显示
	public static String cutString(String s, Integer leng)// s:输入的字符串
															// leng:输出字符串指定的长度
	{
		if (s.length() > leng) {
			s = s.substring(0, leng) + "......";
			return s;
		} else {
			return s;
		}
	}

}
