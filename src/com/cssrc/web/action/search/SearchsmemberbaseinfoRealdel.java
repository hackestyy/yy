package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;
import com.cssrc.dao.admin.ISmemberpastjobDAO;
import com.cssrc.dao.admin.ISmemberpatentinfoDAO;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;
import com.cssrc.dao.admin.IUserLogDAO;

public class SearchsmemberbaseinfoRealdel extends Action {

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private ISmemberdeputyinfoDAO smemberdeputyinfoDAO;

	private ISmemberpastjobDAO smemberpastjobDAO;

	private ISmemberpatentinfoDAO smemberpatentinfoDAO;

	private ISmemberresearchproductionDAO smemberresearchproductionDAO;

	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		String acadname = (String) httpServletRequest.getSession().getAttribute("acadname");
		String assoname = (String) httpServletRequest.getSession().getAttribute("academybaseinfoassoname");
		UserLog logbean = new UserLog();
		try {
			Academysmemberrelation bean = (Academysmemberrelation) academysmemberrelationDAO.getAcademysmemberrelation(asmr_id);
			Integer smbi_id = bean.getSmbi_id();

			// 关系表
			List tAfBookentrys = new ArrayList();
			tAfBookentrys = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
			if (tAfBookentrys.size() == 1) {
				// 专著
				List list1 = smemberacademicliteratureDAO.gainSmemberacademicliterature(smbi_id);
				if (!smemberacademicliteratureDAO.delete(list1)) {
					actionMapping.findForward("failure");
				}
				// 代表委员信息
				List list3 = smemberdeputyinfoDAO.findSmemberdeputyinfoList(smbi_id);
				if (!smemberdeputyinfoDAO.delete(list3)) {
					actionMapping.findForward("failure");
				}
				// 工作历史
				List list4 = smemberpastjobDAO.gainSmemberpastjob(smbi_id);
				if (!smemberpastjobDAO.delete(list4)) {
					actionMapping.findForward("failure");
				}
				// 专利
				List list5 = smemberpatentinfoDAO.gainSmemberpatentinfo(smbi_id);
				if (!smemberpatentinfoDAO.delete(list5)) {
					actionMapping.findForward("failure");
				}
				// 成果产业
				List list6 = smemberresearchproductionDAO.gainSmemberresearchproduction(smbi_id);
				if (!smemberresearchproductionDAO.delete(list6)) {
					actionMapping.findForward("failure");
				}
				// 关系表
				List list7 = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
				if (!academysmemberrelationDAO.delete(list7)) {
					actionMapping.findForward("failure");
				}
				// 基本信息
				List list2 = smemberbaseinfoDAO.findSmemberbaseinfo(smbi_id);
				if (!smemberbaseinfoDAO.delete(list2)) {
					actionMapping.findForward("failure");
				}

				Smemberbaseinfo nobean = (Smemberbaseinfo) list2.get(0);

				User user = (User) httpServletRequest.getSession().getAttribute("USER");
				logbean.setTime(Calendar.getInstance());
				logbean.setUser(user.getUseraccount());
				logbean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + "学会管理员");
				logbean.setOperation("完全删除 " + user.getUseracademic() + " " + user.getUserassociation() + " 普通会员 " + nobean.getMemno());
				if (user.getUserrole().equals("SystemAdmin")) {
					logbean.setAcademy("系统管理员");
					logbean.setOperation("完全删除 " + acadname + " " + assoname + " 普通会员" + nobean.getMemno());
				} else {
					logbean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + " 学会管理员");
					logbean.setOperation("添加 " + user.getUseracademic() + " " + user.getUserassociation() + " 普通会员 " + nobean.getMemno());
				}

			} else {
				if (!academysmemberrelationDAO.removeAcademysmemberrelation(bean)) {
					actionMapping.findForward("failure");
				}
			}

		} catch (Exception ex) {
			actionMapping.findForward("failure");
		}
		userlogDAO.saveUserLog(logbean);
		return actionMapping.findForward("success");
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public ISmemberacademicliteratureDAO getSmemberacademicliteratureDAO() {
		return smemberacademicliteratureDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public ISmemberdeputyinfoDAO getSmemberdeputyinfoDAO() {
		return smemberdeputyinfoDAO;
	}

	public ISmemberpastjobDAO getSmemberpastjobDAO() {
		return smemberpastjobDAO;
	}

	public ISmemberpatentinfoDAO getSmemberpatentinfoDAO() {
		return smemberpatentinfoDAO;
	}

	public ISmemberresearchproductionDAO getSmemberresearchproductionDAO() {
		return smemberresearchproductionDAO;
	}

	public void setSmemberacademicliteratureDAO(ISmemberacademicliteratureDAO smemberacademicliteratureDAO) {
		this.smemberacademicliteratureDAO = smemberacademicliteratureDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public void setSmemberdeputyinfoDAO(ISmemberdeputyinfoDAO smemberdeputyinfoDAO) {
		this.smemberdeputyinfoDAO = smemberdeputyinfoDAO;
	}

	public void setSmemberpastjobDAO(ISmemberpastjobDAO smemberpastjobDAO) {
		this.smemberpastjobDAO = smemberpastjobDAO;
	}

	public void setSmemberpatentinfoDAO(ISmemberpatentinfoDAO smemberpatentinfoDAO) {
		this.smemberpatentinfoDAO = smemberpatentinfoDAO;
	}

	public void setSmemberresearchproductionDAO(ISmemberresearchproductionDAO smemberresearchproductionDAO) {
		this.smemberresearchproductionDAO = smemberresearchproductionDAO;
	}

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

}
