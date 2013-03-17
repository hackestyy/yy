package com.cssrc.web.form.admin;

import org.apache.struts.validator.ValidatorForm;

public class AcadecustomForm extends ValidatorForm {
	public AcadecustomForm() {
	}

	private Integer smbi_id;
	private Integer no;
	private Integer id;
	private Integer abi_id;
	private String content1;
	private String content2;
	private String content3;
	private String content4;
	private String content5;
	private String content6;
	private String abino;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getContent4() {
		return content4;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
	}

	public String getContent5() {
		return content5;
	}

	public void setContent5(String content5) {
		this.content5 = content5;
	}

	public String getContent6() {
		return content6;
	}

	public void setContent6(String content6) {
		this.content6 = content6;
	}

	public Integer getSmbi_id() {
		return smbi_id;
	}

	public void setSmbi_id(Integer smbi_id) {
		this.smbi_id = smbi_id;
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public String getAbino() {
		return abino;
	}

	public void setAbino(String abino) {
		this.abino = abino;
	}

}
