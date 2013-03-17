package com.cssrc.web.action.stat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.stat.IGroupStatDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.stat.PartystatForm;

public class GroupStatAction extends Action {
	public GroupStatAction() {
	}

	private IGroupStatDAO groupstatDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		String acadname = (String) (httpServletRequest.getSession().getAttribute("acadname"));

		PartystatForm form = new PartystatForm();
		List baselist = new ArrayList();
		baselist = academybaseinfoDAO.findAcademybaseinfo(abi_id);
		Academybaseinfo baseform = (Academybaseinfo) baselist.get(0);

		List templist = groupstatDAO.getAcademygroupstat(abi_id);
		for (int i = 0; i < templist.size(); i++) {
			TempBean bypartystat = (TempBean) templist.get(i);
			String partyname = bypartystat.getAgesegment();
			Integer number = bypartystat.getNumber();
			Double ratio = bypartystat.getRatio();
			if (partyname.equals("国有企（事）业")) {

				form.setRatio1(ratio);
				form.setNumber1(number);
			}
			if (partyname.equals("科研机构")) {

				form.setRatio2(ratio);
				form.setNumber2(number);
			}
			if (partyname.equals("高等院校")) {

				form.setRatio3(ratio);
				form.setNumber3(number);
			}
			if (partyname.equals("有限责任公司")) {

				form.setRatio4(ratio);
				form.setNumber4(number);
			}
			if (partyname.equals("股份有限公司")) {

				form.setRatio5(ratio);
				form.setNumber5(number);
			}
			if (partyname.equals("三资企业")) {

				form.setRatio6(ratio);
				form.setNumber6(number);
			}
			if (partyname.equals("集体企业")) {

				form.setRatio7(ratio);
				form.setNumber7(number);
			}
			if (partyname.equals("私营（民营）企业")) {

				form.setRatio8(ratio);
				form.setNumber8(number);
			}
			if (partyname.equals("其他")) {

				form.setRatio9(ratio);
				form.setNumber9(number);
			}
		}

		form.setAcadeid(baseform.getAcadno());
		form.setAcadename(baseform.getAcadname());

		// 统计当年加入的团体会员
		List datelist = new ArrayList();
		String sql = "where abi_id=" + abi_id;
		datelist = academygmemberrelationDAO.list(sql);
		String timenow = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy");
		int yearnum = 0;
		for (int i = 0; i < datelist.size(); i++) {
			String basetime = null;
			Academygmemberrelation baseform2 = new Academygmemberrelation();
			baseform2 = (Academygmemberrelation) datelist.get(i);
			if (baseform2.getJoindate() != null) {
				basetime = DateUtil.getCalendarString(baseform2.getJoindate(), "yyyy");
				if (basetime.equals(timenow)) {
					yearnum++;
				}
			}
		}
		form.setNumber11(yearnum);

		// 总数
		Integer iPartpeo = form.getNumber1() + form.getNumber2() + form.getNumber3() + form.getNumber4() + form.getNumber5() + form.getNumber6() + form.getNumber7() + form.getNumber8() + form.getNumber9();

		// 小计比例
		Double iPartpeo_t = Double.valueOf(iPartpeo);
		Double dRatio_t;
		// 除法分母为0
		if (iPartpeo_t == 0.00) {
			dRatio_t = 0.00;
		} else {
			dRatio_t = iPartpeo_t / iPartpeo_t * 100;
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		String stemp = df.format(dRatio_t);
		Double dPartRatio = Double.valueOf(stemp);

		form.setNumber10(iPartpeo);
		form.setRatio10(dPartRatio);

		TempBean tempbean0 = new TempBean();
		tempbean0.setAssoname(acadname);
		tempbean0.setNumber(iPartpeo);
		tempbean0.setCountshai_id(yearnum);
		tempbean0.setAcadno(baseform.getAcadno());

		int size = templist.size();
		int i = 0;
		TempBean def = new TempBean();
		def.setAgesegment("");
		def.setNumber(new Integer(0));
		def.setCountshai_id(new Integer(0));
		def.setAcadno("");

		TempBean tempbean1 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean2 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean3 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean4 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean5 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean6 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean7 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean8 = (TempBean) (size > i ? templist.get(i++) : def);
		TempBean tempbean9 = (TempBean) (size > i ? templist.get(i++) : def);

		List resultlist = new ArrayList();
		resultlist.add(tempbean0);
		resultlist.add(tempbean1);
		resultlist.add(tempbean2);
		resultlist.add(tempbean3);
		resultlist.add(tempbean4);
		resultlist.add(tempbean5);
		resultlist.add(tempbean6);
		resultlist.add(tempbean7);
		resultlist.add(tempbean8);
		resultlist.add(tempbean9);

		String title = acadname + "团体会员统计表";

		// httpServletRequest.setAttribute("LIST",templist);
		httpServletRequest.setAttribute("groupstatForm", form);
		httpServletRequest.getSession().setAttribute("STATINFO", templist);
		httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", resultlist);
		httpServletRequest.getSession().setAttribute("STAT_TITLE", title);

		return actionMapping.findForward("success");
	}

	public IGroupStatDAO getGroupstatDAO() {
		return groupstatDAO;
	}

	public void setGroupstatDAO(IGroupStatDAO groupstatDAO) {
		this.groupstatDAO = groupstatDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}
}
