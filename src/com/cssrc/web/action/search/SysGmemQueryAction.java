package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.bean.admin.Gmemberbaseinfo;
import com.cssrc.bean.admin.Gmemberbaseinforelation;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.dao.admin.IGmemberbaseinfoDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class SysGmemQueryAction extends Action {

	public SysGmemQueryAction() {

	}

	private IAcadgroupDAO acadgroupDAO;
	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		QueryForm form = (QueryForm) actionForm;
		try {
			String searchsql = getSearchsql(form);
			List list = new ArrayList();
			List list2 = new ArrayList();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction != null) {
				if (searchaction.equals("list")) {
					httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
				}
				if (searchaction.equals("search")) {
					httpServletRequest.getSession().setAttribute("SEARCHCONDITION", searchsql);
					curpage = 1;
					form.resetReseach();
				} else if (searchaction.equals("goto")) {
					offset = (curpage - 1) * pagesize;
				} else if (searchaction.equals("reset")) {
					httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
					form.reset();
					curpage = form.getCurpage();
					pagesize = form.getPagesize();
				}
			} else {
				String tempsearchsql = (String) httpServletRequest.getSession().getAttribute("SEARCHCONDITION");
				if (tempsearchsql != null) {
					searchsql = tempsearchsql;
				}

				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if (httpServletRequest.getParameter("pagesize") != null) {
					pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
				}
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
			List tAfBookentrys = new ArrayList();
			List listresult = new ArrayList();
			list = acadgroupDAO.SearchGmember(searchsql);
			if (list.size() >= offset + pagesize) {
				listresult = list.subList(offset, offset + pagesize);
			} else {
				listresult = list.subList(offset, list.size());
			}

			for (int i = 0; i < list.size(); i++) {
				Gmemberbaseinforelation a1 = (Gmemberbaseinforelation) list.get(i);
				int num = a1.getAgmr_id();
				Academygmemberrelation a2 = academygmemberrelationDAO.getAcademygmemberrelation(num);
				tAfBookentrys.add(a2);
			}

			List academygmemberrelationlist = new ArrayList();
			List gmemberbaseinfolist = new ArrayList();
			List gmemberbaseinforelationlist = new ArrayList();
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				List temptAfBookentrys = new ArrayList();
				Gmemberbaseinforelation gmemberbaseinforelation = new Gmemberbaseinforelation();
				Academygmemberrelation academygmemberrelation = (Academygmemberrelation) tAfBookentrys.get(i);
				academygmemberrelationlist.add(academygmemberrelation);
				Integer gmbi_id = academygmemberrelation.getGmbi_id();
				Academygmemberrelation relationbean = academygmemberrelationDAO.getAcademygmemberrelation(academygmemberrelation.getAgmr_id());
				String searchsqlgmemberbaseinfo = "where gmbi_id = " + gmbi_id;
				temptAfBookentrys = gmemberbaseinfoDAO.list(searchsqlgmemberbaseinfo);
				Gmemberbaseinfo gmemberbaseinfo = (Gmemberbaseinfo) temptAfBookentrys.get(0);
				gmemberbaseinfolist.add(gmemberbaseinfo);
				gmemberbaseinforelation.setAgmr_id(academygmemberrelation.getAgmr_id());
				gmemberbaseinforelation.setContactaddress(gmemberbaseinfo.getContactaddress());
				gmemberbaseinforelation.setAbi_id(academygmemberrelation.getAbi_id());
				gmemberbaseinforelation.setGmbi_id(academygmemberrelation.getGmbi_id());
				gmemberbaseinforelation.setContactname(gmemberbaseinfo.getContactname());
				gmemberbaseinforelation.setInstitutename(gmemberbaseinfo.getInstitutename());
				gmemberbaseinforelation.setContacttelephone(gmemberbaseinfo.getContacttelephone());
				gmemberbaseinforelation.setInstitutecode(gmemberbaseinfo.getInstitutecode());
				gmemberbaseinforelation.setContactaddress(gmemberbaseinfo.getContactaddress());
				gmemberbaseinforelation.setContactpostcode(gmemberbaseinfo.getContactpostcode());
				gmemberbaseinforelation.setInstitutecode(gmemberbaseinfo.getInstitutecode());
				gmemberbaseinforelation.setInstitutetype(gmemberbaseinfo.getInstitutetype());
				gmemberbaseinforelation.setIsannualregister(relationbean.getIsannualregister());
				gmemberbaseinforelation.setJoindate(relationbean.getJoindate());
				gmemberbaseinforelation.setNo(i + 1);
				gmemberbaseinforelationlist.add(gmemberbaseinforelation);
			}

			list2 = gmemberbaseinforelationlist;

			httpServletRequest.setAttribute("SEARCHGMEMBERBASEINFOLIST", listresult);
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, list.size(), pagesize, url);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list2);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
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

	private String getSearchsql(QueryForm form) {

		String searchitem1 = form.getSearchitem1();
		String searchitem2 = form.getSearchitem2();
		String searchitem3 = form.getSearchitem3();
		String searchitem4 = form.getSearchitem4();
		String searchvalue1 = form.getSearchvalue1();
		String searchvalue2 = form.getSearchvalue2();
		String searchvalue3 = form.getSearchvalue3();
		String searchvalue4 = form.getSearchvalue4();
		StringBuffer searchsql = new StringBuffer();
		searchsql.append("select distinct gmbi_id, institutename, AcadName, contacttelephone, contactaddress, isdelete, agmr_id from v_searchgmember where 1=1 ");

		if (searchitem1.equals("acadname") && (!searchvalue1.equals(""))) {
			searchsql.append("and acadname like" + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("institutename") && (!searchvalue1.equals(""))) {
			searchsql.append("and institutename like" + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("institutetype") && (!searchvalue1.equals(""))) {
			searchsql.append("and institutetype like" + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("prodname") && (!searchvalue1.equals(""))) {
			searchsql.append("and prodname like" + " '%" + searchvalue1 + "%'");
			searchsql.append("or prodrewards like " + " '%" + searchvalue1 + "%'");
			searchsql.append("or prodapplication like " + " '%" + searchvalue1 + "%'");
			searchsql.append("or proddate like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("patentname") && (!searchvalue1.equals(""))) {
			searchsql.append("and patentname like" + " '%" + searchvalue1 + "%'");
			searchsql.append("or patenttype like " + " '%" + searchvalue1 + "%'");
			searchsql.append("or patentapplication like " + " '%" + searchvalue1 + "%'");
			searchsql.append("or patentdate like " + " '%" + searchvalue1 + "%'");
		}

		if (searchitem2.equals("acadname") && (!searchvalue2.equals(""))) {
			searchsql.append("and acadname like" + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("institutename") && (!searchvalue2.equals(""))) {
			searchsql.append("and institutename like" + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("institutetype") && (!searchvalue2.equals(""))) {
			searchsql.append("and institutetype like" + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("prodname") && (!searchvalue2.equals(""))) {
			searchsql.append("and prodname like" + " '%" + searchvalue2 + "%'");
			searchsql.append("or prodrewards like " + " '%" + searchvalue2 + "%'");
			searchsql.append("or prodapplication like " + " '%" + searchvalue2 + "%'");
			searchsql.append("or proddate like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("patentname") && (!searchvalue2.equals(""))) {
			searchsql.append("and patentname like" + " '%" + searchvalue2 + "%'");
			searchsql.append("or patenttype like " + " '%" + searchvalue2 + "%'");
			searchsql.append("or patentapplication like " + " '%" + searchvalue2 + "%'");
			searchsql.append("or patentdate like " + " '%" + searchvalue2 + "%'");
		}

		if (searchitem3.equals("acadname") && (!searchvalue3.equals(""))) {
			searchsql.append("and acadname like" + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("institutename") && (!searchvalue3.equals(""))) {
			searchsql.append("and institutename like" + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("institutetype") && (!searchvalue3.equals(""))) {
			searchsql.append("and institutetype like" + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("prodname") && (!searchvalue3.equals(""))) {
			searchsql.append("and prodname like" + " '%" + searchvalue3 + "%'");
			searchsql.append("or prodrewards like " + " '%" + searchvalue3 + "%'");
			searchsql.append("or prodapplication like " + " '%" + searchvalue3 + "%'");
			searchsql.append("or proddate like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("patentname") && (!searchvalue3.equals(""))) {
			searchsql.append("and patentname like" + " '%" + searchvalue3 + "%'");
			searchsql.append("or patenttype like " + " '%" + searchvalue3 + "%'");
			searchsql.append("or patentapplication like " + " '%" + searchvalue3 + "%'");
			searchsql.append("or patentdate like " + " '%" + searchvalue3 + "%'");
		}

		if (searchitem4.equals("acadname") && (!searchvalue4.equals(""))) {
			searchsql.append("and acadname like" + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("institutename") && (!searchvalue4.equals(""))) {
			searchsql.append("and institutename like" + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("institutetype") && (!searchvalue4.equals(""))) {
			searchsql.append("and institutetype like" + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("prodname") && (!searchvalue4.equals(""))) {
			searchsql.append("and prodname like" + " '%" + searchvalue4 + "%'");
			searchsql.append("or prodrewards like " + " '%" + searchvalue4 + "%'");
			searchsql.append("or prodapplication like " + " '%" + searchvalue4 + "%'");
			searchsql.append("or proddate like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("patentname") && (!searchvalue4.equals(""))) {
			searchsql.append("and patentname like" + " '%" + searchvalue4 + "%'");
			searchsql.append("or patenttype like " + " '%" + searchvalue4 + "%'");
			searchsql.append("or patentapplication like " + " '%" + searchvalue4 + "%'");
			searchsql.append("or patentdate like " + " '%" + searchvalue4 + "%'");
		}

		return searchsql.toString();

	}

}
