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

public class SmemberpastjobUpdateAction extends Action {
	public SmemberpastjobUpdateAction() {
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
		if (tempstartdate.equals("")) {
			tempstartdate = null;
		} else {
			bean.setStartdate(DateUtil.getCalendar(tempstartdate).getTime());
		}
		String tempenddate = form.getTempenddate();
		if (tempenddate.equals("")) {
			tempenddate = null;
		} else {
			bean.setEnddate(DateUtil.getCalendar(tempenddate).getTime());
		}

		if (smemberpastjobDAO.modifySmemberpastjob(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public ISmemberpastjobDAO getSmemberpastjobDAO() {
		return smemberpastjobDAO;
	}

	public void setSmemberpastjobDAO(ISmemberpastjobDAO smemberpastjobDAO) {
		this.smemberpastjobDAO = smemberpastjobDAO;
	}

}
