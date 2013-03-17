package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Gmemberpatentinfo;
import com.cssrc.dao.admin.IGmemberpatentinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.GmemberpatentinfoForm;

public class GmemberpatentinfoSaveAction extends Action {
	public GmemberpatentinfoSaveAction() {
	}

	private IGmemberpatentinfoDAO gmemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberpatentinfoForm form = (GmemberpatentinfoForm) actionForm;
		Gmemberpatentinfo bean = new Gmemberpatentinfo();

		Integer gmbi_id = (Integer) httpServletRequest.getSession().getAttribute("gmbi_id");
		form.setGmbi_id(gmbi_id);

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

		if (!gmemberpatentinfoDAO.saveGmemberpatentinfo(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("shadal_id", bean.getGmbi_id());
		return actionMapping.findForward("success");
	}

	public IGmemberpatentinfoDAO getGmemberpatentinfoDAO() {
		return gmemberpatentinfoDAO;
	}

	public void setGmemberpatentinfoDAO(IGmemberpatentinfoDAO gmemberpatentinfoDAO) {
		this.gmemberpatentinfoDAO = gmemberpatentinfoDAO;
	}
}
