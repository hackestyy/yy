<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<script src="<%=contextpath%>/js/global.js">
</script>
<script Language="JavaScript" type="">
window.moveTo(0,0);
window.resizeTo(screen.availWidth,screen.availHeight);
  function warndelete(value)
{
  return confirm('确实要删除吗？');
}


var newWindow;
var newWindow1;


function email()
{
if (!newWindow1 || newWindow1.closed){
newWindow1 = openNestWindow_email("<%=contextpath%>/email.do");
}
else{
newWindow1.close();
newWindow1 = openNestWindow_email("<%=contextpath%>/email.do");
}
}
function note()
{
if (!newWindow1 || newWindow1.closed){
newWindow1 = openNestWindow_email("<%=contextpath%>/note.do");
}
else{
newWindow1.close();
newWindow1 = openNestWindow_email("<%=contextpath%>/note.do");
}
}
</script>
<HTML>
	<HEAD>
		<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
		<script Language="JavaScript" type="">
function submitForm(act)
{
    document.queryForm.searchaction.value=act;
    document.queryForm.submit();
}
function dosearch(){
  if(event.keyCode==13){
  submitForm('search');
  }
}
function dogoto(){
  if(event.keyCode==13){
    submitForm('goto');
  }
}
</script>
		<script type="text/javascript" language="JavaScript1.2"
			src="<%=contextpath%>/images/smenu/stmenu.js"></script>
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
		<script language="javascript" type="">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
  function warndelete(value)
{
  return confirm('确实要删除吗？');
}
</script>
		<base target="_self">
		<link href="css/style_cssrc.css" rel="stylesheet" type="text/css">
	</HEAD>
	<BODY>
		<div align="center">
			<div align="left">
				<TR>
					<TD width="0" height="100%" align="left" valign="top">
					<TD width="185" align="left" valign="top" bgcolor="#FFFFFF">
						<table width="100%" height="100%" border="0" cellSpacing=0
							cellPadding=0 align="left">
							<tr>
								<td height="113" colspan="2" align="left" valign="top">
									<table width="100%" height="113" border="0" cellPadding=0
										cellSpacing=0 background="images/top_03.gif">
										<tr>
											<td width="218" valign="top">
												<img src="images/top_01.gif" width="218" height="83">
											</td>
											<td>
												&nbsp;
											</td>
											<td width="465" valign="top">
												<table width="465" cellPadding=0 cellSpacing=0 border="0">
													<tr>
														<td height="83">
															<img src="images/top_05.gif" width="465" height="83">
														</td>
													</tr>
													<tr>
														<td height="30" align="right" class="">
															<%@include
																file="/WEB-INF/jsp/navigation/navigation_academyadmin.txt"%>
														</td>

													</tr>
												</table>
											</td>
											<td width="21">
												<img src="images/top_06.gif" width="21" height="113">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td width="185" align="left" valign="middle" bgcolor="#F2F5FA">
									<table width="185" height="100%" border="0" cellSpacing=0
										cellPadding=0 align="left">
										<tr>
											<td width="185" height="24" align="left" valign="top">
												<img src="images/left_01.gif" width="185" height="24">
											</td>
										</tr>
										<tr>
											<td align="left" valign="top" bgcolor="#e6f0fa">
												<table width="100%" height="250" border="0" cellPadding=0
													cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
													<tr>
														<td align="center" valign="top" bgcolor="#e6f0fa">
															<div align="left">
																<table width="100%" height="200" border="0"
																	cellPadding=0 cellSpacing=0 align="center">
																	<logic:iterate id="op" name="ACADGROUPLIST"
																		type="com.cssrc.bean.admin.Acadgroup">
																		<logic:equal name="op" property="assoname"
																			value="<%=academybaseinfoassoname%>">
																			<tr>
																				<BR>
																				<div align="left">
																					&nbsp;&nbsp;&nbsp;
																					<img src="<%=contextpath%>/images/sub.jpg"
																						width="9" height="9" alt="" align="middle">
																					<html:link
																						page="/academyadminacademybaseinfolist.do"
																						paramId="shai_id" paramName="op"
																						paramProperty="shai_id" onclick="return warn()"
																						styleClass="style14">
																						<font color="blue"> <b><font
																								face="cursive" size="2"> <bean:write
																										name="op" property="assoname" scope="page" />
																							</font>
																						</b>
																						</font>
																					</html:link>


																				</div>
																			</tr>
																		</logic:equal>
																		<logic:equal name="op" property="assoname"
																			value="<%=academybaseinfoassoname%>">
																			<logic:iterate id="academyop"
																				name="ACADEMYBASEINFOLIST"
																				type="com.cssrc.bean.admin.Academybaseinfo">
																				<logic:equal name="academyop" property="acadname"
																					value="<%=acadname%>">
																					<tr>
																						<br>
																						<div align="left">
																							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							<img src="<%=contextpath%>/images/sub.jpg"
																								width="9" height="9" alt="" align="middle">
																							<html:link
																								page="/academyadminsmemberbaseinfolist.do"
																								paramId="abi_id" paramName="academyop"
																								paramProperty="abi_id" onclick="return warn()">
																								<bean:write name="academyop" property="acadname"
																									scope="page" />
																							</html:link>
																					</tr>
																					<tr>

																						<logic:equal name="academyop" property="acadname"
																							value="<%=acadname%>">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
																								src="<%=contextpath%>/images/point.gif"
																								width="9" height="9" alt="" align="middle">
																							<html:link
																								page="/academyadminsmemberbaseinfomainlist.do"
																								paramId="abi_id" paramName="academyop"
																								paramProperty="abi_id" onclick="return warn()">
                                                          个人会员
                                                        </html:link>
																						</logic:equal>
																					</tr>
                                                <% if(acadname==null||!(acadname=acadname.trim()).endsWith("届")){%>
																					<tr>
																						<logic:equal name="academyop" property="acadname"
																							value="<%=acadname%>">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
																								src="<%=contextpath%>/images/point.gif"
																								width="9" height="9" alt="" align="middle">
																							<html:link
																								page="/academyadmingmemberbaseinfomainlist.do"
																								paramId="abi_id" paramName="academyop"
																								paramProperty="abi_id" onclick="return warn()">
                                                          团体会员
                                                        </html:link>
																						</logic:equal>
																					</tr>
                                                 <% } %>
																				</logic:equal>
																			</logic:iterate>
																		</logic:equal>
																	</logic:iterate>
																</table>
																<p>
																	&nbsp;
																</p>
															</div>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
								<td width="100%" align="left" valign="middle" bgcolor="#FFFFFF">
									<table width="100%" height="100%" cellSpacing="0"
										cellPadding="0" border="0">
										<tr valign="top">
											<td align="center">
												<table width="100%" height="100%" cellSpacing="0"
													cellPadding="0" border="0">
													<tr>
														<td align="center" valign="top">
															<br>
															<table width="90%" border="0" cellpadding="0"
																cellspacing="0">
																<tr>

																	

																	<td valign="top">
																		<table width="100%" border="0" cellpadding="0"
																			cellspacing="0">
																			<tr bgcolor="white">
																				<td height="20" colspan="5">
																					<table width="100%" border="0">
<tr>
																	<td align="center" valign="top">
																	<p>&nbsp;</p>
																	<html:form method="post" action="/stempupdate.do" enctype="multipart/form-data">
																	<html:hidden property="id" name="stempForm" />
																	<table width="90%" border="0" bordercolor="#000000">
																		<tr align="right">
																			<td height="25" colspan="2" align="right"
																				bgcolor="#93C0E1">您的邮箱服务器名：<font color="#FF0000"></td>
																			<td height="25" colspan="2" align="left"
																				bgcolor="#CDE2F1"><html:text property="stempname"
																				name="stempForm" size="27" /></td>
																			
																		</tr>
																	</table>
																	<table width="100%" align="center">
																		<tr>
																			<td height="60" align="right">
																				<input type="submit" class="button" name="strutsButton" value="更新">
																			&nbsp;&nbsp; <input name="button" type="button"
																				class="button" onclick="location.href='academyadminsmemberquerylist.do?abi_id=<%=smemberabi_id%>'" value="返回">

																			</td>
																		</tr>
																	</table>
																	</html:form>
																	</td>
																</tr>
																					</table>
																				</td>
																			</tr>
																		</table>

																	</td>
																</tr>
															</TABLE>
														</td>
													</tr>

												</table>
											</td>
										</tr>
									</table>
							</TR>
						</TABLE>
			</div>
		</div>
	</BODY>
</HTML>
