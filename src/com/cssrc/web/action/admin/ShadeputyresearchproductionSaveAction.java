package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputyresearchproduction;
import com.cssrc.dao.admin.IShadeputyresearchproductionDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputyresearchproductionForm;

public class ShadeputyresearchproductionSaveAction extends Action {
	public ShadeputyresearchproductionSaveAction() {
	}

	private IShadeputyresearchproductionDAO shadeputyresearchproductionDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputyresearchproductionForm form = (ShadeputyresearchproductionForm) actionForm;
		Shadeputyresearchproduction bean = new Shadeputyresearchproduction();

		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);

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
		if (!shadeputyresearchproductionDAO.saveShadeputyresearchproduction(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("shadrp_id", bean.getShadrp_id());
		return actionMapping.findForward("success");
	}

	public IShadeputyresearchproductionDAO getShadeputyresearchproductionDAO() {
		return shadeputyresearchproductionDAO;
	}

	public void setShadeputyresearchproductionDAO(IShadeputyresearchproductionDAO shadeputyresearchproductionDAO) {
		this.shadeputyresearchproductionDAO = shadeputyresearchproductionDAO;
	}

}
