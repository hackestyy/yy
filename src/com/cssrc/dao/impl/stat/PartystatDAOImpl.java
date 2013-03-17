package com.cssrc.dao.impl.stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.IPartystatDAO;

public class PartystatDAOImpl extends HibernateDaoSupport implements IPartystatDAO {
	public List getPartystat() {
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

	public List getAcadpartystat(Integer shai_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.partyname, b.number, b.ratio from t_partyname_string a left join(select party,count(smbi_id) as number,count(smbi_id)/(select count(smbi_id) from v_partystat where shai_id = " + shai_id + ") as ratio from v_partystat where shai_id = " + shai_id + " group by party) b on a.partyname = b.party";
			ResultSet rs = stmt.executeQuery(sqlSearch);
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

	public List getAcademypartystat(Integer abi_id) {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			String sqlSearch = "select a.partyname, b.number, b.ratio from t_partyname_string a left join(select party,count(smbi_id) as number,count(smbi_id)/(select count(smbi_id) from v_partystat where abi_id = " + abi_id + ") as ratio from v_partystat where abi_id = " + abi_id + " group by party) b on a.partyname = b.party";
			ResultSet rs = stmt.executeQuery(sqlSearch);
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

}
