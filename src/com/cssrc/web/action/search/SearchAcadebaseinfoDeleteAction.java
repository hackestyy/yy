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
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;

public class SearchAcadebaseinfoDeleteAction extends Action {
	public SearchAcadebaseinfoDeleteAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer smbi_id = Integer.valueOf(httpServletRequest.getParameter("smbi_id"));
		Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
		List tAfBookentrys = new ArrayList();
		tAfBookentrys = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
		try {
			List abiid_list = academybaseinfoDAO.getAbi_id(shai_id);
			// 学会群范围查询结果删除较麻烦，需考虑一人参加同一个学会群下多个学会和参加多个群下的多个学会，用到了双层循环
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				Academysmemberrelation academysmemberrelationbean = (Academysmemberrelation) tAfBookentrys.get(i);
				Integer abiid_temp = academysmemberrelationbean.getAbi_id();
				for (int j = 0; j < abiid_list.size(); j++) {
					Integer temp_abiid = (Integer) abiid_list.get(j);
					if (abiid_temp.intValue() == temp_abiid.intValue()) {
						academysmemberrelationbean.setIsdelete("1");
						academysmemberrelationDAO.modifyAcademysmemberrelation(academysmemberrelationbean);
					}
				}
			}

			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
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
