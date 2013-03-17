package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class SystemQueryAction extends Action {
	public SystemQueryAction() {
	}

	private IAcadgroupDAO acadgroupDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		QueryForm form = (QueryForm) actionForm;
		try {
			String searchsql = getSearchsql(form);
			List smemberbaseinforelationlist = new ArrayList();
			List list = new ArrayList();
			int offset = 0;
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
			List listresult = new ArrayList();
			list = acadgroupDAO.getSqlresult(searchsql, offset * pagesize, pagesize);
			if (list.size() >= offset + pagesize) {
				listresult = list.subList(offset, offset + pagesize);
			} else {
				listresult = list.subList(offset, list.size());
			}
			httpServletRequest.setAttribute("SEARCHSMEMBERBASEINFOLIST", listresult);
			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, list.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);

		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	private String getSearchsql(QueryForm form) {

		String searchitem1 = form.getSearchitem1();
		String searchitem2 = form.getSearchitem2();
		String searchitem3 = form.getSearchitem3();
		String searchitem4 = form.getSearchitem4();
		String searchvalue1 = form.getSearchvalue1();
		String searchvalue2 = form.getSearchvalue2();
		String searchvalue3 = form.getSearchvalue3();
		String searchvalue4 = form.getSearchvalue4();
		StringBuffer searchsql = new StringBuffer();
		searchsql.append(" select distinct a.smbi_id,a.memno,a.memname,a.memsex,a.meminstitute,a.institutetelephone,a.institutepostcode,a.homeaddress,a.hometelephone,a.homepostcode,a.asmr_id,a.isdelete from searchsmemberbaseinfoview a where 1=1 ");
		if (searchitem1.equals("memname") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("membirthday") && (!searchvalue1.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memsex") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memparty_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memparty_s like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memscholar") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memscholar like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memdegree") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memdegree like " + " '%" + searchvalue1 + "%'");
		}

		if (searchitem1.equals("memrank_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memrank_s like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memnationality_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memnationality_s like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memnation_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memnation_s like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("isemployee") && (!searchvalue1.equals(""))) {
			searchsql.append(" and isemployee like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memskill") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memskill like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("assoduty_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and assoduty_s like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("socialduty1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( socialduty1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("socialhonour1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( socialhonour1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour8 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour9 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour10 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour11 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour12 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour13 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour14 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour15 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour16 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour17 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour18 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour19 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour20 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("sports1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( sports1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("interduty_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and interduty_s like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("nationduty_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and nationduty_s like " + " '%" + searchvalue1 + "%'");
		}
		// 关系表
		if (searchitem1.equals("academyduty1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( academyduty1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty8 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty9 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty10 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or academyduty11 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("memtype") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memtype like " + " '" + searchvalue1 + "'");
		}
		if (searchitem1.equals("belongcommittee1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( belongcommittee1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or belongcommittee2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or belongcommittee3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or belongcommittee4 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("joindate") && (!searchvalue1.equals(""))) {
			searchsql.append(" and joindate like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("isannualregister") && (!searchvalue1.equals(""))) {
			searchsql.append(" and isannualregister like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("prodname") && (!searchvalue1.equals(""))) {
			searchsql.append(" and prodname like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("litename") && (!searchvalue1.equals(""))) {
			searchsql.append(" and litename like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("patentname") && (!searchvalue1.equals(""))) {
			searchsql.append(" and patentname like " + " '%" + searchvalue1 + "%'");
		}

		if (searchitem2.equals("memname") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("membirthday") && (!searchvalue2.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memsex") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memparty_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memparty_s like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memscholar") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memscholar like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memdegree") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memdegree like " + " '%" + searchvalue2 + "%'");
		}

		if (searchitem2.equals("memrank_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memrank_s like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memnationality_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memnationality_s like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memnation_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memnation_s like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("isemployee") && (!searchvalue2.equals(""))) {
			searchsql.append(" and isemployee like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memskill") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memskill like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("assoduty_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and assoduty_s like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("socialduty1") && (!searchvalue2.equals(""))) {
			searchsql.append(" and( socialduty1 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialduty2 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialduty3 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialduty4 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialduty5 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialduty6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem2.equals("socialhonour1") && (!searchvalue2.equals(""))) {
			searchsql.append(" and( socialhonour1 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour2 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour3 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour4 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour5 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour6 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour7 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or socialhonour8 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour9 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour10 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour11 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour12 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour13 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour14 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour15 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour16 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour17 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour18 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour19 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour20 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("sports1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( sports1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem2.equals("interduty_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and interduty_s like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("nationduty_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and nationduty_s like " + " '%" + searchvalue2 + "%'");
		}
		// 关系表
		if (searchitem2.equals("academyduty1") && (!searchvalue2.equals(""))) {
			searchsql.append(" and( academyduty1 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty2 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty3 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty4 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty5 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty6 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty7 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty8 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty9 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty10 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or academyduty11 like " + " '%" + searchvalue2 + "%')");
		}
		if (searchitem2.equals("memtype") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memtype like " + " '" + searchvalue2 + "'");
		}
		if (searchitem2.equals("belongcommittee1") && (!searchvalue2.equals(""))) {
			searchsql.append(" and( belongcommittee1 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or belongcommittee2 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or belongcommittee3 like " + " '%" + searchvalue2 + "%'");
			searchsql.append(" or belongcommittee4 like " + " '%" + searchvalue2 + "%')");
		}
		if (searchitem2.equals("joindate") && (!searchvalue2.equals(""))) {
			searchsql.append(" and joindate like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("isannualregister") && (!searchvalue2.equals(""))) {
			searchsql.append(" and isannualregister like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("prodname") && (!searchvalue2.equals(""))) {
			searchsql.append(" and prodname like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("litename") && (!searchvalue2.equals(""))) {
			searchsql.append(" and litename like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("patentname") && (!searchvalue2.equals(""))) {
			searchsql.append(" and patentname like " + " '%" + searchvalue2 + "%'");
		}

		if (searchitem3.equals("memname") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("membirthday") && (!searchvalue3.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memsex") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memparty_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memparty_s like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memscholar") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memscholar like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memdegree") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memdegree like " + " '%" + searchvalue3 + "%'");
		}

		if (searchitem3.equals("memrank_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memrank_s like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memnationality_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memnationality_s like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memnation_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memnation_s like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("isemployee") && (!searchvalue3.equals(""))) {
			searchsql.append(" and isemployee like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memskill") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memskill like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("assoduty_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and assoduty_s like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("socialduty1") && (!searchvalue3.equals(""))) {
			searchsql.append(" and( socialduty1 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialduty2 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialduty3 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialduty4 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialduty5 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialduty6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem3.equals("socialhonour1") && (!searchvalue3.equals(""))) {
			searchsql.append(" and( socialhonour1 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour2 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour3 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour4 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour5 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour6 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour7 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or socialhonour8 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour9 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour10 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour11 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour12 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour13 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour14 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour15 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour16 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour17 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour18 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour19 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour20 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("sports1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( sports1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem3.equals("interduty_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and interduty_s like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("nationduty_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and nationduty_s like " + " '%" + searchvalue3 + "%'");
		}
		// 关系表
		if (searchitem3.equals("academyduty1") && (!searchvalue3.equals(""))) {
			searchsql.append(" and( academyduty1 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty2 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty3 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty4 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty5 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty6 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty7 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty8 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty9 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty10 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or academyduty11 like " + " '%" + searchvalue3 + "%')");
		}
		if (searchitem3.equals("memtype") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memtype like " + " '" + searchvalue3 + "'");
		}
		if (searchitem3.equals("belongcommittee1") && (!searchvalue3.equals(""))) {
			searchsql.append(" and( belongcommittee1 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or belongcommittee2 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or belongcommittee3 like " + " '%" + searchvalue3 + "%'");
			searchsql.append(" or belongcommittee4 like " + " '%" + searchvalue3 + "%')");
		}
		if (searchitem3.equals("joindate") && (!searchvalue3.equals(""))) {
			searchsql.append(" and joindate like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("isannualregister") && (!searchvalue3.equals(""))) {
			searchsql.append(" and isannualregister like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("prodname") && (!searchvalue3.equals(""))) {
			searchsql.append(" and prodname like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("litename") && (!searchvalue3.equals(""))) {
			searchsql.append(" and litename like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("patentname") && (!searchvalue3.equals(""))) {
			searchsql.append(" and patentname like " + " '%" + searchvalue3 + "%'");
		}

		if (searchitem4.equals("memname") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("membirthday") && (!searchvalue4.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memsex") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memparty_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memparty_s like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memscholar") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memscholar like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memdegree") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memdegree like " + " '%" + searchvalue4 + "%'");
		}

		if (searchitem4.equals("memrank_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memrank_s like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memnationality_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memnationality_s like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memnation_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memnation_s like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("isemployee") && (!searchvalue4.equals(""))) {
			searchsql.append(" and isemployee like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memskill") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memskill like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("assoduty_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and assoduty_s like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("socialduty1") && (!searchvalue4.equals(""))) {
			searchsql.append(" and( socialduty1 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialduty2 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialduty3 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialduty4 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialduty5 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialduty6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialduty8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem4.equals("socialhonour1") && (!searchvalue4.equals(""))) {
			searchsql.append(" and( socialhonour1 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour2 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour3 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour4 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour5 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour6 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour7 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or socialhonour8 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour9 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour10 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour11 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour12 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour13 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour14 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour15 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour16 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour17 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour18 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour19 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or socialhonour20 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("sports1") && (!searchvalue1.equals(""))) {
			searchsql.append(" and( sports1 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports2 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports3 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports4 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports5 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports6 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports7 like " + " '%" + searchvalue1 + "%'");
			searchsql.append(" or sports8 like " + " '%" + searchvalue1 + "%')");
		}
		if (searchitem4.equals("interduty_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and interduty_s like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("nationduty_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and nationduty_s like " + " '%" + searchvalue4 + "%'");
		}
		// 关系表
		if (searchitem4.equals("academyduty1") && (!searchvalue4.equals(""))) {
			searchsql.append(" and( academyduty1 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty2 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty3 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty4 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty5 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty6 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty7 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty8 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty9 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty10 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or academyduty11 like " + " '%" + searchvalue4 + "%')");
		}
		if (searchitem4.equals("memtype") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memtype like " + " '" + searchvalue4 + "'");
		}
		if (searchitem4.equals("belongcommittee1") && (!searchvalue4.equals(""))) {
			searchsql.append(" and( belongcommittee1 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or belongcommittee2 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or belongcommittee3 like " + " '%" + searchvalue4 + "%'");
			searchsql.append(" or belongcommittee4 like " + " '%" + searchvalue4 + "%')");
		}
		if (searchitem4.equals("joindate") && (!searchvalue4.equals(""))) {
			searchsql.append(" and joindate like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("isannualregister") && (!searchvalue4.equals(""))) {
			searchsql.append(" and isannualregister like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("prodname") && (!searchvalue4.equals(""))) {
			searchsql.append(" and prodname like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("litename") && (!searchvalue4.equals(""))) {
			searchsql.append(" and litename like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("patentname") && (!searchvalue4.equals(""))) {
			searchsql.append(" and patentname like " + " '%" + searchvalue4 + "%'");
		}
		// searchsql.append("  order by s_id")
		return searchsql.toString();

	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}
}
