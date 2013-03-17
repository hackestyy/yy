package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;

public class AcademybaseinfocouncilDeleteAction extends Action {
	public AcademybaseinfocouncilDeleteAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));
		Academybaseinfo bean = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		if (!academybaseinfoDAO.removeAcademybaseinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
