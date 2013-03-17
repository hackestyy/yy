package com.cssrc.web.form.admin;

import org.apache.struts.validator.ValidatorForm;

public class NotechargeForm extends ValidatorForm {
	public NotechargeForm() {
	}

	private Integer id;
	private Integer abi_id;
	private Integer num;
	private String data;
	private String abiname;
	private Double price;

	public Integer getAbi_id() {
		return abi_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getAbiname() {
		return abiname;
	}

	public void setAbiname(String abiname) {
		this.abiname = abiname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
