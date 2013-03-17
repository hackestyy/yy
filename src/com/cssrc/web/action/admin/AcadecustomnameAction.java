package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadecustomname;
import com.cssrc.dao.admin.IAcadecustomnameDAO;
import com.cssrc.web.form.admin.AcadecustomnameForm;

public class AcadecustomnameAction extends Action {
	public AcadecustomnameAction() {
	}

	private IAcadecustomnameDAO acadecustomnameDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		List acadecustomnamelist = new ArrayList();
		Acadecustomname acadecustomnamebean = new Acadecustomname();
		try {
			acadecustomnamelist = acadecustomnameDAO.findAcadecustomname(abi_id);
			AcadecustomnameForm form = new AcadecustomnameForm();
			if (!(acadecustomnamelist == null)) {
				for (int i = 0; i < acadecustomnamelist.size(); i++) {
					acadecustomnamebean = (Acadecustomname) acadecustomnamelist.get(i);
					if (acadecustomnamebean.getAbi_id().equals(abi_id)) {
						try {
							org.apache.commons.beanutils.BeanUtils.copyProperties(form, acadecustomnamebean);
						} catch (Exception e) {
							return actionMapping.findForward("failure");
						}
					}
				}
			}

			httpServletRequest.setAttribute("acadecustomnameForm", form);

		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");

	}

	public IAcadecustomnameDAO getAcadecustomnameDAO() {
		return acadecustomnameDAO;
	}

	public void setAcadecustomnameDAO(IAcadecustomnameDAO acadecustomnameDAO) {
		this.acadecustomnameDAO = acadecustomnameDAO;
	}

}
