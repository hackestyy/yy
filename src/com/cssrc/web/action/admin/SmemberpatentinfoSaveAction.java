package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberpatentinfo;
import com.cssrc.dao.admin.ISmemberpatentinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberpatentinfoForm;

public class SmemberpatentinfoSaveAction extends Action {
	public SmemberpatentinfoSaveAction() {
	}

	private ISmemberpatentinfoDAO smemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberpatentinfoForm form = (SmemberpatentinfoForm) actionForm;
		Smemberpatentinfo bean = new Smemberpatentinfo();

		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);

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

		if (!smemberpatentinfoDAO.saveSmemberpatentinfo(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("smpi_id", bean.getSmpi_id());
		return actionMapping.findForward("success");
	}

	public ISmemberpatentinfoDAO getSmemberpatentinfoDAO() {
		return smemberpatentinfoDAO;
	}

	public void setSmemberpatentinfoDAO(ISmemberpatentinfoDAO smemberpatentinfoDAO) {
		this.smemberpatentinfoDAO = smemberpatentinfoDAO;
	}
}
