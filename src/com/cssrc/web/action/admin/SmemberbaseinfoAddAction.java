package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadecustom;
import com.cssrc.bean.admin.Acadecustomname;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcadecustomnameDAO;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcadecustomnameForm;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class SmemberbaseinfoAddAction extends Action {
	public SmemberbaseinfoAddAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private IAcadecustomnameDAO acadecustomnameDAO;

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("smemberabi_id");
		String acadname = (String) httpServletRequest.getSession().getAttribute("acadname");
		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
		Acadecustom acadecustombean = new Acadecustom();
		String memname = (String) httpServletRequest.getSession().getAttribute("memname");
		String memsex = (String) httpServletRequest.getSession().getAttribute("memsex");
		String membirthday = (String) httpServletRequest.getSession().getAttribute("membirthday");
		String memdegree = (String) httpServletRequest.getSession().getAttribute("memdegree");
		String memscholar = (String) httpServletRequest.getSession().getAttribute("memscholar");
		List smemberbeseinfobymemidentity = smemberbaseinfoDAO.gainSmemberbaseinfo(memname, memsex, membirthday, memdegree, memscholar);
		// List smemberbeseinfobymemidentity =
		// smemberbaseinfoDAO.gainSmemberbaseinfo(memidentity);
		Smemberbaseinfo bymemidentitysmemberbeseinfo = (Smemberbaseinfo) smemberbeseinfobymemidentity.get(0);
		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		if (smbi_id == null) {
			smbi_id = bymemidentitysmemberbeseinfo.getSmbi_id();
		}
		form.setSmbi_id(smbi_id);
		form.setAbi_id(abi_id);
		Integer asmr_id = (Integer) httpServletRequest.getSession().getAttribute("asmr_id");
		form.setAsmr_id(asmr_id);
		// form.setAcadgroup_no(form.getAcadgroup_no()+1);

		Smemberbaseinfo bean = new Smemberbaseinfo();
		SmemberbaseinfoForm smemberlist = new SmemberbaseinfoForm();
		if (bymemidentitysmemberbeseinfo.getMembirthday() != null) {
			smemberlist.setTempmembirthday(DateUtil.getCalendarString(bymemidentitysmemberbeseinfo.getMembirthday(), "yyyy-MM-dd"));
		} else {
			smemberlist.setTempmembirthday(null);
		}
		if (bymemidentitysmemberbeseinfo.getUniversitystartdate() != null) {
			smemberlist.setTempuniversitystartdate(DateUtil.getCalendarString(bymemidentitysmemberbeseinfo.getUniversitystartdate(), "yyyy-MM-dd"));
		} else {
			smemberlist.setTempuniversitystartdate(null);
		}
		if (bymemidentitysmemberbeseinfo.getUniversityenddate() != null) {
			smemberlist.setTempuniversityenddate(DateUtil.getCalendarString(bymemidentitysmemberbeseinfo.getUniversityenddate(), "yyyy-MM-dd"));
		} else {
			smemberlist.setTempuniversityenddate(null);
		}
		if (bymemidentitysmemberbeseinfo.getSeasuniversitystartdate() != null) {
			smemberlist.setTempseasuniversitystartdate(DateUtil.getCalendarString(bymemidentitysmemberbeseinfo.getSeasuniversitystartdate(), "yyyy-MM-dd"));
		} else {
			smemberlist.setTempseasuniversitystartdate(null);
		}
		if (bymemidentitysmemberbeseinfo.getSeasuniversityenddate() != null) {
			smemberlist.setTempseasuniversityenddate(DateUtil.getCalendarString(bymemidentitysmemberbeseinfo.getSeasuniversityenddate(), "yyyy-MM-dd"));
		} else {
			smemberlist.setTempseasuniversityenddate(null);
		}
		smemberlist.setMembirthday(bymemidentitysmemberbeseinfo.getMembirthday());
		smemberlist.setUniversitystartdate(bymemidentitysmemberbeseinfo.getUniversitystartdate());
		smemberlist.setUniversityenddate(bymemidentitysmemberbeseinfo.getUniversityenddate());
		smemberlist.setSeasuniversitystartdate(bymemidentitysmemberbeseinfo.getSeasuniversitystartdate());
		smemberlist.setSeasuniversityenddate(bymemidentitysmemberbeseinfo.getSeasuniversityenddate());

		smemberlist.setAssoduty_f(bymemidentitysmemberbeseinfo.getAssoduty_f());
		smemberlist.setAssoduty_s(bymemidentitysmemberbeseinfo.getAssoduty_s());
		smemberlist.setForeignlanguage(bymemidentitysmemberbeseinfo.getForeignlanguage());
		smemberlist.setHomeaddress(bymemidentitysmemberbeseinfo.getHomeaddress());
		smemberlist.setHomepostcode(bymemidentitysmemberbeseinfo.getHomepostcode());
		smemberlist.setHometelephone(bymemidentitysmemberbeseinfo.getHometelephone());
		smemberlist.setInstituteaddress(bymemidentitysmemberbeseinfo.getInstituteaddress());
		smemberlist.setInstitutepostcode(bymemidentitysmemberbeseinfo.getInstitutepostcode());
		smemberlist.setInstitutetelephone(bymemidentitysmemberbeseinfo.getInstitutetelephone());
		smemberlist.setInterduty_f(bymemidentitysmemberbeseinfo.getInterduty_f());
		smemberlist.setInterduty_s(bymemidentitysmemberbeseinfo.getInterduty_s());
		smemberlist.setIsemployee(bymemidentitysmemberbeseinfo.getIsemployee());
		smemberlist.setMemno(bymemidentitysmemberbeseinfo.getMemno());
		smemberlist.setPassword(bymemidentitysmemberbeseinfo.getPassword());
		smemberlist.setMemdegree(bymemidentitysmemberbeseinfo.getMemdegree());
		smemberlist.setMemdept(bymemidentitysmemberbeseinfo.getMemdept());
		smemberlist.setMemduty(bymemidentitysmemberbeseinfo.getMemduty());
		smemberlist.setMemidentity(bymemidentitysmemberbeseinfo.getMemidentity());
		smemberlist.setMeminstitute(bymemidentitysmemberbeseinfo.getMeminstitute());
		smemberlist.setMemname(bymemidentitysmemberbeseinfo.getMemname());
		smemberlist.setMemnation_f(bymemidentitysmemberbeseinfo.getMemnation_f());
		smemberlist.setMemnation_s(bymemidentitysmemberbeseinfo.getMemnation_s());
		smemberlist.setMemnationality_f(bymemidentitysmemberbeseinfo.getMemnationality_f());
		smemberlist.setMemnationality_s(bymemidentitysmemberbeseinfo.getMemnationality_s());
		smemberlist.setMemparty_f(bymemidentitysmemberbeseinfo.getMemparty_f());
		smemberlist.setMemparty_s(bymemidentitysmemberbeseinfo.getMemparty_s());
		smemberlist.setMemrank_f(bymemidentitysmemberbeseinfo.getMemrank_f());
		smemberlist.setMemrank_s(bymemidentitysmemberbeseinfo.getMemrank_s());
		smemberlist.setMemscholar(bymemidentitysmemberbeseinfo.getMemscholar());
		smemberlist.setMemsex(bymemidentitysmemberbeseinfo.getMemsex());
		smemberlist.setMemspeciality(bymemidentitysmemberbeseinfo.getMemspeciality());
		smemberlist.setMemskill(bymemidentitysmemberbeseinfo.getMemskill());
		smemberlist.setNationduty_f(bymemidentitysmemberbeseinfo.getNationduty_f());
		smemberlist.setNationduty_s(bymemidentitysmemberbeseinfo.getNationduty_s());
		smemberlist.setSeasuniversity(bymemidentitysmemberbeseinfo.getSeasuniversity());
		smemberlist.setSeasuniversityenddate(bymemidentitysmemberbeseinfo.getSeasuniversityenddate());
		smemberlist.setSeasuniversityspec(bymemidentitysmemberbeseinfo.getSeasuniversityspec());
		smemberlist.setSeasuniversitystartdate(bymemidentitysmemberbeseinfo.getSeasuniversitystartdate());
		smemberlist.setSocialduty1(bymemidentitysmemberbeseinfo.getSocialduty1());
		smemberlist.setSocialduty2(bymemidentitysmemberbeseinfo.getSocialduty2());
		smemberlist.setSocialduty3(bymemidentitysmemberbeseinfo.getSocialduty3());
		smemberlist.setSocialduty4(bymemidentitysmemberbeseinfo.getSocialduty4());
		smemberlist.setSocialduty5(bymemidentitysmemberbeseinfo.getSocialduty5());
		smemberlist.setSocialduty6(bymemidentitysmemberbeseinfo.getSocialduty6());
		smemberlist.setSocialduty7(bymemidentitysmemberbeseinfo.getSocialduty7());
		smemberlist.setSocialduty8(bymemidentitysmemberbeseinfo.getSocialduty8());
		smemberlist.setSocialhonour1(bymemidentitysmemberbeseinfo.getSocialhonour1());
		smemberlist.setSocialhonour2(bymemidentitysmemberbeseinfo.getSocialhonour2());
		smemberlist.setSocialhonour3(bymemidentitysmemberbeseinfo.getSocialhonour3());
		smemberlist.setSocialhonour4(bymemidentitysmemberbeseinfo.getSocialhonour4());
		smemberlist.setSocialhonour5(bymemidentitysmemberbeseinfo.getSocialhonour5());
		smemberlist.setSocialhonour6(bymemidentitysmemberbeseinfo.getSocialhonour6());
		smemberlist.setSocialhonour7(bymemidentitysmemberbeseinfo.getSocialhonour7());
		smemberlist.setSocialhonour8(bymemidentitysmemberbeseinfo.getSocialhonour8());
		smemberlist.setSocialhonour9(bymemidentitysmemberbeseinfo.getSocialhonour9());
		smemberlist.setSocialhonour10(bymemidentitysmemberbeseinfo.getSocialhonour10());
		smemberlist.setSocialhonour11(bymemidentitysmemberbeseinfo.getSocialhonour11());
		smemberlist.setSocialhonour12(bymemidentitysmemberbeseinfo.getSocialhonour12());
		smemberlist.setSocialhonour13(bymemidentitysmemberbeseinfo.getSocialhonour13());
		smemberlist.setSocialhonour14(bymemidentitysmemberbeseinfo.getSocialhonour14());
		smemberlist.setSocialhonour15(bymemidentitysmemberbeseinfo.getSocialhonour15());
		smemberlist.setSocialhonour16(bymemidentitysmemberbeseinfo.getSocialhonour16());
		smemberlist.setSocialhonour17(bymemidentitysmemberbeseinfo.getSocialhonour17());
		smemberlist.setSocialhonour18(bymemidentitysmemberbeseinfo.getSocialhonour18());
		smemberlist.setSocialhonour19(bymemidentitysmemberbeseinfo.getSocialhonour19());
		smemberlist.setSocialhonour20(bymemidentitysmemberbeseinfo.getSocialhonour20());
		smemberlist.setSports1(bymemidentitysmemberbeseinfo.getSports1());
		smemberlist.setSports2(bymemidentitysmemberbeseinfo.getSports2());
		smemberlist.setSports3(bymemidentitysmemberbeseinfo.getSports3());
		smemberlist.setSports4(bymemidentitysmemberbeseinfo.getSports4());
		smemberlist.setSports5(bymemidentitysmemberbeseinfo.getSports5());
		smemberlist.setSports6(bymemidentitysmemberbeseinfo.getSports6());
		smemberlist.setSports7(bymemidentitysmemberbeseinfo.getSports7());
		smemberlist.setSports8(bymemidentitysmemberbeseinfo.getSports8());
		smemberlist.setUniversityenddate(bymemidentitysmemberbeseinfo.getUniversityenddate());
		smemberlist.setUniversity(bymemidentitysmemberbeseinfo.getUniversity());
		smemberlist.setUniversityspec(bymemidentitysmemberbeseinfo.getUniversityspec());
		smemberlist.setUniversitystartdate(bymemidentitysmemberbeseinfo.getUniversitystartdate());
		smemberlist.setUseremail(bymemidentitysmemberbeseinfo.getUseremail());
		smemberlist.setUsermobile(bymemidentitysmemberbeseinfo.getUsermobile());

		List acadecustomnamelist = new ArrayList();
		List acadecustomlist = new ArrayList();
		Acadecustomname acadecustomnamebean = new Acadecustomname();
		acadecustomnamelist = acadecustomnameDAO.findAcadecustomname(abi_id);
		AcadecustomnameForm acadecustomnameform = new AcadecustomnameForm();
		String state = "N";
		String state1 = "N";
		String state2 = "N";
		String state3 = "N";
		String state4 = "N";
		String state5 = "N";
		String state6 = "N";
		for (int i = 0; i < acadecustomnamelist.size(); i++) {
			acadecustomnamebean = (Acadecustomname) acadecustomnamelist.get(i);
			if (acadecustomnamebean.getAbi_id().equals(abi_id)) {
				try {
					org.apache.commons.beanutils.BeanUtils.copyProperties(acadecustomnameform, acadecustomnamebean);

					// 页面显示控制
					state = "Y";
					if (!acadecustomnameform.getName1().equals(null) && !acadecustomnameform.getName1().equals("")) {
						state1 = "Y";
					}
					if (!acadecustomnameform.getName2().equals(null) && !acadecustomnameform.getName2().equals("")) {
						state2 = "Y";
					}
					if (!acadecustomnameform.getName3().equals(null) && !acadecustomnameform.getName3().equals("")) {
						state3 = "Y";
					}
					if (!acadecustomnameform.getName4().equals(null) && !acadecustomnameform.getName4().equals("")) {
						state4 = "Y";
					}
					if (!acadecustomnameform.getName5().equals(null) && !acadecustomnameform.getName5().equals("")) {
						state5 = "Y";
					}
					if (!acadecustomnameform.getName6().equals(null) && !acadecustomnameform.getName6().equals("")) {
						state6 = "Y";
					}

				} catch (Exception e) {
					return actionMapping.findForward("failure");
				}
			}
		}

		// 获取自定义的具体内容

		httpServletRequest.setAttribute("acadecustomnameform", acadecustomnameform);
		httpServletRequest.setAttribute("state", state);
		httpServletRequest.setAttribute("state1", state1);
		httpServletRequest.setAttribute("state2", state2);
		httpServletRequest.setAttribute("state3", state3);
		httpServletRequest.setAttribute("state4", state4);
		httpServletRequest.setAttribute("state5", state5);
		httpServletRequest.setAttribute("state6", state6);

		httpServletRequest.setAttribute("smemberbaseinfoForm1", smemberlist);
		httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
		httpServletRequest.getSession().setAttribute("smemberabi_id", abi_id);
		return actionMapping.findForward("success");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public IAcadecustomnameDAO getAcadecustomnameDAO() {
		return acadecustomnameDAO;
	}

	public void setAcadecustomnameDAO(IAcadecustomnameDAO acadecustomnameDAO) {
		this.acadecustomnameDAO = acadecustomnameDAO;
	}

}