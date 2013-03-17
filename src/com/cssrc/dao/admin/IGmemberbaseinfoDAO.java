package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Gmemberbaseinfo;

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
public interface IGmemberbaseinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveGmemberbaseinfo(Gmemberbaseinfo gmemberbaseinfo);

	public Integer getSize();

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Gmemberbaseinfo getGmemberbaseinfo(Integer gmbi_id);

	/**
	 * @return List
	 */
	public List findGmemberbaseinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyGmemberbaseinfo(Gmemberbaseinfo gmemberbaseinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeGmemberbaseinfo(Gmemberbaseinfo gmemberbaseinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findGmemberbaseinfo(Integer gmbi_id);

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
	public int SaveGmemberbaseinfoList(List recordBeanList);

	public boolean delete(List list);
}
