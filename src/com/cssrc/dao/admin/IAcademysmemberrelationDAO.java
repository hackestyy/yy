package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Academysmemberrelation;

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
public interface IAcademysmemberrelationDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcademysmemberrelation(Academysmemberrelation academysmemberrelation);

	public Integer getSize(Integer abi_id);

	public Integer getSizeByabi_idAndisdelete(Integer abi_id, String isdelete);

	public Integer getSize1(Integer smbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Academysmemberrelation getAcademysmemberrelation(Integer asmr_id);

	/**
	 * @return List
	 */
	public List findAcademysmemberrelationAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcademysmemberrelation(Academysmemberrelation academysmemberrelation);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeAcademysmemberrelation(Academysmemberrelation academysmemberrelation);

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademysmemberrelation(Integer asmr_id);

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

	public List alllist(String condition);

	public List distinctlist(String condition);

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
	public int SaveAcademysmemberrelationList(List recordBeanList);

	public List gainAcademysmemberrelation(Integer smbi_id);

	public List fetchAcademysmemberrelation(Integer abi_id);

	public List listquery(String condition);

	public List listrelation(String condition);

	public List getsqlresult(Integer abi_id, int offset, int pagesize);
	
	public List getsqlresult(Integer abi_id, int offset, int pagesize,String train);

	public List gainAcademysmemberrelaNODEL(Integer smbi_id);

	public List getsqlresultall(Integer abi_id);

	public boolean delete(List list);

	public int getallonum(Integer abi_id);
}
