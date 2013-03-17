<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<% String contextpath = request.getContextPath();%>


<html:html>

<head>

<title>会员编号</title>
<link href="<%=contextpath%>/css/text_zh.css" rel="stylesheet" type="text/css">
<html:base/>

<body topmargin="30">

<p>&nbsp;</p>
<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="9%" bgcolor="#80adda" class="white"  ><img src="<%=contextpath%>/images/graphics/blue.gif" width="38" height="40"></td>
    <td width="91%" bgcolor="#80adda" class="white"  >无此会员编号，请确认正确的会员编号</td>
  </tr>
  <tr align="left" valign="top" bgcolor="#80adda">
    <td colspan="2">
      <table width="100%" height="178" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="178" valign="top" bgcolor="#FFFFFF">
            <table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#80adda">
              <tr>
                <td height="149" align="center"><img src="<%=contextpath%>/images/graphics/error.gif" width="55" height="51" align="middle">
			<input type="button" class="button" value="返回请按这里" onclick="history.back()" style="cursor: hand;" >
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr align="center" bgcolor="#80adda">
    <td height="35" colspan="2" bgcolor="#80adda" class="yellow-title">&nbsp;</td>
  </tr>
</table>
<p class="lowtext">&nbsp;</p>
<p class="white">&nbsp;</p>
<div align="center"></div>
</body>
</html:html>

