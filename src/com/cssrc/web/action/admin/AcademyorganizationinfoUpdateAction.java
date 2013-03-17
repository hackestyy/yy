package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyorganizationinfo;
import com.cssrc.dao.admin.IAcademyorganizationinfoDAO;
import com.cssrc.web.form.admin.AcademyorganizationinfoForm;

public class AcademyorganizationinfoUpdateAction extends Action {
	public AcademyorganizationinfoUpdateAction() {
	}

	private IAcademyorganizationinfoDAO academyorganizationinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyorganizationinfoForm form = (AcademyorganizationinfoForm) actionForm;
		Academyorganizationinfo bean = new Academyorganizationinfo();

		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (academyorganizationinfoDAO.modifyAcademyorganizationinfo(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IAcademyorganizationinfoDAO getAcademyorganizationinfoDAO() {
		return academyorganizationinfoDAO;
	}

	public void setAcademyorganizationinfoDAO(IAcademyorganizationinfoDAO academyorganizationinfoDAO) {
		this.academyorganizationinfoDAO = academyorganizationinfoDAO;
	}

}
