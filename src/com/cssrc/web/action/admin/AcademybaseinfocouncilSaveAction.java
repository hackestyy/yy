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
import com.cssrc.web.form.admin.AcademybaseinfocouncilForm;

public class AcademybaseinfocouncilSaveAction extends Action {
	public AcademybaseinfocouncilSaveAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfocouncilForm form = (AcademybaseinfocouncilForm) actionForm;
		Academybaseinfo bean = new Academybaseinfo();
		Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		Academybaseinfo academybaseinfo = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		bean.setShai_id(shai_id);
		bean.setAbi_id(abi_id);
		bean.setAcadname(academybaseinfo.getAcadname());
		bean.setAcadno(academybaseinfo.getAcadno());
		bean.setAddress1(academybaseinfo.getAddress1());
		bean.setAddress2(academybaseinfo.getAddress2());
		bean.setPostcode1(academybaseinfo.getPostcode1());
		bean.setPostcode2(academybaseinfo.getPostcode2());
		bean.setRegisterfund(academybaseinfo.getRegisterfund());
		bean.setContactperson(academybaseinfo.getContactperson());
		bean.setContactphone(academybaseinfo.getContactphone());
		bean.setContactfax(academybaseinfo.getContactfax());
		bean.setStarlevel(academybaseinfo.getStarlevel());
		bean.setIs311(academybaseinfo.getIs311());
		bean.setOperationrange(academybaseinfo.getOperationrange());
		bean.setStaffcount(academybaseinfo.getStaffcount());
		bean.setParttimecount(academybaseinfo.getParttimecount());
		bean.setChargemanname(academybaseinfo.getChargemanname());
		bean.setChargemanparty(academybaseinfo.getChargemanparty());
		bean.setChargemansex(academybaseinfo.getChargemansex());
		bean.setChargemanscholar(academybaseinfo.getChargemanscholar());
		bean.setChargemanisretire(academybaseinfo.getChargemanisretire());
		bean.setChargemanidentity(academybaseinfo.getChargemanidentity());
		bean.setChargemanisfulltime(academybaseinfo.getChargemanisfulltime());
		bean.setChargemantelephone(academybaseinfo.getChargemantelephone());
		bean.setChargemanmobile(academybaseinfo.getChargemanmobile());
		bean.setChargemaninstitute(academybaseinfo.getChargemaninstitute());
		bean.setChargemansocialduty(academybaseinfo.getChargemansocialduty());
		bean.setChairmanname(academybaseinfo.getChairmanname());
		bean.setChairmanparty(academybaseinfo.getChairmanparty());
		bean.setChairmansex(academybaseinfo.getChairmansex());
		bean.setChairmanscholar(academybaseinfo.getChairmanscholar());
		bean.setChairmanisretire(academybaseinfo.getChairmanisretire());
		bean.setChairmanidentity(academybaseinfo.getChairmanidentity());
		bean.setChairmanisfulltime(academybaseinfo.getChairmanisfulltime());
		bean.setChairmantelephone(academybaseinfo.getChairmantelephone());
		bean.setChairmanmobile(academybaseinfo.getChairmanmobile());
		bean.setChairmaninstitute(academybaseinfo.getChairmaninstitute());
		bean.setChairmansocialduty(academybaseinfo.getChairmansocialduty());
		bean.setSecretaryname(academybaseinfo.getSecretaryname());
		bean.setSecretaryparty(academybaseinfo.getSecretaryparty());
		bean.setSecretarysex(academybaseinfo.getSecretarysex());
		bean.setSecretaryscholar(academybaseinfo.getSecretaryscholar());
		bean.setSecretaryisretire(academybaseinfo.getSecretaryisretire());
		bean.setSecretaryidentity(academybaseinfo.getSecretaryidentity());
		bean.setSecretaryisfulltime(academybaseinfo.getSecretaryisfulltime());
		bean.setSecretarytelephone(academybaseinfo.getSecretarytelephone());
		bean.setSecretarymobile(academybaseinfo.getSecretarymobile());
		bean.setSecretaryinstitute(academybaseinfo.getSecretaryinstitute());
		bean.setSecretarysocialduty(academybaseinfo.getSecretarysocialduty());
		bean.setRegisterdate(academybaseinfo.getRegisterdate());

		bean.setCertifyyear(DateUtil.getCalendar(form.getTempcertifyyear()));

		String tempstartdate = form.getTempstartdate();

		if (tempstartdate.equals("")) {
			tempstartdate = null;
		}
		if (tempstartdate == null) {
			bean.setStartdate(null);
		} else {
			bean.setStartdate(DateUtil.getCalendar(tempstartdate));
		}

		bean.setChargeyear(form.getChargeyear());
		bean.setTrusteecount(form.getTrusteecount());
		bean.setAdmintrusteecount(form.getAdmintrusteecount());

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
