package com.cssrc.dao.impl.stat.dbwy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.IPeopleNumDAO;

public class PeopleNumDAOImpl extends HibernateDaoSupport implements IPeopleNumDAO {

	public List getAllPeopleNum(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(memno) as number from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setPeoplenum(rs.getInt("number"));
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

	public List getWYPeopleNum(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(memno) as number from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setPeoplenum(rs.getInt("number"));
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

	public List getCWPeopleNum(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(memno) as number from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setPeoplenum(rs.getInt("number"));
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
