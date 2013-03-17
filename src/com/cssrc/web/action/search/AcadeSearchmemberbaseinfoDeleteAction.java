package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class AcadeSearchmemberbaseinfoDeleteAction extends Action {
	public AcadeSearchmemberbaseinfoDeleteAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		String searchsql = "where asmr_id = " + asmr_id;
		List tAfBookentrys = new ArrayList();
		tAfBookentrys = academysmemberrelationDAO.list(searchsql);
		Academysmemberrelation bean = (Academysmemberrelation) tAfBookentrys.get(0);
		bean.setIsdelete("1");
		if (academysmemberrelationDAO.modifyAcademysmemberrelation(bean)) {
			httpServletRequest.getSession().setAttribute("smbi_id", bean.getSmbi_id());
			httpServletRequest.getSession().setAttribute("smemberabi_id", bean.getAbi_id());
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}
}
