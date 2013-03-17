package com.cssrc.web.action.stat.dbwystat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.dbwy.IGatherInfoStatDAO;

public class GatherInfoAllAction extends Action {

	private IGatherInfoStatDAO dbwygatherinfostatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {

			String assoduty_s = (String) (httpServletRequest.getSession().getAttribute("assoduty_s"));

			List tAfBookentrys = dbwygatherinfostatDAO.getAllGatherInfoStat(assoduty_s);
			Integer totalpeo = dbwygatherinfostatDAO.getDBWYAllGatherInfoTotalPeo(assoduty_s);

			TempBean tempbean = new TempBean();

			tempbean.setNumber(totalpeo);
			tempbean.setRatio(100.00);// ��Ϊ�趨100%
			tAfBookentrys.add(tempbean);

			TempBean bean = (TempBean) tAfBookentrys.get(0);
			// WriteExcel.java���õ�list�ĵ�һ���е�assoduty_s��"ȫ�����"
			String title = "��" + assoduty_s + "��" + "ȫ�����" + "��Ϣ����ͳ�Ʊ�";

			httpServletRequest.setAttribute("LIST", tAfBookentrys);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", tAfBookentrys);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IGatherInfoStatDAO getDbwygatherinfostatDAO() {
		return dbwygatherinfostatDAO;
	}

	public void setDbwygatherinfostatDAO(IGatherInfoStatDAO dbwygatherinfostatDAO) {
		this.dbwygatherinfostatDAO = dbwygatherinfostatDAO;
	}

}
