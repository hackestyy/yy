package com.cssrc.dao.impl.stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.IGatherinfoDAO;

public class GatherinfoDAOImpl extends HibernateDaoSupport implements IGatherinfoDAO {

	public List getSysgatherinfo() {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select a.StatContent, b.number, b.ratio from t_TotalInfoStat_string a left join(select MemSex as StatContent, count(*) as number, count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) as ratio from v_person_properties where assoname not in ('常委、委员子库') group by MemSex union select MemNation_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) from v_person_properties where assoname not in ('常委、委员子库') group by MemNation_S union select MemNationality_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) from v_person_properties where assoname not in ('常委、委员子库') group by MemNationality_S union select agesegment, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) from v_person_properties where assoname not in ('常委、委员子库') group by agesegment union select MemParty_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) from v_person_properties where assoname not in ('常委、委员子库') group by MemParty_S union select MemScholar, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) from v_person_properties where assoname not in ('常委、委员子库') group by MemScholar union select MemRank_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) from v_person_properties where assoname not in ('常委、委员子库') group by MemRank_S) b on a.StatContent = b.StatContent");
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

	// 求汇总表的总人数
	public Integer getSysgatherinfototalpeo() {
		Integer totalpeo = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(*) as totalpeo from v_person_properties where assoname not in ('常委、委员子库')");
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

	public List getAcadgatherinfo(Integer shai_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.StatContent, b.number, b.ratio from t_TotalInfoStat_string a left join (select MemSex as StatContent, count(*) as number, count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + ") as ratio from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by MemSex union select MemNation_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + ") from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by MemNation_S union select MemNationality_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id
					+ ") from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by MemNationality_S union select agesegment, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + ") from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by agesegment union select MemParty_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + ") from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by MemParty_S union select MemScholar, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id
					+ ") from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by MemScholar union select MemRank_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + ") from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + " group by MemRank_S) b on a.StatContent = b.StatContent";
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

	// 求汇总表的总人数
	public Integer getAcadgatherinfototalpeo(Integer shai_id) {
		Integer totalpeo = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(*) as totalpeo from v_person_properties where assoname not in ('常委、委员子库') and shai_id=" + shai_id + "");
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

	public List getAcademygatherinfo(Integer abi_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.StatContent, b.number, b.ratio from t_TotalInfoStat_string a left join (select MemSex as StatContent, count(*) as number, count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + ") as ratio from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by MemSex union select MemNation_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + ") from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by MemNation_S union select MemNationality_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id
					+ ") from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by MemNationality_S union select agesegment, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + ") from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by agesegment union select MemParty_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + ") from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by MemParty_S union select MemScholar, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id
					+ ") from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by MemScholar union select MemRank_S, count(*), count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + ") from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + " group by MemRank_S) b on a.StatContent = b.StatContent";
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

	// 求汇总表的总人数
	public Integer getAcademygatherinfototalpeo(Integer abi_id) {
		Integer totalpeo = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(*) as totalpeo from v_person_properties where assoname not in ('常委、委员子库') and abi_id=" + abi_id + "");
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
