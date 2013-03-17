package com.cssrc.util;

import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

public class StringUtil {
	public StringUtil() {
	}

	public static Vector parseString(String s, String s1) {
		Vector vector = new Vector();
		StringTokenizer stringtokenizer = new StringTokenizer(s, s1, false);
		String s2 = "";
		String s3 = "";
		int i = 0;
		while (stringtokenizer.hasMoreTokens())
			if (i == 0) {
				s2 = stringtokenizer.nextToken();
				if (s2.equals(s1))
					vector.add("");
				else
					vector.add(s2);
				i++;
			} else {
				String s4 = stringtokenizer.nextToken();
				if (s2.equals(s1) && s4.equals(s1))
					vector.add("");
				else if (!s4.equals(s1))
					vector.add(s4);
				i++;
				s2 = s4;
			}
		if (s2.equals(s1))
			vector.add("");
		return vector;
	}

	public static String BlankLength(int length) {
		String s = "";
		for (int i = 0; i < length; i++) {
			s += " ";
		}
		return s;
	}

	public static String FormatString(String s, int length) {
		if (s.length() == length)
			return s;
		if (s.length() < length) {
			return BlankLength(length - s.length()) + s;
		} else {
			return s;
		}
	}

	// ��ʽ�����������ַ����ַ���Ϊlength�涨�ĳ��ȣ��������ַ������ÿո���
	public static String FormatStringEng(String s, int length) {
		if (s.length() == length)
			return s;
		if (s.length() < length) {
			return s + BlankLength(length - s.length());
		} else {
			return s;
		}
	}

	// ��ʽ��ֻ�������ַ����ַ���Ϊlength�涨�ĳ��ȣ��������ַ������ÿո���
	public static String FormatStringCh(String s, int length) {
		if (s.length() == length)
			return s;
		if (s.length() < length) {
			return s + BlankLength((length - s.length()) * 2);
		} else {
			return s;
		}
	}

	// ��ʽ��������Ӣ���ַ���Ϊlength�涨�ĳ��ȣ��������ַ������ÿո��룬numΪ���еķ������ַ�����
	public static String FormatStringChAndEng(String s, int length, int num) {
		if (s.length() == length)
			return s;
		if (s.length() < length) {
			return s + BlankLength((length - s.length()) * 2 + num);
		} else {
			return s;
		}
	}

	public static String FormatDouble(Double num) {
		String format = "#################.000";
		if (num == null)
			num = new Double(0);
		DecimalFormat df = new DecimalFormat(format);
		df.setGroupingUsed(false);
		return FormatString(df.format(num), format.length());
	}

}
