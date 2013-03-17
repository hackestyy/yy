package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybrandconstruct;
import com.cssrc.dao.admin.IAcademybrandconstructDAO;

public class AcademybrandconstructDeleteAction extends Action {
	public AcademybrandconstructDeleteAction() {
	}

	private IAcademybrandconstructDAO academybrandconstructDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abc_id = Integer.valueOf(httpServletRequest.getParameter("abc_id"));
		Academybrandconstruct bean = academybrandconstructDAO.getAcademybrandconstruct(abc_id);
		if (!academybrandconstructDAO.removeAcademybrandconstruct(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademybrandconstructDAO getAcademybrandconstructDAO() {
		return academybrandconstructDAO;
	}

	public void setAcademybrandconstructDAO(IAcademybrandconstructDAO academybrandconstructDAO) {
		this.academybrandconstructDAO = academybrandconstructDAO;
	}
}
