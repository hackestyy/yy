package com.cssrc.web.action.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberresearchproduction;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberresearchproductionForm;

public class SearchSmemberresearchproductionUpdateAction extends Action {
	public SearchSmemberresearchproductionUpdateAction() {
	}

	private ISmemberresearchproductionDAO smemberresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberresearchproductionForm form = (SmemberresearchproductionForm) actionForm;
		Smemberresearchproduction bean = new Smemberresearchproduction();

		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
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

		if (smemberresearchproductionDAO.modifySmemberresearchproduction(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public ISmemberresearchproductionDAO getSmemberresearchproductionDAO() {
		return smemberresearchproductionDAO;
	}

	public void setSmemberresearchproductionDAO(ISmemberresearchproductionDAO smemberresearchproductionDAO) {
		this.smemberresearchproductionDAO = smemberresearchproductionDAO;
	}

}
