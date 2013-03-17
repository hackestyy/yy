package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Acadecustom;

public interface IAcadecustomDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveAcadecustom(Acadecustom acadecustom);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Acadecustom getAcadecustom(Integer smbi_id);

	/**
	 * @return List
	 */
	public List findAcadecustomAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyAcadecustom(Acadecustom academybaseinfo);

	public boolean updateAcadecustom(Acadecustom academybaseinfo);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	public List findAcadecustom(Integer smbi_id);

	public List findbyabiid(Integer abiid);

}
