package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyacademicliterature;
import com.cssrc.dao.admin.IShadeputyacademicliteratureDAO;

public class ShadeputyacademicliteratureDeleteAction extends Action {
	public ShadeputyacademicliteratureDeleteAction() {
	}

	private IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadal_id = Integer.valueOf(httpServletRequest.getParameter("shadal_id"));
		Shadeputyacademicliterature bean = shadeputyacademicliteratureDAO.getShadeputyacademicliterature(shadal_id);
		if (!shadeputyacademicliteratureDAO.removeShadeputyacademicliterature(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputyacademicliteratureDAO getShadeputyacademicliteratureDAO() {
		return shadeputyacademicliteratureDAO;
	}

	public void setShadeputyacademicliteratureDAO(IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO) {
		this.shadeputyacademicliteratureDAO = shadeputyacademicliteratureDAO;
	}

}
