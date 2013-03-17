package com.cssrc.web.action.usermanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;
import com.cssrc.web.form.UserForm;

public class VipUpdateAction extends Action {
	public VipUpdateAction() {
	}

	private IUserDAO userDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = (UserForm) actionForm;
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		User bean = new User();
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
			// 校验用户名是否又重复（和add时有区别）
			String temp = (httpServletRequest.getSession().getAttribute("TEMP_USERACCOUNT")).toString();
			String account = bean.getUseraccount();
			if (!temp.equals(account)) {
				if (userDAO.checkusername(account) == 1) {
					return actionMapping.findForward("existcount");
				}
				if (userDAO.checkusername("account") == 2) {
					return actionMapping.findForward("failure");
				}
			}
		} catch (Exception ex) {
		}
		if (userDAO.modifyUser(bean)) {
			httpServletRequest.setAttribute("userrole", userrole);
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
