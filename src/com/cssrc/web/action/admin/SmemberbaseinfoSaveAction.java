package com.cssrc.web.action.admin;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.Acadecustom;
import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.admin.IAcadecustomDAO;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.IUserLogDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

/**
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class SmemberbaseinfoSaveAction extends Action {
	public SmemberbaseinfoSaveAction() {
	}

	private IAcadecustomDAO acadecustomDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	private IAcademybaseinfoDAO academybaseinfoDAO;

	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// TODO 自动生成会员的帐号和密码，供参考
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("smemberabi_id");
		String acadname = (String) httpServletRequest.getSession().getAttribute("acadname");
		String assoname = (String) httpServletRequest.getSession().getAttribute("academybaseinfoassoname");
		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		form.setAbi_id(abi_id);
		Integer asmr_id = (Integer) httpServletRequest.getSession().getAttribute("asmr_id");
		form.setAsmr_id(asmr_id);
		Acadecustom acadecustom = new Acadecustom();
		// form.setAcadgroup_no(form.getAcadgroup_no()+1);
		Smemberbaseinfo bean = new Smemberbaseinfo();
		String tempmembirthday = form.getTempmembirthday();
		String tempuniversitystartdate = form.getTempuniversitystartdate();
		String tempuniversityenddate = form.getTempuniversityenddate();
		String tempseasuniversitystartdate = form.getTempseasuniversitystartdate();
		String tempseasuniversityenddate = form.getTempseasuniversityenddate();
		String tempjoindate = form.getTempjoindate();
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
		if (tempjoindate.equals("")) {
			tempjoindate = null;
		}
		if (tempmembirthday == null) {
			bean.setMembirthday(null);
		} else {
			bean.setMembirthday(DateUtil.getCalendar(tempmembirthday));
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
		List listacademybaseinfo = academybaseinfoDAO.gainAcademybaseinfo(abi_id);
		Academybaseinfo byabi_idacademybaseinfo = (Academybaseinfo) listacademybaseinfo.get(0);

		String rnum = smemberbaseinfoDAO.getRnum().toString();

		if (rnum.length() <= 6) {
			for (int i = rnum.length(); i < 6; i++) {
				rnum = "0" + rnum;
			}

		}
		/* TODO JackyHo 自动生成帐号 */
		String memno = byabi_idacademybaseinfo.getAcadno() + rnum;
		form.setMemno(memno);

		acadecustom.setAbi_id(abi_id);
		if (!(form.getAbino() == null)) {
			acadecustom.setAbino(form.getAbino());
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
		bean.setMemno(form.getMemno());
		bean.setPassword(form.getMemno());
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
		bean.setMemdegree(form.getMemdegree());
		bean.setMemdept(form.getMemdept());
		bean.setMemduty(form.getMemduty());
		bean.setMemidentity(form.getMemidentity());
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
		bean.setMemspeciality(form.getMemspeciality());
		bean.setMemskill(form.getMemskill());
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
		// / form.setMembirthday(DateUtil.getCalendar(tempmembirthday));
		// form.setUniversitystartdate(DateUtil.getCalendar(tempuniversitystartdate));
		// //form.setUniversityenddate(DateUtil.getCalendar(tempuniversityenddate));
		// form.setSeasuniversitystartdate(DateUtil.getCalendar(tempseasuniversitystartdate));
		// form.setSeasuniversityenddate(DateUtil.getCalendar(tempseasuniversityenddate));
		// form.setJoindate(DateUtil.getCalendar(tempjoindate));

		// bean.setMembirthday(form.getMembirthday());
		// bean.setUniversitystartdate(form.getUniversitystartdate());
		// bean.setUniversityenddate(form.getUniversityenddate());
		// bean.setSeasuniversitystartdate(form.getSeasuniversitystartdate());
		// bean.setSeasuniversityenddate(form.getSeasuniversityenddate());

		Academysmemberrelation relationbean = new Academysmemberrelation();

		// relationbean.setJoindate(DateUtil.getCalendar(tempjoindate).getTime());
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
		// relationbean.setAcademyduty12(form.getAcademyduty12());
		// relationbean.setAcademyduty13(form.getAcademyduty13());
		// relationbean.setJoindate(form.getJoindate().getTime());

		try {
			// SmeberbaseinfoCompressAction compress = new
			// SmeberbaseinfoCompressAction();
			int memphotosize = form.getMemphoto().getFileSize();
			if (memphotosize > 250000) {
				return actionMapping.findForward("sizefailure");
			}
			InputStream inputStream = form.getMemphoto().getInputStream();
			bean.setMemphoto(Hibernate.createBlob(inputStream));
			// org.apache.commons.beanutils.BeanUtils.copyProperties(bean,form);
		} catch (Exception ex) {
		}

		// ////////////////////////////////////////////////////mabao
		// add.toString().substring(0,7)
		String memname = form.getMemname();
		String memsex = form.getMemsex();
		String membirthday = form.getTempmembirthday();
		String memdegree = form.getMemdegree();
		String memscholar = form.getMemscholar();
		httpServletRequest.getSession().setAttribute("memname", memname);
		httpServletRequest.getSession().setAttribute("memsex", memsex);
		httpServletRequest.getSession().setAttribute("membirthday", membirthday);
		httpServletRequest.getSession().setAttribute("memdegree", memdegree);
		httpServletRequest.getSession().setAttribute("memscholar", memscholar);
		List listsmemberbaseinfo = smemberbaseinfoDAO.gainSmemberbaseinfo(memname, memsex, membirthday, memdegree, memscholar);

		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		UserLog logbean = new UserLog();
		logbean.setTime(Calendar.getInstance());
		logbean.setUser(user.getUseraccount());
		if (user.getUserrole().equals("SystemAdmin")) {
			logbean.setAcademy("系统管理员");
			logbean.setOperation("添加 " + acadname + " " + assoname + " 普通会员" + bean.getMemno());
		} else {
			logbean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + " 学会管理员");
			logbean.setOperation("添加 " + user.getUseracademic() + " " + user.getUserassociation() + " 普通会员 " + bean.getMemno());
		}

		if (listsmemberbaseinfo.size() == 0) {
			if (smemberbaseinfoDAO.saveSmemberbaseinfo(bean)) {
				if (!(bean.getSmbi_id() == null)) {
					acadecustom.setSmbi_id(bean.getSmbi_id());
				}
				if (acadecustomDAO.saveAcadecustom(acadecustom)) {
					relationbean.setSmbi_id(bean.getSmbi_id());
					relationbean.setIsdelete("0");
					if (!academysmemberrelationDAO.saveAcademysmemberrelation(relationbean)) {
						return actionMapping.findForward("smiderrorAdd");
					}
				}
			}
			httpServletRequest.setAttribute("asmr_id", relationbean.getAsmr_id());
			httpServletRequest.setAttribute("smemberbaseinfoForm", form);
			httpServletRequest.getSession().setAttribute("smbi_id", bean.getSmbi_id());
			httpServletRequest.getSession().setAttribute("smemberabi_id", abi_id);
			userlogDAO.saveUserLog(logbean);
			return actionMapping.findForward("success");
		} else {
			for (int i = 0; i < listsmemberbaseinfo.size(); i++) {// listsmemberbaseinfo会出现大于1的情况吗?
				Smemberbaseinfo smemberbaseinfo = (Smemberbaseinfo) listsmemberbaseinfo.get(i);
				Integer smbiid = smemberbaseinfo.getSmbi_id();
				List listacademysmemberrelation = academysmemberrelationDAO.gainAcademysmemberrelation(smbiid);
				for (int j = 0; j < listacademysmemberrelation.size(); j++) {
					Academysmemberrelation academysmemberrelation = (Academysmemberrelation) listacademysmemberrelation.get(j);
					Integer abiid = academysmemberrelation.getAbi_id();
					List listacadeemybaseinfo = academybaseinfoDAO.findAcademybaseinfo(abiid);
					Academybaseinfo academybaseinfo = (Academybaseinfo) listacadeemybaseinfo.get(0);
					String acadName = academybaseinfo.getAcadname();

					httpServletRequest.setAttribute("asmr_id", relationbean.getAsmr_id());
					httpServletRequest.setAttribute("smemberbaseinfoForm", form);
					httpServletRequest.getSession().setAttribute("smbi_id", bean.getSmbi_id());
					httpServletRequest.getSession().setAttribute("memidentity", form.getMemidentity());
					httpServletRequest.getSession().setAttribute("smemberabi_id", abi_id);
					if (acadName.equals(acadname)) {
						// 在同一个学会已经注册过一次的情形
						userlogDAO.saveUserLog(logbean);
						return actionMapping.findForward("success1");
					}
				}
				if (listsmemberbaseinfo.size() == 1) {
					userlogDAO.saveUserLog(logbean);
					return actionMapping.findForward("success2");
				}
				if (i < listsmemberbaseinfo.size() - 1) {
					continue;
				}

			}
			return null;
		}

	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
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

}
