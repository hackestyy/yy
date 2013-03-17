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

public class ShadeputyinfoUpdateAction extends Action {
	public ShadeputyinfoUpdateAction() {
	}

	private IShadeputyinfoDAO shadeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputyinfoForm form = (ShadeputyinfoForm) actionForm;
		Shadeputyinfo bean = new Shadeputyinfo();

		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		if (shadeputyinfoDAO.modifyShadeputyinfo(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IShadeputyinfoDAO getShadeputyinfoDAO() {
		return shadeputyinfoDAO;
	}

	public void setShadeputyinfoDAO(IShadeputyinfoDAO shadeputyinfoDAO) {
		this.shadeputyinfoDAO = shadeputyinfoDAO;
	}

}
