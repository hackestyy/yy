<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String userrole = (String)session.getAttribute("userrole");%>
<%request.setAttribute("userrole",userrole); %>
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
<script Language="JavaScript" type="">

function submitForm(act)
{
    document.queryForm.searchaction.value=act;
    document.queryForm.submit();
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
                  <td width="185" height="24" align="left" valign="top"><html:link page="/acadgrouplist.do">
                  <img src="<%=contextpath%>/images/left_01.gif" width="185" height="24" border="0" alt="科协系统首页"></html:link></td>
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
                                 <b> <font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b>
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

                                    <p>  <html:form method="post" action="/academyadminlist.do">
	        <input type="hidden" name="searchaction" value="list"/>
           <TBODY>
              <TR vAlign=top>
                <TD><table cellspacing=0 cellpadding=0 width="27%" align="center" border=0>
                  <tbody align="center">
                    <tr>
                      <td width=108><div align="center"><span class=LgBlueText>检索词</span></div></td>
                      <td width=88><div align="center"><span class=LgBlueText>检索项</span></div></td>
                    </tr>
                    <tr>
                      <td><html:text property="searchvalue1" size="20" name="queryForm"/>
                        </td>
                      <td align="center"><html:select name="queryForm" property="searchitem1">
                          <html:option value="useraccount">帐号</html:option>
                          <html:option value="useracademic">学（协）会名称</html:option>
                          
                        </html:select>                      </td>
                    
                    <tr>
                     
                      <td><input  align="right" type="button" class="button" name="strutsButton2" value="查询" onClick="submitForm('search')">                      </td>
                      
                      <td><input  align="left" type="button" class="button" name="strutsButton2" value="重置" onClick="submitForm('reset')">                      </td>
                      
                    </tr>
                  </tbody>
                </table></td>
                      </tr>
                            
                            

                              <tr>

                              <td align="left"> <font face="华文新魏" size="3">&nbsp;用户管理&gt;&gt;<font color = "red">学会管理员</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              
                              <tr>
		<td height="30" align="right">
			<table>
				<tr class="blueright">
					<td class="BlueGText">
						<bean:write name="pagerHeader" scope="request" filter="false"/>
						每页记录
						<html:select name="queryForm" property="pagesize">
                                                  <html:option value="10">10</html:option>
                                                  <html:option value="20">20</html:option>
                                                  <html:option value="50">50</html:option>
                                                  <html:option value="100">100</html:option>
						</html:select>					</td>
					<td class="BlueGText">
						第




						<html:text property="curpage" size="2" onkeydown="dogoto()"/>
						页&nbsp;
						<input type="button" class="button" name="strutsButton" value="go" onClick="submitForm('goto')">					</td>
				</tr>
			</table>		</td>
	</tr>
	</html:form></p>
                              </tr>
                              
                              
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                                        <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                                          <td width="9%"> <div align="center" class="style14">帐号</div></td>
                                          
                                          <td width="10%"> <div align="center" class="style14">权限</div></td>
                                          <td width="16%"> <div align="center" class="style14">所在学会群</div></td>
                                          <td width="13%"> <div align="center" class="style14">所在学会</div></td>
                                          <td width="9%"> <div align="center" class="style14">删除</div></td>
                                          <td width="10%"> <div align="center" class="style14">修改</div></td>
                                        </tr>
                                        <logic:iterate id="op" name="ACADEMYADMINLIST" type="com.cssrc.bean.User">
                                        <tr bgcolor="white" class="tabletext" onMouseOut="this.className='tabletext'" onMouseOver="this.className='tabletextover'">
                                          <td> <div align="center"> <bean:write name="op" property="useraccount" scope="page"/>
                                            </div></td>
                                          
                                          <td><div align="center"> <bean:write name="op" property="userrole" scope="page"/>
                                            </div></td>
                                          <td> <div align="center"> <bean:write name="op" property="userassociation" scope="page"/>
                                            </div></td>
                                          <td><div align="center"> <bean:write name="op" property="useracademic" scope="page"/>
                                            </div></td>
                                          <td> <div align="center"> <html:link page="/academyadmindelete.do" paramId="ui_id" paramName="op" paramProperty="ui_id" onclick="return warndelete()">
                                              <img src="<%=contextpath%>/images/icon/delete.gif" width="16" height="16" border="0" alt="删除">
                                              </html:link> </div></td>
                                          <td> <div align="center"> <html:link page="/academyadminmodify.do" paramId="ui_id" paramName="op" paramProperty="ui_id" onclick="return warn()">
                                              <img src="<%=contextpath%>/images/icon/modify.gif" width="16" height="16" border="0" alt="修改">
                                              </html:link> </div></td>
                                        </tr>
                                        </logic:iterate>
                                        <tr class=BlackText-9p>
                                          <td>&nbsp; </td>
                                          <td>&nbsp; </td>
                                          <td>&nbsp; </td>
                                          <td>&nbsp;</td>
                                          
                                          <td align="right" colspan="2">&nbsp; </td>
                                        </tr>
                                        <tr class=BlackText-9p>
                                          <td>&nbsp; </td>
                                          <td>&nbsp; </td>
                                          <td>&nbsp; </td>
                                          <td>&nbsp;</td>
                                          
                                          <td align="right" colspan="2"> <input type="button" class="button" name="strutsButton" value="添加记录" onClick="location.href='academyadminadd.do'">
                                          &nbsp;&nbsp;
                                          <input type="button" class="button" value="返回" onClick="location.href='acadgrouplist.do'">                                          </td>
                                        </tr>
                                      </table>                </td>
              </tr>
            </TABLE>        </td>
      </tr>
    </table></td>
                                   

              </table></td>
            
          </table>       
    </TABLE>
  </div>
</div>
</BODY>
</HTML>
