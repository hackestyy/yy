package com.cssrc.web.action.admin;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

/**
 * <p>
 * Title:ObjParaModifyAction
 * </p>
 * <p>
 * Description:ÊÔ¼þ²ÎÊý(T_OBJ_PARA)
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
public class SmemberbaseinfopreviewModifyAction extends Action {
	public SmemberbaseinfopreviewModifyAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberbaseinfoForm form = new SmemberbaseinfoForm();
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		Academysmemberrelation relationbean = academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
		Smemberbaseinfo bean = smemberbaseinfoDAO.getSmemberbaseinfo(relationbean.getSmbi_id());

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
		form.setTempmembirthday(DateUtil.getCalendarString(bean.getMembirthday(), "yyyy-MM-dd"));
		form.setTempuniversitystartdate(DateUtil.getCalendarString(bean.getUniversitystartdate(), "yyyy-MM-dd"));
		form.setTempuniversityenddate(DateUtil.getCalendarString(bean.getUniversityenddate(), "yyyy-MM-dd"));
		form.setTempseasuniversitystartdate(DateUtil.getCalendarString(bean.getSeasuniversitystartdate(), "yyyy-MM-dd"));
		form.setTempseasuniversityenddate(DateUtil.getCalendarString(bean.getSeasuniversityenddate(), "yyyy-MM-dd"));
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
		form.setMemdept(bean.getMemdept());
		form.setMemidentity(bean.getMemidentity());
		form.setMeminstitute(bean.getMeminstitute());
		form.setMemname(bean.getMemname());
		form.setMemnation_f(bean.getMemnation_f());
		form.setMemnation_s(bean.getMemnation_s());
		form.setMemnationality_f(bean.getMemnationality_f());
		form.setMemnationality_s(bean.getMemnationality_s());
		form.setMemparty_f(bean.getMemparty_f());
		form.setMemparty_s(bean.getMemparty_s());
		form.setMemrank_f(bean.getMemrank_f());
		form.setMemscholar(bean.getMemscholar());
		form.setMemsex(bean.getMemsex());
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
		form.setUniversity(bean.getUniversity());
		form.setUniversityspec(bean.getUniversityspec());
		form.setUniversitystartdate(bean.getUniversitystartdate());
		form.setUseremail(bean.getUseremail());
		form.setUsermobile(bean.getUsermobile());

		form.setTempjoindate(DateUtil.getCalendarString(form.getJoindate(), "yyyy-MM-dd"));
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
		httpServletRequest.getSession().setAttribute("smemberbaseinfopreview", bean);
		httpServletRequest.getSession().setAttribute("smbi_id", relationbean.getSmbi_id());
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

}
