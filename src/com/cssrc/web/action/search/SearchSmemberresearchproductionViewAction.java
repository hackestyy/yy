package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SearchSmemberresearchproductionViewAction extends Action {
	public SearchSmemberresearchproductionViewAction() {
	}

	private ISmemberresearchproductionDAO smemberresearchproductionDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer smbi_id = Integer.valueOf(httpServletRequest.getParameter("smbi_id"));
		Smemberbaseinfo bean = smemberbaseinfoDAO.getSmemberbaseinfo(smbi_id);
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
			Integer size = smemberresearchproductionDAO.getSize(smbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where smbi_id = " + smbi_id;
			if (pagesize == 0) {
				tAfBookentrys = smemberresearchproductionDAO.list(searchsql);
			} else {
				tAfBookentrys = smemberresearchproductionDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			httpServletRequest.getSession().setAttribute("SEARCHSMEMBERRESEARCHPRODUCTIONLIST", tAfBookentrys);

		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
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
