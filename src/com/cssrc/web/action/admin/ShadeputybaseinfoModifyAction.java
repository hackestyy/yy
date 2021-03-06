package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputybaseinfoForm;

public class ShadeputybaseinfoModifyAction extends Action {
	public ShadeputybaseinfoModifyAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputybaseinfoForm form = new ShadeputybaseinfoForm();
		Integer shadbi_id = Integer.valueOf(httpServletRequest.getParameter("shadbi_id"));
		Shadeputybaseinfo bean = shadeputybaseinfoDAO.getShadeputybaseinfo(shadbi_id);
		if (bean.getDeputybirthday() != null) {
			form.setTempdeputybirthday(DateUtil.getCalendarString(bean.getDeputybirthday(), "yyyy-MM-dd"));
		} else {
			form.setTempdeputybirthday(null);
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
		} else {
			form.setTempseasuniversityenddate(null);
		}

		form.setShadbi_id(shadbi_id);
		form.setDeputyno(bean.getDeputyno());
		form.setDeputyname(bean.getDeputyname());
		form.setDeputyidentity(bean.getDeputyidentity());
		form.setDeputysex(bean.getDeputysex());
		form.setDeputynation_f(bean.getDeputynation_f());
		form.setDeputynation_s(bean.getDeputynation_s());
		form.setDeputyparty_f(bean.getDeputyparty_f());
		form.setDeputyparty_s(bean.getDeputyparty_s());
		form.setDeputynationality_f(bean.getDeputynationality_f());
		form.setDeputynationality_s(bean.getDeputynationality_s());
		form.setDeputydegree(bean.getDeputydegree());
		form.setDeputyscholar(bean.getDeputyscholar());
		form.setDeputyrank_s(bean.getDeputyrank_s());
		form.setDeputyrank_f(bean.getDeputyrank_f());
		form.setDeputyinstitute(bean.getDeputyinstitute());
		form.setDeputydept(bean.getDeputydept());
		form.setIsemployee(bean.getIsemployee());
		form.setMemduty(bean.getMemduty());
		form.setMemskill(bean.getMemskill());
		form.setMemspeciality(bean.getMemspeciality());
		form.setForeignlanguage(bean.getForeignlanguage());
		form.setAssoduty_f(bean.getAssoduty_f());
		form.setAssoduty_s(bean.getAssoduty_s());
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
		form.setInterduty_f(bean.getInterduty_f());
		form.setInterduty_s(bean.getInterduty_s());
		form.setNationduty_f(bean.getNationduty_f());
		form.setNationduty_s(bean.getNationduty_s());
		form.setInstituteaddress(bean.getInstituteaddress());
		form.setInstitutepostcode(bean.getInstitutepostcode());
		form.setInstitutetelephone(bean.getInstitutetelephone());
		form.setHomeaddress(bean.getHomeaddress());
		form.setHomepostcode(bean.getHomepostcode());
		form.setHometelephone(bean.getHometelephone());
		form.setUseremail(bean.getUseremail());
		form.setUsermobile(bean.getUsermobile());
		form.setUniversity(bean.getUniversity());
		form.setUniversityspec(bean.getUniversityspec());

		form.setSeasuniversity(bean.getSeasuniversity());
		form.setSeasuniversityspec(bean.getSeasuniversityspec());

		httpServletRequest.setAttribute("shadeputybaseinfoForm", form);
		httpServletRequest.getSession().setAttribute("shadbi_id", shadbi_id);
		return actionMapping.findForward("success");
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
