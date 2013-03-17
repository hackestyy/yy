package com.cssrc.dao.impl.stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.ISexstatDAO;

public class SexstatDAOImpl extends HibernateDaoSupport implements ISexstatDAO {

	public List getSyssexstat() {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			// TODO 常委、委员子库;
			ResultSet rs = stmt.executeQuery("select a.Assoname, b.number, b.male, b.maleratio, b.female, b.femaleratio from t_shassociationinfo a left join (select AssoName,count(*) as number, sum(case when Memsex='男' then 1 else 0 end) as 'male', sum(case when Memsex='男' then 1 else 0 end)/count(*) as 'maleratio', sum(case when Memsex='女' then 1 else 0 end) as 'female', sum(case when Memsex='女' then 1 else 0 end)/count(*) as 'femaleratio' from v_person_properties where assoname not in ('常委、委员子库') group by AssoName) b on a.Assoname = b.Assoname where a.Assoname not in ('常委、委员子库')");
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAssoname(rs.getString("assoname"));
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

	public List getAcadsexstat(Integer shai_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select a.AcadName, b.number, b.male, b.maleratio, b.female, b.femaleratio from (select Acadname from t_academybaseinfo where shai_id=" + shai_id + ") a left join (select acadname,count(*) as number, sum(case when Memsex='男' then 1 else 0 end) as 'male', sum(case when Memsex='男' then 1 else 0 end)/count(*) as 'maleratio', sum(case when Memsex='女' then 1 else 0 end) as 'female', sum(case when Memsex='女' then 1 else 0 end)/count(*) as 'femaleratio' from v_person_properties c where c.assoname not in ('常委、委员子库') and c.shai_id = " + shai_id + " group by acadname) b on a.AcadName = b.AcadName";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAssoname(rs.getString("acadname"));
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

	public List getAcademysexstat(Integer abi_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sql = "select acadno, acadname,count(*) as number, sum(case when Memsex='男' then 1 else 0 end) as 'male', sum(case when Memsex='男' then 1 else 0 end)/count(*) as 'maleratio', sum(case when Memsex='女' then 1 else 0 end) as 'female', sum(case when Memsex='女' then 1 else 0 end)/count(*) as 'femaleratio' from v_person_properties a where a.assoname not in ('常委、委员子库') and a.abi_id = " + abi_id + " group by abi_id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAcadno(rs.getString("acadno"));
				bean.setAssoname(rs.getString("acadname"));
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
