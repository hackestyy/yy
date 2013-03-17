package com.cssrc.dao.impl.stat.dbwy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.ISexStatDAO;

;

public class SexStatDAOImpl extends HibernateDaoSupport implements ISexStatDAO {

	public List getAllSexStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as number, " + "sum(case when memsex='男'  then 1 else 0 end) as male, " + "sum(case when memsex='男'  then 1 else 0 end)/count(*) as maleratio, " + "sum(case when memsex='女'  then 1 else 0 end) as female, " + "sum(case when memsex='女'  then 1 else 0 end)/count(*) as femaleratio " + "from (select distinct memno,memsex from v_statdbwy " + "where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setCountshai_id(rs.getInt("number"));
				bean.setMale(rs.getInt("male"));

				Double dtemp = rs.getDouble("maleratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setMaleratio(dratio);

				bean.setFemale(rs.getInt("female"));

				Double dtemp2 = rs.getDouble("femaleratio") * 100;
				java.text.DecimalFormat df2 = new java.text.DecimalFormat("0.00");
				String stemp2 = df2.format(dtemp2);
				Double dratio2 = Double.valueOf(stemp2);
				bean.setFemaleratio(dratio2);

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

	public List getWYSexStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as number, " + "sum(case when memsex='男' then 1 else 0 end) as male, " + "sum(case when memsex='男' then 1 else 0 end)/count(*) as maleratio, " + "sum(case when memsex='女' then 1 else 0 end) as female, " + "sum(case when memsex='女' then 1 else 0 end)/count(*) as femaleratio " + "from (select distinct memno, memsex from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setCountshai_id(rs.getInt("number"));
				bean.setMale(rs.getInt("male"));

				Double dtemp = rs.getDouble("maleratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setMaleratio(dratio);

				bean.setFemale(rs.getInt("female"));

				Double dtemp2 = rs.getDouble("femaleratio") * 100;
				java.text.DecimalFormat df2 = new java.text.DecimalFormat("0.00");
				String stemp2 = df2.format(dtemp2);
				Double dratio2 = Double.valueOf(stemp2);
				bean.setFemaleratio(dratio2);

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

	public List getCWSexStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as number, " + "sum(case when memsex='男' then 1 else 0 end) as male, " + "sum(case when memsex='男' then 1 else 0 end)/count(*) as maleratio, " + "sum(case when memsex='女' then 1 else 0 end) as female, " + "sum(case when memsex='女' then 1 else 0 end)/count(*) as femaleratio " + "from (select distinct memno, memsex from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setCountshai_id(rs.getInt("number"));
				bean.setMale(rs.getInt("male"));

				Double dtemp = rs.getDouble("maleratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setMaleratio(dratio);

				bean.setFemale(rs.getInt("female"));

				Double dtemp2 = rs.getDouble("femaleratio") * 100;
				java.text.DecimalFormat df2 = new java.text.DecimalFormat("0.00");
				String stemp2 = df2.format(dtemp2);
				Double dratio2 = Double.valueOf(stemp2);
				bean.setFemaleratio(dratio2);

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
