<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<% String contextpath = request.getContextPath();%>
<HTML>
	<HEAD>
		<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
		<style type="text/css">
		<!-- body { margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; }
	--></style>
		<base target="name">
		<link href="<%=contextpath%>/css/style_cssrc.css" rel="stylesheet" type="text/css">
		<style type="text/css">
<!--
.TableHead {color: #000000; font-size: 12px; font-family: tahoma; font-weight: normal; text-decoration:none }
.TableHeadItem {color: #000000; font-size: 12px; font-family: tahoma; font-weight: bold; text-decoration:none }
-->
		</style>
	</HEAD>
	<BODY>
		<div align="center">
			<table width="100%" height="100%" cellSpacing="0" cellPadding="0" border="0">
				<tr>
					<td align="center" valign="top"><div align="center">
					  <table width="100%" height="100%" cellSpacing="0" cellPadding="0" border="0" style="BORDER-RIGHT:#c4c4c4 1px solid; BORDER-TOP:#c4c4c4 1px solid; BORDER-BOTTOM:#c4c4c4 1px solid">
							  <tr>
								  <td height="59" background="<%=contextpath%>/images/content_09.jpg">
								  <TABLE WIDTH="158" BORDER="0" CELLPADDING="0" CELLSPACING="0">
										  <TR>
											  <TD width="36" height="59" ROWSPAN="2">
												  <IMG SRC="<%=contextpath%>/images/CONTENT_07.jpg" WIDTH="36" HEIGHT="59" ALT=""></TD>
											  <TD width="122" height="43" class="style1">　</TD>
										  </TR>
										  <TR>
											  <TD width="122" height="16">&nbsp;
											  </TD>
										  </TR>
									</TABLE>
								  </td>
							  </tr>
							  <tr>
								  <td align="center" valign="middle">
								  <table width="416" cellSpacing="0" cellPadding="0" border="0">
									<tr>
									  <td width="416" height="25">
			<IMG height=190 alt="" src="<%=contextpath%>/images/login01.jpg"
			width=416 border=0 name=login2_r1_c1></TD>
		  </TR>
		<TR>
		  <TD height="90" background="<%=contextpath%>/images/login02.jpg">

		  <table width="100%" cellSpacing="0" cellPadding="0" border="0"><form name="FormLogin" method="post">
            <tr>
              <td height="15">&nbsp;</td>
              <td height="15">&nbsp;</td>
              <td height="15">&nbsp;</td>
            </tr>
            <tr>
              <td width="130" height="30" align="right" valign="middle" class="title-black">用户名</td>
              <td width="200" height="30" align="center" valign="middle"><input type="text" name="txt_Account">
              </td>
              <td width="86" height="60" rowspan="2" align="center" valign="middle"><input type=image alt=登录
                        src="<%=contextpath%>/images/submit.gif" border=0 name="submit" width="40" height="40"></td>
            </tr>
            <tr>
              <td width="130" height="30" align="right" valign="middle" class="title-black">密&nbsp;&nbsp;码</td>
              <td width="200" height="30" align="center" valign="middle"><input type="text" name="txt_Password"></td>
              </tr>
            <tr>
              <td height="15">&nbsp;</td>
              <td height="15">&nbsp;</td>
              <td height="15">&nbsp;</td>
            </tr></form>
          </table>
		  </TD>
		  </TR>
		  </TABLE>

							    </td>
							  </tr>
					  </table>
				  </div></td>
					<td width="2">&nbsp;</td>
				</tr>
		  </table>
		</div>
	</BODY>
</HTML>
