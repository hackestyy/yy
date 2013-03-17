package com.cssrc.web.form.admin;

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
public class AcademyjournalinfoForm extends ActionForm {
	public AcademyjournalinfoForm() {
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public Integer getAji_id() {
		return aji_id;
	}

	public String getContactaddress() {
		return contactaddress;
	}

	public String getEditorname() {
		return editorname;
	}

	public String getIsself() {
		return isself;
	}

	public String getJournalcode() {
		return journalcode;
	}

	public String getJournalname() {
		return journalname;
	}

	public Integer getPublishcount() {
		return publishcount;
	}

	public String getPublishperiod() {
		return publishperiod;
	}

	public String getContacttelephone() {
		return contacttelephone;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public void setAji_id(Integer aji_id) {
		this.aji_id = aji_id;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public void setEditorname(String editorname) {
		this.editorname = editorname;
	}

	public void setIsself(String isself) {
		this.isself = isself;
	}

	public void setJournalcode(String journalcode) {
		this.journalcode = journalcode;
	}

	public void setJournalname(String journalname) {
		this.journalname = journalname;
	}

	public void setPublishcount(Integer publishcount) {
		this.publishcount = publishcount;
	}

	public void setPublishperiod(String publishperiod) {
		this.publishperiod = publishperiod;
	}

	public void setContacttelephone(String contacttelephone) {
		this.contacttelephone = contacttelephone;
	}

	private Integer aji_id;
	private Integer abi_id;
	private String journalname;
	private String journalcode;
	private String publishperiod;
	private Integer publishcount;
	private String editorname;
	private String contactaddress;
	private String contacttelephone;
	private String isself;

}
