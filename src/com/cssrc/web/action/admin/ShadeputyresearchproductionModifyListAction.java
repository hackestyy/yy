package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IShadeputyresearchproductionDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class ShadeputyresearchproductionModifyListAction extends Action {
	public ShadeputyresearchproductionModifyListAction() {
	}

	private IShadeputyresearchproductionDAO shadeputyresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer tempshadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		Integer shadbi_id = tempshadbi_id.intValue();

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
			Integer size = shadeputyresearchproductionDAO.getSize(shadbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where shadbi_id = " + shadbi_id;
			if (pagesize == 0) {
				tAfBookentrys = shadeputyresearchproductionDAO.list(searchsql);
			} else {
				tAfBookentrys = shadeputyresearchproductionDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("shadbi_id", shadbi_id);
			httpServletRequest.getSession().setAttribute("SHADEPUTYRESEARCHPRODUCTIONLIST", tAfBookentrys);

		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputyresearchproductionDAO getShadeputyresearchproductionDAO() {
		return shadeputyresearchproductionDAO;
	}

	public void setShadeputyresearchproductionDAO(IShadeputyresearchproductionDAO shadeputyresearchproductionDAO) {
		this.shadeputyresearchproductionDAO = shadeputyresearchproductionDAO;
	}

}
