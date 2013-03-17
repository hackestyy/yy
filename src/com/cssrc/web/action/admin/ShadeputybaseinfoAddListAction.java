package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.MyUtil;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class ShadeputybaseinfoAddListAction extends Action {
	public ShadeputybaseinfoAddListAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String assoduty_s = String.valueOf(httpServletRequest.getParameter("assoduty_s"));
		if (assoduty_s.equals("null")) {
			assoduty_s = (String) httpServletRequest.getSession().getAttribute("assoduty_s");
		}
		try {
			QueryForm form = (QueryForm) actionForm;
			// String searchsql = getSearchsql(form);
			List smemberbaseinforelationlist = new ArrayList();
			// List list = new ArrayList();
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
				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
				// searchsql = form.getSearchsql();
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

			Integer shadeputybaseinfosize = shadeputybaseinfoDAO.getSize(assoduty_s);
			Integer size = shadeputybaseinfosize.intValue();
			if (size.intValue() < offset) {
				offset = 0;
			}
			List shadeputybaseinfotAfBookentrys = new ArrayList();
			String shadeputybaseinfosearchsql = "where assoduty_s = " + assoduty_s;

			if (pagesize == 0) {
				shadeputybaseinfotAfBookentrys = shadeputybaseinfoDAO.list(shadeputybaseinfosearchsql);
			}

			else {
				shadeputybaseinfotAfBookentrys = shadeputybaseinfoDAO.list(shadeputybaseinfosearchsql, offset, pagesize);

			}
			List finalList = new ArrayList();
			for (int i = 0; i < shadeputybaseinfotAfBookentrys.size(); i++) {
				Shadeputybaseinfo bean = new Shadeputybaseinfo();
				bean = (Shadeputybaseinfo) shadeputybaseinfotAfBookentrys.get(i);
				String s = bean.getDeputyinstitute();
				String institute = MyUtil.cutString(s, 24);
				bean.setDeputyinstitute(institute);
				finalList.add(bean);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("assoduty_s", assoduty_s);
			httpServletRequest.getSession().setAttribute("SHADEPUTYBASEINFOADDLIST", finalList);

		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

}
