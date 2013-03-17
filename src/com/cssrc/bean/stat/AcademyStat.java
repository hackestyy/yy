package com.cssrc.bean.stat;

import java.io.Serializable;

public class AcademyStat implements Serializable {
	public AcademyStat() {
	}

	private Integer personnumber;
	private Integer serialnumber;
	private String acadname;
	private String remark;

	public String getAcadname() {
		return acadname;
	}

	public void setAcadname(String acadname) {
		this.acadname = acadname;
	}

	public Integer getPersonnumber() {
		return personnumber;
	}

	public void setPersonnumber(Integer personnumber) {
		this.personnumber = personnumber;
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

}
