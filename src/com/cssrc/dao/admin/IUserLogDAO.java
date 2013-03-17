package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.UserLog;

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
public interface IUserLogDAO {

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveUserLog(UserLog uselog);

	/**
	 * @param id
	 *            long
	 * @return User
	 */

	public UserLog getUserLog(Integer no);

	/**
	 * @return List
	 */
	public List findUserLogAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeUserLog(UserLog userlog);

	/**
	 * @param userid
	 * @return List
	 */
	public List findUserLog(String name);

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition);

	/**
	 * @param condition
	 *            String,offset int,pagesize int
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize);

	/**
	 * @return Integer
	 */
	public Integer getSize();

	public Integer getSize1(String userrole);

	/**
	 * @param userid
	 *            String,password String
	 * @return boolean
	 */
	public List findAll();

	public List getsqlresult(String sql, Object[] obj);

	public boolean delete(List list);
}
