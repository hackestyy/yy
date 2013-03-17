package com.cssrc.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.Stemp;
import com.cssrc.dao.admin.IStempDAO;
import com.cssrc.web.form.admin.StempForm;

public class StempAction extends Action {
	public StempAction() {
	}

	private IStempDAO stempDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		String username = user.getUseraccount();
		StempForm form = new StempForm();
		try {
			List stemplist = stempDAO.findStemp(username);
			if (stemplist.size() != 0) {
				Stemp bean = (Stemp) stemplist.get(0);
				form.setUsername(bean.getUsername());
				form.setStempname(bean.getStempname());
				httpServletRequest.setAttribute("stempForm", form);
			}
		} catch (Exception e) {

			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");

	}

	public IStempDAO getStempDAO() {
		return stempDAO;
	}

	public void setStempDAO(IStempDAO stempDAO) {
		this.stempDAO = stempDAO;
	}

}
