package com.cssrc.bean.admin;

import java.io.Serializable;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class Shadeputyinfo implements Serializable {
	public Shadeputyinfo() {
	}

	public String getAssoduty_f() {
		return assoduty_f;
	}

	public String getAssoduty_s() {
		return assoduty_s;
	}

	public Integer getShadbi_id() {
		return shadbi_id;
	}

	public Integer getShadi_id() {
		return shadi_id;
	}

	public void setAssoduty_f(String assoduty_f) {
		this.assoduty_f = assoduty_f;
	}

	public void setAssoduty_s(String assoduty_s) {
		this.assoduty_s = assoduty_s;
	}

	public void setShadbi_id(Integer shadbi_id) {
		this.shadbi_id = shadbi_id;
	}

	public void setShadi_id(Integer shadi_id) {
		this.shadi_id = shadi_id;
	}

	private Integer shadi_id;
	private Integer shadbi_id;
	private String assoduty_s;
	private String assoduty_f;

}
