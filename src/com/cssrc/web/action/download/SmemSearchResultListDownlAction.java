package com.cssrc.web.action.download;

import java.io.File;
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
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.WriteExcel;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmemSearchResultListDownlAction extends Action {

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		String searchsql = (String) httpServletRequest.getSession().getAttribute("smemsearchresultdownload");
		String academyname = (String) httpServletRequest.getSession().getAttribute("acadname");
		String title = academyname + "查询结果";
		try {
			List listtemp = new ArrayList();
			listtemp = smemberbaseinfoDAO.getSqlresult(searchsql);

			ServletContext m_application = this.getServlet().getServletContext();
			String UPath = m_application.getRealPath("/") + "download" + "\\T_SMEMBERINFO.xls";
			;
			String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";
			WriteExcel writeExcel = new WriteExcel(listtemp, title, UPath, outputFile, "a", "a", "a", "a");

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

			java.io.File file = new File(outputFile.toString());
			if (!file.delete()) {
				System.out.println("删除不成功！");
			}
			return null;

		} catch (Exception e) {
			return null;
		}

	}

}
