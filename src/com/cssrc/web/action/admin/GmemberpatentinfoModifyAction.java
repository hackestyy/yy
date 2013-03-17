package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberpatentinfo;
import com.cssrc.dao.admin.IGmemberpatentinfoDAO;
import com.cssrc.web.form.admin.GmemberpatentinfoForm;

public class GmemberpatentinfoModifyAction extends Action {
	public GmemberpatentinfoModifyAction() {
	}

	private IGmemberpatentinfoDAO gmemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberpatentinfoForm form = new GmemberpatentinfoForm();
		Integer gmpi_id = Integer.valueOf(httpServletRequest.getParameter("gmpi_id"));
		Gmemberpatentinfo bean = gmemberpatentinfoDAO.getGmemberpatentinfo(gmpi_id);

		form.setGmpi_id(bean.getGmpi_id());
		form.setGmbi_id(bean.getGmbi_id());
		form.setPatentname(bean.getPatentname().toString());
		if (bean.getPatentdate() != null) {
			form.setTemppatentdate(bean.getPatentdate().toString().substring(0, 10));
		}
		form.setPatenttype(bean.getPatenttype().toString());
		form.setPatentapplication(bean.getPatentapplication().toString());

		httpServletRequest.setAttribute("GmemberpatentinfoForm", form);
		httpServletRequest.getSession().setAttribute("gmpi_id", gmpi_id);
		return actionMapping.findForward("success");
	}

	public IGmemberpatentinfoDAO getGmemberpatentinfoDAO() {
		return gmemberpatentinfoDAO;
	}

	public void setGmemberpatentinfoDAO(IGmemberpatentinfoDAO gmemberpatentinfoDAO) {
		this.gmemberpatentinfoDAO = gmemberpatentinfoDAO;
	}
}
