package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;

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
public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {
	private static final String LOAD_ALL = "from User user order by user.userid desc";

	/** default constructor */
	public UserDAOImpl() {
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveUser(User user) {
		try {
			this.getHibernateTemplate().saveOrUpdate(user);
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
	public User getUser(String userid) {
		return (User) this.getHibernateTemplate().get(User.class, new String(userid));
	}

	public User getUser(Integer ui_id) {
		return (User) this.getHibernateTemplate().get(User.class, new Integer(ui_id));
	}

	/**
	 * @return List
	 */
	public List findUserAll() {
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
	public boolean modifyUser(User user) {
		try {
			this.getHibernateTemplate().update(user);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeUser(User user) {
		try {
			this.getHibernateTemplate().delete(user);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findUser(String user_name) {
		String query = "from User user where user.useraccount =" + "'" + user_name + "'";
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
			result = this.getHibernateTemplate().find("from User user " + condition);
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
			result = this.getHibernateTemplate().find("from User user " + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from User");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public Integer getSize1(String userrole) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from User where userrole = '" + userrole + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	/**
	 * @param userid
	 *            String,password String
	 * @return boolean
	 */
	public boolean isValidUser(String user_name, String user_password) {
		try {
			String condition = "from User user where useraccount = '" + user_name + "' and userpwd = '" + user_password + "'";
			List result = this.getHibernateTemplate().find(condition);
			if (result.size() > 0) {
				return true;
			}
		} catch (DataAccessException e) {
		}
		return false;
	}

	public List listAssoName() {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select assoname from Shassociationinfo");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List listAcadName() {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select acadname from Academybaseinfo");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List listAccount() {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select useraccount from User");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public int checkusername(String username) {
		try {
			List result = this.getHibernateTemplate().find("select useraccount from User where useraccount = '" + username + "'");
			if (result.size() > 0) {
				return 1;
			}
		} catch (DataAccessException ex) {
			return 2;
		}
		return 3;
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
