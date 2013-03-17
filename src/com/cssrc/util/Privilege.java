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
	 * num值的说明： 安全审计：0 创建用户、修改密码、授予角色：1 创建角色、给角色授予操作权限：2 数据库备份：3 数据库恢复：4
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
