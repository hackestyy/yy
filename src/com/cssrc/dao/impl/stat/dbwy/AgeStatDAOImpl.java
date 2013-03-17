package com.cssrc.dao.impl.stat.dbwy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.IAgeStatDAO;

public class AgeStatDAOImpl extends HibernateDaoSupport implements IAgeStatDAO {

	public List getAllAgeStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.agesegment, d.number, d.ratio " + "from t_agesegment_string a " + "left join " + "(select agesegment,count(agesegment) as number, " + "count(agesegment)/(select count(*) from (select distinct memno,agesegment from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') b) as ratio " + "from (select distinct memno,agesegment from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c group by agesegment) d " + "on a.agesegment =d.agesegment";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("agesegment"));
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

	public List getWYAgeStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.agesegment, d.number, d.ratio from t_agesegment_string a left join (select agesegment,count(agesegment) as number, count(agesegment)/(select count(*) from (select distinct memno,agesegment from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) b) as ratio from (select distinct memno,agesegment from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c group by agesegment) d on a.agesegment =d.agesegment";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("agesegment"));
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

	public List getCWAgeStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.agesegment, d.number, d.ratio from t_agesegment_string a left join (select agesegment,count(agesegment) as number, count(agesegment)/(select count(*) from (select distinct memno,agesegment from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) b) as ratio from (select distinct memno,agesegment from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c group by agesegment) d on a.agesegment =d.agesegment";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("agesegment"));
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

}
