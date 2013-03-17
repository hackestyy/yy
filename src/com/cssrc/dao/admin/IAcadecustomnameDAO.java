package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Acadecustomname;

public interface IAcadecustomnameDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcadecustomname(Acadecustomname acadecustomname);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Acadecustomname getAcadecustomname(Integer abi_id);

	/**
	 * @return List
	 */
	public List findAcadecustomnameAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcadecustomname(Acadecustomname academybaseinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	public List findAcadecustomname(Integer abi_id);

}
