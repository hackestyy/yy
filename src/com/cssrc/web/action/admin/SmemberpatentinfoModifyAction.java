package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberpatentinfo;
import com.cssrc.dao.admin.ISmemberpatentinfoDAO;
import com.cssrc.web.form.admin.SmemberpatentinfoForm;

public class SmemberpatentinfoModifyAction extends Action {
	public SmemberpatentinfoModifyAction() {
	}

	private ISmemberpatentinfoDAO smemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberpatentinfoForm form = new SmemberpatentinfoForm();
		Integer smpi_id = Integer.valueOf(httpServletRequest.getParameter("smpi_id"));
		Smemberpatentinfo bean = smemberpatentinfoDAO.getSmemberpatentinfo(smpi_id);

		/*
		 * smpi_id smbi_id patentname patentdate patenttype
		 * patentisindustrialized patentvalue
		 */

		form.setSmpi_id(bean.getSmpi_id());
		form.setSmbi_id(bean.getSmbi_id());
		form.setPatentname(bean.getPatentname().toString());
		if (bean.getPatentdate() != null) {
			form.setTemppatentdate(bean.getPatentdate().toString().substring(0, 10));
		}
		form.setPatenttype(bean.getPatenttype().toString());
		form.setPatentisindustrialized(bean.getPatentisindustrialized().toString());
		form.setPatentvalue(bean.getPatentvalue().toString());

		httpServletRequest.setAttribute("SmemberpatentinfoForm", form);
		httpServletRequest.getSession().setAttribute("smpi_id", smpi_id);
		return actionMapping.findForward("success");
	}

	public ISmemberpatentinfoDAO getSmemberpatentinfoDAO() {
		return smemberpatentinfoDAO;
	}

	public void setSmemberpatentinfoDAO(ISmemberpatentinfoDAO smemberpatentinfoDAO) {
		this.smemberpatentinfoDAO = smemberpatentinfoDAO;
	}
}
