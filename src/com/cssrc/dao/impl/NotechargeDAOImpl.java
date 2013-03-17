package com.cssrc.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Notecharge;
import com.cssrc.dao.admin.INotechargeDAO;

public class NotechargeDAOImpl extends HibernateDaoSupport implements INotechargeDAO {
	private static final String LOAD_ALL = "from Notecharge notecharge order by notecharge.id desc";

	/** default constructor */
	public NotechargeDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveNotecharge(Notecharge notecharge) {
		try {
			this.getHibernateTemplate().save(notecharge);
			return true;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return false;
		}
	}

	/**
	 * @param String
	 *            long
	 * @return Adv
	 */
	public Notecharge getNotecharge(Integer id) {
		try {
			return (Notecharge) this.getHibernateTemplate().get(Notecharge.class, id);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * @return List
	 */
	public List findNotecharge() {
		try {
			return this.getHibernateTemplate().find(LOAD_ALL);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * @param type
	 *            user
	 * @return boolean
	 */
	public boolean modifyNotecharge(Notecharge notecharge) {
		try {
			this.getHibernateTemplate().saveOrUpdate(notecharge);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	public boolean updateNotecharge(Notecharge notecharge) {
		try {
			this.getHibernateTemplate().update(notecharge);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */

	public List findNotecharge(Integer id, String data) {
		String query = "from Notecharge notecharge where notecharge.abi_id =" + "'" + id + "' and notecharge.data='" + data + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List findNotecharge(String data) {
		String query = "from Notecharge notecharge where notecharge.data='" + data + "' order by abi_id";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

}
