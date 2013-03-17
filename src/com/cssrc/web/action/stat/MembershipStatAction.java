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
import com.cssrc.bean.stat.MembershipStat;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class MembershipStatAction extends Action {
	public MembershipStatAction() {
	}

	private IAcadgroupDAO acadgroupDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {
			QueryForm form = (QueryForm) actionForm;
			double alldegree = 0;
			double sum = 0;
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
					MembershipStat bean = new MembershipStat();
					Acadgroup acadgroup = (Acadgroup) tAfBookentrys.get(i);
					bean.setSerialnumber(i + 1);
					// TODO 常委、委员子库;
					if (acadgroup.getAssoname().equals("常委、委员子库")) {
						continue;
					}
					bean.setAcadgroupname(acadgroup.getAssoname());
					String shai_idsearchsql = "where shai_id = " + acadgroup.getShai_id();
					academybaseinfotAfBookentrys = academybaseinfoDAO.list(shai_idsearchsql);
					int allpersonsize = 0;
					int alldegreesize = 0;
					StringBuffer abi_idsearchsql = new StringBuffer();
					abi_idsearchsql.append("where 1=1 ");
					for (int j = 0; j < academybaseinfotAfBookentrys.size(); j++) {
						Academybaseinfo academybaseinfo = (Academybaseinfo) academybaseinfotAfBookentrys.get(j);
						if (j == 0) {
							abi_idsearchsql.append("and abi_id = " + " '" + academybaseinfo.getAbi_id() + "'");
						} else {
							abi_idsearchsql.append("or abi_id = " + " '" + academybaseinfo.getAbi_id() + "'");
						}
						if (j == (academybaseinfotAfBookentrys.size() - 1)) {
							List allacademysmemberrelationtAfBookentrys = new ArrayList();
							List distinctacademysmemberrelationtAfBookentrys = new ArrayList();
							List academygmemberrelationtAfBookentrys = new ArrayList();
							allacademysmemberrelationtAfBookentrys = academysmemberrelationDAO.alllist(abi_idsearchsql.toString());
							distinctacademysmemberrelationtAfBookentrys = academysmemberrelationDAO.distinctlist(abi_idsearchsql.toString());
							academygmemberrelationtAfBookentrys = academygmemberrelationDAO.list(abi_idsearchsql.toString(), offset, pagesize);
							alldegreesize += allacademysmemberrelationtAfBookentrys.size() + academygmemberrelationtAfBookentrys.size();
							allpersonsize += distinctacademysmemberrelationtAfBookentrys.size() + academygmemberrelationtAfBookentrys.size();
							sum += (double) allpersonsize;
						}
					}
					// bean.setPersonnumber(((double)allpersonsize)/10000.0000);
					// bean.setPersontimes(((double)alldegreesize)/10000.0000);
					acadgrouptAfBookentrys.add(bean);
					alldegree = (double) alldegreesize;
				}

			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("MEMBERSHIPSTATLIST", acadgrouptAfBookentrys);

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