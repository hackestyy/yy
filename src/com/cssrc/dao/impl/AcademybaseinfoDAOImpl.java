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

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;

public class AcademybaseinfoDAOImpl extends HibernateDaoSupport implements IAcademybaseinfoDAO {
	private static final String LOAD_ALL = "from Academybaseinfo academybaseinfo order by Academybaseinfo.abi_id desc";

	/** default constructor */
	public AcademybaseinfoDAOImpl() {
	}

	public Integer getSize(Integer shai_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academybaseinfo where shai_id = '" + shai_id + "'");
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
	public boolean saveAcademybaseinfo(Academybaseinfo academybaseinfo) {
		try {
			this.getHibernateTemplate().save(academybaseinfo);
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
	public Academybaseinfo getAcademybaseinfo(Integer abi_id) {
		return (Academybaseinfo) this.getHibernateTemplate().get(Academybaseinfo.class, new Integer(abi_id));
	}

	/**
	 * @return List
	 */
	public List findAcademybaseinfoAll() {
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
	public boolean modifyAcademybaseinfo(Academybaseinfo academybaseinfo) {
		try {
			this.getHibernateTemplate().update(academybaseinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeAcademybaseinfo(Academybaseinfo academybaseinfo) {
		try {
			this.getHibernateTemplate().delete(academybaseinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademybaseinfo(Integer abi_id) {
		String query = "from Academybaseinfo academybaseinfo where academybaseinfo.abi_id =" + "'" + abi_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Academybaseinfo");
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
			List result = this.getHibernateTemplate().find("select count(*) from Academybaseinfo" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Academybaseinfo" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Academybaseinfo academybaseinfo " + condition + " order by abi_id ", obj);
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
			result = this.getHibernateTemplate().find("from Academybaseinfo academybaseinfo " + condition + " order by abi_id ");
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
			result = this.getHibernateTemplate().find("from Academybaseinfo academybaseinfo " + condition + " order by abi_id");
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
		String query = "select * from Academybaseinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by abi_id");
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

	public List getlistquery(String condition, int offset, int pagesize) {
		List result = new ArrayList();
		String query = "select * from Academybaseinfo";
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

	public List searchlistquery(String condition, int offset, int pagesize) {
		List result = new ArrayList();
		String query = "select abi_id,acadname,acadno from Academybaseinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by abi_id");
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
			result = this.getHibernateTemplate().find("from Academybaseinfo academybaseinfo" + condition, obj);
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
	public int SaveAcademybaseinfoList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Academybaseinfo bean = new Academybaseinfo();
				if (null == bean) {
					return 2;
				}
				if (!saveAcademybaseinfo(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List getSqlresult(String searchsql) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete,memname";
		if (searchsql.toLowerCase().indexOf("order") > 0) {
			ordersearchsql = searchsql;
		}
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				bean.setInstitutetelephone((String) rs.getString("institutetelephone"));
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

	public List getSqlresult1(String searchsql, String train) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete," + train;
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				bean.setInstitutetelephone((String) rs.getString("institutetelephone"));
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

	public List gainAcademybaseinfo(Integer abi_id) {
		String query = "from Academybaseinfo academybaseinfo where academybaseinfo.abi_id =" + "'" + abi_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public boolean selectAcadName(String searchsql) {

		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(searchsql);
			while (rs.next()) {
				rs.close();
				stmt.close();
				return false;
			}
			rs.close();
			stmt.close();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			s.disconnect();
			s.close();
		}
	}

	public List selectIdandName() {
		try {
			return this.getHibernateTemplate().find("from Academybaseinfo");
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	public List getSqlresult1(String searchsql) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql;
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {
				Academybaseinfo bean = new Academybaseinfo();
				bean.setShai_id(Integer.valueOf(rs.getString("shai_id")));
				bean.setAbi_id(Integer.valueOf(rs.getString("abi_id")));
				bean.setAcadname((String) rs.getString("acadname"));
				bean.setAcadno((String) rs.getString("acadno"));
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

	public List getAbi_id(Integer shai_id) {
		try {
			return this.getHibernateTemplate().find("select abi_id from Academybaseinfo where shai_id=" + shai_id);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}
}
