package com.cssrc.web.action.stat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.bean.stat.MembershipStat;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.dao.admin.ISearchsmemberbaseinfoviewDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class MembershipStatGenderAction extends Action {
	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public ISearchsmemberbaseinfoviewDAO getSearchsmemberbaseinfoviewDAO() {
		return searchsmemberbaseinfoviewDAO;
	}

	public void setSearchsmemberbaseinfoviewDAO(ISearchsmemberbaseinfoviewDAO searchsmemberbaseinfoviewDAO) {
		this.searchsmemberbaseinfoviewDAO = searchsmemberbaseinfoviewDAO;
	}

	public MembershipStatGenderAction() {

	}

	private IAcadgroupDAO acadgroupDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;
	private ISearchsmemberbaseinfoviewDAO searchsmemberbaseinfoviewDAO;
	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		try {
			QueryForm form = (QueryForm) actionForm;
			int offset = 0;
			String searchsql = form.getSearchsql();
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			if (searchaction == null) {
				searchaction = "list";
			}
			if (searchaction.equals("search")) {
				curpage = 1;
				form.resetReseach();
			} else if (searchaction.equals("goto")) {
				offset = (curpage - 1) * pagesize;
			} else if (searchaction.equals("reset")) {
				form.reset();
				curpage = form.getCurpage();
				pagesize = form.getPagesize();
				searchsql = form.getSearchsql();
			} else {
				String pageOffset = httpServletRequest.getParameter("pager.offset");
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
			List tAfBookentrys = new ArrayList();
			List acadgrouptAfBookentrys = new ArrayList();
			List academybaseinfotAfBookentrys = new ArrayList();
			if (pagesize == 0) {

			} else {
				tAfBookentrys = acadgroupDAO.list(searchsql, offset, pagesize);
				for (int i = 0; i < tAfBookentrys.size(); i++) {
					MembershipStat bean = new MembershipStat();
					Acadgroup acadgroup = (Acadgroup) tAfBookentrys.get(i);
					bean.setSerialnumber(i + 1);
					// TODO 常委、委员子库;
					if (acadgroup.getAssoname().equals("常委、委员子库")) {
						continue;
					}
					bean.setAcadgroupname(acadgroup.getAssoname());
					String shai_idsearchsql = "where shai_id = " + acadgroup.getShai_id();
					academybaseinfotAfBookentrys = academybaseinfoDAO.list(shai_idsearchsql);
					int allpersonsize = 0;
					int alldegreesize = 0;
					StringBuffer abi_idsearchsql = new StringBuffer();
					abi_idsearchsql.append("where 1=1 ");
					for (int j = 0; j < academybaseinfotAfBookentrys.size(); j++) {
						Academybaseinfo academybaseinfo = (Academybaseinfo) academybaseinfotAfBookentrys.get(j);
						abi_idsearchsql.append("and smemberbaseinfo.memsex=" + '男');
						academybaseinfotAfBookentrys = smemberbaseinfoDAO.leftlist(abi_idsearchsql.toString());
						// if(j==0){
						// abi_idsearchsql.append("and abi_id = " +
						// " '"+academybaseinfo.getAbi_id()+ "'");
						// }else{
						// abi_idsearchsql.append("or abi_id = " +
						// " '"+academybaseinfo.getAbi_id()+ "'");
						// }

						if (j == (academybaseinfotAfBookentrys.size() - 1)) {
							List allacademysmemberrelationtAfBookentrys = new ArrayList();
							List distinctacademysmemberrelationtAfBookentrys = new ArrayList();
							List academygmemberrelationtAfBookentrys = new ArrayList();

						}
					}

				}
			}
			List listresult = new ArrayList();
			httpServletRequest.setAttribute("SMEMBERBASEINFOLIST", listresult);
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, listresult.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}
}
