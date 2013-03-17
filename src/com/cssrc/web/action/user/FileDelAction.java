package com.cssrc.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class FileDelAction extends Action {

	public FileDelAction() {

	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String filename = httpServletRequest.getParameter("filesname");
		String filepath = this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\" + filename;
		try {
			java.io.File myDelFile = new java.io.File(filepath);
			myDelFile.delete();
		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

}
