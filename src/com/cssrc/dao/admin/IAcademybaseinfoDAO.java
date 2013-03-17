package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Academybaseinfo;

public interface IAcademybaseinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcademybaseinfo(Academybaseinfo academybaseinfo);

	public Integer getSize(Integer shai_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Academybaseinfo getAcademybaseinfo(Integer abi_id);

	/**
	 * @return List
	 */
	public List findAcademybaseinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcademybaseinfo(Academybaseinfo academybaseinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeAcademybaseinfo(Academybaseinfo academybaseinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademybaseinfo(Integer abi_id);

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

	public List searchlistquery(String condition, int offset, int pagesize);

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
	public int SaveAcademybaseinfoList(List recordBeanList);

	public List getlistquery(String condition, int offset, int pagesize);

	public List getSqlresult(String searchsql);

	public List getSqlresult1(String searchsql, String train);

	public List gainAcademybaseinfo(Integer abi_id);

	public boolean selectAcadName(String searchsql);

	public List selectIdandName();

	public List getSqlresult1(String searchsql);

	public List getAbi_id(Integer shai_id);
}
