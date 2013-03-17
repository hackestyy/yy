package com.cssrc.web.action.common;

import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.cssrc.bean.OnlineCtrl;
import com.cssrc.bean.User;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.IOnlineCtrlDAO;
import com.cssrc.dao.IUserDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.IUserLogDAO;
import com.cssrc.web.form.common.LoginForm;

public class LoginAction extends Action {
	public LoginAction() {
	}

	private IUserDAO userDAO;
	private IUserLogDAO userlogDAO;
	private IOnlineCtrlDAO onlinectrlDAO;

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ActionMessages errors = new ActionMessages();
		LoginForm form = (LoginForm) actionForm;
		UserLog bean = new UserLog();
		httpServletRequest.getSession().setAttribute("onlineUserBindingListener", new OnlineUserBindingListener(form.getUseraccount()));
		ServletContext application = httpServletRequest.getSession().getServletContext();
		List onlineUserList = (List) application.getAttribute("onlineUserList");
		int num = onlineUserList.size();
		ServletContext ct = this.servlet.getServletContext();
		httpServletRequest.getSession().setAttribute("onlineusernum", num);
		ct.getAttribute("onlinenum");
		int no = 1;
		List onlinelist = onlinectrlDAO.findOnlieCtrl(no);
		OnlineCtrl nolinebean = new OnlineCtrl();
		int a = onlinelist.size();
		if (a == 0) {
			nolinebean.setNo(1);
			nolinebean.setNum(5);
			nolinebean.setTime(30);
		} else {
			nolinebean = (OnlineCtrl) onlinelist.get(0);
		}
		if (num <= nolinebean.getNum()) {
			String vcode = form.getUservcode();
			if (vcode != null && vcode.length() > 0) {
				vcode = vcode.trim();
			} else {
				vcode = "";
			}
			HttpSession session = httpServletRequest.getSession();
			String uservcode = "";
			if (session != null && session.getAttribute("uservcode") != null) {
				uservcode = session.getAttribute("uservcode").toString().trim();
				session.removeAttribute("uservcode");
			}
			if (vcode.compareToIgnoreCase(uservcode) == 0) {
				if (smemberbaseinfoDAO.isValidUser(form.getUseraccount(), form.getUserpwd())) {
					List userlist = smemberbaseinfoDAO.gainSmemberbaseinfolist(String.valueOf(form.getUseraccount()));
					Smemberbaseinfo smember = (Smemberbaseinfo) userlist.get(0);
					httpServletRequest.getSession().setAttribute("USER", smember);
					httpServletRequest.getSession().setAttribute("memno", form.getUseraccount());
					return actionMapping.findForward("success4");
				} else if (userDAO.isValidUser(form.getUseraccount(), form.getUserpwd())) {
					List userlist = userDAO.findUser(String.valueOf(form.getUseraccount()));
					User user = (User) userlist.get(0);
					bean.setOperation("登陆");
					bean.setTime(Calendar.getInstance());
					bean.setUser(form.getUseraccount());
					String grants = user.getUserrole();
					httpServletRequest.getSession().setAttribute("USER", user);

					if (grants.equals("SystemAdmin")) {
						bean.setAcademy("系统管理员");
						userlogDAO.saveUserLog(bean);
						return actionMapping.findForward("success1");
					}
					if (grants.equals("VIP")) {
						bean.setAcademy("VIP用户");
						userlogDAO.saveUserLog(bean);
						return actionMapping.findForward("success2");
					}
					if (grants.equals("AcademyAdmin")) {
						httpServletRequest.getSession().setAttribute("userassociation", user.getUserassociation());
						httpServletRequest.getSession().setAttribute("useracademic", user.getUseracademic());
						bean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + " 学会管理员");
						userlogDAO.saveUserLog(bean);
						return actionMapping.findForward("success3");
					}

					else {
						return actionMapping.findForward("grantsfailure");
					}
				} else {
					errors.add("errorMessage", new ActionMessage("error.login"));
					saveErrors(httpServletRequest, errors);
					httpServletRequest.setAttribute("failure", "failure");
					return actionMapping.findForward("grantsfailure");
				}
			} else {
				errors.add("errorMessage", new ActionMessage("error.login"));
				saveErrors(httpServletRequest, errors);
				httpServletRequest.setAttribute("failure", "grantsfailurevcode");
				return actionMapping.findForward("grantsfailurevcode");
			}
		} else {
			httpServletRequest.setAttribute("failure", "outofnum");
			return actionMapping.findForward("outofnum");
		}

	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
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

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

}
