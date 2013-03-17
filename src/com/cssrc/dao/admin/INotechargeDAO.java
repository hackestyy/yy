package com.cssrc.dao.admin;

import java.util.List;

import com.cssrc.bean.admin.Notecharge;

public interface INotechargeDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean saveNotecharge(Notecharge notecharge);

	/**
	 * @param id
	 *            long
	 * @return User
	 */
	public Notecharge getNotecharge(Integer id);

	/**
	 * @return List
	 */
	public List findNotecharge();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */
	public boolean modifyNotecharge(Notecharge notecharge);

	public boolean updateNotecharge(Notecharge notecharge);

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	public List findNotecharge(Integer id, String data);

	public List findNotecharge(String data);

}
