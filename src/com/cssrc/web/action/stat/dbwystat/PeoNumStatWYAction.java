package com.cssrc.web.action.stat.dbwystat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.IPeopleNumDAO;

public class PeoNumStatWYAction extends Action {

	private IPeopleNumDAO peoplenumDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoduty_s = (String) (httpServletRequest.getSession().getAttribute("assoduty_s"));
		try {
			List tAfBookentrys = peoplenumDAO.getWYPeopleNum(assoduty_s);
			List list = new ArrayList();

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();
				bean = (TempBean) tAfBookentrys.get(i);
				bean.setAssoduty_f("全体委员");
				bean.setAssoduty_s(Integer.valueOf(assoduty_s));
				list.add(bean);
			}

			String title = "第" + assoduty_s + "届" + "全体委员" + "人数分类统计表";

			httpServletRequest.setAttribute("LIST", list);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IPeopleNumDAO getPeoplenumDAO() {
		return peoplenumDAO;
	}

	public void setPeoplenumDAO(IPeopleNumDAO peoplenumDAO) {
		this.peoplenumDAO = peoplenumDAO;
	}

}
