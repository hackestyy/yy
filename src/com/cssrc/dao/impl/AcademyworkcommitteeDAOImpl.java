package com.cssrc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Academyworkcommittee;
import com.cssrc.dao.admin.IAcademyworkcommitteeDAO;

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
public class AcademyworkcommitteeDAOImpl extends HibernateDaoSupport implements IAcademyworkcommitteeDAO {
	private static final String LOAD_ALL = "from Academyworkcommittee academyworkcommittee order by Academyworkcommittee.awc_id desc";

	/** default constructor */
	public AcademyworkcommitteeDAOImpl() {
	}

	public Integer getSize(Integer abi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academyworkcommittee where abi_id = '" + abi_id + "'");
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
	public boolean saveAcademyworkcommittee(Academyworkcommittee academyworkcommittee) {
		try {
			this.getHibernateTemplate().save(academyworkcommittee);
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
	public Academyworkcommittee getAcademyworkcommittee(Integer awc_id) {
		return (Academyworkcommittee) this.getHibernateTemplate().get(Academyworkcommittee.class, new Integer(awc_id));
	}

	/**
	 * @return List
	 */
	public List findAcademyworkcommitteeAll() {
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
	public boolean modifyAcademyworkcommittee(Academyworkcommittee academyworkcommittee) {
		try {
			this.getHibernateTemplate().update(academyworkcommittee);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeAcademyworkcommittee(Academyworkcommittee academyworkcommittee) {
		try {
			this.getHibernateTemplate().delete(academyworkcommittee);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademyworkcommittee(Integer awc_id) {
		String query = "from Academyworkcommittee academyworkcommittee where Academyworkcommittee.awc_id =" + "'" + awc_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Academyworkcommittee");
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
			List result = this.getHibernateTemplate().find("select count(*) from Academyworkcommittee" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Academyworkcommittee" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Academyworkcommittee academyworkcommittee " + condition + " order by awc_id ", obj);
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
			result = this.getHibernateTemplate().find("from Academyworkcommittee academyworkcommittee " + condition + " order by awc_id ");
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
			result = this.getHibernateTemplate().find("from Academyworkcommittee academyworkcommittee " + condition + " order by awc_id");
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
		String query = "select * from Academyworkcommittee";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by awc_id");
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
			result = this.getHibernateTemplate().find("from Academyworkcommittee academyworkcommittee" + condition, obj);
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
	public int SaveAcademyworkcommitteeList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Academyworkcommittee bean = new Academyworkcommittee();
				if (null == bean) {
					return 2;
				}
				if (!saveAcademyworkcommittee(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

}
