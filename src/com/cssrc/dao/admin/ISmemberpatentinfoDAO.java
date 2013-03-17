package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Smemberpatentinfo;

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
public interface ISmemberpatentinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveSmemberpatentinfo(Smemberpatentinfo smemberpatentinfo);

	public Integer getSize(Integer smbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Smemberpatentinfo getSmemberpatentinfo(Integer smpi_id);

	/**
	 * @return List
	 */
	public List findSmemberpatentinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifySmemberpatentinfo(Smemberpatentinfo smemberpatentinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeSmemberpatentinfo(Smemberpatentinfo smemberpatentinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberpatentinfo(Integer smpi_id);

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
	public int SaveSmemberpatentinfoList(List recordBeanList);

	public List gainSmemberpatentinfo(Integer smbi_id);

	public boolean delete(List list);
}
