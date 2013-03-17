<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%
	String contextpath = request.getContextPath();
%>
<%
	String failure = (String) request.getAttribute("failure");
%>
<%
	request.setAttribute("failure", failure);
%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员动态会籍管理系统</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<style type="text/css">
<!--
a:link {
	color: #000000;
	text-decoration: none;
}

a:visited {
	color: #000000;
	text-decoration: none;
}

a:hover {
	color: #000000;
	text-decoration: none;
}

a:active {
	color: #000000;
	text-decoration: none;
}
-->
</style>
<base target="_self">
<link href="<%=contextpath%>/css/style_cssrc.css" rel="stylesheet"
	type="text/css">
</HEAD>
<BODY>
	<html:form action="/login.do" method="post">
		<div align="center">
			<div align="left">
				<TR>
					<TD width="0" height="100%" align="left" valign="top">
					<TD width="185" align="left" valign="top" bgcolor="#FFFFFF">
						<table width="100%" height="100%" border="0" cellSpacing=0
							cellPadding=0 align="left">
							<tr>
								<td width="100%" height="113" align="left" valign="top"><table
										width="100%" height="113" border="0" cellPadding=0
										cellSpacing=0 background="images/top_03.gif">
										<tr>
											<td width="218" valign="top"><img
												src="<%=contextpath%>/images/top_01.gif" width="218"
												height="83"></td>
											<td>&nbsp;</td>
											<td width="465" valign="top"><table width="465"
													cellPadding=0 cellSpacing=0 border="0">
													<tr>
														<td height="83"><img
															src="<%=contextpath%>/images/top_05.gif" width="465"
															height="83"></td>
													</tr>
													<tr>
														<td height="30" align="right" class="QXR01">&nbsp;</td>
													</tr>
												</table></td>
											<td width="21"><img
												src="<%=contextpath%>/images/top_06.gif" width="21"
												height="113"></td>
										</tr>
									</table></td>
							</tr>
							<tr>
								<td align="left" valign="middle" bgcolor="#FFFFFF">
									<table width="100%" height="250" border="0" cellPadding=0
										cellSpacing=0>
										<tr>
											<td align="center" valign="middle" bgcolor="#FFFFFF">
												<table width="418" cellSpacing="0" cellPadding="0"
													border="0">
													<tr>
														<td><img src="<%=contextpath%>/images/login01.jpg"
															width="418" height="186"></td>
													</tr>
													<tr>
														<td>
															<table width="100%" cellSpacing="0" cellPadding="0"
																border="0">
																<tr>
																	<td width="416" height="90" align="center"
																		valign="middle" bgcolor="#3791C6"><table
																			width="303" height="62" border="0" cellpadding="0"
																			cellspacing="0">
																			<tr>
																				<td height="44"><div align="center">
																						<table width="303" height="40" border="0"
																							cellpadding="0" cellspacing="0">
																							<tr>
																								<td width="90%" height="39"><table
																										width="100%" height="40" border="0"
																										cellpadding="0" cellspacing="0">
																										<tr>
																											<td width="35%"><div align="right">用户名&nbsp;&nbsp;</div>
																											</td>
																											<td width="65%"><html:text
																													property="useraccount" style="width:180px"
																													maxlength="25" name="loginForm" /></td>
																										</tr>
																										<tr>
																											<td><div align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;</div>
																											</td>
																											<td><html:password property="userpwd"
																													style="width:180px" maxlength="25"
																													name="loginForm" /></td>
																										</tr>
																										<tr>
																											<td><div align="right">    验证码&nbsp;&nbsp;</div>
																											</td>
																											<td valign="bottom"><html:text property="uservcode"
																													style="width:180px" maxlength="25"
																													name="loginForm" /></td>
																										</tr>

																									</table></td>
																								<td width="28%"><table width="100%"
																										height="100%" border="0" cellpadding="0"
																										cellspacing="0">
																										<tr>
																											<td>&nbsp;&nbsp;<input
																												name="submit" type="image"
																												src="<%=contextpath%>/images/submit.gif"
																												alt=登录 align="center" width="40" height="40"
																												border="0">
																											</td>
																										</tr>
																										<tr>
																											<td>&nbsp;&nbsp;<img src="image.jsp" alt="验证码" align="center" />
																											</td>
																										</tr>
																									</table></td>
																							</tr>
																						</table>
																					</div></td>
																			</tr>

																			<tr>
																				<td><div align="center">
																						<logic:equal name="failure" value="failure">

																							<label class="style7"><font color="red">出错了，请重新输入正确的用户名和密码！</font>
																							</label>

																						</logic:equal>
																					</div></td>
																			</tr>
																			<tr>
																				<td><div align="center">
																						<logic:equal name="failure"
																							value="grantsfailurevcode">

																							<label class="style7"><font color="red">出错了，请输入正确的验证码！</font>
																							</label>

																						</logic:equal>
																					</div></td>
																			</tr>
																			<tr>
																				<td><div align="center">
																						<logic:equal name="failure" value="outofnum">

																							<label class="style7"><font color="red">由于登陆人数限制，请梢后再尝试登陆！</font>
																							</label>

																						</logic:equal>
																					</div></td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table></td>
													</tr>
												</table></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				</TR>
				</TABLE>
			</div>
		</div>
	</html:form>
</BODY>
</HTML>
