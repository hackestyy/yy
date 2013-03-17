package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Academygmemberrelation;

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
public interface IAcademygmemberrelationDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcademygmemberrelation(Academygmemberrelation academygmemberrelation);

	public Integer getSize(Integer abi_id);

	public Integer getSizeByabi_idAndisdelete(Integer abi_id, String isdelete);

	public Integer getSize1(Integer gmbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Academygmemberrelation getAcademygmemberrelation(Integer agmr_id);

	/**
	 * @return List
	 */
	public List findAcademygmemberrelationAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcademygmemberrelation(Academygmemberrelation academygmemberrelation);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeAcademygmemberrelation(Academygmemberrelation academygmemberrelation);

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademygmemberrelation(Integer agmr_id);

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
	public int SaveAcademygmemberrelationList(List recordBeanList);

	public List gainAcademysmemberrelation(Integer agmr_id);
}
