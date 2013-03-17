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
public class Smemberpastjob implements Serializable {
	public Smemberpastjob() {
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

	public Date getEnddate() {
		return enddate;
	}

	public Date getStartdate() {
		return startdate;
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

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	private Integer smpj_id;
	private Integer smbi_id;
	private String jobinstitute;
	private String jobrank;
	private java.util.Date startdate;
	private java.util.Date enddate;
	private String jobaddress;
}
