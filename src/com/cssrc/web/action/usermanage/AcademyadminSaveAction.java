package com.cssrc.web.action.usermanage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.IUserDAO;
import com.cssrc.dao.admin.IShassociationDAO;
import com.cssrc.dao.admin.IUserLogDAO;
import com.cssrc.web.form.UserForm;

public class AcademyadminSaveAction extends Action {
	public AcademyadminSaveAction() {
	}

	private IUserDAO userDAO;
	private IShassociationDAO shassociationDAO;
	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = (UserForm) actionForm;
		User bean = new User();
		Integer ui_id = (Integer) httpServletRequest.getSession().getAttribute("ui_id");
		form.setUi_id(ui_id);
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		form.setUserrole("AcademyAdmin");
		bean.setUseracademic(form.getUseracademic());
		bean.setUseraccount(form.getUseraccount());
		bean.setUserassociation(form.getUserassociation());
		bean.setUserpwd(form.getUserpwd());
		bean.setUserpwdmd5(form.getUserpwdmd5());
		bean.setUserrole(form.getUserrole());

		String temp = bean.getUserassociation(); // shai_id
		Integer shai_id = Integer.valueOf(temp);
		String assoname = shassociationDAO.selAssoNamebyID(shai_id);
		bean.setUserassociation(assoname);

		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		UserLog logbean = new UserLog();
		logbean.setTime(Calendar.getInstance());
		logbean.setUser(user.getUseraccount());
		logbean.setAcademy("系统管理员");
		logbean.setOperation("添加 " + bean.getUseracademic() + " " + bean.getUserassociation() + " 学会管理员 " + bean.getUseraccount());
		userlogDAO.saveUserLog(logbean);

		// 校验部分
		// 校验帐号
		String account = bean.getUseraccount();

		if (userDAO.checkusername(account) == 1) {
			return actionMapping.findForward("existcount");
		}
		if (userDAO.checkusername(account) == 2) {
			return actionMapping.findForward("failure");
		}

		// 校验学会群
		List assonamelist = new ArrayList();
		assonamelist = userDAO.listAssoName();
		int iCompare = 0;
		String temp1 = bean.getUserassociation();
		if (temp1 == null) {
			temp1 = "noassoname";// 随机指定一个值，只要不和已有的群名称重复
			return actionMapping.findForward("acadwarn");
		}
		for (int i = 0; i < assonamelist.size(); i++) {
			String temp2 = String.valueOf(assonamelist.get(i));
			if (temp1.equals(temp2)) {
				iCompare = iCompare + 1;
			}
		}
		if (iCompare == 0) {
			return actionMapping.findForward("acadwarn");
		}

		// 校验学会
		List acadnamelist = new ArrayList();
		acadnamelist = userDAO.listAcadName();
		int iCompare2 = 0;
		String temp3 = bean.getUseracademic();
		for (int i = 0; i < acadnamelist.size(); i++) {
			String temp4 = String.valueOf(acadnamelist.get(i));
			if (temp3.equals(temp4)) {
				iCompare2 = iCompare2 + 1;
			}
		}
		if (iCompare2 == 0) {
			return actionMapping.findForward("academywarn");
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

	public IShassociationDAO getShassociationDAO() {
		return shassociationDAO;
	}

	public void setShassociationDAO(IShassociationDAO shassociationDAO) {
		this.shassociationDAO = shassociationDAO;
	}

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

}
