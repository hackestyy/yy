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

public class AcademyspecialitycommitteeSaveAction extends Action {
	public AcademyspecialitycommitteeSaveAction() {
	}

	private IAcademyspecialitycommitteeDAO academyspecialitycommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyspecialitycommitteeForm form = (AcademyspecialitycommitteeForm) actionForm;
		Academyspecialitycommittee bean = new Academyspecialitycommittee();

		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (!academyspecialitycommitteeDAO.saveAcademyspecialitycommittee(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("asc_id", bean.getAsc_id());
		return actionMapping.findForward("success");
	}

	public IAcademyspecialitycommitteeDAO getAcademyspecialitycommitteeDAO() {
		return academyspecialitycommitteeDAO;
	}

	public void setAcademyspecialitycommitteeDAO(IAcademyspecialitycommitteeDAO academyspecialitycommitteeDAO) {
		this.academyspecialitycommitteeDAO = academyspecialitycommitteeDAO;
	}

}
