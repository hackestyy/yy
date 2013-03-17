package com.cssrc.web.action.smember;

import org.apache.struts.action.Action;

public class CountModifyAction extends Action {
	public CountModifyAction() {

	}

	/*
	 * private ISmemberbaseinfoDAO smemberbaseinfoDAO; private IUserDAO userDAO;
	 * public IUserDAO getUserDAO() { return userDAO; }
	 * public void setUserDAO(IUserDAO userDAO) { this.userDAO = userDAO; }
	 * public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() { return
	 * smemberbaseinfoDAO; }
	 * public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO)
	 * { this.smemberbaseinfoDAO = smemberbaseinfoDAO; }
	 * public ActionForward execute(ActionMapping actionMapping, ActionForm
	 * actionForm, HttpServletRequest httpServletRequest, HttpServletResponse
	 * httpServletResponse) {
	 * Smemberbaseinfo smemberbaseinfo =
	 * (Smemberbaseinfo)httpServletRequest.getSession().getAttribute("USER");
	 * SmemberbaseinfoForm form = (SmemberbaseinfoForm) actionForm;
	 * String newmemno = form.getMemno(); int flag1 = 0; int flag2 = 0; List
	 * list1 = smemberbaseinfoDAO.listmemno("s"); List list2 =
	 * userDAO.listAccount();
	 * for(int i=0;i<list1.size();i++) { if(newmemno.equals(list1.get(i))) {
	 * flag1 = flag1 + 1; } }
	 * for(int i=0;i<list2.size();i++) { if(newmemno.equals(list2.get(i))) {
	 * flag2 = flag2 + 1; } }
	 * if(flag1!=0||flag2!=0) { return
	 * actionMapping.findForward("countfailure"); }
	 * smemberbaseinfo.setMemno(newmemno);
	 * if (!smemberbaseinfoDAO.updateSmemberbaseinfo(smemberbaseinfo)) { return
	 * actionMapping.findForward("failure"); }
	 * return actionMapping.findForward("success");
	 * }
	 */
}
