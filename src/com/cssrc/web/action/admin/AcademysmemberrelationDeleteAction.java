package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.web.form.admin.AcademysmemberrelationForm;

public class AcademysmemberrelationDeleteAction extends Action {
	public AcademysmemberrelationDeleteAction() {
	}

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademysmemberrelationForm form = new AcademysmemberrelationForm();
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		Academysmemberrelation bean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
		form.setIsdelete(bean.getIsdelete());
		if (!academysmemberrelationDAO.removeAcademysmemberrelation(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
