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
import com.cssrc.dao.stat.dbwy.INationStatDAO;

public class NationStatWYAction extends Action {
	private INationStatDAO dbwynationstatDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String assoduty_s = (String) (httpServletRequest.getSession().getAttribute("assoduty_s"));

		try {

			List tAfBookentrys = dbwynationstatDAO.getWYNationStat(assoduty_s);
			List list = new ArrayList();
			TempBean tempbean = (TempBean) tAfBookentrys.get(0);

			for (int i = 0; i < tAfBookentrys.size(); i++) {
				TempBean bean = new TempBean();

				bean = (TempBean) tAfBookentrys.get(i);
				bean.setAssoduty_f("ȫ��ίԱ");
				bean.setAssoduty_s(Integer.valueOf(assoduty_s));
				list.add(bean);
			}

			/*
			 * �Ա�״ͼ��ʾ ��Ҫ����Ϊlist��ת�� �� �б��� Ů Ů����
			 * ת��
			 * �� �б��� Ů Ů����
			 */
			List list4cakechart = new ArrayList();
			TempBean beanCakeM = new TempBean();
			TempBean beanCakeF = new TempBean();
			beanCakeF.setAgesegment("����");
			beanCakeF.setRatio(tempbean.getMaleratio());
			list4cakechart.add(beanCakeF);
			beanCakeM.setAgesegment("��������");
			beanCakeM.setRatio(tempbean.getFemaleratio());
			list4cakechart.add(beanCakeM);

			String title = "��" + assoduty_s + "��" + "ȫ��ίԱ" + "�������ͳ�Ʊ�";

			httpServletRequest.setAttribute("LIST", list);
			httpServletRequest.getSession().setAttribute("STATINFO", list4cakechart);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
			httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public INationStatDAO getDbwynationstatDAO() {
		return dbwynationstatDAO;
	}

	public void setDbwynationstatDAO(INationStatDAO dbwynationstatDAO) {
		this.dbwynationstatDAO = dbwynationstatDAO;
	}

}
