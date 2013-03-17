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
import com.cssrc.dao.stat.dbwy.IScholarStatDAO;

public class ScholarStatAllAction extends Action {
	private IScholarStatDAO dbwyscholarstatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoduty_s = (String) (httpServletRequest.getSession().getAttribute("assoduty_s"));

		try {
			List tAfBookentrys = dbwyscholarstatDAO.getAllScholarStat(assoduty_s);
			List list = new ArrayList();
			List templist = new ArrayList();
			Integer totalpeo = 0;

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();

				bean = (TempBean) tAfBookentrys.get(i);
				totalpeo = totalpeo + bean.getNumber();

				bean.setSerialnumber(i + 1);
				bean.setAssoduty_f("全体代表");
				bean.setAssoduty_s(Integer.valueOf(assoduty_s));
				list.add(bean);
				templist.add(bean);
			}

			TempBean tempbean = new TempBean();
			tempbean.setAgesegment("合计");
			tempbean.setAssoduty_f("全体代表");
			tempbean.setAssoduty_s(Integer.valueOf(assoduty_s));
			tempbean.setNumber(totalpeo);
			if (totalpeo == 0) {
				tempbean.setRatio(0.00);// 总人数为0时，设定0%
			} else {
				tempbean.setRatio(100.00);// 人为设定100%
			}
			templist.add(tempbean);

			String title = "第" + assoduty_s + "届" + "全体代表" + "学历情况统计表";

			httpServletRequest.setAttribute("LIST", templist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", templist);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public IScholarStatDAO getDbwyscholarstatDAO() {
		return dbwyscholarstatDAO;
	}

	public void setDbwyscholarstatDAO(IScholarStatDAO dbwyscholarstatDAO) {
		this.dbwyscholarstatDAO = dbwyscholarstatDAO;
	}

}
