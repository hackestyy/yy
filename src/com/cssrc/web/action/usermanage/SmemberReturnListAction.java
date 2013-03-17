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
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SmemberReturnListAction extends Action {
	public SmemberReturnListAction() {
	}

	private IUserDAO userDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		try {
			EntrySearchForm form = new EntrySearchForm();
			int offset = 0;
			String searchsql = form.getSearchsql();
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
				httpServletRequest.getSession().removeAttribute("CONDITION");
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
				searchsql = form.getSearchsql();
			} else {
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if (httpServletRequest.getParameter("pagesize") != null) {
					pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
				}
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
			Integer usersize = userDAO.getSize1(userrole);
			Integer size = usersize.intValue();

			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			List userlist = new ArrayList();
			String usersearchsql = "where userrole = '" + userrole + "'";
			if (pagesize == 0) {
				tAfBookentrys = userDAO.list(usersearchsql);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					User bean = new User();
					bean = (User) tAfBookentrys.get(i);
					bean.setUserrole("普通会员");
					userlist.add(bean);
				}
			} else {
				tAfBookentrys = userDAO.list(usersearchsql, offset, pagesize);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					User bean = new User();
					bean = (User) tAfBookentrys.get(i);
					bean.setUserrole("普通会员");
					userlist.add(bean);
				}
			}
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("userrole", userrole);
			httpServletRequest.setAttribute("SMEMBERLIST", userlist);

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

}
