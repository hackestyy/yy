package com.cssrc.web.filter;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cssrc.util.StringUtil;

public final class TimeoutCheckFilter implements Filter {
	private FilterConfig a;
	private static String _flddo = "timeoutpage";
	private static String _fldint = "logindo";
	protected String TIMEOUTPAGE;
	protected String LOGINDOURL;
	private static String _fldfor = "attributename";
	protected String ATTRIBUTENAME;

	public TimeoutCheckFilter() {
		a = null;
		TIMEOUTPAGE = "/WEB-INF/jsp/error/errorTimeout.jsp";
		LOGINDOURL = "login";
		ATTRIBUTENAME = "USER";
	}

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException {
		HttpServletRequest httpservletrequest = (HttpServletRequest) servletrequest;
		HttpServletResponse httpservletresponse = (HttpServletResponse) servletresponse;
		HttpSession httpsession = httpservletrequest.getSession();
		String s = httpservletrequest.getRequestURI();
		Vector vector = StringUtil.parseString(s, "/");
		int i = vector.size() - 1;
		String s1 = (String) vector.get(i);
		if ((!s1.startsWith("login.do")) &&(!s1.endsWith("login.do")) && (!s1.endsWith("logout.do")) && (!s1.startsWith("admin"))) {
			if (httpsession.getAttribute(ATTRIBUTENAME) == null) {
				servletrequest.getRequestDispatcher(TIMEOUTPAGE).forward(servletrequest, servletresponse);
				return;
			} else {
				try {
					filterchain.doFilter(servletrequest, servletresponse);
				} catch (Exception e) {
				}
				return;
			}
		} else {
			filterchain.doFilter(servletrequest, servletresponse);
			return;
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig filterconfig) {
		a = filterconfig;
		if (filterconfig.getInitParameter(_flddo) != null)
			TIMEOUTPAGE = filterconfig.getInitParameter(_flddo);
		if (filterconfig.getInitParameter(_fldint) != null)
			LOGINDOURL = filterconfig.getInitParameter(_fldint);
		if (filterconfig.getInitParameter(_fldfor) != null)
			ATTRIBUTENAME = filterconfig.getInitParameter(_fldfor);
	}
}
