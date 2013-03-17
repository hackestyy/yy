package com.cssrc.web.action.download;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.bean.admin.Smemberacademicliterature;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.bean.admin.Smemberdeputyinfo;
import com.cssrc.bean.admin.Smemberpastjob;
import com.cssrc.bean.admin.Smemberpatentinfo;
import com.cssrc.bean.admin.Smemberresearchproduction;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberacademicliteratureDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.dao.admin.ISmemberdeputyinfoDAO;
import com.cssrc.dao.admin.ISmemberpastjobDAO;
import com.cssrc.dao.admin.ISmemberpatentinfoDAO;
import com.cssrc.dao.admin.ISmemberresearchproductionDAO;
import com.cssrc.util.Number2Duty;
import com.cssrc.util.WriteExcel;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class PersonInfoDownloadAction extends Action {
	public PersonInfoDownloadAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private ISmemberdeputyinfoDAO smemberdeputyinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;
	private ISmemberpastjobDAO smemberpastjobDAO;
	private ISmemberresearchproductionDAO smemberresearchproductionDAO;
	private ISmemberacademicliteratureDAO smemberacademicliteratureDAO;
	private ISmemberpatentinfoDAO smemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		try {
			Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
			User user = (User) httpServletRequest.getSession().getAttribute("USER");

			ServletContext m_application = this.getServlet().getServletContext();
			String UPath = m_application.getRealPath("/") + "download" + "\\T_PERSONINFO.xls";
			;
			String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";

			// 会员基本信息处理
			Smemberbaseinfo smemberbaseinfo = new Smemberbaseinfo();
			smemberbaseinfo = smemberbaseinfoDAO.getSmemberbaseinfo(smbi_id);

			// 主要社会职务合并至一个字段 if...else...去掉null
			String sociaDuty1 = smemberbaseinfo.getSocialduty1();
			sociaDuty1 = Mutil2One(sociaDuty1);
			String sociaDuty2 = smemberbaseinfo.getSocialduty2();
			sociaDuty2 = Mutil2One(sociaDuty2);
			String sociaDuty3 = smemberbaseinfo.getSocialduty3();
			sociaDuty3 = Mutil2One(sociaDuty3);
			String sociaDuty4 = smemberbaseinfo.getSocialduty4();
			sociaDuty4 = Mutil2One(sociaDuty4);
			String sociaDuty5 = smemberbaseinfo.getSocialduty5();
			sociaDuty5 = Mutil2One(sociaDuty5);
			String sociaDuty6 = smemberbaseinfo.getSocialduty6();
			sociaDuty6 = Mutil2One(sociaDuty6);
			String sociaDuty7 = smemberbaseinfo.getSocialduty7();
			sociaDuty7 = Mutil2One(sociaDuty7);
			String sociaDuty8 = smemberbaseinfo.getSocialduty8();
			sociaDuty8 = Mutil2One(sociaDuty8);
			String sociaDuty = sociaDuty1 + sociaDuty2 + sociaDuty3 + sociaDuty4 + sociaDuty5 + sociaDuty6 + sociaDuty7 + sociaDuty8;
			smemberbaseinfo.setSocialduty1(sociaDuty);

			// 主要社会荣誉合并至一个字段
			String sociaHonour1 = smemberbaseinfo.getSocialhonour1();
			sociaHonour1 = Mutil2One(sociaHonour1);
			String sociaHonour2 = smemberbaseinfo.getSocialhonour2();
			sociaHonour2 = Mutil2One(sociaHonour2);
			String sociaHonour3 = smemberbaseinfo.getSocialhonour3();
			sociaHonour3 = Mutil2One(sociaHonour3);
			String sociaHonour4 = smemberbaseinfo.getSocialhonour4();
			sociaHonour4 = Mutil2One(sociaHonour4);
			String sociaHonour5 = smemberbaseinfo.getSocialhonour5();
			sociaHonour5 = Mutil2One(sociaHonour5);
			String sociaHonour6 = smemberbaseinfo.getSocialhonour6();
			sociaHonour6 = Mutil2One(sociaHonour6);
			String sociaHonour7 = smemberbaseinfo.getSocialhonour7();
			sociaHonour7 = Mutil2One(sociaHonour7);
			String sociaHonour8 = smemberbaseinfo.getSocialhonour8();
			sociaHonour8 = Mutil2One(sociaHonour8);
			String sociaHonour9 = smemberbaseinfo.getSocialhonour9();
			sociaHonour9 = Mutil2One(sociaHonour9);
			String sociaHonour10 = smemberbaseinfo.getSocialhonour10();
			sociaHonour10 = Mutil2One(sociaHonour10);
			String sociaHonour11 = smemberbaseinfo.getSocialhonour11();
			sociaHonour11 = Mutil2One(sociaHonour11);
			String sociaHonour12 = smemberbaseinfo.getSocialhonour12();
			sociaHonour12 = Mutil2One(sociaHonour12);
			String sociaHonour13 = smemberbaseinfo.getSocialhonour13();
			sociaHonour13 = Mutil2One(sociaHonour13);
			String sociaHonour14 = smemberbaseinfo.getSocialhonour14();
			sociaHonour14 = Mutil2One(sociaHonour14);
			String sociaHonour15 = smemberbaseinfo.getSocialhonour15();
			sociaHonour15 = Mutil2One(sociaHonour15);
			String sociaHonour16 = smemberbaseinfo.getSocialhonour16();
			sociaHonour16 = Mutil2One(sociaHonour16);
			String sociaHonour17 = smemberbaseinfo.getSocialhonour17();
			sociaHonour17 = Mutil2One(sociaHonour17);
			String sociaHonour18 = smemberbaseinfo.getSocialhonour18();
			sociaHonour18 = Mutil2One(sociaHonour18);
			String sociaHonour19 = smemberbaseinfo.getSocialhonour19();
			sociaHonour19 = Mutil2One(sociaHonour19);
			String sociaHonour20 = smemberbaseinfo.getSocialhonour20();
			sociaHonour20 = Mutil2One(sociaHonour20);
			String sociaHonour = sociaHonour1 + sociaHonour2 + sociaHonour3 + sociaHonour4 + sociaHonour5 + sociaHonour6 + sociaHonour7 + sociaHonour8 + sociaHonour9 + sociaHonour10 + sociaHonour11 + sociaHonour12 + sociaHonour13 + sociaHonour14 + sociaHonour15 + sociaHonour16 + sociaHonour17 + sociaHonour18 + sociaHonour19 + sociaHonour20;
			smemberbaseinfo.setSocialhonour1(sociaHonour);

			// 文体活动合并至一个字段
			String sports1 = smemberbaseinfo.getSports1();
			sports1 = Mutil2One(sports1);
			String sports2 = smemberbaseinfo.getSports2();
			sports2 = Mutil2One(sports2);
			String sports3 = smemberbaseinfo.getSports3();
			sports3 = Mutil2One(sports3);
			String sports4 = smemberbaseinfo.getSports4();
			sports4 = Mutil2One(sports4);
			String sports5 = smemberbaseinfo.getSports5();
			sports5 = Mutil2One(sports5);
			String sports6 = smemberbaseinfo.getSports6();
			sports6 = Mutil2One(sports6);
			String sports7 = smemberbaseinfo.getSports7();
			sports7 = Mutil2One(sports7);
			String sports8 = smemberbaseinfo.getSports8();
			sports8 = Mutil2One(sports8);
			String sports = sports1 + sports2 + sports3 + sports4 + sports5 + sports6 + sports7 + sports8;
			smemberbaseinfo.setSports1(sports);

			// 参加国际社团及任职合并至一个字段
			String interDuty = smemberbaseinfo.getInterduty_s();
			if (interDuty.equals("是")) {
				smemberbaseinfo.setInterduty_s(smemberbaseinfo.getInterduty_f());
			}

			// 参加国内社团及任职合并至一个字段
			String nationDuty = smemberbaseinfo.getNationduty_s();
			if (nationDuty.equals("是")) {
				smemberbaseinfo.setNationduty_s(smemberbaseinfo.getNationduty_f());
			}

			// 职称合并至一个字段
			String rank = smemberbaseinfo.getMemrank_s() + " " + smemberbaseinfo.getMemrank_f();
			smemberbaseinfo.setMemrank_s(rank);

			// 民族合并成一个字段
			String nation = smemberbaseinfo.getMemnation_s();
			if (nation.equals("少数民族")) {
				smemberbaseinfo.setMemnation_s(smemberbaseinfo.getMemnation_f());
			}
			// 党派合并成一个字段
			String party = smemberbaseinfo.getMemparty_s();
			if (party.equals("民主党派")) {
				smemberbaseinfo.setMemparty_s(smemberbaseinfo.getMemparty_f());
			}
			// 国籍合并成一个字段
			String nationality = smemberbaseinfo.getMemnationality_s();
			if (nationality.equals("外国籍")) {
				smemberbaseinfo.setMemnationality_s(smemberbaseinfo.getMemnationality_f());
			}

			// 转换数字到具体的代表委员职务信息
			String assoduty_f = smemberbaseinfo.getAssoduty_f();
			String assoduty_s = smemberbaseinfo.getAssoduty_s();
			if (assoduty_f != null && !assoduty_f.equals("")) {
				assoduty_f = Number2Duty.Number2Duty(assoduty_f);
				smemberbaseinfo.setAssoduty_f(assoduty_f);
			}
			if (assoduty_s != null && !assoduty_s.equals("")) {
				assoduty_s = "第" + assoduty_s + "届";
				smemberbaseinfo.setAssoduty_s(assoduty_s);
			}
			if (assoduty_f == null || assoduty_f.equals("")) {
				smemberbaseinfo.setAssoduty_f("无");
			}
			if (assoduty_s == null || assoduty_s.equals("")) {
				smemberbaseinfo.setAssoduty_s("无");
			}

			// 曾任代表委员记录处理
			List list = new ArrayList();
			List dbwylist = new ArrayList();
			list = smemberdeputyinfoDAO.findSmemberdeputyinfoList(smbi_id);
			if (list.size() == 0) {
				Smemberdeputyinfo smemberdeputyinfo = new Smemberdeputyinfo();
				smemberdeputyinfo.setAssoduty_s("无");
				smemberdeputyinfo.setAssoduty_f("无");
				dbwylist.add(smemberdeputyinfo);
			}
			for (int i = 0; i < list.size(); i++) {
				Smemberdeputyinfo smemberdeputyinfo = new Smemberdeputyinfo();
				smemberdeputyinfo = (Smemberdeputyinfo) list.get(i);
				// 转换数字到具体的代表委员职务信息
				String assoduty_f_history = smemberdeputyinfo.getAssoduty_f();
				if (assoduty_f_history != null && !assoduty_f_history.equals("")) {
					assoduty_f_history = Number2Duty.Number2Duty(assoduty_f_history);
					smemberdeputyinfo.setAssoduty_f(assoduty_f_history);
				}
				if (assoduty_f_history == null || assoduty_f_history.equals("")) {
					smemberdeputyinfo.setAssoduty_f("无");
				}
				// 加"第x届"的字样
				String assoduty_s_history = smemberdeputyinfo.getAssoduty_s();
				if (assoduty_s_history != null && !assoduty_s_history.equals("")) {
					assoduty_s_history = "第" + assoduty_s_history + "届";
					smemberdeputyinfo.setAssoduty_s(assoduty_s_history);
				}
				if (assoduty_s_history == null || assoduty_s_history.equals("")) {
					smemberdeputyinfo.setAssoduty_s("无");
				}
				dbwylist.add(smemberdeputyinfo);
			}

			// 参加学会信息
			List list2 = new ArrayList();
			List academysmemberList = new ArrayList();
			list2 = academysmemberrelationDAO.gainAcademysmemberrelaNODEL(smbi_id);

			if (list2.size() == 0) {
				Academysmemberrelation academysmemberrelation = new Academysmemberrelation();
				academysmemberrelation.setMemtype(" ");
				academysmemberrelation.setIsannualregister(" ");
				academysmemberrelation.setBelongcommittee1(" ");
				academysmemberrelation.setAcademyduty1(" ");
				academysmemberList.add(academysmemberrelation);
			}
			for (int i = 0; i < list2.size(); i++) {
				Academysmemberrelation academysmemberrelation = new Academysmemberrelation();
				academysmemberrelation = (Academysmemberrelation) list2.get(i);

				String belongcommittee1 = academysmemberrelation.getBelongcommittee1();
				belongcommittee1 = Mutil2One(belongcommittee1);
				String belongcommittee2 = academysmemberrelation.getBelongcommittee2();
				belongcommittee2 = Mutil2One(belongcommittee2);
				String belongcommittee3 = academysmemberrelation.getBelongcommittee3();
				belongcommittee3 = Mutil2One(belongcommittee3);
				String belongcommittee4 = academysmemberrelation.getBelongcommittee4();
				belongcommittee4 = Mutil2One(belongcommittee4);
				String belongcommittee = belongcommittee1 + belongcommittee2 + belongcommittee3 + belongcommittee4;
				academysmemberrelation.setBelongcommittee1(belongcommittee);

				String academyduty1 = academysmemberrelation.getAcademyduty1();
				academyduty1 = Mutil2One(academyduty1);
				String academyduty2 = academysmemberrelation.getAcademyduty2();
				academyduty2 = Mutil2One(academyduty2);
				String academyduty3 = academysmemberrelation.getAcademyduty3();
				academyduty3 = Mutil2One(academyduty3);
				String academyduty4 = academysmemberrelation.getAcademyduty4();
				academyduty4 = Mutil2One(academyduty4);
				String academyduty5 = academysmemberrelation.getAcademyduty5();
				academyduty5 = Mutil2One(academyduty5);
				String academyduty6 = academysmemberrelation.getAcademyduty6();
				academyduty6 = Mutil2One(academyduty6);
				String academyduty7 = academysmemberrelation.getAcademyduty7();
				academyduty7 = Mutil2One(academyduty7);
				String academyduty8 = academysmemberrelation.getAcademyduty8();
				academyduty8 = Mutil2One(academyduty8);
				String academyduty9 = academysmemberrelation.getAcademyduty9();
				academyduty9 = Mutil2One(academyduty9);
				String academyduty10 = academysmemberrelation.getAcademyduty10();
				academyduty10 = Mutil2One(academyduty10);
				String academyduty11 = academysmemberrelation.getAcademyduty11();
				academyduty11 = Mutil2One(academyduty11);
				String academyduty = academyduty1 + academyduty2 + academyduty3 + academyduty4 + academyduty5 + academyduty6 + academyduty7 + academyduty8 + academyduty9 + academyduty10 + academyduty11;
				academysmemberrelation.setAcademyduty1(academyduty);

				academysmemberList.add(academysmemberrelation);
			}

			// 主要工作经历
			List list3 = new ArrayList();
			List smemberpastjobList = new ArrayList();
			list3 = smemberpastjobDAO.gainSmemberpastjob(smbi_id);
			if (list3.size() == 0) {
				Smemberpastjob smemberpastjob = new Smemberpastjob();
				smemberpastjob.setJobaddress(" ");
				smemberpastjob.setJobinstitute(" ");
				smemberpastjob.setJobrank(" ");
				smemberpastjobList.add(smemberpastjob);
			} else {
				smemberpastjobList = list3;
			}

			// 科研
			List list4 = new ArrayList();
			List resProList = new ArrayList();
			list4 = smemberresearchproductionDAO.gainSmemberresearchproduction(smbi_id);
			if (list4.size() == 0) {
				Smemberresearchproduction smemresprobean = new Smemberresearchproduction();
				smemresprobean.setProdapplication(" ");
				smemresprobean.setProdname(" ");
				smemresprobean.setProdrewards(" ");
				resProList.add(smemresprobean);
			} else {
				resProList = list4;
				/*
				 * for(int i=0; i<list4.size(); i++) { Smemberresearchproduction
				 * smemresprobean = new Smemberresearchproduction();
				 * smemresprobean = (Smemberresearchproduction)list4.get(0);
				 * //这里借用smbi_id作为序号列 smemresprobean.setSmbi_id(i+1);
				 * resProList.add(smemresprobean); }
				 */
			}

			// 论著
			List list5 = new ArrayList();
			List acadLiteraList = new ArrayList();
			list5 = smemberacademicliteratureDAO.gainSmemberacademicliterature(smbi_id);
			if (list5.size() == 0) {
				Smemberacademicliterature smemacadlitera = new Smemberacademicliterature();
				smemacadlitera.setLitehouse(" ");
				smemacadlitera.setLitejournal(" ");
				smemacadlitera.setLitename(" ");
				acadLiteraList.add(smemacadlitera);
			} else {
				acadLiteraList = list5;
			}

			// 专利
			List list6 = new ArrayList();
			List patentList = new ArrayList();
			list6 = smemberpatentinfoDAO.gainSmemberpatentinfo(smbi_id);
			if (list6.size() == 0) {
				Smemberpatentinfo patentinfobean = new Smemberpatentinfo();
				patentinfobean.setPatentisindustrialized(" ");
				patentinfobean.setPatentname(" ");
				patentinfobean.setPatenttype(" ");
				patentinfobean.setPatentvalue(" ");
				patentList.add(patentinfobean);
			} else {
				patentList = list6;
			}

			WriteExcel writeExcel = new WriteExcel(smemberbaseinfo, dbwylist, academysmemberList, smemberpastjobList, resProList, acadLiteraList, patentList, UPath, outputFile);

			SmartUpload smartupload = new SmartUpload();
			javax.servlet.ServletConfig servletconfig = this.getServlet().getServletConfig();
			try {
				smartupload.initialize(servletconfig, httpServletRequest, httpServletResponse);
			} catch (ServletException ex) {
			}
			try {
				smartupload.setContentDisposition(null);
				Thread.sleep(1000);
				smartupload.downloadFile(outputFile);
			} catch (SmartUploadException ex1) {
			} catch (IOException ex1) {
			} catch (ServletException ex1) {
			} catch (Exception ex1) {
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return actionMapping.findForward("failure");

		}

		return null;

	}

	public String Mutil2One(String string)// 将多个字段合并成一个字符串
	{
		if (string != null) {
			string = string + "  ";
		} else {
			string = "";
		}
		return string;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public ISmemberpatentinfoDAO getSmemberpatentinfoDAO() {
		return smemberpatentinfoDAO;
	}

	public void setSmemberpatentinfoDAO(ISmemberpatentinfoDAO smemberpatentinfoDAO) {
		this.smemberpatentinfoDAO = smemberpatentinfoDAO;
	}

	public ISmemberacademicliteratureDAO getSmemberacademicliteratureDAO() {
		return smemberacademicliteratureDAO;
	}

	public void setSmemberacademicliteratureDAO(ISmemberacademicliteratureDAO smemberacademicliteratureDAO) {
		this.smemberacademicliteratureDAO = smemberacademicliteratureDAO;
	}

	public ISmemberpastjobDAO getSmemberpastjobDAO() {
		return smemberpastjobDAO;
	}

	public void setSmemberpastjobDAO(ISmemberpastjobDAO smemberpastjobDAO) {
		this.smemberpastjobDAO = smemberpastjobDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public ISmemberdeputyinfoDAO getSmemberdeputyinfoDAO() {
		return smemberdeputyinfoDAO;
	}

	public void setSmemberdeputyinfoDAO(ISmemberdeputyinfoDAO smemberdeputyinfoDAO) {
		this.smemberdeputyinfoDAO = smemberdeputyinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public ISmemberresearchproductionDAO getSmemberresearchproductionDAO() {
		return smemberresearchproductionDAO;
	}

	public void setSmemberresearchproductionDAO(ISmemberresearchproductionDAO smemberresearchproductionDAO) {
		this.smemberresearchproductionDAO = smemberresearchproductionDAO;
	}

}
