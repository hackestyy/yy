package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.dao.admin.IAcadgroupDAO;

/**
 * <p>
 * Title:ObjParaDeleteAction
 * </p>
 * <p>
 * Description:ÊÔ¼þ²ÎÊý(T_OBJ_PARA)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author xuejian
 * @version 1.0
 */
public class AcadgroupDeleteAction extends Action {
	public AcadgroupDeleteAction() {
	}

	private IAcadgroupDAO acadgroupDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shai_id = Integer.valueOf(httpServletRequest.getParameter("shai_id"));
		Acadgroup bean = acadgroupDAO.getAcadgroup(shai_id);
		if (!acadgroupDAO.removeAcadgroup(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

}
