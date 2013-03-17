package com.cssrc.web.action.stat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.IGatherinfoDAO;

public class AcadGatherInfoAction extends Action {

	public AcadGatherInfoAction() {

	}

	private IGatherinfoDAO gatherinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {

			Integer shai_id = (Integer) (httpServletRequest.getSession().getAttribute("shai_id"));
			String assoname = (String) (httpServletRequest.getSession().getAttribute("academybaseinfoassoname"));

			List tAfBookentrys = gatherinfoDAO.getAcadgatherinfo(shai_id);
			Integer totalpeo = gatherinfoDAO.getAcadgatherinfototalpeo(shai_id);

			TempBean tempbean = new TempBean();
			tempbean.setNumber(totalpeo);
			tempbean.setRatio(100.00);// 人为设定100%
			tAfBookentrys.add(tempbean);

			String title = assoname + "信息汇总统计表";

			httpServletRequest.setAttribute("LIST", tAfBookentrys);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", tAfBookentrys);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IGatherinfoDAO getGatherinfoDAO() {
		return gatherinfoDAO;
	}

	public void setGatherinfoDAO(IGatherinfoDAO gatherinfoDAO) {
		this.gatherinfoDAO = gatherinfoDAO;
	}

}
