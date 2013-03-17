package com.cssrc.util;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {

	public DateUtil() {
	}

	public static String getCurrentDateString(String s) {
		if (null == s) {
			return new String("0000-00-00");
		}
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
		simpledateformat.setTimeZone(TimeZone.getDefault());
		return simpledateformat.format(calendar.getTime());
	}

	public static String getDateString(Date date, String s) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
		return simpledateformat.format(date);
	}

	public static Date getDate(String s, String s1) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1);
		ParsePosition parseposition = new ParsePosition(0);
		return simpledateformat.parse(s, parseposition);
	}

	public static Date addDays(String s, String s1, int i) {
		return addDays(getDate(s, s1), i);
	}

	public static Date addDays(Date date, int i) {
		GregorianCalendar gregoriancalendar = new GregorianCalendar();
		gregoriancalendar.setTime(date);
		gregoriancalendar.add(5, i);
		return gregoriancalendar.getTime();
	}

	public static boolean isDateBetween(Date date, Date date1, Date date2) {
		return (date1.before(date) || date1.equals(date)) && (date.before(date2) || date.equals(date2));
	}

	public static String getCalendarString(Calendar calendar, String s) {
		if (null == calendar) {
			return new String("0000-00-00");
		}
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
		return simpledateformat.format(calendar.getTime());
	}

	public static Calendar getCalendar(String s) {
		if (null == s) {
			return null;
		}
		int i = Integer.parseInt(s.substring(0, 4));
		int j = Integer.parseInt(s.substring(5, 7)) - 1;
		int k = Integer.parseInt(s.substring(8, 10));
		Calendar calendar = Calendar.getInstance();
		calendar.set(i, j, k);
		return calendar;
	}

	public static Double dStr(String s, int flag) {
		// s是字符串，flag是保留的小数位。
		StringBuffer temp = new StringBuffer();
		if (s == null || s.equals("")) {
			temp.append("0.");
			for (int i = 1; i <= flag; i++) {
				temp.append("0");
			}

		} else {
			if (s.indexOf(".") != 0) {
				for (int j = s.indexOf(".") + 1; j <= s.indexOf(".") + 2; j++) {
					temp.append(s.charAt(j));
				}
				temp.append(".");
				for (int m = 3; m <= flag + 2; m++) {
					temp.append(s.charAt(s.indexOf(".") + m));
				}
			}

		}
		return Double.valueOf(temp.toString());
	}

}
