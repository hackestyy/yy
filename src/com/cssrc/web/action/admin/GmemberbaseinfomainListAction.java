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
import com.cssrc.bean.admin.Gmemberbaseinfo;
import com.cssrc.bean.admin.Gmemberbaseinforelation;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IGmemberbaseinfoDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class GmemberbaseinfomainListAction extends Action {
	public GmemberbaseinfomainListAction() {
	}

	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		/*
		 * if (abi_id == null) { abi_id =
		 * Integer.valueOf(httpServletRequest.getParameter("abi_id")); }
		 */
		// Acadgroup bean = acadgroupDAO.getAcadgroup(shai_id);
		try {
			EntrySearchForm form = new EntrySearchForm();
			int offset = 0;
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
				curpage = Integer.valueOf(httpServletRequest.getParameter("curpage"));
				pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
				form.setPagesize(pagesize);
				form.setCurpage(curpage);
				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
			} else {
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if (httpServletRequest.getParameter("pagesize") != null) {
					pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
					form.setPagesize(pagesize);
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

			Integer size = academygmemberrelationDAO.getSize(abi_id);
			/*
			 * if (size.intValue() < offset) { offset = 0; }
			 */
			List gmemberbaseinfolist = new ArrayList();
			List academygmemberrelationlist = new ArrayList();
			List gmemberbaseinforelationlist = new ArrayList();
			List list = new ArrayList();
			List tAfBookentrys = new ArrayList();
			List tAfBookentrys0 = new ArrayList();
			String searchsql = "where abi_id = " + abi_id + " and isdelete=" + 0;
			if (pagesize == 0) {
				tAfBookentrys = academygmemberrelationDAO.list(searchsql);
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
			} else {
				tAfBookentrys = academygmemberrelationDAO.list(searchsql);
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
			}
			if (gmemberbaseinforelationlist.size() >= offset + pagesize) {
				list = gmemberbaseinforelationlist.subList(offset, offset + pagesize);
			} else {
				list = gmemberbaseinforelationlist.subList(offset, gmemberbaseinforelationlist.size());
			}
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, gmemberbaseinforelationlist.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.setAttribute("entrysearchForm", form);
			httpServletRequest.getSession().setAttribute("gmemberabi_id", abi_id);
			// httpServletRequest.getSession().setAttribute("GMEMBERBASEINFOLIST",
			// gmemberbaseinforelationlist);
			httpServletRequest.getSession().setAttribute("GMEMBERBASEINFOLIST", list);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", gmemberbaseinforelationlist);
			httpServletRequest.getSession().setAttribute("ACADEMYGMEMBERBASEINFOLIST", academygmemberrelationlist);
		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public IGmemberbaseinfoDAO getGmemberbaseinfoDAO() {
		return gmemberbaseinfoDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}

	public void setGmemberbaseinfoDAO(IGmemberbaseinfoDAO gmemberbaseinfoDAO) {
		this.gmemberbaseinfoDAO = gmemberbaseinfoDAO;
	}

}
