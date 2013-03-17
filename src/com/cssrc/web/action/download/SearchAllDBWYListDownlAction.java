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
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.util.WriteExcel;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SearchAllDBWYListDownlAction extends Action {
	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		String searchsql = (String) httpServletRequest.getSession().getAttribute("searchalldbwysql");
		String title = "科协全体代表委员";

		try {
			List list = new ArrayList();
			List listtemp = new ArrayList();
			listtemp = shadeputybaseinfoDAO.getSqlresult(searchsql);

			for (int i = 0; i < listtemp.size(); i++) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean = (Smemberbainforelation) listtemp.get(i);
				bean.setNo(i + 1);
				list.add(bean);
			}

			ServletContext m_application = this.getServlet().getServletContext();
			String UPath = m_application.getRealPath("/") + "download" + "\\T_SMEMBERINFO.xls";
			;
			String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";
			WriteExcel writeExcel = new WriteExcel(list, title, UPath, outputFile, "a", "a", "a", "a");

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

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
