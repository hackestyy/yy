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
import com.cssrc.dao.stat.dbwy.IPartyStatDAO;
import com.cssrc.web.form.stat.PartystatForm;

public class PartyStatWYAction extends Action {

	private IPartyStatDAO dbwypartystatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoduty_s = (String) (httpServletRequest.getSession().getAttribute("assoduty_s"));
		PartystatForm form = new PartystatForm();

		List templist = dbwypartystatDAO.getWYPartyStat(assoduty_s);
		for (int i = 0; i < templist.size(); i++) {
			TempBean bypartystat = (TempBean) templist.get(i);
			String partyname = bypartystat.getAgesegment();
			Integer number = bypartystat.getNumber();
			Double ratio = bypartystat.getRatio();

			if (partyname.equals("中共党员")) {
				form.setRatio1(ratio);
				form.setNumber1(number);
			}
			if (partyname.equals("民革")) {
				form.setRatio2(ratio);
				form.setNumber2(number);
			}
			if (partyname.equals("民盟")) {

				form.setRatio3(ratio);
				form.setNumber3(number);
			}
			if (partyname.equals("民建")) {

				form.setRatio4(ratio);
				form.setNumber4(number);
			}
			if (partyname.equals("民进")) {

				form.setRatio5(ratio);
				form.setNumber5(number);
			}
			if (partyname.equals("农工党")) {

				form.setRatio6(ratio);
				form.setNumber6(number);
			}
			if (partyname.equals("致公党")) {

				form.setRatio7(ratio);
				form.setNumber7(number);
			}
			if (partyname.equals("九三学社")) {

				form.setRatio8(ratio);
				form.setNumber8(number);
			}
			if (partyname.equals("台盟")) {

				form.setRatio9(ratio);
				form.setNumber9(number);
			}
			if (partyname.equals("无党派")) {

				form.setRatio10(ratio);
				form.setNumber10(number);
			}

		}

		// 小计人数
		Integer iPartpeo = form.getNumber2() + form.getNumber3() + form.getNumber4() + form.getNumber5() + form.getNumber6() + form.getNumber7() + form.getNumber8() + form.getNumber9();

		// 总计人数
		Integer iTotalpeo = form.getNumber1() + form.getNumber10() + iPartpeo;
		// 小计比例
		Double iPartpeo_t = Double.valueOf(iPartpeo);
		Double iTotalpeo_t = Double.valueOf(iTotalpeo);
		Double dRatio_t;
		Double dTotalRatio;
		// 除法分母为0
		if (iTotalpeo_t == 0.00) {
			dRatio_t = 0.00;
		} else {
			dRatio_t = iPartpeo_t / iTotalpeo_t * 100;
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		String stemp = df.format(dRatio_t);
		Double dPartRatio = Double.valueOf(stemp);
		// 总计比例
		if (iTotalpeo_t == 0.00) {
			dTotalRatio = 0.00;
		} else {
			dTotalRatio = 100.00;// 人为设定100%
		}

		form.setNumber11(iPartpeo);
		form.setRatio11(dPartRatio);
		form.setNumber12(iTotalpeo);
		form.setRatio12(dTotalRatio);

		// 以下一段为重新组合从Dao获得的List中项目次序，使得小计一项在list的第二行出现，以便写入Excel
		TempBean tempbean2 = new TempBean();
		tempbean2.setAgesegment("小计");
		tempbean2.setNumber(iPartpeo);
		tempbean2.setRatio(dPartRatio);

		TempBean tempbean12 = new TempBean();
		tempbean12.setAgesegment("合计");
		tempbean12.setNumber(iTotalpeo);
		tempbean12.setRatio(dTotalRatio);

		TempBean tempbean1 = (TempBean) templist.get(0);
		TempBean tempbean3 = (TempBean) templist.get(1);
		TempBean tempbean4 = (TempBean) templist.get(2);
		TempBean tempbean5 = (TempBean) templist.get(3);
		TempBean tempbean6 = (TempBean) templist.get(4);
		TempBean tempbean7 = (TempBean) templist.get(5);
		TempBean tempbean8 = (TempBean) templist.get(6);
		TempBean tempbean9 = (TempBean) templist.get(7);
		TempBean tempbean10 = (TempBean) templist.get(8);
		TempBean tempbean11 = (TempBean) templist.get(9);

		// WriteExcel.java会用到list的第一个中的assoduty_s和"全体代表"
		tempbean1.setAssoduty_s(Integer.valueOf(assoduty_s));
		tempbean1.setAssoduty_f("全体委员");

		List list = new ArrayList();
		list.add(tempbean1);
		list.add(tempbean2);
		list.add(tempbean3);
		list.add(tempbean4);
		list.add(tempbean5);
		list.add(tempbean6);
		list.add(tempbean7);
		list.add(tempbean8);
		list.add(tempbean9);
		list.add(tempbean10);
		list.add(tempbean11);
		list.add(tempbean12);

		String title = "第" + assoduty_s + "届" + "全体委员" + "政治面貌统计表";

		// httpServletRequest.setAttribute("LIST",templist);
		httpServletRequest.setAttribute("partystatForm", form);
		httpServletRequest.getSession().setAttribute("STATINFO", templist);
		httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
		httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		return actionMapping.findForward("success");
	}

	public IPartyStatDAO getDbwypartystatDAO() {
		return dbwypartystatDAO;
	}

	public void setDbwypartystatDAO(IPartyStatDAO dbwypartystatDAO) {
		this.dbwypartystatDAO = dbwypartystatDAO;
	}

}
