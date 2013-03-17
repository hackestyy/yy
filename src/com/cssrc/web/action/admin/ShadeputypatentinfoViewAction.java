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
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.dao.admin.IShadeputypatentinfoDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class ShadeputypatentinfoViewAction extends Action {
	public ShadeputypatentinfoViewAction() {
	}

	private IShadeputypatentinfoDAO shadeputypatentinfoDAO;
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
			Integer size = shadeputypatentinfoDAO.getSize(shadbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where shadbi_id = " + shadbi_id;
			if (pagesize == 0) {
				tAfBookentrys = shadeputypatentinfoDAO.list(searchsql);
			} else {
				tAfBookentrys = shadeputypatentinfoDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("shadbi_id", shadbi_id);
			httpServletRequest.getSession().setAttribute("SHADEPUTYPATENTINFO", tAfBookentrys);

		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputypatentinfoDAO getShadeputypatentinfoDAO() {
		return shadeputypatentinfoDAO;
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputypatentinfoDAO(IShadeputypatentinfoDAO shadeputypatentinfoDAO) {
		this.shadeputypatentinfoDAO = shadeputypatentinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
