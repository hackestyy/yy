package com.cssrc.web.form.admin;

import java.util.Calendar;

import org.apache.struts.validator.ValidatorForm;

public class GroupStatForm extends ValidatorForm {
	public GroupStatForm() {
	}

	private Integer num;
	private Integer newnum;
	private Calendar time;
	private Double ratio;
	private Integer abi_id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNewnum() {
		return newnum;
	}

	public void setNewnum(Integer newnum) {
		this.newnum = newnum;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

}
