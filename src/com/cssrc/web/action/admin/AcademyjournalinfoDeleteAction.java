package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyjournalinfo;
import com.cssrc.dao.admin.IAcademyjournalinfoDAO;

public class AcademyjournalinfoDeleteAction extends Action {
	public AcademyjournalinfoDeleteAction() {
	}

	private IAcademyjournalinfoDAO academyjournalinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer aji_id = Integer.valueOf(httpServletRequest.getParameter("aji_id"));
		Academyjournalinfo bean = academyjournalinfoDAO.getAcademyjournalinfo(aji_id);
		if (!academyjournalinfoDAO.removeAcademyjournalinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademyjournalinfoDAO getAcademyjournalinfoDAO() {
		return academyjournalinfoDAO;
	}

	public void setAcademyjournalinfoDAO(IAcademyjournalinfoDAO academyjournalinfoDAO) {
		this.academyjournalinfoDAO = academyjournalinfoDAO;
	}
}
