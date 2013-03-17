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
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.ShadeputybaseinfoForm;

public class ShadeputybaseinfoSaveAction extends Action {
	public ShadeputybaseinfoSaveAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String assoduty_s = String.valueOf(httpServletRequest.getSession().getAttribute("assoduty_s"));

		ShadeputybaseinfoForm form = (ShadeputybaseinfoForm) actionForm;
		Shadeputybaseinfo bean = new Shadeputybaseinfo();
		form.setAssoduty_s(assoduty_s);
		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");
		form.setShadbi_id(shadbi_id);

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
		if (tempdeputybirthday == null) {
			bean.setDeputybirthday(null);
		} else {
			bean.setDeputybirthday(DateUtil.getCalendar(tempdeputybirthday));
		}
		if (tempuniversitystartdate == null) {
			bean.setUniversitystartdate(null);
		} else {
			bean.setUniversitystartdate(DateUtil.getCalendar(tempuniversitystartdate));
		}
		if (tempuniversityenddate == null) {
			bean.setUniversityenddate(null);
		} else {
			bean.setUniversityenddate(DateUtil.getCalendar(tempuniversityenddate));
		}
		if (tempseasuniversitystartdate == null) {
			bean.setSeasuniversitystartdate(null);
		} else {
			bean.setSeasuniversitystartdate(DateUtil.getCalendar(tempseasuniversitystartdate));
		}
		if (tempseasuniversityenddate == null) {
			bean.setSeasuniversityenddate(null);
		} else {
			bean.setSeasuniversityenddate(DateUtil.getCalendar(tempseasuniversityenddate));
		}

		String rnum = null;
		try {
			rnum = shadeputybaseinfoDAO.getRnum().toString();
		} catch (Exception e) {
		}
		if (rnum == null) {
			rnum = "";
		}

		if (rnum.length() <= 5) {
			for (int i = rnum.length(); i < 5; i++) {
				rnum = "0" + rnum;
			}
		}

		String deputyno = "DBWY" + rnum;

		bean.setShadbi_id(form.getShadbi_id());
		bean.setDeputyno(deputyno);
		bean.setDeputyname(form.getDeputyname());
		bean.setDeputyidentity(form.getDeputyidentity());
		bean.setDeputysex(form.getDeputysex());
		bean.setDeputynation_f(form.getDeputynation_f());
		bean.setDeputynation_s(form.getDeputynation_s());
		bean.setDeputyparty_f(form.getDeputyparty_f());
		bean.setDeputyparty_s(form.getDeputyparty_s());
		bean.setDeputynationality_f(form.getDeputynationality_f());
		bean.setDeputynationality_s(form.getDeputynationality_s());
		bean.setDeputydegree(form.getDeputydegree());
		bean.setDeputyscholar(form.getDeputyscholar());
		bean.setDeputyrank_s(form.getDeputyrank_s());
		bean.setDeputyrank_f(form.getDeputyrank_f());
		bean.setDeputyinstitute(form.getDeputyinstitute());
		bean.setDeputydept(form.getDeputydept());
		bean.setIsemployee(form.getIsemployee());
		bean.setMemduty(form.getMemduty());
		bean.setMemskill(form.getMemskill());
		bean.setMemspeciality(form.getMemspeciality());
		bean.setForeignlanguage(form.getForeignlanguage());
		bean.setAssoduty_f(form.getAssoduty_f());
		bean.setAssoduty_s(form.getAssoduty_s());
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
		bean.setInterduty_f(form.getInterduty_f());
		bean.setInterduty_s(form.getInterduty_s());
		bean.setNationduty_f(form.getNationduty_f());
		bean.setNationduty_s(form.getNationduty_s());
		bean.setInstituteaddress(form.getInstituteaddress());
		bean.setInstitutepostcode(form.getInstitutepostcode());
		bean.setInstitutetelephone(form.getInstitutetelephone());
		bean.setHomeaddress(form.getHomeaddress());
		bean.setHomepostcode(form.getHomepostcode());
		bean.setHometelephone(form.getHometelephone());
		bean.setUseremail(form.getUseremail());
		bean.setUsermobile(form.getUsermobile());
		bean.setUniversity(form.getUniversity());
		bean.setUniversityspec(form.getUniversityspec());

		bean.setSeasuniversity(form.getSeasuniversity());
		bean.setSeasuniversityspec(form.getSeasuniversityspec());

		try {
			// SmeberbaseinfoCompressAction compress = new
			// SmeberbaseinfoCompressAction();
			int memphotosize = form.getDeputyphoto().getFileSize();
			if (memphotosize > 250000) {
				return actionMapping.findForward("sizefailure");
			}
			InputStream inputStream = form.getDeputyphoto().getInputStream();
			bean.setDeputyphoto(Hibernate.createBlob(inputStream));
			// org.apache.commons.beanutils.BeanUtils.copyProperties(bean,form);

			// 校验是否重复录入
			String deputyname = form.getDeputyname();
			String deputysex = form.getDeputysex();
			String deputybirthday = form.getTempdeputybirthday();
			String deputydegree = form.getDeputydegree();
			String deputyscholar = form.getDeputyscholar();
			// httpServletRequest.getSession().setAttribute("deputyname",
			// deputyname);
			// httpServletRequest.getSession().setAttribute("deputysex",
			// deputysex);
			// httpServletRequest.getSession().setAttribute("deputybirthday",
			// deputybirthday);
			// httpServletRequest.getSession().setAttribute("deputydegree",
			// deputydegree);
			// httpServletRequest.getSession().setAttribute("deputyscholar",
			// deputyscholar);
			List listdeputybaseinfo = shadeputybaseinfoDAO.gainDeputybaseinfo(deputyname, deputysex, deputybirthday, deputydegree, deputyscholar);
			// 第一次录入的情形
			if (listdeputybaseinfo.size() == 0) {
				if (!shadeputybaseinfoDAO.saveShadeputybaseinfo(bean)) {
					return actionMapping.findForward("smiderrorAdd");
				}
				httpServletRequest.setAttribute("shadeputybaseinfoForm", form);
				httpServletRequest.getSession().setAttribute("assoduty_s", assoduty_s);
				httpServletRequest.getSession().setAttribute("shadbi_id", bean.getShadbi_id());
				httpServletRequest.getSession().setAttribute("deputyidentity", bean.getDeputyidentity());
				return actionMapping.findForward("success");
			} else {
				return actionMapping.findForward("exist");
			}

		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
