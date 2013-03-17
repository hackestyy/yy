package com.cssrc.dao.impl.stat.dbwy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.IRankStatDAO;

public class RankStatDAOImpl extends HibernateDaoSupport implements IRankStatDAO {
	public List getAllRankStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.*, d.number, d.ratio " + "from t_memrankstat_string a " + "left join " + "(select memrank_s,count(memrank_s) as number, " + "count(memrank_s)/(select count(*) from (select distinct memno,memrank_s from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') b) as ratio " + "from (select distinct memno,memrank_s from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c group by memrank_s) d " + "on a.memrank_s = d.memrank_s";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("memrank_s"));
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

	public List getWYRankStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.*, d.number, d.ratio from t_memrankstat_string a left join (select memrank_s,count(memrank_s) as number, count(memrank_s)/(select count(*) from (select distinct memno,memrank_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) b) as ratio from (select distinct memno,memrank_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c group by memrank_s) d on a.memrank_s = d.memrank_s";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("memrank_s"));
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

	public List getCWRankStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.*, d.number, d.ratio from t_memrankstat_string a left join (select memrank_s,count(memrank_s) as number, count(memrank_s)/(select count(*) from (select distinct memno,memrank_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) b) as ratio from (select distinct memno,memrank_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c group by memrank_s) d on a.memrank_s = d.memrank_s";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("memrank_s"));
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
