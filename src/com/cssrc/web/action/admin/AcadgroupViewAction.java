package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.admin.AcadgroupForm;

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
public class AcadgroupViewAction extends Action {
	public AcadgroupViewAction() {
	}

	private IAcadgroupDAO acadgroupDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcadgroupForm form = new AcadgroupForm();
		Acadgroup bean = new Acadgroup();
		Integer shai_id = bean.getShai_id();
		if (httpServletRequest.getParameter("shai_id") != null) {
			shai_id = Integer.valueOf(httpServletRequest.getParameter("shai_id"));
			bean = acadgroupDAO.getAcadgroup(shai_id);
		} else {
			shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
			bean = acadgroupDAO.getAcadgroup(shai_id);
		}
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		httpServletRequest.setAttribute("AcadgroupForm", form);
		httpServletRequest.getSession().setAttribute("Shai_id", shai_id);
		return actionMapping.findForward("success");
	}
}
