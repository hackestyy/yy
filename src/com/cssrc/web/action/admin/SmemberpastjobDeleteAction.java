package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberpastjob;
import com.cssrc.dao.admin.ISmemberpastjobDAO;

public class SmemberpastjobDeleteAction extends Action {
	public SmemberpastjobDeleteAction() {
	}

	private ISmemberpastjobDAO smemberpastjobDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer smpj_id = Integer.valueOf(httpServletRequest.getParameter("smpj_id"));
		Smemberpastjob bean = smemberpastjobDAO.getSmemberpastjob(smpj_id);
		if (!smemberpastjobDAO.removeSmemberpastjob(bean)) {
			return actionMapping.findForward("errorDelete");
		}
		return actionMapping.findForward("success");
	}

	public ISmemberpastjobDAO getSmemberpastjobDAO() {
		return smemberpastjobDAO;
	}

	public void setSmemberpastjobDAO(ISmemberpastjobDAO smemberpastjobDAO) {
		this.smemberpastjobDAO = smemberpastjobDAO;
	}

}
