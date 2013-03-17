package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyspecialitycommittee;
import com.cssrc.dao.admin.IAcademyspecialitycommitteeDAO;
import com.cssrc.web.form.admin.AcademyspecialitycommitteeForm;

public class AcademyspecialitycommitteeModifyAction extends Action {
	public AcademyspecialitycommitteeModifyAction() {
	}

	private IAcademyspecialitycommitteeDAO academyspecialitycommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyspecialitycommitteeForm form = new AcademyspecialitycommitteeForm();
		Integer asc_id = Integer.valueOf(httpServletRequest.getParameter("asc_id"));
		Academyspecialitycommittee bean = academyspecialitycommitteeDAO.getAcademyspecialitycommittee(asc_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

		httpServletRequest.setAttribute("academyspecialitycommitteeForm", form);
		httpServletRequest.getSession().setAttribute("asc_id", asc_id);
		return actionMapping.findForward("success");
	}

	public IAcademyspecialitycommitteeDAO getAcademyspecialitycommitteeDAO() {
		return academyspecialitycommitteeDAO;
	}

	public void setAcademyspecialitycommitteeDAO(IAcademyspecialitycommitteeDAO academyspecialitycommitteeDAO) {
		this.academyspecialitycommitteeDAO = academyspecialitycommitteeDAO;
	}

}
