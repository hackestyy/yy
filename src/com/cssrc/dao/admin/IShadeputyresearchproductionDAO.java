package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Shadeputyresearchproduction;

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
public interface IShadeputyresearchproductionDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveShadeputyresearchproduction(Shadeputyresearchproduction shadeputyresearchproduction);

	public Integer getSize(Integer shadbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Shadeputyresearchproduction getShadeputyresearchproduction(Integer shadrp_id);

	/**
	 * @return List
	 */
	public List findShadeputyresearchproductionAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyShadeputyresearchproduction(Shadeputyresearchproduction shadeputyresearchproduction);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeShadeputyresearchproduction(Shadeputyresearchproduction shadeputyresearchproduction);

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputyresearchproduction(Integer shadrp_id);

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
	public int SaveShadeputyresearchproductionList(List recordBeanList);

}
