package com.cssrc.web.action.usermanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.dao.IUserDAO;
import com.cssrc.dao.admin.IShassociationDAO;
import com.cssrc.util.CheckType;
import com.cssrc.web.form.UserForm;

public class AcademyadminUpdateAction extends Action {
	public AcademyadminUpdateAction() {
	}

	private IUserDAO userDAO;
	private IShassociationDAO shassociationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = (UserForm) actionForm;
		String userrole = String.valueOf(httpServletRequest.getSession().getAttribute("userrole"));
		User bean = new User();

		form.setUserrole(form.getUserrole());
		bean.setUi_id(form.getUi_id());
		bean.setUseracademic(form.getUseracademic());
		bean.setUseraccount(form.getUseraccount());
		bean.setUserassociation(form.getUserassociation());
		bean.setUserpwd(form.getUserpwd());
		bean.setUserpwdmd5(form.getUserpwdmd5());
		bean.setUserrole(form.getUserrole());
		// 将shai_id转换成具体的学会群名称
		String temp = bean.getUserassociation(); // shai_id
		if (CheckType.isNum(temp)) {
			Integer shai_id = Integer.valueOf(temp);
			String assoname = shassociationDAO.selAssoNamebyID(shai_id);
			bean.setUserassociation(assoname);
		}

		// 校验部分
		// 校验用户名是否重复（和add时有区别）
		String temp_2 = (httpServletRequest.getSession().getAttribute("TEMP_USERACCOUNT")).toString();
		String account = bean.getUseraccount();
		if (!temp_2.equals(account)) {
			if (userDAO.checkusername(account) == 1) {
				return actionMapping.findForward("existcount");
			}
			if (userDAO.checkusername("account") == 2) {
				return actionMapping.findForward("failure");
			}
		}
		// 校验学会群

		List assonamelist = new ArrayList();
		assonamelist = userDAO.listAssoName();
		int iCompare = 0;
		String temp1 = bean.getUserassociation();
		if (temp1 == null) {
			temp1 = "noassoname";// 随机指定一个值，只要不和群名称重复
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

	public IShassociationDAO getShassociationDAO() {
		return shassociationDAO;
	}

	public void setShassociationDAO(IShassociationDAO shassociationDAO) {
		this.shassociationDAO = shassociationDAO;
	}

}
