package com.cssrc.bean.admin;

import java.io.Serializable;

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
public class Academyorganizationinfo implements Serializable {
	public Academyorganizationinfo() {
	}

	public Integer getAbi_id() {
		return abi_id;
	}

	public Integer getAoi_id() {
		return aoi_id;
	}

	public String getChargeman() {
		return chargeman;
	}

	public String getContacttelephone() {
		return contacttelephone;
	}

	public String getOrganame() {
		return organame;
	}

	public Integer getStaffcount() {
		return staffcount;
	}

	public void setAbi_id(Integer abi_id) {
		this.abi_id = abi_id;
	}

	public void setAoi_id(Integer aoi_id) {
		this.aoi_id = aoi_id;
	}

	public void setChargeman(String chargeman) {
		this.chargeman = chargeman;
	}

	public void setContacttelephone(String contacttelephone) {
		this.contacttelephone = contacttelephone;
	}

	public void setOrganame(String organame) {
		this.organame = organame;
	}

	public void setStaffcount(Integer staffcount) {
		this.staffcount = staffcount;
	}

	private Integer aoi_id;
	private Integer abi_id;
	private String organame;
	private String chargeman;
	private Integer staffcount;
	private String contacttelephone;
}
