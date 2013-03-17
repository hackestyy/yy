<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
td  {
	line-height: 13pt;
	font-family : ����;
	font-size : 9pt;
}
.button{
	border:1px solid #AAAAAA;
	PADDING-top:2px;
	height:20px;font:"menu";
	background-color: #e9e9e9;
	margin-bottom:1px;
}
.inputText{
	border:1px solid #AAAAAA;
	PADDING-top:2px;
	height:19px;font:"menu";
	background-color: #ffffff;
	margin-bottom:1px;
	PADDING-left:2px;
}
.inputTextarea{
	border:1px solid #AAAAAA;
	PADDING-top:2px;
	height:60px;font:"menu";
	background-color: #ffffff;
	margin-bottom:1px;
	PADDING-left:2px;
}
</style>
<title><bean:message key="error"/></title>
</head>
<body topmargin="0" leftmargin="0">

<table width="100%" height="100%" cellspacing='0' cellpadding='0' border='0'>

<tr><td valign="middle">
	<table width="400" height="157" cellspacing='0' cellpadding='0' border='0' align="center" style="background-image: url(images/bg.gif);background-position:0% 0%;background-repeat: no-repeat;">
	<tr height=30><td colspan=4></td></tr>
	<tr>
		<td width=30></td>
		<td width=110 align=center valign="top"><img src="images/error.gif"></td>
		<td width=10></td>
		<td valign="top">
			<table cellspacing='0' cellpadding='0' border='0'>
			<tr height=25 bgcolor="f4f4f4"><td colspan="2">&nbsp;&nbsp;<b><bean:message key="error.msg"/></b></td></tr>
			<tr height=10 colspan=2><td></td></tr>
			<tr>
                        <td style="PADDING-left:12px;">
                          <html:errors/><br>
			</td></tr>
			<tr height=7 colspan=2><td></td></tr>
			<tr><td colspan=2 align=right>
                          <html:button property="isee" styleClass="button" onclick="javascript:history.go(-1);"><bean:message key="db.iknow"/></html:button>
			&nbsp;&nbsp;
			</td></tr>
			</table>
		</td>
	</tr>
	</table><br>
</td></tr>
</table>
</body>
</html>
