<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
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
<script language="javascript" type="">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);

function submitForm(act)
{
    document.entrysearchForm.searchaction.value=act;
    document.entrysearchForm.submit();
}
function dosearch(){
  if(event.keyCode==13){
  submitForm('search');
  }
}
function dogoto(){
  if(event.keyCode==13){
    submitForm('goto');
  }
}
function checkSelect()
{
   var iNum = 0;
   var length = 0;
   if(document.form1.selection.length == null)
   {
      length = 1;
   }
   else
   {
     length = document.form1.selection.length;
   }
   for (var i=0;i<length;i++)
   {
     var e;
     if(length == 1)
     {     
		e = document.form1.selection;
     }
     else
     {
       e = document.form1.selection[i];
     }
     if( e.checked )
        iNum++;
    }
    if( iNum == 0 )
    {
      alert('请选择一个恢复文件!');
      return ;
    }
    if( iNum > 1 )
    {
      alert('只能选择一个恢复文件!');
      return ;
    }
    if( iNum == 1 )
    {

	  if(confirm("确实要恢复数据库吗？"))
	  {
		document.form1.submit();
	  }
	  else
	  {
		alert('已经取消了恢复操作！');
	  }
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

						<%@include file = "/WEB-INF/jsp/navigation/navigation_admin_sys.txt"%>                        </td>
                      </tr>
                  </table></td>
                  <td width="21"><img src="images/top_06.gif" width="21" height="113"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td width="185" align="left" valign="middle" bgcolor="#F2F5FA"><table width="185" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
                <tr>
                  <td width="185" height="24" align="left" valign="top"><html:link page="/acadgrouplist.do">
                  <img src="<%=contextpath%>/images/left_01.gif" width="185" height="24" border="0" alt="科协系统首页"></html:link></td>
                </tr>
                <tr>
                  <td align="left" valign="top" bgcolor="#F2F5FA">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#e6f0fa"><div align="left">
                            <table width="100%" height="200" border="0" cellPadding=0 cellSpacing=0 align="center">
                            <logic:iterate id="op" name="ACADGROUPLIST" type="com.cssrc.bean.admin.Acadgroup">
                              <tr>
                             <BR>
             		<div align="left"> <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                 <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b>                                  </html:link>
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
              <td width="100%" align="left" valign="middle" bgcolor="#FFFFFF">
			  
			    <table width="100%" height="100%" cellspacing="0" cellpadding="0" border="0">
                  <tr valign="top">
                    <td align="center"><table width="100%" height="100%" cellspacing="0" cellpadding="0" border="0">
                        <tr>
                          <td align="center" valign="top"><br>
                              <table width="90%"  border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td height="30" align="right" valign="top"></td>
                                </tr>
                                <tr>
                                  <td align="left"><font face="华文新魏" size="3">数据库管理&nbsp;&gt;&gt;&nbsp;<font color="red">数据恢复</font></font><br>
                                      <hr color="#008000" size="3"></td>
                                </tr>
                                <tr>
                                  <td valign="top"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                                      <tr bgcolor="white">
                                        <td height="14" colspan="5"><table width="100%" border="0" cellpadding="0" cellspacing="2">
                                            <tr class="blueright">
                                              <td colspan="5" class="BlueGText"><div align="right"> 
                                              
                                              <html:form method="post" action="/recoverylist.do">
	        								<input type="hidden" name="searchaction" value="list"/>
											<bean:write name="pagerHeader" scope="request" filter="false"/>
											每页记录
											<html:select name="entrysearchForm" property="pagesize">
                                                  <html:option value="10">10</html:option>
                                                  <html:option value="20">20</html:option>
                                                  <html:option value="50">50</html:option>
                                                  <html:option value="100">100</html:option>
                                                  
											</html:select>
											&nbsp;&nbsp;
											
											第


											<html:text property="curpage" size="2" onkeydown="dogoto()"/>
											页&nbsp;
											<input type="button" class="button" name="strutsButton" value="go" onclick=
											"submitForm('goto')">
											
										  </html:form>
                                              
                                              </div></td>
                                            </tr>
                                            <form name="form1" action="recovery.do" >
                                            <tr heigth="16">
                                              <td width="10%" bgcolor="#80ADDA" heigth="24"><div align="center">选择</div></td>
                                              <td width="11%" bgcolor="#80ADDA" heigth="24"><div align="center">序号</div></td>
                                              <td width="58%" bgcolor="#80ADDA" heigth="24"><div align="center">备份文件名</div></td>
                                            </tr>
                                            <logic:iterate id="op" name="filesname" type="com.cssrc.bean.view.TempBean">
                                              <tr bgcolor="white" class="tabletext" onMouseOut="this.className='tabletext'" onMouseOver="this.className='tabletextover'">
                                                <td><div align="center">
                                                    <input type="checkbox" name="selection" value="<bean:write name="op" property="filesname"/>
                                                  "/></div></td>
                                                <td><div align="center">
                                                    <bean:write name="op" property="serialnumber" scope="page"/>
                                                </div></td>
                                                <td><div align="center"><div align="center">
                                                    <bean:write name="op" property="filesname" scope="page"/>
                                                </div></td>
                                              </tr>
                                            </logic:iterate>
											<tr>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
												<td><div align="right">
                                                    <input name="button" type="button" class="button" onclick="checkSelect();" value="恢复">
                                                    

												  <input name="button2" type="button" class="button" onClick="location.href='acadgrouplist.do'" value="返回">
												  </div></td>
											</tr></form>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                        </tr>
                    </table></td>
                  </tr>
                </table>
			  </TR>
    </TABLE>
  </div>
</div>
</BODY>
</HTML>
