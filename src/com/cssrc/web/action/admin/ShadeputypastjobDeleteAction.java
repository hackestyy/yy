package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputypastjob;
import com.cssrc.dao.admin.IShadeputypastjobDAO;

public class ShadeputypastjobDeleteAction extends Action {
	public ShadeputypastjobDeleteAction() {
	}

	private IShadeputypastjobDAO shadeputypastjobDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadpj_id = Integer.valueOf(httpServletRequest.getParameter("shadpj_id"));
		Shadeputypastjob bean = shadeputypastjobDAO.getShadeputypastjob(shadpj_id);
		if (!shadeputypastjobDAO.removeShadeputypastjob(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputypastjobDAO getShadeputypastjobDAO() {
		return shadeputypastjobDAO;
	}

	public void setShadeputypastjobDAO(IShadeputypastjobDAO shadeputypastjobDAO) {
		this.shadeputypastjobDAO = shadeputypastjobDAO;
	}

}
