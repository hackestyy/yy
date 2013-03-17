package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Shadeputyacademicliterature;

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
public interface IShadeputyacademicliteratureDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveShadeputyacademicliterature(Shadeputyacademicliterature shadeputyacademicliterature);

	public Integer getSize(Integer shadbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Shadeputyacademicliterature getShadeputyacademicliterature(Integer shadal_id);

	/**
	 * @return List
	 */
	public List findShadeputyacademicliteratureAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyShadeputyacademicliterature(Shadeputyacademicliterature shadeputyacademicliterature);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeShadeputyacademicliterature(Shadeputyacademicliterature shadeputyacademicliterature);

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputyacademicliterature(Integer shadal_id);

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
	public int SaveShadeputyacademicliteratureList(List recordBeanList);

}
