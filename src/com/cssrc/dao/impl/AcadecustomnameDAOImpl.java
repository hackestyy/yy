package com.cssrc.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Acadecustomname;
import com.cssrc.dao.admin.IAcadecustomnameDAO;

public class AcadecustomnameDAOImpl extends HibernateDaoSupport implements IAcadecustomnameDAO {
	private static final String LOAD_ALL = "from Academybaseinfo academybaseinfo order by Academybaseinfo.abi_id desc";

	/** default constructor */
	public AcadecustomnameDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveAcadecustomname(Acadecustomname acadecustomname) {
		try {
			this.getHibernateTemplate().save(acadecustomname);
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
	public Acadecustomname getAcadecustomname(Integer abi_id) {
		try {
			return (Acadecustomname) this.getHibernateTemplate().get(Acadecustomname.class, abi_id);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * @return List
	 */
	public List findAcadecustomnameAll() {
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
	public boolean modifyAcadecustomname(Acadecustomname acadecustomname) {
		try {
			this.getHibernateTemplate().saveOrUpdate(acadecustomname);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */

	public List findAcadecustomname(Integer abi_id) {
		String query = "from Acadecustomname acadecustomname where acadecustomname.abi_id =" + "'" + abi_id + "'";
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
