package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberpastjob;
import com.cssrc.dao.admin.ISmemberpastjobDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberpastjobForm;

public class SmemberpastjobSaveAction extends Action {
	public SmemberpastjobSaveAction() {
	}

	private ISmemberpastjobDAO smemberpastjobDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		SmemberpastjobForm form = (SmemberpastjobForm) actionForm;
		Smemberpastjob bean = new Smemberpastjob();
		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		String tempstartdate = form.getTempstartdate();
		String tempenddate = form.getTempenddate();
		if (tempstartdate.equals("")) {
			tempstartdate = null;
		}
		if (tempenddate.equals("")) {
			tempenddate = null;
		}
		if (tempstartdate == null) {
			bean.setStartdate(null);
		} else {
			bean.setStartdate(DateUtil.getCalendar(tempstartdate).getTime());
		}
		if (tempenddate == null) {
			bean.setEnddate(null);
		} else {
			bean.setEnddate(DateUtil.getCalendar(tempenddate).getTime());
		}

		if (!smemberpastjobDAO.saveSmemberpastjob(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("smpj_id", bean.getSmpj_id());
		return actionMapping.findForward("success");
	}

	public ISmemberpastjobDAO getSmemberpastjobDAO() {
		return smemberpastjobDAO;
	}

	public void setSmemberpastjobDAO(ISmemberpastjobDAO smemberpastjobDAO) {
		this.smemberpastjobDAO = smemberpastjobDAO;
	}

}
