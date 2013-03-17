package com.cssrc.web.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.IUserDAO;
import com.cssrc.web.form.common.LoginForm;

public class LogoutAction extends Action {
	public LogoutAction() {
	}

	private IUserDAO userDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		LoginForm form = (LoginForm) actionForm;
		String username = form.getUseraccount();
		form.setUseraccount("");
		form.setUserpwd("");
		httpServletRequest.getSession().removeAttribute("onlineUserBindingListener");
		httpServletRequest.getSession().removeAttribute("USER");
		httpServletRequest.getSession().removeAttribute("userrole");
		httpServletRequest.getSession().removeAttribute("academybaseinfoassoname");
		httpServletRequest.getSession().removeAttribute("shai_id");
		httpServletRequest.getSession().removeAttribute("ACADEMYBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("acadname");
		httpServletRequest.getSession().removeAttribute("ACADGROUPLIST");
		httpServletRequest.getSession().removeAttribute("abi_id");
		httpServletRequest.getSession().removeAttribute("abc_id");
		httpServletRequest.getSession().removeAttribute("ACADEMYJOURNALINFOLIST");
		httpServletRequest.getSession().removeAttribute("ACADEMYBRANDCONSTRUCTLIST");
		httpServletRequest.getSession().removeAttribute("aji_id");
		httpServletRequest.getSession().removeAttribute("ACADEMYORGANIZATIONINFOLIST");
		httpServletRequest.getSession().removeAttribute("aoi_id");
		httpServletRequest.getSession().removeAttribute("asmr_id");
		httpServletRequest.getSession().removeAttribute("smbi_id");
		httpServletRequest.getSession().removeAttribute("ACADEMYSMEMBERRELATIONLIST");
		httpServletRequest.getSession().removeAttribute("ACADEMYSPECIALITYCOMMITTEELIST");
		httpServletRequest.getSession().removeAttribute("asc_id");
		httpServletRequest.getSession().removeAttribute("awc_id");
		httpServletRequest.getSession().removeAttribute("ACADEMYWORKCOMMITTEE");
		httpServletRequest.getSession().removeAttribute("CONDITION");
		httpServletRequest.getSession().removeAttribute("gmbi_id");
		httpServletRequest.getSession().removeAttribute("gmemberabi_id");
		httpServletRequest.getSession().removeAttribute("GMEMBERBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("ACADEMYGMEMBERBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("agmr_id");
		httpServletRequest.getSession().removeAttribute("GMEMBERPATENTINFOLIST");
		httpServletRequest.getSession().removeAttribute("shadal_id");
		httpServletRequest.getSession().removeAttribute("GMEMBERRESEARCHPRODUCTIONLIST");
		httpServletRequest.getSession().removeAttribute("gmrp_id");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYACADEMICLITERATURE");
		httpServletRequest.getSession().removeAttribute("shadbi_id");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYACADEMICLITERATURELIST");
		httpServletRequest.getSession().removeAttribute("assoduty_s");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYBASEINFOADDLIST");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("deputyidentity");
		httpServletRequest.getSession().removeAttribute("shadi_id");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYINFOLIST");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYPASTJOBLIST");
		httpServletRequest.getSession().removeAttribute("shadpj_id");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYPATENTINFOLIST");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYRESEARCHPRODUCTIONLIST");
		httpServletRequest.getSession().removeAttribute("SHADEPUTYRESEARCHPRODUCTION");
		httpServletRequest.getSession().removeAttribute("smbi_id");
		httpServletRequest.getSession().removeAttribute("SMEMBERACADEMICLITERATURELIST");
		httpServletRequest.getSession().removeAttribute("smal_id");
		httpServletRequest.getSession().removeAttribute("SMEMBERACADEMICLITERATURE");
		httpServletRequest.getSession().removeAttribute("smemberabi_id");
		httpServletRequest.getSession().removeAttribute("SMEMBERBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("smemberbaseinfopreview");
		httpServletRequest.getSession().removeAttribute("ACADEMYSMEMBERBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("memidentity");
		httpServletRequest.getSession().removeAttribute("SMEMBERDEPUTYINFOLIST");
		httpServletRequest.getSession().removeAttribute("SMEMBERPASTJOBLIST");
		httpServletRequest.getSession().removeAttribute("SMEMBERPATENTINFOLIST");
		httpServletRequest.getSession().removeAttribute("SMEMBERPATENTINFO");
		httpServletRequest.getSession().removeAttribute("SMEMBERRESEARCHPRODUCTIONLIST");
		httpServletRequest.getSession().removeAttribute("smrp_id");
		httpServletRequest.getSession().removeAttribute("SMEMBERRESEARCHPRODUCTIONLIST");
		httpServletRequest.getSession().removeAttribute("SMEMBERRESEARCHPRODUCTION");
		httpServletRequest.getSession().removeAttribute("userassociation");
		httpServletRequest.getSession().removeAttribute("useracademic");
		httpServletRequest.getSession().removeAttribute("searchshai_id");
		httpServletRequest.getSession().removeAttribute("smemberabi_id");
		httpServletRequest.getSession().removeAttribute("SEARCHACADEMYSMEMBERRELATIONLIST");
		httpServletRequest.getSession().removeAttribute("SEARCHSMEMBERRESEARCHPRODUCTIONLIST");
		httpServletRequest.getSession().removeAttribute("SEARCHSMEMBERACADEMICLITERATURELIST");
		httpServletRequest.getSession().removeAttribute("smpj_id");
		httpServletRequest.getSession().removeAttribute("SEARCHSMEMBERPASTJOBLIST");
		httpServletRequest.getSession().removeAttribute("smpi_id");
		httpServletRequest.getSession().removeAttribute("SEARCHSMEMBERPATENTINFOLIST");
		httpServletRequest.getSession().removeAttribute("SMEMBERBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("ACADEMYSMEMBERBASEINFOLIST");
		httpServletRequest.getSession().removeAttribute("STATINFO_EXCEL");
		httpServletRequest.getSession().removeAttribute("STATINFO");
		httpServletRequest.getSession().removeAttribute("MEMBERSHIPSTATLIST");
		httpServletRequest.getSession().removeAttribute("assoname");
		httpServletRequest.getSession().removeAttribute("SYSACADGROUP");
		httpServletRequest.getSession().removeAttribute("ACADEMIESLIST");
		httpServletRequest.getSession().removeAttribute("memno");
		httpServletRequest.getSession().removeAttribute("acadsearchresultdownload");
		httpServletRequest.getSession().removeAttribute("smemsearchresultdownload");
		httpServletRequest.getSession().removeAttribute("searchalldbwysql");
		httpServletRequest.getSession().removeAttribute("searchJCdbwysql");
		httpServletRequest.getSession().removeAttribute("SEARCHCONDITION4STAT");
		httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
		httpServletRequest.getSession().removeAttribute("deputyname");
		httpServletRequest.getSession().removeAttribute("deputysex");
		httpServletRequest.getSession().removeAttribute("deputybirthday");
		httpServletRequest.getSession().removeAttribute("deputydegree");
		httpServletRequest.getSession().removeAttribute("deputyscholar");
		httpServletRequest.getSession().removeAttribute("memname");
		httpServletRequest.getSession().removeAttribute("memsex");
		httpServletRequest.getSession().removeAttribute("membirthday");
		httpServletRequest.getSession().removeAttribute("memdegree");
		httpServletRequest.getSession().removeAttribute("memscholar");

		return actionMapping.findForward("success");
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
