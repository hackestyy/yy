package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputypatentinfo;
import com.cssrc.dao.admin.IShadeputypatentinfoDAO;
import com.cssrc.web.form.admin.ShadeputypatentinfoForm;

public class ShadeputypatentinfoModifyAction extends Action {
	public ShadeputypatentinfoModifyAction() {
	}

	private IShadeputypatentinfoDAO shadeputypatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputypatentinfoForm form = new ShadeputypatentinfoForm();
		Integer shadpi_id = Integer.valueOf(httpServletRequest.getParameter("shadpi_id"));
		Shadeputypatentinfo bean = shadeputypatentinfoDAO.getShadeputypatentinfo(shadpi_id);

		form.setShadpi_id(bean.getShadpi_id());
		form.setShadbi_id(bean.getShadbi_id());
		form.setPatentname(bean.getPatentname().toString());
		if (bean.getPatentdate() != null) {
			form.setTemppatentdate(bean.getPatentdate().toString().substring(0, 10));
		}
		form.setPatenttype(bean.getPatenttype().toString());
		form.setPatentisindustrialized(bean.getPatentisindustrialized().toString());
		form.setPatentvalue(bean.getPatentvalue().toString());

		httpServletRequest.setAttribute("ShadeputypatentinfoForm", form);
		httpServletRequest.getSession().setAttribute("shadpi_id", shadpi_id);
		return actionMapping.findForward("success");
	}

	public IShadeputypatentinfoDAO getShadeputypatentinfoDAO() {
		return shadeputypatentinfoDAO;
	}

	public void setShadeputypatentinfoDAO(IShadeputypatentinfoDAO shadeputypatentinfoDAO) {
		this.shadeputypatentinfoDAO = shadeputypatentinfoDAO;
	}

}
