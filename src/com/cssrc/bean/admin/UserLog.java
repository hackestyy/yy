package com.cssrc.bean.admin;

import java.io.Serializable;
import java.util.Calendar;

public class UserLog implements Serializable {
	public UserLog() {
	}

	private Integer no;
	private String user;
	private Calendar time;
	private String operation;
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

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

}
