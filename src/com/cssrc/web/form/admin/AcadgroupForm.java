package com.cssrc.web.form.admin;

import org.apache.struts.validator.ValidatorForm;

public class AcadgroupForm extends ValidatorForm {
	public AcadgroupForm() {
	}

	public String getAssoname() {
		return assoname;
	}

	public Integer getBelongcount() {
		return belongcount;
	}

	public String getContactperson() {
		return contactperson;
	}

	public String getContacttelephone() {
		return contacttelephone;
	}

	public Integer getShai_id() {
		return shai_id;
	}

	public void setAssoname(String assoname) {
		this.assoname = assoname;
	}

	public void setBelongcount(Integer belongcount) {
		this.belongcount = belongcount;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public void setContacttelephone(String contacttelephone) {
		this.contacttelephone = contacttelephone;
	}

	public void setShai_id(Integer shai_id) {
		this.shai_id = shai_id;
	}

	private Integer shai_id;
	private String assoname;
	private String contactperson;
	private String contacttelephone;
	private Integer belongcount;

}
