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

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.bean.admin.Shadeputyinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.dao.admin.IShadeputyinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputybaseinfoForm;

public class ShadeputybaseinfoUpdateAction extends Action {
	public ShadeputybaseinfoUpdateAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;
	private IShadeputyinfoDAO shadeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		ShadeputybaseinfoForm form = (ShadeputybaseinfoForm) actionForm;
		Shadeputybaseinfo bean = new Shadeputybaseinfo();
		Shadeputyinfo deputyinfobean = new Shadeputyinfo();
		String assoduty_s = String.valueOf(httpServletRequest.getSession().getAttribute("assoduty_s"));

		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);

		bean.setAssoduty_f(form.getAssoduty_f());
		bean.setAssoduty_s(form.getAssoduty_s());
		String assoduty_f_now = form.getAssoduty_f();
		String assoduty_s_now = form.getAssoduty_s();
		List shadeputybaseinfobydeputyidentity = shadeputybaseinfoDAO.findShadeputybaseinfo(shadbi_id);
		Shadeputybaseinfo bydeputyidentityshadeputybaseinfo = (Shadeputybaseinfo) shadeputybaseinfobydeputyidentity.get(0);
		Integer shadbi_id_now = bydeputyidentityshadeputybaseinfo.getShadbi_id();

		// Integer size = smemberbeseinfobymemidentity.size();
		String assoduty_f_past = bydeputyidentityshadeputybaseinfo.getAssoduty_f();
		String assoduty_s_past = bydeputyidentityshadeputybaseinfo.getAssoduty_s();
		if (!assoduty_s_past.equals(assoduty_s_now)) {
			deputyinfobean.setShadbi_id(shadbi_id_now);
			deputyinfobean.setAssoduty_f(bydeputyidentityshadeputybaseinfo.getAssoduty_f());
			deputyinfobean.setAssoduty_s(bydeputyidentityshadeputybaseinfo.getAssoduty_s());
			if (!shadeputyinfoDAO.saveShadeputyinfo(deputyinfobean)) {
				return actionMapping.findForward("failure");
			}
		}

		String tempdeputybirthday = form.getTempdeputybirthday();
		String tempuniversitystartdate = form.getTempuniversitystartdate();
		String tempuniversityenddate = form.getTempuniversityenddate();
		String tempseasuniversitystartdate = form.getTempseasuniversitystartdate();
		String tempseasuniversityenddate = form.getTempseasuniversityenddate();
		if (tempdeputybirthday.equals("")) {
			tempdeputybirthday = null;
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

		bean.setDeputybirthday(DateUtil.getCalendar(tempdeputybirthday));
		bean.setUniversitystartdate(DateUtil.getCalendar(tempuniversitystartdate));
		bean.setUniversityenddate(DateUtil.getCalendar(tempuniversityenddate));
		bean.setSeasuniversitystartdate(DateUtil.getCalendar(tempseasuniversitystartdate));
		bean.setSeasuniversityenddate(DateUtil.getCalendar(tempseasuniversityenddate));

		bean.setDeputyno(bydeputyidentityshadeputybaseinfo.getDeputyno());
		bean.setAssoduty_f(form.getAssoduty_f());
		bean.setAssoduty_s(form.getAssoduty_s());
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
		bean.setDeputydegree(form.getDeputydegree());
		bean.setDeputydept(form.getDeputydept());
		bean.setMemduty(form.getMemduty());
		bean.setDeputyidentity(form.getDeputyidentity());
		bean.setDeputyinstitute(form.getDeputyinstitute());
		bean.setDeputyname(form.getDeputyname());
		bean.setDeputynation_f(form.getDeputynation_f());
		bean.setDeputynation_s(form.getDeputynation_s());
		bean.setDeputynationality_f(form.getDeputynationality_f());
		bean.setDeputynationality_s(form.getDeputynationality_s());
		bean.setDeputyparty_f(form.getDeputyparty_f());
		bean.setDeputyparty_s(form.getDeputyparty_s());
		bean.setDeputyrank_f(form.getDeputyrank_f());
		bean.setDeputyrank_s(form.getDeputyrank_s());
		bean.setDeputyscholar(form.getDeputyscholar());
		bean.setDeputysex(form.getDeputysex());
		bean.setMemskill(form.getMemskill());
		bean.setMemspeciality(form.getMemspeciality());
		bean.setNationduty_f(form.getNationduty_f());
		bean.setNationduty_s(form.getNationduty_s());
		bean.setSeasuniversity(form.getSeasuniversity());
		bean.setSeasuniversityspec(form.getSeasuniversityspec());
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
		bean.setUniversity(form.getUniversity());
		bean.setUniversityspec(form.getUniversityspec());
		bean.setUseremail(form.getUseremail());
		bean.setUsermobile(form.getUsermobile());
		bean.setShadbi_id(shadbi_id);

		Shadeputybaseinfo shadeputybaseinfo = shadeputybaseinfoDAO.getShadeputybaseinfo(form.getShadbi_id());

		try {
			InputStream inputStream = form.getDeputyphoto().getInputStream();
			if (form.getDeputyphoto().getFileName().equals("")) {
				bean.setDeputyphoto(shadeputybaseinfo.getDeputyphoto());
			}
			if (!form.getDeputyphoto().getFileName().equals("")) {
				bean.setDeputyphoto(Hibernate.createBlob(inputStream));
			}
		} catch (Exception ex) {
		}

		if (shadeputybaseinfoDAO.modifyShadeputybaseinfo(bean)) {

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

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

	public IShadeputyinfoDAO getShadeputyinfoDAO() {
		return shadeputyinfoDAO;
	}

	public void setShadeputyinfoDAO(IShadeputyinfoDAO shadeputyinfoDAO) {
		this.shadeputyinfoDAO = shadeputyinfoDAO;
	}
}
