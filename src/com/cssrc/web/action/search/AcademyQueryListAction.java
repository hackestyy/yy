package com.cssrc.web.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.bean.admin.Smemberbainforelation;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.dao.admin.ISmemberbaseinfoDAO;
import com.cssrc.util.MyUtil;
import com.cssrc.web.form.common.QueryForm;
import com.cssrc.web.page.Pager;

public class AcademyQueryListAction extends Action {
	public AcademyQueryListAction() {
	}

	private IAcadgroupDAO acadgroupDAO;

	private ISmemberbaseinfoDAO smemberbaseinfoDAO;

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	private IAcademybaseinfoDAO academybaseinfoDAO;

	private Object[] obj;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Integer shai_id = (Integer) httpServletRequest.getSession().getAttribute("shai_id");
		Acadgroup tempacadgroup = acadgroupDAO.getAcadgroup(shai_id);
		QueryForm form = (QueryForm) actionForm;
		try {
			String searchsql = getSearchsql(form, shai_id);
			List smemberbaseinforelationlist = new ArrayList();
			List list = new ArrayList();
			int offset = 0;
			int curpage = form.getCurpage();
			int pagesize = form.getPagesize();
			String searchaction = httpServletRequest.getParameter("searchaction");
			String train = httpServletRequest.getParameter("train");
			if (searchaction != null) {
				if (searchaction.equals("list")) {
					httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
					httpServletRequest.getSession().removeAttribute("TRAIN");
				}
				if (searchaction.equals("search")) {
					httpServletRequest.getSession().setAttribute("SEARCHCONDITION", searchsql);
					curpage = 1;
					form.resetReseach();
				} else if (searchaction.equals("goto")) {
					offset = (curpage - 1) * pagesize;
				} else if (searchaction.equals("reset")) {
					httpServletRequest.getSession().removeAttribute("SEARCHCONDITION");
					form.reset();
					curpage = form.getCurpage();
					pagesize = form.getPagesize();
					// searchsql = form.getSearchsql();
				}
			} else {
				String tempsearchsql = (String) httpServletRequest.getSession().getAttribute("SEARCHCONDITION");
				if (tempsearchsql != null) {
					searchsql = tempsearchsql;
				}
				String pageOffset = httpServletRequest.getParameter("pager.offset");
				if (httpServletRequest.getParameter("pagesize") != null) {
					pagesize = Integer.valueOf(httpServletRequest.getParameter("pagesize"));
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
			List listresult = new ArrayList();
			String trainval = (String) httpServletRequest.getSession().getAttribute("TRAIN");

			// list = academybaseinfoDAO.getSqlresult(searchsql);

			if (train == null) {
				if (trainval == null) {
					list = academybaseinfoDAO.getSqlresult(searchsql);
				} else
					list = academybaseinfoDAO.getSqlresult1(searchsql, trainval);

			} else if (train.equals("memno")) {
				list = academybaseinfoDAO.getSqlresult1(searchsql, "memno");
				httpServletRequest.getSession().setAttribute("TRAIN", train);
			} else if (train.equals("joindate")) {
				list = academybaseinfoDAO.getSqlresult1(searchsql, "joindate");
				httpServletRequest.getSession().setAttribute("TRAIN", train);
			} else if (train.equals("meminstitute")) {
				list = academybaseinfoDAO.getSqlresult1(searchsql, "meminstitute");
				httpServletRequest.getSession().setAttribute("TRAIN", train);
			} else if (train.equals("belongcommittee1")) {
				list = academybaseinfoDAO.getSqlresult1(searchsql, "belongcommittee1");
				httpServletRequest.getSession().setAttribute("TRAIN", train);
			}

			if (list.size() >= offset + pagesize) {
				listresult = list.subList(offset, offset + pagesize);
			} else {
				listresult = list.subList(offset, list.size());
			}
			List finalList = new ArrayList();
			for (int i = 0; i < listresult.size(); i++) {
				Smemberbainforelation bean = new Smemberbainforelation();
				bean = (Smemberbainforelation) listresult.get(i);
				String s = bean.getMeminstitute();
				String institute = MyUtil.cutString(s, 24);
				bean.setMeminstitute(institute);
				finalList.add(bean);
			}
			httpServletRequest.setAttribute("SMEMBERBASEINFOLIST", finalList);
			httpServletRequest.getSession().setAttribute("searchshai_id", shai_id);
			httpServletRequest.getSession().setAttribute("searchsqlprint", searchsql);
			httpServletRequest.getSession().setAttribute("acadsearchresultdownload", searchsql);

			String url = httpServletRequest.getRequestURI();
			String pagerHeader = Pager.generateall(offset, list.size(), pagesize, url);
			httpServletRequest.setAttribute("pagerHeader", pagerHeader);
		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}
		return actionMapping.findForward("success");
	}

	private String getSearchsql(QueryForm form, Integer shai_id) {

		String searchitem1 = form.getSearchitem1();
		String searchitem2 = form.getSearchitem2();
		String searchitem3 = form.getSearchitem3();
		String searchitem4 = form.getSearchitem4();
		String searchvalue1 = form.getSearchvalue1();
		String searchvalue2 = form.getSearchvalue2();
		String searchvalue3 = form.getSearchvalue3();
		String searchvalue4 = form.getSearchvalue4();

		if (searchitem1.equals("assoduty_s") && (!searchvalue1.equals(""))) {
			if (searchvalue1.equals("主席")) {
				searchvalue1 = "0";
			}
			if (searchvalue1.equals("驻会副主席")) {
				searchvalue1 = "1";
			}
			if (searchvalue1.equals("副主席")) {
				searchvalue1 = "2";
			}
			if (searchvalue1.equals("常委会委员")) {
				searchvalue1 = "3";
			}
			if (searchvalue1.equals("委员")) {
				searchvalue1 = "4";
			}
			if (searchvalue1.equals("代表")) {
				searchvalue1 = "5";
			}
		}

		if (searchitem2.equals("assoduty_s") && (!searchvalue2.equals(""))) {
			if (searchvalue2.equals("主席")) {
				searchvalue2 = "0";
			}
			if (searchvalue2.equals("驻会副主席")) {
				searchvalue2 = "1";
			}
			if (searchvalue2.equals("副主席")) {
				searchvalue2 = "2";
			}
			if (searchvalue2.equals("常委会委员")) {
				searchvalue2 = "3";
			}
			if (searchvalue2.equals("委员")) {
				searchvalue2 = "4";
			}
			if (searchvalue2.equals("代表")) {
				searchvalue2 = "5";
			}
		}

		if (searchitem3.equals("assoduty_s") && (!searchvalue3.equals(""))) {
			if (searchvalue3.equals("主席")) {
				searchvalue3 = "0";
			}
			if (searchvalue3.equals("驻会副主席")) {
				searchvalue3 = "1";
			}
			if (searchvalue3.equals("副主席")) {
				searchvalue3 = "2";
			}
			if (searchvalue3.equals("常委会委员")) {
				searchvalue3 = "3";
			}
			if (searchvalue3.equals("委员")) {
				searchvalue3 = "4";
			}
			if (searchvalue3.equals("代表")) {
				searchvalue3 = "5";
			}
		}

		if (searchitem4.equals("assoduty_s") && (!searchvalue4.equals(""))) {
			if (searchvalue4.equals("主席")) {
				searchvalue4 = "0";
			}
			if (searchvalue4.equals("驻会副主席")) {
				searchvalue4 = "1";
			}
			if (searchvalue4.equals("副主席")) {
				searchvalue4 = "2";
			}
			if (searchvalue4.equals("常委会委员")) {
				searchvalue4 = "3";
			}
			if (searchvalue4.equals("委员")) {
				searchvalue4 = "4";
			}
			if (searchvalue4.equals("代表")) {
				searchvalue4 = "5";
			}
		}

		StringBuffer searchsql = new StringBuffer();
		searchsql.append(" select distinct a.*, a.smbi_id,a.membirthday,a.memscholar,a.memdegree,a.memno,a.memname,a.memsex,a.meminstitute,a.institutetelephone,a.isdelete, a.party,a.memrank_s,a.memduty,a.memspeciality,a.instituteaddress,a.institutepostcode,a.homeaddress,a.homepostcode,hometelephone,memnation_s,memnationality_s from searchsmemberbaseinfoview a where 1=1 ");
		searchsql.append(" and a.abi_id in( select i.abi_id from t_shassociationinfo h,t_academybaseinfo i where h.shai_id=i.shai_id and h.shai_id=" + "'" + shai_id + "' )");
		if (searchitem1.equals("memname") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("custom") && (!searchvalue1.equals(""))) {
			searchsql.append(" and (content1 like" + " '%" + searchvalue1 + "%' OR content2 like" + " '%" + searchvalue1 + "%' OR content3 like" + " '%" + searchvalue1 + "%' OR content4 like" + " '%" + searchvalue1 + "%' OR content5 like" + " '%" + searchvalue1 + "%' OR content6 like" + " '%" + searchvalue1 + "%')");
		}
		if (searchitem1.equals("membirthday") && (!searchvalue1.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memsex") && (!searchvalue1.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue1 + "%'");
		}
		if (searchitem1.equals("memparty_s") && (!searchvalue1.equals(""))) {
			searchsql.append(" and party like " + " '%" + searchvalue1 + "%'");
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
			searchsql.append(" and assoduty_f like " + " '%" + searchvalue1 + "%'");
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
			searchsql.append(" and memtype like " + " '%" + searchvalue1 + "%'");
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
			searchsql.append(" and isannualregister like " + " '" + searchvalue1 + "'");
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
		if (searchitem1.equals("meminstitute") && (!searchvalue1.equals(""))) {
			searchsql.append(" and meminstitute like " + " '%" + searchvalue1 + "%'");
		}

		if (searchitem2.equals("memname") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("custom") && (!searchvalue1.equals(""))) {
			searchsql.append(" and (content1 like" + " '%" + searchvalue2 + "%' OR content2 like" + " '%" + searchvalue2 + "%' OR content3 like" + " '%" + searchvalue2 + "%' OR content4 like" + " '%" + searchvalue2 + "%' OR content5 like" + " '%" + searchvalue2 + "%' OR content6 like" + " '%" + searchvalue2 + "%')");
		}
		if (searchitem2.equals("membirthday") && (!searchvalue2.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memsex") && (!searchvalue2.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue2 + "%'");
		}
		if (searchitem2.equals("memparty_s") && (!searchvalue2.equals(""))) {
			searchsql.append(" and party like " + " '%" + searchvalue2 + "%'");
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
			searchsql.append(" and assoduty_f like " + " '%" + searchvalue2 + "%'");
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
			searchsql.append(" and memtype like " + " '%" + searchvalue2 + "%'");
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
			searchsql.append(" and isannualregister like " + " '" + searchvalue2 + "'");
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
		if (searchitem2.equals("meminstitute") && (!searchvalue2.equals(""))) {
			searchsql.append(" and meminstitute like " + " '%" + searchvalue2 + "%'");
		}

		if (searchitem3.equals("memname") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("custom") && (!searchvalue1.equals(""))) {
			searchsql.append(" and (content1 like" + " '%" + searchvalue3 + "%' OR content2 like" + " '%" + searchvalue3 + "%' OR content3 like" + " '%" + searchvalue3 + "%' OR content4 like" + " '%" + searchvalue3 + "%' OR content5 like" + " '%" + searchvalue3 + "%' OR content6 like" + " '%" + searchvalue3 + "%')");
		}
		if (searchitem3.equals("membirthday") && (!searchvalue3.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memsex") && (!searchvalue3.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue3 + "%'");
		}
		if (searchitem3.equals("memparty_s") && (!searchvalue3.equals(""))) {
			searchsql.append(" and party like " + " '%" + searchvalue3 + "%'");
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
			searchsql.append(" and assoduty_f like " + " '%" + searchvalue3 + "%'");
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
			searchsql.append(" and memtype like " + " '%" + searchvalue3 + "%'");
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
			searchsql.append(" and isannualregister like " + " '" + searchvalue3 + "'");
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
		if (searchitem3.equals("meminstitute") && (!searchvalue3.equals(""))) {
			searchsql.append(" and meminstitute like " + " '%" + searchvalue3 + "%'");
		}

		if (searchitem4.equals("memname") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memname like" + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("custom") && (!searchvalue1.equals(""))) {
			searchsql.append(" and (content1 like" + " '%" + searchvalue4 + "%' OR content2 like" + " '%" + searchvalue4 + "%' OR content3 like" + " '%" + searchvalue4 + "%' OR content4 like" + " '%" + searchvalue4 + "%' OR content5 like" + " '%" + searchvalue4 + "%' OR content6 like" + " '%" + searchvalue4 + "%')");
		}
		if (searchitem4.equals("membirthday") && (!searchvalue4.equals(""))) {
			searchsql.append(" and membirthday like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memsex") && (!searchvalue4.equals(""))) {
			searchsql.append(" and memsex like " + " '%" + searchvalue4 + "%'");
		}
		if (searchitem4.equals("memparty_s") && (!searchvalue4.equals(""))) {
			searchsql.append(" and party like " + " '%" + searchvalue4 + "%'");
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
			searchsql.append(" and assoduty_f like " + " '%" + searchvalue4 + "%'");
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
			searchsql.append(" and memtype like " + " '%" + searchvalue4 + "%'");
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
			searchsql.append(" and isannualregister like " + " '" + searchvalue4 + "'");
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
		if (searchitem4.equals("meminstitute") && (!searchvalue4.equals(""))) {
			searchsql.append(" and meminstitute like " + " '%" + searchvalue4 + "%'");
		}
		// searchsql.append("order by s_id")
		return searchsql.toString();
	}

	public ISmemberbaseinfoDAO getSmemberbaseinfoDAO() {
		return smemberbaseinfoDAO;
	}

	public void setSmemberbaseinfoDAO(ISmemberbaseinfoDAO smemberbaseinfoDAO) {
		this.smemberbaseinfoDAO = smemberbaseinfoDAO;
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

}
