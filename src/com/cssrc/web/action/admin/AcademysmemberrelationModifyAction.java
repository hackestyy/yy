package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.web.form.admin.AcademysmemberrelationForm;

public class AcademysmemberrelationModifyAction extends Action {
	public AcademysmemberrelationModifyAction() {
	}

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademysmemberrelationForm form = new AcademysmemberrelationForm();
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		Academysmemberrelation bean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
		form.setAbi_id(bean.getAbi_id());
		form.setSmbi_id(bean.getSmbi_id());
		form.setAsmr_id(asmr_id);
		form.setIsdelete("0");
		form.setAcademyduty1(bean.getAcademyduty1());
		form.setAcademyduty2(bean.getAcademyduty2());
		form.setAcademyduty3(bean.getAcademyduty3());
		form.setAcademyduty4(bean.getAcademyduty4());
		form.setAcademyduty5(bean.getAcademyduty5());
		form.setAcademyduty6(bean.getAcademyduty6());
		form.setAcademyduty7(bean.getAcademyduty7());
		form.setAcademyduty8(bean.getAcademyduty8());
		form.setAcademyduty9(bean.getAcademyduty9());
		form.setAcademyduty10(bean.getAcademyduty10());
		form.setAcademyduty11(bean.getAcademyduty11());
		form.setBelongcommittee1(bean.getBelongcommittee1());
		form.setBelongcommittee2(bean.getBelongcommittee2());
		form.setBelongcommittee3(bean.getBelongcommittee3());
		form.setBelongcommittee4(bean.getBelongcommittee4());
		form.setMemtype(bean.getMemtype());
		form.setIsannualregister(bean.getIsannualregister());
		form.setDeletedate(bean.getDeletedate());

		if (bean.getJoindate() != null) {
			form.setTempjoindate(bean.getJoindate().toString().substring(0, 10));
		}

		httpServletRequest.setAttribute("academysmemberrelationForm", form);
		httpServletRequest.getSession().setAttribute("asmr_id", asmr_id);
		httpServletRequest.getSession().setAttribute("abi_id", bean.getAbi_id());
		httpServletRequest.getSession().setAttribute("smbi_id", bean.getSmbi_id());
		String dbwy = httpServletRequest.getParameter("dbwy");
		if (dbwy != null) {
			if (dbwy.equals("wy")) {
				return actionMapping.findForward("success_wy");
			}
			if (dbwy.equals("cw")) {
				return actionMapping.findForward("success_cw");
			} else {
				return actionMapping.findForward("success");
			}
		} else {
			return actionMapping.findForward("success");
		}
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
