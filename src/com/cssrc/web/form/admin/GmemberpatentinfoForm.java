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
public class GmemberpatentinfoForm extends ActionForm {
	public GmemberpatentinfoForm() {
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

	public Calendar getPatentdate() {
		return patentdate;
	}

	public String getPatentname() {
		return patentname;
	}

	public String getPatenttype() {
		return patenttype;
	}

	public String getTemppatentdate() {
		return temppatentdate;
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

	public void setPatentdate(Calendar patentdate) {
		this.patentdate = patentdate;
	}

	public void setPatentname(String patentname) {
		this.patentname = patentname;
	}

	public void setPatenttype(String patenttype) {
		this.patenttype = patenttype;
	}

	public void setTemppatentdate(String temppatentdate) {
		this.temppatentdate = temppatentdate;
	}

	private Integer gmpi_id;
	private Integer gmbi_id;
	private String patentname;
	private String temppatentdate;
	private Calendar patentdate;
	private String patenttype;
	private String patentapplication;

}
