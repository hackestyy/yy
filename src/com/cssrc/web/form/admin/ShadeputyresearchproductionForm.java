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
public class ShadeputyresearchproductionForm extends ValidatorForm {
	public ShadeputyresearchproductionForm() {
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

	public Integer getShadbi_id() {
		return shadbi_id;
	}

	public Integer getShadrp_id() {
		return shadrp_id;
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

	public void setShadbi_id(Integer shadbi_id) {
		this.shadbi_id = shadbi_id;
	}

	public void setShadrp_id(Integer shadrp_id) {
		this.shadrp_id = shadrp_id;
	}

	public void setTempproddate(String tempproddate) {
		this.tempproddate = tempproddate;
	}

	private Integer shadrp_id;
	private Integer shadbi_id;
	private String prodname;
	private String tempproddate;
	private Calendar proddate;
	private String prodrewards;
	private String prodapplication;

}
