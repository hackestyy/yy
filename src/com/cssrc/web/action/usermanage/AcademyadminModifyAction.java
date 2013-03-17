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
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IShassociationDAO;
import com.cssrc.web.form.UserForm;

public class AcademyadminModifyAction extends Action {
	public AcademyadminModifyAction() {
	}

	private IUserDAO userDAO;
	private IShassociationDAO shassociationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		UserForm form = new UserForm();
		Integer ui_id = Integer.valueOf(httpServletRequest.getParameter("ui_id"));
		User bean = userDAO.getUser(ui_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
			List acadlist = academybaseinfoDAO.selectIdandName();
			List acadgrouplist = shassociationDAO.selectIdandName();
			String useraccount = bean.getUseraccount();
			httpServletRequest.getSession().setAttribute("SYSACADGROUP", acadgrouplist);
			httpServletRequest.getSession().setAttribute("ACADEMIESLIST", acadlist);
			httpServletRequest.getSession().setAttribute("TEMP_USERACCOUNT", useraccount);

		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		httpServletRequest.setAttribute("userForm", form);

		return actionMapping.findForward("success");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public IShassociationDAO getShassociationDAO() {
		return shassociationDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public void setShassociationDAO(IShassociationDAO shassociationDAO) {
		this.shassociationDAO = shassociationDAO;
	}

}
