package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyspecialitycommittee;
import com.cssrc.dao.admin.IAcademyspecialitycommitteeDAO;

public class AcademyspecialitycommitteeDeleteAction extends Action {
	public AcademyspecialitycommitteeDeleteAction() {
	}

	private IAcademyspecialitycommitteeDAO academyspecialitycommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer asc_id = Integer.valueOf(httpServletRequest.getParameter("asc_id"));
		Academyspecialitycommittee bean = academyspecialitycommitteeDAO.getAcademyspecialitycommittee(asc_id);
		if (!academyspecialitycommitteeDAO.removeAcademyspecialitycommittee(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademyspecialitycommitteeDAO getAcademyspecialitycommitteeDAO() {
		return academyspecialitycommitteeDAO;
	}

	public void setAcademyspecialitycommitteeDAO(IAcademyspecialitycommitteeDAO academyspecialitycommitteeDAO) {
		this.academyspecialitycommitteeDAO = academyspecialitycommitteeDAO;
	}

}
