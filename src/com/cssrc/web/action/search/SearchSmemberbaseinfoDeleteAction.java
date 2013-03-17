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
import com.cssrc.dao.admin.ISearchsmemberbaseinfoviewDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class SearchSmemberbaseinfoDeleteAction extends Action {
	public SearchSmemberbaseinfoDeleteAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private ISearchsmemberbaseinfoviewDAO searchsmemberbaseinfoviewDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
		Integer smbi_id = Integer.valueOf(httpServletRequest.getParameter("smbi_id"));
		String searchsql = "where smbi_id = " + smbi_id;
		List tAfBookentrys = new ArrayList();
		tAfBookentrys = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
		try {
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				Academysmemberrelation academysmemberrelationbean = (Academysmemberrelation) tAfBookentrys.get(i);
				academysmemberrelationbean.setIsdelete("1");
				academysmemberrelationDAO.modifyAcademysmemberrelation(academysmemberrelationbean);
			}

			searchsmemberbaseinfoviewDAO.deleteSearchsmemberbaseinfoview(smbi_id);

			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			// httpServletRequest.getSession().setAttribute("smemberabi_id",bean.getAbi_id());
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public ISearchsmemberbaseinfoviewDAO getSearchsmemberbaseinfoviewDAO() {
		return searchsmemberbaseinfoviewDAO;
	}

	public void setSearchsmemberbaseinfoviewDAO(ISearchsmemberbaseinfoviewDAO searchsmemberbaseinfoviewDAO) {
		this.searchsmemberbaseinfoviewDAO = searchsmemberbaseinfoviewDAO;
	}

}
