package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Shadeputybaseinfo;

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
public interface IShadeputybaseinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveShadeputybaseinfo(Shadeputybaseinfo shadeputybaseinfo);

	public Integer getSize(String assoduty_s);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Shadeputybaseinfo getShadeputybaseinfo(Integer shadbi_id);

	/**
	 * @return List
	 */
	public List findShadeputybaseinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyShadeputybaseinfo(Shadeputybaseinfo shadeputybaseinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeShadeputybaseinfo(Shadeputybaseinfo shadeputybaseinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputybaseinfo(Integer shadbi_id);

	/**
	 * @param condition
	 * @return List
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
	public int SaveShadeputybaseinfoList(List recordBeanList);

	public List gainShadeputybaseinfo(String deputyidentity);

	public List getlist(String condition, int offset, int pagesize);

	public Integer getRnum();

	public List getSqlresult(String searchsql);

	public List findshadbi_idByDeputyNO(String deputyno);

	public List gainDeputybaseinfo(String one, String two, String three, String four, String five);

	public List findShadeputybaseinfobymemno(String memno);
}
