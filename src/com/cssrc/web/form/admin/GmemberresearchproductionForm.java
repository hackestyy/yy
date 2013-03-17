package com.cssrc.web.form.admin;

import java.util.Calendar;

import org.apache.struts.action.ActionForm;

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
public class GmemberresearchproductionForm extends ActionForm {
	public GmemberresearchproductionForm() {
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

	public Calendar getProddate() {
		return proddate;
	}

	public String getProdname() {
		return prodname;
	}

	public String getProdrewards() {
		return prodrewards;
	}

	public String getTempproddate() {
		return tempproddate;
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

	public void setProddate(Calendar proddate) {
		this.proddate = proddate;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public void setProdrewards(String prodrewards) {
		this.prodrewards = prodrewards;
	}

	public void setTempproddate(String tempproddate) {
		this.tempproddate = tempproddate;
	}

	private Integer gmrp_id;
	private Integer gmbi_id;
	private String prodname;
	private String tempproddate;
	private Calendar proddate;
	private String prodrewards;
	private String prodapplication;

}
