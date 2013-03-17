package com.cssrc.web.form;

import org.apache.struts.validator.ValidatorForm;

public class OnlineCtrlForm extends ValidatorForm {
	public OnlineCtrlForm() {
	}

	private Integer no;
	private Integer num;
	private Integer time;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}
