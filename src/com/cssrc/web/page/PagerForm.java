package com.cssrc.web.page;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * <p>
 * Title: PagerForm
 * </p>
 * <p>
 * Description: for query
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: CSSRC IT DIVISION
 * </p>
 * 
 * @author mengbin
 * @version 1.0
 */
public class PagerForm extends ValidatorActionForm {
	static final int _fldif = 1;
	static final int a = 10;
	protected String searchitem;
	protected String condition;
	protected String searchvalue;
	protected String searchsql;
	protected int pagesize;
	protected int offset;
	protected int curpage;
	protected int totalpage;
	protected int totalrecord;

	public PagerForm() {
		searchitem = "";
		searchvalue = "";
		searchsql = "";
		pagesize = 20;
		offset = 0;
		curpage = 1;
		totalpage = 0;
		totalrecord = 0;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int i) {
		curpage = i;
	}

	public String getSearchsql() {
		return searchsql;
	}

	public void setSearchsql(String s) {
		searchsql = s;
	}

	public String getSearchitem() {
		return searchitem;
	}

	public void setSearchitem(String s) {
		searchitem = s;
	}

	public String getSearchvalue() {
		return searchvalue;
	}

	public void setSearchvalue(String s) {
		searchvalue = s;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int i) {
		pagesize = i;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int i) {
		offset = i;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int i) {
		totalpage = i;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public String getCondition() {
		return condition;
	}

	public void setTotalrecord(int i) {
		totalrecord = i;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void reset() {
		searchitem = "";

		searchvalue = "";
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
}
