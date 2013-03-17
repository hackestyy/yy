package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

/**
 * <p>
 * Title: BKQueryAction
 * </p>
 * <p>
 * Description: ÊÔÑé±³¾°×ÊÁÏ¿â(T_FD_BACKGR)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcadgroupQueryAction extends Action {
	public AcadgroupQueryAction() {
	}

	private Object[] obj;
	private IAcadgroupDAO acadgroupDAO;

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
			searchsql = getSearchsql(form);
			form.setSearchsql(searchsql);
			if (searchaction.equals("search")) {
				httpServletRequest.getSession().setAttribute("CONDITION", searchsql);
				curpage = 1;
				form.resetReseach();
			} else if (searchaction.equals("goto")) {
				searchsql = (String) httpServletRequest.getSession().getAttribute("CONDITION");
				if (null == searchsql) {
					searchsql = "";
				}

				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				httpServletRequest.getSession().removeAttribute("CONDITION");
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
				searchsql = form.getSearchsql();
			} else {
				searchsql = (String) httpServletRequest.getSession().getAttribute("CONDITION");
				if (null == searchsql) {
					searchsql = "";
				}
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if ((pageOffset == null) || pageOffset.equals("")) {
					offset = 0;
				} else {
					offset = Integer.parseInt(pageOffset);
				}
				// if pagesize = 0('all' in the page) will not be div
				// the curpage will be set to 1
				if (pagesize != 0) {
					form.setCurpage((offset / pagesize) + 1);
				} else {
					form.setCurpage(1);
				}
			}

			Integer size = acadgroupDAO.getquerySize(searchsql);
			if (size.intValue() < offset) {
				offset = 0;
			}
			List tAfBookentrys = new ArrayList();
			if (pagesize == 0) {
				tAfBookentrys = acadgroupDAO.list(searchsql);
			} else {
				tAfBookentrys = acadgroupDAO.list(searchsql, offset, pagesize, obj);
			}

			String url = httpServletRequest.getRequestURI();

			String pagerHeader = Pager.generateall(offset, size.intValue(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.setAttribute("ACADGROUPLIST", tAfBookentrys);
		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	private String getSearchsql(QueryForm form) {
		this.obj = null;
		String searchitem1 = form.getSearchitem1();
		String searchitem2 = form.getSearchitem2();
		String searchitem3 = form.getSearchitem3();
		String condition = "like";
		String searchvalue1 = form.getSearchvalue1();
		String searchvalue2 = form.getSearchvalue2();
		String searchvalue3 = form.getSearchvalue3();
		String join1 = form.getJoin1();
		String join2 = form.getJoin2();
		StringBuffer searchsql = new StringBuffer();
		List list = new ArrayList();

		if (!searchvalue1.equals("")) {
			searchsql.append(" where " + searchitem1 + " " + condition + " ? ");
			list.add("%" + searchvalue1 + "%");
			if (!searchvalue2.equals("")) {
				if (join1.equals("0")) {
					searchsql.append(" and " + searchitem2 + " " + condition + " ? ");
					list.add("%" + searchvalue2 + "%");
				} else {
					searchsql.append(" or " + searchitem2 + " " + condition + " ? ");
					list.add("%" + searchvalue2 + "%");
				}
				if (!searchvalue3.equals("")) {
					if (join2.equals("0")) {
						searchsql.append(" and " + searchitem3 + " " + condition + " ? ");
						list.add("%" + searchvalue3 + "%");
					} else {
						searchsql.append(" or " + searchitem3 + " " + condition + " ? ");
						list.add("%" + searchvalue3 + "%");
					}
				}
			}
		}
		obj = list.toArray();
		return searchsql.toString();
	}

}
