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
public class Smemberpatentinfo implements Serializable {
	public Smemberpatentinfo() {
	}

	public String getPatentisindustrialized() {
		return patentisindustrialized;
	}

	public String getPatentname() {
		return patentname;
	}

	public String getPatenttype() {
		return patenttype;
	}

	public String getPatentvalue() {
		return patentvalue;
	}

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public Integer getSmpi_id() {
		return smpi_id;
	}

	public Date getPatentdate() {
		return patentdate;
	}

	public void setPatentisindustrialized(String patentisindustrialized) {
		this.patentisindustrialized = patentisindustrialized;
	}

	public void setPatentname(String patentname) {
		this.patentname = patentname;
	}

	public void setPatenttype(String patenttype) {
		this.patenttype = patenttype;
	}

	public void setPatentvalue(String patentvalue) {
		this.patentvalue = patentvalue;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public void setSmpi_id(Integer smpi_id) {
		this.smpi_id = smpi_id;
	}

	public void setPatentdate(Date patentdate) {
		this.patentdate = patentdate;
	}

	private Integer smpi_id;
	private Integer smbi_id;
	private String patentname;
	private java.util.Date patentdate;
	private String patenttype;
	private String patentisindustrialized;
	private String patentvalue;
}
