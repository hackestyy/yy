package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputypastjob;
import com.cssrc.dao.admin.IShadeputypastjobDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputypastjobForm;

public class ShadeputypastjobUpdateAction extends Action {
	public ShadeputypastjobUpdateAction() {
	}

	private IShadeputypastjobDAO shadeputypastjobDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputypastjobForm form = (ShadeputypastjobForm) actionForm;
		Shadeputypastjob bean = new Shadeputypastjob();

		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		String tempstartdate = form.getTempstartdate();
		String tempenddate = form.getTempenddate();

		if (tempstartdate.equals("")) {
			tempstartdate = null;
		} else {
			bean.setStartdate(DateUtil.getCalendar(tempstartdate).getTime());
		}
		if (tempenddate.equals("")) {
			tempenddate = null;
		} else {
			bean.setEnddate(DateUtil.getCalendar(tempenddate).getTime());
		}
		if (shadeputypastjobDAO.modifyShadeputypastjob(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IShadeputypastjobDAO getShadeputypastjobDAO() {
		return shadeputypastjobDAO;
	}

	public void setShadeputypastjobDAO(IShadeputypastjobDAO shadeputypastjobDAO) {
		this.shadeputypastjobDAO = shadeputypastjobDAO;
	}

}
