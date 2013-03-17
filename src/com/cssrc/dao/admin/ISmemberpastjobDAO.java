package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Smemberpastjob;

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
public interface ISmemberpastjobDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveSmemberpastjob(Smemberpastjob smemberpastjob);

	public Integer getSize(Integer smbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Smemberpastjob getSmemberpastjob(Integer smpj_id);

	/**
	 * @return List
	 */
	public List findSmemberpastjobAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifySmemberpastjob(Smemberpastjob smemberpastjob);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeSmemberpastjob(Smemberpastjob smemberpastjob);

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberpastjob(Integer smpj_id);

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
	public int SaveSmemberpastjobList(List recordBeanList);

	public List gainSmemberpastjob(Integer smbi_id);

	public boolean delete(List list);

}
