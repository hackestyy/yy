package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyresearchproduction;
import com.cssrc.dao.admin.IShadeputyresearchproductionDAO;
import com.cssrc.web.form.admin.ShadeputyresearchproductionForm;

public class ShadeputyresearchproductionModifyAction extends Action {
	public ShadeputyresearchproductionModifyAction() {
	}

	private IShadeputyresearchproductionDAO shadeputyresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputyresearchproductionForm form = new ShadeputyresearchproductionForm();
		Integer shadrp_id = Integer.valueOf(httpServletRequest.getParameter("shadrp_id"));
		Shadeputyresearchproduction bean = shadeputyresearchproductionDAO.getShadeputyresearchproduction(shadrp_id);

		form.setShadbi_id(bean.getShadbi_id());
		form.setShadrp_id(bean.getShadrp_id());
		if (bean.getProddate() != null) {
			form.setTempproddate(bean.getProddate().toString().substring(0, 10));
		}
		form.setProdapplication(bean.getProdapplication());
		form.setProdname(bean.getProdname());
		form.setProdrewards(bean.getProdrewards());

		httpServletRequest.setAttribute("shadeputyresearchproductionForm", form);
		httpServletRequest.getSession().setAttribute("shadrp_id", shadrp_id);
		return actionMapping.findForward("success");
	}

	public IShadeputyresearchproductionDAO getShadeputyresearchproductionDAO() {
		return shadeputyresearchproductionDAO;
	}

	public void setShadeputyresearchproductionDAO(IShadeputyresearchproductionDAO shadeputyresearchproductionDAO) {
		this.shadeputyresearchproductionDAO = shadeputyresearchproductionDAO;
	}

}
