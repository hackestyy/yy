package com.cssrc.web.action.usermanage;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.IUserDAO;
import com.cssrc.dao.admin.IUserLogDAO;

public class AcademyadminDeleteAction extends Action {
	public AcademyadminDeleteAction() {
	}

	private IUserDAO userDAO;
	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer ui_id = Integer.valueOf(httpServletRequest.getParameter("ui_id"));
		User bean = userDAO.getUser(ui_id);
		if (!userDAO.removeUser(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		UserLog logbean = new UserLog();
		logbean.setTime(Calendar.getInstance());
		logbean.setUser(user.getUseraccount());
		logbean.setAcademy("系统管理员");
		logbean.setOperation("删除 " + bean.getUseracademic() + " " + bean.getUserassociation() + " 学会管理员 " + bean.getUseraccount());
		userlogDAO.saveUserLog(logbean);

		httpServletRequest.setAttribute("userrole", bean.getUserrole());
		return actionMapping.findForward("success");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

}
