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
public class Shadeputypatentinfo implements Serializable {
	public Shadeputypatentinfo() {
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

	public Integer getShadbi_id() {
		return shadbi_id;
	}

	public Integer getShadpi_id() {
		return shadpi_id;
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

	public void setShadbi_id(Integer shadbi_id) {
		this.shadbi_id = shadbi_id;
	}

	public void setShadpi_id(Integer shadpi_id) {
		this.shadpi_id = shadpi_id;
	}

	public void setPatentdate(Date patentdate) {
		this.patentdate = patentdate;
	}

	private Integer shadpi_id;
	private Integer shadbi_id;
	private String patentname;
	private java.util.Date patentdate;
	private String patenttype;
	private String patentisindustrialized;
	private String patentvalue;

}
