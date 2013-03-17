package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcademyjournalinfoDAO;

public class AcademyjournalinfoUploadAction extends Action {
	public AcademyjournalinfoUploadAction() {
	}

	private IAcademyjournalinfoDAO academyjournalinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		return actionMapping.findForward("success");
	}

	public IAcademyjournalinfoDAO getAcademyjournalinfoDAO() {
		return academyjournalinfoDAO;
	}

	public void setAcademyjournalinfoDAO(IAcademyjournalinfoDAO academyjournalinfoDAO) {
		this.academyjournalinfoDAO = academyjournalinfoDAO;
	}

}
