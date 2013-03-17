package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Acadgroup;

/**
 * <p>
 * Title: CSSRCDB
 * </p>
 * <p>
 * Description: interface
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: CSSRC IT DIVISION
 * </p>
 * 
 * @author wujianbo
 * @version 1.0
 */
public interface IAcadgroupDAO {

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcadgroup(Acadgroup acadgroup);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Acadgroup getAcadgroup(Integer acadgroup_no);

	public Acadgroup getAcadgroupByAssoname(String assoname);

	/**
	 * @return List
	 */
	public List findAcadgroupAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcadgroup(Acadgroup acadgroup);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeAcadgroup(Acadgroup acadgroup);

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcadgroup(Integer acadgroup_no);

	/**
	 * @param condition
	 * @return List
	 */
	public Integer getSize();

	public Integer getSize(String assoname);

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
	public int SaveAcadgroupList(List recordBeanList);

	public List gainAcadgroup(String assoname);

	public List getSqlresult(String searchsql, int start, int pagesize);

	public List getSqlresultprint(String searchsql);

	public List getSqlresult1(String searchsql, String train, int start, int pagesize);

	public List gainAcadgroup(Integer shai_id);

	public List list();

	public List SearchGmember(String searchsql);

	public int getallonum(String searchsql);
}
