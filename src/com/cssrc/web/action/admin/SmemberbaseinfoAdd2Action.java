package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadecustom;
import com.cssrc.bean.admin.Acadecustomname;
import com.cssrc.dao.admin.IAcadecustomnameDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.admin.AcadecustomnameForm;
import com.cssrc.web.form.admin.SmemberbaseinfoForm;

/**
 * <p>
 * Title:ObjParaModifyAction
 * </p>
 * <p>
 * Description:试件参数(T_OBJ_PARA)
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
public class SmemberbaseinfoAdd2Action extends Action {
	public SmemberbaseinfoAdd2Action() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private IAcadecustomnameDAO acadecustomnameDAO;

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// SmemberbaseinfoForm form1 = (SmemberbaseinfoForm)actionForm;
		SmemberbaseinfoForm form = new SmemberbaseinfoForm();
		Acadecustom acadecustombean = new Acadecustom();
		Integer abi_id = Integer.valueOf(httpServletRequest.getParameter("abi_id"));

		List acadecustomnamelist = new ArrayList();
		List acadecustomlist = new ArrayList();
		Acadecustomname acadecustomnamebean = new Acadecustomname();
		acadecustomnamelist = acadecustomnameDAO.findAcadecustomname(abi_id);
		AcadecustomnameForm acadecustomnameform = new AcadecustomnameForm();
		String state = "N";
		String state1 = "N";
		String state2 = "N";
		String state3 = "N";
		String state4 = "N";
		String state5 = "N";
		String state6 = "N";
		for (int i = 0; i < acadecustomnamelist.size(); i++) {
			acadecustomnamebean = (Acadecustomname) acadecustomnamelist.get(i);
			if (acadecustomnamebean.getAbi_id().equals(abi_id)) {
				try {
					org.apache.commons.beanutils.BeanUtils.copyProperties(acadecustomnameform, acadecustomnamebean);

					// 页面显示控制
					state = "Y";
					if (!acadecustomnameform.getName1().equals(null) && !acadecustomnameform.getName1().equals("")) {
						state1 = "Y";
					}
					if (!acadecustomnameform.getName2().equals(null) && !acadecustomnameform.getName2().equals("")) {
						state2 = "Y";
					}
					if (!acadecustomnameform.getName3().equals(null) && !acadecustomnameform.getName3().equals("")) {
						state3 = "Y";
					}
					if (!acadecustomnameform.getName4().equals(null) && !acadecustomnameform.getName4().equals("")) {
						state4 = "Y";
					}
					if (!acadecustomnameform.getName5().equals(null) && !acadecustomnameform.getName5().equals("")) {
						state5 = "Y";
					}
					if (!acadecustomnameform.getName6().equals(null) && !acadecustomnameform.getName6().equals("")) {
						state6 = "Y";
					}

				} catch (Exception e) {
					return actionMapping.findForward("failure");
				}
			}
		}

		// 获取自定义的具体内容

		httpServletRequest.setAttribute("acadecustomnameform", acadecustomnameform);
		httpServletRequest.setAttribute("state", state);
		httpServletRequest.setAttribute("state1", state1);
		httpServletRequest.setAttribute("state2", state2);
		httpServletRequest.setAttribute("state3", state3);
		httpServletRequest.setAttribute("state4", state4);
		httpServletRequest.setAttribute("state5", state5);
		httpServletRequest.setAttribute("state6", state6);

		httpServletRequest.setAttribute("smemberbaseinfoForm", form);
		return actionMapping.findForward("success");
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public IAcadecustomnameDAO getAcadecustomnameDAO() {
		return acadecustomnameDAO;
	}

	public void setAcadecustomnameDAO(IAcadecustomnameDAO acadecustomnameDAO) {
		this.acadecustomnameDAO = acadecustomnameDAO;
	}

}
