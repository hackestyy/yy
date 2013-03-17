package com.cssrc.web.action.admin;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;

import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.Smemberdeputyinfo;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

/**
 * <p>
 * Title: BKUpdateAction
 * </p>
 * <p>
 * Description: ÊÔÑé±³¾°×ÊÁÏ¿â(T_FD_BACKGR)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class SmemberbaseinfoUpdateAction1 extends Action {
	public SmemberbaseinfoUpdateAction1() {
	}

	private ISmemberdeputyinfoDAO smemberdeputyinfoDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
		Smemberbaseinfo bean = new Smemberbaseinfo();
		Smemberdeputyinfo deputyinfobean = new Smemberdeputyinfo();
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("smemberabi_id");
		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		form.setAbi_id(abi_id);
		Integer asmr_id = (Integer) httpServletRequest.getSession().getAttribute("asmr_id");
		form.setAsmr_id(asmr_id);
		bean.setMemidentity(form.getMemidentity());
		bean.setAssoduty_f(form.getAssoduty_f());
		bean.setAssoduty_s(form.getAssoduty_s());
		String memidentity = form.getMemidentity();
		String memname = form.getMemname();
		String memsex = form.getMemsex();
		String membirthday = form.getTempmembirthday();
		String memdegree = form.getMemdegree();
		String memscholar = form.getMemscholar();
		List smemberbeseinfobymemidentity = smemberbaseinfoDAO.findSmemberbaseinfo(smbi_id);
		// List smemberbeseinfobymemidentity =
		// smemberbaseinfoDAO.gainSmemberbaseinfo(memidentity);
		Smemberbaseinfo bymemidentitysmemberbeseinfo = (Smemberbaseinfo) smemberbeseinfobymemidentity.get(0);
		Integer smbi_id_now = bymemidentitysmemberbeseinfo.getSmbi_id();

		// Integer size = smemberbeseinfobymemidentity.size();
		String assoduty_f_past = bymemidentitysmemberbeseinfo.getAssoduty_f();
		String assoduty_s_past = bymemidentitysmemberbeseinfo.getAssoduty_s();

		String tempmembirthday = form.getTempmembirthday();
		String tempuniversitystartdate = form.getTempuniversitystartdate();
		String tempuniversityenddate = form.getTempuniversityenddate();
		String tempseasuniversitystartdate = form.getTempseasuniversitystartdate();
		String tempseasuniversityenddate = form.getTempseasuniversityenddate();

		if (tempmembirthday.equals("")) {
			tempmembirthday = null;
		}
		if (tempuniversitystartdate.equals("")) {
			tempuniversitystartdate = null;
		}
		if (tempuniversityenddate.equals("")) {
			tempuniversityenddate = null;
		}
		if (tempseasuniversitystartdate.equals("")) {
			tempseasuniversitystartdate = null;
		}
		if (tempseasuniversityenddate.equals("")) {
			tempseasuniversityenddate = null;
		}

		bean.setSmbi_id(form.getSmbi_id());
		bean.setMembirthday(DateUtil.getCalendar(tempmembirthday));
		bean.setUniversitystartdate(DateUtil.getCalendar(tempuniversitystartdate));
		bean.setUniversityenddate(DateUtil.getCalendar(tempuniversityenddate));
		bean.setSeasuniversitystartdate(DateUtil.getCalendar(tempseasuniversitystartdate));
		bean.setSeasuniversityenddate(DateUtil.getCalendar(tempseasuniversityenddate));

		bean.setAssoduty_f(assoduty_f_past);
		bean.setAssoduty_s(assoduty_s_past);
		bean.setForeignlanguage(form.getForeignlanguage());
		bean.setHomeaddress(form.getHomeaddress());
		bean.setHomepostcode(form.getHomepostcode());
		bean.setHometelephone(form.getHometelephone());
		bean.setInstituteaddress(form.getInstituteaddress());
		bean.setInstitutepostcode(form.getInstitutepostcode());
		bean.setInstitutetelephone(form.getInstitutetelephone());
		bean.setInterduty_f(form.getInterduty_f());
		bean.setInterduty_s(form.getInterduty_s());
		bean.setIsemployee(form.getIsemployee());
		bean.setMemdegree(form.getMemdegree());
		bean.setMemdept(form.getMemdept());
		bean.setMemduty(form.getMemduty());
		bean.setMemno(form.getMemno());
		bean.setMeminstitute(form.getMeminstitute());
		bean.setMemname(form.getMemname());
		bean.setMemnation_f(form.getMemnation_f());
		bean.setMemnation_s(form.getMemnation_s());
		bean.setMemnationality_f(form.getMemnationality_f());
		bean.setMemnationality_s(form.getMemnationality_s());
		bean.setMemparty_f(form.getMemparty_f());
		bean.setMemparty_s(form.getMemparty_s());
		bean.setMemrank_f(form.getMemrank_f());
		bean.setMemrank_s(form.getMemrank_s());
		bean.setMemscholar(form.getMemscholar());
		bean.setMemsex(form.getMemsex());
		bean.setMemskill(form.getMemskill());
		bean.setMemspeciality(form.getMemspeciality());
		bean.setNationduty_f(form.getNationduty_f());
		bean.setNationduty_s(form.getNationduty_s());
		bean.setSeasuniversity(form.getSeasuniversity());
		// bean.setSeasuniversityenddate(form.getSeasuniversityenddate());
		bean.setSeasuniversityspec(form.getSeasuniversityspec());
		// bean.setSeasuniversitystartdate(form.getSeasuniversitystartdate());
		bean.setSocialduty1(form.getSocialduty1());
		bean.setSocialduty2(form.getSocialduty2());
		bean.setSocialduty3(form.getSocialduty3());
		bean.setSocialduty4(form.getSocialduty4());
		bean.setSocialduty5(form.getSocialduty5());
		bean.setSocialduty6(form.getSocialduty6());
		bean.setSocialduty7(form.getSocialduty7());
		bean.setSocialduty8(form.getSocialduty8());
		bean.setSocialhonour1(form.getSocialhonour1());
		bean.setSocialhonour2(form.getSocialhonour2());
		bean.setSocialhonour3(form.getSocialhonour3());
		bean.setSocialhonour4(form.getSocialhonour4());
		bean.setSocialhonour5(form.getSocialhonour5());
		bean.setSocialhonour6(form.getSocialhonour6());
		bean.setSocialhonour7(form.getSocialhonour7());
		bean.setSocialhonour8(form.getSocialhonour8());
		bean.setSocialhonour9(form.getSocialhonour9());
		bean.setSocialhonour10(form.getSocialhonour10());
		bean.setSocialhonour11(form.getSocialhonour11());
		bean.setSocialhonour12(form.getSocialhonour12());
		bean.setSocialhonour13(form.getSocialhonour13());
		bean.setSocialhonour14(form.getSocialhonour14());
		bean.setSocialhonour15(form.getSocialhonour15());
		bean.setSocialhonour16(form.getSocialhonour16());
		bean.setSocialhonour17(form.getSocialhonour17());
		bean.setSocialhonour18(form.getSocialhonour18());
		bean.setSocialhonour19(form.getSocialhonour19());
		bean.setSocialhonour20(form.getSocialhonour20());
		bean.setSports1(form.getSports1());
		bean.setSports2(form.getSports2());
		bean.setSports3(form.getSports3());
		bean.setSports4(form.getSports4());
		bean.setSports5(form.getSports5());
		bean.setSports6(form.getSports6());
		bean.setSports7(form.getSports7());
		bean.setSports8(form.getSports8());
		// bean.setUniversityenddate(form.getUniversityenddate());
		bean.setUniversity(form.getUniversity());
		bean.setUniversityspec(form.getUniversityspec());
		// bean.setUniversitystartdate(form.getUniversitystartdate());
		bean.setUseremail(form.getUseremail());
		bean.setUsermobile(form.getUsermobile());
		bean.setPassword(form.getPassword());

		// form.setMembirthday(DateUtil.getCalendar(form.getTempmembirthday()));
		// form.setUniversitystartdate(DateUtil.getCalendar(form.getTempuniversitystartdate()));
		// form.setUniversityenddate(DateUtil.getCalendar(form.getTempuniversityenddate()));
		// form.setSeasuniversitystartdate(DateUtil.getCalendar(form.getTempseasuniversitystartdate()));
		// form.setSeasuniversityenddate(DateUtil.getCalendar(form.getTempseasuniversityenddate()));
		// form.setJoindate(DateUtil.getCalendar(form.getTempjoindate()));

		/*
		 * Academysmemberrelation relationbean = new Academysmemberrelation();
		 * relationbean.setAsmr_id(asmr_id); List smemberbainforelationlist =
		 * academysmemberrelationDAO.findAcademysmemberrelation(asmr_id);
		 * Academysmemberrelation smemberbainforelation =
		 * (Academysmemberrelation)smemberbainforelationlist.get(0);
		 * String tempjoindate = form.getTempjoindate(); if
		 * (tempjoindate.equals("")) { tempjoindate = null; }else{
		 * relationbean.setJoindate
		 * (DateUtil.getCalendar(tempjoindate).getTime()); }
		 * relationbean.setAbi_id(form.getAbi_id());
		 * relationbean.setSmbi_id(form.getSmbi_id());
		 * relationbean.setAsmr_id(form.getAsmr_id());
		 * relationbean.setIsdelete(form.getIsdelete());
		 * relationbean.setMemtype(form.getMemtype());
		 * relationbean.setDeletedate(form.getDeletedate());
		 * relationbean.setIsannualregister(form.getIsannualregister());
		 * relationbean.setBelongcommittee1(form.getBelongcommittee1());
		 * relationbean.setBelongcommittee2(form.getBelongcommittee2());
		 * relationbean.setBelongcommittee3(form.getBelongcommittee3());
		 * relationbean.setBelongcommittee4(form.getBelongcommittee4());
		 * relationbean.setAcademyduty1(form.getAcademyduty1());
		 * relationbean.setAcademyduty2(form.getAcademyduty2());
		 * relationbean.setAcademyduty3(form.getAcademyduty3());
		 * relationbean.setAcademyduty4(form.getAcademyduty4());
		 * relationbean.setAcademyduty5(form.getAcademyduty5());
		 * relationbean.setAcademyduty6(form.getAcademyduty6());
		 * relationbean.setAcademyduty7(form.getAcademyduty7());
		 * relationbean.setAcademyduty8(form.getAcademyduty8());
		 * relationbean.setAcademyduty9(form.getAcademyduty9());
		 * relationbean.setAcademyduty10(form.getAcademyduty10());
		 * relationbean.setAcademyduty11(form.getAcademyduty11());
		 */

		Smemberbaseinfo smemberbaseinfo = smemberbaseinfoDAO.getSmemberbaseinfo(form.getSmbi_id());

		try {
			InputStream inputStream = form.getMemphoto().getInputStream();
			if (form.getMemphoto().getFileName().equals("")) {
				bean.setMemphoto(smemberbaseinfo.getMemphoto());
			}
			if (!form.getMemphoto().getFileName().equals("")) {
				bean.setMemphoto(Hibernate.createBlob(inputStream));
			}
		} catch (Exception ex) {
		}

		if (smemberbaseinfoDAO.modifySmemberbaseinfo(bean)) {
			/*
			 * relationbean.setSmbi_id(bean.getSmbi_id());
			 * relationbean.setIsdelete("0"); if
			 * (!academysmemberrelationDAO.modifyAcademysmemberrelation(
			 * relationbean)) { return
			 * actionMapping.findForward("smiderrorAdd"); }
			 */
		}

		return actionMapping.findForward("success");
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public ISmemberdeputyinfoDAO getSmemberdeputyinfoDAO() {
		return smemberdeputyinfoDAO;
	}

	public void setSmemberdeputyinfoDAO(ISmemberdeputyinfoDAO smemberdeputyinfoDAO) {
		this.smemberdeputyinfoDAO = smemberdeputyinfoDAO;
	}

}
