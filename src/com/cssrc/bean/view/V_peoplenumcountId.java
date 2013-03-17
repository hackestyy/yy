package com.cssrc.bean.view;

import java.io.Serializable;

public class V_peoplenumcountId implements Serializable {
	public V_peoplenumcountId() {
	}

	private Integer shai_id;
	private String assoname;
	private Integer abi_id;
	private String acadname;
	private String acadno;
	private Integer smbi_id;
	private String isdelete;

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

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getShai_id() {
		return shai_id;
	}

	public void setShai_id(Integer shai_id) {
		this.shai_id = shai_id;
	}

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public String getAcadno() {
		return acadno;
	}

	public void setAcadno(String acadno) {
		this.acadno = acadno;
	}

}
