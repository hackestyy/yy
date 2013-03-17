package com.cssrc.web.action.academyadmin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class AcademyadminAcadgroupListAction extends Action {
	public AcademyadminAcadgroupListAction() {
	}

	private IAcadgroupDAO acadgroupDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoname = String.valueOf(httpServletRequest.getSession().getAttribute("userassociation"));
		String acadname = String.valueOf(httpServletRequest.getSession().getAttribute("useracademic"));

		try {
			QueryForm form = (QueryForm) actionForm;
			int offset = 0;
			String searchsql = form.getSearchsql();
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction == null) {
				searchaction = "list";
			}
			if (searchaction.equals("search")) {
				curpage = 1;
				form.resetReseach();
			} else if (searchaction.equals("goto")) {
				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
				searchsql = form.getSearchsql();
			} else {
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if ((pageOffset == null) || pageOffset.equals("")) {
					offset = 0;
				} else {
					offset = Integer.parseInt(pageOffset);
				}
				if (pagesize != 0) {
					form.setCurpage((offset / pagesize) + 1);
				} else {
					form.setCurpage(1);
				}
			}

			Integer size = acadgroupDAO.getSize();
			if (size.intValue() < offset) {
				offset = 0;
			}

			List tAfBookentrys = new ArrayList();
			List acadgrouptAfBookentrys = new ArrayList();
			List academybaseinfotAfBookentrys = new ArrayList();
			if (pagesize == 0) {
				tAfBookentrys = acadgroupDAO.list(searchsql);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					Acadgroup bean = new Acadgroup();
					Acadgroup acadgroup = (Acadgroup) tAfBookentrys.get(i);
					String shai_idsearchsql = "where shai_id = " + acadgroup.getShai_id();
					academybaseinfotAfBookentrys = academybaseinfoDAO.list(shai_idsearchsql);
					bean.setShai_id(acadgroup.getShai_id());
					bean.setAssoname(acadgroup.getAssoname());
					bean.setBelongcount(academybaseinfotAfBookentrys.size());
					bean.setContactperson(acadgroup.getContactperson());
					bean.setContacttelephone(acadgroup.getContacttelephone());
					acadgrouptAfBookentrys.add(bean);
				}
			} else {
				tAfBookentrys = acadgroupDAO.list(searchsql, offset, pagesize);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					Acadgroup bean = new Acadgroup();
					Acadgroup acadgroup = (Acadgroup) tAfBookentrys.get(i);
					String shai_idsearchsql = "where shai_id = " + acadgroup.getShai_id();
					academybaseinfotAfBookentrys = academybaseinfoDAO.list(shai_idsearchsql);
					bean.setShai_id(acadgroup.getShai_id());
					bean.setAssoname(acadgroup.getAssoname());
					bean.setBelongcount(academybaseinfotAfBookentrys.size());
					bean.setContactperson(acadgroup.getContactperson());
					bean.setContacttelephone(acadgroup.getContacttelephone());
					acadgrouptAfBookentrys.add(bean);
				}
			}
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("ACADGROUPLIST", acadgrouptAfBookentrys);
			httpServletRequest.getSession().setAttribute("academybaseinfoassoname", assoname);
			httpServletRequest.getSession().setAttribute("acadname", acadname);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}
}
