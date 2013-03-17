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
import com.cssrc.dao.stat.IRankstatDAO;

public class AcademyRankStatAction extends Action {
	public AcademyRankStatAction() {

	}

	private IRankstatDAO rankstatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		String acadname = (String) (httpServletRequest.getSession().getAttribute("acadname"));

		try {

			List tAfBookentrys = rankstatDAO.getAcademyrankstat(abi_id);
			List list = new ArrayList();
			List templist = new ArrayList();
			Integer totalpeo = 0;

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();

				bean = (TempBean) tAfBookentrys.get(i);
				totalpeo = totalpeo + bean.getNumber();

				bean.setSerialnumber(i + 1);
				list.add(bean);
				templist.add(bean);
			}

			TempBean tempbean = new TempBean();
			tempbean.setAgesegment("合计");
			tempbean.setNumber(totalpeo);

			if (totalpeo == 0) {
				tempbean.setRatio(0.00);// 总人数为0时，设定0%
			} else {
				tempbean.setRatio(100.00);// 人为设定100%
			}

			templist.add(tempbean);

			String title = acadname + "技术职称情况统计表";

			httpServletRequest.setAttribute("LIST", templist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", templist);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IRankstatDAO getRankstatDAO() {
		return rankstatDAO;
	}

	public void setRankstatDAO(IRankstatDAO rankstatDAO) {
		this.rankstatDAO = rankstatDAO;
	}

}
