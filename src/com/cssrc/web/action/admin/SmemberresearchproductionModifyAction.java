package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberresearchproduction;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;
import com.cssrc.web.form.admin.SmemberresearchproductionForm;

public class SmemberresearchproductionModifyAction extends Action {
	public SmemberresearchproductionModifyAction() {
	}

	private ISmemberresearchproductionDAO smemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberresearchproductionForm form = new SmemberresearchproductionForm();
		Integer smrp_id = Integer.valueOf(httpServletRequest.getParameter("smrp_id"));
		Smemberresearchproduction bean = smemberresearchproductionDAO.getSmemberresearchproduction(smrp_id);

		form.setSmrp_id(bean.getSmrp_id());
		form.setSmbi_id(bean.getSmbi_id());
		form.setProdname(bean.getProdname().toString());
		if (bean.getProddate() != null) {
			form.setTempproddate(bean.getProddate().toString().substring(0, 10));
		}
		form.setProdrewards(bean.getProdrewards().toString());
		form.setProdapplication(bean.getProdapplication().toString());

		httpServletRequest.setAttribute("SmemberresearchproductionForm", form);
		httpServletRequest.getSession().setAttribute("smrp_id", smrp_id);
		return actionMapping.findForward("success");
	}

	public ISmemberresearchproductionDAO getSmemberresearchproductionDAO() {
		return smemberresearchproductionDAO;
	}

	public void setSmemberresearchproductionDAO(ISmemberresearchproductionDAO smemberresearchproductionDAO) {
		this.smemberresearchproductionDAO = smemberresearchproductionDAO;
	}
}
