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
public class SmemberpastjobForm extends ActionForm {
	public SmemberpastjobForm() {
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

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public Integer getSmpj_id() {
		return smpj_id;
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

	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}

	public void setJobaddress(String jobaddress) {
		this.jobaddress = jobaddress;
	}

	public void setJobinstitute(String jobinstitute) {
		this.jobinstitute = jobinstitute;
	}

	public void setJobrank(String jobrank) {
		this.jobrank = jobrank;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public void setSmpj_id(Integer smpj_id) {
		this.smpj_id = smpj_id;
	}

	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}

	public void setTempenddate(String tempenddate) {
		this.tempenddate = tempenddate;
	}

	public void setTempstartdate(String tempstartdate) {
		this.tempstartdate = tempstartdate;
	}

	private Integer smpj_id;
	private Integer smbi_id;
	private String jobinstitute;
	private String jobrank;
	private String tempstartdate;
	private Calendar startdate;
	private String tempenddate;
	private Calendar enddate;
	private String jobaddress;

}
