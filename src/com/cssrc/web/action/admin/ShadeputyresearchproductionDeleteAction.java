package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyresearchproduction;
import com.cssrc.dao.admin.IShadeputyresearchproductionDAO;

public class ShadeputyresearchproductionDeleteAction extends Action {
	public ShadeputyresearchproductionDeleteAction() {
	}

	private IShadeputyresearchproductionDAO shadeputyresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadrp_id = Integer.valueOf(httpServletRequest.getParameter("shadrp_id"));
		Shadeputyresearchproduction bean = shadeputyresearchproductionDAO.getShadeputyresearchproduction(shadrp_id);
		if (!shadeputyresearchproductionDAO.removeShadeputyresearchproduction(bean)) {
			return actionMapping.findForward("errorDelete");
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
