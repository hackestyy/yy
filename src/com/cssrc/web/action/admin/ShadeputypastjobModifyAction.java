package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputypastjob;
import com.cssrc.dao.admin.IShadeputypastjobDAO;
import com.cssrc.web.form.admin.ShadeputypastjobForm;

public class ShadeputypastjobModifyAction extends Action {
	public ShadeputypastjobModifyAction() {
	}

	private IShadeputypastjobDAO shadeputypastjobDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputypastjobForm form = new ShadeputypastjobForm();
		Integer shadpj_id = Integer.valueOf(httpServletRequest.getParameter("shadpj_id"));
		Shadeputypastjob bean = shadeputypastjobDAO.getShadeputypastjob(shadpj_id);

		form.setShadbi_id(bean.getShadbi_id());
		form.setShadpj_id(bean.getShadpj_id());
		if (bean.getStartdate() != null) {
			form.setTempstartdate(bean.getStartdate().toString().substring(0, 10));
		}
		if (bean.getEnddate() != null) {
			form.setTempenddate(bean.getEnddate().toString().substring(0, 10));
		}
		form.setJobaddress(bean.getJobaddress());
		form.setJobinstitute(bean.getJobinstitute());
		form.setJobrank(bean.getJobrank());

		httpServletRequest.setAttribute("shadeputypastjobForm", form);
		httpServletRequest.getSession().setAttribute("shadpj_id", shadpj_id);
		return actionMapping.findForward("success");
	}

	public IShadeputypastjobDAO getShadeputypastjobDAO() {
		return shadeputypastjobDAO;
	}

	public void setShadeputypastjobDAO(IShadeputypastjobDAO shadeputypastjobDAO) {
		this.shadeputypastjobDAO = shadeputypastjobDAO;
	}

}
