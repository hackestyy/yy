package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Stemp;

public interface IStempDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveStemp(Stemp stemp);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Stemp getStemp(Integer smbi_id);

	/**
	 * @return List
	 */
	public List findStempAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyStemp(Stemp stemp);

	public boolean updateStemp(Stemp stemp);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	public List findStemp(String smbi_id);

}
