package com.cssrc.web.action.admin;

import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;

/**
 * <p>
 * Title:ObjParaShowObjAction
 * </p>
 * <p>
 * Description:ÊÔ¼þ²ÎÊý(T_OBJ_PARA)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author xuejian
 * @version 1.0
 */
public class SmemberbaseinfopreviewobjAction extends Action {
	public SmemberbaseinfopreviewobjAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Smemberbaseinfo bean = new Smemberbaseinfo();
		bean = (Smemberbaseinfo) httpServletRequest.getSession().getAttribute("smemberbaseinfopreview");
		// byte[] b = new byte[1024];
		// int length;
		// ByteArrayInputStream in = new
		// ByteArrayInputStream(bean.getMemphoto());
		try {
			Blob imageblob = (Blob) bean.getMemphoto();
			InputStream input = imageblob.getBinaryStream();
			byte[] image = new byte[input.available()];
			ServletOutputStream out = httpServletResponse.getOutputStream();
			int length = 0;
			httpServletResponse.setContentType("image/jpeg");
			while ((length = input.read(image)) != -1) {
				out.write(image, 0, length);
			}
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
		}
		return null;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

}
