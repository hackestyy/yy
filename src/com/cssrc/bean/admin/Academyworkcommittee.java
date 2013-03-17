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
public class Academyworkcommittee implements Serializable {
	public Academyworkcommittee() {
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public Integer getAwc_id() {
		return awc_id;
	}

	public String getCommdirector() {
		return commdirector;
	}

	public String getCommname() {
		return commname;
	}

	public void setCommname(String commname) {
		this.commname = commname;
	}

	public void setCommdirector(String commdirector) {
		this.commdirector = commdirector;
	}

	public void setAwc_id(Integer awc_id) {
		this.awc_id = awc_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	private Integer awc_id;
	private Integer abi_id;
	private String commname;
	private String commdirector;

}
