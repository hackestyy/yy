package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Shadeputyresearchproduction;
import com.cssrc.dao.admin.IShadeputyresearchproductionDAO;

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
public class ShadeputyresearchproductionDAOImpl extends HibernateDaoSupport implements IShadeputyresearchproductionDAO {
	private static final String LOAD_ALL = "from Shadeputyresearchproduction shadeputyresearchproduction order by Shadeputyresearchproduction.shadrp_id desc";

	/** default constructor */
	public ShadeputyresearchproductionDAOImpl() {
	}

	public Integer getSize(Integer shadbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyresearchproduction where shadbi_id = '" + shadbi_id + "'");
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
	public boolean saveShadeputyresearchproduction(Shadeputyresearchproduction shadeputyresearchproduction) {
		try {
			this.getHibernateTemplate().save(shadeputyresearchproduction);
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
	public Shadeputyresearchproduction getShadeputyresearchproduction(Integer shadrp_id) {
		return (Shadeputyresearchproduction) this.getHibernateTemplate().get(Shadeputyresearchproduction.class, new Integer(shadrp_id));
	}

	/**
	 * @return List
	 */
	public List findShadeputyresearchproductionAll() {
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
	public boolean modifyShadeputyresearchproduction(Shadeputyresearchproduction shadeputyresearchproduction) {
		try {
			this.getHibernateTemplate().update(shadeputyresearchproduction);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeShadeputyresearchproduction(Shadeputyresearchproduction shadeputyresearchproduction) {
		try {
			this.getHibernateTemplate().delete(shadeputyresearchproduction);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputyresearchproduction(Integer shadrp_id) {
		String query = "from Shadeputyresearchproduction shadeputyresearchproduction where shadeputyresearchproduction.shadrp_id =" + "'" + shadrp_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyresearchproduction");
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyresearchproduction" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputyresearchproduction" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Shadeputyresearchproduction shadeputyresearchproduction " + condition + " order by shadrp_id ", obj);
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
			result = this.getHibernateTemplate().find("from Shadeputyresearchproduction shadeputyresearchproduction " + condition + " order by shadrp_id ");
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
			result = this.getHibernateTemplate().find("from Shadeputyresearchproduction shadeputyresearchproduction " + condition + " order by shadrp_id");
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
		String query = "select * from Shadeputyresearchproduction";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by shadrp_id");
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
			result = this.getHibernateTemplate().find("from Shadeputyresearchproduction shadeputyresearchproduction" + condition, obj);
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
	public int SaveShadeputyresearchproductionList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Shadeputyresearchproduction bean = new Shadeputyresearchproduction();
				if (null == bean) {
					return 2;
				}
				if (!saveShadeputyresearchproduction(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

}
