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
import com.cssrc.web.form.admin.AcademybaseinfoForm;

/**
 * <p>
 * Title: BKUpdateAction
 * </p>
 * <p>
 * Description: ÊÔÑé±³¾°×ÊÁÏ¿â(T_FD_BACKGR)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcademybaseinfoUpdateAction extends Action {
	public AcademybaseinfoUpdateAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfoForm form = (AcademybaseinfoForm) actionForm;
		Academybaseinfo bean = new Academybaseinfo();
		Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		Academybaseinfo academybaseinfo = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		form.setShai_id(shai_id);
		form.setAbi_id(abi_id);
		String tempregisterdate = form.getTempregisterdate();
		if (tempregisterdate.equals("")) {
			tempregisterdate = null;
		}
		bean.setRegisterdate(DateUtil.getCalendar(tempregisterdate));
		bean.setCertifyyear(DateUtil.getCalendar(form.getTempcertifyyear()));
		form.setRegisterdate(DateUtil.getCalendar(form.getTempregisterdate()));

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
		form.setStartdate(academybaseinfo.getStartdate());
		form.setChargeyear(academybaseinfo.getChargeyear());
		form.setTrusteecount(academybaseinfo.getTrusteecount());
		form.setAdmintrusteecount(academybaseinfo.getAdmintrusteecount());
		form.setPartytype(academybaseinfo.getPartytype());
		form.setIspartygroup(academybaseinfo.getIspartygroup());
		form.setPartyperson(academybaseinfo.getPartyperson());
		form.setPartytelephon(academybaseinfo.getPartytelephon());

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
