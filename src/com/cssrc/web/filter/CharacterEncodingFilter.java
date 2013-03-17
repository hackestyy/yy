package com.cssrc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class CharacterEncodingFilter implements Filter {

	protected String encoding;
	protected FilterConfig filterConfig;
	protected boolean ignore;

	public CharacterEncodingFilter() {
		encoding = null;
		filterConfig = null;
		ignore = true;
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException {
		if (ignore || servletrequest.getCharacterEncoding() == null) {
			String s = selectEncoding(servletrequest);
			if (s != null)
				servletrequest.setCharacterEncoding(s);
		}
		try {
			filterchain.doFilter(servletrequest, servletresponse);
		} catch (Exception e) {
		}
	}

	public void init(FilterConfig filterconfig) throws ServletException {
		filterConfig = filterconfig;
		encoding = filterconfig.getInitParameter("encoding");
		String s = filterconfig.getInitParameter("ignore");
		if (s == null)
			ignore = true;
		else if (s.equalsIgnoreCase("true"))
			ignore = true;
		else if (s.equalsIgnoreCase("yes"))
			ignore = true;
		else
			ignore = false;
	}

	protected String selectEncoding(ServletRequest servletrequest) {
		return encoding;
	}
}
