package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Academyspecialitycommittee;

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
public interface IAcademyspecialitycommitteeDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcademyspecialitycommittee(Academyspecialitycommittee academyspecialitycommittee);

	public Integer getSize(Integer abi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Academyspecialitycommittee getAcademyspecialitycommittee(Integer asc_id);

	/**
	 * @return List
	 */
	public List findAcademyspecialitycommitteeAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcademyspecialitycommittee(Academyspecialitycommittee academyspecialitycommittee);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeAcademyspecialitycommittee(Academyspecialitycommittee academyspecialitycommittee);

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademyspecialitycommittee(Integer asc_id);

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
	public int SaveAcademyspecialitycommitteeList(List recordBeanList);

}
