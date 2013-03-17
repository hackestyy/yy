package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyjournalinfo;
import com.cssrc.dao.admin.IAcademyjournalinfoDAO;
import com.cssrc.web.form.admin.AcademyjournalinfoForm;

public class AcademyjournalinfoViewAction extends Action {
	public AcademyjournalinfoViewAction() {
	}

	private IAcademyjournalinfoDAO academyjournalinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyjournalinfoForm form = new AcademyjournalinfoForm();
		Integer aji_id = Integer.valueOf(httpServletRequest.getParameter("aji_id"));
		Academyjournalinfo bean = new Academyjournalinfo();
		if (httpServletRequest.getParameter("aji_id") != null) {
			aji_id = Integer.valueOf(httpServletRequest.getParameter("aji_id"));
			bean = academyjournalinfoDAO.getAcademyjournalinfo(aji_id);
		} else {
			aji_id = (Integer) httpServletRequest.getSession().getAttribute("aji_id");
			bean = academyjournalinfoDAO.getAcademyjournalinfo(aji_id);
		}
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		httpServletRequest.setAttribute("academyjournalinfoForm", form);
		httpServletRequest.getSession().setAttribute("aji_id", aji_id);
		return actionMapping.findForward("success");
	}

	public IAcademyjournalinfoDAO getAcademyjournalinfoDAO() {
		return academyjournalinfoDAO;
	}

	public void setAcademyjournalinfoDAO(IAcademyjournalinfoDAO academyjournalinfoDAO) {
		this.academyjournalinfoDAO = academyjournalinfoDAO;
	}

}
