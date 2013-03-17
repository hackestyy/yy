package com.cssrc.web.action.usermanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.IOnlineCtrlDAO;
import com.cssrc.dao.IUserDAO;
import com.cssrc.web.form.OnlineCtrlForm;

public class OnlineAdminManageModify extends Action {
	private IUserDAO userDAO;
	private IOnlineCtrlDAO onlinectrlDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession s = httpServletRequest.getSession();
		OnlineCtrlForm form = new OnlineCtrlForm();
		int time = (Integer) s.getAttribute("timeout");
		int maxnum = (Integer) s.getAttribute("maxnum");
		form.setTime(time);
		form.setNum(maxnum);
		httpServletRequest.setAttribute("timeout", time);
		httpServletRequest.setAttribute("onlinectrlForm", form);
		return actionMapping.findForward("success");

	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IOnlineCtrlDAO getOnlinectrlDAO() {
		return onlinectrlDAO;
	}

	public void setOnlinectrlDAO(IOnlineCtrlDAO onlinectrlDAO) {
		this.onlinectrlDAO = onlinectrlDAO;
	}

}
