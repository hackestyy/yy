package com.cssrc.web.form.admin;

import java.util.Calendar;

import org.apache.struts.validator.ValidatorForm;

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
public class SmemberresearchproductionForm extends ValidatorForm {
	public SmemberresearchproductionForm() {
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

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public Integer getSmrp_id() {
		return smrp_id;
	}

	public String getTempproddate() {
		return tempproddate;
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

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public void setSmrp_id(Integer smrp_id) {
		this.smrp_id = smrp_id;
	}

	public void setTempproddate(String tempproddate) {
		this.tempproddate = tempproddate;
	}

	private Integer smrp_id;
	private Integer smbi_id;
	private String prodname;
	private String tempproddate;
	private Calendar proddate;
	private String prodrewards;
	private String prodapplication;

}
