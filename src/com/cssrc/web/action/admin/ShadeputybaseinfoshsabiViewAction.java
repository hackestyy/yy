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

public class ShadeputybaseinfoshsabiViewAction extends Action {
	public ShadeputybaseinfoshsabiViewAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ShadeputybaseinfoForm form = new ShadeputybaseinfoForm();
		Shadeputybaseinfo bean = new Shadeputybaseinfo();
		Integer shadbi_id = Integer.valueOf(httpServletRequest.getParameter("shadbi_id"));
		form.setShadbi_id(bean.getShadbi_id());
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
		form.setDeputyname(bean.getDeputyname());
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
		form.setDeputydegree(bean.getDeputydegree());
		form.setDeputydept(bean.getDeputydept());
		form.setMemduty(bean.getMemduty());
		form.setDeputyidentity(bean.getDeputyidentity());
		form.setDeputyinstitute(bean.getDeputyinstitute());
		form.setDeputyname(bean.getDeputyname());
		form.setDeputynation_f(bean.getDeputynation_f());
		form.setDeputynation_s(bean.getDeputynation_s());
		form.setDeputynationality_f(bean.getDeputynationality_f());
		form.setDeputynationality_s(bean.getDeputynationality_s());
		form.setDeputyparty_f(bean.getDeputyparty_f());
		form.setDeputyparty_s(bean.getDeputyparty_s());
		form.setDeputyrank_f(bean.getDeputyrank_f());
		form.setDeputyscholar(bean.getDeputyscholar());
		form.setDeputysex(bean.getDeputysex());
		form.setMemskill(bean.getMemskill());
		form.setNationduty_f(bean.getNationduty_f());
		form.setNationduty_s(bean.getNationduty_s());
		form.setSeasuniversity(bean.getSeasuniversity());
		form.setSeasuniversityenddate(bean.getSeasuniversityenddate());
		form.setSeasuniversityspec(bean.getSeasuniversityspec());
		form.setSeasuniversitystartdate(bean.getSeasuniversitystartdate());
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
		form.setUniversityenddate(bean.getUniversityenddate());
		form.setUniversityspec(bean.getUniversityspec());
		form.setUniversitystartdate(bean.getUniversitystartdate());
		form.setUseremail(bean.getUseremail());
		form.setUsermobile(bean.getUsermobile());

		// try {
		// org.apache.commons.beanutils.BeanUtils.copyProperties(form,
		// bean);
		// } catch (Exception ex) {
		// return actionMapping.findForward("failure");
		// }
		httpServletRequest.setAttribute("shadeputybaseinfoForm", form);

		httpServletRequest.setAttribute("deputynationality_s", bean.getDeputynationality_s());
		httpServletRequest.setAttribute("deputynationality_f", bean.getDeputynationality_f());
		httpServletRequest.setAttribute("deputynation_s", bean.getDeputynation_s());
		httpServletRequest.setAttribute("deputynation_f", bean.getDeputynation_f());
		httpServletRequest.setAttribute("deputyparty_s", bean.getDeputyparty_s());
		httpServletRequest.setAttribute("deputyparty_f", bean.getDeputyparty_f());
		httpServletRequest.setAttribute("deputyrank_s", bean.getDeputyrank_s());
		httpServletRequest.setAttribute("deputyrank_f", bean.getDeputyrank_f());
		httpServletRequest.setAttribute("interduty_s", bean.getInterduty_s());
		httpServletRequest.setAttribute("interduty_f", bean.getInterduty_f());
		httpServletRequest.setAttribute("nationduty_s", bean.getNationduty_s());
		httpServletRequest.setAttribute("nationduty_f", bean.getNationduty_f());

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
