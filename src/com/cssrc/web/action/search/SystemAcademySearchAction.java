package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class SystemAcademySearchAction extends Action {
	public SystemAcademySearchAction() {
	}

	private IAcadgroupDAO acadgroupDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// 以actionForm的形式提交，和用户管理中用户翻页及学会会员管理翻页不同 currentpage、pagesize获得方式不同

		QueryForm form = (QueryForm) actionForm;
		try {// 翻页的过程中抓住pagesize、curpage、offset就行了
			String searchsql = getSearchsql(form);

			List list = new ArrayList();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction != null) {
				if (searchaction.equals("list")) {
					httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
				}
				if (searchaction.equals("search")) {
					httpServletRequest.getSession().setAttribute("SEARCHCONDITION", searchsql);
					curpage = 1;
					form.resetReseach();
				} else if (searchaction.equals("goto")) {
					offset = (curpage - 1) * pagesize;
				} else if (searchaction.equals("reset")) {
					httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
					form.reset();
					curpage = form.getCurpage();
					pagesize = form.getPagesize();
				}
			} else {
				String tempsearchsql = (String) httpServletRequest.getSession().getAttribute("SEARCHCONDITION");
				if (tempsearchsql != null) {
					searchsql = tempsearchsql;
				}
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if (httpServletRequest.getParameter("pagesize") != null) {
					pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
				}
				// 第一次进当前页面时pager.offset必然为null
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
			List listresult = new ArrayList();
			list = academybaseinfoDAO.getSqlresult1(searchsql);
			if (list.size() >= offset + pagesize) {
				listresult = list.subList(offset, offset + pagesize);
			} else {
				listresult = list.subList(offset, list.size());
			}
			httpServletRequest.setAttribute("ACADEMYSEARCHLIST", listresult);
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, list.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	private String getSearchsql(QueryForm form) {

		String searchitem1 = form.getSearchitem1();
		String searchitem2 = form.getSearchitem2();
		String searchvalue1 = form.getSearchvalue1();
		String searchvalue2 = form.getSearchvalue2();
		StringBuffer searchsql = new StringBuffer();
		searchsql.append("select shai_id, abi_id, acadname, acadno from t_Academybaseinfo  where 1=1 ");
		if (searchitem1.equals("acadname") && (!searchvalue1.equals(""))) {
			searchsql.append("and acadname like" + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("acadno") && (!searchvalue1.equals(""))) {
			searchsql.append("and acadno like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem2.equals("acadname") && (!searchvalue2.equals(""))) {
			searchsql.append("and acadname like" + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("acadno") && (!searchvalue2.equals(""))) {
			searchsql.append("and acadno like " + " '%" + searchvalue2 + "%'");
		}

		// searchsql.append(" order by s_id")
		return searchsql.toString();

	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
