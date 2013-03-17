package com.cssrc.util;

import java.util.Calendar;

public class CheckType {
	/**
	 * @param i
	 *            总长度
	 * @param j
	 *            小数长度
	 * @param x
	 *            要测的值
	 * @return
	 */
	public static boolean Number(int i, int j, Double x) {
		if (x == null) {
			return true;
		}
		String temp = x.toString();
		int index = temp.indexOf('.');
		int sub = temp.indexOf('-');
		// 没有负号
		if (-1 == sub) {
			// 没有小数点
			if (-1 == index) {
				if (temp.length() > (i - j)) {
					return false;
				}
			} else {
				int m = temp.substring(0, index).length();// 包括起点和终点,取的是整数部分
				int n = temp.length() - m - 1;// 小数部分
				if (m > (i - j) || n > j) {
					return false;
				}
			}
		}
		// 存在负号的情况
		else {
			if (-1 == index) {
				// 没有小数点
				if (temp.length() > (i - j + 1)) {
					return false;
				}
			} else {
				int m = temp.substring(0, index).length();// 包括起点和终点,取的是整数部分,不包括负号
				int n = temp.length() - m - 1;// 小数部分
				if (m > (i - j + 1) || n > j) {
					return false;
				}
			}

		}
		return true;
	}

	/**
	 * @param i
	 *            字符的长度
	 * @param x
	 *            要测试的字符串
	 * @return
	 */
	public static boolean CheckVarchar2(int i, String x) {
		if (x == null) {
			return true;
		}
		if (x.length() > i) {
			return false;
		}
		return true;

	}

	public static boolean CheckVarchar3(int i, String m) {
		char temp1 = 'x';
		char temp2 = 'y';
		char temp3 = 'z';
		if (m == null) {
			return true;
		}
		if (m.equals(temp1) || m.equals(temp2) || m.equals(temp3)) {
			return false;
		}
		if (m.length() > i) {
			return false;
		}
		return true;

	}

	public static boolean CheckCalendar(Calendar data) {
		try {
			DateUtil.getCalendarString(data, "yyyy-MM-dd");
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param i
	 *            总长度
	 * @param x
	 *            要测的值
	 * @return
	 */
	public static boolean CheckInteger(int i, Integer x) {
		if (x == null) {
			return true;
		}

		if (x.toString().length() > i) {
			return false;
		}
		return true;

	}

	/**
	 * 判断一个字符串是否是纯数字，不能判断数字字符混合型的
	 * 
	 * @param s
	 *            将进行判断的字符串
	 * @return
	 */

	public static boolean isNum(String s) {
		if (Character.isDigit(s.charAt(0))) {
			return true;
		}
		return false;
	}

}
