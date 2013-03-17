package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyorganizationinfo;
import com.cssrc.dao.admin.IAcademyorganizationinfoDAO;

public class AcademyorganizationinfoDeleteAction extends Action {
	public AcademyorganizationinfoDeleteAction() {
	}

	private IAcademyorganizationinfoDAO academyorganizationinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer aoi_id = Integer.valueOf(httpServletRequest.getParameter("aoi_id"));
		Academyorganizationinfo bean = academyorganizationinfoDAO.getAcademyorganizationinfo(aoi_id);
		if (!academyorganizationinfoDAO.removeAcademyorganizationinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademyorganizationinfoDAO getAcademyorganizationinfoDAO() {
		return academyorganizationinfoDAO;
	}

	public void setAcademyorganizationinfoDAO(IAcademyorganizationinfoDAO academyorganizationinfoDAO) {
		this.academyorganizationinfoDAO = academyorganizationinfoDAO;
	}

}
