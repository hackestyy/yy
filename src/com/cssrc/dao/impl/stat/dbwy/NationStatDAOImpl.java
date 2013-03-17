package com.cssrc.dao.impl.stat.dbwy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.INationStatDAO;

public class NationStatDAOImpl extends HibernateDaoSupport implements INationStatDAO {

	public List getAllNationStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as number, " + "sum(case when MemNation_S='汉族' then 1 else 0 end) as hannationality, " + "sum(case when MemNation_S='汉族' then 1 else 0 end)/count(*) as hannationalityratio, " + "sum(case when MemNation_S='少数民族' then 1 else 0 end) as minority, " + "sum(case when MemNation_S='少数民族' then 1 else 0 end)/count(*) as minorityratio " + "from (select distinct memno,MemNation_S from v_statdbwy " + "where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setCountshai_id(rs.getInt("number"));
				bean.setMale(rs.getInt("hannationality"));

				Double dtemp = rs.getDouble("hannationalityratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setMaleratio(dratio);

				bean.setFemale(rs.getInt("minority"));

				Double dtemp2 = rs.getDouble("minorityratio") * 100;
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

	public List getWYNationStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as number, " + "sum(case when MemNation_S='汉族' then 1 else 0 end) as hannationality, " + "sum(case when MemNation_S='汉族' then 1 else 0 end)/count(*) as hannationalityratio, " + "sum(case when MemNation_S='少数民族' then 1 else 0 end) as minority, " + "sum(case when MemNation_S='少数民族' then 1 else 0 end)/count(*) as minorityratio " + "from (select distinct memno,MemNation_S from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setCountshai_id(rs.getInt("number"));
				bean.setMale(rs.getInt("hannationality"));

				Double dtemp = rs.getDouble("hannationalityratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setMaleratio(dratio);

				bean.setFemale(rs.getInt("minority"));

				Double dtemp2 = rs.getDouble("minorityratio") * 100;
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

	public List getCWNationStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as number, " + "sum(case when MemNation_S='汉族' then 1 else 0 end) as hannationality, " + "sum(case when MemNation_S='汉族' then 1 else 0 end)/count(*) as hannationalityratio, " + "sum(case when MemNation_S='少数民族' then 1 else 0 end) as minority, " + "sum(case when MemNation_S='少数民族' then 1 else 0 end)/count(*) as minorityratio " + "from (select distinct memno,MemNation_S from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) a";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setCountshai_id(rs.getInt("number"));
				bean.setMale(rs.getInt("hannationality"));

				Double dtemp = rs.getDouble("hannationalityratio") * 100;
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
				String stemp = df.format(dtemp);
				Double dratio = Double.valueOf(stemp);
				bean.setMaleratio(dratio);

				bean.setFemale(rs.getInt("minority"));

				Double dtemp2 = rs.getDouble("minorityratio") * 100;
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
