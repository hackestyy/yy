<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer viewabi_id = (Integer)session.getAttribute("abi_id");%>
<%Integer viewasmr_id = (Integer)session.getAttribute("asmr_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<%Integer viewsmbi_id = (Integer)session.getAttribute("smbi_id");%>
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
                        <%@include file = "/WEB-INF/jsp/navigation/navigation_dbwy_vipall.txt"%>
                        
                        
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
                  <td align="left" valign="top" bgcolor="#F2F5FA">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#e6f0fa"><div align="left">
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
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                   <b><font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </logic:notEqual>
                                  </div>
                       </tr>
                               
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
									
									<br>
                                        
                                       
                                             <tr>
                                                 <div align="left">
                                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                 <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=8">
                                                        第8届




                                                 </a>
                                             </tr>
                                      
                                        	 
                                    <br>
                                     			
                                    
                                    
												<tr>

                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                      <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=9">
                                                          第9届




                                                      </a>

                                            </tr>
                                            
                                              <br>
                                                 
                                                 
                                              
                                              
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=10">
                                                          第10届




                                                    </a>
                                              	 </tr>
                                            
                                                <br>
                                                 
                                              
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=11">
                                                          第11届




                                                    </a>
                                              	 </tr>
                                              
                                              <br>
                                                 
                                                 
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=12">
                                                          第12届




                                                    </a>
                                              	 </tr>
                                              

                                      </logic:equal>
                              </logic:iterate>
                            </table>

                            <p>&nbsp;</p>
                        </div></td>
                      </tr>
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
                                <td align="left"><font face="华文新魏" size="3"><font color="red">代表、委员详细信息</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>&nbsp;</p>
                   <tr>
                                <td height="30" align="left">
								  <table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                    <tr>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CL.jpg" width="10" height="30"></td>
                                      <td width="10%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                             <a href='vipsearchdbwybaseinfoview.do?smbi_id=<%=viewsmbi_id%>'>
                                              基本信息 </a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='vipsearchdbwydeputyinfoview1.do?smbi_id=<%=viewsmbi_id%>'>
                                              代表委员信息 </a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='vipsearchdbwyacademyrelationviewlist1.do?smbi_id=<%=viewsmbi_id%>'>
                                              参加学会信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td><div align="center" class="style14 style17">
                                              <a href='vipsearchdbwypastjobview1.do?smbi_id=<%=viewsmbi_id%>'>
                                              主要工作经历</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='vipsearchdbwyresearchproductionview1.do?smbi_id=<%=viewsmbi_id%>'>
                                              主要科研成果</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='vipsearchdbwyacademicliteratureview1.do?smbi_id=<%=viewsmbi_id%>'>
                                              主要学术科普论著</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="21%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                               <a href='vipsearchdbwypatentinfoview1.do?smbi_id=<%=viewsmbi_id%>'>
                                              专利（软件著作权）情况</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CR.jpg" width="10" height="30"></td>
                                    </tr>
                                  </table></td>
                              </tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#e6f0fa">
                                  <tr>
                                    <td height="100"> <table width="100%" height="100" cellpadding="0" cellspacing="0" border="0" style="BORDER-LEFT:#c4c4c4 1px solid; BORDER-RIGHT:#c4c4c4 1px solid; BORDER-BOTTOM:#c4c4c4 1px solid">
                                        <tr>
                                          <td align="center" valign="top"> <p>&nbsp;</p>

                                    <table width="95%" border="0">
                                      <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                                        <td> <div align="center" class="style14">单位名称</div></td>
                                        <td> <div align="center" class="style14">职称</div></td>
                                        <td> <div align="center" class="style14">起止年月</div></td>
                                        <td> <div align="center" class="style14">地点</div></td>
                                      </tr>
                                      <logic:iterate id="smember" name="SEARCHSMEMBERPASTJOBLIST" type="com.cssrc.bean.admin.Smemberpastjob">
                                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                                        <td> <div align="center"> <bean:write name="smember" property="jobinstitute" scope="page"/>
                                          </div></td>
                                        <td> <div align="center"> <bean:write name="smember" property="jobrank" scope="page"/>
                                          </div></td>
                                        <td> <div align="center"> <bean:write name="smember" property="startdate" scope="page" format="yyyy-MM-dd"/>至<bean:write name="smember" property="enddate" scope="page" format="yyyy-MM-dd"/>
                                          </div></td>
                                        <td> <div align="center"> <bean:write name="smember" property="jobaddress" scope="page"/>
                                          </div></td>
                                      </tr>
                                      </logic:iterate>
                                    </table>
                <tr>
                  <td height="60" align="right">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="location.href='vipdbwyquerylist.do'" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
              </table>

                                        </tr>
                                      </table></td>
                                  </tr>

              </table></td>
            </tr>
          </table>
        </TR>
    </TABLE>
</body>
</html>


