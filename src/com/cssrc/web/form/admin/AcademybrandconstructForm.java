package com.cssrc.web.form.admin;

import org.apache.struts.action.ActionForm;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcademybrandconstructForm extends ActionForm {
	public AcademybrandconstructForm() {
	}

	public Integer getAbc_id() {
		return abc_id;
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public String getActivememo() {
		return activememo;
	}

	public String getActivename() {
		return activename;
	}

	public String getActiveno() {
		return activeno;
	}

	public void setAbc_id(Integer abc_id) {
		this.abc_id = abc_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public void setActivememo(String activememo) {
		this.activememo = activememo;
	}

	public void setActivename(String activename) {
		this.activename = activename;
	}

	public void setActiveno(String activeno) {
		this.activeno = activeno;
	}

	private Integer abc_id;
	private Integer abi_id;
	private String activename;
	private String activeno;
	private String activememo;

}
