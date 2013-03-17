package com.cssrc.bean;

import java.io.Serializable;

public class User implements Serializable {
	public User() {
	}

	public Integer getUi_id() {
		return ui_id;
	}

	public String getUseracademic() {
		return useracademic;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public String getUserassociation() {
		return userassociation;
	}

	public String getUserno() {
		return userno;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public String getUserpwdmd5() {
		return userpwdmd5;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUi_id(Integer ui_id) {
		this.ui_id = ui_id;
	}

	public void setUseracademic(String useracademic) {
		this.useracademic = useracademic;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public void setUserassociation(String userassociation) {
		this.userassociation = userassociation;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public void setUserpwdmd5(String userpwdmd5) {
		this.userpwdmd5 = userpwdmd5;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	private Integer ui_id;
	private String useraccount;
	private String userpwd;
	private String userpwdmd5;
	private String userrole;
	private String userassociation;
	private String useracademic;
	private String userno;
	private int timeout;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
