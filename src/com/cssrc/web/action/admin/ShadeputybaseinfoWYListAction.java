package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputylistinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.dao.admin.IShadeputyinfoDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;
import com.cssrc.util.MyUtil;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class ShadeputybaseinfoWYListAction extends Action {
	public ShadeputybaseinfoWYListAction() {
	}

	private ISmemberdeputyinfoDAO smemberdeputyinfoDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;
	private IShadeputyinfoDAO shadeputyinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String assoduty_s = httpServletRequest.getParameter("assoduty_s");
		if (assoduty_s == null) {
			assoduty_s = (String) httpServletRequest.getSession().getAttribute("assoduty_s");
		}
		String queryString = "('0','1','2','3','4')";

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
			List listresult = new ArrayList();
			List templist = new ArrayList();
			List list = new ArrayList();
			String condition = " where (assoduty_s='" + assoduty_s + "' and assoduty_f in " + queryString + ") or (assoduty_s_history='" + assoduty_s + "' and assoduty_f_history in " + queryString + ") order by assoduty_f,memname";
			templist = smemberdeputyinfoDAO.getSqlresult(condition);
			for (int i = 0; i < templist.size(); i++) {
				Shadeputylistinfo bean = (Shadeputylistinfo) templist.get(i);
				String deputyno = bean.getDeputyno();
				String str = deputyno.substring(0, 4);
				if (str.equals("DBWY")) {
					bean.setIsshsamember("NO");
				} else {
					bean.setIsshsamember("YES");
				}
				list.add(bean);

			}

			if (list.size() >= offset + pagesize) {
				listresult = list.subList(offset, offset + pagesize);
			} else {
				listresult = list.subList(offset, list.size());
			}
			List finalList = new ArrayList();
			for (int i = 0; i < listresult.size(); i++) {
				Shadeputylistinfo bean = new Shadeputylistinfo();
				bean = (Shadeputylistinfo) listresult.get(i);
				String s = bean.getDeputyinstitute();
				String institute = MyUtil.cutString(s, 24);
				bean.setDeputyinstitute(institute);
				finalList.add(bean);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, list.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("assoduty_s", assoduty_s);
			httpServletRequest.getSession().setAttribute("SHADEPUTYBASEINFOLIST", finalList);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public ISmemberdeputyinfoDAO getSmemberdeputyinfoDAO() {
		return smemberdeputyinfoDAO;
	}

	public void setSmemberdeputyinfoDAO(ISmemberdeputyinfoDAO smemberdeputyinfoDAO) {
		this.smemberdeputyinfoDAO = smemberdeputyinfoDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

	public IShadeputyinfoDAO getShadeputyinfoDAO() {
		return shadeputyinfoDAO;
	}

	public void setShadeputyinfoDAO(IShadeputyinfoDAO shadeputyinfoDAO) {
		this.shadeputyinfoDAO = shadeputyinfoDAO;
	}
}
