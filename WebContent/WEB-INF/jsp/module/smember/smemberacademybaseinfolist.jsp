<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>

<%Integer viewsmbi_id = (Integer)session.getAttribute("smbi_id");%>
<%Integer viewasmr_id = (Integer)session.getAttribute("asmr_id");%>
<%String memname = (String)session.getAttribute("memname");%>
<%String shai_id = (String)session.getAttribute("SHAI_ID").toString();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<html:hidden property="abi_id" name="academybaseinfoForm"/>
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
						<a href="<%=contextpath%>/changepwd.do" target="_top">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=contextpath%>/logout.do" target="_top">退出系统</a></td>						</td>
                      </tr>
                  </table></td>
                  <td width="21" rowspan="2"><img src="images/top_06.gif" width="21" height="113"></td>
                </tr>
                <tr>
                  <td height="30" align="left" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录，<%=memname%> </td>
                </tr>
              </table>
            
            <tr>
              <td width="185" align="left" valign="middle" bgcolor="#e6f0fa"><table width="185" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
                <tr>
                  <td width="185" height="24" align="left" valign="top"><html:link page="/smemberview.do">
                  <img src="<%=contextpath%>/images/left_01_s.gif" width="185" height="24" border="0" alt="会员个人信息"></html:link></td>
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
             			         <div align="left"> <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/smemberacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link> 
                                  </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/smemberacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                   <b><font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </logic:notEqual>                                                      
                                  </div>
                              </tr>   
                              <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                              		 <logic:iterate id="academyop" name="ACADEMYBASEINFOLIST" type="com.cssrc.bean.admin.Academybaseinfo">                  
                          			<logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                     <tr>
                                        <BR>
                                          <div align="left">
                                          
                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                     <html:link page="/smembersmemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                      <bean:write name="academyop" property="acadname" scope="page"/>
                                     </html:link>  
                                        </tr>
                                        <tr>
											
                                                      
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/smembersmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          个人会员
                                                        </html:link>
                                                   
                                                </tr>
                                                <% if(acadname==null||!(acadname=acadname.trim()).endsWith("届")){%>
                                                <tr>
                                                      
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/smembergmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          团体会员
                                                        </html:link>
                                                   
                                                </tr>
                                                 <% } %>
                                                </logic:equal>
                                                
                                                <logic:equal name="academyop" property="shai_id" value="<%=shai_id%>" >
                                                
                                                <logic:notEqual name="academyop" property="acadname" value="<%=acadname%>" >
                                                <tr>
                                               <br>
                                                 <div align="left">
                                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                     <html:link page="/smembersmemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                      <bean:write name="academyop" property="acadname" scope="page"/>
                                     </html:link> 
                                     </tr>
                                       </logic:notEqual>  </logic:equal>
                                               </logic:iterate>   
              						</logic:equal>
              						  
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
                              <tr>

                                    <p>&nbsp;</p>
                              </tr>
                              <tr>
                                <td align="left"><font face="华文新魏" size="3"><font color="red">学会基本信息</font></font> <br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                             
                                  
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#e6f0fa">
                                  <tr>
                                    <td height="100"> <table width="100%" height="285" cellpadding="0" cellspacing="0" border="0"  style="BORDER-TOP:#c4c4c4 1px solid;BORDER-LEFT:#c4c4c4 1px solid; BORDER-RIGHT:#c4c4c4 1px solid; BORDER-BOTTOM:#c4c4c4 1px solid">
                                        <tr>
                                          <td align="center" valign="top"> <p>&nbsp;</p>
                                            <table width="90%" border="0" bordercolor="#000000">
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学（协）会名称:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="acadname"name="academybaseinfoForm" /></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学会代码:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="acadno"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">登记日期:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="tempregisterdate"name="academybaseinfoForm" /></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">注册资金:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="registerfund"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr align="right">
                                                <td width="15%" rowspan="2" align="right" bgcolor="#93C0E1">办公地址:</td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">1.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="address1"name="academybaseinfoForm" /></td>
                                                <td width="15%" rowspan="2" align="right" bgcolor="#93C0E1">邮政编码:</td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">1.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="postcode1"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr>
                                                <td width="5%" align="right" bgcolor="#93C0E1">2.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="address2"name="academybaseinfoForm" /></td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">2.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="postcode2"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">联系人姓名:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="contactperson"name="academybaseinfoForm" /></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1">联系电话:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="contactphone"name="academybaseinfoForm" /></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1">传真:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="contactfax"name="academybaseinfoForm"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学会星级评定:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="starlevel"name="academybaseinfoForm"/></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">主管单位:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="is311"name="academybaseinfoForm"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">业务范围:</td>
                                                <td height="25" colspan="6" align="center" bgcolor="#CDE2F1"><bean:write property="operationrange"name="academybaseinfoForm"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">工作人员总数:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="staffcount"name="academybaseinfoForm"/></td>
                                                <td width="15%" height="25" align="left" bgcolor="#93C0E1">人</td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">其中兼职人数:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="parttimecount"name="academybaseinfoForm"/></td>
                                                <td width="15%" height="25" align="left" bgcolor="#93C0E1">人</td>
                                              </tr>

                                            </table>
                </td>
              </tr>
            </TABLE>

        </td>
      </tr>
    </table></td>
                                    </tr>

              </table></td>
            </tr>
          </table>        </TR>
    </TABLE>

</BODY>
</HTML>
