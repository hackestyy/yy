package com.cssrc.web.action.usermanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IShassociationDAO;

public class AcademyAdminAddAction extends Action {
	public AcademyAdminAddAction() {

	}

	private IShassociationDAO shassociationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		try {
			List acadlist = academybaseinfoDAO.selectIdandName();
			List acadgrouplist = shassociationDAO.selectIdandName();

			httpServletRequest.getSession().setAttribute("SYSACADGROUP", acadgrouplist);
			httpServletRequest.getSession().setAttribute("ACADEMIESLIST", acadlist);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

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
