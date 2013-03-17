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

public class CountNameModAction extends Action {
	public CountNameModAction() {

	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		// 原密码
		Smemberbaseinfo smemberbaseinfo = (Smemberbaseinfo) httpServletRequest.getSession().getAttribute("USER");
		String pwd1 = smemberbaseinfo.getPassword();
		// 输入的密码
		ChangeCountForm form = (ChangeCountForm) actionForm;
		String pwd2 = form.getOlduserpwd();
		// 比较
		if (!pwd1.equals(pwd2)) {
			return actionMapping.findForward("pwdfailure");
		}

		// update帐号
		String newcountname = form.getCountname();
		int flag = smemberbaseinfoDAO.listmemno(newcountname);
		int flag2 = smemberbaseinfoDAO.listmemno_userinfotable(newcountname);
		if (flag == 1 || flag2 == 1) {
			return actionMapping.findForward("existcount");
		}

		if (flag == 3 || flag2 == 3) {
			return actionMapping.findForward("failure");
		}

		if (flag == 2 && flag2 == 2) {

			smemberbaseinfo.setMemno(newcountname);

			if (!smemberbaseinfoDAO.updateSmemberbaseinfo(smemberbaseinfo)) {
				return actionMapping.findForward("failure");
			}

			return actionMapping.findForward("success");

		}

		else {
			return actionMapping.findForward("failure");
		}

	}

}
