package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Shadeputypastjob;

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
public interface IShadeputypastjobDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveShadeputypastjob(Shadeputypastjob shadeputypastjob);

	public Integer getSize(Integer shadbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Shadeputypastjob getShadeputypastjob(Integer shadpj_id);

	/**
	 * @return List
	 */
	public List findShadeputypastjobAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyShadeputypastjob(Shadeputypastjob shadeputypastjob);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeShadeputypastjob(Shadeputypastjob shadeputypastjob);

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputypastjob(Integer shadpj_id);

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
	public int SaveShadeputypastjobList(List recordBeanList);

}
