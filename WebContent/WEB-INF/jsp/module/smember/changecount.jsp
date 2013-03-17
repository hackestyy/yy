<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%Integer viewabi_id = (Integer)session.getAttribute("abi_id");%>
<%Integer viewsmbi_id = (Integer)session.getAttribute("smbi_id");%>
<%Integer viewasmr_id = (Integer)session.getAttribute("asmr_id");%>
<%String memname = (String)session.getAttribute("memname");%>
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
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>
<script language="javascript">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
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
<html:form method="post" action="/countmodify.do" >
<div align="center">
  <div align="left">
        <TR>
          <TD width="0" height="100%" align="left" valign="top">
          <TD width="185" align="left" valign="top" bgcolor="#FFFFFF">
		  <table width="100%" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
            <tr>
              <td height="113" colspan="2" align="left" valign="top"><table width="100%" height="113" border="0" cellPadding=0 cellSpacing=0 background="images/top_03.gif">
                <tr>
                  <td width="218" valign="top"><img src="images/top_01.gif" width="218" height="83"></td>
                  <td rowspan="2">&nbsp;</td>
                  <td width="465" rowspan="2" valign="top"><table width="465" cellPadding=0 cellSpacing=0 border="0">
                      <tr>
                        <td height="83"><img src="images/top_05.gif" width="465" height="83"></td>
                      </tr>
                      <tr>
                        <td height="30" align="right" class="">
						<%@include file = "/WEB-INF/jsp/navigation/navigation_user.txt"%>						</td>
                      </tr>
                  </table></td>
                  <td width="21" rowspan="2"><img src="images/top_06.gif" width="21" height="113"></td>
                </tr>
                <tr>
                  <td height="30" align="left" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录，<%=memname%></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td width="185" align="left" valign="middle" bgcolor="#e6f0fa"><table width="185" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
                <tr>
                  <td width="185" height="24" align="left" valign="top"><img src="images/left_01_s.gif" width="185" height="24"></td>
                </tr>
                <tr>
                  <td align="left" valign="top" bgcolor="#e6f0fa">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#e6f0fa"><div align="left">
                            <table width="100%" height="200" border="0" cellPadding=0 cellSpacing=0 align="center">
                             <logic:iterate id="op" name="ACADGROUPLIST" type="com.cssrc.bean.admin.Acadgroup">

                              <tr>
                             <BR>
             			         <div align="left"> 
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/smemberacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                 <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>                                                       
                                  </div>
                              </tr>                      
                          
                                     
                                           
              
                              </logic:iterate>
                            </table>
                            <p>&nbsp;</p>
                        </div></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
              <td width="100%" align="left" valign="middle" bgcolor="#FFFFFF"><table width="100%" height="100%" cellSpacing="0" cellPadding="0" border="0">
                <tr valign="top">
                  <td align="center">
                    <table width="100%" height="100%" cellSpacing="0" cellPadding="0" border="0">
                      <tr>
                        <td align="center" valign="top"> <br>
                            <table width="90%"  border="0" cellpadding="0" cellspacing="0">
                              

                            <td align="left"><font face="华文新魏" size="3">&nbsp;个人会员&gt;&gt;<font color="red">修改帐号</font></font><br>
                                <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>&nbsp;</p>
                              <table width="100%" border="0" bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#e6f0fa">

                                <tr>
                                  <td width="20%" height="25" align="right" bgcolor="#93C0E1">请输入新帐号:</td>
                                  <td width="30%" align="left" bgcolor="#CDE2F1">
                                    <html:text property="memno" name="smemberbaseinfoForm" style="width:197px"/>
                                  </td>
                                </tr>
                               

                              </table>
              <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    <input name="button" type="submit" class="button"
value="确定">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="history.back()" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
              </table>

          </td>
        </tr>
    </table>
        </TR>
    </TABLE>
    </td>
    </tr>
    </table>
    </td>
    </tr>
    </table>
    </TD>
    </TR>
    </div>
    </div>
    </html:form>
</body>
</html>

