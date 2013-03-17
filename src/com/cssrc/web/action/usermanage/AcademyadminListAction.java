package com.cssrc.web.action.usermanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class AcademyadminListAction extends Action {
	public AcademyadminListAction() {
	}

	private IUserDAO userDAO;
	private Object[] obj;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String userrole = (String) httpServletRequest.getParameter("userrole");
		if (userrole == null || userrole.equals("VIP") || userrole.equals("SystemAdmin")) {
			userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		}
		if (userrole.equals("学会管理员")) {
			userrole = "AcademyAdmin";
		}
		try {

			QueryForm form = (QueryForm) actionForm;
			String searchsql = getSearchsql(form, userrole);
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
			List list = new ArrayList();
			List result = new ArrayList();
			list = userDAO.getsqlresult(searchsql, obj);

			for (int i = 0; i < list.size(); i++) {
				User bean = new User();
				bean = (User) list.get(i);
				bean.setUserrole("学会管理员");
				listresult.add(bean);
			}
			if (listresult.size() >= offset + pagesize) {
				result = listresult.subList(offset, offset + pagesize);
			} else {
				result = listresult.subList(offset, listresult.size());
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, listresult.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("userrole", userrole);
			httpServletRequest.setAttribute("ACADEMYADMINLIST", result);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private String getSearchsql(QueryForm form, String userrole) {
		this.obj = null;
		String searchitem1 = form.getSearchitem1();
		String searchvalue1 = form.getSearchvalue1();
		List list = new ArrayList();

		StringBuffer searchsql = new StringBuffer();
		searchsql.append("from User where userrole = '" + userrole + "' ");
		if (searchitem1.equals("useraccount") && (!searchvalue1.equals(""))) {
			searchsql.append("and useraccount like" + " ? ");

			list.add("%" + searchvalue1 + "%");
		}
		if (searchitem1.equals("useracademic") && (!searchvalue1.equals(""))) {
			searchsql.append("and useracademic like " + " ? ");

			list.add("%" + searchvalue1 + "%");
		}
		obj = list.toArray();
		return searchsql.toString();
	}

}
