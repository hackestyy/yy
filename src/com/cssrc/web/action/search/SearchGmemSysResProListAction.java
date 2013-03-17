package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberresearchproduction;
import com.cssrc.dao.admin.IGmemberresearchproductionDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SearchGmemSysResProListAction extends Action {
	public SearchGmemSysResProListAction() {

	}

	private IGmemberresearchproductionDAO gmemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer tempgmbi_id = (Integer) httpServletRequest.getSession().getAttribute("gmbi_id");
		Integer gmbi_id = tempgmbi_id.intValue();

		Gmemberresearchproduction bean = gmemberresearchproductionDAO.getGmemberresearchproduction(gmbi_id);
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
			Integer size = gmemberresearchproductionDAO.getSize(gmbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where gmbi_id = " + gmbi_id;
			if (pagesize == 0) {
				tAfBookentrys = gmemberresearchproductionDAO.list(searchsql);
			} else {
				tAfBookentrys = gmemberresearchproductionDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("gmbi_id", gmbi_id);
			httpServletRequest.getSession().setAttribute("GMEMBERRESEARCHPRODUCTIONLIST", tAfBookentrys);

		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");

		}
		return actionMapping.findForward("success");

	}

	public IGmemberresearchproductionDAO getGmemberresearchproductionDAO() {
		return gmemberresearchproductionDAO;
	}

	public void setGmemberresearchproductionDAO(IGmemberresearchproductionDAO gmemberresearchproductionDAO) {
		this.gmemberresearchproductionDAO = gmemberresearchproductionDAO;
	}

}
