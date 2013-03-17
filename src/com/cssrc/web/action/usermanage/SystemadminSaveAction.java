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
import com.cssrc.web.form.UserForm;

public class SystemadminSaveAction extends Action {
	public SystemadminSaveAction() {
	}

	private IUserDAO userDAO;
	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = (UserForm) actionForm;
		User bean = new User();
		Integer ui_id = (Integer) httpServletRequest.getSession().getAttribute("ui_id");
		form.setUi_id(ui_id);
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		form.setUserrole("SystemAdmin");
		bean.setUseracademic(form.getUseracademic());
		bean.setUseraccount(form.getUseraccount());
		bean.setUserassociation(form.getUserassociation());
		bean.setUserpwd(form.getUserpwd());
		bean.setUserpwdmd5(form.getUserpwdmd5());
		bean.setUserrole(form.getUserrole());
		// 记录日志
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		UserLog logbean = new UserLog();
		logbean.setTime(Calendar.getInstance());
		logbean.setUser(user.getUseraccount());
		logbean.setAcademy("系统管理员");
		logbean.setOperation("添加系统管理员" + bean.getUseraccount());
		userlogDAO.saveUserLog(logbean);

		String account = bean.getUseraccount();

		if (userDAO.checkusername(account) == 1) {
			return actionMapping.findForward("existcount");
		}
		if (userDAO.checkusername(account) == 2) {
			return actionMapping.findForward("failure");
		}

		if (!userDAO.saveUser(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("userrole", userrole);
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
