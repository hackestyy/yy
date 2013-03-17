package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Smemberdeputyinfo;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public interface ISmemberdeputyinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveSmemberdeputyinfo(Smemberdeputyinfo smemberdeputyinfo);

	public Integer getSize(Integer smbi_id);

	public Integer getSize(String assoduty_s, String queryString);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Smemberdeputyinfo getSmemberdeputyinfo(Integer smdi_id);

	/**
	 * @return List
	 */
	public List findSmemberdeputyinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifySmemberdeputyinfo(Smemberdeputyinfo smemberdeputyinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeSmemberdeputyinfo(Smemberdeputyinfo smemberdeputyinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberdeputyinfo(Integer smdi_id);

	/**
	 * @param condition
	 * @return List
	 */
	public Integer getSize();

	/**
	 * @param
	 * @return Integer
	 */
	public Integer getquerySize(String condition);

	/**
	 * @param
	 * @return int
	 */
	public Integer getquerySize(String condition, Object[] obj);

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition, Object[] obj);

	public List listquery(String condition, int offset, int pagesize);

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition);

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize);

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize, Object[] obj);

	/**
	 * @param userid
	 *            String,password String
	 * @return boolean
	 */
	public int SaveSmemberdeputyinfoList(List recordBeanList);

	public List getSqlresult(String assoduty_s);

	public List findSmemberdeputyinfoList(Integer smbi_id);

	public boolean delete(List list);

}
