package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyworkcommittee;
import com.cssrc.dao.admin.IAcademyworkcommitteeDAO;
import com.cssrc.web.form.admin.AcademyworkcommitteeForm;

public class AcademyworkcommitteeModifyAction extends Action {
	public AcademyworkcommitteeModifyAction() {
	}

	private IAcademyworkcommitteeDAO academyworkcommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyworkcommitteeForm form = new AcademyworkcommitteeForm();
		Integer awc_id = Integer.valueOf(httpServletRequest.getParameter("awc_id"));
		Academyworkcommittee bean = academyworkcommitteeDAO.getAcademyworkcommittee(awc_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

		httpServletRequest.setAttribute("academyworkcommitteeForm", form);
		httpServletRequest.getSession().setAttribute("awc_id", awc_id);
		return actionMapping.findForward("success");
	}

	public IAcademyworkcommitteeDAO getAcademyworkcommitteeDAO() {
		return academyworkcommitteeDAO;
	}

	public void setAcademyworkcommitteeDAO(IAcademyworkcommitteeDAO academyworkcommitteeDAO) {
		this.academyworkcommitteeDAO = academyworkcommitteeDAO;
	}
}
