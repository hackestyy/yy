package com.cssrc.dao.impl.stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.IGroupStatDAO;

public class GroupStatDAOImpl extends HibernateDaoSupport implements IGroupStatDAO {
	public List getGroupStat() {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select a.partyname, b.number, b.ratio from t_partyname_string a left join (select party,count(smbi_id) as number,count(smbi_id)/(select count(smbi_id) from v_partystat) as ratio from v_partystat group by party) b on a.partyname = b.party");
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("partyname"));
				bean.setNumber(rs.getInt("number"));
				Double dtemp = rs.getDouble("ratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setRatio(dratio);
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

	public List getAcadgroupstat(Integer shai_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.institutetype, b.number, b.ratio from t_groupstat_string a left join(select institutetype,count(shai_id) as number,count(shai_id)/(select count(shai_id) from v_gmemberstats  where shai_id =" + shai_id + " ) as ratio from v_gmemberstats  where shai_id =" + shai_id + "  group by institutetype) b on a.institutetype = b.institutetype";
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("institutetype"));
				bean.setNumber(rs.getInt("number"));
				Double dtemp = rs.getDouble("ratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setRatio(dratio);
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

	public List getAcadgroupstatacadename(Integer shai_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.acadname, a.abi_id,b.number, b.ratio from t_academybaseinfo a left join(select acadname,abi_id,count(shai_id) as number,count(shai_id)/(select count(shai_id) from v_gmemberstats  where shai_id =" + shai_id + " ) as ratio from v_gmemberstats  where shai_id =" + shai_id + "  group by acadname) b on a.acadname = b.acadname where shai_id =" + shai_id;
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("acadname"));
				bean.setNumber(rs.getInt("number"));
				bean.setAbi_id(rs.getInt("abi_id"));
				Double dtemp = rs.getDouble("ratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setRatio(dratio);
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

	public List getAllgroupstat() {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.institutetype, b.number, b.ratio from t_groupstat_string a left join(select institutetype,count(shai_id) as number,count(shai_id)/(select count(shai_id) from v_gmemberstats ) as ratio from v_gmemberstats group by institutetype) b on a.institutetype = b.institutetype";
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("institutetype"));
				bean.setNumber(rs.getInt("number"));
				Double dtemp = rs.getDouble("ratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setRatio(dratio);
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

	public List getallgroupstatacadename() {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.assoname, a.shai_id,b.number, b.ratio from t_shassociationinfo a left join(select assoname,acadname,count(shai_id) as number,count(shai_id)/(select count(shai_id) from v_gmemberstats ) as ratio from v_gmemberstats group by assoname) b on a.assoname = b.assoname where a.assoname not in ('常委、委员子库')";
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("assoname"));
				bean.setNumber(rs.getInt("number"));
				bean.setShai_id(rs.getInt("shai_id"));
				Double dtemp = rs.getDouble("ratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setRatio(dratio);
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

	public List getAcademygroupstat(Integer abi_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.institutetype, b.number, b.ratio from t_groupstat_string a left join(select institutetype,count(abi_id) as number,count(abi_id)/(select count(abi_id) from v_gmemberstats  where abi_id =" + abi_id + " ) as ratio from v_gmemberstats  where abi_id =" + abi_id + "  group by institutetype) b on a.institutetype = b.institutetype";
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("institutetype"));
				bean.setNumber(rs.getInt("number"));
				Double dtemp = rs.getDouble("ratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setRatio(dratio);
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

	public List list(String condition) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select joindate,abi_id from v_gmemberstats " + condition;
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setJoindate(rs.getDate("joindate"));
				bean.setAbi_id(rs.getInt("abi_id"));
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

	public List list() {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select joindate,shai_id from v_gmemberstats";
			ResultSet rs = stmt.executeQuery(sqlSearch);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setJoindate(rs.getDate("joindate"));
				bean.setShai_id(rs.getInt("shai_id"));
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

}
