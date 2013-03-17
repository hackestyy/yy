package com.cssrc.web.form.view;

import org.apache.struts.action.ActionForm;

public class V_peoplenumcountForm extends ActionForm {
	public V_peoplenumcountForm() {
	}

	private Integer shai_id;
	private String assoname;
	private Integer abi_id;
	private String acadname;
	private Integer smbi_id;
	private String isdelete;
	private Integer countshai_id;
	private Integer serialnumber;
	private String remark;
	private String acadno;

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

	public Integer getCountshai_id() {
		return countshai_id;
	}

	public void setCountshai_id(Integer countshai_id) {
		this.countshai_id = countshai_id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(Integer serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getAcadno() {
		return acadno;
	}

	public void setAcadno(String acadno) {
		this.acadno = acadno;
	}

}
