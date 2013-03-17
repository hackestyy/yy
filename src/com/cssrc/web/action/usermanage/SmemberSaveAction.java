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

public class SmemberSaveAction extends Action {
	public SmemberSaveAction() {
	}

	private IUserDAO userDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = (UserForm) actionForm;
		User bean = new User();
		Integer ui_id = (Integer) httpServletRequest.getSession().getAttribute("ui_id");
		form.setUi_id(ui_id);
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		form.setUserrole("User");
		bean.setUseracademic(form.getUseracademic());
		bean.setUseraccount(form.getUseraccount());
		bean.setUserassociation(form.getUserassociation());
		bean.setUserpwd(form.getUserpwd());
		bean.setUserpwdmd5(form.getUserpwdmd5());
		bean.setUserrole(form.getUserrole());
		bean.setUserno(form.getUserno());

		String memno = (String) form.getUserno();
		List listsmemberbaseinfo = smemberbaseinfoDAO.gainSmemberbaseinfolist(memno);
		if (listsmemberbaseinfo.size() == 1) {
			if (!userDAO.saveUser(bean)) {
				return actionMapping.findForward("smiderrorAdd");
			}

			httpServletRequest.getSession().setAttribute("userrole", userrole);
			return actionMapping.findForward("success");
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
