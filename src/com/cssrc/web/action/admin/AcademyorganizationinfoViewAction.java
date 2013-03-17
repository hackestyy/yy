package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademyorganizationinfoDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class AcademyorganizationinfoViewAction extends Action {
	public AcademyorganizationinfoViewAction() {
	}

	private IAcademyorganizationinfoDAO academyorganizationinfoDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));
		Academybaseinfo bean = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		try {
			EntrySearchForm form = new EntrySearchForm();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
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
			Integer size = academyorganizationinfoDAO.getSize(abi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where abi_id = " + abi_id;
			if (pagesize == 0) {
				tAfBookentrys = academyorganizationinfoDAO.list(searchsql);
			} else {
				tAfBookentrys = academyorganizationinfoDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("abi_id", abi_id);
			httpServletRequest.getSession().setAttribute("ACADEMYORGANIZATIONINFOLIST", tAfBookentrys);

		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IAcademyorganizationinfoDAO getAcademyorganizationinfoDAO() {
		return academyorganizationinfoDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademyorganizationinfoDAO(IAcademyorganizationinfoDAO academyorganizationinfoDAO) {
		this.academyorganizationinfoDAO = academyorganizationinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}
}
