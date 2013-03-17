package com.cssrc.web.action.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademybaseinfoForm;

/**
 * <p>
 * Title:ObjParaModifyAction
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
public class SystemAcademySearchModifyAction extends Action {
	public SystemAcademySearchModifyAction() {
	}

	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademybaseinfoForm form = new AcademybaseinfoForm();
		Integer abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));
		List academybaseinfobyabi_id = academybaseinfoDAO.gainAcademybaseinfo(abi_id);
		Academybaseinfo byabi_idacademybaseinfo = (Academybaseinfo) academybaseinfobyabi_id.get(0);
		Integer shai_id = byabi_idacademybaseinfo.getShai_id();
		Academybaseinfo bean = academybaseinfoDAO.getAcademybaseinfo(abi_id);
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(form, bean);
		} catch (Exception ex) {
			return actionMapping.findForward("failure");
		}
		form.setTempregisterdate(DateUtil.getCalendarString(form.getRegisterdate(), "yyyy-MM-dd"));
		httpServletRequest.getSession().setAttribute("acadname", form.getAcadname());
		httpServletRequest.setAttribute("academybaseinfoForm", form);
		httpServletRequest.getSession().setAttribute("abi_id", abi_id);
		httpServletRequest.getSession().setAttribute("shai_id", shai_id);
		return actionMapping.findForward("success");
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
