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

			// ��ϵ��
			List tAfBookentrys = new ArrayList();
			tAfBookentrys = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
			if (tAfBookentrys.size() == 1) {
				// ר��
				List list1 = smemberacademicliteratureDAO.gainSmemberacademicliterature(smbi_id);
				if (!smemberacademicliteratureDAO.delete(list1)) {
					actionMapping.findForward("failure");
				}
				// ����ίԱ��Ϣ
				List list3 = smemberdeputyinfoDAO.findSmemberdeputyinfoList(smbi_id);
				if (!smemberdeputyinfoDAO.delete(list3)) {
					actionMapping.findForward("failure");
				}
				// ������ʷ
				List list4 = smemberpastjobDAO.gainSmemberpastjob(smbi_id);
				if (!smemberpastjobDAO.delete(list4)) {
					actionMapping.findForward("failure");
				}
				// ר��
				List list5 = smemberpatentinfoDAO.gainSmemberpatentinfo(smbi_id);
				if (!smemberpatentinfoDAO.delete(list5)) {
					actionMapping.findForward("failure");
				}
				// �ɹ���ҵ
				List list6 = smemberresearchproductionDAO.gainSmemberresearchproduction(smbi_id);
				if (!smemberresearchproductionDAO.delete(list6)) {
					actionMapping.findForward("failure");
				}
				// ��ϵ��
				List list7 = academysmemberrelationDAO.gainAcademysmemberrelation(smbi_id);
				if (!academysmemberrelationDAO.delete(list7)) {
					actionMapping.findForward("failure");
				}
				// ������Ϣ
				List list2 = smemberbaseinfoDAO.findSmemberbaseinfo(smbi_id);
				if (!smemberbaseinfoDAO.delete(list2)) {
					actionMapping.findForward("failure");
				}

				Smemberbaseinfo nobean = (Smemberbaseinfo) list2.get(0);

				User user = (User) httpServletRequest.getSession().getAttribute("USER");
				logbean.setTime(Calendar.getInstance());
				logbean.setUser(user.getUseraccount());
				logbean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + "ѧ�����Ա");
				logbean.setOperation("��ȫɾ�� " + user.getUseracademic() + " " + user.getUserassociation() + " ��ͨ��Ա " + nobean.getMemno());
				if (user.getUserrole().equals("SystemAdmin")) {
					logbean.setAcademy("ϵͳ����Ա");
					logbean.setOperation("��ȫɾ�� " + acadname + " " + assoname + " ��ͨ��Ա" + nobean.getMemno());
				} else {
					logbean.setAcademy(user.getUseracademic() + " " + user.getUserassociation() + " ѧ�����Ա");
					logbean.setOperation("��� " + user.getUseracademic() + " " + user.getUserassociation() + " ��ͨ��Ա " + nobean.getMemno());
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
