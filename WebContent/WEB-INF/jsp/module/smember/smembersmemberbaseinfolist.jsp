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
<%String shai_id = (String)session.getAttribute("SHAI_ID").toString();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%String acadname = (String)session.getAttribute("acadname");%>
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
		  <table width="100%" height="125%" border="0" cellSpacing=0 cellPadding=0 align="left">
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
                  <td height="30" align="left" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录，<%=memname%></td>
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
                                <td align="left"><font face="华文新魏" size="3"><font color="red">会员信息列表</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              	<tr>
		<td height="30" align="right">
		
		<html:form method="post" action="/smembersmemberbaseinfomainlist.do">
		<input type="hidden" name="searchaction" value="list"/>
		
			<table>
				<tr class="blueright">
					<td class="BlueGText">
						<bean:write name="pagerHeader" scope="request" filter="false"/>
						每页记录
						<html:select name="entrysearchForm" property="pagesize">
                                                  <html:option value="10">10</html:option>
                                                  <html:option value="20">20</html:option>
                                                  <html:option value="50">50</html:option>
                                                  <html:option value="100">100</html:option>
                                                  
						</html:select>
					</td>
					<td class="BlueGText">
						第


						<html:text name="entrysearchForm" property="curpage" size="2" onkeydown="dogoto()"/>
						页&nbsp;
						<input type="button" class="button" name="strutsButton" value="go" onclick="submitForm('goto')">
					</td>
					
				</tr>
			</table>
		</html:form>	
			
		</td>
	</tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                    <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">会员姓名</font></b></div>                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">性别</font></b></div>                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">工作单位</font></b></div>                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">联系电话</font></b></div>                      </td>
                    </tr>
                    <logic:iterate id="smemberop" name="SMEMBERBASEINFOLIST" type="com.cssrc.bean.admin.Smemberbainforelation">

                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="memname" scope="page"/>
                          </div>                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="memsex" scope="page"/>
                          </div>                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="meminstitute" scope="page"/>
                          </div>                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="institutetelephone" scope="page"/>
                          </div>                        </td>
                                              </tr>
                    </logic:iterate>
                    
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

