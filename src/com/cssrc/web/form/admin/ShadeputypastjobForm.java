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
public class ShadeputypastjobForm extends ActionForm {
	public ShadeputypastjobForm() {
	}

	public Calendar getEnddate() {
		return enddate;
	}

	public String getJobaddress() {
		return jobaddress;
	}

	public String getJobinstitute() {
		return jobinstitute;
	}

	public String getJobrank() {
		return jobrank;
	}

	public Integer getShadbi_id() {
		return shadbi_id;
	}

	public Integer getShadpj_id() {
		return shadpj_id;
	}

	public Calendar getStartdate() {
		return startdate;
	}

	public String getTempenddate() {
		return tempenddate;
	}

	public String getTempstartdate() {
		return tempstartdate;
	}

	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}

	public void setShadpj_id(Integer shadpj_id) {
		this.shadpj_id = shadpj_id;
	}

	public void setShadbi_id(Integer shadbi_id) {
		this.shadbi_id = shadbi_id;
	}

	public void setJobrank(String jobrank) {
		this.jobrank = jobrank;
	}

	public void setJobinstitute(String jobinstitute) {
		this.jobinstitute = jobinstitute;
	}

	public void setJobaddress(String jobaddress) {
		this.jobaddress = jobaddress;
	}

	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}

	public void setTempenddate(String tempenddate) {
		this.tempenddate = tempenddate;
	}

	public void setTempstartdate(String tempstartdate) {
		this.tempstartdate = tempstartdate;
	}

	private Integer shadpj_id;
	private Integer shadbi_id;
	private String jobinstitute;
	private String jobrank;
	private String tempstartdate;
	private Calendar startdate;
	private String tempenddate;
	private Calendar enddate;
	private String jobaddress;

}
