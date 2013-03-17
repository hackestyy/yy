package com.cssrc.web.action.note;

public class Dllnote {
	public native static long sendnote(String s, String msg);

	static {
		System.loadLibrary("Dllnote");
	}

}
