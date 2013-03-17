package com.cssrc.web.action.smember;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.AcademysmemberrelationTemp;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SmemberAcademysmemberrelationViewListAction extends Action {
	public SmemberAcademysmemberrelationViewListAction() {
	}

	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer tempsmbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		Integer smbi_id = tempsmbi_id.intValue();
		Integer tempabi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		Integer abi_id = tempabi_id.intValue();
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
			Integer size1 = academysmemberrelationDAO.getSize(smbi_id);
			Integer size = academysmemberrelationDAO.getSize(abi_id);
			if (size.intValue() < offset) {
				offset = 0;
			}
			if (size1.intValue() < offset) {
				offset = 0;
			}
			// List tAfBookentrys = new ArrayList();
			List tAfBookentrys = new ArrayList();
			List temptAfBookentrys = new ArrayList();
			List acadtAfBookentrys = new ArrayList();
			List academysmemberrelationtAfBookentrys = new ArrayList();
			String searchsql = "where smbi_id = " + smbi_id + " and isdelete=" + 0;
			// String searchsq2 = "where abi_id = " + abi_id+" and isdelete="+0;
			if (pagesize == 0) {
				tAfBookentrys = academysmemberrelationDAO.list(searchsql);
				// tAfBookentrys = academysmemberrelationDAO.list(searchsq2);
			} else {
				tAfBookentrys = academysmemberrelationDAO.list(searchsql, offset, pagesize);
				// tAfBookentrys = academysmemberrelationDAO.list(searchsq2,
				// offset, pagesize);
			}

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				Academysmemberrelation academysmemberrelation = new Academysmemberrelation();
				academysmemberrelation = (Academysmemberrelation) tAfBookentrys.get(i);

				AcademysmemberrelationTemp bean = new AcademysmemberrelationTemp();
				bean.setAsmr_id(academysmemberrelation.getAsmr_id());
				bean.setAbi_id(academysmemberrelation.getAbi_id());
				bean.setSmbi_id(academysmemberrelation.getSmbi_id());
				bean.setJoindate(academysmemberrelation.getJoindate());
				bean.setMemtype(academysmemberrelation.getMemtype());
				bean.setIsannualregister(academysmemberrelation.getIsannualregister());

				String abi_idsearchsql = "where abi_id = '" + academysmemberrelation.getAbi_id() + "'";
				acadtAfBookentrys = academybaseinfoDAO.list(abi_idsearchsql, offset, pagesize);
				Academybaseinfo academybaseinfo = (Academybaseinfo) acadtAfBookentrys.get(0);
				bean.setAcadname(academybaseinfo.getAcadname());

				temptAfBookentrys.add(bean);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.getSession().setAttribute("smbi_id", smbi_id);
			httpServletRequest.getSession().setAttribute("abi_id", abi_id);
			httpServletRequest.getSession().setAttribute("ACADEMYSMEMBERRELATIONLIST", temptAfBookentrys);

		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
