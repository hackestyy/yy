package com.cssrc.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.MyUtil;
import com.cssrc.web.page.EntrySearchForm;
import com.cssrc.web.page.Pager;

public class SmemberbaseinfomainListAction extends Action {
	public SmemberbaseinfomainListAction() {
	}

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer abi_id = (Integer) (httpServletRequest.getSession().getAttribute("abi_id"));
		String academybaseinfoassoname = (String) (httpServletRequest.getSession().getAttribute("academybaseinfoassoname"));
		String acadname = (String) (httpServletRequest.getSession().getAttribute("acadname"));
		// Acadgroup bean = acadgroupDAO.getAcadgroup(shai_id);
		try {
			EntrySearchForm form = new EntrySearchForm();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction == null) {
				searchaction = "list";
				httpServletRequest.getSession().removeAttribute("TRAIN");
			}
			if (searchaction.equals("search")) {
				curpage = 1;
				form.resetReseach();
			} else if (searchaction.equals("goto")) {
				curpage = Integer.valueOf(httpServletRequest.getParameter("curpage"));
				pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
				form.setPagesize(pagesize);
				form.setCurpage(curpage);
				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
			} else {
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if (httpServletRequest.getParameter("pagesize") != null) {
					pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
					form.setPagesize(pagesize);
				}
				if ((pageOffset == null) || pageOffset.equals("")) {
					offset = 0;
				} else {
					offset = Integer.parseInt(pageOffset);
				}

				if (pagesize != 0) {
					form.setCurpage((offset / pagesize) + 1);
				} else {
					form.setCurpage(1);
				}
			}
			List smemberbaseinfolist = new ArrayList();
			// List academysmemberrelationlist = new ArrayList();
			List smemberbaseinforelationlist = new ArrayList();
			List list = new ArrayList();
			// List tAfBookentrys = new ArrayList();
			List tAfBookentrys0 = new ArrayList();
			String searchsql = "where abi_id = " + abi_id + " and isdelete=" + 0;

			/*
			 * tAfBookentrys = academysmemberrelationDAO.list(searchsql); for
			 * (int i = 0; i < tAfBookentrys.size(); i++) { List
			 * temptAfBookentrys = new ArrayList(); Smemberbainforelation
			 * smemberbainforelation = new Smemberbainforelation();
			 * Academysmemberrelation academysmemberrelation =
			 * (Academysmemberrelation) tAfBookentrys .get(i);
			 * academysmemberrelationlist
			 * .add(academysmemberrelation);//纯属多余的部分（保险起见还是保留下来
			 * ）academysmemberrelationlist }
			 */

			List listresult = new ArrayList();
			List listtemp = new ArrayList();
			// TODO 如果是仅读取多少届的会员，修改这里 yy_modify
			String train = httpServletRequest.getParameter("train");
			if (null==train||"".equals(train)) {
				listtemp = academysmemberrelationDAO.getsqlresult(abi_id, offset, pagesize);
			}else{
//				if(train.equals("memno")||train.equals("meminstitute")){
				if ("abino".equals(train)) {
					listtemp = academysmemberrelationDAO.getsqlresult(abi_id, offset, pagesize,"smbi_id");
				}else {
					listtemp = academysmemberrelationDAO.getsqlresult(abi_id, offset, pagesize,train);
				}
				
			}
			
			Integer num = academysmemberrelationDAO.getallonum(abi_id);

			for (int i = 0; i < listtemp.size(); i++) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean = (Smemberbainforelation) listtemp.get(i);
				bean.setNo(i + 1);
				list.add(bean);
			}
			listresult = list;
			/*
			 * if (list.size() >= offset + pagesize) { listresult =
			 * list.subList(offset, offset + pagesize); }else { listresult =
			 * list.subList(offset, list.size()); }
			 */

			// 处理单位名称过长导致页面变形的问题
			List finalList = new ArrayList();
			for (int i = 0; i < listresult.size(); i++) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean = (Smemberbainforelation) listresult.get(i);
				String s = bean.getMeminstitute();
				String institute = MyUtil.cutString(s, 24);
				bean.setMeminstitute(institute);
				finalList.add(bean);
			}

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, num, pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
			httpServletRequest.setAttribute("entrysearchForm", form);
			httpServletRequest.getSession().setAttribute("smemberabi_id", abi_id);
			httpServletRequest.getSession().setAttribute("SMEMBERBASEINFOLIST", finalList);
			// httpServletRequest.getSession().setAttribute("SMEMBERBASEINFOLIST",
			// smemberbaseinforelationlist);
			// httpServletRequest.getSession().setAttribute(
			// "ACADEMYSMEMBERBASEINFOLIST", academysmemberrelationlist);
			httpServletRequest.getSession().setAttribute("STATINFO_EXCEL", list);
		} catch (Exception e) {
			// errors.add("ErrorMessage", new ActionMessage("error.Exception"));
			// saveErrors(request, errors);
			// logger.error(StringUtil.getLogString(loginDTO.getUserid(),
			// e.getMessage()) );
			e.printStackTrace();
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");

	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

}
