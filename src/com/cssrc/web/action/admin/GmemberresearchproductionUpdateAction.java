package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberresearchproduction;
import com.cssrc.dao.admin.IGmemberresearchproductionDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.GmemberresearchproductionForm;

public class GmemberresearchproductionUpdateAction extends Action {
	public GmemberresearchproductionUpdateAction() {
	}

	private IGmemberresearchproductionDAO gmemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberresearchproductionForm form = (GmemberresearchproductionForm) actionForm;
		Gmemberresearchproduction bean = new Gmemberresearchproduction();

		Integer gmbi_id = (Integer) httpServletRequest.getSession().getAttribute("gmbi_id");
		form.setGmbi_id(gmbi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		String tempproddate = form.getTempproddate();
		if (tempproddate.equals("")) {
			tempproddate = null;
		} else {
			bean.setProddate(DateUtil.getCalendar(tempproddate).getTime());
		}

		if (gmemberresearchproductionDAO.modifyGmemberresearchproduction(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IGmemberresearchproductionDAO getGmemberresearchproductionDAO() {
		return gmemberresearchproductionDAO;
	}

	public void setGmemberresearchproductionDAO(IGmemberresearchproductionDAO gmemberresearchproductionDAO) {
		this.gmemberresearchproductionDAO = gmemberresearchproductionDAO;
	}
}
