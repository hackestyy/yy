package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.web.form.admin.AcademybaseinfoForm;

public class GmemberbaseinfoListAction extends Action {
	public GmemberbaseinfoListAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfoForm form = new AcademybaseinfoForm();
		Integer abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));
		Academybaseinfo bean = new Academybaseinfo();
		if (httpServletRequest.getParameter("abi_id") != null) {
			abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));
			bean = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		} else {
			abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
			bean = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		}
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		httpServletRequest.setAttribute("academybaseinfoForm", form);
		httpServletRequest.getSession().setAttribute("acadname", form.getAcadname());
		httpServletRequest.getSession().setAttribute("abi_id", abi_id);
		return actionMapping.findForward("success");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
