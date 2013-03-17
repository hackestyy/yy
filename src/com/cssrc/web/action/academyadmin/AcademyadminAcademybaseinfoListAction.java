package com.cssrc.web.action.academyadmin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class AcademyadminAcademybaseinfoListAction extends Action {
	public AcademyadminAcademybaseinfoListAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;
	private IAcadgroupDAO acadgroupDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shai_id = Integer.valueOf(httpServletRequest.getParameter("shai_id"));
		String acadname = String.valueOf(httpServletRequest.getSession().getAttribute("acadname"));
		Acadgroup bean = acadgroupDAO.getAcadgroup(shai_id);
		// TODO 常委、委员子库;
		if (bean.getAssoname().equals("常委、委员子库")) {
			try {
				EntrySearchForm form = new EntrySearchForm();
				int offset = 0;
				int curpage = form.getCurpage();
				int pagesize = 50;
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
				Integer size = academybaseinfoDAO.getSize(shai_id);
				if (size.intValue() < offset) {
					offset = 0;
				}
				List tAfBookentrys = new ArrayList();
				String searchsql = "where shai_id = " + shai_id;
				if (pagesize == 0) {
					tAfBookentrys = academybaseinfoDAO.list(searchsql);
				} else {
					tAfBookentrys = academybaseinfoDAO.list(searchsql, offset, pagesize);
				}

				String url = httpServletRequest.getRequestURI();
				String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
				httpServletRequest.setAttribute("pagerHeader", pagerHeader);
				httpServletRequest.setAttribute("academybaseinfoassoname", bean.getAssoname());
				httpServletRequest.getSession().setAttribute("academybaseinfoassoname", bean.getAssoname());
				httpServletRequest.getSession().setAttribute("shai_id", shai_id);
				httpServletRequest.getSession().setAttribute("ACADEMYBASEINFOLIST", tAfBookentrys);

			} catch (Exception e) {
				// errors.add("ErrorMessage", new
				// ActionMessage("error.Exception"));
				// saveErrors(request, errors);
				// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
				// e.getMessage()) );
				return actionMapping.findForward("failure");
			}
			return actionMapping.findForward("shadeputybaseinfosuccess");
		}
		// TODO 常委、委员子库;
		if (!bean.getAssoname().equals("常委、委员子库")) {
			try {
				EntrySearchForm form = new EntrySearchForm();
				int offset = 0;
				int curpage = form.getCurpage();
				int pagesize = 50;
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
				Integer size = academybaseinfoDAO.getSize(shai_id);
				if (size.intValue() < offset) {
					offset = 0;
				}
				List tAfBookentrys = new ArrayList();
				String searchsql = "where shai_id = " + shai_id;
				if (pagesize == 0) {
					tAfBookentrys = academybaseinfoDAO.list(searchsql);
				} else {
					tAfBookentrys = academybaseinfoDAO.list(searchsql, offset, pagesize);
				}

				String url = httpServletRequest.getRequestURI();
				String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
				httpServletRequest.setAttribute("pagerHeader", pagerHeader);
				httpServletRequest.setAttribute("academybaseinfoassoname", bean.getAssoname());
				httpServletRequest.getSession().setAttribute("academybaseinfoassoname", bean.getAssoname());
				httpServletRequest.getSession().setAttribute("shai_id", shai_id);
				httpServletRequest.getSession().setAttribute("ACADEMYBASEINFOLIST", tAfBookentrys);
				httpServletRequest.getSession().setAttribute("acadname", acadname);
				return actionMapping.findForward("success");

			} catch (Exception e) {
				// errors.add("ErrorMessage", new
				// ActionMessage("error.Exception"));
				// saveErrors(request, errors);
				// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
				// e.getMessage()) );
				return actionMapping.findForward("failure");
			}

		}
		return actionMapping.findForward("failure");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

}
