package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SmemberresearchproductionQueryAction extends Action {
	public SmemberresearchproductionQueryAction() {
	}

	private ISmemberresearchproductionDAO smemberresearchproductionDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		try {
			EntrySearchForm form = (EntrySearchForm) actionForm;
			Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
			int offset = 0;
			String searchsql = form.getSearchsql();
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();

			String searchaction = httpServletRequest.getParameter("searchaction");

			if (searchaction == null) {
				searchaction = "list";
			}
			searchsql = getSearchsql(form, smbi_id);
			form.setSearchsql(searchsql);
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

			Integer size = smemberresearchproductionDAO.getSize(smbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List list = new ArrayList();
			List smemberresearchproductionAfBookentrys = new ArrayList();
			List smemberbaseinfoAfBookentrys = new ArrayList();
			if (pagesize == 0) {
				smemberresearchproductionAfBookentrys = smemberresearchproductionDAO.list(searchsql);
			} else {
				smemberresearchproductionAfBookentrys = smemberresearchproductionDAO.list(searchsql, offset, pagesize);
				smemberbaseinfoAfBookentrys = smemberbaseinfoDAO.list(searchsql);
				String url = httpServletRequest.getRequestURI();
				String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
				httpServletRequest.setAttribute("pagerHeader", pagerHeader);
				httpServletRequest.setAttribute("SMEMBERRESEARCHPRODUCTION", smemberresearchproductionAfBookentrys);
				httpServletRequest.setAttribute("SMEMBERBASEINFO", smemberbaseinfoAfBookentrys);
			}

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	private String getSearchsql(EntrySearchForm form, long fno) {
		String searchitem = form.getSearchitem();
		String condition = form.getCondition();
		String searchvalue = form.getSearchvalue();
		StringBuffer searchsql = new StringBuffer();

		if (!searchvalue.equals("")) {
			searchsql.append(" where " + searchitem + " " + condition + " ");
			if (condition.equals("like")) {
				searchsql.append(" '%" + searchvalue + "%' and fno = " + fno);
			} else {
				searchsql.append("'" + searchvalue + "'%' and fno = " + fno);
			}
		} else {
			searchsql.append("where fno = " + fno);
		}
		return searchsql.toString();
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public ISmemberresearchproductionDAO getSmemberresearchproductionDAO() {
		return smemberresearchproductionDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public void setSmemberresearchproductionDAO(ISmemberresearchproductionDAO smemberresearchproductionDAO) {
		this.smemberresearchproductionDAO = smemberresearchproductionDAO;
	}
}
