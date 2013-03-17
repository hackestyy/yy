package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcademyspecialitycommitteeDAO;

public class AcademyspecialitycommitteeUploadAction extends Action {
	public AcademyspecialitycommitteeUploadAction() {
	}

	private IAcademyspecialitycommitteeDAO AcademyspecialitycommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		return actionMapping.findForward("success");
	}

	public IAcademyspecialitycommitteeDAO getAcademyspecialitycommitteeDAO() {
		return AcademyspecialitycommitteeDAO;
	}

	public void setAcademyspecialitycommitteeDAO(IAcademyspecialitycommitteeDAO AcademyspecialitycommitteeDAO) {
		this.AcademyspecialitycommitteeDAO = AcademyspecialitycommitteeDAO;
	}

}
