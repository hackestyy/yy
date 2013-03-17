package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademybaseinfopartybuildForm;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcademybaseinfopartybuildSaveAction extends Action {
	public AcademybaseinfopartybuildSaveAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfopartybuildForm form = (AcademybaseinfopartybuildForm) actionForm;
		Academybaseinfo bean = new Academybaseinfo();
		Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		Academybaseinfo academybaseinfo = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		form.setShai_id(shai_id);
		form.setAbi_id(abi_id);
		form.setAcadname(academybaseinfo.getAcadname());
		form.setAcadno(academybaseinfo.getAcadno());
		form.setAddress1(academybaseinfo.getAddress1());
		form.setAddress2(academybaseinfo.getAddress2());
		form.setPostcode1(academybaseinfo.getPostcode1());
		form.setPostcode2(academybaseinfo.getPostcode2());
		form.setRegisterfund(academybaseinfo.getRegisterfund());
		form.setContactperson(academybaseinfo.getContactperson());
		form.setContactphone(academybaseinfo.getContactphone());
		form.setContactfax(academybaseinfo.getContactfax());
		form.setStarlevel(academybaseinfo.getStarlevel());
		form.setIs311(academybaseinfo.getIs311());
		form.setOperationrange(academybaseinfo.getOperationrange());
		form.setStaffcount(academybaseinfo.getStaffcount());
		form.setParttimecount(academybaseinfo.getParttimecount());
		form.setChargemanname(academybaseinfo.getChargemanname());
		form.setChargemanparty(academybaseinfo.getChargemanparty());
		form.setChargemansex(academybaseinfo.getChargemansex());
		form.setChargemanscholar(academybaseinfo.getChargemanscholar());
		form.setChargemanisretire(academybaseinfo.getChargemanisretire());
		form.setChargemanidentity(academybaseinfo.getChargemanidentity());
		form.setChargemanisfulltime(academybaseinfo.getChargemanisfulltime());
		form.setChargemantelephone(academybaseinfo.getChargemantelephone());
		form.setChargemanmobile(academybaseinfo.getChargemanmobile());
		form.setChargemaninstitute(academybaseinfo.getChargemaninstitute());
		form.setChargemansocialduty(academybaseinfo.getChargemansocialduty());
		form.setChairmanname(academybaseinfo.getChairmanname());
		form.setChairmanparty(academybaseinfo.getChairmanparty());
		form.setChairmansex(academybaseinfo.getChairmansex());
		form.setChairmanscholar(academybaseinfo.getChairmanscholar());
		form.setChairmanisretire(academybaseinfo.getChairmanisretire());
		form.setChairmanidentity(academybaseinfo.getChairmanidentity());
		form.setChairmanisfulltime(academybaseinfo.getChairmanisfulltime());
		form.setChairmantelephone(academybaseinfo.getChairmantelephone());
		form.setChairmanmobile(academybaseinfo.getChairmanmobile());
		form.setChairmaninstitute(academybaseinfo.getChairmaninstitute());
		form.setChairmansocialduty(academybaseinfo.getChairmansocialduty());
		form.setSecretaryname(academybaseinfo.getSecretaryname());
		form.setSecretaryparty(academybaseinfo.getSecretaryparty());
		form.setSecretarysex(academybaseinfo.getSecretarysex());
		form.setSecretaryscholar(academybaseinfo.getSecretaryscholar());
		form.setSecretaryisretire(academybaseinfo.getSecretaryisretire());
		form.setSecretaryidentity(academybaseinfo.getSecretaryidentity());
		form.setSecretaryisfulltime(academybaseinfo.getSecretaryisfulltime());
		form.setSecretarytelephone(academybaseinfo.getSecretarytelephone());
		form.setSecretarymobile(academybaseinfo.getSecretarymobile());
		form.setSecretaryinstitute(academybaseinfo.getSecretaryinstitute());
		form.setSecretarysocialduty(academybaseinfo.getSecretarysocialduty());
		form.setChargeyear(academybaseinfo.getChargeyear());
		form.setTrusteecount(academybaseinfo.getTrusteecount());
		form.setAdmintrusteecount(academybaseinfo.getAdmintrusteecount());
		form.setRegisterdate(academybaseinfo.getRegisterdate());
		bean.setRegisterdate(DateUtil.getCalendar(form.getTempregisterdate()));
		bean.setCertifyyear(DateUtil.getCalendar(form.getTempcertifyyear()));
		bean.setStartdate(DateUtil.getCalendar(form.getTempstartdate()));

		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}
		if (academybaseinfoDAO.modifyAcademybaseinfo(bean)) {
			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
