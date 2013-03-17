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
public class Gmemberresearchproduction implements Serializable {
	public Gmemberresearchproduction() {
	}

	public Integer getGmbi_id() {
		return gmbi_id;
	}

	public Integer getGmrp_id() {
		return gmrp_id;
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

	public Date getProddate() {
		return proddate;
	}

	public void setGmbi_id(Integer gmbi_id) {
		this.gmbi_id = gmbi_id;
	}

	public void setGmrp_id(Integer gmrp_id) {
		this.gmrp_id = gmrp_id;
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

	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}

	private Integer gmrp_id;
	private Integer gmbi_id;
	private String prodname;
	private java.util.Date proddate;
	private String prodrewards;
	private String prodapplication;
}
