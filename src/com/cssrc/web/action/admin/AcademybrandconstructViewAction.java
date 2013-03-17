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

public class AcademybrandconstructViewAction extends Action {
	public AcademybrandconstructViewAction() {
	}

	private IAcademybrandconstructDAO academybrandconstructDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybrandconstructForm form = new AcademybrandconstructForm();
		Integer abc_id = Integer.valueOf(httpServletRequest.getParameter("abc_id"));
		Academybrandconstruct bean = new Academybrandconstruct();
		if (httpServletRequest.getParameter("abc_id") != null) {
			abc_id = Integer.valueOf(httpServletRequest.getParameter("abc_id"));
			bean = academybrandconstructDAO.getAcademybrandconstruct(abc_id);
		} else {
			abc_id = (Integer) httpServletRequest.getSession().getAttribute("abc_id");
			bean = academybrandconstructDAO.getAcademybrandconstruct(abc_id);
		}
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		httpServletRequest.setAttribute("academybrandconstructForm", form);
		httpServletRequest.getSession().setAttribute("abc_id", abc_id);
		return actionMapping.findForward("success");
	}

	public IAcademybrandconstructDAO getAcademybrandconstructDAO() {
		return academybrandconstructDAO;
	}

	public void setAcademybrandconstructDAO(IAcademybrandconstructDAO academybrandconstructDAO) {
		this.academybrandconstructDAO = academybrandconstructDAO;
	}
}
