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
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.WriteExcel;
import com.cssrc.web.form.common.QueryForm;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmemberQueryPrintAction extends Action {
	public SmemberQueryPrintAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;
	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		String train = httpServletRequest.getParameter("train");
		String searchsqlprint = (String) httpServletRequest.getSession().getAttribute("searchsqlprint");
		if (searchsqlprint == null || searchsqlprint.trim().length() == 0) {
			searchsqlprint = (String) httpServletRequest.getSession().getAttribute("smemsearchresultdownload");
		}
		List list = smemberbaseinfoDAO.getSqlresult(searchsqlprint);
		int num = list.size();
		int[] printid = new int[num];
		for (int i = 0; i < list.size(); i++) {
			Smemberbainforelation bean = new Smemberbainforelation();

			bean = (Smemberbainforelation) list.get(i);
			printid[i] = bean.getSmbi_id();
		}
		// int[] printid = (int[])
		// httpServletRequest.getSession().getAttribute("listprint");
		List printlist = new ArrayList();
		QueryForm form = (QueryForm) actionForm;
		try {
			for (int i = 0; i < printid.length; i++) {
				Smemberbaseinfo smemberbaseinfo = new Smemberbaseinfo();
				int smbi_id = printid[i];
				smemberbaseinfo = smemberbaseinfoDAO.getSmemberbaseinfo(smbi_id);
				printlist.add(smemberbaseinfo);
			}
			ServletContext m_application = this.getServlet().getServletContext();
			String UPath = m_application.getRealPath("/") + "download" + "\\T_SMEMBERPRINT.xls";
			;
			String outputFile = m_application.getRealPath("/") + "download\\" + user.getUseraccount() + "_shsareport.xls";
			WriteExcel writeExcel = new WriteExcel(printlist, UPath, outputFile, "a", "a", "a", "a");

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

			File file = new File(outputFile);
			if (file != null && file.exists()) {
				try {
					if (!file.delete()) {
						System.out.println("删除不成功：" + outputFile);
					}
				} catch (Exception e) {
					System.out.println("删除不成功：" + outputFile);
				}
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

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}
}
