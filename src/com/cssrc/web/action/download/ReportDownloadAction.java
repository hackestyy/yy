package com.cssrc.web.action.download;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.dao.stat.ISexstatDAO;
import com.cssrc.util.WriteExcel;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class ReportDownloadAction extends Action {
	public ReportDownloadAction() {
	}

	private ISexstatDAO sexstatDAO;
	private IAcadgroupDAO acadgroupDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		List list = (List) httpServletRequest.getSession().getAttribute("STATINFO_EXCEL");
		String writeExcelClass = httpServletRequest.getParameter("writeExcelClass");

		// Excel �ļ�Ҫ��ŵ�λ�ã��ٶ��ڷ�������uploadĿ¼��
		ServletContext m_application = this.getServlet().getServletContext();
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		String tabletitle = (String) httpServletRequest.getSession().getAttribute("STAT_TITLE");
		String UPath = null;
		String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";

		if (writeExcelClass.equals("INFO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_INFO.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 4.00, 4.00, tabletitle);
		}

		if (writeExcelClass.equals("PEO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_PEO.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, tabletitle);
		}
		if (writeExcelClass.equals("ACADPEO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADPEO.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, tabletitle);
		}
		if (writeExcelClass.equals("ACADEMYPEO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADEMYPEO.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5.00, tabletitle);
		}

		if (writeExcelClass.equals("SEX")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_SEX.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 5);
		}
		if (writeExcelClass.equals("ACADSEX")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADSEX.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 5);
		}
		if (writeExcelClass.equals("ACADEMYSEX")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADEMYSEX.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 4.00, 5);
		}

		if (writeExcelClass.equals("NATION")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_NATION.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 5);
		}
		if (writeExcelClass.equals("ACADNATION")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADNATION.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 5);
		}
		if (writeExcelClass.equals("ACADEMYNATION")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADEMYNATION.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 4.00, 5);
		}

		if (writeExcelClass.equals("NATIONALITY")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_NATIONALITY.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 5);
		}
		if (writeExcelClass.equals("ACADNATIONALITY")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADNATIONALITY.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 5);
		}
		if (writeExcelClass.equals("ACADEMYNATIONALITY")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADEMYNATIONALITY.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, tabletitle, 4.00, 5);
		}
		if (writeExcelClass.equals("POLITICS")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_POLITICS.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 5, tabletitle, 1);
		}
		if (writeExcelClass.equals("age")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_AGE.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "three", tabletitle);
		}
		if (writeExcelClass.equals("study")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_STUDY.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "three", tabletitle);
		}
		if (writeExcelClass.equals("rank")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_RANK2.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "three", tabletitle);
		}

		// ����ίԱͳ��
		if (writeExcelClass.equals("DBWYPEONUM")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYPEONUM.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5.00, 6, tabletitle, "a");
		}

		if (writeExcelClass.equals("DBWYSEX")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYSEX.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", tabletitle, 1);
		}
		if (writeExcelClass.equals("DBWYNATION")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYNATION.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", tabletitle, 1);
		}
		if (writeExcelClass.equals("DBWYNATIONALITY")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYNATIONALITY.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", tabletitle, 1);
		}

		if (writeExcelClass.equals("dbwyage")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYAGE.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", "a", tabletitle, 1);
		}
		if (writeExcelClass.equals("dbwyrank")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYRANK.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", "a", tabletitle, 1);
		}
		if (writeExcelClass.equals("dbwyscholar")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYSCHOLAR.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", "a", tabletitle, 1);
		}

		if (writeExcelClass.equals("dbwyparty")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYPARTY.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", "a", "a", tabletitle, 1);
		}
		if (writeExcelClass.equals("DBWYINFO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_DBWYINFO.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, 4.00, 5, "a", "a", "a", "a", tabletitle);
		}
		String academyname = (String) httpServletRequest.getSession().getAttribute("acadname");
		if (writeExcelClass.equals("SMEMBERBASEINFO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_SMEMBERINFO.xls";
			String abi_id = httpServletRequest.getParameter("abi_id");
			list = academysmemberrelationDAO.getsqlresultall(Integer.valueOf(abi_id));
			WriteExcel writeExcel = new WriteExcel(list, academyname, UPath, outputFile, "a", "a", "a", "a");
		}
		if (writeExcelClass.equals("SMEMBERBASEINFOALL")) {

			Integer allnum = (Integer) httpServletRequest.getSession().getAttribute("allnum");
			if (allnum > 10000) {
				httpServletResponse.setContentType("text/html;charset=GBK");
				PrintWriter out = httpServletResponse.getWriter();
				String alertmsg = "�����ص��������������ѯ���ٴγ��ԣ�";
				out.println("<script>alert('" + alertmsg + "')</script>");
				out.println("<script>history.back()</script>");
				out.println("<script>location.reload()</script>");
				out.flush();
				return null;
			}
			String searchsql = (String) httpServletRequest.getSession().getAttribute("searchsqlprint");
			List listtemp = acadgroupDAO.getSqlresultprint(searchsql);
			List listtemp1 = new ArrayList();
			for (int i = 0; i < listtemp.size(); i++) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean = (Smemberbainforelation) listtemp.get(i);
				bean.setNo(i + 1);
				listtemp1.add(bean);
			}
			UPath = m_application.getRealPath("/") + "download" + "\\T_SMEMBERINFO.xls";
			WriteExcel writeExcel = new WriteExcel(listtemp1, academyname, UPath, outputFile, "a", "a", "a", "a");
		}
		if (writeExcelClass.equals("GMEMBERBASEINFO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_GMEMBERINFO.xls";
			WriteExcel writeExcel = new WriteExcel(list, academyname, UPath, outputFile, "a", "a", "a", "a", 1);
		}
		String academybaseinfoassoname = (String) httpServletRequest.getSession().getAttribute("academybaseinfoassoname");
		if (writeExcelClass.equals("ACADEGMEMBERBASEINFO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_GMEMBERINFO.xls";
			WriteExcel writeExcel = new WriteExcel(list, academybaseinfoassoname, UPath, outputFile, "a", "a", "a", "a", 1);
		}

		if (writeExcelClass.equals("SYSGMEMBERBASEINFO")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_GMEMBERINFO.xls";
			WriteExcel writeExcel = new WriteExcel(list, "", UPath, outputFile, "a", "a", "a", "a", 1);
		}
		if (writeExcelClass.equals("USERLOG")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_USERLOG.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "a", "a", "a", "a", 1);
		}
		if (writeExcelClass.equals("GROUPSTAT")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_GROUPSTAT.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "a", "a", "a", "a", 1, tabletitle);
		}
		if (writeExcelClass.equals("ACADEGROUPSTAT")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_ACADEGROUPSTAT.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "a", "a", "a", "a", 1, 1, tabletitle);
		}
		if (writeExcelClass.equals("SYSGROUPSTAT")) {
			UPath = m_application.getRealPath("/") + "download" + "\\T_SYSGROUPSTAT.xls";
			WriteExcel writeExcel = new WriteExcel(list, UPath, outputFile, "a", "a", "a", 1, 1, 1, tabletitle);
		}

		// �½�һ��SmartUpload����
		SmartUpload smartupload = new SmartUpload();
		// ��ʼ��
		javax.servlet.ServletConfig servletconfig = this.getServlet().getServletConfig();
		try {
			smartupload.initialize(servletconfig, httpServletRequest, httpServletResponse);
		} catch (ServletException ex) {
		}
		// �趨contentDispositionΪnull�Խ�ֹ������Զ����ļ���
		// ��֤������Ӻ��������ļ��������趨�������ص��ļ���չ��Ϊ
		// docʱ����������Զ���word��������չ��Ϊpdfʱ��
		// ���������acrobat�򿪡�

		try {
			smartupload.setContentDisposition(null);
			Thread.sleep(1000);
			smartupload.downloadFile(outputFile);
		} catch (SmartUploadException ex1) {
		} catch (IOException ex1) {
		} catch (ServletException ex1) {
		} catch (Exception ex1) {
		}

		java.io.File file = new File(outputFile.toString());
		if (!file.delete()) {
			System.out.println("ɾ�����ɹ���");
		}
		return null;
	}

	public ISexstatDAO getSexstatDAO() {
		return sexstatDAO;
	}

	public void setSexstatDAO(ISexstatDAO sexstatDAO) {
		this.sexstatDAO = sexstatDAO;
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
