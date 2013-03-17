package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberresearchproduction;
import com.cssrc.dao.admin.IGmemberresearchproductionDAO;
import com.cssrc.web.form.admin.GmemberresearchproductionForm;

public class SearchSysGmemResProModAction extends Action {

	public SearchSysGmemResProModAction() {

	}

	private IGmemberresearchproductionDAO gmemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberresearchproductionForm form = new GmemberresearchproductionForm();
		Integer gmrp_id = Integer.valueOf(httpServletRequest.getParameter("gmrp_id"));
		Gmemberresearchproduction bean = gmemberresearchproductionDAO.getGmemberresearchproduction(gmrp_id);

		form.setGmrp_id(bean.getGmrp_id());
		form.setGmbi_id(bean.getGmbi_id());
		form.setProdname(bean.getProdname().toString());
		if (bean.getProddate() != null) {
			form.setTempproddate(bean.getProddate().toString().substring(0, 10));
		}
		form.setProdrewards(bean.getProdrewards().toString());
		form.setProdapplication(bean.getProdapplication().toString());

		httpServletRequest.setAttribute("GmemberresearchproductionForm", form);
		httpServletRequest.getSession().setAttribute("gmrp_id", gmrp_id);
		return actionMapping.findForward("success");
	}

	public IGmemberresearchproductionDAO getGmemberresearchproductionDAO() {
		return gmemberresearchproductionDAO;
	}

	public void setGmemberresearchproductionDAO(IGmemberresearchproductionDAO gmemberresearchproductionDAO) {
		this.gmemberresearchproductionDAO = gmemberresearchproductionDAO;
	}
}
