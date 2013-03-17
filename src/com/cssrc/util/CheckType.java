package com.cssrc.util;

import java.util.Calendar;

public class CheckType {
	/**
	 * @param i
	 *            �ܳ���
	 * @param j
	 *            С������
	 * @param x
	 *            Ҫ���ֵ
	 * @return
	 */
	public static boolean Number(int i, int j, Double x) {
		if (x == null) {
			return true;
		}
		String temp = x.toString();
		int index = temp.indexOf('.');
		int sub = temp.indexOf('-');
		// û�и���
		if (-1 == sub) {
			// û��С����
			if (-1 == index) {
				if (temp.length() > (i - j)) {
					return false;
				}
			} else {
				int m = temp.substring(0, index).length();// ���������յ�,ȡ������������
				int n = temp.length() - m - 1;// С������
				if (m > (i - j) || n > j) {
					return false;
				}
			}
		}
		// ���ڸ��ŵ����
		else {
			if (-1 == index) {
				// û��С����
				if (temp.length() > (i - j + 1)) {
					return false;
				}
			} else {
				int m = temp.substring(0, index).length();// ���������յ�,ȡ������������,����������
				int n = temp.length() - m - 1;// С������
				if (m > (i - j + 1) || n > j) {
					return false;
				}
			}

		}
		return true;
	}

	/**
	 * @param i
	 *            �ַ��ĳ���
	 * @param x
	 *            Ҫ���Ե��ַ���
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
	 *            �ܳ���
	 * @param x
	 *            Ҫ���ֵ
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
	 * �ж�һ���ַ����Ƿ��Ǵ����֣������ж������ַ�����͵�
	 * 
	 * @param s
	 *            �������жϵ��ַ���
	 * @return
	 */

	public static boolean isNum(String s) {
		if (Character.isDigit(s.charAt(0))) {
			return true;
		}
		return false;
	}

}
