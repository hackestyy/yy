package com.cssrc.util;

//ת�����ֵ�����Ĵ���ίԱְ����Ϣ
public class Number2Duty {

	public static String Number2Duty(String assoduty_f) {
		switch (Integer.valueOf(assoduty_f)) {
		case 0:
			assoduty_f = "��ϯ";
			break;
		case 1:
			assoduty_f = "פ�ḱ��ϯ";
			break;
		case 2:
			assoduty_f = "����ϯ";
			break;
		case 3:
			assoduty_f = "��ί��ίԱ";
			break;
		case 4:
			assoduty_f = "ίԱ";
			break;
		case 5:
			assoduty_f = "����";
			break;
		}
		return assoduty_f;
	}

}
