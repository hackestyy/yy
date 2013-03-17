package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;

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
public class AcademygmemberrelationDAOImpl extends HibernateDaoSupport implements IAcademygmemberrelationDAO {
	private static final String LOAD_ALL = "from Academygmemberrelation academygmemberrelation order by Academygmemberrelation.agmr_id desc";

	/** default constructor */
	public AcademygmemberrelationDAOImpl() {
	}

	public Integer getSize(Integer abi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academygmemberrelation where abi_id = '" + abi_id + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public Integer getSizeByabi_idAndisdelete(Integer abi_id, String isdelete) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academygmemberrelation where abi_id = '" + abi_id + "'+ and isdelete= '" + isdelete + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}

	}

	public Integer getSize1(Integer gmbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academygmemberrelation where gmbi_id = '" + gmbi_id + "'");
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
	public boolean saveAcademygmemberrelation(Academygmemberrelation academygmemberrelation) {
		try {
			this.getHibernateTemplate().save(academygmemberrelation);
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
	public Academygmemberrelation getAcademygmemberrelation(Integer agmr_id) {
		return (Academygmemberrelation) this.getHibernateTemplate().get(Academygmemberrelation.class, new Integer(agmr_id));
	}

	/**
	 * @return List
	 */
	public List findAcademygmemberrelationAll() {
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
	public boolean modifyAcademygmemberrelation(Academygmemberrelation academygmemberrelation) {
		try {
			this.getHibernateTemplate().update(academygmemberrelation);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeAcademygmemberrelation(Academygmemberrelation academygmemberrelation) {
		try {
			this.getHibernateTemplate().delete(academygmemberrelation);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademygmemberrelation(Integer agmr_id) {
		String query = "from Academygmemberrelation academygmemberrelation where academygmemberrelation.agmr_id =" + "'" + agmr_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Academygmemberrelation");
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
			List result = this.getHibernateTemplate().find("select count(*) from Academygmemberrelation" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Academygmemberrelation" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Academygmemberrelation academygmemberrelation " + condition + " order by agmr_id ", obj);
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
			result = this.getHibernateTemplate().find("from Academygmemberrelation academygmemberrelation " + condition + " order by agmr_id ");
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
			result = this.getHibernateTemplate().find("from Academygmemberrelation academygmemberrelation " + condition + " order by agmr_id");
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
		String query = "select * from Academygmemberrelation";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by agmr_id");
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
			result = this.getHibernateTemplate().find("from Academygmemberrelation academygmemberrelation" + condition, obj);
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
	public int SaveAcademygmemberrelationList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Academygmemberrelation bean = new Academygmemberrelation();
				if (null == bean) {
					return 2;
				}
				if (!saveAcademygmemberrelation(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List gainAcademysmemberrelation(Integer agmr_id) {
		String query = "from Academysmemberrelation academysmemberrelation where academysmemberrelation.agmr_id =" + "'" + agmr_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

}
