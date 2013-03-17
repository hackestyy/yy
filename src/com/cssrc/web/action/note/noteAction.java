package com.cssrc.web.action.note;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.web.form.note.NoteForm;

public class noteAction extends Action {
	public noteAction() {
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		NoteForm noteForm = new NoteForm();
		noteForm = (NoteForm) request.getSession().getAttribute("noteForm");
		request.setAttribute("noteForm", noteForm);

		return mapping.findForward("success");

	}

}
