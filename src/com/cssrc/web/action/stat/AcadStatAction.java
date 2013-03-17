package com.cssrc.web.action.stat;

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
import com.cssrc.bean.stat.AcadStat;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class AcadStatAction extends Action {
	public AcadStatAction() {
	}

	private IAcadgroupDAO acadgroupDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

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

			Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
			Acadgroup acadgroup = acadgroupDAO.getAcadgroup(shai_id);
			AcadStat bean = new AcadStat();
			String shai_idsearchsql = "where shai_id = " + shai_id;
			academybaseinfotAfBookentrys = academybaseinfoDAO.list(shai_idsearchsql);
			int allpersonsize = 0;
			int alldegreesize = 0;
			for (int j = 0; j < academybaseinfotAfBookentrys.size(); j++) {
				Academybaseinfo academybaseinfo = (Academybaseinfo) academybaseinfotAfBookentrys.get(j);
				bean.setAcadname(academybaseinfo.getAcadname());
				bean.setSerialnumber(j + 1);
				String abi_idsearchsql = "where abi_id = " + academybaseinfo.getAbi_id();
				List allacademysmemberrelationtAfBookentrys = new ArrayList();
				List distinctacademysmemberrelationtAfBookentrys = new ArrayList();
				List academygmemberrelationtAfBookentrys = new ArrayList();
				allacademysmemberrelationtAfBookentrys = academysmemberrelationDAO.alllist(abi_idsearchsql);
				distinctacademysmemberrelationtAfBookentrys = academysmemberrelationDAO.distinctlist(abi_idsearchsql);
				academygmemberrelationtAfBookentrys = academygmemberrelationDAO.list(abi_idsearchsql, offset, pagesize);
				allpersonsize += distinctacademysmemberrelationtAfBookentrys.size() + academygmemberrelationtAfBookentrys.size();
				bean.setPersonnumber(allpersonsize);
				academybaseinfotAfBookentrys.add(bean);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.setAttribute("academybaseinfoassoname", acadgroup.getAssoname());
			httpServletRequest.getSession().setAttribute("academybaseinfoassoname", acadgroup.getAssoname());
			httpServletRequest.getSession().setAttribute("shai_id", shai_id);
			httpServletRequest.getSession().setAttribute("ACADSTATLIST", academybaseinfotAfBookentrys);
			httpServletRequest.getSession().setAttribute("ACADEMYBASEINFOLIST", academybaseinfotAfBookentrys);

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

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
