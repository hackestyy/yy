package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybrandconstruct;
import com.cssrc.dao.admin.IAcademybrandconstructDAO;
import com.cssrc.web.form.admin.AcademybrandconstructForm;

public class AcademybrandconstructSaveAction extends Action {
	public AcademybrandconstructSaveAction() {
	}

	private IAcademybrandconstructDAO academybrandconstructDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybrandconstructForm form = (AcademybrandconstructForm) actionForm;
		Academybrandconstruct bean = new Academybrandconstruct();

		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (!academybrandconstructDAO.saveAcademybrandconstruct(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("abc_id", bean.getAbc_id());
		return actionMapping.findForward("success");
	}

	public IAcademybrandconstructDAO getAcademybrandconstructDAO() {
		return academybrandconstructDAO;
	}

	public void setAcademybrandconstructDAO(IAcademybrandconstructDAO academybrandconstructDAO) {
		this.academybrandconstructDAO = academybrandconstructDAO;
	}

}
