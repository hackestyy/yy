package com.cssrc.web.action.academyadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;
import com.cssrc.web.form.ChangeCountForm;

public class AcademyAdminPwdModAction extends Action {
	public AcademyAdminPwdModAction() {

	}

	private IUserDAO userDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		ChangeCountForm form = (ChangeCountForm) actionForm;

		String pwd1 = user.getUserpwd();
		String pwd2 = form.getOlduserpwd();
		String newpwd = form.getNewuserpwd();

		if (!pwd1.equals(pwd2)) {
			return actionMapping.findForward("pwdfailure");
		}

		user.setUserpwd(newpwd);

		if (!userDAO.modifyUser(user)) {
			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
