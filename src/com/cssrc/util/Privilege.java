package com.cssrc.util;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class Privilege {
	public Privilege() {
	}

	/*
	 * numֵ��˵���� ��ȫ��ƣ�0 �����û����޸����롢�����ɫ��1 ������ɫ������ɫ�������Ȩ�ޣ�2 ���ݿⱸ�ݣ�3 ���ݿ�ָ���4
	 */
	public static boolean CheckUfuncgPrivilege(String s, int num) {
		int[] roles = new int[20];
		for (int i = 0; i <= num; i++) {
			if (s.charAt(i) == '1') {
				roles[i] = 1;
			} else
				roles[i] = 0;
		}
		if (roles[num] == 0)
			return true;
		else
			return false;
	}

}
