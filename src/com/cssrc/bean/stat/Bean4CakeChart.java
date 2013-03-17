package com.cssrc.bean.stat;

import java.io.Serializable;

public class Bean4CakeChart implements Serializable {
	public Bean4CakeChart() {
	}

	private String agesegment;
	private Double ratio;

	public String getAgesegment() {
		return agesegment;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setAgesegment(String agesegment) {
		this.agesegment = agesegment;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

}
