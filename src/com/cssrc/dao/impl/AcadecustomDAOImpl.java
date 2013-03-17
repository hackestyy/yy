package com.cssrc.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Acadecustom;
import com.cssrc.dao.admin.IAcadecustomDAO;

public class AcadecustomDAOImpl extends HibernateDaoSupport implements IAcadecustomDAO {
	private static final String LOAD_ALL = "from Academybaseinfo academybaseinfo order by Academybaseinfo.abi_id desc";

	/** default constructor */
	public AcadecustomDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveAcadecustom(Acadecustom acadecustom) {
		try {
			this.getHibernateTemplate().save(acadecustom);
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
	public Acadecustom getAcadecustom(Integer smbi_id) {
		try {
			return (Acadecustom) this.getHibernateTemplate().get(Acadecustom.class, smbi_id);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * @return List
	 */
	public List findAcadecustomAll() {
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
	public boolean modifyAcadecustom(Acadecustom acadecustom) {
		try {
			this.getHibernateTemplate().saveOrUpdate(acadecustom);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	public boolean updateAcadecustom(Acadecustom acadecustom) {
		try {
			this.getHibernateTemplate().update(acadecustom);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */

	public List findAcadecustom(Integer smbi_id) {
		String query = "from Acadecustom acadecustom where acadecustom.smbi_id =" + "'" + smbi_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List findbyabiid(Integer abiid) {
		String query = "from Acadecustom where abi_id = " + abiid + " order by abino";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	/**
	 * @param condition
	 * @return List
	 */

}
