package com.cssrc.web.action.usermanage;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.OnlineCtrl;
import com.cssrc.dao.IOnlineCtrlDAO;

public class OnlineAdminManage extends Action {
	private IOnlineCtrlDAO onlinectrlDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		int timeout;
		int onlineusernum;
		int maxnum;
		int maxtime;
		HttpSession s = httpServletRequest.getSession();
		ServletContext application = httpServletRequest.getSession().getServletContext();
		try {
			List onlineUserList = (List) application.getAttribute("onlineUserList");
			onlineusernum = onlineUserList.size();
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		List onlinelist = onlinectrlDAO.findOnlieCtrl(1);
		OnlineCtrl nolinebean = new OnlineCtrl();
		if (onlinelist.size() == 0) {
			nolinebean.setNo(1);
			nolinebean.setNum(100);
			nolinebean.setTime(30);
			s.setMaxInactiveInterval(1800);
			onlinectrlDAO.saveOnlineCtrl(nolinebean);
			maxnum = nolinebean.getNum();
			timeout = 30;
			maxtime = 1800;
		} else {
			nolinebean = (OnlineCtrl) onlinelist.get(0);
			int nowtime = s.getMaxInactiveInterval();
			int mtime = nolinebean.getTime() * 60;
			if (nowtime != mtime) {
				nolinebean.setTime(nowtime / 60);
				onlinectrlDAO.saveOnlineCtrl(nolinebean);
			}
			timeout = nolinebean.getTime();
			maxtime = timeout * 60;
		}
		try {
			s.setMaxInactiveInterval(maxtime);
			maxnum = nolinebean.getNum();
			timeout = nolinebean.getTime();
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		s.setAttribute("onlineusernum", onlineusernum);
		s.setAttribute("maxnum", maxnum);
		s.setAttribute("timeout", timeout);
		return actionMapping.findForward("success");

	}

	public IOnlineCtrlDAO getOnlinectrlDAO() {
		return onlinectrlDAO;
	}

	public void setOnlinectrlDAO(IOnlineCtrlDAO onlinectrlDAO) {
		this.onlinectrlDAO = onlinectrlDAO;
	}

}
