package com.cssrc.web.action.search;

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
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;
import com.cssrc.util.WriteExcel;
import com.cssrc.web.form.common.QueryForm;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DbwyQueryPrintAction extends Action {
	public DbwyQueryPrintAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		String train = httpServletRequest.getParameter("train");
		List printlist = (List) httpServletRequest.getSession().getAttribute("listprint");

		List shalist = new ArrayList();
		QueryForm form = (QueryForm) actionForm;
		try {

			ServletContext m_application = this.getServlet().getServletContext();
			String UPath = m_application.getRealPath("/") + "download" + "\\T_SMEMBERPRINT.xls";
			;
			String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";
			WriteExcel writeExcel = new WriteExcel(printlist, UPath, outputFile, "a", "a", "a", "a", "a", "a");

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
				System.out.println("É¾³ý²»³É¹¦£¡");
			}
			return null;

		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			return actionMapping.findForward("failure");
		}

	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
