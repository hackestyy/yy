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
import com.cssrc.dao.stat.IGatherinfoDAO;
import com.cssrc.dao.stat.IPartystatDAO;
import com.cssrc.web.form.stat.PartystatForm;

public class PartystatAction extends Action {
	public PartystatAction() {
	}

	private IPartystatDAO partystatDAO;
	private IGatherinfoDAO gatherinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		PartystatForm form = new PartystatForm();
		List templist = partystatDAO.getPartystat();
		for (int i = 0; i < templist.size(); i++) {
			TempBean bypartystat = (TempBean) templist.get(i);
			String partyname = bypartystat.getAgesegment();
			Integer number = bypartystat.getNumber();
			Double ratio = bypartystat.getRatio();
			if (partyname.equals("�й���Ա")) {

				form.setRatio1(ratio);
				form.setNumber1(number);
			}
			if (partyname.equals("���")) {

				form.setRatio2(ratio);
				form.setNumber2(number);
			}
			if (partyname.equals("����")) {

				form.setRatio3(ratio);
				form.setNumber3(number);
			}
			if (partyname.equals("��")) {

				form.setRatio4(ratio);
				form.setNumber4(number);
			}
			if (partyname.equals("���")) {

				form.setRatio5(ratio);
				form.setNumber5(number);
			}
			if (partyname.equals("ũ����")) {

				form.setRatio6(ratio);
				form.setNumber6(number);
			}
			if (partyname.equals("�¹���")) {

				form.setRatio7(ratio);
				form.setNumber7(number);
			}
			if (partyname.equals("����ѧ��")) {

				form.setRatio8(ratio);
				form.setNumber8(number);
			}
			if (partyname.equals("̨��")) {

				form.setRatio9(ratio);
				form.setNumber9(number);
			}
			if (partyname.equals("�޵���")) {

				form.setRatio10(ratio);
				form.setNumber10(number);
			}

		}
		Integer totalpeo = gatherinfoDAO.getSysgatherinfototalpeo();
		// Integer tat5 = totalpeo - form.getNumber2() - form.getNumber3() -
		// form.getNumber4() - form.getNumber5() - form.getNumber6() -
		// form.getNumber7() - form.getNumber8() - form.getNumber9() -
		// form.getNumber10();
		// form.setNumber5(tat5);

		// С������
		Integer iPartpeo = form.getNumber2() + form.getNumber3() + form.getNumber4() + form.getNumber5() + form.getNumber6() + form.getNumber7() + form.getNumber8() + form.getNumber9();

		// �ܼ�����
		Integer iTotalpeo = form.getNumber1() + form.getNumber10() + iPartpeo;
		// С�Ʊ���
		Double iPartpeo_t = Double.valueOf(iPartpeo);
		Double iTotalpeo_t = Double.valueOf(iTotalpeo);
		Double dRatio_t;
		Double dTotalRatio;
		// ������ĸΪ0
		if (iTotalpeo_t == 0.00) {
			dRatio_t = 0.00;
		} else {
			dRatio_t = iPartpeo_t / iTotalpeo_t * 100;
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		String stemp = df.format(dRatio_t);
		Double dPartRatio = Double.valueOf(stemp);
		// �ܼƱ���
		if (iTotalpeo_t == 0.00) {
			dTotalRatio = 0.00;
		} else {
			dTotalRatio = 100.00;// ��Ϊ�趨100%
		}

		form.setNumber11(iPartpeo);
		form.setRatio11(dPartRatio);
		form.setNumber12(iTotalpeo);
		form.setRatio12(dTotalRatio);

		// ����һ��Ϊ������ϴ�Dao��õ�List����Ŀ����ʹ��С��һ����list�ĵڶ��г��֣��Ա�д��Excel
		TempBean tempbean2 = new TempBean();
		tempbean2.setAgesegment("С��");
		tempbean2.setNumber(iPartpeo);
		tempbean2.setRatio(dPartRatio);

		TempBean tempbean12 = new TempBean();
		tempbean12.setAgesegment("�ϼ�");
		tempbean12.setNumber(iTotalpeo);
		tempbean12.setRatio(dTotalRatio);

		TempBean tempbean1 = (TempBean) (templist.size() <= 0 ? null : templist.get(0));
		TempBean tempbean3 = (TempBean) (templist.size() <= 1 ? null : templist.get(1));
		TempBean tempbean4 = (TempBean) (templist.size() <= 2 ? null : templist.get(2));
		TempBean tempbean5 = (TempBean) (templist.size() <= 3 ? null : templist.get(3));
		TempBean tempbean6 = (TempBean) (templist.size() <= 4 ? null : templist.get(4));
		TempBean tempbean7 = (TempBean) (templist.size() <= 5 ? null : templist.get(5));
		TempBean tempbean8 = (TempBean) (templist.size() <= 6 ? null : templist.get(6));
		TempBean tempbean9 = (TempBean) (templist.size() <= 7 ? null : templist.get(7));
		TempBean tempbean10 = (TempBean) (templist.size() <= 8 ? null : templist.get(8));
		TempBean tempbean11 = (TempBean) (templist.size() <= 9 ? null : templist.get(9));

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

		// httpServletRequest.setAttribute("LIST",templist);
		httpServletRequest.setAttribute("partystatForm", form);
		httpServletRequest.getSession().setAttribute("STATINFO", templist);
		httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
		httpServletRequest.getSession().setAttribute("STAT_TITLE", "�����п�Э��Ա������òͳ�Ʊ�");

		return actionMapping.findForward("success");
	}

	public IPartystatDAO getPartystatDAO() {
		return partystatDAO;
	}

	public void setPartystatDAO(IPartystatDAO partystatDAO) {
		this.partystatDAO = partystatDAO;
	}

	public IGatherinfoDAO getGatherinfoDAO() {
		return gatherinfoDAO;
	}

	public void setGatherinfoDAO(IGatherinfoDAO gatherinfoDAO) {
		this.gatherinfoDAO = gatherinfoDAO;
	}

}