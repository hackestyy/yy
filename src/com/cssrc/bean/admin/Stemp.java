package com.cssrc.bean.admin;

import java.io.Serializable;

public class Stemp implements Serializable {
	public Stemp() {
	}

	private Integer id;
	private String username;
	private String stempname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStempname() {
		return stempname;
	}

	public void setStempname(String stempname) {
		this.stempname = stempname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
