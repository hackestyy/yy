package com.cssrc.web.action.usermanage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.UserLog;
import com.cssrc.dao.admin.IUserLogDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.UserLogForm;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class UserLogListAction extends Action {
	public UserLogListAction() {
	}

	private IUserLogDAO userlogDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String userrole = String.valueOf(httpServletRequest.getParameter("userrole"));
		try {
			QueryForm form = new QueryForm();
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

			List tAfBookentrys = new ArrayList();
			List list = new ArrayList();

			tAfBookentrys = userlogDAO.findAll();

			Integer size = tAfBookentrys.size();
			if (size.intValue() < offset) {
				offset = 0;
			}
			// 获取当前时间
			String timenow = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy-MM-dd");
			String[] timelist = timenow.split("-");
			int times = Integer.valueOf(timelist[0]) * 365 + Integer.valueOf(timelist[1]) * 30 + Integer.valueOf(timelist[2]);

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				UserLog bean = new UserLog();
				UserLogForm userlogform = new UserLogForm();
				bean = (UserLog) tAfBookentrys.get(i);
				// 获取数据库中操作时间
				String timeop = DateUtil.getCalendarString(bean.getTime(), "yyyy-MM-dd");
				String[] timeoplist = timeop.split("-");
				int timeops = Integer.valueOf(timeoplist[0]) * 365 + Integer.valueOf(timeoplist[1]) * 30 + Integer.valueOf(timeoplist[2]);
				// if (times > timeops + 7) {
				// userlogDAO.removeUserLog(bean);
				// } else {
				userlogform.setNo(bean.getNo());
				userlogform.setUser(bean.getUser());
				userlogform.setOperation(bean.getOperation());
				userlogform.setTemptime(DateUtil.getCalendarString(bean.getTime(), "yyyy-MM-dd kk:mm:ss EEEE"));
				userlogform.setAcademy(bean.getAcademy());
				list.add(userlogform);
				// }
			}
			List listresult = new ArrayList();
			if (list.size() >= offset + pagesize) {
				listresult = list.subList(offset, offset + pagesize);
			} else {
				listresult = list.subList(offset, list.size());
			}
			List finalList = new ArrayList();
			int a = list.size();
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, a, pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.getSession().setAttribute("userrole", userrole);
			httpServletRequest.setAttribute("USERLOGLIST", listresult);
			httpServletRequest.setAttribute("queryForm", form);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");
	}

	public IUserLogDAO getUserlogDAO() {
		return userlogDAO;
	}

	public void setUserlogDAO(IUserLogDAO userlogDAO) {
		this.userlogDAO = userlogDAO;
	}

}
