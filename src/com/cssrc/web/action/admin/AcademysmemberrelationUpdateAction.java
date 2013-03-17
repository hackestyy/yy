package com.cssrc.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademysmemberrelationForm;

public class AcademysmemberrelationUpdateAction extends Action {
	public AcademysmemberrelationUpdateAction() {
	}

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademysmemberrelationForm form = (AcademysmemberrelationForm) actionForm;
		Academysmemberrelation bean = new Academysmemberrelation();
		Integer asmr_id = (Integer) httpServletRequest.getSession().getAttribute("asmr_id");
		form.setAsmr_id(asmr_id);
		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		bean.setAsmr_id(asmr_id);
		List smemberbainforelationlist = academysmemberrelationDAO.findAcademysmemberrelation(asmr_id);
		Academysmemberrelation smemberbainforelation = (Academysmemberrelation) smemberbainforelationlist.get(0);
		String tempjoindate = form.getTempjoindate();
		if (tempjoindate.equals("")) {
			tempjoindate = null;
		} else {
			bean.setJoindate(DateUtil.getCalendar(tempjoindate).getTime());
		}
		bean.setAbi_id(form.getAbi_id());
		bean.setSmbi_id(form.getSmbi_id());
		bean.setAsmr_id(form.getAsmr_id());
		bean.setIsdelete("0");
		bean.setAcademyduty1(form.getAcademyduty1());
		bean.setAcademyduty2(form.getAcademyduty2());
		bean.setAcademyduty3(form.getAcademyduty3());
		bean.setAcademyduty4(form.getAcademyduty4());
		bean.setAcademyduty5(form.getAcademyduty5());
		bean.setAcademyduty6(form.getAcademyduty6());
		bean.setAcademyduty7(form.getAcademyduty7());
		bean.setAcademyduty8(form.getAcademyduty8());
		bean.setAcademyduty9(form.getAcademyduty9());
		bean.setAcademyduty10(form.getAcademyduty10());
		bean.setAcademyduty11(form.getAcademyduty11());
		bean.setBelongcommittee1(form.getBelongcommittee1());
		bean.setBelongcommittee2(form.getBelongcommittee2());
		bean.setBelongcommittee3(form.getBelongcommittee3());
		bean.setBelongcommittee4(form.getBelongcommittee4());
		bean.setMemtype(form.getMemtype());
		bean.setIsannualregister(form.getIsannualregister());
		bean.setDeletedate(form.getDeletedate());

		if (academysmemberrelationDAO.modifyAcademysmemberrelation(bean)) {
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
		return actionMapping.findForward("failure");
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
