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
import com.cssrc.web.form.admin.AcademybaseinfoprincipalForm;

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
public class AcademybaseinfoprincipalUpdateAction extends Action {
	public AcademybaseinfoprincipalUpdateAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfoprincipalForm form = (AcademybaseinfoprincipalForm) actionForm;
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
		form.setRegisterdate(academybaseinfo.getRegisterdate());
		form.setStartdate(academybaseinfo.getStartdate());
		form.setChargeyear(academybaseinfo.getChargeyear());
		form.setTrusteecount(academybaseinfo.getTrusteecount());
		form.setAdmintrusteecount(academybaseinfo.getAdmintrusteecount());
		form.setPartytype(academybaseinfo.getPartytype());
		form.setIspartygroup(academybaseinfo.getIspartygroup());
		form.setPartyperson(academybaseinfo.getPartyperson());
		form.setPartytelephon(academybaseinfo.getPartytelephon());

		bean.setRegisterdate(DateUtil.getCalendar(form.getTempregisterdate()));
		bean.setCertifyyear(DateUtil.getCalendar(form.getTempcertifyyear()));

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
