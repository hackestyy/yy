package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.bean.admin.Gmemberbaseinfo;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IGmemberbaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.GmemberbaseinfoForm;

public class GmemberbaseinfoUpdateAction extends Action {
	public GmemberbaseinfoUpdateAction() {
	}

	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberbaseinfoForm form = (GmemberbaseinfoForm) actionForm;
		Gmemberbaseinfo bean = new Gmemberbaseinfo();
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("gmemberabi_id");
		Integer gmbi_id = (Integer) httpServletRequest.getSession().getAttribute("gmbi_id");
		form.setGmbi_id(gmbi_id);
		form.setAbi_id(abi_id);
		Integer agmr_id = (Integer) httpServletRequest.getSession().getAttribute("agmr_id");
		form.setAgmr_id(agmr_id);

		String tempjoindate = form.getTempjoindate();
		if (tempjoindate.equals("")) {
			tempjoindate = null;
		}

		bean.setContactaddress(form.getContactaddress());
		bean.setContactdepartment(form.getContactdepartment());
		bean.setContactduty(form.getContactduty());
		bean.setContactemail(form.getContactemail());
		bean.setContactfax(form.getContactfax());
		bean.setContacthigherstaffcount(form.getContacthigherstaffcount());
		bean.setContactname(form.getContactname());
		bean.setContactoperationrange(form.getContactoperationrange());
		bean.setContactperson(form.getContactperson());
		bean.setContactpostcode(form.getContactpostcode());
		bean.setContactrank(form.getContactrank());
		bean.setContactstaffcount(form.getContactstaffcount());
		bean.setContacttelephone(form.getContacttelephone());
		bean.setContacturl(form.getContacturl());
		bean.setGmbi_id(form.getGmbi_id());
		bean.setInstitutecode(form.getInstitutecode());
		bean.setInstitutename(form.getInstitutename());
		bean.setInstitutetype(form.getInstitutetype());
		bean.setMemno(form.getMemno());

		form.setJoindate(DateUtil.getCalendar(form.getTempjoindate()));

		Academygmemberrelation relationbean = new Academygmemberrelation();
		relationbean.setAbi_id(form.getAbi_id());
		relationbean.setAgmr_id(form.getAgmr_id());
		relationbean.setDeletedate(form.getDeletedate());
		relationbean.setGmbi_id(form.getGmbi_id());
		relationbean.setIsannualregister(form.getIsannualregister());
		relationbean.setIsdelete(form.getIsdelete());
		relationbean.setJoindate(form.getJoindate());
		relationbean.setMemtype(form.getMemtype());

		if (gmemberbaseinfoDAO.modifyGmemberbaseinfo(bean)) {
			relationbean.setGmbi_id(bean.getGmbi_id());
			relationbean.setIsdelete("0");
			if (!academygmemberrelationDAO.modifyAcademygmemberrelation(relationbean)) {
				return actionMapping.findForward("smiderrorAdd");
			}
		}

		return actionMapping.findForward("success");
	}

	public IGmemberbaseinfoDAO getGmemberbaseinfoDAO() {
		return gmemberbaseinfoDAO;
	}

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public void setGmemberbaseinfoDAO(IGmemberbaseinfoDAO gmemberbaseinfoDAO) {
		this.gmemberbaseinfoDAO = gmemberbaseinfoDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}

}
