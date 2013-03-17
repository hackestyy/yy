package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class JudgeDBWYSourceDelAction extends Action {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String memno = httpServletRequest.getParameter("memno").toString();
		String str = memno.substring(0, 4);
		String dbwy = httpServletRequest.getParameter("dbwy");
		httpServletRequest.setAttribute("dbwy", dbwy);
		if (str.equals("DBWY")) {
			httpServletRequest.getSession().setAttribute("memno", memno);
			return actionMapping.findForward("success2");
		} else {
			httpServletRequest.getSession().setAttribute("memno", memno);
			return actionMapping.findForward("success1");
		}

	}

}
