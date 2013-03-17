package com.cssrc.dao;

import java.util.List;

import com.cssrc.bean.OnlineCtrl;

/**
 * <p>
 * Title: CSSRCDB
 * </p>
 * <p>
 * Description: interface
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: CSSRC IT DIVISION
 * </p>
 * 
 * @author wujianbo
 * @version 1.0
 */
public interface IOnlineCtrlDAO {

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveOnlineCtrl(OnlineCtrl user);

	/**
	 * @param id
	 *            long
	 * @return User
	 */

	public OnlineCtrl getOnlineCtrl(Integer no);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyOnlineCtrl(OnlineCtrl onlinectrl);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeOnlineCtrl(OnlineCtrl onlinectrl);

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition);

	public List findOnlieCtrl(Integer no);

	/**
	 * @param condition
	 *            String,offset int,pagesize int
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize);

	public List getsqlresult(String sql, Object[] obj);
}
