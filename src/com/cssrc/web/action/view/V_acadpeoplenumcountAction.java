package com.cssrc.web.action.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.view.IV_peoplenumcountDAO;
import com.cssrc.util.DateUtil;

public class V_acadpeoplenumcountAction extends Action {

	public V_acadpeoplenumcountAction() {

	}

	private IV_peoplenumcountDAO v_peoplenumcountDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer shai_id = (Integer) (httpServletRequest.getSession().getAttribute("shai_id"));
		String assoname = (String) (httpServletRequest.getSession().getAttribute("academybaseinfoassoname"));
		String title = assoname + "人数分类统计表";
		try {

			List tAfBookentrys = v_peoplenumcountDAO.getAcadPeopleNumCount(shai_id);
			List list = new ArrayList();
			List templist = new ArrayList();
			Integer totalpeo = 0;
			Integer yearnumall = 0;
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();
				bean = (TempBean) tAfBookentrys.get(i);
				totalpeo = totalpeo + bean.getCountshai_id();
				bean.setSerialnumber(i + 1);
				// 统计当年加入的会员
				List datelist = new ArrayList();
				String sql = "where abi_id=" + bean.getAbi_id();
				datelist = academysmemberrelationDAO.list(sql);
				String timenow = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy");
				int yearnum = 0;
				for (int j = 0; j < datelist.size(); j++) {
					String basetime = null;
					Academysmemberrelation baseform2 = new Academysmemberrelation();
					baseform2 = (Academysmemberrelation) datelist.get(j);
					if (baseform2.getJoindate() != null) {
						basetime = DateUtil.getDateString(baseform2.getJoindate(), "yyyy");

						if (basetime.equals(timenow)) {
							yearnum++;
						}
					}
				}
				yearnumall = yearnumall + yearnum;
				bean.setNumber(yearnum);
				list.add(bean);
				templist.add(bean);
			}
			TempBean tempbean = new TempBean();
			tempbean.setAssoname("合计");
			tempbean.setCountshai_id(totalpeo);
			tempbean.setNumber(yearnumall);
			templist.add(tempbean);
			httpServletRequest.setAttribute("LIST", templist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", templist);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IV_peoplenumcountDAO getV_peoplenumcountDAO() {
		return v_peoplenumcountDAO;
	}

	public void setV_peoplenumcountDAO(IV_peoplenumcountDAO v_peoplenumcountdao) {
		v_peoplenumcountDAO = v_peoplenumcountdao;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
