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

public class AcademyjournalinfoSaveAction extends Action {
	public AcademyjournalinfoSaveAction() {
	}

	private IAcademyjournalinfoDAO academyjournalinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademyjournalinfoForm form = (AcademyjournalinfoForm) actionForm;
		Academyjournalinfo bean = new Academyjournalinfo();

		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (!academyjournalinfoDAO.saveAcademyjournalinfo(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("aji_id", bean.getAji_id());
		return actionMapping.findForward("success");
	}

	public IAcademyjournalinfoDAO getAcademyjournalinfoDAO() {
		return academyjournalinfoDAO;
	}

	public void setAcademyjournalinfoDAO(IAcademyjournalinfoDAO academyjournalinfoDAO) {
		this.academyjournalinfoDAO = academyjournalinfoDAO;
	}
}
