package com.cssrc.web.action.email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.web.form.email.EmailForm;

public class emailAction extends Action {
	public emailAction() {
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		EmailForm emailForm = new EmailForm();
		emailForm = (EmailForm) request.getSession().getAttribute("emailForm");
		request.setAttribute("emailForm", emailForm);

		return mapping.findForward("success");

	}

}
