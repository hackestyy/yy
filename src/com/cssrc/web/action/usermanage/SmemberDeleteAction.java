package com.cssrc.web.action.usermanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;

public class SmemberDeleteAction extends Action {
	public SmemberDeleteAction() {
	}

	private IUserDAO userDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer ui_id = Integer.valueOf(httpServletRequest.getParameter("ui_id"));
		User bean = userDAO.getUser(ui_id);
		if (!userDAO.removeUser(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		httpServletRequest.setAttribute("userrole", bean.getUserrole());
		return actionMapping.findForward("success");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
