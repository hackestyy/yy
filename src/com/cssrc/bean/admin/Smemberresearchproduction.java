package com.cssrc.bean.admin;

import java.io.Serializable;
import java.util.Date;

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
public class Smemberresearchproduction implements Serializable {
	public Smemberresearchproduction() {
	}

	public String getProdapplication() {
		return prodapplication;
	}

	public String getProdname() {
		return prodname;
	}

	public String getProdrewards() {
		return prodrewards;
	}

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public Integer getSmrp_id() {
		return smrp_id;
	}

	public Date getProddate() {
		return proddate;
	}

	public void setProdapplication(String prodapplication) {
		this.prodapplication = prodapplication;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public void setProdrewards(String prodrewards) {
		this.prodrewards = prodrewards;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public void setSmrp_id(Integer smrp_id) {
		this.smrp_id = smrp_id;
	}

	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}

	private Integer smrp_id;
	private Integer smbi_id;
	private String prodname;
	private java.util.Date proddate;
	private String prodrewards;
	private String prodapplication;
}
