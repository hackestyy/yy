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
public class AcademygmemberrelationForm extends ActionForm {
	public AcademygmemberrelationForm() {
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public Integer getAgmr_id() {
		return agmr_id;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public Integer getGmbi_id() {
		return gmbi_id;
	}

	public String getIsannualregister() {
		return isannualregister;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public Calendar getJoindate() {
		return joindate;
	}

	public String getMemtype() {
		return memtype;
	}

	public String getTempjoindate() {
		return tempjoindate;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public void setAgmr_id(Integer agmr_id) {
		this.agmr_id = agmr_id;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	public void setGmbi_id(Integer gmbi_id) {
		this.gmbi_id = gmbi_id;
	}

	public void setIsannualregister(String isannualregister) {
		this.isannualregister = isannualregister;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public void setJoindate(Calendar joindate) {
		this.joindate = joindate;
	}

	public void setMemtype(String memtype) {
		this.memtype = memtype;
	}

	public void setTempjoindate(String tempjoindate) {
		this.tempjoindate = tempjoindate;
	}

	private Integer agmr_id;
	private Integer abi_id;
	private Integer gmbi_id;
	private String tempjoindate;
	private Calendar joindate;
	private String memtype;
	private String isannualregister;
	private String isdelete;
	private String deletedate;

}
