package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;

public class SearchDBWYBaseInfoDelAction1 extends Action {

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String memno = httpServletRequest.getSession().getAttribute("memno").toString();
		List smbi_idList = smemberbaseinfoDAO.findsmbi_id_Bymemno(memno);
		Integer smbi_id = (Integer) smbi_idList.get(0);

		List tAfBookentrys = new ArrayList();
		tAfBookentrys = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
		try {
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				Academysmemberrelation academysmemberrelationbean = (Academysmemberrelation) tAfBookentrys.get(i);
				academysmemberrelationbean.setIsdelete("1");
				academysmemberrelationDAO.modifyAcademysmemberrelation(academysmemberrelationbean);
			}

			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			// httpServletRequest.getSession().setAttribute("smemberabi_id",bean.getAbi_id());
			String dbwy = httpServletRequest.getParameter("dbwy");
			if (dbwy != null) {
				if (dbwy.equals("wy")) {
					return actionMapping.findForward("success_wy");
				}
				if (dbwy.equals("cw")) {
					return actionMapping.findForward("success_cw");
				} else {
					return actionMapping.findForward("success");
				}
			} else {
				return actionMapping.findForward("success");
			}
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
