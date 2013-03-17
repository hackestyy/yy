package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyacademicliterature;
import com.cssrc.dao.admin.IShadeputyacademicliteratureDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputyacademicliteratureForm;

public class ShadeputyacademicliteratureSaveAction extends Action {
	public ShadeputyacademicliteratureSaveAction() {
	}

	private IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputyacademicliteratureForm form = (ShadeputyacademicliteratureForm) actionForm;
		Shadeputyacademicliterature bean = new Shadeputyacademicliterature();

		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);

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

		if (!shadeputyacademicliteratureDAO.saveShadeputyacademicliterature(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("shadal_id", bean.getShadal_id());
		return actionMapping.findForward("success");
	}

	public IShadeputyacademicliteratureDAO getShadeputyacademicliteratureDAO() {
		return shadeputyacademicliteratureDAO;
	}

	public void setShadeputyacademicliteratureDAO(IShadeputyacademicliteratureDAO shadeputyacademicliteratureDAO) {
		this.shadeputyacademicliteratureDAO = shadeputyacademicliteratureDAO;
	}

}
