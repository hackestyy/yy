package com.cssrc.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Stemp;
import com.cssrc.dao.admin.IStempDAO;

public class StempDAOImpl extends HibernateDaoSupport implements IStempDAO {
	private static final String LOAD_ALL = "from Stemp stemp order by Stemp.id desc";

	/** default constructor */
	public StempDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveStemp(Stemp stemp) {
		try {
			this.getHibernateTemplate().save(stemp);
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
	public Stemp getStemp(Integer smbi_id) {
		try {
			return (Stemp) this.getHibernateTemplate().get(Stemp.class, smbi_id);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * @return List
	 */
	public List findStempAll() {
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
	public boolean modifyStemp(Stemp stemp) {
		try {
			this.getHibernateTemplate().saveOrUpdate(stemp);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	public boolean updateStemp(Stemp stemp) {
		try {
			this.getHibernateTemplate().update(stemp);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */

	public List findStemp(String username) {
		String query = "from Stemp stemp where stemp.username =" + "'" + username + "'";
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
