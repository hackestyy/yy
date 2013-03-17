package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Smemberacademicliterature;

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
public interface ISmemberacademicliteratureDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveSmemberacademicliterature(Smemberacademicliterature smemberacademicliterature);

	public Integer getSize(Integer smbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Smemberacademicliterature getSmemberacademicliterature(Integer smal_id);

	/**
	 * @return List
	 */
	public List findSmemberacademicliteratureAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifySmemberacademicliterature(Smemberacademicliterature smemberacademicliterature);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeSmemberacademicliterature(Smemberacademicliterature smemberacademicliterature);

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberacademicliterature(Integer smal_id);

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
	public int SaveSmemberacademicliteratureList(List recordBeanList);

	public List gainSmemberacademicliterature(Integer smbi_id);

	public boolean delete(List list);

}
