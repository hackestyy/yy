package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IGmemberbaseinfoDAO;
import com.cssrc.dao.admin.IGmemberpatentinfoDAO;
import com.cssrc.dao.admin.IGmemberresearchproductionDAO;

public class GmemberbaseinfoRealdelAction extends Action {

	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IGmemberpatentinfoDAO gmemberpatentinfoDAO;
	private IGmemberresearchproductionDAO gmemberresearchproductionDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer agmr_id = Integer.valueOf(httpServletRequest.getParameter("agmr_id"));
		String acadname = (String) httpServletRequest.getSession().getAttribute("acadname");
		String assoname = (String) httpServletRequest.getSession().getAttribute("academybaseinfoassoname");
		UserLog logbean = new UserLog();
		try {
			Academygmemberrelation bean = (Academygmemberrelation) academygmemberrelationDAO.getAcademygmemberrelation(agmr_id);
			Integer gmbi_id = bean.getGmbi_id();

			// 关系表
			List tAfBookentrys = new ArrayList();
			tAfBookentrys = academygmemberrelationDAO.findAcademygmemberrelation(agmr_id);
			if (tAfBookentrys.size() == 1) {
				academygmemberrelationDAO.removeAcademygmemberrelation(bean);

				// 基本信息

				List list1 = gmemberbaseinfoDAO.findGmemberbaseinfo(gmbi_id);
				if (!gmemberbaseinfoDAO.delete(list1)) {
					actionMapping.findForward("failure");
				}
				// 主要产品
				List list2 = gmemberpatentinfoDAO.findGmemberpatentinfo(gmbi_id);
				if (!gmemberpatentinfoDAO.delete(list2)) {
					actionMapping.findForward("failure");
				}
				// 专利 标准
				List list3 = gmemberresearchproductionDAO.findGmemberresearchproduction(gmbi_id);
				if (!gmemberresearchproductionDAO.delete(list3)) {
					actionMapping.findForward("failure");
				}

			} else {
				if (!academygmemberrelationDAO.removeAcademygmemberrelation(bean)) {
					actionMapping.findForward("failure");
				}
			}

		} catch (Exception ex) {
			actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}

	public IGmemberbaseinfoDAO getGmemberbaseinfoDAO() {
		return gmemberbaseinfoDAO;
	}

	public void setGmemberbaseinfoDAO(IGmemberbaseinfoDAO gmemberbaseinfoDAO) {
		this.gmemberbaseinfoDAO = gmemberbaseinfoDAO;
	}

	public IGmemberpatentinfoDAO getGmemberpatentinfoDAO() {
		return gmemberpatentinfoDAO;
	}

	public void setGmemberpatentinfoDAO(IGmemberpatentinfoDAO gmemberpatentinfoDAO) {
		this.gmemberpatentinfoDAO = gmemberpatentinfoDAO;
	}

	public IGmemberresearchproductionDAO getGmemberresearchproductionDAO() {
		return gmemberresearchproductionDAO;
	}

	public void setGmemberresearchproductionDAO(IGmemberresearchproductionDAO gmemberresearchproductionDAO) {
		this.gmemberresearchproductionDAO = gmemberresearchproductionDAO;
	}

}
