package com.cssrc.bean.admin;

import java.io.Serializable;

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
public class Academyspecialitycommittee implements Serializable {
	public Academyspecialitycommittee() {
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public Integer getAsc_id() {
		return asc_id;
	}

	public String getCommdirector() {
		return commdirector;
	}

	public String getCommname() {
		return commname;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public void setAsc_id(Integer asc_id) {
		this.asc_id = asc_id;
	}

	public void setCommdirector(String commdirector) {
		this.commdirector = commdirector;
	}

	public void setCommname(String commname) {
		this.commname = commname;
	}

	private Integer asc_id;
	private Integer abi_id;
	private String commname;
	private String commdirector;
}
