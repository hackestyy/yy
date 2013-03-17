package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Gmemberpatentinfo;

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
public interface IGmemberpatentinfoDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveGmemberpatentinfo(Gmemberpatentinfo gmemberpatentinfo);

	public Integer getSize(Integer gmbi_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Gmemberpatentinfo getGmemberpatentinfo(Integer gmpi_id);

	/**
	 * @return List
	 */
	public List findGmemberpatentinfoAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyGmemberpatentinfo(Gmemberpatentinfo gmemberpatentinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean removeGmemberpatentinfo(Gmemberpatentinfo gmemberpatentinfo);

	/**
	 * @param userid
	 * @return List
	 */
	public List findGmemberpatentinfo(Integer gmpi_id);

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
	public int SaveGmemberpatentinfoList(List recordBeanList);

	public boolean delete(List list);
}
