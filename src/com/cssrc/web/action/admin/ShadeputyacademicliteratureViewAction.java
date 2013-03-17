package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.dao.admin.IShadeputyacademicliteratureDAO;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class ShadeputyacademicliteratureViewAction extends Action {
	public ShadeputyacademicliteratureViewAction() {
	}

	private IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO;
	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadbi_id = Integer.valueOf(httpServletRequest.getParameter("shadbi_id"));
		Shadeputybaseinfo bean = shadeputybaseinfoDAO.getShadeputybaseinfo(shadbi_id);
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
			Integer size = shadeputyacademicliteratureDAO.getSize(shadbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where shadbi_id = " + shadbi_id;
			if (pagesize == 0) {
				tAfBookentrys = shadeputyacademicliteratureDAO.list(searchsql);
			} else {
				tAfBookentrys = shadeputyacademicliteratureDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("shadbi_id", shadbi_id);
			httpServletRequest.getSession().setAttribute("SHADEPUTYACADEMICLITERATURE", tAfBookentrys);

		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputyacademicliteratureDAO getShadeputyacademicliteratureDAO() {
		return shadeputyacademicliteratureDAO;
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputyacademicliteratureDAO(IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO) {
		this.shadeputyacademicliteratureDAO = shadeputyacademicliteratureDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
