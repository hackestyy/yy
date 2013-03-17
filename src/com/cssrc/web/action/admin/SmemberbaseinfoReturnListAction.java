package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SmemberbaseinfoReturnListAction extends Action {
	public SmemberbaseinfoReturnListAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("smemberabi_id");

		// Acadgroup bean = acadgroupDAO.getAcadgroup(shai_id);
		try {
			EntrySearchForm form = new EntrySearchForm();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
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
			Integer size = academysmemberrelationDAO.getSize(abi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List smemberbaseinfolist = new ArrayList();
			List academysmemberrelationlist = new ArrayList();
			List smemberbaseinforelationlist = new ArrayList();
			List tAfBookentrys = new ArrayList();
			List tAfBookentrys0 = new ArrayList();
			String searchsql = "where abi_id = " + abi_id + " and isdelete=" + 0;

			if (pagesize == 0) {
				tAfBookentrys = academysmemberrelationDAO.list(searchsql);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					List temptAfBookentrys = new ArrayList();
					Smemberbainforelation smemberbainforelation = new Smemberbainforelation();
					Academysmemberrelation academysmemberrelation = (Academysmemberrelation) tAfBookentrys.get(i);
					academysmemberrelationlist.add(academysmemberrelation);
					Integer smbi_id = academysmemberrelation.getSmbi_id();
					String searchsqlsmemberbaseinfo = "where smbi_id = " + smbi_id;
					temptAfBookentrys = smemberbaseinfoDAO.list(searchsqlsmemberbaseinfo);
					Smemberbaseinfo smemberbaseinfo = (Smemberbaseinfo) temptAfBookentrys.get(0);
					smemberbaseinfolist.add(smemberbaseinfo);
					smemberbainforelation.setAsmr_id(academysmemberrelation.getAsmr_id());
					smemberbainforelation.setMemname(smemberbaseinfo.getMemname());
					smemberbainforelation.setAbi_id(academysmemberrelation.getAbi_id());
					smemberbainforelation.setSmbi_id(academysmemberrelation.getSmbi_id());
					smemberbainforelation.setMemsex(smemberbaseinfo.getMemsex());
					smemberbainforelation.setInstitutetelephone(smemberbaseinfo.getInstitutetelephone());
					smemberbainforelation.setMeminstitute(smemberbaseinfo.getMeminstitute());
					smemberbaseinforelationlist.add(smemberbainforelation);
				}

			} else {
				tAfBookentrys = academysmemberrelationDAO.list(searchsql, offset, pagesize);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					List temptAfBookentrys = new ArrayList();
					Smemberbainforelation smemberbainforelation = new Smemberbainforelation();
					Academysmemberrelation academysmemberrelation = (Academysmemberrelation) tAfBookentrys.get(i);
					academysmemberrelationlist.add(academysmemberrelation);
					Integer smbi_id = academysmemberrelation.getSmbi_id();
					String searchsqlsmemberbaseinfo = "where smbi_id = " + smbi_id;
					temptAfBookentrys = smemberbaseinfoDAO.list(searchsqlsmemberbaseinfo);
					Smemberbaseinfo smemberbaseinfo = (Smemberbaseinfo) temptAfBookentrys.get(0);
					smemberbaseinfolist.add(smemberbaseinfo);
					smemberbainforelation.setAsmr_id(academysmemberrelation.getAsmr_id());
					smemberbainforelation.setMemname(smemberbaseinfo.getMemname());
					smemberbainforelation.setAbi_id(academysmemberrelation.getAbi_id());
					smemberbainforelation.setSmbi_id(academysmemberrelation.getSmbi_id());
					smemberbainforelation.setMemsex(smemberbaseinfo.getMemsex());
					smemberbainforelation.setInstitutetelephone(smemberbaseinfo.getInstitutetelephone());
					smemberbainforelation.setMeminstitute(smemberbaseinfo.getMeminstitute());
					smemberbaseinforelationlist.add(smemberbainforelation);
				}

			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("smemberabi_id", abi_id);
			httpServletRequest.getSession().setAttribute("SMEMBERBASEINFOLIST", smemberbaseinforelationlist);
			httpServletRequest.getSession().setAttribute("ACADEMYSMEMBERBASEINFOLIST", academysmemberrelationlist);
		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

}
