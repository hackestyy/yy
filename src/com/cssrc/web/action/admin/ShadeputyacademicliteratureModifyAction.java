package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyacademicliterature;
import com.cssrc.dao.admin.IShadeputyacademicliteratureDAO;
import com.cssrc.web.form.admin.ShadeputyacademicliteratureForm;

public class ShadeputyacademicliteratureModifyAction extends Action {
	public ShadeputyacademicliteratureModifyAction() {
	}

	private IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputyacademicliteratureForm form = new ShadeputyacademicliteratureForm();
		Integer shadal_id = Integer.valueOf(httpServletRequest.getParameter("shadal_id"));
		Shadeputyacademicliterature bean = shadeputyacademicliteratureDAO.getShadeputyacademicliterature(shadal_id);

		form.setShadal_id(bean.getShadal_id());
		form.setShadbi_id(bean.getShadbi_id());
		form.setLitename(bean.getLitename().toString());
		if (bean.getLitedate() != null) {
			form.setTemplitedate(bean.getLitedate().toString().substring(0, 10));
		}
		form.setLitejournal(bean.getLitejournal().toString());
		form.setLitehouse(bean.getLitehouse().toString());

		httpServletRequest.setAttribute("ShadeputyacademicliteratureForm", form);
		httpServletRequest.getSession().setAttribute("shadal_id", shadal_id);
		return actionMapping.findForward("success");
	}

	public IShadeputyacademicliteratureDAO getShadeputyacademicliteratureDAO() {
		return shadeputyacademicliteratureDAO;
	}

	public void setShadeputyacademicliteratureDAO(IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO) {
		this.shadeputyacademicliteratureDAO = shadeputyacademicliteratureDAO;
	}

}
