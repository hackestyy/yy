package com.cssrc.web.action.stat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.stat.INationstatDAO;

public class NationnumcountAcademyAction extends Action {
	public NationnumcountAcademyAction() {

	}

	private INationstatDAO nationstatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		String acadname = (String) (httpServletRequest.getSession().getAttribute("acadname"));

		try {

			List tAfBookentrys = nationstatDAO.getAcademynationstat(abi_id);
			List list = new ArrayList();
			TempBean tempbean = (TempBean) tAfBookentrys.get(0);

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();

				bean = (TempBean) tAfBookentrys.get(i);

				list.add(bean);
			}

			List list4cakechart = new ArrayList();
			TempBean beanCakeM = new TempBean();
			TempBean beanCakeF = new TempBean();
			beanCakeF.setAgesegment("少数民族");
			beanCakeF.setRatio(tempbean.getFemaleratio());
			list4cakechart.add(beanCakeF);
			beanCakeM.setAgesegment("汉族");
			beanCakeM.setRatio(tempbean.getMaleratio());
			list4cakechart.add(beanCakeM);

			String title = acadname + "民族情况统计表";

			httpServletRequest.setAttribute("LIST", list);
			httpServletRequest.getSession().setAttribute("STATINFO", list4cakechart);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public INationstatDAO getNationstatDAO() {
		return nationstatDAO;
	}

	public void setNationstatDAO(INationstatDAO nationstatDAO) {
		this.nationstatDAO = nationstatDAO;
	}

}
