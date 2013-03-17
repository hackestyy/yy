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
public class Shadeputyresearchproduction implements Serializable {
	public Shadeputyresearchproduction() {
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

	public Integer getShadbi_id() {
		return shadbi_id;
	}

	public Integer getShadrp_id() {
		return shadrp_id;
	}

	public Date getProddate() {
		return proddate;
	}

	public void setShadrp_id(Integer shadrp_id) {
		this.shadrp_id = shadrp_id;
	}

	public void setShadbi_id(Integer shadbi_id) {
		this.shadbi_id = shadbi_id;
	}

	public void setProdrewards(String prodrewards) {
		this.prodrewards = prodrewards;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public void setProdapplication(String prodapplication) {
		this.prodapplication = prodapplication;
	}

	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}

	private Integer shadrp_id;
	private Integer shadbi_id;
	private String prodname;
	private java.util.Date proddate;
	private String prodrewards;
	private String prodapplication;

}
