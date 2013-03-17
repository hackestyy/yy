package com.cssrc.web.form.admin;

import java.util.Calendar;

import org.apache.struts.validator.ValidatorForm;

public class UserLogForm extends ValidatorForm {
	public UserLogForm() {
	}

	private Integer no;
	private String user;
	private String operation;
	private Calendar time;
	private String temptime;
	private String academy;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTemptime() {
		return temptime;
	}

	public void setTemptime(String temptime) {
		this.temptime = temptime;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

}
