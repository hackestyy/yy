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

public class ShadeputyinfoModifyAction extends Action {
	public ShadeputyinfoModifyAction() {
	}

	private IShadeputyinfoDAO shadeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputyinfoForm form = new ShadeputyinfoForm();
		Integer shadi_id = Integer.valueOf(httpServletRequest.getParameter("shadi_id"));
		Shadeputyinfo bean = shadeputyinfoDAO.getShadeputyinfo(shadi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

		httpServletRequest.setAttribute("shadeputyinfoForm", form);
		httpServletRequest.getSession().setAttribute("shadi_id", shadi_id);
		return actionMapping.findForward("success");
	}

	public IShadeputyinfoDAO getShadeputyinfoDAO() {
		return shadeputyinfoDAO;
	}

	public void setShadeputyinfoDAO(IShadeputyinfoDAO shadeputyinfoDAO) {
		this.shadeputyinfoDAO = shadeputyinfoDAO;
	}

}
