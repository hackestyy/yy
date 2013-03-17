package com.cssrc.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RecoveryAction extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		HttpSession session = httpServletRequest.getSession(true);
		String[] no = httpServletRequest.getParameterValues("selection");
		if (no.length != 1) {
			return actionMapping.findForward("failure");
		}
		String filesname = no[0].trim();

		String command = "\"" + this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\recovery.bat\" \"" + this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\" + filesname + "\"";
		try {
			Process p = Runtime.getRuntime().exec(command);
			int i = 0;
			int t = 100;
			while (true) {
				if (p.waitFor() == 0) {
					break;
				}
				if (i++ > 20 * 60 * 1000 / t) {
					throw new Exception("Script Run TimeOut");
				}
				try {
					Thread.sleep(t);
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

}
