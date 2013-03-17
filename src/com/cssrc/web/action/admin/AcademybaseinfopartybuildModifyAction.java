package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.web.form.admin.AcademybaseinfopartybuildForm;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcademybaseinfopartybuildModifyAction extends Action {
	public AcademybaseinfopartybuildModifyAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfopartybuildForm form = new AcademybaseinfopartybuildForm();
		Integer abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));
		Academybaseinfo bean = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

		httpServletRequest.getSession().setAttribute("acadname", form.getAcadname());
		httpServletRequest.setAttribute("academybaseinfopartybuildForm", form);
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
