package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademysmemberrelationTempForm;

public class SearchAcademysmemberrelationViewAction extends Action {
	public SearchAcademysmemberrelationViewAction() {
	}

	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademysmemberrelationTempForm form = new AcademysmemberrelationTempForm();
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		Academysmemberrelation bean = new Academysmemberrelation();
		if (httpServletRequest.getParameter("asmr_id") != null) {
			asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
			bean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
		} else {
			asmr_id = (Integer) httpServletRequest.getSession().getAttribute("asmr_id");
			bean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
		}
		form.setIsdelete(bean.getIsdelete());
		if (bean.getJoindate() != null) {
			form.setTempjoindate(DateUtil.getDateString(bean.getJoindate(), "yyyy-MM-dd"));
		} else {
			form.setTempjoindate(null);
		}
		form.setAbi_id(bean.getAbi_id());
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
		form.setAsmr_id(bean.getAsmr_id());
		form.setBelongcommittee1(bean.getBelongcommittee1());
		form.setBelongcommittee2(bean.getBelongcommittee2());
		form.setBelongcommittee3(bean.getBelongcommittee3());
		form.setBelongcommittee4(bean.getBelongcommittee4());
		form.setIsannualregister(bean.getIsannualregister());
		form.setMemtype(bean.getMemtype());

		List acadtAfBookentrys = new ArrayList();
		String abi_idsearchsql = "where abi_id = '" + bean.getAbi_id() + "'";
		acadtAfBookentrys = academybaseinfoDAO.list(abi_idsearchsql);
		Academybaseinfo academybaseinfo = (Academybaseinfo) acadtAfBookentrys.get(0);
		form.setAcadname(academybaseinfo.getAcadname());

		httpServletRequest.setAttribute("academysmemberrelationForm", form);
		httpServletRequest.getSession().setAttribute("asmr_id", asmr_id);
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

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
