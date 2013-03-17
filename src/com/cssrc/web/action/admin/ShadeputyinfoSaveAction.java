package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyinfo;
import com.cssrc.dao.admin.IShadeputyinfoDAO;
import com.cssrc.web.form.admin.ShadeputyinfoForm;

public class ShadeputyinfoSaveAction extends Action {
	public ShadeputyinfoSaveAction() {
	}

	private IShadeputyinfoDAO shadeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		ShadeputyinfoForm form = (ShadeputyinfoForm) actionForm;
		Shadeputyinfo bean = new Shadeputyinfo();
		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);
		String assoduty_s = String.valueOf(httpServletRequest.getSession().getAttribute("assoduty_s"));
		form.setAssoduty_s(assoduty_s);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		if (!shadeputyinfoDAO.saveShadeputyinfo(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("assoduty_s", bean.getAssoduty_s());
		httpServletRequest.getSession().setAttribute("shadbi_id", bean.getShadbi_id());
		return actionMapping.findForward("success");
	}

	public IShadeputyinfoDAO getShadeputyinfoDAO() {
		return shadeputyinfoDAO;
	}

	public void setShadeputyinfoDAO(IShadeputyinfoDAO shadeputyinfoDAO) {
		this.shadeputyinfoDAO = shadeputyinfoDAO;
	}

}
