package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Shadeputyinfo;

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
public interface IShadeputyinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveShadeputyinfo(Shadeputyinfo shadeputyinfo);

	public Integer getSize(Integer shadbi_id);

	public Integer getSize(String assoduty_s, String queryString);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Shadeputyinfo getShadeputyinfo(Integer shadi_id);

	/**
	 * @return List
	 */
	public List findShadeputyinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyShadeputyinfo(Shadeputyinfo shadeputyinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeShadeputyinfo(Shadeputyinfo shadeputyinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputyinfo(Integer shadi_id);

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
	public int SaveShadeputyinfoList(List recordBeanList);

}
