package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Academyorganizationinfo;

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
public interface IAcademyorganizationinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcademyorganizationinfo(Academyorganizationinfo academyorganizationinfo);

	public Integer getSize(Integer abi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Academyorganizationinfo getAcademyorganizationinfo(Integer aoi_id);

	/**
	 * @return List
	 */
	public List findAcademyorganizationinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcademyorganizationinfo(Academyorganizationinfo academyorganizationinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeAcademyorganizationinfo(Academyorganizationinfo academyorganizationinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademyorganizationinfo(Integer aoi_id);

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
	public int SaveAcademyorganizationinfoList(List recordBeanList);

}
