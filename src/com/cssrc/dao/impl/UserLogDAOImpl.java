package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.admin.IUserLogDAO;

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
public class UserLogDAOImpl extends HibernateDaoSupport implements IUserLogDAO {
	private static final String LOAD_ALL = "from UserLog userlog order by user.no desc";
	private static final Log log = LogFactory.getLog(UserLogDAOImpl.class);

	/** default constructor */
	public UserLogDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveUserLog(UserLog userlog) {
		try {
			this.getHibernateTemplate().save(userlog);
			return true;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return false;
		}
	}

	public UserLog getUserLog(Integer no) {
		return (UserLog) this.getHibernateTemplate().get(UserLog.class, new Integer(no));
	}

	/**
	 * @return List
	 */
	public List findUserLogAll() {
		try {
			return this.getHibernateTemplate().find(LOAD_ALL);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeUserLog(UserLog userlog) {
		try {
			this.getHibernateTemplate().delete(userlog);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findUserLog(String name) {
		String query = "from userlog userlog where userlog.name =" + "'" + name + "' order by time";
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
	public List list(String condition) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from UserLog userlog " + condition);
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from UserLog userlog " + condition);
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

	/**
	 * @param userid
	 * @return List
	 */
	public Integer getSize() {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from UserLog");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public Integer getSize1(String userrole) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from UserLog where userrole = '" + userrole + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
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

	public List findAll() {
		log.debug("finding all UserLog instances order by time " + "desc");
		try {
			String queryString = "from UserLog order by time desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public boolean delete(List list) {
		try {
			this.getHibernateTemplate().deleteAll(list);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return false;
		}
		return true;
	}

}
