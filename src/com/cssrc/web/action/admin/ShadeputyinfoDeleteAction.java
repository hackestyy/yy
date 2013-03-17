package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyinfo;
import com.cssrc.dao.admin.IShadeputyinfoDAO;

public class ShadeputyinfoDeleteAction extends Action {
	public ShadeputyinfoDeleteAction() {
	}

	private IShadeputyinfoDAO shadeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadi_id = Integer.valueOf(httpServletRequest.getParameter("shadi_id"));
		Shadeputyinfo bean = shadeputyinfoDAO.getShadeputyinfo(shadi_id);
		if (!shadeputyinfoDAO.removeShadeputyinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputyinfoDAO getShadeputyinfoDAO() {
		return shadeputyinfoDAO;
	}

	public void setShadeputyinfoDAO(IShadeputyinfoDAO shadeputyinfoDAO) {
		this.shadeputyinfoDAO = shadeputyinfoDAO;
	}

}
