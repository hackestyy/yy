package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;

public class ShadeputybaseinfoDeleteAction extends Action {
	public ShadeputybaseinfoDeleteAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadbi_id = Integer.valueOf(httpServletRequest.getParameter("shadbi_id"));
		Shadeputybaseinfo bean = shadeputybaseinfoDAO.getShadeputybaseinfo(shadbi_id);
		if (!shadeputybaseinfoDAO.removeShadeputybaseinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}

		return actionMapping.findForward("success");
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
