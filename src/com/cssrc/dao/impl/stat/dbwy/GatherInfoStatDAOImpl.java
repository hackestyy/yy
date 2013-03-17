package com.cssrc.dao.impl.stat.dbwy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.IGatherInfoStatDAO;

public class GatherInfoStatDAOImpl extends HibernateDaoSupport implements IGatherInfoStatDAO {

	public List getAllGatherInfoStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.StatContent, b.number, b.ratio " + "from t_TotalInfoStat_string a left join " + "(select memsex as statcontent, count(memno) as number, count(memno)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c) as ratio from (select distinct memno,memsex from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') d group by memsex " + "union " + "select memnation_s as statcontent, count(memnation_s) as number, count(memnation_s)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s
					+ "') c) as ratio from (select distinct memno,memnation_s from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') d group by memnation_s " + "union " + "select memnationality_s as statcontent, count(memnationality_s) as number, count(memnationality_s)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c) as ratio from (select distinct memno,memnationality_s from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') d group by memnationality_s " + "union "
					+ "select agesegment as statcontent, count(agesegment) as number, count(agesegment)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c) as ratio from (select distinct memno,agesegment from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') d group by agesegment " + "union " + "select memparty_s as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c) as ratio from (select distinct memno,memparty_s from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s
					+ "') d group by memparty_s " + "union " + "select memscholar as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c) as ratio from (select distinct memno,memscholar from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') d group by memscholar " + "union " + "select memrank_s as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c) as ratio from (select distinct memno,memrank_s from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='"
					+ assoduty_s + "') d group by memrank_s) b " + "on a.StatContent = b.StatContent";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
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

	// 求汇总表总人数
	public Integer getDBWYAllGatherInfoTotalPeo(String assoduty_s) {
		Integer totalpeo = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(memno) as totalpeo from (select distinct memno from v_statdbwy where assoduty_s='" + assoduty_s + "' or assoduty_s_history='" + assoduty_s + "') c");
			while (rs.next()) {
				totalpeo = Integer.valueOf(rs.getInt("totalpeo"));
			}
			rs.close();
			stmt.close();
			rs = null;
			stmt = null;
			return totalpeo;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}

	}

	public List getWYGatherInfoStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.StatContent, b.number, b.ratio " + "from t_TotalInfoStat_string a left join " + "(select memsex as statcontent, count(memno) as number, count(memno)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,memsex from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by memsex "
					+ "union select memnation_s as statcontent, count(memnation_s) as number, count(memnation_s)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,memnation_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by memnation_s " + "union select memnationality_s as statcontent, count(memnationality_s) as number, count(memnationality_s)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s
					+ "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,memnationality_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by memnationality_s " + "union select agesegment as statcontent, count(agesegment) as number, count(agesegment)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,agesegment from v_statdbwy where (assoduty_s='"
					+ assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by agesegment " + "union select memparty_s as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,memparty_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by memparty_s "
					+ "union select memscholar as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,memscholar from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by memscholar " + "union select memrank_s as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='"
					+ assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c) as ratio from (select distinct memno,memrank_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) d group by memrank_s) b on a.StatContent = b.StatContent";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
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

	// 求汇总表总人数
	public Integer getDBWYWYGatherInfoTotalPeo(String assoduty_s) {
		Integer totalpeo = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(memno) as totalpeo from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3,4)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3,4))) c");
			while (rs.next()) {
				totalpeo = Integer.valueOf(rs.getInt("totalpeo"));
			}
			rs.close();
			stmt.close();
			rs = null;
			stmt = null;
			return totalpeo;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}

	}

	public List getCWGatherInfoStat(String assoduty_s) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.StatContent, b.number, b.ratio " + "from t_TotalInfoStat_string a left join " + "(select memsex as statcontent, count(memno) as number, count(memno)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,memsex from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by memsex "
					+ "union select memnation_s as statcontent, count(memnation_s) as number, count(memnation_s)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,memnation_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by memnation_s " + "union select memnationality_s as statcontent, count(memnationality_s) as number, count(memnationality_s)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s
					+ "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,memnationality_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by memnationality_s " + "union select agesegment as statcontent, count(agesegment) as number, count(agesegment)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,agesegment from v_statdbwy where (assoduty_s='" + assoduty_s
					+ "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by agesegment " + "union select memparty_s as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,memparty_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by memparty_s "
					+ "union select memscholar as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,memscholar from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by memscholar " + "union select memrank_s as statcontent, count(*) as number, count(*)/(select count(memno) from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s
					+ "' and  assoduty_f_history in (0,1,2,3))) c) as ratio from (select distinct memno,memrank_s from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) d group by memrank_s) b " + "on a.StatContent = b.StatContent";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
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

	// 求汇总表总人数
	public Integer getDBWYCWGatherInfoTotalPeo(String assoduty_s) {
		Integer totalpeo = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(memno) as totalpeo from (select distinct memno from v_statdbwy where (assoduty_s='" + assoduty_s + "' and assoduty_f in (0,1,2,3)) or (assoduty_s_history='" + assoduty_s + "' and  assoduty_f_history in (0,1,2,3))) c");
			while (rs.next()) {
				totalpeo = Integer.valueOf(rs.getInt("totalpeo"));
			}
			rs.close();
			stmt.close();
			rs = null;
			stmt = null;
			return totalpeo;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
			s = null;
		}

	}

}
