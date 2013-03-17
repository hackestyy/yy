<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%String contextpath = request.getContextPath();%>
<%String userrole = (String) session.getAttribute("userrole");%>
<%request.setAttribute("userrole", userrole);

			%>
<%String STATINFO_EXCEL = (String) session.getAttribute("userrole");%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<script type="text/javascript" language="JavaScript1.2"src="<%=contextpath%>/images/smenu/stmenu.js"/>
<script language="javascript" type="">

</script>
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
  function warndeleteall()
{
  var a=confirm('确实要删除吗？');
  if(a==true)  
  {
    location.href='<%=contextpath%>/userlogdelete.do';
  }

}

  function warndelete()
{
  var a=confirm('确实要删除吗？');
  if(a==true)  
  {
    location.href='<%=contextpath%>/userlogdel.do';
  }

}
function submitForm(act)
{
    document.queryForm.searchaction.value=act;
    document.queryForm.submit();
}
function dogoto(){
  if(event.keyCode==13){
    submitForm('goto');
  }
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
					<td width="218" valign="top"><img src="images/top_01.gif"
						width="218" height="83"></td>
					<td>&nbsp;</td>
					<td width="465" valign="top">
					<table width="465" cellPadding=0 cellSpacing=0 border="0">
						<tr>
							<td height="83"><img src="images/top_05.gif" width="465"
								height="83"></td>
						</tr>
						<tr>
							<td height="30" align="right" class=""><%@include
								file="/WEB-INF/jsp/navigation/navigation_admin_sys.txt"%></td>
						</tr>
					</table>
					</td>
					<td width="21"><img src="images/top_06.gif" width="21" height="113"></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="185" align="left" valign="middle" bgcolor="#F2F5FA">
			<table width="185" height="100%" border="0" cellSpacing=0
				cellPadding=0 align="left">
				<tr>
					<td width="185" height="24" align="left" valign="top"><html:link
						page="/acadgrouplist.do">
						<img src="<%=contextpath%>/images/left_01.gif" width="185"
							height="24" border="0" alt="科协系统首页">
					</html:link></td>
				</tr>
				<tr>
					<td align="left" valign="top" bgcolor="#e6f0fa">
					<table width="100%" height="250" border="0" cellPadding=0
						cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
						<tr>
							<td align="center" valign="top" bgcolor="#e6f0fa">
							<div align="left">
							<table width="100%" height="200" border="0" cellPadding=0
								cellSpacing=0 align="center">
								<logic:iterate id="op" name="ACADGROUPLIST"
									type="com.cssrc.bean.admin.Acadgroup">
									<tr>
										<BR>
										<div align="left"><html:link page="/academybaseinfolist.do"
											paramId="shai_id" paramName="op" paramProperty="shai_id"
											onclick="return warn()">
                                &nbsp;&nbsp;&nbsp;<img
												src="<%=contextpath%>/images/add.jpg" width="9" height="9"
												alt="" align="middle" border="0">
										</html:link> <html:link page="/academybaseinfolist.do"
											paramId="shai_id" paramName="op" paramProperty="shai_id"
											onclick="return warn()" styleClass="style14">
											<b><font face="cursive" size="2"> <bean:write name="op"
												property="assoname" scope="page" /></font></b>
										</html:link></div>
									</tr>
								</logic:iterate>
							</table>

							<p>&nbsp;</p>
							</div>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
			<td width="100%" align="left" valign="middle" bgcolor="#FFFFFF">
			<table width="100%" height="100%" cellSpacing="0" cellPadding="0"
				border="0">
				<tr valign="top">
					<td align="center">
					<table width="100%" height="100%" cellSpacing="0" cellPadding="0"
						border="0">
						<tr>
							<td align="center" valign="top"><br>
							<table width="90%" border="0" cellpadding="0" cellspacing="0">
								<tr>
										<input type="hidden" name="searchaction" value="list" />
										<TBODY>
											<tr>
												<td align="left"><font face="华文新魏" size="3"><br>
												<font color="red">个人会员信息列表</font></font><br>
												<hr color="#008000" size="3">
												</td>
											</tr>
											<tr>
											
							<html:form method="post" action="/userloglist.do">
							<input type="hidden" name="searchaction" value="list"/>
												<td height="30" align="right">
												<table>
													<tr class="blueright">
														<td class="BlueGText"><bean:write name="pagerHeader"
															scope="request" filter="false" /> 每页记录 <html:select
															name="queryForm" property="pagesize">
															<html:option value="10">10</html:option>
															<html:option value="20">20</html:option>
															<html:option value="40">40</html:option>
															<html:option value="100">100</html:option>

														</html:select></td>
														
														<td class="BlueGText">第 <html:text property="curpage"
															size="2" onkeydown="dogoto()" /> 页&nbsp; <input
															type="button" class="button" name="strutsButton"
															value="go" onclick="submitForm('goto')"></td>
													</tr>
												</table>
												</td>
											</tr>
									</html:form>
								
								<tr>
									<td valign="top">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr bgcolor="white">
											<td height="20" colspan="5">
											<table width="100%" border="0">
												<tr align="center">
													<td>
													<div align="center" class="tabletop"><b><font
														face="楷体_GB2312" size="3" width="25%">时间</font></b></div>
													</td>
													<td width="100px">
													<div align="center" class="tabletop"><b><font
														face="楷体_GB2312" size="3">帐号名称</font></b></div>
													</td>
													<td>
													<div align="center" class="tabletop"><b><font
														face="楷体_GB2312" size="3" width="30%">所属学会</font></b></div>
													</td>
													<td>
													<div align="center" class="tabletop"><b><font
														face="楷体_GB2312" size="3" width="25%">操作内容</font></b></div>
													</td>
												</tr>
												<logic:iterate id="op" name="USERLOGLIST"
													type="com.cssrc.web.form.admin.UserLogForm">
													<tr bgcolor="white" class="tabletext"
														onmouseout="this.className='tabletext'"
														onmouseover="this.className='tabletextover'">
														<td>
														<div align="center"><bean:write name="op"
															property="temptime" scope="page" /></div>
														</td>
														<td>
														<div align="center"><bean:write name="op" property="user"
															scope="page" /></div>
														</td>
														<td>
														<div align="center"><bean:write name="op"
															property="academy" scope="page" /></div>
														</td>
														<td>
														<div align="center"><bean:write name="op"
															property="operation" scope="page" /></div>
														</td>
													</tr>
												</logic:iterate>
											</table>
											<table align="right">
												<tr class=BlackText-9p>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
													<td align="right" colspan="2">&nbsp;</td>
												</tr>
												<tr class=BlackText-9p>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
													<td align="right" colspan="2">
													<td colspan="3" align="right"><input type="button"
														class="button" name="strutsButton" value="删除所有日志"
														onclick="warndeleteall()"></td>
													<td colspan="3" align="right"><input type="button"
														class="button" name="strutsButton" value="删除当前页日志"
														onclick="warndelete()" ></td>
													<td colspan="3" align="right"><input type="button"
														class="button" name="strutsButton" value="下载日志"
														onclick="location.href='reportdownload.do?writeExcelClass=USERLOG'"></td>
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
					</td>
				</tr>
			</table>
					
				
	</TABLE>
</div>
</div>
</BODY>
</HTML>
