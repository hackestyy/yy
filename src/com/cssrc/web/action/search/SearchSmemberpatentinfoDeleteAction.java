package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberpatentinfo;
import com.cssrc.dao.admin.ISmemberpatentinfoDAO;

public class SearchSmemberpatentinfoDeleteAction extends Action {
	public SearchSmemberpatentinfoDeleteAction() {
	}

	private ISmemberpatentinfoDAO smemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer smpi_id = Integer.valueOf(httpServletRequest.getParameter("smpi_id"));
		Smemberpatentinfo bean = smemberpatentinfoDAO.getSmemberpatentinfo(smpi_id);
		if (!smemberpatentinfoDAO.removeSmemberpatentinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public ISmemberpatentinfoDAO getSmemberpatentinfoDAO() {
		return smemberpatentinfoDAO;
	}

	public void setSmemberpatentinfoDAO(ISmemberpatentinfoDAO smemberpatentinfoDAO) {
		this.smemberpatentinfoDAO = smemberpatentinfoDAO;
	}

}
