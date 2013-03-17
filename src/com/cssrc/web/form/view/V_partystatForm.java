package com.cssrc.web.form.view;

import org.apache.struts.action.ActionForm;

public class V_partystatForm extends ActionForm {
	public V_partystatForm() {
	}

	private Integer shai_id;
	private String party;
	private Integer abi_id;
	private Integer number;
	private Double ratio;

	public Integer getAbi_id() {
		return abi_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public Integer getShai_id() {
		return shai_id;
	}

	public void setShai_id(Integer shai_id) {
		this.shai_id = shai_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

}
