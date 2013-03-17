<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
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
<base target="content">
<link href="<%=contextpath%>/css/style_cssrc.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
<html:form action="/login.do" method="post" focus="ui_id">
<div align="center">
  <div align="left">
        <TR>
          <TD width="0" height="100%" align="left" valign="top">
          <TD width="185" align="left" valign="top" bgcolor="#FFFFFF">
		  <table width="100%" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
            <tr>
              <td width="100%" height="113" align="left" valign="top"><table width="100%" height="113" border="0" cellPadding=0 cellSpacing=0 background="images/top_03.gif">
                <tr>
                  <td width="218" valign="top"><img src="<%=contextpath%>/images/top_01.gif" width="218" height="83"></td>
                  <td>&nbsp;</td>
                  <td width="465" valign="top"><table width="465" cellPadding=0 cellSpacing=0 border="0">
                      <tr>
                        <td height="83"><img src="<%=contextpath%>/images/top_05.gif" width="465" height="83"></td>
                      </tr>
                      <tr>
                        <td height="30" align="right" class="QXR01">&nbsp;</td>
                      </tr>
                  </table></td>
                  <td width="21"><img src="<%=contextpath%>/images/top_06.gif" width="21" height="113"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td align="left" valign="middle" bgcolor="#FFFFFF">
			    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0>
                  <tr>
                    <td align="center" valign="middle" bgcolor="#FFFFFF">
					<table width="418" cellSpacing="0" cellPadding="0" border="0">
                      <tr>
                        <td><img src="<%=contextpath%>/images/login01.jpg" width="418" height="186"></td>
                      </tr>
                      <tr>
                        <td>
                          <table width="100%" cellSpacing="0" cellPadding="0" border="0">
                            <tr>
                              <td width="416" height="90" align="center" valign="middle" bgcolor="#3791C6">
							  <table width="80%" cellSpacing="0" cellPadding="0" height="50"  border="0">
                                  <tr>
                                    <td width="80" align="right" class="style13">用户名</td>
                                    <td width="200" align="center" valign="middle">
                                       <html:text property="useraccount" size="25" maxlength="25" name="loginForm"/>
                                    </td>
                                    <td rowspan="2" align="center" valign="middle"><input type="image" alt=登录 src="<%=contextpath%>/images/submit.gif" border=0 name="submit" width="40" height="40"></td>
                                  </tr>
                                  <tr>
                                    <td width="80" align="right" class="style13">密&nbsp;&nbsp;码</td>
                                    <td width="200" align="center" valign="middle">
                                      <html:password property="userpwd" size="25" maxlength="25" name="loginForm"/>
                                    </td>
                                  </tr>
                                  &nbsp;
                                  <tr align="center">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td colspan="3" class="style13"><label class="style7"><font color="red">出错了，请重新输入正确的用户名和密码！</font></label></td>
                                  </tr>
                              </table></td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>        </TR>
    </TABLE>
  </div>
</div>
</html:form>
</BODY>
</HTML>
