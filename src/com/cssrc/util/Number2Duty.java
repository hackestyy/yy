package com.cssrc.util;

//转换数字到具体的代表委员职务信息
public class Number2Duty {

	public static String Number2Duty(String assoduty_f) {
		switch (Integer.valueOf(assoduty_f)) {
		case 0:
			assoduty_f = "主席";
			break;
		case 1:
			assoduty_f = "驻会副主席";
			break;
		case 2:
			assoduty_f = "副主席";
			break;
		case 3:
			assoduty_f = "常委会委员";
			break;
		case 4:
			assoduty_f = "委员";
			break;
		case 5:
			assoduty_f = "代表";
			break;
		}
		return assoduty_f;
	}

}
