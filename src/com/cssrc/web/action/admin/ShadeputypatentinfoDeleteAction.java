package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputypatentinfo;
import com.cssrc.dao.admin.IShadeputypatentinfoDAO;

public class ShadeputypatentinfoDeleteAction extends Action {
	public ShadeputypatentinfoDeleteAction() {
	}

	private IShadeputypatentinfoDAO shadeputypatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadpi_id = Integer.valueOf(httpServletRequest.getParameter("shadpi_id"));
		Shadeputypatentinfo bean = shadeputypatentinfoDAO.getShadeputypatentinfo(shadpi_id);
		if (!shadeputypatentinfoDAO.removeShadeputypatentinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputypatentinfoDAO getShadeputypatentinfoDAO() {
		return shadeputypatentinfoDAO;
	}

	public void setShadeputypatentinfoDAO(IShadeputypatentinfoDAO shadeputypatentinfoDAO) {
		this.shadeputypatentinfoDAO = shadeputypatentinfoDAO;
	}

}
