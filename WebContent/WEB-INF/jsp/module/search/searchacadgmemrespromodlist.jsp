<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer modifygmbi_id = (Integer)session.getAttribute("gmbi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<%Integer modifyagmr_id = (Integer)session.getAttribute("agmr_id");%>
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
                         <td height="30" align="right" class=""><strong><a href="<%=contextpath%>/logout.do" target="_top">退出系统</a></strong></td>
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
             			<div align="left"> <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                   <b><font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </logic:notEqual>
                                  </div>
                              </tr>
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                               <logic:iterate id="academyop" name="ACADEMYBASEINFOLIST" type="com.cssrc.bean.admin.Academybaseinfo">
                                              <tr>
                                               <BR>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                        <html:link page="/smemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          <bean:write name="academyop" property="acadname" scope="page"/>
                                                        </html:link>
                                                </tr>
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
                                 <td align="left"><font face="华文新魏" size="3"><%=(String)request.getSession().getAttribute("academybaseinfoassoname")%>&nbsp;&gt;&gt;&nbsp;<font color="red">修改团体会员信息</font></font><br>
                                     <hr color="#008000" size="3">
                                </td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>&nbsp;</p>
                   <tr>
                                <td height="30" align="left">
								  <table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                    <tr>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CL.jpg" width="10" height="30"></td>
                                      <td width="33%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchacadgmembaseinfomodify.do?agmr_id=<%=modifyagmr_id%>'>基本信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                      <td width="33%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td><div align="center" class="style14 style17">
                                              <a href='searchacadgmemrespromodlist.do?gmbi_id=<%=modifygmbi_id%>'>主要产品（科研成果）信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                      <td width="34%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchacadgmempatentmodlist.do?gmbi_id=<%=modifygmbi_id%>'>专利、标准信息</a></div></td>
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
                                          <td align="center" valign="top">
                                          <p>&nbsp;</p>

                                    <table width="95%" border="0">
                                      <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                                        <td width="20%"> <div align="center" class="style14">产品（成果）名称</div></td>
                                        <td width="15%"> <div align="center" class="style14">完成日期</div></td>
                                        <td width="25%"> <div align="center" class="style14">获奖情况</div></td>
                                        <td width="24%"> <div align="center" class="style14">可应用领域</div></td>
                                        <td width="8%"> <div align="center" class="style14">删除</div></td>
                                        <td width="8%"> <div align="center" class="style14">修改</div></td>
                                      </tr>
                                      <logic:iterate id="acadewc" name="GMEMBERRESEARCHPRODUCTIONLIST" type="com.cssrc.bean.admin.Gmemberresearchproduction">
                                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                                        <td> <div align="center"><bean:write name="acadewc" property="prodname" scope="page"/>
                                          </div></td>
                                        <td><div align="center"> <bean:write name="acadewc" property="proddate" scope="page" format="yyyy-MM-dd"/></div></td>
                                        <td><div align="center"> <bean:write name="acadewc" property="prodrewards" scope="page"/></div></td>
                                        <td><div align="center"> <bean:write name="acadewc" property="prodapplication" scope="page"/></div></td>
                                        <td><div align="center"> <html:link page="/searchacadgmemresprodel.do" paramId="gmrp_id" paramName="acadewc" paramProperty="gmrp_id" onclick="return warndelete()">
                                            <img src="<%=contextpath%>/images/icon/delete.gif" width="16" height="16" border="0" alt="删除">
                                            </html:link> </div></td>
                                        <td><div align="center"> <html:link page="/searchacadgmemrespromodmod.do" paramId="gmrp_id" paramName="acadewc" paramProperty="gmrp_id" onclick="return warn()">
                                            <img src="<%=contextpath%>/images/icon/modify.gif" width="16" height="16" border="0" alt="修改">
                                            </html:link> </div></td>
                                      </tr>
                                      </logic:iterate>
                                    </table>
                       <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                   <input type="button" class="button" name="strutsButton" value="添加记录" onclick="location.href='searchacadgmemrespromodadd.do'">
                           &nbsp;
                        <input type="button" class="button" value="返回" onclick="location.href='academygmemquerylist.do'">

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
