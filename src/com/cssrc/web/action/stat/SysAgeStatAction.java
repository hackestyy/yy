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
import com.cssrc.dao.stat.IAgestatDAO;

public class SysAgeStatAction extends Action {

	public SysAgeStatAction() {

	}

	private IAgestatDAO agestatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {

			List tAfBookentrys = agestatDAO.getSysagestat();
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

			httpServletRequest.setAttribute("LIST", templist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", templist);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", "宁波市科协会员年龄情况统计表");

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IAgestatDAO getAgestatDAO() {
		return agestatDAO;
	}

	public void setAgestatDAO(IAgestatDAO agestatDAO) {
		this.agestatDAO = agestatDAO;
	}

}
