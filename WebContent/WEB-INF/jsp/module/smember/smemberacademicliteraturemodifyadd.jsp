<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<script language=JavaScript src="<%=contextpath%>/js/Calendar.js" type=""></script>
<%
Integer viewabi_id = (Integer) session.getAttribute("abi_id");
%>
<%
Integer viewsmbi_id = (Integer) session.getAttribute("smbi_id");
%>
<%
Integer viewasmr_id = (Integer) session.getAttribute("asmr_id");
%>
<%
String memname = (String) session.getAttribute("memname");
%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<%Integer modifysmbi_id = (Integer)session.getAttribute("smbi_id");%>
<%Integer modifyasmr_id = (Integer)session.getAttribute("asmr_id");%>
<html:form method="post" action="/smemberacademicliteraturemodifysave1.do" enctype="multipart/form-data" onsubmit="return validateSmemberacademicliteratureForm(this);">

<HTML>
	<HEAD>
		<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
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
		<script type="text/javascript" language="JavaScript1.2"
			src="<%=contextpath%>/images/smenu/stmenu.js"></script>

<script language="javascript">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
</script>
<script language="javascript">
  function resetpwd()
  {
  	var a=document.smemberbaseinfoForm.password.value;
  	document.smemberbaseinfoForm.password.value=111111;
  }
</script>
<script language="javascript">
function change()
{
	//获得控件值


	var obj = document.smemberbaseinfoForm.memparty_s;
	var colls = document.smemberbaseinfoForm.memparty_f.options;
	var party = "";
	//申请数组
	partylist = new Array("民革","民盟","民建","民进","农工党","致公党","九三学社","台盟");
	partylist2 = new Array("","民革","民盟","民建","民进","农工党","致公党","九三学社","台盟");
	//获得radio的值


	for(var i=0; i<obj.length; i++)
	{
		if(obj[i].checked)
		{
   			party = obj[i].value;
  		}
	}
	
	if(party=="民主党派")
	{
		document.smemberbaseinfoForm.memparty_f.disabled=false;
		var index = colls.selectedIndex;
		colls.length=null;//清空下拉菜单
		for(var i=0; i<partylist.length; i++)
		{
			opt = document.createElement("OPTION");
			opt.value = partylist[i];
			opt.text = partylist[i];
			document.smemberbaseinfoForm.memparty_f.add(opt);
		}
		if(index>0){
			colls.selectedIndex = index;
		}
	}
	if(party=="中共党员"||party=="无党派")
	{
		document.smemberbaseinfoForm.memparty_f.disabled=true;
		colls.length=null;
		for(var i=0; i<partylist2.length; i++)
		{
			opt = document.createElement("OPTION");
			opt.value = partylist2[i];
			opt.text = partylist2[i];
			document.smemberbaseinfoForm.memparty_f.add(opt);
		}
	}

}

  function start1()
{
   
	document.getElementById("Button1").disabled=true;
	document.getElementById("Button1").value=3;
	window.setTimeout("tick()",1000);
}
function tick()
{
	var time = document.getElementById("Button1").value;
	if(time>0)
	{
	document.getElementById("Button1").value=time-1;
	window.setTimeout("tick()",1000);
	}
	else
	{
	document.getElementById("Button1").disabled=false;
	document.getElementById("Button1").value="更新";
	}
	
}
</script>
<script language=JavaScript src="<%=contextpath%>/js/jquery-1.4.2.min.js"></script>
<script language=JavaScript>
$(function(){
change();
});
</script>
		<base target="_self">
		<link href="css/style_cssrc.css" rel="stylesheet" type="text/css">
		<style type="text/css">
<!--
.style1 {
	color: #0000FF;
	font-weight: bold;
}
-->
</style>
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
											<td rowspan="2">
												&nbsp;
											</td>
											<td width="465" rowspan="2" valign="top">
												<table width="465" cellPadding=0 cellSpacing=0 border="0">
													<tr>
														<td height="83">
															<img src="images/top_05.gif" width="465" height="83">
														</td>
													</tr>
													<tr>
														<td height="30" align="right" class="">
															<a href="<%=contextpath%>/changepwd.do" target="_top">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="<%=contextpath%>/changeinfo.do" target="_top">修改个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="<%=contextpath%>/logout.do" target="_top">退出系统</a>
														</td>
													</tr>
												</table>
											</td>
											<td width="21" rowspan="2">
												<img src="images/top_06.gif" width="21" height="113">
											</td>
										</tr>
										<tr>
											<td height="30" align="left">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录，

												<%=memname%>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td width="185" align="left" valign="middle" bgcolor="#e6f0fa">
									<table width="185" height="100%" border="0" cellSpacing=0
										cellPadding=0 align="left">
										<tr>
											<td width="185" height="24" align="left" valign="top">
												<img src="images/left_01_s.gif" width="185" height="24">
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

																		<tr>
																			<BR>
																			<div align="left">
																				&nbsp;&nbsp;&nbsp;
																				<img src="<%=contextpath%>/images/add.jpg" width="9"
																					height="9" alt="" align="middle">
																				<html:link page="/smemberacademybaseinfolist.do"
																					paramId="shai_id" paramName="op"
																					paramProperty="shai_id" onclick="return warn()"
																					styleClass="style14">
																					<b><font face="cursive" size="2"> <bean:write
																								name="op" property="assoname" scope="page" />
																					</font>
																					</b>
																				</html:link>
																			</div>
																		</tr>




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
																	<p>
																		&nbsp;
																	</p>
																</tr>
																<tr>
																	<td align="left">
																		<font face="华文新魏" size="3"><font color="red">个人信息</font>
																		</font>
																		<br>
																		<hr color="#008000" size="3">
																	</td>
																</tr>
																<tr>
																	<td align="center" valign="top">
																		<p>
																			&nbsp;
																		</p>
																<tr>
                              <td height="30" align="left"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                  <tr>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CL.jpg" width="10" height="30"></td>
                                      <td width="10%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='changeinfo.do?asmr_id=<%=modifyasmr_id%>'>基本信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='smemberdeputyinfomodifylist1.do?smbi_id=<%=modifysmbi_id%>'>代表委员信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='academysmemberrelationmodifylist1.do?smbi_id=<%=modifysmbi_id%>'>参加学会信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='smemberpastjobmodifylist1.do?smbi_id=<%=modifysmbi_id%>'>主要工作经历</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg" bgcolor="#FFFFFF"><div align="center" class="style14 style17">
                                              <a href='smemberresearchproductionmodifylist1.do?smbi_id=<%=modifysmbi_id%>'>主要科研成果</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                      <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td><div align="center" class="style14 style17">
                                              <a href='smemberacademicliteraturemodifylist1.do?smbi_id=<%=modifysmbi_id%>'>主要学术科普论著</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                      <td width="21%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='smemberpatentinfomodifylist1.do?smbi_id=<%=modifysmbi_id%>'>专利（软件著作权）情况</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CR.jpg" width="10" height="30"></td>
                                    </tr>
                              </table></td>
                            </tr>
																<tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#e6f0fa">
                                  <tr>
                                    <td height="100"> <table width="100%" height="100" cellpadding="0" cellspacing="0" border="0" style="BORDER-LEFT:#c4c4c4 1px solid; BORDER-RIGHT:#c4c4c4 1px solid; BORDER-BOTTOM:#c4c4c4 1px solid">
                                        <tr>
                                          <td align="center" valign="top"> <p>&nbsp;</p>
                                            <table width="90%" border="0" bordercolor="#000000">
                                              <tr align="right">
                                                <td width="20%" height="25" align="center" bgcolor="#93C0E1">学术、科普论著名称<font color="#FF0000">*</font></td>
                                                <td width="30%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="litename" name="smemberacademicliteratureForm" size="27"/></td>
                                                <td width="20%" height="25" align="center" bgcolor="#93C0E1">发表日期</td>
                                                <td width="30%" height="25" align="left" bgcolor="#CDE2F1">
                                                  <html:text property="templitedate" name="smemberacademicliteratureForm" readonly="true" size="23"/>
                                                  <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(templitedate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期">
                                                </td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" align="center" bgcolor="#93C0E1">何种刊物上发表</td>
                                                <td width="30%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="litejournal" name="smemberacademicliteratureForm" size="27"/></td>
                                                <td height="25" align="center" bgcolor="#93C0E1">出版社名称</td>
                                                <td width="30%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="litehouse" name="smemberacademicliteratureForm" size="27"/></td>
                                              </tr>
                                            </table>
                                            <table width="90%"  border="0">
                                              <tr>
                                                <td colspan="2" align="center"></td>
                                                <td width="14%" align="center"></td>
                                                <td colspan="3" align="center"></td>
                                              </tr>
                                              <tr>
                                                <td width="14%"></td>
                                                <td width="29%"></td>
                                                <td></td>
                                                <td width="13%"></td>
                                                <td width="3%" align="center"></td>
                                                <td width="13%"></td>
                                              </tr>
                                              <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td align="center"></td>
                                                <td></td>
                                              </tr>
                                            </table>

                                            <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    <input name="submit" type="submit" class="button"
value="添加">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button" onclick="history.back()" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
              </table>                                        </tr>
                                      </table></td>
                                  </tr>

              </table></td>
            </tr>
															</table>
													</TR>
												</TABLE>
	</body>
</html>
  </html:form>

