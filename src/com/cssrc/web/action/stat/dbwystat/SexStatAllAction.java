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
import com.cssrc.dao.stat.dbwy.ISexStatDAO;

public class SexStatAllAction extends Action {

	private ISexStatDAO dbwysexstatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoduty_s = (String) (httpServletRequest.getSession().getAttribute("assoduty_s"));

		try {

			List tAfBookentrys = dbwysexstatDAO.getAllSexStat(assoduty_s);
			List list = new ArrayList();
			TempBean tempbean = (TempBean) tAfBookentrys.get(0);

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();

				bean = (TempBean) tAfBookentrys.get(i);
				bean.setAssoduty_f("全体代表");
				bean.setAssoduty_s(Integer.valueOf(assoduty_s));
				list.add(bean);
			}

			/*
			 * 以饼状图显示 主要过程为list的转置 男 男比例 女 女比例
			 * 转成
			 * 男 男比例 女 女比例
			 */
			List list4cakechart = new ArrayList();
			TempBean beanCakeM = new TempBean();
			TempBean beanCakeF = new TempBean();
			beanCakeF.setAgesegment("女性");
			beanCakeF.setRatio(tempbean.getFemaleratio());
			list4cakechart.add(beanCakeF);
			beanCakeM.setAgesegment("男性");
			beanCakeM.setRatio(tempbean.getMaleratio());
			list4cakechart.add(beanCakeM);

			String title = "第" + assoduty_s + "届" + "全体代表" + "性别情况统计表";

			httpServletRequest.setAttribute("LIST", list);
			httpServletRequest.getSession().setAttribute("STATINFO", list4cakechart);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public ISexStatDAO getDbwysexstatDAO() {
		return dbwysexstatDAO;
	}

	public void setDbwysexstatDAO(ISexStatDAO dbwysexstatDAO) {
		this.dbwysexstatDAO = dbwysexstatDAO;
	}

}
