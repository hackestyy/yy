package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.web.form.admin.AcademybaseinfoprincipalForm;

/**
 * <p>
 * Title: BKViewAction
 * </p>
 * <p>
 * Description: ÊÔÑé±³¾°×ÊÁÏ¿â(T_FD_BACKGR)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcademybaseinfoprincipalViewAction extends Action {
	public AcademybaseinfoprincipalViewAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfoprincipalForm form = new AcademybaseinfoprincipalForm();
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
		httpServletRequest.setAttribute("academybaseinfoprincipalForm", form);
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
