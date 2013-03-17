package com.cssrc.web.action.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class ShadeputyBaseinfolistViewAction extends Action {
	public ShadeputyBaseinfolistViewAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberbaseinfoForm form = new SmemberbaseinfoForm();

		Integer smbi_id = Integer.valueOf(httpServletRequest.getParameter("smbi_id"));
		List relationlist = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
		Integer size = relationlist.size();
		if (size == 0) {
			return actionMapping.findForward("failure2");
		} else {
			Academysmemberrelation academysmemberrelation = (Academysmemberrelation) relationlist.get(0);
			Integer asmr_id = academysmemberrelation.getAsmr_id();
			Academysmemberrelation relationbean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
			Integer abi_id = relationbean.getAbi_id();
			List acadebaseinfolist = academybaseinfoDAO.findAcademybaseinfo(abi_id);
			Academybaseinfo academybaseinfo = (Academybaseinfo) acadebaseinfolist.get(0);
			String acadename = academybaseinfo.getAcadname();
			Smemberbaseinfo bean = new Smemberbaseinfo();
			bean = smemberbaseinfoDAO.getSmemberbaseinfo(smbi_id);
			form.setSmbi_id(bean.getSmbi_id());

			if (bean.getMembirthday() != null) {
				form.setTempmembirthday(DateUtil.getCalendarString(bean.getMembirthday(), "yyyy-MM-dd"));
			} else {
				form.setTempmembirthday(null);
			}
			if (bean.getUniversitystartdate() != null) {
				form.setTempuniversitystartdate(DateUtil.getCalendarString(bean.getUniversitystartdate(), "yyyy-MM-dd"));
			} else {
				form.setTempuniversitystartdate(null);
			}
			if (bean.getUniversityenddate() != null) {
				form.setTempuniversityenddate(DateUtil.getCalendarString(bean.getUniversityenddate(), "yyyy-MM-dd"));
			} else {
				form.setTempuniversityenddate(null);
			}
			if (bean.getSeasuniversitystartdate() != null) {
				form.setTempseasuniversitystartdate(DateUtil.getCalendarString(bean.getSeasuniversitystartdate(), "yyyy-MM-dd"));
			} else {
				form.setTempseasuniversitystartdate(null);
			}
			if (bean.getSeasuniversityenddate() != null) {
				form.setTempseasuniversityenddate(DateUtil.getCalendarString(bean.getSeasuniversityenddate(), "yyyy-MM-dd"));
			}
			form.setAssoduty_f(bean.getAssoduty_f());
			form.setAssoduty_s(bean.getAssoduty_s());
			form.setForeignlanguage(bean.getForeignlanguage());
			form.setHomeaddress(bean.getHomeaddress());
			form.setHomepostcode(bean.getHomepostcode());
			form.setHometelephone(bean.getHometelephone());
			form.setInstituteaddress(bean.getInstituteaddress());
			form.setInstitutepostcode(bean.getInstitutepostcode());
			form.setInstitutetelephone(bean.getInstitutetelephone());
			form.setInterduty_f(bean.getInterduty_f());
			form.setInterduty_s(bean.getInterduty_s());
			form.setMemdegree(bean.getMemdegree());
			form.setMemdept(bean.getMemdept());
			form.setMemduty(bean.getMemduty());
			form.setMemidentity(bean.getMemidentity());
			form.setMeminstitute(bean.getMeminstitute());
			form.setMemname(bean.getMemname());
			form.setMemnation_f(bean.getMemnation_f());
			form.setMemnation_s(bean.getMemnation_s());
			form.setMemnationality_f(bean.getMemnationality_f());
			form.setMemnationality_s(bean.getMemnationality_s());
			form.setMemparty_f(bean.getMemparty_f());
			form.setMemparty_s(bean.getMemparty_s());
			form.setMemrank_s(bean.getMemrank_s());
			form.setMemrank_f(bean.getMemrank_f());
			form.setMemscholar(bean.getMemscholar());
			form.setMemsex(bean.getMemsex());
			form.setMemskill(bean.getMemskill());
			form.setMemspeciality(bean.getMemspeciality());
			form.setNationduty_f(bean.getNationduty_f());
			form.setNationduty_s(bean.getNationduty_s());
			form.setSocialduty1(bean.getSocialduty1());
			form.setSocialduty2(bean.getSocialduty2());
			form.setSocialduty3(bean.getSocialduty3());
			form.setSocialduty4(bean.getSocialduty4());
			form.setSocialduty5(bean.getSocialduty5());
			form.setSocialduty6(bean.getSocialduty6());
			form.setSocialduty7(bean.getSocialduty7());
			form.setSocialduty8(bean.getSocialduty8());
			form.setSocialhonour1(bean.getSocialhonour1());
			form.setSocialhonour2(bean.getSocialhonour2());
			form.setSocialhonour3(bean.getSocialhonour3());
			form.setSocialhonour4(bean.getSocialhonour4());
			form.setSocialhonour5(bean.getSocialhonour5());
			form.setSocialhonour6(bean.getSocialhonour6());
			form.setSocialhonour7(bean.getSocialhonour7());
			form.setSocialhonour8(bean.getSocialhonour8());
			form.setSocialhonour9(bean.getSocialhonour9());
			form.setSocialhonour10(bean.getSocialhonour10());
			form.setSocialhonour11(bean.getSocialhonour11());
			form.setSocialhonour12(bean.getSocialhonour12());
			form.setSocialhonour13(bean.getSocialhonour13());
			form.setSocialhonour14(bean.getSocialhonour14());
			form.setSocialhonour15(bean.getSocialhonour15());
			form.setSocialhonour16(bean.getSocialhonour16());
			form.setSocialhonour17(bean.getSocialhonour17());
			form.setSocialhonour18(bean.getSocialhonour18());
			form.setSocialhonour19(bean.getSocialhonour19());
			form.setSocialhonour20(bean.getSocialhonour20());
			form.setSports1(bean.getSports1());
			form.setSports2(bean.getSports2());
			form.setSports3(bean.getSports3());
			form.setSports4(bean.getSports4());
			form.setSports5(bean.getSports5());
			form.setSports6(bean.getSports6());
			form.setSports7(bean.getSports7());
			form.setSports8(bean.getSports8());
			form.setUniversity(bean.getUniversity());
			form.setUniversityspec(bean.getUniversityspec());
			form.setUniversitystartdate(bean.getUniversitystartdate());
			form.setUniversityenddate(bean.getUniversityenddate());
			form.setSeasuniversity(bean.getSeasuniversity());
			form.setSeasuniversityspec(bean.getSeasuniversityspec());
			form.setSeasuniversityenddate(bean.getSeasuniversityenddate());
			form.setSeasuniversitystartdate(bean.getSeasuniversitystartdate());
			form.setUseremail(bean.getUseremail());
			form.setUsermobile(bean.getUsermobile());
			form.setIsemployee(bean.getIsemployee());

			form.setAsmr_id(relationbean.getAsmr_id());
			if (relationbean.getJoindate() != null) {
				form.setTempjoindate(DateUtil.getDateString(relationbean.getJoindate(), "yyyy-MM-dd"));
			} else {
				form.setTempjoindate(null);
			}
			form.setAbi_id(relationbean.getAbi_id());
			form.setSmbi_id(relationbean.getSmbi_id());
			form.setIsdelete(relationbean.getIsdelete());
			form.setMemtype(relationbean.getMemtype());
			form.setDeletedate(relationbean.getDeletedate());
			form.setIsannualregister(relationbean.getIsannualregister());
			form.setBelongcommittee1(relationbean.getBelongcommittee1());
			form.setBelongcommittee2(relationbean.getBelongcommittee2());
			form.setBelongcommittee3(relationbean.getBelongcommittee3());
			form.setBelongcommittee4(relationbean.getBelongcommittee4());
			form.setAcademyduty1(relationbean.getAcademyduty1());
			form.setAcademyduty2(relationbean.getAcademyduty2());
			form.setAcademyduty3(relationbean.getAcademyduty3());
			form.setAcademyduty4(relationbean.getAcademyduty4());
			form.setAcademyduty5(relationbean.getAcademyduty5());
			form.setAcademyduty6(relationbean.getAcademyduty6());
			form.setAcademyduty7(relationbean.getAcademyduty7());
			form.setAcademyduty8(relationbean.getAcademyduty8());
			form.setAcademyduty9(relationbean.getAcademyduty9());
			form.setAcademyduty10(relationbean.getAcademyduty10());
			form.setAcademyduty11(relationbean.getAcademyduty11());

			httpServletRequest.setAttribute("smemberbaseinfoForm", form);
			httpServletRequest.getSession().setAttribute("smbi_id", relationbean.getSmbi_id());
			httpServletRequest.getSession().setAttribute("asmr_id", asmr_id);

			httpServletRequest.setAttribute("memnationality_s", bean.getMemnationality_s());
			httpServletRequest.setAttribute("memnationality_f", bean.getMemnationality_f());
			httpServletRequest.setAttribute("memnation_s", bean.getMemnation_s());
			httpServletRequest.setAttribute("memnation_f", bean.getMemnation_f());
			httpServletRequest.setAttribute("memparty_s", bean.getMemparty_s());
			httpServletRequest.setAttribute("memparty_f", bean.getMemparty_f());
			httpServletRequest.setAttribute("memrank_s", bean.getMemrank_s());
			httpServletRequest.setAttribute("memrank_f", bean.getMemrank_f());
			httpServletRequest.setAttribute("interduty_s", bean.getInterduty_s());
			httpServletRequest.setAttribute("interduty_f", bean.getInterduty_f());
			httpServletRequest.setAttribute("nationduty_s", bean.getNationduty_s());
			httpServletRequest.setAttribute("nationduty_f", bean.getNationduty_f());
			httpServletRequest.getSession().setAttribute("acadname", acadename);

			return actionMapping.findForward("success");
		}
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

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
