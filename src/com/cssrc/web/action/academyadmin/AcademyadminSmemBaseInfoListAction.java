package com.cssrc.web.action.academyadmin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademybaseinfoForm;

public class AcademyadminSmemBaseInfoListAction extends Action {
	public AcademyadminSmemBaseInfoListAction() {
	}

	private IAcadgroupDAO acadgroupDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoname = String.valueOf(httpServletRequest.getSession().getAttribute("userassociation"));
		String acadname = String.valueOf(httpServletRequest.getSession().getAttribute("useracademic"));

		List tAfBookentrys = new ArrayList();
		List academybaseinfotAfBookentrys = new ArrayList();
		Integer shai_id = 0;
		Integer abi_id = 0;
		Academybaseinfo tempbean = new Academybaseinfo();

		tAfBookentrys = acadgroupDAO.list();
		for (int i = 0; i < tAfBookentrys.size(); i++) {
			Acadgroup bean = new Acadgroup();
			Acadgroup acadgroup = (Acadgroup) tAfBookentrys.get(i);
			if (acadgroup.getAssoname().equals(assoname)) {
				String shai_idsearchsql = "where shai_id = " + acadgroup.getShai_id();
				shai_id = acadgroup.getShai_id();
				academybaseinfotAfBookentrys = academybaseinfoDAO.list(shai_idsearchsql);
				for (int j = 0; j < academybaseinfotAfBookentrys.size(); j++) {
					// Academybaseinfo tempbean = new Academybaseinfo();
					Academybaseinfo academybaseinfo = (Academybaseinfo) academybaseinfotAfBookentrys.get(j);
					if (academybaseinfo.getAcadname().equals(acadname)) {
						String abi_idsearchsql = "where abi_id = " + academybaseinfo.getAbi_id();
						abi_id = academybaseinfo.getAbi_id();
						List templist = new ArrayList();
						templist = academybaseinfoDAO.findAcademybaseinfo(abi_id);
						tempbean = (Academybaseinfo) templist.get(0);
					}
				}
			}
		}

		AcademybaseinfoForm form = new AcademybaseinfoForm();
		/*
		 * Integer abi_id =
		 * Integer.valueOf(httpServletRequest.getParameter("abi_id"));
		 * Academybaseinfo bean = new Academybaseinfo();
		 * if(httpServletRequest.getParameter("abi_id") != null) { abi_id =
		 * Integer.valueOf(httpServletRequest.getParameter("abi_id")); bean =
		 * academybaseinfoDAO.getAcademybaseinfo(abi_id); } else { abi_id =
		 * (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		 * bean = academybaseinfoDAO.getAcademybaseinfo(abi_id); }
		 */
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, tempbean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		form.setTempregisterdate(DateUtil.getCalendarString(form.getRegisterdate(), "yyyy-MM-dd"));
		httpServletRequest.setAttribute("academybaseinfoForm", form);
		httpServletRequest.getSession().setAttribute("assoname", assoname);
		httpServletRequest.getSession().setAttribute("academybaseinfoassoname", assoname);
		httpServletRequest.getSession().setAttribute("acadname", acadname);
		httpServletRequest.getSession().setAttribute("shai_id", shai_id);
		httpServletRequest.getSession().setAttribute("abi_id", abi_id);
		httpServletRequest.getSession().setAttribute("ACADGROUPLIST", tAfBookentrys);
		httpServletRequest.getSession().setAttribute("ACADEMYBASEINFOLIST", academybaseinfotAfBookentrys);

		return actionMapping.findForward("success");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

}
