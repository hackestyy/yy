package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputypatentinfo;
import com.cssrc.dao.admin.IShadeputypatentinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputypatentinfoForm;

public class ShadeputypatentinfoSaveAction extends Action {
	public ShadeputypatentinfoSaveAction() {
	}

	private IShadeputypatentinfoDAO shadeputypatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputypatentinfoForm form = (ShadeputypatentinfoForm) actionForm;
		Shadeputypatentinfo bean = new Shadeputypatentinfo();

		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);

		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		String temppatentdate = form.getTemppatentdate();
		if (temppatentdate.equals("")) {
			temppatentdate = null;
		} else {
			bean.setPatentdate(DateUtil.getCalendar(temppatentdate).getTime());
		}

		if (!shadeputypatentinfoDAO.saveShadeputypatentinfo(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("shadpi_id", bean.getShadpi_id());
		return actionMapping.findForward("success");
	}

	public IShadeputypatentinfoDAO getShadeputypatentinfoDAO() {
		return shadeputypatentinfoDAO;
	}

	public void setShadeputypatentinfoDAO(IShadeputypatentinfoDAO shadeputypatentinfoDAO) {
		this.shadeputypatentinfoDAO = shadeputypatentinfoDAO;
	}

}
