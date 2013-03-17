package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Gmemberresearchproduction;

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
public interface IGmemberresearchproductionDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveGmemberresearchproduction(Gmemberresearchproduction gmemberresearchproduction);

	public Integer getSize(Integer gmbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Gmemberresearchproduction getGmemberresearchproduction(Integer gmrp_id);

	/**
	 * @return List
	 */
	public List findGmemberresearchproductionAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyGmemberresearchproduction(Gmemberresearchproduction gmemberresearchproduction);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeGmemberresearchproduction(Gmemberresearchproduction gmemberresearchproduction);

	/**
	 * @param userid
	 * @return List
	 */
	public List findGmemberresearchproduction(Integer gmrp_id);

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
	public int SaveGmemberresearchproductionList(List recordBeanList);

	public boolean delete(List list);
}
