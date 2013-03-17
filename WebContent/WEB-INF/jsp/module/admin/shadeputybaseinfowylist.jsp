<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<%String assoduty_s = (String)session.getAttribute("assoduty_s");%>
<%request.setAttribute("assoduty_s",assoduty_s); %>

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
<script language="javascript">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
</script>
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
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>

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
                        <%@include file = "/WEB-INF/jsp/navigation/navigation_dbwy_jcwy.txt"%></td>

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
             				<div align="left"> 
             					<logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                <font color="blue"> <b> <font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                   <b><font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </logic:notEqual>
                                  </div>
                       </tr>
                               
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
									
									<br>
                                        <logic:equal name="assoduty_s" value="8">
                                        	<tr>
                                                <div align="left">
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=8">
                                                       第8届


                                                </a>
                                            </tr>
                                        </logic:equal>
                                        <logic:notEqual name="assoduty_s" value="8">
                                             <tr>
                                                 <div align="left">
                                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                 <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=8">
                                                        第8届


                                                 </a>
                                             </tr>
                                        </logic:notEqual>
                                        	 <tr>
                                        	 	 <logic:equal name="assoduty_s" value="8">
                                             	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                             	 <a href="<%=contextpath%>/shadeputybaseinfodblist.do?assoduty_s=8">
                                             	 代表
                                             	 </a>
                                             </tr>
                                             <tr>
                                             	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
												 <a href="<%=contextpath%>/shadeputybaseinfowylist.do?assoduty_s=8">
												 委员
												 </a>
											</tr>
                                            <tr>
                                            	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
												 <a href="<%=contextpath%>/shadeputybaseinfocwlist.do?assoduty_s=8">常委</a>
											</tr>
                                        </logic:equal>
                                    <br>
                                     			
                                     	<logic:equal name="assoduty_s" value="9">            <tr>

                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                      <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=9">
                                                          第9届


                                                      </a>

                                            </tr>
                                            </logic:equal>
												<logic:notEqual name="assoduty_s" value="9">                                                 <tr>

                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                      <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=9">
                                                          第9届


                                                      </a>

                                            </tr>
                                            </logic:notEqual>
                                            <logic:equal name="assoduty_s" value="9">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfodblist.do?assoduty_s=9">代表</a>


                                                
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfowylist.do?assoduty_s=9">委员</a>


                                                </tr>
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfocwlist.do?assoduty_s=9">常委</a>


                                                </tr>
                                                </logic:equal>
                                              <br>
                                                 <logic:equal name="assoduty_s" value="10">
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=10">
                                                          第10届


                                                    </a>
                                              	 </tr>
                                              </logic:equal>
                                              <logic:notEqual name="assoduty_s" value="10">
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=10">
                                                          第10届


                                                    </a>
                                              	 </tr>
                                              </logic:notEqual>
                                              <logic:equal name="assoduty_s" value="10">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfodblist.do?assoduty_s=10">代表</a>


                                                
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfowylist.do?assoduty_s=10">委员</a>


                                                </tr>
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfocwlist.do?assoduty_s=10">常委</a>


                                                </tr>
                                                </logic:equal>
                                                <br>
                                                 <logic:equal name="assoduty_s" value="11">
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=11">
                                                          第11届


                                                    </a>
                                              	 </tr>
                                              </logic:equal>
                                              <logic:notEqual name="assoduty_s" value="11">
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=11">
                                                          第11届


                                                    </a>
                                              	 </tr>
                                              </logic:notEqual>
                                            <logic:equal name="assoduty_s" value="11">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfodblist.do?assoduty_s=11">代表</a>


                                                
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfowylist.do?assoduty_s=11">委员</a>


                                                </tr>
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfocwlist.do?assoduty_s=11">常委</a>


                                                </tr>
                                                </logic:equal>
                                              <br>
                                                 <logic:equal name="assoduty_s" value="12">
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=12">
                                                          第12届


                                                    </a>
                                              	 </tr>
                                              </logic:equal>
                                              <logic:notEqual name="assoduty_s" value="12">
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=12">
                                                          第12届


                                                    </a>
                                              	 </tr>
                                              </logic:notEqual>
                                           <logic:equal name="assoduty_s" value="12">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfodblist.do?assoduty_s=12">代表</a>


                                                
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfowylist.do?assoduty_s=12">委员</a>


                                                </tr>
                                                <tr>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">

                                                          <a href="<%=contextpath%>/shadeputybaseinfocwlist.do?assoduty_s=12">常委</a>


                                                </tr>

                                                </logic:equal>

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
                                <td align="left"><font face="华文新魏" size="3"><%=(String)request.getSession().getAttribute("academybaseinfoassoname")%>&nbsp;&gt;&gt;&nbsp;<font color="red">委员信息列表</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
		<td height="30" align="right">


		<html:form method="post" action="/shadeputybaseinfowylist.do'">
		<input type="hidden" name="assoduty_s" value="<%=assoduty_s%>" />
		<input type="hidden" name="searchaction" value="list"/>
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
                                                  
						</html:select>
					</td>
					<td class="BlueGText">
						第






						<html:text property="curpage" size="2" onkeydown="dogoto()"/>
						页&nbsp;
						<input type="button" class="button" name="strutsButton" value="go" onclick="submitForm('goto')">
					</td>
				</tr>
			</table>

			</html:form>

		</td>

	</tr>
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                    <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                      <td width="10%">
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">会员姓名</font></b></div>
                      </td>
                      <td width="5%">
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">性别</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">工作单位</font></b></div>
                      </td>
                      <td width="15%">
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">联系电话</font></b></div>
                      </td>

                      <td width="5%">
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">详细</font></b></div>
                      </td>
                      </tr>
                    <logic:iterate id="smemberop" name="SHADEPUTYBASEINFOLIST" type="com.cssrc.bean.admin.Shadeputylistinfo">

                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="deputyname" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="deputysex" scope="page"/>
                          </div>
                        </td>
                        <td width="30%">
                          <div align="center">
                            <bean:write name="smemberop" property="deputyinstitute" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="smemberop" property="deputytelephone" scope="page"/>
                          </div>
                        </td>
 <logic:equal name="smemberop" property="isshsamember" value="YES">
                        <td>
                          <div align="center">
                            <html:link page="/shadeputybaseinfodbcwwylistview.do" paramId="smbi_id" paramName="smemberop" paramProperty="baseinfo_id">
                              <img src="<%=contextpath%>/images/icon/view.gif" width="16" height="16" border="0" alt="详细"></html:link>
                          </div>
                        </td>
                         </logic:equal>
                          <logic:equal name="smemberop" property="isshsamember" value="NO">
                            <td>
                          <div align="center">
                            <html:link page="/shadeputybaseinfodbcwwy1listview.do" paramId="shadbi_id" paramName="smemberop" paramProperty="baseinfo_id" >
                              <img src="<%=contextpath%>/images/icon/view.gif" width="16" height="16" border="0" alt="详细">
                            </html:link>
                          </div>
                        </td>
                          
                          </logic:equal>
                        </tr>
                    </logic:iterate>
                    <tr>
                    <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                    <td  align="right">
                        <input type="button" class="button" value="返回" onclick="location.href='shadeputybaseinfolist.do?assoduty_s=<%=assoduty_s%>'">
                    </td>
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
