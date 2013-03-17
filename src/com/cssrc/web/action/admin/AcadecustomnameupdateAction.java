package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadecustomname;
import com.cssrc.dao.admin.IAcadecustomnameDAO;
import com.cssrc.web.form.admin.AcadecustomnameForm;

public class AcadecustomnameupdateAction extends Action {
	public AcadecustomnameupdateAction() {
	}

	private IAcadecustomnameDAO acadecustomnameDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		AcadecustomnameForm form = (AcadecustomnameForm) actionForm;
		Acadecustomname bean = new Acadecustomname();
		try {
			bean.setAbi_id(abi_id);
			if (!form.getId().equals(0)) {
				bean.setId(form.getId());
			}
			bean.setName1(form.getName1());
			bean.setName2(form.getName2());
			bean.setName3(form.getName3());
			bean.setName4(form.getName4());
			bean.setName5(form.getName5());
			bean.setName6(form.getName6());

			if (acadecustomnameDAO.modifyAcadecustomname(bean)) {
				httpServletRequest.setAttribute("acadecustomnameForm", form);
				return actionMapping.findForward("success");
			} else {
				return actionMapping.findForward("failure");
			}

		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}

	}

	public IAcadecustomnameDAO getAcadecustomnameDAO() {
		return acadecustomnameDAO;
	}

	public void setAcadecustomnameDAO(IAcadecustomnameDAO acadecustomnameDAO) {
		this.acadecustomnameDAO = acadecustomnameDAO;
	}

}
