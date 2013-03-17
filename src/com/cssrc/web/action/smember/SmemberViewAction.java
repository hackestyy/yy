package com.cssrc.web.action.smember;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadecustom;
import com.cssrc.bean.admin.Acadecustomname;
import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.Tempsmember;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.admin.IAcadecustomDAO;
import com.cssrc.dao.admin.IAcadecustomnameDAO;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.IUserLogDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcadecustomForm;
import com.cssrc.web.form.admin.AcadecustomnameForm;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class SmemberViewAction extends Action {
	public SmemberViewAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;
	private IAcadgroupDAO acadgroupDAO;
	private IUserLogDAO userlogDAO;
	private IAcadecustomnameDAO acadecustomnameDAO;

	private IAcadecustomDAO acadecustomDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String memno = String.valueOf(httpServletRequest.getSession().getAttribute("memno"));
		List smemberbeseinfobymemno = smemberbaseinfoDAO.gainSmemberbaseinfolist(memno);
		Integer size = smemberbeseinfobymemno.size();
		List acadgrouptAfBookentrys = new ArrayList();
		List academybaseinfotAfBookentrys = new ArrayList();

		if (size == 0) {
			return actionMapping.findForward("failure1");
		} else {
			Smemberbaseinfo bymemnosmemberbeseinfo = (Smemberbaseinfo) smemberbeseinfobymemno.get(0);
			Integer smbi_id = bymemnosmemberbeseinfo.getSmbi_id();
			List academysmemberrelationbysmbi_id = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
			Academysmemberrelation bysmbi_idacademysmemberrelation = new Academysmemberrelation();
			Integer tempshai_id = null;
			for (int i = 0; i < academysmemberrelationbysmbi_id.size(); i++) {
				Tempsmember tempsmember = new Tempsmember();
				Acadgroup acadgroupbean = new Acadgroup();
				Academybaseinfo academybaseinfobean = new Academybaseinfo();
				bysmbi_idacademysmemberrelation = (Academysmemberrelation) academysmemberrelationbysmbi_id.get(i);
				Integer abi_id = bysmbi_idacademysmemberrelation.getAbi_id();

				List academybaseinfo = academybaseinfoDAO.gainAcademybaseinfo(abi_id);
				Academybaseinfo tempacademybaseinfobean = (Academybaseinfo) academybaseinfo.get(0);
				academybaseinfobean.setAbi_id(tempacademybaseinfobean.getAbi_id());
				academybaseinfobean.setShai_id(tempacademybaseinfobean.getShai_id());
				academybaseinfobean.setAcadname(tempacademybaseinfobean.getAcadname());
				academybaseinfotAfBookentrys.add(academybaseinfobean);

				tempsmember.setAbi_id(tempacademybaseinfobean.getAbi_id());
				tempsmember.setAcadname(tempacademybaseinfobean.getAcadname());
				Integer nowshai_id = tempacademybaseinfobean.getShai_id();
				if ((tempshai_id == null) || (tempshai_id.intValue() != nowshai_id.intValue())) {
					Integer shai_id = tempacademybaseinfobean.getShai_id();
					List acadgroup = acadgroupDAO.gainAcadgroup(shai_id);
					Acadgroup tempacadgroup = (Acadgroup) acadgroup.get(0);
					acadgroupbean.setShai_id(tempacadgroup.getShai_id());
					acadgroupbean.setAssoname(tempacadgroup.getAssoname());
					acadgrouptAfBookentrys.add(acadgroupbean);
				}
				UserLog bean = new UserLog();
				bean.setOperation("登陆");
				bean.setTime(Calendar.getInstance());
				bean.setUser(bymemnosmemberbeseinfo.getMemno());
				bean.setAcademy(acadgroupbean.getAssoname() + " " + academybaseinfobean.getAcadname() + " 普通会员");
				userlogDAO.saveUserLog(bean);
				// tempsmember.setShai_id(tempacadgroup.getShai_id());
				// tempsmember.setAssoname(tempacadgroup.getAssoname());
				// acadgrouptAfBookentrys.add(acadgroupbean);
				tempshai_id = nowshai_id;

			}

			bysmbi_idacademysmemberrelation = (Academysmemberrelation) academysmemberrelationbysmbi_id.get(0);
			Integer asmr_id = bysmbi_idacademysmemberrelation.getAsmr_id();
			Integer abi_id = bysmbi_idacademysmemberrelation.getAbi_id();
			SmemberbaseinfoForm form = new SmemberbaseinfoForm();
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
			} else {
				form.setTempseasuniversityenddate(null);
			}
			form.setAssoduty_f(bean.getAssoduty_f());
			form.setMemno(bean.getMemno());
			form.setPassword(bean.getPassword());
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
			// form.setUniversitystartdate(bean.getUniversitystartdate());
			// form.setUniversityenddate(bean.getUniversityenddate());
			form.setSeasuniversity(bean.getSeasuniversity());
			form.setSeasuniversityspec(bean.getSeasuniversityspec());
			// form.setSeasuniversityenddate(bean.getSeasuniversityenddate());
			// form.setSeasuniversitystartdate(bean.getSeasuniversitystartdate());
			form.setUseremail(bean.getUseremail());
			form.setUsermobile(bean.getUsermobile());
			form.setIsemployee(bean.getIsemployee());

			// try {
			// org.apache.commons.beanutils.BeanUtils.copyProperties(form,
			// bean);
			// } catch (Exception ex) {
			// return actionMapping.findForward("failure");
			// }

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
			Acadecustom acadecustombean = new Acadecustom();
			AcadecustomForm acadecustomform = new AcadecustomForm();
			// acadecustombean =
			// acadecustomDAO.getAcadecustom(relationbean.getSmbi_id());
			acadecustombean = acadecustomDAO.getAcadecustom(bean.getSmbi_id());
			if (!(acadecustombean == null)) {
				try {
					org.apache.commons.beanutils.BeanUtils.copyProperties(acadecustomform, acadecustombean);
				} catch (Exception e) {
					return actionMapping.findForward("failure");
				}
			}

			httpServletRequest.setAttribute("acadecustomform", acadecustomform);
			httpServletRequest.setAttribute("acadecustomnameform", acadecustomnameform);
			httpServletRequest.setAttribute("state", state);
			httpServletRequest.setAttribute("state1", state1);
			httpServletRequest.setAttribute("state2", state2);
			httpServletRequest.setAttribute("state3", state3);
			httpServletRequest.setAttribute("state4", state4);
			httpServletRequest.setAttribute("state5", state5);
			httpServletRequest.setAttribute("state6", state6);

			httpServletRequest.setAttribute("smemberbaseinfoForm", form);
			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			httpServletRequest.getSession().setAttribute("asmr_id", asmr_id);
			httpServletRequest.getSession().setAttribute("abi_id", abi_id);
			httpServletRequest.getSession().setAttribute("memname", bean.getMemname());
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

			httpServletRequest.getSession().setAttribute("ACADGROUPLIST", acadgrouptAfBookentrys);
			httpServletRequest.getSession().setAttribute("ACADEMYBASEINFOLIST", academybaseinfotAfBookentrys);

			return actionMapping.findForward("success");
		}
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

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

	public IAcadecustomDAO getAcadecustomDAO() {
		return acadecustomDAO;
	}

	public void setAcadecustomDAO(IAcadecustomDAO acadecustomDAO) {
		this.acadecustomDAO = acadecustomDAO;
	}

	public IAcadecustomnameDAO getAcadecustomnameDAO() {
		return acadecustomnameDAO;
	}

	public void setAcadecustomnameDAO(IAcadecustomnameDAO acadecustomnameDAO) {
		this.acadecustomnameDAO = acadecustomnameDAO;
	}

}
