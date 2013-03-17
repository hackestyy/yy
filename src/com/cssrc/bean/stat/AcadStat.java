package com.cssrc.bean.stat;

import java.io.Serializable;

public class AcadStat implements Serializable {
	public AcadStat() {
	}

	public String getAcadname() {
		return acadname;
	}

	public Integer getPersonnumber() {
		return personnumber;
	}

	public String getRemark() {
		return remark;
	}

	public Integer getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(Integer serialnumber) {
		this.serialnumber = serialnumber;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setPersonnumber(Integer personnumber) {
		this.personnumber = personnumber;
	}

	public void setAcadname(String acadname) {
		this.acadname = acadname;
	}

	private Integer personnumber;
	private Integer serialnumber;
	private String acadname;
	private String remark;

}
