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

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;

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
public class AcademysmemberrelationDAOImpl extends HibernateDaoSupport implements IAcademysmemberrelationDAO {
	private static final String LOAD_ALL = "from Academysmemberrelation academysmemberrelation order by Academysmemberrelation.asmr_id desc";

	/** default constructor */
	public AcademysmemberrelationDAOImpl() {
	}

	public Integer getSize(Integer abi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academysmemberrelation where abi_id = '" + abi_id + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}
	}

	public Integer getSizeByabi_idAndisdelete(Integer abi_id, String isdelete) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academysmemberrelation where abi_id = '" + abi_id + "'+ and isdelete= '" + isdelete + "'");
			ListIterator iterator = result.listIterator();
			Object rows = (Object) iterator.next();
			return Integer.valueOf(rows.toString());
		} catch (DataAccessException e) {
			return Integer.valueOf("0");
		}

	}

	public Integer getSize1(Integer smbi_id) {
		try {
			List result = this.getHibernateTemplate().find("select count(*) from Academysmemberrelation where smbi_id = '" + smbi_id + "'");
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
	public boolean saveAcademysmemberrelation(Academysmemberrelation academysmemberrelation) {
		try {
			this.getHibernateTemplate().save(academysmemberrelation);
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
	public Academysmemberrelation getAcademysmemberrelation(Integer asmr_id) {
		return (Academysmemberrelation) this.getHibernateTemplate().get(Academysmemberrelation.class, new Integer(asmr_id));
	}

	/**
	 * @return List
	 */
	public List findAcademysmemberrelationAll() {
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
	public boolean modifyAcademysmemberrelation(Academysmemberrelation academysmemberrelation) {
		try {
			this.getHibernateTemplate().update(academysmemberrelation);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param user
	 *            User
	 */
	public boolean removeAcademysmemberrelation(Academysmemberrelation academysmemberrelation) {
		try {
			this.getHibernateTemplate().delete(academysmemberrelation);
		} catch (DataAccessException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param userid
	 * @return List
	 */
	public List findAcademysmemberrelation(Integer asmr_id) {
		String query = "from Academysmemberrelation academysmemberrelation where academysmemberrelation.asmr_id =" + "'" + asmr_id + "'";
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
			List result = this.getHibernateTemplate().find("select count(*) from Academysmemberrelation");
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
			List result = this.getHibernateTemplate().find("select count(*) from Academysmemberrelation" + condition);
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
			List result = this.getHibernateTemplate().find("select count(*) from Academysmemberrelation" + condition, obj);
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
			result = this.getHibernateTemplate().find("from Academysmemberrelation academysmemberrelation " + condition + " order by asmr_id ", obj);
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List alllist(String condition) {

		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select academysmemberrelation.smbi_id from Academysmemberrelation academysmemberrelation " + condition + " order by asmr_id ");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List distinctlist(String condition) {

		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("select distinct academysmemberrelation.smbi_id from Academysmemberrelation academysmemberrelation " + condition + " order by asmr_id ");
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
			result = getHibernateTemplate().find("from Academysmemberrelation academysmemberrelation " + condition + " order by asmr_id ");
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List listrelation(String condition) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from Academysmemberrelation academysmemberrelation " + condition);
			return result;
		} catch (DataAccessException ex) {
			return result;
		}
	}

	public List listquery(String condition) {
		List result = new ArrayList();
		try {
			result = this.getHibernateTemplate().find("from Academysmemberrelation academysmemberrelation " + condition + " order by abi_id ");
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
			String queryString = "from Academysmemberrelation academysmemberrelation " + condition + " order by asmr_id";
			result = this.getHibernateTemplate().find(queryString);
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
		String query = "select * from Academysmemberrelation";
		try {
			result = this.getHibernateTemplate().find(query + " " + condition + " order by asmr_id");
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
			result = this.getHibernateTemplate().find("from Academysmemberrelation academysmemberrelation" + condition, obj);
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
	public int SaveAcademysmemberrelationList(List recordBeanList) {

		try {
			for (int i = 0; i < recordBeanList.size(); i++) {
				Academysmemberrelation bean = new Academysmemberrelation();
				if (null == bean) {
					return 2;
				}
				if (!saveAcademysmemberrelation(bean)) {
					return 1;
				}
			}
		} catch (DataAccessException ex) {
			return 1;
		}
		return 0;
	}

	public List gainAcademysmemberrelation(Integer smbi_id) {
		String query = "from Academysmemberrelation academysmemberrelation where academysmemberrelation.smbi_id =" + "'" + smbi_id + "' order by abi_id";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List fetchAcademysmemberrelation(Integer abi_id) {
		String query = "from Academysmemberrelation academysmemberrelation where academysmemberrelation.abi_id =" + "'" + abi_id + "'";
		try {
			return this.getHibernateTemplate().find(query);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	public List getsqlresultall(Integer abi_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = "select 'a' as temp, memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty1 = '理事（会）长' and isdelete=0 " + "union all select 'b', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id
				+ " and academyduty2 = '常务副理事（会）长' and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "union all select 'c', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty3 = '副理事（会）长' and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'd', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty4 = '常务理事' and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null)  and isdelete=0 "
				+ "union all select 'e', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty5 = '理事' and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'f', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty6 = '秘书长' and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'g', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and (academyduty6 <> '秘书长' or academyduty6 is null) and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "order by temp,memname";
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
				bean.setMemno(rs.getString("memno"));
				bean.setAsmr_id(rs.getInt("asmr_id"));
				bean.setMemname(rs.getString("memname"));
				bean.setAbi_id(rs.getInt("abi_id"));
				bean.setSmbi_id(rs.getInt("smbi_id"));
				bean.setMemsex(rs.getString("memsex"));
				bean.setInstitutetelephone(rs.getString("institutetelephone"));
				bean.setMeminstitute(rs.getString("meminstitute"));
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

	public List getsqlresult(Integer abi_id, int offset, int pagesize) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = "select 'a' as temp, memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty1 = '理事（会）长' and isdelete=0 " + "union all select 'b', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id
				+ " and academyduty2 = '常务副理事（会）长' and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "union all select 'c', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty3 = '副理事（会）长' and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'd', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty4 = '常务理事' and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null)  and isdelete=0 "
				+ "union all select 'e', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty5 = '理事' and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'f', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty6 = '秘书长' and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'g', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and (academyduty6 <> '秘书长' or academyduty6 is null) and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "order by temp,memname limit " + offset + "," + pagesize;
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql);
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setMemno(rs.getString("memno"));
				bean.setAsmr_id(rs.getInt("asmr_id"));
				bean.setMemname(rs.getString("memname"));
				bean.setAbi_id(rs.getInt("abi_id"));
				bean.setSmbi_id(rs.getInt("smbi_id"));
				bean.setMemsex(rs.getString("memsex"));
				bean.setInstitutetelephone(rs.getString("institutetelephone"));
				bean.setMeminstitute(rs.getString("meminstitute"));

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
	public List getsqlresult(Integer abi_id, int offset, int pagesize,String train) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
//		String ordersearchsql = "select 'a' as temp, memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty1 = '理事（会）长' and isdelete=0 " + "union all select 'b', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id
//				+ " and academyduty2 = '常务副理事（会）长' and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "union all select 'c', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty3 = '副理事（会）长' and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
//				+ "union all select 'd', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty4 = '常务理事' and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null)  and isdelete=0 "
//				+ "union all select 'e', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty5 = '理事' and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
//				+ "union all select 'f', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty6 = '秘书长' and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
//				+ "union all select 'g', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and (academyduty6 <> '秘书长' or academyduty6 is null) and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "order by "+train+",memname limit " + offset + "," + pagesize;
		StringBuffer ordersearchsql = new StringBuffer();
		ordersearchsql.append(" select distinct a.asmr_id,a.smbi_id,a.membirthday,a.memscholar,a.memdegree,a.usermobile,a.memno,a.memname,a.memsex,a.meminstitute,a.institutetelephone,a.isdelete, a.party,a.memrank_s,a.memduty,a.memspeciality,a.instituteaddress,a.institutepostcode,a.homeaddress,a.homepostcode,hometelephone,memnation_s,memnationality_s ,a.useremail from searchsmemberbaseinfoview a where 1=1 ");
		ordersearchsql.append(" and a.abi_id =" + "'" + abi_id + "' ");
		ordersearchsql.append(" order by isdelete," + train);
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ordersearchsql.toString());
			while (rs.next()) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean.setMemno(rs.getString("memno"));
				bean.setAsmr_id(rs.getInt("asmr_id"));
				bean.setMemname(rs.getString("memname"));
//				bean.setAbi_id(rs.getInt("abi_id"));
				bean.setSmbi_id(rs.getInt("smbi_id"));
				bean.setMemsex(rs.getString("memsex"));
				bean.setInstitutetelephone(rs.getString("institutetelephone"));
				bean.setMeminstitute(rs.getString("meminstitute"));

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
			ex.printStackTrace();
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}
	}
	public int getallonum(Integer abi_id) {
		String str = "select 'a' as temp, memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty1 = '理事（会）长' and isdelete=0 " + "union all select 'b', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id
				+ " and academyduty2 = '常务副理事（会）长' and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 " + "union all select 'c', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty3 = '副理事（会）长' and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'd', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty4 = '常务理事' and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null)  and isdelete=0 "
				+ "union all select 'e', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty5 = '理事' and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'f', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and academyduty6 = '秘书长' and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 "
				+ "union all select 'g', memno,memname,memsex,meminstitute,institutetelephone,asmr_id,abi_id,  membirthday,party,memrank_s,memduty,memspeciality,instituteaddress,institutepostcode,homeaddress,homepostcode,hometelephone,memnation_s,memnationality_s,memscholar,memdegree,  smbi_id from v_academysmemberrelationlist where  abi_id=" + abi_id + " and (academyduty6 <> '秘书长' or academyduty6 is null) and (academyduty5 <> '理事'  or academyduty5 is null) and (academyduty4 <> '常务理事' or academyduty4 is null) and (academyduty3 <> '副理事（会）长' or academyduty3 is null)  and (academyduty2 <> '常务副理事（会）长' or academyduty2 is null) and (academyduty1 <> '理事（会）长' or academyduty1 is null) and isdelete=0 ";

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		String ordersearchsql = "select count(*) as count from (" + str + ") a";
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

	public List gainAcademysmemberrelaNODEL(Integer smbi_id) {
		String query = "from Academysmemberrelation academysmemberrelation where academysmemberrelation.smbi_id =" + "'" + smbi_id + "' and academysmemberrelation.isdelete=0";
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
