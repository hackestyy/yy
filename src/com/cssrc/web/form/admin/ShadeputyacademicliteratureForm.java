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
public class ShadeputyacademicliteratureForm extends ValidatorForm {
	public ShadeputyacademicliteratureForm() {
	}

	public Calendar getLitedate() {
		return litedate;
	}

	public String getLitehouse() {
		return litehouse;
	}

	public String getLitejournal() {
		return litejournal;
	}

	public String getLitename() {
		return litename;
	}

	public Integer getShadal_id() {
		return shadal_id;
	}

	public Integer getShadbi_id() {
		return shadbi_id;
	}

	public String getTemplitedate() {
		return templitedate;
	}

	public void setShadbi_id(Integer shadbi_id) {
		this.shadbi_id = shadbi_id;
	}

	public void setShadal_id(Integer shadal_id) {
		this.shadal_id = shadal_id;
	}

	public void setLitename(String litename) {
		this.litename = litename;
	}

	public void setLitejournal(String litejournal) {
		this.litejournal = litejournal;
	}

	public void setLitehouse(String litehouse) {
		this.litehouse = litehouse;
	}

	public void setLitedate(Calendar litedate) {
		this.litedate = litedate;
	}

	public void setTemplitedate(String templitedate) {
		this.templitedate = templitedate;
	}

	private Integer shadal_id;
	private Integer shadbi_id;
	private String litename;
	private String templitedate;
	private Calendar litedate;
	private String litejournal;
	private String litehouse;

}
