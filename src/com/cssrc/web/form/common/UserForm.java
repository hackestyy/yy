package com.cssrc.web.form.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.cssrc.util.MyUtil;

public class UserForm extends ValidatorForm {
	public UserForm() {
	}

	private String username = "";
	private String userid = "";
	private String password = "";
	private String repassword = "";
	private String role = "";
	private String phone = "";
	private String email = "";
	private String oldrepassword = "";
	private String selected[];

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getRepassword() {
		return repassword;
	}

	public String getUsername() {
		return username;
	}

	public String getUserid() {
		return userid;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String[] getSelected() {
		return selected;
	}

	public String getOldrepassword() {
		return oldrepassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRepassword(String repassword) {
		this.repassword = MyUtil.encryptPassword(repassword);
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSelected(String[] selected) {
		this.selected = selected;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setOldrepassword(String oldrepassword) {
		this.oldrepassword = oldrepassword;
	}

	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
		ActionErrors errors = new ActionErrors();
		if (!password.equals(oldrepassword)) {
			errors.add("error.reg.passwd.notsame", new ActionMessage("error.reg.passwd.notsame"));
		}
		if (null == selected) {
			errors.add("error.reg.role.notselected", new ActionMessage("error.reg.role.notselected"));
		}
		return errors;
	}

}
