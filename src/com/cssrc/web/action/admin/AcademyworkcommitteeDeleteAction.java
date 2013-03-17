package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academyworkcommittee;
import com.cssrc.dao.admin.IAcademyworkcommitteeDAO;

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

public class AcademyworkcommitteeDeleteAction extends Action {
	public AcademyworkcommitteeDeleteAction() {
	}

	private IAcademyworkcommitteeDAO academyworkcommitteeDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer awc_id = Integer.valueOf(httpServletRequest.getParameter("awc_id"));
		Academyworkcommittee bean = academyworkcommitteeDAO.getAcademyworkcommittee(awc_id);
		if (!academyworkcommitteeDAO.removeAcademyworkcommittee(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IAcademyworkcommitteeDAO getAcademyworkcommitteeDAO() {
		return academyworkcommitteeDAO;
	}

	public void setAcademyworkcommitteeDAO(IAcademyworkcommitteeDAO academyworkcommitteeDAO) {
		this.academyworkcommitteeDAO = academyworkcommitteeDAO;
	}
}
