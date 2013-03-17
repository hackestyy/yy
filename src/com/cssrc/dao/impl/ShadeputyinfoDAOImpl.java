package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Shadeputyinfo;
import com.cssrc.dao.admin.IShadeputyinfoDAO;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class ShadeputyinfoDAOImpl extends HibernateDaoSupport implements IShadeputyinfoDAO {
	private static final String LOAD_ALL = "from Shadeputyinfo shadeputyinfo order by Shadeputyinfo.shadi_id desc";

	/** default constructor */
	public ShadeputyinfoDAOImpl() {
	}

	public Integer getSize(Integer shadbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyinfo where shadbi_id = '" + shadbi_id + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public Integer getSize(String assoduty_s, String queryString) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyinfo where assoduty_s = '" + assoduty_s + "' and assoduty_f in " + queryString);
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	/**
	 * @param adv
	 *            Adv
	 * @return Adv
	 */
	public boolean saveShadeputyinfo(Shadeputyinfo shadeputyinfo) {
		try {
			this.getHibernateTemplate().save(shadeputyinfo);
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
	public Shadeputyinfo getShadeputyinfo(Integer shadi_id) {
		return (Shadeputyinfo) this.getHibernateTemplate().get(Shadeputyinfo.class, new Integer(shadi_id));
	}

	/**
	 * @return List
	 */
	public List findShadeputyinfoAll() {
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
	public boolean modifyShadeputyinfo(Shadeputyinfo shadeputyinfo) {
		try {
			this.getHibernateTemplate().update(shadeputyinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeShadeputyinfo(Shadeputyinfo shadeputyinfo) {
		try {
			this.getHibernateTemplate().delete(shadeputyinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputyinfo(Integer shadi_id) {
		String query = "from Shadeputyinfo shadeputyinfo where shadeputyinfo.shadi_id =" + "'" + shadi_id + "'";
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
	public Integer getSize() {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyinfo");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	/**
	 * @param
	 * @return int
	 */
	public Integer getquerySize(String condition) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyinfo" + condition);
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	/**
	 * @param
	 * @return int
	 */
	public Integer getquerySize(String condition, Object[] obj) {
		try {
			if (condition.equals(""))
				obj = null;
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyinfo" + condition, obj);
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition, Object[] obj) {

		List result = new ArrayList();
		try {
			if (condition.equals(""))
				obj = null;
			result = this.getHibernateTemplate().find("from Shadeputyinfo shadeputyinfo " + condition + " order by shadi_id ", obj);
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from Shadeputyinfo shadeputyinfo " + condition + " order by shadi_id ");
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
			result = this.getHibernateTemplate().find("from Shadeputyinfo shadeputyinfo " + condition + " order by shadi_id");
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

	public List listquery(String condition, int offset, int pagesize) {
		List result = new ArrayList();
		String query = "select * from Shadeputyinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by shadi_id");
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
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize, Object[] obj) {
		List result = new ArrayList();
		try {
			if ("".equals(condition))
				obj = null;
			result = this.getHibernateTemplate().find("from Shadeputyinfo shadeputyinfo" + condition, obj);
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
	 *            String,password String
	 * @return boolean
	 */
	public int SaveShadeputyinfoList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Shadeputyinfo bean = new Shadeputyinfo();
				if (null == bean) {
					return 2;
				}
				if (!saveShadeputyinfo(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

}
