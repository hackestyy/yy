package com.cssrc.web.action.usermanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.OnlineCtrl;
import com.cssrc.dao.IOnlineCtrlDAO;
import com.cssrc.dao.IUserDAO;
import com.cssrc.web.form.OnlineCtrlForm;

public class OnlineAdminManageUpdata extends Action {
	private IUserDAO userDAO;
	private IOnlineCtrlDAO onlinectrlDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession s = httpServletRequest.getSession();
		OnlineCtrl onlinectrl = onlinectrlDAO.getOnlineCtrl(1);
		OnlineCtrlForm form = (OnlineCtrlForm) actionForm;
		try {
			onlinectrl.setNum(form.getNum());
			onlinectrl.setTime(form.getTime());
			onlinectrl.setNo(1);
			int maxtime = form.getTime() * 60;
			s.setMaxInactiveInterval(maxtime);
			if (onlinectrlDAO.modifyOnlineCtrl(onlinectrl)) {
				httpServletRequest.setAttribute("fileForm", form);
				s.setAttribute("maxnum", form.getNum());
				s.setAttribute("timeout", form.getTime());
			} else {
				return actionMapping.findForward("failure");
			}
		} catch (Exception e) {
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

	public IOnlineCtrlDAO getOnlinectrlDAO() {
		return onlinectrlDAO;
	}

	public void setOnlinectrlDAO(IOnlineCtrlDAO onlinectrlDAO) {
		this.onlinectrlDAO = onlinectrlDAO;
	}

}
