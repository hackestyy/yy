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

public class AcademyworkcommitteeSaveAction extends Action {
	public AcademyworkcommitteeSaveAction() {
	}

	private IAcademyworkcommitteeDAO academyworkcommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyworkcommitteeForm form = (AcademyworkcommitteeForm) actionForm;
		Academyworkcommittee bean = new Academyworkcommittee();

		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (!academyworkcommitteeDAO.saveAcademyworkcommittee(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("awc_id", bean.getAwc_id());
		return actionMapping.findForward("success");
	}

	public IAcademyworkcommitteeDAO getAcademyworkcommitteeDAO() {
		return academyworkcommitteeDAO;
	}

	public void setAcademyworkcommitteeDAO(IAcademyworkcommitteeDAO academyworkcommitteeDAO) {
		this.academyworkcommitteeDAO = academyworkcommitteeDAO;
	}
}
