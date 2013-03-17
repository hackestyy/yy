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
import com.cssrc.dao.stat.INationalityDAO;

;

public class NationalitynumcountAction extends Action {

	public NationalitynumcountAction() {

	}

	private INationalityDAO nationalityDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {

			List tAfBookentrys = nationalityDAO.getSysnationalitystat();
			List list = new ArrayList();
			List templist = new ArrayList();

			Integer totalpeo = 0;
			Integer totalmalepeo = 0;
			Integer totalfemalepeo = 0;
			Double totalmalepeoRatio = 0.00;
			Double totalfemalepeoRatio = 0.00;

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();

				bean = (TempBean) tAfBookentrys.get(i);

				totalpeo = totalpeo + bean.getCountshai_id();
				totalmalepeo = totalmalepeo + bean.getMale();
				totalfemalepeo = totalfemalepeo + bean.getFemale();
				bean.setSerialnumber(i + 1);
				list.add(bean);
				templist.add(bean);
			}

			TempBean tempbean = new TempBean();
			// 转换成double型的才能相除后任为double型
			Double totalmalepeo_t = Double.valueOf(totalmalepeo);
			Double totalpeo_t = Double.valueOf(totalpeo);
			Double dRatioMale;
			Double dRatioFemale;

			// 避免学会人数为0时，分母为0带来的异常
			if (totalpeo_t == 0) {
				dRatioMale = 0.00;
			} else {
				dRatioMale = Double.valueOf((totalmalepeo_t / totalpeo_t) * 100);
			}
			java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
			String stemp = df.format(dRatioMale);
			totalmalepeoRatio = Double.valueOf(stemp);

			// 避免学会人数为0时，分母为0带来的异常
			if (totalpeo_t == 0) {
				dRatioFemale = 0.00;
			} else {
				dRatioFemale = 100 - totalmalepeoRatio;
			}

			java.text.DecimalFormat df2 = new java.text.DecimalFormat("0.00");
			String stemp2 = df2.format(dRatioFemale);
			totalfemalepeoRatio = Double.valueOf(stemp2);

			tempbean.setAssoname("合计");
			tempbean.setCountshai_id(totalpeo);
			tempbean.setMale(totalmalepeo);
			tempbean.setMaleratio(totalmalepeoRatio);
			tempbean.setFemale(totalfemalepeo);
			tempbean.setFemaleratio(totalfemalepeoRatio);

			templist.add(tempbean);

			httpServletRequest.setAttribute("LIST", templist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", templist);
			httpServletRequest.getSession().setAttribute("STATINFO", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", "宁波市科协会员国籍情况统计表");

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public INationalityDAO getNationalityDAO() {
		return nationalityDAO;
	}

	public void setNationalityDAO(INationalityDAO nationalityDAO) {
		this.nationalityDAO = nationalityDAO;
	}

}
