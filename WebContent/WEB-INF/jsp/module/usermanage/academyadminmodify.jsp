<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<html:form method="post" action="/academyadminupdate.do" onsubmit="return validateUserForm(this);">
 <html:hidden property="ui_id" name="userForm"/>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>
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
<script type="text/javascript" language="javascript">
var count;  
count=0;
subcat = new Array();
<logic:iterate id="gg" name="ACADEMIESLIST">
	subcat[count++] = new Array("<bean:write name="gg" property="shai_id"/>",
								"<bean:write name="gg" property="acadname"/>"
								 );
</logic:iterate>

function onsel()
{
	var shai_id = document.userForm.userassociation.value;
	if(shai_id=='0')
    {

    	document.userForm.useracademic.length=0;
    	
    	opt=document.createElement ("OPTION");
    	
    	opt.value=0;
    	opt.text="--请选择--";
    	document.userForm.useracademic.add(opt);
    }
    else{
    document.userForm.useracademic.length=0;
	for (i=0;i < count; i++)
	{
		if (subcat[i][0] == shai_id)
		{
			opt=document.createElement ("OPTION");
			opt.value=subcat[i][1];
			opt.text=subcat[i][1];			
			document.userForm.useracademic.add(opt);
		}
		
	}
	}
}
</script>
<script language="javascript">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
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
		  <table width="100%" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
            <tr>
              <td height="113" colspan="2" align="left" valign="top"><table width="100%" height="113" border="0" cellPadding=0 cellSpacing=0 background="images/top_03.gif">
                <tr>
                  <td width="218" valign="top"><img src="images/top_01.gif" width="218" height="83"></td>
                  <td>&nbsp;</td>
                  <td width="465" valign="top"><table width="465" cellPadding=0 cellSpacing=0 border="0">
                      <tr>
                        <td height="83"><img src="images/top_05.gif" width="465" height="83"></td>
                      </tr>
                      <tr>
                        <td height="30" align="right" class="">
                        <%@include file = "/WEB-INF/jsp/navigation/navigation_admin_sys.txt"%>
                        </td>

                      </tr>
                  </table></td>
                  <td width="21"><img src="images/top_06.gif" width="21" height="113"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td width="185" align="left" valign="middle" bgcolor="#F2F5FA"><table width="185" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
                <tr>
                  <td width="185" height="24" align="left" valign="top"><img src="images/left_01.gif" width="185" height="24"></td>
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
             <div align="left"> <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                 <b> <font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
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
                              <tr>
                                <p>&nbsp;</p>
                              </tr>
                              <tr>

                            <td align="left"> <font face="华文新魏" size="3">&nbsp;用户管理&gt;&gt;<font color = "red">修改学会管理员</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>&nbsp;</p>
                              <table width="90%" border="0" bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#e6f0fa">

                                <tr>
                                  <td width="20%" height="25" align="right" bgcolor="#93C0E1">帐号:</td>
                                  <td width="30%" align="left" bgcolor="#CDE2F1">
                                    <html:text property="useraccount"name="userForm" size="27"/>
                                  </td>
                                  <td width="20%" height="25" align="right" bgcolor="#93C0E1">密码:</td>
                                  <td width="30%" align="left" bgcolor="#CDE2F1">
                                    <html:password property="userpwd"name="userForm" style="width:207px"/>
                                  </td>
                                </tr>
                                <tr>
                                  <td width="20%" height="25" align="right" bgcolor="#93C0E1">所在学会群:</td>

                                  <td width="30%" align="left" bgcolor="#CDE2F1">
                                  <logic:empty name="userForm" property="userassociation">
                                  <html:select name="userForm" property="userassociation" onchange="onsel();" style="width:197px">
                                  <option value="0" selected>--请选择--</option>
                                  	<logic:iterate id="op" name="SYSACADGROUP">   
                						<option value="<bean:write name="op" property="shai_id"/>">
                  							<bean:write name="op" property="assoname"/>
                						</option>   
              						</logic:iterate>   
                                  </html:select>
                                  </logic:empty>
                                  <logic:notEmpty name="userForm" property="userassociation">
                                  	<html:text name="userForm" property="userassociation" readonly="true" size="27"/>
                                  </logic:notEmpty>
                                  </td>
                                
                                  <td width="20%" height="25" align="right" bgcolor="#93C0E1">所在学会:</td>
                                  <td width="30%" align="left" bgcolor="#CDE2F1">
                                  <logic:empty name="userForm" property="useracademic">
                                  <html:select name="userForm" property="useracademic" style="width:207px">   
           						   		<option value="0"  selected>--请选择--</option>   
           						   </html:select>
           						  </logic:empty>
           						  <logic:notEmpty name="userForm" property="useracademic">
                                  	<html:text name="userForm" property="useracademic" readonly="true" size="27" style="width:207px"/>
                                  </logic:notEmpty>
                                  </td>
                                  
                                  
                                </tr>
								<tr>
                                  <td width="20%" height="25" align="right" bgcolor="#93C0E1">权限:</td>
                                  <td width="30%" align="left" bgcolor="#CDE2F1">
                                    <html:select name="userForm" property="userrole" style="width:197px">
                          <html:option value="SystemAdmin">系统管理员</html:option>
                           <html:option value="VIP">VIP</html:option>
                           <html:option value="AcademyAdmin">学会管理员</html:option>
                           
                           
                         </html:select>
                                  </td>
                                  
                                </tr>
                              </table>
              <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    <input name="submit" type="submit" class="button"
value="更新">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="history.back()" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
              </table>

          </td>
        </tr>
    </table></td>
                                    </tr>

              </table></td>
            </tr>
          </table>
        </TR>
    </TABLE>
  </div>
  </body>
  </html>
  </html:form>
<html:javascript formName="userForm"/>