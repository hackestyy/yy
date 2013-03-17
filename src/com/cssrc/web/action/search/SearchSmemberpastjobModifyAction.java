package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberpastjob;
import com.cssrc.dao.admin.ISmemberpastjobDAO;
import com.cssrc.web.form.admin.SmemberpastjobForm;

public class SearchSmemberpastjobModifyAction extends Action {
	public SearchSmemberpastjobModifyAction() {
	}

	private ISmemberpastjobDAO smemberpastjobDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberpastjobForm form = new SmemberpastjobForm();
		Integer smpj_id = Integer.valueOf(httpServletRequest.getParameter("smpj_id"));
		Smemberpastjob bean = smemberpastjobDAO.getSmemberpastjob(smpj_id);

		form.setSmpj_id(bean.getSmpj_id());
		form.setSmbi_id(bean.getSmbi_id());
		form.setJobaddress(bean.getJobaddress());
		form.setJobinstitute(bean.getJobinstitute());
		form.setJobrank(bean.getJobrank());
		if (bean.getStartdate() != null) {
			form.setTempstartdate(bean.getStartdate().toString().substring(0, 10));
		}
		if (bean.getEnddate() != null) {
			form.setTempenddate(bean.getEnddate().toString().substring(0, 10));
		}

		httpServletRequest.setAttribute("smemberpastjobForm", form);
		httpServletRequest.getSession().setAttribute("smpj_id", smpj_id);
		return actionMapping.findForward("success");
	}

	public ISmemberpastjobDAO getSmemberpastjobDAO() {
		return smemberpastjobDAO;
	}

	public void setSmemberpastjobDAO(ISmemberpastjobDAO smemberpastjobDAO) {
		this.smemberpastjobDAO = smemberpastjobDAO;
	}

}
