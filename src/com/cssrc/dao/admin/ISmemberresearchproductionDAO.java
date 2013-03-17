package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Smemberresearchproduction;

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
public interface ISmemberresearchproductionDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveSmemberresearchproduction(Smemberresearchproduction smemberresearchproduction);

	public Integer getSize(Integer smbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Smemberresearchproduction getSmemberresearchproduction(Integer smrp_id);

	/**
	 * @return List
	 */
	public List findSmemberresearchproductionAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifySmemberresearchproduction(Smemberresearchproduction smemberresearchproduction);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeSmemberresearchproduction(Smemberresearchproduction smemberresearchproduction);

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberresearchproduction(Integer smrp_id);

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
	public int SaveSmemberresearchproductionList(List recordBeanList);

	public List gainSmemberresearchproduction(Integer smbi_id);

	public boolean delete(List list);

}
