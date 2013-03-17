package com.cssrc.dao;

import java.util.List;

import com.cssrc.bean.User;

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
public interface IUserDAO {

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveUser(User user);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public User getUser(String userid);

	public User getUser(Integer ui_id);

	/**
	 * @return List
	 */
	public List findUserAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyUser(User user);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeUser(User user);

	/**
	 * @param userid
	 * @return List
	 */
	public List findUser(String user_name);

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
	public boolean isValidUser(String user_name, String password);

	public List listAssoName();

	public List listAcadName();

	public List listAccount();

	public int checkusername(String username);

	public List getsqlresult(String sql, Object[] obj);
}
