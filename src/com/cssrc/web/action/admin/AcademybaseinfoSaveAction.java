package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademybaseinfoForm;

/**
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcademybaseinfoSaveAction extends Action {
	public AcademybaseinfoSaveAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfoForm form = (AcademybaseinfoForm) actionForm;
		// form.setAcadgroup_no(form.getAcadgroup_no()+1);
		Academybaseinfo bean = new Academybaseinfo();

		String sql = "select * from t_academybaseinfo where acadname= '" + form.getAcadname() + "'";

		if (academybaseinfoDAO.selectAcadName(sql)) {
			Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
			bean.setShai_id(shai_id);
			bean.setAbi_id(form.getAbi_id());
			String tempregisterdate = form.getTempregisterdate();
			if (tempregisterdate.equals("")) {
				tempregisterdate = null;
			}
			if (tempregisterdate == null) {
				bean.setRegisterdate(null);
			} else {
				bean.setRegisterdate(DateUtil.getCalendar(tempregisterdate));
			}
			bean.setAcadname(form.getAcadname());
			bean.setAcadno(form.getAcadno());
			bean.setAddress1(form.getAddress1());
			bean.setAddress2(form.getAddress2());
			bean.setPostcode1(form.getPostcode1());
			bean.setPostcode2(form.getPostcode2());
			bean.setRegisterfund(form.getRegisterfund());
			bean.setContactperson(form.getContactperson());
			bean.setContactphone(form.getContactphone());
			bean.setContactfax(form.getContactfax());
			bean.setStarlevel(form.getStarlevel());
			bean.setIs311(form.getIs311());
			bean.setOperationrange(form.getOperationrange());
			bean.setStaffcount(form.getStaffcount());
			bean.setParttimecount(form.getParttimecount());

			bean.setCertifyyear(DateUtil.getCalendar(form.getTempcertifyyear()));

			if (!academybaseinfoDAO.saveAcademybaseinfo(bean)) {
				return actionMapping.findForward("smiderrorAdd");
			}
			httpServletRequest.getSession().setAttribute("abi_id", bean.getAbi_id());
			return actionMapping.findForward("success");
		} else {
			return actionMapping.findForward("alreadyexist");
		}

	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}
}
