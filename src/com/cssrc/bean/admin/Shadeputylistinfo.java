package com.cssrc.bean.admin;

import java.io.Serializable;

public class Shadeputylistinfo implements Serializable {
	public String getDeputyno() {
		return deputyno;
	}

	public void setDeputyno(String deputyno) {
		this.deputyno = deputyno;
	}

	public Shadeputylistinfo() {
	}

	public String getAssoduty_f() {
		return assoduty_f;
	}

	public String getAssoduty_s() {
		return assoduty_s;
	}

	public String getDeputyidentity() {
		return deputyidentity;
	}

	public String getDeputyinstitute() {
		return deputyinstitute;
	}

	public String getDeputyname() {
		return deputyname;
	}

	public String getDeputysex() {
		return deputysex;
	}

	public String getDeputytelephone() {
		return deputytelephone;
	}

	public Integer getDeputyinfo_id() {
		return deputyinfo_id;
	}

	public Integer getBaseinfo_id() {
		return baseinfo_id;
	}

	public String getIsshsamember() {
		return isshsamember;
	}

	public void setDeputytelephone(String deputytelephone) {
		this.deputytelephone = deputytelephone;
	}

	public void setDeputysex(String deputysex) {
		this.deputysex = deputysex;
	}

	public void setDeputyname(String deputyname) {
		this.deputyname = deputyname;
	}

	public void setDeputyinstitute(String deputyinstitute) {
		this.deputyinstitute = deputyinstitute;
	}

	public void setDeputyidentity(String deputyidentity) {
		this.deputyidentity = deputyidentity;
	}

	public void setAssoduty_s(String assoduty_s) {
		this.assoduty_s = assoduty_s;
	}

	public void setAssoduty_f(String assoduty_f) {
		this.assoduty_f = assoduty_f;
	}

	public void setBaseinfo_id(Integer baseinfo_id) {
		this.baseinfo_id = baseinfo_id;
	}

	public void setDeputyinfo_id(Integer deputyinfo_id) {
		this.deputyinfo_id = deputyinfo_id;
	}

	public void setIsshsamember(String isshsamember) {
		this.isshsamember = isshsamember;
	}

	private Integer baseinfo_id;
	private Integer deputyinfo_id;
	private String deputyidentity;
	private String isshsamember;
	private String deputyname;
	private String deputysex;
	private String deputyinstitute;
	private String deputytelephone;
	private String assoduty_s;
	private String assoduty_f;
	private String deputyno;

}
