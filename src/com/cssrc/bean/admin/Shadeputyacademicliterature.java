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
public class Shadeputyacademicliterature implements Serializable {
	public Shadeputyacademicliterature() {
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

	public Date getLitedate() {
		return litedate;
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

	public void setLitedate(Date litedate) {
		this.litedate = litedate;
	}

	private Integer shadal_id;
	private Integer shadbi_id;
	private String litename;
	private java.util.Date litedate;
	private String litejournal;
	private String litehouse;

}
