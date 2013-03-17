package com.cssrc.web.form;

import org.apache.struts.validator.ValidatorForm;

public class ChangeCountForm extends ValidatorForm {
	public ChangeCountForm() {

	}

	private String countname;
	private String olduserpwd;
	private String newuserpwd;
	private String repuserpwd;

	public String getCountname() {
		return countname;
	}

	public void setCountname(String countname) {
		this.countname = countname;
	}

	public String getNewuserpwd() {
		return newuserpwd;
	}

	public void setNewuserpwd(String newuserpwd) {
		this.newuserpwd = newuserpwd;
	}

	public String getOlduserpwd() {
		return olduserpwd;
	}

	public void setOlduserpwd(String olduserpwd) {
		this.olduserpwd = olduserpwd;
	}

	public String getRepuserpwd() {
		return repuserpwd;
	}

	public void setRepuserpwd(String repuserpwd) {
		this.repuserpwd = repuserpwd;
	}

}
