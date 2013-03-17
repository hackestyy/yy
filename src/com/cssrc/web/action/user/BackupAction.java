package com.cssrc.web.action.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BackupAction extends Action {
	public BackupAction() {
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Calendar cDay = Calendar.getInstance();
		SimpleDateFormat myf = new SimpleDateFormat("yyyyMMddHHmmss");
		String day = myf.format(cDay.getTime());

		String command = "\"" + this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\backup.bat\" \"" + this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\" + day + "\"";
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
