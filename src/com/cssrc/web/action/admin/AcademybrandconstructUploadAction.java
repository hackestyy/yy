package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcademybrandconstructDAO;

public class AcademybrandconstructUploadAction extends Action {
	public AcademybrandconstructUploadAction() {
	}

	private IAcademybrandconstructDAO academybrandconstructDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		return actionMapping.findForward("success");
	}

	public IAcademybrandconstructDAO getAcademybrandconstructDAO() {
		return academybrandconstructDAO;
	}

	public void setAcademybrandconstructDAO(IAcademybrandconstructDAO academybrandconstructDAO) {
		this.academybrandconstructDAO = academybrandconstructDAO;
	}
}
