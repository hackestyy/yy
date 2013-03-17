package com.cssrc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Shadeputylistinfo;
import com.cssrc.bean.admin.Smemberdeputyinfo;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;

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
public class SmemberdeputyinfoDAOImpl extends HibernateDaoSupport implements ISmemberdeputyinfoDAO {
	private static final String LOAD_ALL = "from Smemberdeputyinfo smemberdeputyinfo order by Smemberdeputyinfo.smdi_id desc";

	/** default constructor */
	public SmemberdeputyinfoDAOImpl() {
	}

	public Integer getSize(Integer smbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Smemberdeputyinfo where smbi_id = '" + smbi_id + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public Integer getSize(String assoduty_s, String queryString) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Smemberdeputyinfo where assoduty_s = '" + assoduty_s + "' and assoduty_f in " + queryString);
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
	public boolean saveSmemberdeputyinfo(Smemberdeputyinfo smemberdeputyinfo) {
		try {
			this.getHibernateTemplate().save(smemberdeputyinfo);
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
	public Smemberdeputyinfo getSmemberdeputyinfo(Integer smdi_id) {
		return (Smemberdeputyinfo) this.getHibernateTemplate().get(Smemberdeputyinfo.class, new Integer(smdi_id));
	}

	/**
	 * @return List
	 */
	public List findSmemberdeputyinfoAll() {
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
	public boolean modifySmemberdeputyinfo(Smemberdeputyinfo smemberdeputyinfo) {
		try {
			this.getHibernateTemplate().update(smemberdeputyinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeSmemberdeputyinfo(Smemberdeputyinfo smemberdeputyinfo) {
		try {
			this.getHibernateTemplate().delete(smemberdeputyinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberdeputyinfo(Integer smdi_id) {
		String query = "from Smemberdeputyinfo smemberdeputyinfo where smemberdeputyinfo.smdi_id =" + "'" + smdi_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberdeputyinfo");
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberdeputyinfo" + condition);
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
			if (condition.equals("")) {
				obj = null;
			}
			List result = this.getHibernateTemplate().find("select count(*) from Smemberdeputyinfo" + condition, obj);
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
			if (condition.equals("")) {
				obj = null;
			}
			result = this.getHibernateTemplate().find("from Smemberdeputyinfo smemberdeputyinfo " + condition + " order by smdi_id ", obj);
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
			result = this.getHibernateTemplate().find("from Smemberdeputyinfo smemberdeputyinfo " + condition + " order by smdi_id ");
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
			result = this.getHibernateTemplate().find("from Smemberdeputyinfo smemberdeputyinfo " + condition + " order by smdi_id");
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
		String query = "select * from Smemberdeputyinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by smdi_id");
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
			if ("".equals(condition)) {
				obj = null;
			}
			result = this.getHibernateTemplate().find("from Smemberdeputyinfo smemberdeputyinfo" + condition, obj);
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
	public int SaveSmemberdeputyinfoList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Smemberdeputyinfo bean = new Smemberdeputyinfo();
				if (null == bean) {
					return 2;
				}
				if (!saveSmemberdeputyinfo(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List getSqlresult(String condition) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = "select distinct smbi_id, memno, memname, memsex, meminstitute, institutetelephone from v_searchdbwy " + condition;
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {

				Shadeputylistinfo bean = new Shadeputylistinfo();
				bean.setBaseinfo_id((Integer) rs.getInt("smbi_id"));
				bean.setDeputyno((String) rs.getString("memno"));
				bean.setDeputyname((String) rs.getString("memname"));
				bean.setDeputysex((String) rs.getString("memsex"));
				bean.setDeputyinstitute((String) rs.getString("meminstitute"));
				bean.setDeputytelephone((String) rs.getString("institutetelephone"));
				// bean.setIsdelete((String)rs.getString("isdelete"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
			rs = null;
			stmt = null;
			return list;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}
	}

	public List findSmemberdeputyinfoList(Integer smbi_id) {
		String query = "from Smemberdeputyinfo smemberdeputyinfo where smemberdeputyinfo.smbi_id =" + "'" + smbi_id + "'";
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
