package com.cssrc.web.form.common;

import com.cssrc.web.page.QueryPagerForm;

public class QueryForm extends QueryPagerForm {
	public QueryForm() {
	}

	public final static String SEARCH = "search";
	public final static String GOTO = "goto";
	public final static String RESET = "reset";

	private int strutsAction;
	private String strutsButton = "";

	public int getStrutsAction() {
		return strutsAction;
	}

	public String getStrutsButton() {
		return strutsButton;
	}

	public void setStrutsAction(int strutsAction) {
		this.strutsAction = strutsAction;
	}

	public void setStrutsButton(String strutsButton) {
		this.strutsButton = strutsButton;
	}
}
