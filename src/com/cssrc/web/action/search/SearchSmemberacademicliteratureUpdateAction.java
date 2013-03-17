package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberacademicliteratureForm;

public class SearchSmemberacademicliteratureUpdateAction extends Action {
	public SearchSmemberacademicliteratureUpdateAction() {
	}

	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberacademicliteratureForm form = (SmemberacademicliteratureForm) actionForm;
		Smemberacademicliterature bean = new Smemberacademicliterature();

		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		String templitedate = form.getTemplitedate();
		if (templitedate.equals("")) {
			templitedate = null;
		} else {
			bean.setLitedate(DateUtil.getCalendar(templitedate).getTime());
		}

		if (smemberacademicliteratureDAO.modifySmemberacademicliterature(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public ISmemberacademicliteratureDAO getSmemberacademicliteratureDAO() {
		return smemberacademicliteratureDAO;
	}

	public void setSmemberacademicliteratureDAO(ISmemberacademicliteratureDAO smemberacademicliteratureDAO) {
		this.smemberacademicliteratureDAO = smemberacademicliteratureDAO;
	}

}
