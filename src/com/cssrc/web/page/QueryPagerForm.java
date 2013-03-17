package com.cssrc.web.page;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:UserUpdate
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:CSSRC IT DIVISION
 * </p>
 * 
 * @author mengbin
 * @version 1.0
 */
public class QueryPagerForm extends ValidatorActionForm {

	static final int _fldif = 1;
	static final int a = 10;
	protected String searchitem1;
	protected String searchitem2;
	protected String searchitem3;
	protected String searchitem4;
	protected String condition;
	protected String searchvalue1;
	protected String searchvalue2;
	protected String searchvalue3;
	protected String searchvalue4;
	protected String join1;
	protected String join2;
	protected String join3;
	protected String searchsql;
	protected int pagesize;
	protected int offset;
	protected int curpage;
	protected int totalpage;
	protected int totalrecord;

	public QueryPagerForm() {
		searchitem1 = "";
		searchitem2 = "";
		searchitem3 = "";
		searchitem4 = "";
		condition = "";
		searchvalue1 = "";
		searchvalue2 = "";
		searchvalue3 = "";
		searchvalue4 = "";
		join1 = "0";
		join2 = "0";
		join3 = "0";
		searchsql = "";
		pagesize = 20;
		offset = 0;
		curpage = 1;
		totalpage = 0;
		totalrecord = 0;

	}

	public void reset() {
		searchitem1 = "";
		searchitem2 = "";
		searchitem3 = "";
		searchitem4 = "";
		condition = "";
		searchvalue1 = "";
		searchvalue2 = "";
		searchvalue3 = "";
		searchvalue4 = "";
		join1 = "0";
		join2 = "0";
		join3 = "0";
		searchsql = "";
		pagesize = 20;
		offset = 0;
		curpage = 1;
		totalpage = 0;
		totalrecord = 0;
	}

	public void resetReseach() {
		offset = 0;
		curpage = 1;
		totalpage = 0;
		totalrecord = 0;
	}

	public String toString() {
		StringBuffer stringbuffer = new StringBuffer();
		stringbuffer.append("[] totalrecord = " + getTotalrecord());
		return stringbuffer.toString();
	}

	public String getCondition() {
		return condition;
	}

	public int getCurpage() {
		return curpage;
	}

	public String getJoin1() {
		return join1;
	}

	public String getJoin2() {
		return join2;
	}

	public int getOffset() {
		return offset;
	}

	public int getPagesize() {
		return pagesize;
	}

	public String getSearchitem1() {
		return searchitem1;
	}

	public String getSearchitem2() {
		return searchitem2;
	}

	public String getSearchitem3() {
		return searchitem3;
	}

	public String getSearchsql() {
		return searchsql;
	}

	public String getSearchvalue1() {
		return searchvalue1;
	}

	public String getSearchvalue2() {
		return searchvalue2;
	}

	public String getSearchvalue3() {
		return searchvalue3;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public String getJoin3() {
		return join3;
	}

	public String getSearchitem4() {
		return searchitem4;
	}

	public String getSearchvalue4() {
		return searchvalue4;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public void setSearchvalue3(String searchvalue3) {
		this.searchvalue3 = searchvalue3;
	}

	public void setSearchvalue2(String searchvalue2) {
		this.searchvalue2 = searchvalue2;
	}

	public void setSearchsql(String searchsql) {
		this.searchsql = searchsql;
	}

	public void setSearchvalue1(String searchvalue1) {
		this.searchvalue1 = searchvalue1;
	}

	public void setSearchitem3(String searchitem3) {
		this.searchitem3 = searchitem3;
	}

	public void setSearchitem2(String searchitem2) {
		this.searchitem2 = searchitem2;
	}

	public void setSearchitem1(String searchitem1) {
		this.searchitem1 = searchitem1;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setJoin2(String join2) {
		this.join2 = join2;
	}

	public void setJoin1(String join1) {
		this.join1 = join1;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setJoin3(String join3) {
		this.join3 = join3;
	}

	public void setSearchitem4(String searchitem4) {
		this.searchitem4 = searchitem4;
	}

	public void setSearchvalue4(String searchvalue4) {
		this.searchvalue4 = searchvalue4;
	}

}
