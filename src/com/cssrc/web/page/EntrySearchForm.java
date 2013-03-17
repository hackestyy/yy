package com.cssrc.web.page;

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

public class EntrySearchForm extends PagerForm {
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
