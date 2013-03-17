package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;

public class SmemberacademicliteratureUploadAction extends Action {
	public SmemberacademicliteratureUploadAction() {
	}

	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		return actionMapping.findForward("success");
	}

	public ISmemberacademicliteratureDAO getSmemberacademicliteratureDAO() {
		return smemberacademicliteratureDAO;
	}

	public void setSmemberacademicliteratureDAO(ISmemberacademicliteratureDAO smemberacademicliteratureDAO) {
		this.smemberacademicliteratureDAO = smemberacademicliteratureDAO;
	}
}
