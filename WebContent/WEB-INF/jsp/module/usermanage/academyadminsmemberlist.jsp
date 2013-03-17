<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String userrole = (String)session.getAttribute("userrole");%>
<%request.setAttribute("userrole",userrole); %>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>
<script Language="JavaScript" type="">

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
</script>
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
  function warndelete(value)
{
  return confirm('确实要删除吗？');
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
                        <%@include file = "/WEB-INF/jsp/navigation/navigation_academyadmin.txt"%>
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
	                         <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                              <tr>
                             <BR>
             		<div align="left"> 
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academyadminacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                
                                 
                                  </div>
                              </tr>
                              </logic:equal>
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                               <logic:iterate id="academyop" name="ACADEMYBASEINFOLIST" type="com.cssrc.bean.admin.Academybaseinfo">
                                              <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                              <tr>
                                               <br>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/academyadminsmemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          <bean:write name="academyop" property="acadname" scope="page"/>
                                                        </html:link>
                                            </tr>
                                            <tr>

                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/academyadminsmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          个人会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                <% if(acadname==null||!(acadname=acadname.trim()).endsWith("届")){%>
                                                <tr>
                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/academyadmingmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          团体会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                 <% } %>
                                                </logic:equal>
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

                              <td align="left"> <font face="华文新魏" size="3">&nbsp;用户管理&gt;&gt;<font color="red">会员管理</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
							  <tr class="blueright">
                                          <td class="BlueGText"><div align="right">
										  <html:form method="post" action="/smemberlist.do">
	        								<input type="hidden" name="searchaction" value="list"/>
											<bean:write name="pagerHeader" scope="request" filter="false"/>
											每页记录
											<html:select name="entrysearchForm" property="pagesize">
                                                  <html:option value="10">10</html:option>
                                                  <html:option value="20">20</html:option>
                                                  <html:option value="50">50</html:option>
                                                  <html:option value="100">100</html:option>
                                                  
											</html:select>
					
											
											第


											<html:text name="entrysearchForm" property="curpage" size="2" onkeydown="dogoto()"/>
											页&nbsp;
											<input type="button" class="button" name="strutsButton" value="go" onclick=
											"submitForm('goto')">
											
										  </html:form>
										  
										  </div></td>
                              </tr>
							  
                              <tr>
							  
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                                        <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                                          <td width="7%"> <div align="center" class="style14">帐号</div></td>
                                          <td width="11%"> <div align="center" class="style14">会员编号</div></td>
                                          
                                          <td width="5%"> <div align="center" class="style14">权限</div></td>
                                          
                                          <td width="10%"> <div align="center" class="style14">删除</div></td>
                                          <td width="10%"> <div align="center" class="style14">修改</div></td>
                                        </tr>
                                        <logic:iterate id="op" name="SMEMBERLIST" type="com.cssrc.bean.User">
                                        <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                                          <td> <div align="center"> <bean:write name="op" property="useraccount" scope="page"/>
                                            </div></td>
                                            <td> <div align="center"> <bean:write name="op" property="userno" scope="page"/>
                                            </div></td>
                                          
                                          <td><div align="center"> <bean:write name="op" property="userrole" scope="page"/>
                                            </div></td>
                                          
                                          <td> <div align="center"> <html:link page="/academyadminsmemberdelete.do" paramId="ui_id" paramName="op" paramProperty="ui_id" onclick="return warndelete()">
                                              <img src="<%=contextpath%>/images/icon/delete.gif" width="16" height="16" border="0" alt="删除">
                                              </html:link> </div></td>
                                          <td> <div align="center"> <html:link page="/academyadminsmembermodify.do" paramId="ui_id" paramName="op" paramProperty="ui_id" onclick="return warn()">
                                              <img src="<%=contextpath%>/images/icon/modify.gif" width="16" height="16" border="0" alt="修改">
                                              </html:link> </div></td>
                                        </tr>
                                        </logic:iterate>
                                        <tr class=BlackText-9p>
                                          <td>&nbsp; </td>
                                          
                                          <td>&nbsp; </td>
                                          
                                          
                                          <td align="right">&nbsp; </td>
                                          <td colspan="2" align="right">&nbsp;</td>
                                        </tr>
                                        <tr class=BlackText-9p>
                                          <td>&nbsp; </td>
                                          
                                          <td>&nbsp; </td>
                                         
                                          
                                          
                                          <td colspan="3" align="right"><input type="button" class="button" name="strutsButton" value="添加记录" onclick="location.href='academyadminsmemberadd.do'">
                                          &nbsp;&nbsp;
                                          <input type="button" class="button" value="返回" onclick="location.href='academyadminsmemberbaseinfomainlist.do'"></td>
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
  </div>
</div>
</BODY>
</HTML>
