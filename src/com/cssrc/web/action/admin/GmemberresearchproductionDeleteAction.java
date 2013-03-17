package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberresearchproduction;
import com.cssrc.dao.admin.IGmemberresearchproductionDAO;

public class GmemberresearchproductionDeleteAction extends Action {
	public GmemberresearchproductionDeleteAction() {
	}

	private IGmemberresearchproductionDAO gmemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer gmrp_id = Integer.valueOf(httpServletRequest.getParameter("gmrp_id"));
		Gmemberresearchproduction bean = gmemberresearchproductionDAO.getGmemberresearchproduction(gmrp_id);
		if (!gmemberresearchproductionDAO.removeGmemberresearchproduction(bean)) {
			return actionMapping.findForward("errorDelete");
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
