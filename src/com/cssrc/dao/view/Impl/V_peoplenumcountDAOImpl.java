package com.cssrc.dao.view.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.view.IV_peoplenumcountDAO;
import com.cssrc.util.DateUtil;

public class V_peoplenumcountDAOImpl extends HibernateDaoSupport implements IV_peoplenumcountDAO {

	public List getPeopleNumCount() {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			// TODO 常委、委员子库;
			ResultSet rs = stmt.executeQuery("select shai_id,assoname, count(smbi_id) as number from v_peoplenumcount where (isdelete=0 or isdelete is null) and Assoname not in ('常委、委员子库') group by shai_id");
			while (rs.next()) {
				TempBean bean = new TempBean();
				TempBean bean1 = new TempBean();
				int a = 0;
				bean.setShai_id(rs.getInt("shai_id"));
				bean.setAssoname(rs.getString("assoname"));
				bean.setCountshai_id(rs.getInt("number"));
				String name = rs.getString("assoname");
				List list1 = new ArrayList();
				// list1 = list(name);
				// for (int i = 0; i < list1.size(); i++) {
				// String time = (String)list1.get(i);
				// String nowtime =
				// DateUtil.getCalendarString(Calendar.getInstance(), "yyyy");
				// if (time.equals(nowtime)) {
				// a++;
				// }

				// }
				// bean.setTyearnum(a);
				list.add(bean);
			}
			s.close();
			return list;
		} catch (Exception ex) {
			return null;
		}
	}

	public List list(String condition) throws SQLException {
		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;
		conn = s.connection();
		String[] a;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select joindate from v_peoplenumcount where assoname='" + condition + "'");
		try {
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setJoindate(rs.getDate("joindate"));
				if (!(bean.getJoindate() == null))

				{
					String i = DateUtil.getDateString(bean.getJoindate(), "yyyy");
					list.add(i);
				}
				// list.add(bean);
			}
			s.close();
			return list;

		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}

	}

	// 计算总学会净人数
	public Integer getPeoplePureNumCount() {
		Integer peoplepurenumcount = 0;
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select count(smbi_id) as peoplepurenumcount from  (select distinct smbi_id from v_person_properties where Assoname not in ('常委、委员子库')) as a");
			while (rs.next()) {
				peoplepurenumcount = Integer.valueOf(rs.getInt("peoplepurenumcount"));
			}
			rs.close();
			stmt.close();
			return peoplepurenumcount;
		} catch (Exception ex) {
			return null;
		} finally {
			s.disconnect();
			s.close();
		}

	}

	public List getAcadPeopleNumCount(Integer shai_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select abi_id,acadname, count(smbi_id) as number from v_peoplenumcount where shai_id=" + shai_id + " and (isdelete=0 or isdelete is null) group by abi_id");
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAbi_id(rs.getInt("abi_id"));
				bean.setAssoname(rs.getString("acadname"));
				bean.setCountshai_id(rs.getInt("number"));
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

	public List getAcademyPeopleNumCount(Integer abi_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();

		Connection conn = null;

		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select acadno, acadname, count(smbi_id) as number from v_peoplenumcount where abi_id=" + abi_id + " and (isdelete=0 or isdelete is null) group by abi_id");
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setAcadno(rs.getString("acadno"));
				bean.setAssoname(rs.getString("acadname"));
				bean.setCountshai_id(rs.getInt("number"));
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

	public List listalltime(int shai_id) {

		List list = new ArrayList();
		Session s = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = null;
		try {
			conn = s.connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select joindate from v_peoplenumcount where (isdelete=0 or isdelete is null) and Assoname not in ('常委、委员子库') and shai_id=" + shai_id);
			while (rs.next()) {
				TempBean bean = new TempBean();
				TempBean bean1 = new TempBean();
				int a = 0;
				bean.setJoindate(rs.getDate("joindate"));
				List list1 = new ArrayList();
				// list1 = list(name);
				// for (int i = 0; i < list1.size(); i++) {
				// String time = (String)list1.get(i);
				// String nowtime =
				// DateUtil.getCalendarString(Calendar.getInstance(), "yyyy");
				// if (time.equals(nowtime)) {
				// a++;
				// }

				// }
				// bean.setTyearnum(a);
				list.add(bean);
			}
			s.close();
			return list;
		} catch (Exception ex) {
			return null;
		}
	}

}
