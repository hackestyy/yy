package com.cssrc.bean.admin;

import java.io.Serializable;

public class Tempsmember implements Serializable {
	public Tempsmember() {
	}

	private Integer shai_id;
	private String assoname;
	private Integer abi_id;
	private String acadname;

	public Integer getAbi_id() {
		return abi_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public String getAcadname() {
		return acadname;
	}

	public void setAcadname(String acadname) {
		this.acadname = acadname;
	}

	public String getAssoname() {
		return assoname;
	}

	public void setAssoname(String assoname) {
		this.assoname = assoname;
	}

	public Integer getShai_id() {
		return shai_id;
	}

	public void setShai_id(Integer shai_id) {
		this.shai_id = shai_id;
	}
}
