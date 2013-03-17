package com.cssrc.bean;

import java.io.Serializable;

public class OnlineCtrl implements Serializable {
	public OnlineCtrl() {
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
