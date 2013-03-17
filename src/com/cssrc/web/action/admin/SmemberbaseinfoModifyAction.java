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
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcadecustomDAO;
import com.cssrc.dao.admin.IAcadecustomnameDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcadecustomForm;
import com.cssrc.web.form.admin.AcadecustomnameForm;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

/**
 * <p>
 * Title:ObjParaModifyAction
 * </p>
 * <p>
 * Description:试件参数(T_OBJ_PARA)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author xuejian
 * @version 1.0
 */
public class SmemberbaseinfoModifyAction extends Action {
	public SmemberbaseinfoModifyAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private IAcadecustomnameDAO acadecustomnameDAO;

	private IAcadecustomDAO acadecustomDAO;

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// SmemberbaseinfoForm form1 = (SmemberbaseinfoForm)actionForm;
		SmemberbaseinfoForm form = new SmemberbaseinfoForm();
		Acadecustom acadecustombean = new Acadecustom();
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("smemberabi_id");
		Academysmemberrelation relationbean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
		Smemberbaseinfo bean = smemberbaseinfoDAO.getSmemberbaseinfo(relationbean.getSmbi_id());

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
		form.setMemidentity(bean.getMemidentity());
		// String memidentity = form1.getMemidentity();
		// List smemberbeseinfobymemidentity =
		// smemberbaseinfoDAO.gainSmemberbaseinfo(memidentity);
		// Smemberbaseinfo bymemidentitysmemberbeseinfo =
		// (Smemberbaseinfo)smemberbeseinfobymemidentity.get(0);

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
		form.setIsemployee(bean.getIsemployee());
		form.setMemdegree(bean.getMemdegree());
		form.setMemdept(bean.getMemdept());
		form.setMemduty(bean.getMemduty());
		form.setMemno(bean.getMemno());
		form.setMeminstitute(bean.getMeminstitute());
		form.setMemname(bean.getMemname());
		form.setMemnation_f(bean.getMemnation_f());
		form.setMemnation_s(bean.getMemnation_s());
		form.setMemnationality_f(bean.getMemnationality_f());
		form.setMemnationality_s(bean.getMemnationality_s());
		if (!bean.getMemparty_s().equals("民主党派")) {
			form.setMemparty_f("");
		} else {
			form.setMemparty_f(bean.getMemparty_f());
		}
		form.setMemparty_s(bean.getMemparty_s());
		form.setMemrank_f(bean.getMemrank_f());
		form.setMemrank_s(bean.getMemrank_s());
		form.setMemscholar(bean.getMemscholar());
		form.setMemsex(bean.getMemsex());
		form.setMemspeciality(bean.getMemspeciality());
		form.setMemskill(bean.getMemskill());
		form.setNationduty_f(bean.getNationduty_f());
		form.setNationduty_s(bean.getNationduty_s());
		form.setSeasuniversity(bean.getSeasuniversity());
		form.setPassword(bean.getPassword());

		// form.setSeasuniversitystartdate(bean.getSeasuniversitystartdate());
		// form.setSeasuniversityenddate(bean.getSeasuniversityenddate());
		// form.setUniversityenddate(bean.getUniversityenddate());
		// form.setUniversitystartdate(bean.getUniversitystartdate());

		form.setSeasuniversityspec(bean.getSeasuniversityspec());

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

		form.setUseremail(bean.getUseremail());
		form.setUsermobile(bean.getUsermobile());
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

		// try {
		// Blob imageblob = (Blob)bean.getMemphoto() ;
		// InputStream input = imageblob.getBinaryStream();

		// FormFile images = (FormFile)input;
		// form.setMemphoto(images);
		// org.apache.commons.beanutils.BeanUtils.copyProperties(form,
		// bean);
		// } catch (Exception ex) {
		// return actionMapping.findForward("failure");
		// }

		// httpServletRequest.getSession().setAttribute("acadname",
		// form.getAcadname());

		List acadecustomnamelist = new ArrayList();
		List acadecustomlist = new ArrayList();
		Acadecustomname acadecustomnamebean = new Acadecustomname();
		acadecustomnamelist = acadecustomnameDAO.findAcadecustomname(relationbean.getAbi_id());
		AcadecustomnameForm acadecustomnameform = new AcadecustomnameForm();
		String state = "N";
		String state1 = "N";
		String state2 = "N";
		String state3 = "N";
		String state4 = "N";
		String state5 = "N";
		String state6 = "N";
		if (!(acadecustomnamelist == null)) {
			for (int i = 0; i < acadecustomnamelist.size(); i++) {
				acadecustomnamebean = (Acadecustomname) acadecustomnamelist.get(i);
				if (acadecustomnamebean.getAbi_id().equals(relationbean.getAbi_id())) {
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
		}

		// 获取自定义的具体内容
		AcadecustomForm acadecustomform = new AcadecustomForm();
		// acadecustombean =
		// acadecustomDAO.getAcadecustom(relationbean.getSmbi_id());
		int customid = 0;
		form.setCustomid(customid);
		List customlist = acadecustomDAO.findAcadecustom(relationbean.getSmbi_id());
		for (int i = 0; i < customlist.size(); i++) {

			Acadecustom acbean = (Acadecustom) customlist.get(i);
			if (acbean.getAbi_id().equals(abi_id)) {
				acadecustombean = acbean;
				customid = 1;
				form.setCustomid(customid);
			}
		}
		if (!(customlist.size() == 0)) {
			try {
				form.setAbino(acadecustombean.getAbino());
				form.setContent1(acadecustombean.getContent1());
				form.setContent2(acadecustombean.getContent2());
				form.setContent3(acadecustombean.getContent3());
				form.setContent4(acadecustombean.getContent4());
				form.setContent5(acadecustombean.getContent5());
				form.setContent6(acadecustombean.getContent6());
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
		httpServletRequest.getSession().setAttribute("smbi_id", relationbean.getSmbi_id());
		httpServletRequest.getSession().setAttribute("customno", acadecustombean.getNo());
		httpServletRequest.getSession().setAttribute("asmr_id", asmr_id);
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
