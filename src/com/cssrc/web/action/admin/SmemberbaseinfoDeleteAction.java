package com.cssrc.web.action.admin;

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
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.IUserLogDAO;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

public class SmemberbaseinfoDeleteAction extends Action {
	public SmemberbaseinfoDeleteAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
		Integer asmr_id = Integer.valueOf(httpServletRequest.getParameter("asmr_id"));
		String acadname = (String) httpServletRequest.getSession().getAttribute("acadname");
		String assoname = (String) httpServletRequest.getSession().getAttribute("academybaseinfoassoname");
		String searchsql = "where asmr_id = " + asmr_id;
		List tAfBookentrys = new ArrayList();
		tAfBookentrys = academysmemberrelationDAO.list(searchsql);
		Academysmemberrelation bean = (Academysmemberrelation) tAfBookentrys.get(0);
		bean.setIsdelete("1");

		Smemberbaseinfo relationbean = smemberbaseinfoDAO.getSmemberbaseinfo(bean.getSmbi_id());

		if (academysmemberrelationDAO.modifyAcademysmemberrelation(bean)) {
			httpServletRequest.getSession().setAttribute("smbi_id", bean.getSmbi_id());
			httpServletRequest.getSession().setAttribute("smemberabi_id", bean.getAbi_id());

			// 记录到日志
			User user = (User) httpServletRequest.getSession().getAttribute("USER");
			UserLog logbean = new UserLog();
			logbean.setTime(Calendar.getInstance());
			logbean.setUser(user.getUseraccount());
			if (user.getUserrole().equals("SystemAdmin")) {
				logbean.setAcademy("系统管理员");
				logbean.setOperation("预删除 " + acadname + " " + assoname + " 普通会员" + relationbean.getMemno());
			} else {
				logbean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + " 学会管理员");
				logbean.setOperation("预删除 " + user.getUseracademic() + " " + user.getUserassociation() + " 普通会员 " + relationbean.getMemno());
			}

			userlogDAO.saveUserLog(logbean);

			return actionMapping.findForward("success");
		}
		return actionMapping.findForward("failure");
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

}
