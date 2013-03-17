package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;
import com.cssrc.web.form.admin.SmemberacademicliteratureForm;

public class SmemberacademicliteratureModifyAction extends Action {
	public SmemberacademicliteratureModifyAction() {
	}

	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberacademicliteratureForm form = new SmemberacademicliteratureForm();
		Integer smal_id = Integer.valueOf(httpServletRequest.getParameter("smal_id"));
		Smemberacademicliterature bean = smemberacademicliteratureDAO.getSmemberacademicliterature(smal_id);

		form.setSmal_id(bean.getSmal_id());
		form.setSmbi_id(bean.getSmbi_id());
		form.setLitename(bean.getLitename().toString());
		if (bean.getLitedate() != null) {
			form.setTemplitedate(bean.getLitedate().toString().substring(0, 10));
		}
		form.setLitejournal(bean.getLitejournal().toString());
		form.setLitehouse(bean.getLitehouse().toString());

		httpServletRequest.setAttribute("SmemberacademicliteratureForm", form);
		httpServletRequest.getSession().setAttribute("smal_id", smal_id);
		return actionMapping.findForward("success");
	}

	public ISmemberacademicliteratureDAO getSmemberacademicliteratureDAO() {
		return smemberacademicliteratureDAO;
	}

	public void setSmemberacademicliteratureDAO(ISmemberacademicliteratureDAO smemberacademicliteratureDAO) {
		this.smemberacademicliteratureDAO = smemberacademicliteratureDAO;
	}
}
