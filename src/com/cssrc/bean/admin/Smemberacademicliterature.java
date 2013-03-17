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
public class Smemberacademicliterature implements Serializable {
	public Smemberacademicliterature() {
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

	public Integer getSmal_id() {
		return smal_id;
	}

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public Date getLitedate() {
		return litedate;
	}

	public void setLitehouse(String litehouse) {
		this.litehouse = litehouse;
	}

	public void setLitejournal(String litejournal) {
		this.litejournal = litejournal;
	}

	public void setLitename(String litename) {
		this.litename = litename;
	}

	public void setSmal_id(Integer smal_id) {
		this.smal_id = smal_id;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public void setLitedate(Date litedate) {
		this.litedate = litedate;
	}

	private Integer smal_id;
	private Integer smbi_id;
	private String litename;
	private java.util.Date litedate;
	private String litejournal;
	private String litehouse;
}
