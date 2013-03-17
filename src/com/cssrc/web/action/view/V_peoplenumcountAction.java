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

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.view.IV_peoplenumcountDAO;
import com.cssrc.util.DateUtil;

public class V_peoplenumcountAction extends Action {
	public V_peoplenumcountAction() {

	}

	private IV_peoplenumcountDAO v_peoplenumcountDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {

			List tAfBookentrys = v_peoplenumcountDAO.getPeopleNumCount();
			List list = new ArrayList();
			List templist = new ArrayList();
			Integer totalpeo = 0;
			Integer newyearnum = 0;
			Integer peoplepurenumcount = v_peoplenumcountDAO.getPeoplePureNumCount();// 净人数
			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();
				bean = (TempBean) tAfBookentrys.get(i);
				totalpeo = totalpeo + bean.getCountshai_id();
				bean.setSerialnumber(i + 1);

				// 统计当年加入的会员
				List datelist = new ArrayList();
				datelist = v_peoplenumcountDAO.listalltime(bean.getShai_id());
				String timenow = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy");
				int yearnum = 0;
				for (int j = 0; j < datelist.size(); j++) {
					String basetime = null;
					TempBean baseform2 = new TempBean();
					baseform2 = (TempBean) datelist.get(j);
					if (baseform2.getJoindate() != null) {
						basetime = DateUtil.getDateString(baseform2.getJoindate(), "yyyy");

						if (basetime.equals(timenow)) {
							yearnum++;
						}
					}
				}
				bean.setNumber(yearnum);
				newyearnum = newyearnum + yearnum;
				list.add(bean);
				templist.add(bean);
			}
			TempBean tempbean = new TempBean();
			tempbean.setAssoname("合计");
			tempbean.setCountshai_id(totalpeo);
			tempbean.setNumber(newyearnum);
			templist.add(tempbean);

			// 净人数
			TempBean tempbean2 = new TempBean();
			tempbean2.setAssoname("市科协学会会员净人数");
			tempbean2.setCountshai_id(peoplepurenumcount);
			templist.add(tempbean2);

			httpServletRequest.setAttribute("LIST", templist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", templist);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", "宁波市科协会员人数分类统计表");

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

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
