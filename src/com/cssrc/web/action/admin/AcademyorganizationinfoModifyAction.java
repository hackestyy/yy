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

public class AcademyorganizationinfoModifyAction extends Action {
	public AcademyorganizationinfoModifyAction() {
	}

	private IAcademyorganizationinfoDAO academyorganizationinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyorganizationinfoForm form = new AcademyorganizationinfoForm();
		Integer aoi_id = Integer.valueOf(httpServletRequest.getParameter("aoi_id"));
		Academyorganizationinfo bean = academyorganizationinfoDAO.getAcademyorganizationinfo(aoi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

		httpServletRequest.setAttribute("academyorganizationinfoForm", form);
		httpServletRequest.getSession().setAttribute("aoi_id", aoi_id);
		return actionMapping.findForward("success");
	}

	public IAcademyorganizationinfoDAO getAcademyorganizationinfoDAO() {
		return academyorganizationinfoDAO;
	}

	public void setAcademyorganizationinfoDAO(IAcademyorganizationinfoDAO academyorganizationinfoDAO) {
		this.academyorganizationinfoDAO = academyorganizationinfoDAO;
	}

}
