package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IGmemberbaseinfoDAO;
import com.cssrc.web.form.admin.GmemberbaseinfoForm;

public class SearchSysGmemBaseInfoDelAction extends Action {
	public SearchSysGmemBaseInfoDelAction() {

	}

	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberbaseinfoForm form = (GmemberbaseinfoForm) actionForm;
		Integer agmr_id = Integer.valueOf(httpServletRequest.getParameter("agmr_id"));
		String searchsql = "where agmr_id = " + agmr_id;
		List tAfBookentrys = new ArrayList();
		tAfBookentrys = academygmemberrelationDAO.list(searchsql);
		Academygmemberrelation bean = (Academygmemberrelation) tAfBookentrys.get(0);
		bean.setIsdelete("1");
		if (academygmemberrelationDAO.modifyAcademygmemberrelation(bean)) {
			httpServletRequest.getSession().setAttribute("gmbi_id", bean.getGmbi_id());
			httpServletRequest.getSession().setAttribute("gmemberabi_id", bean.getAbi_id());
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public IGmemberbaseinfoDAO getGmemberbaseinfoDAO() {
		return gmemberbaseinfoDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}

	public void setGmemberbaseinfoDAO(IGmemberbaseinfoDAO gmemberbaseinfoDAO) {
		this.gmemberbaseinfoDAO = gmemberbaseinfoDAO;
	}

}
