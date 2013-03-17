package com.cssrc.web.form.admin;

import org.apache.struts.action.ActionForm;

public class FlagForm extends ActionForm {
	public FlagForm() {
	}

	private Integer flag1;
	private Integer flag2;

	public Integer getFlag1() {
		return flag1;
	}

	public void setFlag1(Integer flag1) {
		this.flag1 = flag1;
	}

	public Integer getFlag2() {
		return flag2;
	}

	public void setFlag2(Integer flag2) {
		this.flag2 = flag2;
	}

}
