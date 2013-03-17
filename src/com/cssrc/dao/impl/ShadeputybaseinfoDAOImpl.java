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

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;

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
public class ShadeputybaseinfoDAOImpl extends HibernateDaoSupport implements IShadeputybaseinfoDAO {
	private static final String LOAD_ALL = "from Shadeputybaseinfo shadeputybaseinfo order by Shadeputybaseinfo.shadbi_id desc";

	/** default constructor */
	public ShadeputybaseinfoDAOImpl() {
	}

	public Integer getSize(String assoduty_s) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputybaseinfo where assoduty_s = '" + assoduty_s + "'");
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
	public boolean saveShadeputybaseinfo(Shadeputybaseinfo shadeputybaseinfo) {
		try {
			this.getHibernateTemplate().save(shadeputybaseinfo);
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
	public Shadeputybaseinfo getShadeputybaseinfo(Integer shadbi_id) {
		return (Shadeputybaseinfo) this.getHibernateTemplate().get(Shadeputybaseinfo.class, new Integer(shadbi_id));
	}

	/**
	 * @return List
	 */
	public List findShadeputybaseinfoAll() {
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
	public boolean modifyShadeputybaseinfo(Shadeputybaseinfo shadeputybaseinfo) {
		try {
			this.getHibernateTemplate().update(shadeputybaseinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeShadeputybaseinfo(Shadeputybaseinfo shadeputybaseinfo) {
		try {
			this.getHibernateTemplate().delete(shadeputybaseinfo);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findShadeputybaseinfo(Integer shadbi_id) {
		String query = "from Shadeputybaseinfo shadeputybaseinfo where shadeputybaseinfo.shadbi_id =" + "'" + shadbi_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List findShadeputybaseinfobymemno(String memno) {
		String query = "from Shadeputybaseinfo shadeputybaseinfo where shadeputybaseinfo.memno =" + "'" + memno + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputybaseinfo");
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputybaseinfo" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Shadeputybaseinfo" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Shadeputybaseinfo shadeputybaseinfo " + condition + " order by shadbi_id ", obj);
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
			result = this.getHibernateTemplate().find("from Shadeputybaseinfo shadeputybaseinfo " + condition + " order by deputyname ");
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
			result = this.getHibernateTemplate().find("from Shadeputybaseinfo shadeputybaseinfo " + condition + " order by deputyname");
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
		String query = "select * from Shadeputybaseinfo";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by shadbi_id");
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
			result = this.getHibernateTemplate().find("from Shadeputybaseinfo shadeputybaseinfo" + condition, obj);
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
	public int SaveShadeputybaseinfoList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Shadeputybaseinfo bean = new Shadeputybaseinfo();
				if (null == bean) {
					return 2;
				}
				if (!saveShadeputybaseinfo(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List gainShadeputybaseinfo(String deputyidentity) {
		String query = "from Shadeputybaseinfo shadeputybaseinfo where shadeputybaseinfo.deputyidentity =" + "'" + deputyidentity + "'";
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
			result = this.getHibernateTemplate().find("select count(*) from Shadeputybaseinfo  " + condition + " order by shadbi_id");
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

	public Integer getRnum() {
		try {
			List result = this.getHibernateTemplate().find("select max(shadbi_id) from Shadeputybaseinfo");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public List getSqlresult(String searchsql) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = searchsql + " order by isdelete,memname";
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {
				// 借用Smemberbainforelation Bean
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setMemno((String) rs.getString("memno"));
				bean.setUseremail((String) rs.getString("useremail"));
				bean.setMemname((String) rs.getString("memname"));
				bean.setMemsex((String) rs.getString("memsex"));
				bean.setMeminstitute((String) rs.getString("meminstitute"));
				bean.setInstitutetelephone((String) rs.getString("institutetelephone"));
				bean.setUsermobile((String) rs.getString("usermobile"));
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

	public List findshadbi_idByDeputyNO(String deputyno) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select shadbi_id from Shadeputybaseinfo where deputyno='" + deputyno + "'");
			return result;
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

	public List gainDeputybaseinfo(String one, String two, String three, String four, String five) {
		List result = new ArrayList();
		String tempthreefirst = three.substring(0, 7) + "-01";
		String tempthreelast = three.substring(0, 7) + "-31";
		String query = "from Shadeputybaseinfo shadeputybaseinfo where shadeputybaseinfo.deputyname =?" + " and shadeputybaseinfo.deputysex =?" + " and shadeputybaseinfo.deputybirthday >=" + "'" + tempthreefirst + "'" + " and shadeputybaseinfo.deputybirthday <=" + "'" + tempthreelast + "'" + " and shadeputybaseinfo.deputydegree =?" + " and shadeputybaseinfo.deputyscholar =?";
		try {
			Session s = this.getSession();
			Query queryresult = s.createQuery(query);
			queryresult.setString(0, one);// query中?的代替物
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

}
