package com.cssrc.web.action.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class SearchMemberidentityExistAction extends Action {
	public SearchMemberidentityExistAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {
			SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
			// Integer abi_id = form.getAbi_id();
			// List tAfBookentrys =
			// academysmemberrelationDAO.fetchAcademysmemberrelation(abi_id);
			// Academysmemberrelation academysmemberrelation
			// =(Academysmemberrelation) tAfBookentrys.get(0);
			// Integer smbi_id = academysmemberrelation.getSmbi_id();
			List tAfBookentrys = smemberbaseinfoDAO.findSmemberbaseinfoAll();
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				Smemberbaseinfo smemberbaseinfo = (Smemberbaseinfo) tAfBookentrys.get(i);
				if (smemberbaseinfo.getMemidentity().equals(form.getMemidentity())) {
					return actionMapping.findForward("success");
				}

			}
			return null;
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}

	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

}
