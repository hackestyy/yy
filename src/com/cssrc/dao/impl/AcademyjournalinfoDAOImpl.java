package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Academyjournalinfo;
import com.cssrc.dao.admin.IAcademyjournalinfoDAO;

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
public class AcademyjournalinfoDAOImpl extends HibernateDaoSupport implements IAcademyjournalinfoDAO {
	private static final String LOAD_ALL = "from Academyjournalinfo academyjournalinfo order by Academyjournalinfo.aji_id desc";

	/** default constructor */
	public AcademyjournalinfoDAOImpl() {
	}

	public Integer getSize(Integer abi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academyjournalinfo where abi_id = '" + abi_id + "'");
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
	public boolean saveAcademyjournalinfo(Academyjournalinfo academyjournalinfo) {
		try {
			this.getHibernateTemplate().save(academyjournalinfo);
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
	public Academyjournalinfo getAcademyjournalinfo(Integer aji_id) {
		return (Academyjournalinfo) this.getHibernateTemplate().get(Academyjournalinfo.class, new Integer(aji_id));
	}

	/**
	 * @return List
	 */
	public List findAcademyjournalinfoAll() {
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
	public boolean modifyAcademyjournalinfo(Academyjournalinfo academyjournalinfo) {
		try {
			this.getHibernateTemplate().update(academyjournalinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeAcademyjournalinfo(Academyjournalinfo academyjournalinfo) {
		try {
			this.getHibernateTemplate().delete(academyjournalinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademyjournalinfo(Integer aji_id) {
		String query = "from Academyjournalinfo academyjournalinfo where academyjournalinfo.aji_id =" + "'" + aji_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Academyjournalinfo");
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
			List result = this.getHibernateTemplate().find("select count(*) from Academyjournalinfo" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Academyjournalinfo" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Academyjournalinfo academyjournalinfo " + condition + " order by aji_id ", obj);
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
			result = this.getHibernateTemplate().find("from Academyjournalinfo academyjournalinfo " + condition + " order by aji_id ");
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
			result = this.getHibernateTemplate().find("from Academyjournalinfo academyjournalinfo " + condition + " order by aji_id");
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
		String query = "select * from Academyjournalinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by aji_id");
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
			result = this.getHibernateTemplate().find("from Academyjournalinfo academyjournalinfo" + condition, obj);
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
	public int SaveAcademyjournalinfoList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Academyjournalinfo bean = new Academyjournalinfo();
				if (null == bean) {
					return 2;
				}
				if (!saveAcademyjournalinfo(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

}
