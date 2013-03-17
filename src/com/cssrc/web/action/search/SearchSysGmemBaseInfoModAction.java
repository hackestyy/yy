package com.cssrc.web.action.search;

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

public class SearchSysGmemBaseInfoModAction extends Action {

	public SearchSysGmemBaseInfoModAction() {

	}

	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		GmemberbaseinfoForm form = new GmemberbaseinfoForm();
		// Integer agmr_id = (Integer)
		// httpServletRequest.getSession().getAttribute("agmr_id");
		// if (agmr_id == null)
		// {
		Integer agmr_id = Integer.valueOf(httpServletRequest.getParameter("agmr_id"));
		// }
		Academygmemberrelation relationbean = academygmemberrelationDAO.getAcademygmemberrelation(agmr_id);
		Gmemberbaseinfo bean = gmemberbaseinfoDAO.getGmemberbaseinfo(relationbean.getGmbi_id());

		form.setContactaddress(bean.getContactaddress());
		form.setContactdepartment(bean.getContactdepartment());
		form.setContactduty(bean.getContactduty());
		form.setContactemail(bean.getContactemail());
		form.setContactfax(bean.getContactfax());
		form.setContacthigherstaffcount(bean.getContacthigherstaffcount());
		form.setContactname(bean.getContactname());
		form.setContactoperationrange(bean.getContactoperationrange());
		form.setContactperson(bean.getContactperson());
		form.setContactpostcode(bean.getContactpostcode());
		form.setContactrank(bean.getContactrank());
		form.setContactstaffcount(bean.getContactstaffcount());
		form.setContacttelephone(bean.getContacttelephone());
		form.setContacturl(bean.getContacturl());
		form.setGmbi_id(bean.getGmbi_id());
		form.setInstitutecode(bean.getInstitutecode());
		form.setInstitutename(bean.getInstitutename());
		form.setInstitutetype(bean.getInstitutetype());
		form.setMemno(bean.getMemno());

		form.setAbi_id(relationbean.getAbi_id());
		form.setAgmr_id(relationbean.getAgmr_id());
		form.setDeletedate(relationbean.getDeletedate());
		form.setGmbi_id(relationbean.getGmbi_id());
		form.setIsannualregister(relationbean.getIsannualregister());
		form.setIsdelete(relationbean.getIsdelete());
		form.setJoindate(relationbean.getJoindate());
		form.setMemtype(relationbean.getMemtype());
		form.setTempjoindate(DateUtil.getCalendarString(form.getJoindate(), "yyyy-MM-dd"));

		httpServletRequest.setAttribute("gmemberbaseinfoForm", form);
		httpServletRequest.getSession().setAttribute("gmbi_id", relationbean.getGmbi_id());
		httpServletRequest.getSession().setAttribute("agmr_id", agmr_id);
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
