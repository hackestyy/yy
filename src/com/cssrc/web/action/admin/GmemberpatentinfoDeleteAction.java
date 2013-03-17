package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberpatentinfo;
import com.cssrc.dao.admin.IGmemberpatentinfoDAO;

public class GmemberpatentinfoDeleteAction extends Action {
	public GmemberpatentinfoDeleteAction() {
	}

	private IGmemberpatentinfoDAO gmemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer gmpi_id = Integer.valueOf(httpServletRequest.getParameter("gmpi_id"));
		Gmemberpatentinfo bean = gmemberpatentinfoDAO.getGmemberpatentinfo(gmpi_id);
		if (!gmemberpatentinfoDAO.removeGmemberpatentinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IGmemberpatentinfoDAO getGmemberpatentinfoDAO() {
		return gmemberpatentinfoDAO;
	}

	public void setGmemberpatentinfoDAO(IGmemberpatentinfoDAO gmemberpatentinfoDAO) {
		this.gmemberpatentinfoDAO = gmemberpatentinfoDAO;
	}
}
