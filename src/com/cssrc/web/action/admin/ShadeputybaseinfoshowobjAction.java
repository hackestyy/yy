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

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;

public class ShadeputybaseinfoshowobjAction extends Action {
	public ShadeputybaseinfoshowobjAction() {
	}

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shadbi_id = (Integer) httpServletRequest.getSession().getAttribute("shadbi_id");

		Shadeputybaseinfo bean = new Shadeputybaseinfo();
		bean = shadeputybaseinfoDAO.getShadeputybaseinfo(shadbi_id);

		try {
			Blob imageblob = (Blob) bean.getDeputyphoto();
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

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
