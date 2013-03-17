package com.cssrc.dao.impl.stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.IScholarstatDAO;

public class ScholarstatDAOImpl extends HibernateDaoSupport implements IScholarstatDAO {

	public List getSysscholarstat() {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.memscholar, b.number, b.ratio from t_memscholarstat_string a left join (select memscholar, count(*) as number, count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库')) as ratio from v_person_properties where assoname not in ('常委、委员子库') group by memscholar) b on a.memscholar = b.memscholar";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("memscholar"));
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

	public List getAcadscholarstat(Integer shai_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.memscholar, b.number, b.ratio from t_memscholarstat_string a left join (select memscholar, count(*) as number, count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and shai_id = " + shai_id + ") as ratio from v_person_properties where assoname not in ('常委、委员子库') and shai_id = " + shai_id + " group by memscholar) b on a.memscholar = b.memscholar";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("memscholar"));
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

	public List getAcademyscholarstat(Integer abi_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.memscholar, b.number, b.ratio from t_memscholarstat_string a left join (select memscholar, count(*) as number, count(*)/(select count(*) from v_person_properties where assoname not in ('常委、委员子库') and abi_id = " + abi_id + ") as ratio from v_person_properties where assoname not in ('常委、委员子库') and abi_id = " + abi_id + " group by memscholar) b on a.memscholar = b.memscholar";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAgesegment(rs.getString("memscholar"));
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
