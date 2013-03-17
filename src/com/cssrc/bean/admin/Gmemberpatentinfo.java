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
public class Gmemberpatentinfo implements Serializable {
	public Gmemberpatentinfo() {
	}

	public Integer getGmbi_id() {
		return gmbi_id;
	}

	public Integer getGmpi_id() {
		return gmpi_id;
	}

	public String getPatentapplication() {
		return patentapplication;
	}

	public String getPatentname() {
		return patentname;
	}

	public String getPatenttype() {
		return patenttype;
	}

	public Date getPatentdate() {
		return patentdate;
	}

	public void setGmbi_id(Integer gmbi_id) {
		this.gmbi_id = gmbi_id;
	}

	public void setGmpi_id(Integer gmpi_id) {
		this.gmpi_id = gmpi_id;
	}

	public void setPatentapplication(String patentapplication) {
		this.patentapplication = patentapplication;
	}

	public void setPatentname(String patentname) {
		this.patentname = patentname;
	}

	public void setPatenttype(String patenttype) {
		this.patenttype = patenttype;
	}

	public void setPatentdate(Date patentdate) {
		this.patentdate = patentdate;
	}

	private Integer gmpi_id;
	private Integer gmbi_id;
	private String patentname;
	private java.util.Date patentdate;
	private String patenttype;
	private String patentapplication;
}
