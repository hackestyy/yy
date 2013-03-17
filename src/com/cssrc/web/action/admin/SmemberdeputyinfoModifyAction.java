package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberdeputyinfo;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;
import com.cssrc.web.form.admin.SmemberdeputyinfoForm;

public class SmemberdeputyinfoModifyAction extends Action {
	public SmemberdeputyinfoModifyAction() {
	}

	private ISmemberdeputyinfoDAO smemberdeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberdeputyinfoForm form = new SmemberdeputyinfoForm();
		Integer smdi_id = Integer.valueOf(httpServletRequest.getParameter("smdi_id"));
		Smemberdeputyinfo bean = smemberdeputyinfoDAO.getSmemberdeputyinfo(smdi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

		httpServletRequest.setAttribute("smemberdeputyinfoForm", form);
		httpServletRequest.getSession().setAttribute("smdi_id", smdi_id);
		return actionMapping.findForward("success");
	}

	public ISmemberdeputyinfoDAO getSmemberdeputyinfoDAO() {
		return smemberdeputyinfoDAO;
	}

	public void setSmemberdeputyinfoDAO(ISmemberdeputyinfoDAO smemberdeputyinfoDAO) {
		this.smemberdeputyinfoDAO = smemberdeputyinfoDAO;
	}

}
