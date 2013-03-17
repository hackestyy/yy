package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;

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
public class SmemberacademicliteratureDAOImpl extends HibernateDaoSupport implements ISmemberacademicliteratureDAO {
	private static final String LOAD_ALL = "from Smemberacademicliterature smemberacademicliterature order by Smemberacademicliterature.smal_id desc";

	/** default constructor */
	public SmemberacademicliteratureDAOImpl() {
	}

	public Integer getSize(Integer smbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Smemberacademicliterature where smbi_id = '" + smbi_id + "'");
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
	public boolean saveSmemberacademicliterature(Smemberacademicliterature smemberacademicliterature) {
		try {
			this.getHibernateTemplate().save(smemberacademicliterature);
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
	public Smemberacademicliterature getSmemberacademicliterature(Integer smal_id) {
		return (Smemberacademicliterature) this.getHibernateTemplate().get(Smemberacademicliterature.class, new Integer(smal_id));
	}

	/**
	 * @return List
	 */
	public List findSmemberacademicliteratureAll() {
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
	public boolean modifySmemberacademicliterature(Smemberacademicliterature smemberacademicliterature) {
		try {
			this.getHibernateTemplate().update(smemberacademicliterature);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeSmemberacademicliterature(Smemberacademicliterature smemberacademicliterature) {
		try {
			this.getHibernateTemplate().delete(smemberacademicliterature);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberacademicliterature(Integer smal_id) {
		String query = "from Smemberacademicliterature smemberacademicliterature where smemberacademicliterature.smal_id =" + "'" + smal_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberacademicliterature");
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberacademicliterature" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberacademicliterature" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Smemberacademicliterature smemberacademicliterature " + condition + " order by smal_id ", obj);
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
			result = this.getHibernateTemplate().find("from Smemberacademicliterature smemberacademicliterature " + condition + " order by smal_id ");
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
			result = this.getHibernateTemplate().find("from Smemberacademicliterature smemberacademicliterature " + condition + " order by smal_id");
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
		String query = "select * from Smemberacademicliterature";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by smal_id");
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
			result = this.getHibernateTemplate().find("from Smemberacademicliterature smemberacademicliterature" + condition, obj);
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
	public int SaveSmemberacademicliteratureList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Smemberacademicliterature bean = new Smemberacademicliterature();
				if (null == bean) {
					return 2;
				}
				if (!saveSmemberacademicliterature(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List gainSmemberacademicliterature(Integer smbi_id) {
		String query = "from Smemberacademicliterature smemberacademicliterature where smemberacademicliterature.smbi_id =" + "'" + smbi_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
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
