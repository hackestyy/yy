package com.cssrc.web.action.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Shadeputybaseinfo;
import com.cssrc.dao.admin.IShadeputybaseinfoDAO;

public class SearchDBWYBaseInfoDelAction2 extends Action {

	private IShadeputybaseinfoDAO shadeputybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String deputyno = httpServletRequest.getSession().getAttribute("memno").toString();
		List shadbi_idList = shadeputybaseinfoDAO.findshadbi_idByDeputyNO(deputyno);
		Integer shadbi_id = (Integer) shadbi_idList.get(0);
		Shadeputybaseinfo bean = shadeputybaseinfoDAO.getShadeputybaseinfo(shadbi_id);
		if (!shadeputybaseinfoDAO.removeShadeputybaseinfo(bean)) {
			return actionMapping.findForward("errorDelete");
		}

		String dbwy = httpServletRequest.getParameter("dbwy");
		if (dbwy != null) {
			if (dbwy.equals("wy")) {
				return actionMapping.findForward("success_wy");
			}
			if (dbwy.equals("cw")) {
				return actionMapping.findForward("success_cw");
			} else {
				return actionMapping.findForward("success");
			}
		} else {
			return actionMapping.findForward("success");
		}
	}

	public IShadeputybaseinfoDAO getShadeputybaseinfoDAO() {
		return shadeputybaseinfoDAO;
	}

	public void setShadeputybaseinfoDAO(IShadeputybaseinfoDAO shadeputybaseinfoDAO) {
		this.shadeputybaseinfoDAO = shadeputybaseinfoDAO;
	}

}
