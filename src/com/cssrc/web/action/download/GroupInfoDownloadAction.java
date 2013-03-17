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
import com.cssrc.bean.admin.Academygmemberrelation;
import com.cssrc.bean.admin.Gmemberbaseinfo;
import com.cssrc.dao.admin.IAcademygmemberrelationDAO;
import com.cssrc.dao.admin.IGmemberbaseinfoDAO;
import com.cssrc.dao.admin.IGmemberpatentinfoDAO;
import com.cssrc.dao.admin.IGmemberresearchproductionDAO;
import com.cssrc.util.WriteExcel;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class GroupInfoDownloadAction extends Action {
	public GroupInfoDownloadAction() {
	}

	private IGmemberbaseinfoDAO gmemberbaseinfoDAO;
	private IAcademygmemberrelationDAO academygmemberrelationDAO;
	private IGmemberresearchproductionDAO gmemberresearchproductionDAO;
	private IGmemberpatentinfoDAO gmemberpatentinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		try {
			Integer agmr_id = (Integer) httpServletRequest.getSession().getAttribute("agmr_id");
			User user = (User) httpServletRequest.getSession().getAttribute("USER");

			ServletContext m_application = this.getServlet().getServletContext();
			String UPath = m_application.getRealPath("/") + "download" + "\\T_GROUPINFO.xls";
			;
			String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";

			Gmemberbaseinfo gmemberbaseinfo = new Gmemberbaseinfo();
			gmemberbaseinfo = gmemberbaseinfoDAO.getGmemberbaseinfo(agmr_id);

			Academygmemberrelation academygmemberrelation = new Academygmemberrelation();
			academygmemberrelation = academygmemberrelationDAO.getAcademygmemberrelation(agmr_id);
			int gmbi_id = gmemberbaseinfo.getGmbi_id();

			String searchsql = "where gmbi_id = " + gmbi_id;

			List list1 = new ArrayList();
			List list2 = new ArrayList();
			// Gmemberresearchproduction gmemberresearchproduction = new
			// Gmemberresearchproduction();
			list1 = gmemberresearchproductionDAO.list(searchsql);

			// Gmemberpatentinfo gmemberpatentinfo = new Gmemberpatentinfo();
			list2 = gmemberpatentinfoDAO.list(searchsql);

			WriteExcel writeExcel = new WriteExcel(gmemberbaseinfo, academygmemberrelation, list1, list2, UPath, outputFile);

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

	public IAcademygmemberrelationDAO getAcademygmemberrelationDAO() {
		return academygmemberrelationDAO;
	}

	public void setAcademygmemberrelationDAO(IAcademygmemberrelationDAO academygmemberrelationDAO) {
		this.academygmemberrelationDAO = academygmemberrelationDAO;
	}

	public IGmemberbaseinfoDAO getGmemberbaseinfoDAO() {
		return gmemberbaseinfoDAO;
	}

	public void setGmemberbaseinfoDAO(IGmemberbaseinfoDAO gmemberbaseinfoDAO) {
		this.gmemberbaseinfoDAO = gmemberbaseinfoDAO;
	}

	public IGmemberpatentinfoDAO getGmemberpatentinfoDAO() {
		return gmemberpatentinfoDAO;
	}

	public void setGmemberpatentinfoDAO(IGmemberpatentinfoDAO gmemberpatentinfoDAO) {
		this.gmemberpatentinfoDAO = gmemberpatentinfoDAO;
	}

	public IGmemberresearchproductionDAO getGmemberresearchproductionDAO() {
		return gmemberresearchproductionDAO;
	}

	public void setGmemberresearchproductionDAO(IGmemberresearchproductionDAO gmemberresearchproductionDAO) {
		this.gmemberresearchproductionDAO = gmemberresearchproductionDAO;
	}

}
