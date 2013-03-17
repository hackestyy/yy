package com.cssrc.sys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cssrc.util.Constant;

public class CheckAdminUser {

	private String userName = "";
	private String userPassWord = "";
	private Properties props = new Properties();

	public CheckAdminUser() {
		try {
			String path = Constant.CONFIGPATH + "admininfo.properties";
			InputStream infile = new FileInputStream(path);
			// getClass().getResourceAsStream("/admininfo.properties");
			props.load(infile);
			this.userName = props.getProperty("userName");
			this.userPassWord = props.getProperty("userPassWord");
			infile.close();
		} catch (Exception e) {
			e.toString();

		}
	}

	public boolean checkUserOK(String cUserName, String cUserPassWord) {
		if (cUserName.equals(this.userName) && cUserPassWord.equals(this.userPassWord)) {
			return true;
		} else {
			return false;
		}
	}

	public void changepass(String cUserName, String cUserPassWord) {
		String path = Constant.CONFIGPATH + "admininfo.properties";
		Properties prop = new Properties();
		prop.setProperty("userName", String.valueOf(cUserName));
		prop.setProperty("userPassWord", String.valueOf(cUserPassWord));
		try {
			FileOutputStream fos = new FileOutputStream(path);
			prop.store(fos, "admininfo.properties");
			fos.close();
		} catch (FileNotFoundException ex) {

		} catch (IOException ex) {

		}
	}

}
