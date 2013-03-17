/**
 * 供下载文件使用
 */
package com.cssrc.sys;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * @author Administrator
 */
public class FileDownLoadServlet extends HttpServlet {
	private final String a = "/error/errorDownload.jsp";

	public FileDownLoadServlet() {
	}

	public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
		long l = 0L;
		String filename = httpservletrequest.getParameter("fileId");
		ServletContext m_application = this.getServletContext();
		String path = m_application.getRealPath("/");
		if (filename != null) {
			String s2 = filename;
			String s3 = path + "download/" + filename;
			SmartUpload smartupload = new SmartUpload();
			ServletConfig servletconfig = getServletConfig();
			smartupload.initialize(servletconfig, httpservletrequest, httpservletresponse);
			try {
				s2 = new String(s2.getBytes("GBK"), "ISO8859_1");
			} catch (Exception exception) {
				System.err.println("--> e = " + exception);
			}
			File file = new File(s3);
			if (!file.exists())
				httpservletresponse.sendRedirect(httpservletrequest.getContextPath() + a);
			else
				try {
					smartupload.downloadFile(s3, null, s2);
				} catch (SmartUploadException smartuploadexception) {
					httpservletresponse.sendRedirect(httpservletrequest.getContextPath() + a);
				} catch (SocketException e) {
				}
		} else {
			httpservletresponse.sendRedirect(httpservletrequest.getContextPath() + a);
		}
	}

	public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
		doPost(httpservletrequest, httpservletresponse);
	}
}
