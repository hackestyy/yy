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
public class GmemberbaseinfoForm extends ValidatorForm {
	public GmemberbaseinfoForm() {
	}

	public String getContactaddress() {
		return contactaddress;
	}

	public String getContactdepartment() {
		return contactdepartment;
	}

	public String getContactduty() {
		return contactduty;
	}

	public String getContactemail() {
		return contactemail;
	}

	public String getContactfax() {
		return contactfax;
	}

	public Integer getContacthigherstaffcount() {
		return contacthigherstaffcount;
	}

	public String getContactname() {
		return contactname;
	}

	public String getContactoperationrange() {
		return contactoperationrange;
	}

	public String getContactperson() {
		return contactperson;
	}

	public String getContactpostcode() {
		return contactpostcode;
	}

	public String getContactrank() {
		return contactrank;
	}

	public Integer getContactstaffcount() {
		return contactstaffcount;
	}

	public String getContacttelephone() {
		return contacttelephone;
	}

	public String getContacturl() {
		return contacturl;
	}

	public Integer getGmbi_id() {
		return gmbi_id;
	}

	public String getInstitutecode() {
		return institutecode;
	}

	public String getInstitutename() {
		return institutename;
	}

	public String getInstitutetype() {
		return institutetype;
	}

	public String getMemno() {
		return memno;
	}

	public String getOtherproperty() {
		return otherproperty;
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

	public void setOtherproperty(String otherproperty) {
		this.otherproperty = otherproperty;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}

	public void setInstitutetype(String institutetype) {
		this.institutetype = institutetype;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}

	public void setInstitutecode(String institutecode) {
		this.institutecode = institutecode;
	}

	public void setGmbi_id(Integer gmbi_id) {
		this.gmbi_id = gmbi_id;
	}

	public void setContacturl(String contacturl) {
		this.contacturl = contacturl;
	}

	public void setContacttelephone(String contacttelephone) {
		this.contacttelephone = contacttelephone;
	}

	public void setContactstaffcount(Integer contactstaffcount) {
		this.contactstaffcount = contactstaffcount;
	}

	public void setContactrank(String contactrank) {
		this.contactrank = contactrank;
	}

	public void setContactpostcode(String contactpostcode) {
		this.contactpostcode = contactpostcode;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public void setContactoperationrange(String contactoperationrange) {
		this.contactoperationrange = contactoperationrange;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public void setContacthigherstaffcount(Integer contacthigherstaffcount) {
		this.contacthigherstaffcount = contacthigherstaffcount;
	}

	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public void setContactduty(String contactduty) {
		this.contactduty = contactduty;
	}

	public void setContactdepartment(String contactdepartment) {
		this.contactdepartment = contactdepartment;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
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

	private Integer gmbi_id;
	private String memno;
	private String institutename;
	private String institutecode;
	private String contactname;
	private String contactduty;
	private String contactrank;
	private String institutetype;
	private String contactaddress;
	private String contactpostcode;
	private String contactdepartment;
	private String contactperson;
	private String contacttelephone;
	private String contactfax;
	private String contacturl;
	private String contactemail;
	private Integer contactstaffcount;
	private Integer contacthigherstaffcount;
	private String contactoperationrange;
	private String otherproperty;

	private Integer agmr_id;
	private Integer abi_id;
	private String tempjoindate;
	private Calendar joindate;
	private String memtype;
	private String isannualregister;
	private String isdelete;
	private String deletedate;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
