package com.cssrc.dao.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.dao.admin.ISearchsmemberbaseinfoviewDAO;

public class SearchsmemberbaseinfoviewDAOImpl extends HibernateDaoSupport implements ISearchsmemberbaseinfoviewDAO {
	private static final String LOAD_ALL = "from Searchsmemberbaseinfoview searchsmemberbaseinfoview";

	/** default constructor */
	public SearchsmemberbaseinfoviewDAOImpl() {
	}

	public Integer getSize(Integer shai_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Searchsmemberbaseinfoview where shai_id = '" + shai_id + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	/**
	 * @param String
	 *            long
	 * @return Adv
	 */
	/**
	 * @return List
	 */
	public List findSearchsmemberbaseinfoviewAll() {
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

	/**
	 * @param user
	 *            User
	 */

	/**
	 * @param userid
	 * @return List
	 */
	public List findSearchsmemberbaseinfoview(Integer abi_id) {
		String query = "from Searchsmemberbaseinfoview searchsmemberbaseinfoview where searchsmemberbaseinfoview.abi_id =" + "'" + abi_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from searchsmemberbaseinfoview");
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
			List result = this.getHibernateTemplate().find("select count(*) from searchsmemberbaseinfoview" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from searchsmemberbaseinfoview" + condition, obj);
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
			result = this.getHibernateTemplate().find("from searchsmemberbaseinfoview searchsmemberbaseinfoview " + condition + " order by abi_id ", obj);
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
			result = this.getHibernateTemplate().find("from searchsmemberbaseinfoview searchsmemberbaseinfoview " + condition + " order by abi_id ");
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
			result = this.getHibernateTemplate().find("from searchsmemberbaseinfoview searchsmemberbaseinfoview " + condition + " order by abi_id");
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
		String query = "select * from searchsmemberbaseinfoview";
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
		String query = "select * from searchsmemberbaseinfoview";
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
			result = this.getHibernateTemplate().find("from Searchsmemberbaseinfoview searchsmemberbaseinfoview" + condition, obj);
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

	/**
	 * @param type
	 *            user
	 * @return boolean
	 */
	public boolean deleteSearchsmemberbaseinfoview(Integer smbi_id) {
		String sql = "update searchsmemberbaseinfoview set isdelete='1' where smbi_id =" + "'" + smbi_id + "'";
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			int i = 1;

			stmt.close();
			stmt = null;
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}
	}

	public List findSearchsmemberbaseinfoviewBySmbiId(Integer smbi_id) {
		String query = "select * from searchsmemberbaseinfoview where smbi_id =" + "'" + smbi_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

}
