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
 * Title: BKUpdateAction
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
public class AcadgroupUpdateAction extends Action {
	public AcadgroupUpdateAction() {
	}

	private IAcadgroupDAO acadgroupDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcadgroupForm form = (AcadgroupForm) actionForm;
		Acadgroup bean = new Acadgroup();
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (acadgroupDAO.modifyAcadgroup(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}
}
