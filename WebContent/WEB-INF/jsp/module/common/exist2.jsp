<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String memidentity = (String)session.getAttribute("memidentity");%>
<% String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String) session.getAttribute("academybaseinfoassoname");%>
<%Integer viewabi_id = (Integer) session.getAttribute("abi_id");%>
<%String acadname = (String) session.getAttribute("acadname");%>
<%Integer viewsmbi_id = (Integer) session.getAttribute("smbi_id");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册验证</title>
</head>
<body topmargin="30">
<p>&nbsp;</p>
<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="9%" bgcolor="#80adda" class="white" height="40" align="center">
    该会员已经在其他学会中注册过，没有在本学会中注册，可以注册！</td>

  </tr>

  <tr align="left" valign="top" bgcolor="#80adda">
    <td colspan="2">
      <table width="100%" height="178" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="178" valign="top" bgcolor="#FFFFFF">
            <table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#80adda">
              <tr>
                <td width="50%" height="149" align="center"><img src="<%=contextpath%>/images/graphics/error.gif" width="55" height="51" align="middle">
			<input type="button" class="button" value="继续注册！" onclick="location.href='smemberbaseinfoadd1.do?abi_id=<%=smemberabi_id%>'" style="cursor: hand;" >
                </td>
                <td width="50%" height="149" align="center"><img src="<%=contextpath%>/images/graphics/error.gif" width="55" height="51" align="middle">
			<input type="button" class="button" value="返回！" onclick="history.back()" style="cursor: hand;" >
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
 <!--  <html:hidden name="smemberbaseinfoForm" property="memidentity"/> -->
  <tr align="center" bgcolor="#80adda">
    <td height="35" colspan="2" bgcolor="#80adda" class="yellow-title">&nbsp;</td>
  </tr>
</table>
<p class="lowtext">&nbsp;</p>
<p class="white">&nbsp;</p>
<div align="center"></div>
</body>
</html>
