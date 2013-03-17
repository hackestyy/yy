//参加多个学会的会员继续注册
package com.cssrc.web.action.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadecustom;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcadecustomDAO;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class SmemberbaseinfoSave1Action extends Action {
	public SmemberbaseinfoSave1Action() {
	}

	private IAcadecustomDAO acadecustomDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("smemberabi_id");
		String acadname = (String) httpServletRequest.getSession().getAttribute("acadname");

		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;

		String memname = (String) httpServletRequest.getSession().getAttribute("memname");
		String memsex = (String) httpServletRequest.getSession().getAttribute("memsex");
		String membirthday = (String) httpServletRequest.getSession().getAttribute("membirthday");
		String memdegree = (String) httpServletRequest.getSession().getAttribute("memdegree");
		String memscholar = (String) httpServletRequest.getSession().getAttribute("memscholar");
		List smemberbeseinfobymemidentity = smemberbaseinfoDAO.gainSmemberbaseinfo(memname, memsex, membirthday, memdegree, memscholar);
		Smemberbaseinfo bymemidentitysmemberbeseinfo = (Smemberbaseinfo) smemberbeseinfobymemidentity.get(0);
		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		form.setAbi_id(abi_id);
		Integer asmr_id = (Integer) httpServletRequest.getSession().getAttribute("asmr_id");
		form.setAsmr_id(asmr_id);
		// form.setAcadgroup_no(form.getAcadgroup_no()+1);
		Smemberbaseinfo bean = new Smemberbaseinfo();
		Smemberbaseinfo smemberlist = new Smemberbaseinfo();

		String tempjoindate = form.getTempjoindate();

		Acadecustom acadecustom = new Acadecustom();
		acadecustom.setAbi_id(abi_id);
		if (!(form.getAbino() == null)) {
			acadecustom.setAbino(form.getAbino());
		}
		if (!(form.getSmbi_id() == null)) {
			acadecustom.setSmbi_id(form.getSmbi_id());
		}
		if (!(form.getContent1() == null)) {
			acadecustom.setContent1(form.getContent1());
		}
		if (!(form.getContent2() == null)) {
			acadecustom.setContent2(form.getContent2());
		}
		if (!(form.getContent3() == null)) {
			acadecustom.setContent3(form.getContent3());
		}
		if (!(form.getContent4() == null)) {
			acadecustom.setContent4(form.getContent4());
		}
		if (!(form.getContent5() == null)) {
			acadecustom.setContent5(form.getContent5());
		}
		if (!(form.getContent6() == null)) {
			acadecustom.setContent6(form.getContent6());
		}
		if (tempjoindate.equals("")) {
			tempjoindate = null;
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
		smemberlist.setMemdegree(bymemidentitysmemberbeseinfo.getMemdegree());
		smemberlist.setMemdept(bymemidentitysmemberbeseinfo.getMemdept());
		smemberlist.setMemduty(bymemidentitysmemberbeseinfo.getMemduty());
		smemberlist.setMemidentity(bymemidentitysmemberbeseinfo.getMemidentity());
		smemberlist.setMeminstitute(bymemidentitysmemberbeseinfo.getMeminstitute());
		smemberlist.setMemno(bymemidentitysmemberbeseinfo.getMemno());
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
		// smemberlist.setSeasuniversityenddate(bymemidentitysmemberbeseinfo.getSeasuniversityenddate());
		smemberlist.setSeasuniversityspec(bymemidentitysmemberbeseinfo.getSeasuniversityspec());
		// smemberlist.setSeasuniversitystartdate(bymemidentitysmemberbeseinfo.getSeasuniversitystartdate());
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
		// smemberlist.setUniversityenddate(bymemidentitysmemberbeseinfo.getUniversityenddate());
		smemberlist.setUniversity(bymemidentitysmemberbeseinfo.getUniversity());
		smemberlist.setUniversityspec(bymemidentitysmemberbeseinfo.getUniversityspec());
		// smemberlist.setUniversitystartdate(bymemidentitysmemberbeseinfo.getUniversitystartdate());
		smemberlist.setUseremail(bymemidentitysmemberbeseinfo.getUseremail());
		smemberlist.setUsermobile(bymemidentitysmemberbeseinfo.getUsermobile());

		Academysmemberrelation relationbean = new Academysmemberrelation();
		if (tempjoindate == null) {
			relationbean.setJoindate(new Date());
		} else {
			relationbean.setJoindate(DateUtil.getCalendar(tempjoindate).getTime());
		}
		relationbean.setAbi_id(form.getAbi_id());
		relationbean.setSmbi_id(form.getSmbi_id());
		relationbean.setAsmr_id(form.getAsmr_id());
		relationbean.setIsdelete(form.getIsdelete());
		relationbean.setMemtype(form.getMemtype());
		relationbean.setDeletedate(form.getDeletedate());
		relationbean.setIsannualregister(form.getIsannualregister());
		relationbean.setBelongcommittee1(form.getBelongcommittee1());
		relationbean.setBelongcommittee2(form.getBelongcommittee2());
		relationbean.setBelongcommittee3(form.getBelongcommittee3());
		relationbean.setBelongcommittee4(form.getBelongcommittee4());
		relationbean.setAcademyduty1(form.getAcademyduty1());
		relationbean.setAcademyduty2(form.getAcademyduty2());
		relationbean.setAcademyduty3(form.getAcademyduty3());
		relationbean.setAcademyduty4(form.getAcademyduty4());
		relationbean.setAcademyduty5(form.getAcademyduty5());
		relationbean.setAcademyduty6(form.getAcademyduty6());
		relationbean.setAcademyduty7(form.getAcademyduty7());
		relationbean.setAcademyduty8(form.getAcademyduty8());
		relationbean.setAcademyduty9(form.getAcademyduty9());
		relationbean.setAcademyduty10(form.getAcademyduty10());
		relationbean.setAcademyduty11(form.getAcademyduty11());
		// if (smemberbaseinfoDAO.saveSmemberbaseinfo(smemberlist)) {
		relationbean.setSmbi_id(bymemidentitysmemberbeseinfo.getSmbi_id());
		relationbean.setIsdelete("0");
		if (acadecustomDAO.saveAcadecustom(acadecustom)) {
			if (!academysmemberrelationDAO.saveAcademysmemberrelation(relationbean)) {
				return actionMapping.findForward("smiderrorAdd");
			}
		}

		// }
		httpServletRequest.setAttribute("asmr_id", relationbean.getAsmr_id());
		httpServletRequest.setAttribute("smemberbaseinfoForm", form);
		httpServletRequest.getSession().setAttribute("smbi_id", bymemidentitysmemberbeseinfo.getSmbi_id());
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

	public IAcadecustomDAO getAcadecustomDAO() {
		return acadecustomDAO;
	}

	public void setAcadecustomDAO(IAcadecustomDAO acadecustomDAO) {
		this.acadecustomDAO = acadecustomDAO;
	}

}
