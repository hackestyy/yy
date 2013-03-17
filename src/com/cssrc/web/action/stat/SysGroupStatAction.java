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

import com.cssrc.bean.view.TempBean;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.stat.IGroupStatDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.GroupStatForm;
import com.cssrc.web.form.stat.PartystatForm;

public class SysGroupStatAction extends Action {
	public SysGroupStatAction() {
	}

	private IGroupStatDAO groupstatDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shai_id = (Integer) (httpServletRequest.getSession().getAttribute("shai_id"));

		PartystatForm form = new PartystatForm();
		TempBean bean = new TempBean();
		List listall = new ArrayList();
		List listinsitiute = new ArrayList();
		List listacadename = new ArrayList();
		List templist = groupstatDAO.getAllgroupstat();
		List templistname = groupstatDAO.getallgroupstatacadename();
		// List acadelist = groupstatDAO.
		for (int i = 0; i < templist.size(); i++) {
			GroupStatForm formall = new GroupStatForm();
			TempBean bypartystat = (TempBean) templist.get(i);
			String partyname = bypartystat.getAgesegment();
			Integer number = bypartystat.getNumber();
			Double ratio = bypartystat.getRatio();
			if (partyname.equals("国有企（事）业")) {

				form.setNumber1(number);
				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("国有企（事）业");
				listinsitiute.add(formall);
			}
			if (partyname.equals("科研机构")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("科研机构");
				listinsitiute.add(formall);
				form.setNumber2(number);
			}
			if (partyname.equals("高等院校")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("高等院校");
				listinsitiute.add(formall);
				form.setNumber3(number);
			}
			if (partyname.equals("有限责任公司")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("有限责任公司");
				listinsitiute.add(formall);
				form.setNumber4(number);
			}
			if (partyname.equals("股份有限公司")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("股份有限公司");
				listinsitiute.add(formall);
				form.setNumber5(number);
			}
			if (partyname.equals("三资企业")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("三资企业");
				listinsitiute.add(formall);
				form.setNumber6(number);
			}
			if (partyname.equals("集体企业")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("集体企业");
				listinsitiute.add(formall);
				form.setNumber7(number);
			}
			if (partyname.equals("私营（民营）企业")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("私营（民营）企业");
				listinsitiute.add(formall);
				form.setNumber8(number);
			}
			if (partyname.equals("其他")) {

				formall.setRatio(ratio);
				formall.setNum(number);
				formall.setName("其他");
				listinsitiute.add(formall);
				form.setNumber9(number);
			}
		}

		// 统计当年加入的团体会员
		List datelist = new ArrayList();
		datelist = groupstatDAO.list();
		String timenow = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy");
		int allnewnum = 0;
		for (int i = 0; i < templistname.size(); i++) {
			int yearnum = 0;
			GroupStatForm formall = new GroupStatForm();
			bean = (TempBean) templistname.get(i);
			int nameid = bean.getShai_id();
			for (int j = 0; j < datelist.size(); j++) {
				TempBean baseform2 = new TempBean();
				baseform2 = (TempBean) datelist.get(j);
				String basetime = DateUtil.getDateString(baseform2.getJoindate(), "yyyy");
				if (baseform2.getShai_id().equals(nameid)) {
					if (basetime.equals(timenow)) {
						yearnum++;
					}
				}
			}

			formall.setName(bean.getAgesegment());
			formall.setNum(bean.getNumber());
			formall.setNewnum(yearnum);
			listacadename.add(formall);
			allnewnum = allnewnum + yearnum;
		}
		// 总数
		GroupStatForm formaall = new GroupStatForm();
		Integer iPartpeo = form.getNumber1() + form.getNumber2() + form.getNumber3() + form.getNumber4() + form.getNumber5() + form.getNumber6() + form.getNumber7() + form.getNumber8() + form.getNumber9();
		formaall.setNewnum(allnewnum);
		formaall.setNum(iPartpeo);
		formaall.setName("合计");
		listacadename.add(formaall);

		listall.add(listinsitiute);
		listall.add(listacadename);

		/*
		 * // 小计比例 Double iPartpeo_t = Double.valueOf(iPartpeo); Double
		 * dRatio_t; // 除法分母为0 if (iPartpeo_t == 0.00) { dRatio_t = 0.00; } else
		 * { dRatio_t = iPartpeo_t / iPartpeo_t * 100; }
		 * java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		 * String stemp = df.format(dRatio_t); Double dPartRatio =
		 * Double.valueOf(stemp);
		 * form.setNumber10(iPartpeo); form.setRatio10(dPartRatio);
		 * TempBean tempbean1 = (TempBean) templist.get(0); TempBean tempbean2 =
		 * (TempBean) templist.get(1); TempBean tempbean3 = (TempBean)
		 * templist.get(2); TempBean tempbean4 = (TempBean) templist.get(3);
		 * TempBean tempbean5 = (TempBean) templist.get(4); TempBean tempbean6 =
		 * (TempBean) templist.get(5); TempBean tempbean7 = (TempBean)
		 * templist.get(6); TempBean tempbean8 = (TempBean) templist.get(7);
		 * TempBean tempbean9 = (TempBean) templist.get(8);
		 * List list = new ArrayList(); list.add(tempbean1);
		 * list.add(tempbean2); list.add(tempbean3); list.add(tempbean4);
		 * list.add(tempbean5); list.add(tempbean6); list.add(tempbean7);
		 * list.add(tempbean8); list.add(tempbean9);
		 */

		String title = "宁波科协团体会员统计表";

		// httpServletRequest.setAttribute("LIST",templist);
		// httpServletRequest.setAttribute("groupstatForm", form);
		httpServletRequest.setAttribute("templistname", templistname);
		httpServletRequest.getSession().setAttribute("listinsitiute", listinsitiute);
		httpServletRequest.getSession().setAttribute("listacadename", listacadename);
		httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", listall);
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
