package com.cssrc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;

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
public class SmemberbaseinfoDAOImpl extends HibernateDaoSupport implements ISmemberbaseinfoDAO {
	private static final String LOAD_ALL = "from Smemberbaseinfo smemberbaseinfo order by smemberbaseinfo.smbi_id desc";

	/** default constructor */
	public SmemberbaseinfoDAOImpl() {
	}

	public Integer getSize(String assoduty_s) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Smemberbaseinfo where assoduty_s = '" + assoduty_s + "'");
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
	public boolean saveSmemberbaseinfo(Smemberbaseinfo smemberbaseinfo) {
		try {
			this.getHibernateTemplate().save(smemberbaseinfo);
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
	public Smemberbaseinfo getSmemberbaseinfo(Integer smbi_id) {
		return (Smemberbaseinfo) this.getHibernateTemplate().get(Smemberbaseinfo.class, new Integer(smbi_id));
	}

	/**
	 * @return List
	 */
	public List findSmemberbaseinfoAll() {
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
	public boolean modifySmemberbaseinfo(Smemberbaseinfo smemberbaseinfo) {
		try {
			this.getHibernateTemplate().update(smemberbaseinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeSmemberbaseinfo(Smemberbaseinfo smemberbaseinfo) {
		try {
			this.getHibernateTemplate().delete(smemberbaseinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findSmemberbaseinfo(Integer smbi_id) {
		String query = "from Smemberbaseinfo smemberbaseinfo where smemberbaseinfo.smbi_id =" + "'" + smbi_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberbaseinfo");
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberbaseinfo" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Smemberbaseinfo" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Smemberbaseinfo smemberbaseinfo " + condition + " order by memname ", obj);
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
			result = this.getHibernateTemplate().find("from Smemberbaseinfo smemberbaseinfo " + condition + " order by memname ");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List leftlist(String condition) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from Smemberbaseinfo smemberbaseinfo left join s.course c " + condition + " order by smbi_id ");
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
			result = this.getHibernateTemplate().find("from Smemberbaseinfo smemberbaseinfo " + condition + " order by smbi_id");
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
		String query = "select smbi_id,memname,memsex,institutetelephone,hometelephone from Smemberbaseinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by smbi_id");
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
			result = this.getHibernateTemplate().find("from Smemberbaseinfo smemberbaseinfo" + condition, obj);
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
	public int SaveSmemberbaseinfoList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Smemberbaseinfo bean = new Smemberbaseinfo();
				if (null == bean) {
					return 2;
				}
				if (!saveSmemberbaseinfo(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List gainSmemberbaseinfo(String one, String two, String three, String four, String five) {
		List result = new ArrayList();
		String tempthreefirst = three.substring(0, 7) + "-01";
		String tempthreelast = three.substring(0, 7) + "-31";
		String query = "from Smemberbaseinfo smemberbaseinfo where smemberbaseinfo.memname =?" + " and smemberbaseinfo.memsex =?" + " and smemberbaseinfo.membirthday >=" + "'" + tempthreefirst + "'" + " and smemberbaseinfo.membirthday <=" + "'" + tempthreelast + "'" + " and smemberbaseinfo.memdegree =?" + " and smemberbaseinfo.memscholar =?";
		try {
			Session s = this.getSession();
			Query queryresult = s.createQuery(query);
			queryresult.setString(0, one);
			queryresult.setString(1, two);
			queryresult.setString(2, four);
			queryresult.setString(3, five);
			result = queryresult.list();
			s.close();
			s = null;
			return result;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List gainSmemberbaseinfolist(String memno) {
		String query = "from Smemberbaseinfo smemberbaseinfo where smemberbaseinfo.memno =" + "'" + memno + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List getlist(String condition, int offset, int pagesize) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select count(*) from Smemberbaseinfo  " + condition + " order by smbi_id");
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

	public List getSqlresult(String searchsql) {
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
			int i = 1;
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setNo(i);
				i++;
				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				bean.setAsmr_id(Integer.valueOf(rs.getString("asmr_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemno((String) rs.getString("memno"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));

				// bean.setInstitutetelephone((String) rs
				// .getString("institutetelephone"));
				bean.setIsdelete((String) rs.getString("isdelete"));
				bean.setUsermobile(rs.getString("usermobile"));
				if (null!=rs.getDate("membirthday")) {
					bean.setMembirthdaydate(rs.getDate("membirthday").toString());
				}				
				bean.setMemparty_f(rs.getString("party"));
				bean.setMemrank_s(rs.getString("memrank_s"));
				bean.setMemduty(rs.getString("memduty"));
				bean.setMemspeciality(rs.getString("memspeciality"));
				bean.setMemnation_s(rs.getString("memnation_s"));
				bean.setMemnationality_s(rs.getString("memnationality_s"));
				bean.setMemscholar(rs.getString("memscholar"));
				bean.setMemdegree(rs.getString("memdegree"));

				// ll²¹¼Óemail
				bean.setUseremail((String) rs.getString("useremail"));
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
			System.out.println(ordersearchsql);
			ex.printStackTrace();
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
				bean.setAsmr_id(Integer.valueOf(rs.getString("asmr_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				// bean.setInstitutetelephone((String) rs
				// .getString("institutetelephone"));
				bean.setIsdelete((String) rs.getString("isdelete"));
				bean.setUsermobile(rs.getString("usermobile"));
				if (null!=rs.getDate("membirthday")) {
					bean.setMembirthdaydate(rs.getDate("membirthday").toString());
				}
				bean.setMemparty_f(rs.getString("party"));
				bean.setMemrank_s(rs.getString("memrank_s"));
				bean.setMemduty(rs.getString("memduty"));
				bean.setMemspeciality(rs.getString("memspeciality"));
				bean.setMemnation_s(rs.getString("memnation_s"));
				bean.setMemnationality_s(rs.getString("memnationality_s"));
				bean.setMemscholar(rs.getString("memscholar"));

				bean.setMemdegree(rs.getString("memdegree"));

				// ll²¹¼Óemail
				bean.setUseremail((String) rs.getString("useremail"));
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
			ex.printStackTrace();
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}
	}

	public Smemberbainforelation getSqlresult2(Integer train, Integer abi_id) {
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = "select distinct a.asmr_id,a.smbi_id,a.membirthday,a.memscholar,a.memdegree,a.usermobile,a.memno,a.memname,a.memsex,a.meminstitute,a.institutetelephone,a.isdelete, a.party,a.memrank_s,a.memduty,a.memspeciality,a.instituteaddress,a.institutepostcode,a.homeaddress,a.homepostcode,hometelephone,memnation_s,memnationality_s ,a.useremail from searchsmemberbaseinfoview a where 1=1 and a.smbi_id='" + train + "' and a.abi_id =" + "'" + abi_id + "' ";
		Connection conn = null;
		Smemberbainforelation bean = new Smemberbainforelation();
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {

				bean.setSmbi_id(Integer.valueOf(rs.getString("smbi_id")));
				bean.setAsmr_id(Integer.valueOf(rs.getString("asmr_id")));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				// bean.setInstitutetelephone((String) rs
				// .getString("institutetelephone"));
				bean.setIsdelete((String) rs.getString("isdelete"));
				bean.setUsermobile(rs.getString("usermobile"));
				if (null!=rs.getDate("membirthday")) {
					bean.setMembirthdaydate(rs.getDate("membirthday").toString());
				}	
				bean.setMemparty_f(rs.getString("party"));
				bean.setMemrank_s(rs.getString("memrank_s"));
				bean.setMemduty(rs.getString("memduty"));
				bean.setMemspeciality(rs.getString("memspeciality"));
				bean.setMemnation_s(rs.getString("memnation_s"));
				bean.setMemnationality_s(rs.getString("memnationality_s"));
				bean.setMemscholar(rs.getString("memscholar"));

				bean.setMemdegree(rs.getString("memdegree"));

				// ll²¹¼Óemail
				bean.setUseremail((String) rs.getString("useremail"));
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
			}
			rs.close();
			stmt.close();
			rs = null;
			stmt = null;
			return bean;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}
	}

	public Integer getRnum() {
		try {
			List result = this.getHibernateTemplate().find("select max(smbi_id) from Smemberbaseinfo");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (Exception e) {
			return Integer.valueOf("0");
		}
	}

	public boolean isValidUser(String user_name, String user_password) {
		try {
			String condition = "from Smemberbaseinfo where memno = '" + user_name + "' and password = '" + user_password + "'";
			List result = this.getHibernateTemplate().find(condition);
			if (result.size() > 0) {
				return true;
			}
		} catch (DataAccessException e) {
		}
		return false;
	}

	public boolean updateSmemberbaseinfo(Smemberbaseinfo smemberbaseinfo) {
		try {
			this.getHibernateTemplate().saveOrUpdate(smemberbaseinfo);
			return true;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return false;
		}
	}

	public int listmemno(String memno) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select memno from Smemberbaseinfo where memno = '" + memno + "'");
			if (result.size() > 0) {
				return 1;
			}
			return 2;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return 3;
		}
	}

	public int listmemno_userinfotable(String memno) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select useraccount from User where useraccount = '" + memno + "'");
			if (result.size() > 0) {
				return 1;
			}
			return 2;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return 3;
		}
	}

	public List findsmbi_id_Bymemno(String memno) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select smbi_id from Smemberbaseinfo where memno='" + memno + "'");
			return result;
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

	public boolean modifymemno(String memno, Integer id) {
		try {
			String hsql = "update Smemberbaseinfo set memno='" + memno + "' where smbi_id=" + id;
			Query q = this.getSession().createQuery(hsql);
			q.executeUpdate();
			// this.getHibernateTemplate().update(
			// "update Smemberbaseinfo a set a.memno='" + memno +
			// "' where a.smbi_id=2977");
		} catch (DataAccessException ex) {
			logger.error(ex);
			return false;
		}
		return true;
	}

}
