package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SmemberacademicliteratureAddListAction extends Action {
	public SmemberacademicliteratureAddListAction() {
	}

	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer tempsmbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		Integer smbi_id = tempsmbi_id.intValue();

		Smemberacademicliterature bean = smemberacademicliteratureDAO.getSmemberacademicliterature(smbi_id);

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
			Integer size = smemberacademicliteratureDAO.getSize(smbi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			String searchsql = "where smbi_id = " + smbi_id;
			if (pagesize == 0) {
				tAfBookentrys = smemberacademicliteratureDAO.list(searchsql);
			} else {
				tAfBookentrys = smemberacademicliteratureDAO.list(searchsql, offset, pagesize);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			httpServletRequest.getSession().setAttribute("SMEMBERACADEMICLITERATURELIST", tAfBookentrys);

		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");

		}
		return actionMapping.findForward("success");

	}

	public ISmemberacademicliteratureDAO getSmemberacademicliteratureDAO() {
		return smemberacademicliteratureDAO;
	}

	public void setSmemberacademicliteratureDAO(ISmemberacademicliteratureDAO smemberacademicliteratureDAO) {
		this.smemberacademicliteratureDAO = smemberacademicliteratureDAO;
	}
}
