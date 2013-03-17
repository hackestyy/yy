package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.OnlineCtrl;
import com.cssrc.dao.IOnlineCtrlDAO;

/**
 * <p>
 * Title: CSSRCDB
 * </p>
 * <p>
 * Description: Implement of interface
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: CSSRC IT DIVISION
 * </p>
 * 
 * @author wujianbo
 * @version 1.0
 */
public class OnlineCtrlDAOImpl extends HibernateDaoSupport implements IOnlineCtrlDAO {
	private static final String LOAD_ALL = "from OnlineCtrl onlinectrl order by onlinectrl.no desc";

	/** default constructor */
	public OnlineCtrlDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveOnlineCtrl(OnlineCtrl onlinectrl) {
		try {
			this.getHibernateTemplate().saveOrUpdate(onlinectrl);
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

	public OnlineCtrl getOnlineCtrl(Integer no) {

		return (OnlineCtrl) this.getHibernateTemplate().get(OnlineCtrl.class, new Integer(no));
	}

	/**
	 * @param type
	 *            user
	 * @return boolean
	 */
	public boolean modifyOnlineCtrl(OnlineCtrl onlinectrl) {
		try {
			this.getHibernateTemplate().update(onlinectrl);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeOnlineCtrl(OnlineCtrl onlinectrl) {
		try {
			this.getHibernateTemplate().delete(onlinectrl);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */

	public List list(String condition) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from OnlineCtrl onlinectrl " + condition);
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List findOnlieCtrl(Integer no) {
		String query = "from OnlineCtrl onlinectrl where onlinectrl.no =" + no;
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from OnlineCtrl onlinectrl " + condition);
			if (result.size() >= offset + pagesize) {
				return result.subList(offset, offset + pagesize);
			} else {
				return result.subList(offset, result.size());
			}
		} catch (DataAccessException xe) {
			xe.toString();
			return result;
		}
	}

	public List getsqlresult(String sql, Object[] obj) {
		List result = new ArrayList();
		try {
			if ("".equals(sql))
				obj = null;
			if (obj.equals(null)) {
				result = this.getHibernateTemplate().find(sql);
			} else {
				result = this.getHibernateTemplate().find(sql, obj);
			}
			return result;
		} catch (DataAccessException xe) {
			xe.toString();
			return result;
		}
	}
}
