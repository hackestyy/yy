package com.cssrc.web.action.usermanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.UserForm;

public class SmemberUpdateAction extends Action {
	public SmemberUpdateAction() {
	}

	private IUserDAO userDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = (UserForm) actionForm;
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		User bean = new User();
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		String memno = (String) form.getUserno();
		List listsmemberbaseinfo = smemberbaseinfoDAO.gainSmemberbaseinfolist(memno);
		if (listsmemberbaseinfo.size() == 1) {
			if (userDAO.modifyUser(bean)) {
				httpServletRequest.setAttribute("userrole", userrole);
				return actionMapping.findForward("success");
			}
			return actionMapping.findForward("failure");
		} else {
			return actionMapping.findForward("failure1");
		}

	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

}
