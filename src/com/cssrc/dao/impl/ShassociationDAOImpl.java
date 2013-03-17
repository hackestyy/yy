package com.cssrc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.admin.Shassociationinfo;
import com.cssrc.dao.admin.IShassociationDAO;

public class ShassociationDAOImpl extends HibernateDaoSupport implements IShassociationDAO {

	public boolean selectAssonName(String searchsql) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(searchsql);
			while (rs.next()) {
				rs.close();
				stmt.close();
				return false;
			}
			rs.close();
			stmt.close();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			s.disconnect();
			s.close();
		}
	}

	public List selectIdandName() {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			// 常委、委员子库;
			String sql = "select * from t_Shassociationinfo where assoname not in ('常委、委员子库')";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Shassociationinfo bean = new Shassociationinfo();
				bean.setShai_id(rs.getInt("shai_id"));
				bean.setAssoname(rs.getString("assoname"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
			return list;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
		}

	}

	public String selAssoNamebyID(Integer shai_id) {
		try {
			List result = this.getHibernateTemplate().find("select assoname from Shassociationinfo where shai_id =" + shai_id);
			return result.get(0).toString();
		} catch (Exception ex) {
			return null;
		}
	}
}
