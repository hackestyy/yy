package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberdeputyinfo;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;
import com.cssrc.web.form.admin.SmemberdeputyinfoForm;

public class SearchSmemberdeputyinfoUpdateAction extends Action {
	public SearchSmemberdeputyinfoUpdateAction() {
	}

	private ISmemberdeputyinfoDAO smemberdeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberdeputyinfoForm form = (SmemberdeputyinfoForm) actionForm;
		Smemberdeputyinfo bean = new Smemberdeputyinfo();

		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		if (smemberdeputyinfoDAO.modifySmemberdeputyinfo(bean)) {
			String dbwy = httpServletRequest.getParameter("dbwy");
			if (dbwy != null) {
				if (dbwy.equals("wy")) {
					return actionMapping.findForward("success_wy");
				}
				if (dbwy.equals("cw")) {
					return actionMapping.findForward("success_cw");
				} else {
					return actionMapping.findForward("success");
				}
			} else {
				return actionMapping.findForward("success");
			}
		}
		return actionMapping.findForward("failure");
	}

	public ISmemberdeputyinfoDAO getSmemberdeputyinfoDAO() {
		return smemberdeputyinfoDAO;
	}

	public void setSmemberdeputyinfoDAO(ISmemberdeputyinfoDAO smemberdeputyinfoDAO) {
		this.smemberdeputyinfoDAO = smemberdeputyinfoDAO;
	}

}
