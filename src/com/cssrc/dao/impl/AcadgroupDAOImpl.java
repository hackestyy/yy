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

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.bean.admin.Gmemberbaseinforelation;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IAcadgroupDAO;

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
public class AcadgroupDAOImpl extends HibernateDaoSupport implements IAcadgroupDAO {
	private static final String LOAD_ALL = "from Acadgroup acadgroup order by acadgroup.acadgroup_no desc";

	/** default constructor */
	public AcadgroupDAOImpl() {
	}

	public Integer getSize(String assoname) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Acadgroup where assoname = '" + assoname + "'");
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
	public boolean saveAcadgroup(Acadgroup acadgroup) {
		try {
			this.getHibernateTemplate().save(acadgroup);
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
	public Acadgroup getAcadgroup(Integer acadgroup_no) {
		return (Acadgroup) this.getHibernateTemplate().get(Acadgroup.class, new Integer(acadgroup_no));
	}

	public Acadgroup getAcadgroupByAssoname(String assoname) {
		return (Acadgroup) this.getHibernateTemplate().get(Acadgroup.class, new String(assoname));
	}

	/**
	 * @return List
	 */
	public List findAcadgroupAll() {
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
	public boolean modifyAcadgroup(Acadgroup acadgroup) {
		try {
			this.getHibernateTemplate().update(acadgroup);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeAcadgroup(Acadgroup acadgroup) {
		try {
			this.getHibernateTemplate().delete(acadgroup);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcadgroup(Integer acadgroup_no) {
		String query = "from Acadgroup acadgroup where acadgroup.shai_id =" + "'" + acadgroup_no + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Acadgroup");
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
			List result = this.getHibernateTemplate().find("select count(*) from Acadgroup" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Acadgroup" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Acadgroup acadgroup " + condition + " order by shai_id ", obj);
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
			result = this.getHibernateTemplate().find("from Acadgroup acadgroup " + condition + " order by shai_id ");
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
			result = this.getHibernateTemplate().find("from Acadgroup acadgroup " + condition + " order by shai_id");
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
		String query = "select shai_id,assoname,contactperson,contacttelephone from Acadgroup";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by shai_id");
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
			result = this.getHibernateTemplate().find("from Acadgroup acadgroup" + condition, obj);
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
	public int SaveAcadgroupList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Acadgroup bean = new Acadgroup();
				if (null == bean) {
					return 2;
				}
				if (!saveAcadgroup(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List gainAcadgroup(String assoname) {
		String query = "from Acadgroup acadgroup where acadgroup.assoname =" + "'" + assoname + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	public List getSqlresult(String searchsql, int start, int pagesize) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete,memname limit " + start + "," + pagesize;
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			int i = 1;
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				bean.setInstitutetelephone(rs.getString("institutetelephone"));
				if (bean.getInstitutetelephone().length() < 1) {
					bean.setInstitutetelephone(rs.getString("hometelephone"));
				}
				// bean.setInstitutetelephone((String) rs
				// .getString("institutetelephone"));
				bean.setIsdelete((String) rs.getString("isdelete"));
				bean.setNo(i);
				i++;
				/*
				 * String temp = rs.getDate("membirthday").toString();
				 * bean.setMembirthdaydate(temp);
				 * bean.setMemparty_f(rs.getString("party"));
				 * bean.setMemrank_s(rs.getString("memrank_s"));
				 * bean.setMemduty(rs.getString("memduty"));
				 * bean.setMemspeciality(rs.getString("memspeciality"));
				 * bean.setMemnation_s(rs.getString("memnation_s"));
				 * bean.setMemnationality_s(rs.getString("memnationality_s"));
				 * bean.setMemscholar(rs.getString("memscholar"));
				 * bean.setMemdegree(rs.getString("memdegree"));
				 * String instituteadd = rs.getString("instituteaddress"); if
				 * (instituteadd.length() < 1) {
				 * bean.setInstituteaddress(rs.getString("homeaddress"));
				 * bean.setInstitutepostcode(rs.getString("homepostcode"));
				 * bean.setInstitutetelephone(rs.getString("hometelephone")); }
				 * else {
				 * bean.setInstituteaddress(rs.getString("instituteaddress"));
				 * bean .setInstitutepostcode(rs
				 * .getString("institutepostcode"));
				 * bean.setInstitutetelephone(rs
				 * .getString("institutetelephone"));
				 * }
				 */

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

	public List getSqlresultprint(String searchsql) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete,memname";
		// ¾À´í
		if (searchsql.toLowerCase().indexOf("order") >= 0) {
			ordersearchsql = searchsql;
		}
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			int i = 0;
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				// bean.setAsmr_id(Integer.valueOf(rs.getString("asmr_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemno((String) rs.getString("memno"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				bean.setInstitutetelephone(rs.getString("institutetelephone"));

				// bean.setInstitutetelephone((String) rs
				// .getString("institutetelephone"));
				bean.setIsdelete((String) rs.getString("isdelete"));

				String temp = rs.getDate("membirthday").toString();
				bean.setMembirthdaydate(temp);
				bean.setMemparty_f(rs.getString("party"));
				bean.setMemrank_s(rs.getString("memrank_s"));
				bean.setMemduty(rs.getString("memduty"));
				bean.setMemspeciality(rs.getString("memspeciality"));
				bean.setMemnation_s(rs.getString("memnation_s"));
				bean.setMemnationality_s(rs.getString("memnationality_s"));
				bean.setMemscholar(rs.getString("memscholar"));

				bean.setMemdegree(rs.getString("memdegree"));

				String instituteadd = rs.getString("instituteaddress");
				if (instituteadd.length() < 1) {
					bean.setInstituteaddress(rs.getString("homeaddress"));
					bean.setInstitutepostcode(rs.getString("homepostcode"));
					bean.setInstitutetelephone(rs.getString("hometelephone"));
				} else {
					bean.setInstituteaddress(rs.getString("instituteaddress"));
					bean.setInstitutepostcode(rs.getString("institutepostcode"));
					bean.setInstitutetelephone(rs.getString("institutetelephone"));

				}

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

	public List getSqlresult1(String searchsql, String train, int start, int pagesize) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete," + train + " limit " + start + "," + pagesize;
		;
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			int i = 0;
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				// bean.setAsmr_id(Integer.valueOf(rs.getString("asmr_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				// bean.setInstitutetelephone((String) rs
				// .getString("institutetelephone"));
				bean.setIsdelete((String) rs.getString("isdelete"));

				/*
				 * String temp = rs.getDate("membirthday").toString();
				 * bean.setMembirthdaydate(temp);
				 * bean.setMemparty_f(rs.getString("party"));
				 * bean.setMemrank_s(rs.getString("memrank_s"));
				 * bean.setMemduty(rs.getString("memduty"));
				 * bean.setMemspeciality(rs.getString("memspeciality"));
				 * bean.setMemnation_s(rs.getString("memnation_s"));
				 * bean.setMemnationality_s(rs.getString("memnationality_s"));
				 * bean.setMemscholar(rs.getString("memscholar"));
				 * bean.setMemdegree(rs.getString("memdegree"));
				 * //ll²¹¼Óemail
				 * bean.setUseremail((String)rs.getString("useremail")); String
				 * instituteadd = rs.getString("instituteaddress"); if
				 * (instituteadd.length() < 1) {
				 * bean.setInstituteaddress(rs.getString("homeaddress"));
				 * bean.setInstitutepostcode(rs.getString("homepostcode"));
				 * bean.setInstitutetelephone(rs.getString("hometelephone")); }
				 * else {
				 * bean.setInstituteaddress(rs.getString("instituteaddress"));
				 * bean .setInstitutepostcode(rs
				 * .getString("institutepostcode"));
				 * bean.setInstitutetelephone(rs
				 * .getString("institutetelephone"));
				 * }
				 */

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

	public List gainAcadgroup(Integer shai_id) {
		String query = "from Acadgroup acadgroup where acadgroup.shai_id =" + "'" + shai_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List list() {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from Acadgroup");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List SearchGmember(String searchsql) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete";
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {
				Gmemberbaseinforelation bean = new Gmemberbaseinforelation();
				bean.setGmbi_id(rs.getInt("gmbi_id"));
				bean.setAgmr_id(rs.getInt("agmr_id"));
				bean.setContactaddress(rs.getString("contactaddress"));
				bean.setContacttelephone(rs.getString("contacttelephone"));
				bean.setInstitutename(rs.getString("institutename"));
				bean.setAcadname(rs.getString("acadname"));
				bean.setIsdelete(rs.getString("isdelete"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
			return list;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
		}

	}

	public int getallonum(String searchsql) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = "select count(*) as count from (" + searchsql + ") a";
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			int i = 1;
			while (rs.next()) {
				i = Integer.valueOf(rs.getString("count"));
			}
			rs.close();
			stmt.close();
			rs = null;
			stmt = null;
			return i;
		} catch (Exception ex) {
			return 0;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}
	}

}
