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
public class Shadeputypastjob implements Serializable {
	public Shadeputypastjob() {
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

	public Date getEnddate() {
		return enddate;
	}

	public Date getStartdate() {
		return startdate;
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

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	private Integer shadpj_id;
	private Integer shadbi_id;
	private String jobinstitute;
	private String jobrank;
	private java.util.Date startdate;
	private java.util.Date enddate;
	private String jobaddress;

}
