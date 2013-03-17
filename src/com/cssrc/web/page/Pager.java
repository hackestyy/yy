package com.cssrc.web.page;

import java.util.ResourceBundle;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author mengbin
 * @version 1.0
 */
public class Pager {
	private static int _fldtry = 15;
	private static String _flddo = "Result page";
	private static String _fldcase = "第一页";
	private static String _fldbyte = "前一页";
	private static String a = "下一页";
	private static String _fldnew = "最后页";
	private static String _fldgoto = "第";
	private static String _fldelse = "页";
	private static String _fldfor = "共";
	private static String _fldint = "记录";
	private static String _fldif = "Records per Page";
	private static String _fldchar = "To";

	public Pager() {
	}

	public static String generateall(int i, int j, int k, String s) {
		if (k > 0) {
			int l = j % k != 0 ? j / k + 1 : j / k;
			int i1 = i / k + 1;
			String s1;
			if (s.indexOf("?") > -1)
				s1 = "&";
			else
				s1 = "?";
			String s2 = "";
			if (i1 > 1) {
				s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=0" + "&pagesize=" + k + "\">" + _fldcase + "</a>\n";
				s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=" + (i - k) + "&pagesize=" + k + "\">" + _fldbyte + "</a>\n";
			} else {
				s2 = s2 + "&nbsp;" + _fldcase + "\n";
				s2 = s2 + "&nbsp;" + _fldbyte + "\n";
			}
			if (i1 < l) {
				s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=" + (i + k) + "&pagesize=" + k + "\">" + a + "</a>\n";
				s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=" + (l - 1) * k + "&pagesize=" + k + "\">" + _fldnew + "</a>\n";
			} else {
				s2 = s2 + "&nbsp;" + a + "\n";
				s2 = s2 + "&nbsp;" + _fldnew + "\n";
			}
			s2 = s2 + "&nbsp;&nbsp;&nbsp;&nbsp;";
			s2 = s2 + _fldgoto + "<span class='redtext'>" + i1 + "</span>" + _fldelse + "&nbsp;";
			s2 = s2 + _fldfor + "<span class='redtext'>" + l + "</span>" + _fldelse + "&nbsp;";
			s2 = s2 + _fldfor + "<span class='redtext'>" + j + "</span>" + _fldint + "&nbsp;";
			return s2;
		} else {
			return "";
		}
	}

	public static String generate(int i, int j, int k, String s) {
		if (j > k) {
			String s1;
			if (s.indexOf("?") > -1)
				s1 = "&";
			else
				s1 = "?";
			String s2 = "<font face='Helvetica' size='-1'>" + _flddo + ": ";
			if (i > 0)
				s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=" + (i - k) + "\">[<< Prev]</a>\n";
			int i1 = (_fldtry / 2) * k;
			int l;
			if (i < i1)
				l = 0;
			else if (i < j - i1)
				l = i - i1;
			else
				l = (j / k - _fldtry) * k;
			for (int j1 = l; j1 < j && j1 < l + _fldtry * k; j1 += k)
				if (j1 == i)
					s2 = s2 + "<b>" + (j1 / k + 1) + "</b>\n";
				else
					s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=" + j1 + "\">" + (j1 / k + 1) + "</a>\n";

			if (i < j - k)
				s2 = s2 + "&nbsp;<a href=\"" + s + s1 + "pager.offset=" + (i + k) + "\">[Next >>]</a>\n";
			s2 = s2 + "</font>";
			return s2;
		} else {
			return "";
		}
	}

	static {
		ResourceBundle resourcebundle = ResourceBundle.getBundle("ApplicationResources");
		try {
			_flddo = resourcebundle.getString("pager.header.title");
			_fldcase = resourcebundle.getString("pager.header.firstpage");
			_fldbyte = resourcebundle.getString("pager.header.prepage");
			a = resourcebundle.getString("pager.header.nextpage");
			_fldnew = resourcebundle.getString("pager.header.lastpage");
			_fldgoto = resourcebundle.getString("pager.header.showthepage");
			_fldelse = resourcebundle.getString("pager.header.showpage");
			_fldfor = resourcebundle.getString("pager.header.showtotalpage");
			_fldint = resourcebundle.getString("pager.header.showrecord");
			_fldif = resourcebundle.getString("pager.header.showrecordspage");
			_fldchar = resourcebundle.getString("pager.header.showtopage");
			// _fldtry =
			// Integer.parseInt(resourcebundle.getString("pager.max.page.index"));
		} catch (Exception exception) {
		}
	}
}
