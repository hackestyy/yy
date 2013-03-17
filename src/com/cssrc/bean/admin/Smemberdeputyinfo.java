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
public class Smemberdeputyinfo implements Serializable {
	public Smemberdeputyinfo() {
	}

	public String getAssoduty_f() {
		return assoduty_f;
	}

	public String getAssoduty_s() {
		return assoduty_s;
	}

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public Integer getSmdi_id() {
		return smdi_id;
	}

	public void setAssoduty_f(String assoduty_f) {
		this.assoduty_f = assoduty_f;
	}

	public void setAssoduty_s(String assoduty_s) {
		this.assoduty_s = assoduty_s;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public void setSmdi_id(Integer smdi_id) {
		this.smdi_id = smdi_id;
	}

	private Integer smdi_id;
	private Integer smbi_id;
	private String assoduty_s;
	private String assoduty_f;
}
