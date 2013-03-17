package com.cssrc.web.action.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.view.TempBean;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class ListfileAction extends Action {
	public ListfileAction() {

	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		EntrySearchForm form = (EntrySearchForm) actionForm;
		try {

			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction == null) {
				searchaction = "list";
			}
			if (searchaction.equals("goto")) {
				offset = (curpage - 1) * pagesize;

			} else {
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

			File mydir = new File(this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\");
			String[] files = mydir.list();
			List temp = new ArrayList();
			List filesname = new ArrayList();
			// 去除backup.bat和recovery.bat两个文件
			for (int i = 0; i < files.length; i++) {
				TempBean bean = new TempBean();
				String sTemp = files[i];
				if (sTemp.equals("backup.bat") || sTemp.equals("recovery.bat")) {
					continue;
				}
				bean.setFilesname(sTemp);
				bean.setPath(this.getServlet().getServletContext().getRealPath("/") + "WEB-INF\\backup\\");
				temp.add(bean);
			}
			// 加上序号
			for (int i = 0; i < temp.size(); i++) {
				TempBean bean = new TempBean();
				bean = (TempBean) temp.get(i);
				bean.setSerialnumber(i + 1);
				filesname.add(bean);
			}
			int filescount = filesname.size();

			if (filesname.size() >= offset + pagesize) {
				filesname = filesname.subList(offset, offset + pagesize);
			} else {
				filesname = filesname.subList(offset, filesname.size());
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, filescount, pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

			httpServletRequest.setAttribute("filesname", filesname);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}
}