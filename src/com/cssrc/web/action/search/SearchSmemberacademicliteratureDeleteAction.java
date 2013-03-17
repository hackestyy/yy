package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;

public class SearchSmemberacademicliteratureDeleteAction extends Action {
	public SearchSmemberacademicliteratureDeleteAction() {
	}

	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer smal_id = Integer.valueOf(httpServletRequest.getParameter("smal_id"));
		Smemberacademicliterature bean = smemberacademicliteratureDAO.getSmemberacademicliterature(smal_id);
		if (!smemberacademicliteratureDAO.removeSmemberacademicliterature(bean)) {
			return actionMapping.findForward("errorDelete");
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
