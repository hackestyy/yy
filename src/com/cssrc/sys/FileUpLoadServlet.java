package com.cssrc.sys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

public class FileUpLoadServlet extends HttpServlet {
	public FileUpLoadServlet() {
	}

	public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
		doPost(httpservletrequest, httpservletresponse);
	}

	public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
		SmartUpload smartupload = new SmartUpload();
		String nextAction = httpservletrequest.getParameter("infoaction");
		javax.servlet.ServletConfig servletconfig = getServletConfig();
		smartupload.initialize(servletconfig, httpservletrequest, httpservletresponse);
		try {
			smartupload.upload();
			smartupload.save("/upload");
			Files files = smartupload.getFiles();
			File file = files.getFile(0);
			String uploadFile = file.getFileName();
			httpservletrequest.getSession().setAttribute("FileName", uploadFile);
			httpservletresponse.sendRedirect(httpservletrequest.getContextPath() + nextAction);
		} catch (Exception exception) {
			httpservletrequest.getSession().setAttribute("FileName", new String(""));
			httpservletresponse.sendRedirect(httpservletrequest.getContextPath() + nextAction);
		}
	}
}
