package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.bean.admin.Smemberbaseinfo;

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
public interface ISmemberbaseinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveSmemberbaseinfo(Smemberbaseinfo smemberbaseinfo);

	public Integer getSize(String assoduty_s);

	public Integer getSize();

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Smemberbaseinfo getSmemberbaseinfo(Integer smbi_id);

	/**
	 * @return List
	 */
	public List findSmemberbaseinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifySmemberbaseinfo(Smemberbaseinfo smemberbaseinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeSmemberbaseinfo(Smemberbaseinfo smemberbaseinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberbaseinfo(Integer smbi_id);

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

	public List leftlist(String condition);

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize, Object[] obj);

	/**
	 * @param userid
	 *            String,password String
	 * @return boolean
	 */
	public int SaveSmemberbaseinfoList(List recordBeanList);

	public List gainSmemberbaseinfo(String one, String two, String three, String four, String five);

	public List gainSmemberbaseinfolist(String memno);

	public List getlist(String condition, int offset, int pagesize);

	public List getSqlresult(String searchsql);

	public List getSqlresult1(String searchsql, String train);

	public Integer getRnum();

	public boolean isValidUser(String user_name, String user_password);

	public boolean updateSmemberbaseinfo(Smemberbaseinfo smemberbaseinfo);

	public int listmemno(String memno);

	public int listmemno_userinfotable(String memno);

	public List findsmbi_id_Bymemno(String memno);

	public boolean delete(List list);

	public boolean modifymemno(String memno, Integer id);

	public Smemberbainforelation getSqlresult2(Integer train, Integer abi_id);
}
