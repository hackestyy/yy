package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class JudgeDBWYSourceAction extends Action {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String memno = httpServletRequest.getParameter("memno").toString();
		String str = memno.substring(0, 4);
		String dbwy = httpServletRequest.getParameter("dbwy");
		httpServletRequest.setAttribute("dbwy", dbwy);
		// �û������޸ĵ�¼�ʺţ�so��������"SAST"��ͷ���жϣ�ע�͵�
		// if(str.equals("SAST"))
		// {
		// httpServletRequest.getSession().setAttribute("memno",memno);
		// return actionMapping.findForward("success1");
		// }
		if (str.equals("DBWY")) {
			httpServletRequest.getSession().setAttribute("memno", memno);
			return actionMapping.findForward("success2");
		} else {
			httpServletRequest.getSession().setAttribute("memno", memno);
			return actionMapping.findForward("success1");
		}

	}

}
