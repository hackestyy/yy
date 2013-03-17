package com.cssrc.web.action.smember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberbaseinfo;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.ChangeCountForm;

public class PwdModifyAction extends Action {
	public PwdModifyAction() {

	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Smemberbaseinfo smemberbaseinfo = (Smemberbaseinfo) httpServletRequest.getSession().getAttribute("USER");
		ChangeCountForm form = (ChangeCountForm) actionForm;

		String pwd1 = smemberbaseinfo.getPassword();
		String pwd2 = form.getOlduserpwd();
		String newpwd = form.getNewuserpwd();
		// int smbi_id = smemberbaseinfo.getSmbi_id();

		if (!pwd1.equals(pwd2)) {
			return actionMapping.findForward("pwdfailure");
		}

		smemberbaseinfo.setPassword(newpwd);

		if (!smemberbaseinfoDAO.updateSmemberbaseinfo(smemberbaseinfo)) {
			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");
	}

}
