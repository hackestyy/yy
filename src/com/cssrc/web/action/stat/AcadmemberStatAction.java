package com.cssrc.web.action.stat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.stat.MembershipStat;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class AcadmemberStatAction extends Action {
	public AcadmemberStatAction() {
	}

	private String dbDriver = "com.mysql.jdbc.Driver";

	private String dbUrl = "jdbc:mysql://127.0.0.1:3306/shsadb?characterEncoding=UTF-8";

	private String username = "hao";

	private String password = "hao";

	Connection conn = null;

	Statement stmt = null;

	ResultSet rs = null;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		QueryForm form = (QueryForm) actionForm;

		Integer shai_id = (Integer) (httpServletRequest.getSession().getAttribute("shai_id"));

		try {
			Class.forName(dbDriver); // º”‘ÿmysql«˝∂Ø
			conn = DriverManager.getConnection(dbUrl, username, password);
			stmt = conn.createStatement();
			String searchsql = getSearchsql(form, shai_id);
			List list = new ArrayList();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction == null) {
				searchaction = "list";
			}
			if (searchaction.equals("search")) {
				curpage = 1;
				form.resetReseach();
			} else if (searchaction.equals("goto")) {
				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
				searchsql = form.getSearchsql();
			} else {
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if ((pageOffset == null) || pageOffset.equals("")) {
					offset = 0;
				} else {
					offset = Integer.parseInt(pageOffset);
				}
				if (pagesize != 0) {
					form.setCurpage((offset / pagesize) + 1);
				} else {
					form.setCurpage(1);
				}
			}

			rs = stmt.executeQuery(searchsql);
			Integer i = 0;
			while (rs.next()) {
				MembershipStat bean = new MembershipStat();
				i++;
				bean.setSerialnumber(i);
				bean.setAcademyname(rs.getString("Acadname"));
				bean.setPersonnumber(rs.getInt("peoplenum"));
				list.add(bean);
			}

			rs.close();
			stmt.close();
			conn.close();

			httpServletRequest.setAttribute("MEMBERSHIPSTATLIST", list);
			httpServletRequest.getSession().setAttribute("searchshai_id", shai_id);
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, list.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	private String getSearchsql(QueryForm form, Integer shai_id) {
		StringBuffer searchsql = new StringBuffer();
		searchsql.append("select AcadName, peoplenum from ((select AcadName,abi_id from T_AcademyBaseInfo where shai_id= shai_id) d left join (select a.abi_id,  count(a.abi_id) peoplenum from T_AcademyBaseInfo a,T_AcademySMemberRelation b where a.ABI_ID=b.ABI_ID and a.shai_id=shai_id and b.isdelete<1 group by a.abi_id) c on c.abi_id=d.abi_id)");

		return searchsql.toString();
	}

}
