package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Shadeputyacademicliterature;
import com.cssrc.dao.admin.IShadeputyacademicliteratureDAO;

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
public class ShadeputyacademicliteratureDAOImpl extends HibernateDaoSupport implements IShadeputyacademicliteratureDAO {
	private static final String LOAD_ALL = "from Shadeputyacademicliterature shadeputyacademicliterature order by Shadeputyacademicliterature.shadal_id desc";

	/** default constructor */
	public ShadeputyacademicliteratureDAOImpl() {
	}

	public Integer getSize(Integer shadbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyacademicliterature where shadbi_id = '" + shadbi_id + "'");
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
	public boolean saveShadeputyacademicliterature(Shadeputyacademicliterature shadeputyacademicliterature) {
		try {
			this.getHibernateTemplate().save(shadeputyacademicliterature);
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
	public Shadeputyacademicliterature getShadeputyacademicliterature(Integer shadal_id) {
		return (Shadeputyacademicliterature) this.getHibernateTemplate().get(Shadeputyacademicliterature.class, new Integer(shadal_id));
	}

	/**
	 * @return List
	 */
	public List findShadeputyacademicliteratureAll() {
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
	public boolean modifyShadeputyacademicliterature(Shadeputyacademicliterature shadeputyacademicliterature) {
		try {
			this.getHibernateTemplate().update(shadeputyacademicliterature);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeShadeputyacademicliterature(Shadeputyacademicliterature shadeputyacademicliterature) {
		try {
			this.getHibernateTemplate().delete(shadeputyacademicliterature);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputyacademicliterature(Integer shadal_id) {
		String query = "from Shadeputyacademicliterature shadeputyacademicliterature where shadeputyacademicliterature.shadal_id =" + "'" + shadal_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyacademicliterature");
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyacademicliterature" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyacademicliterature" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Shadeputyacademicliterature shadeputyacademicliterature " + condition + " order by shadal_id ", obj);
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
			result = this.getHibernateTemplate().find("from Shadeputyacademicliterature shadeputyacademicliterature " + condition + " order by shadal_id ");
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
			result = this.getHibernateTemplate().find("from Shadeputyacademicliterature shadeputyacademicliterature " + condition + " order by shadal_id");
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
		String query = "select * from Shadeputyacademicliterature";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by shadal_id");
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
			result = this.getHibernateTemplate().find("from Shadeputyacademicliterature shadeputyacademicliterature" + condition, obj);
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
	public int SaveShadeputyacademicliteratureList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Shadeputyacademicliterature bean = new Shadeputyacademicliterature();
				if (null == bean) {
					return 2;
				}
				if (!saveShadeputyacademicliterature(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

}
