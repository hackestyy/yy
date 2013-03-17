package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberresearchproduction;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;

public class SearchSmemberresearchproductionDeleteAction extends Action {
	public SearchSmemberresearchproductionDeleteAction() {
	}

	private ISmemberresearchproductionDAO smemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer smrp_id = Integer.valueOf(httpServletRequest.getParameter("smrp_id"));
		Smemberresearchproduction bean = smemberresearchproductionDAO.getSmemberresearchproduction(smrp_id);
		if (!smemberresearchproductionDAO.removeSmemberresearchproduction(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public ISmemberresearchproductionDAO getSmemberresearchproductionDAO() {
		return smemberresearchproductionDAO;
	}

	public void setSmemberresearchproductionDAO(ISmemberresearchproductionDAO smemberresearchproductionDAO) {
		this.smemberresearchproductionDAO = smemberresearchproductionDAO;
	}

}
