<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer viewsmbi_id = (Integer)session.getAttribute("smbi_id");%>
<%Integer viewasmr_id = (Integer)session.getAttribute("asmr_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
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
                  <td width="185" height="24" align="left" valign="top"><img src="images/left_01.gif" width="185" height="24"></td>
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
             		<div align="left"> <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                 <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </div>
                              </tr>
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
                                <td align="left"><font face="华文新魏" size="3"><font color="red">个人会员详细信息</font></font><font color="red" style="float:right">参加会议（活动）情况 </font><br>
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
                                      <td width="10%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchsmemberbaseinfoview.do?smbi_id=<%=viewsmbi_id%>'>基本信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchsmemberdeputyinfoview.do?smbi_id=<%=viewsmbi_id%>'>代表委员信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchacademysmemberrelationviewlist.do?smbi_id=<%=viewsmbi_id%>'>参加学会信息</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchsmemberpastjobview.do?smbi_id=<%=viewsmbi_id%>'>主要工作经历</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchsmemberresearchproductionview.do?smbi_id=<%=viewsmbi_id%>'>主要科研成果</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                              <a href='searchsmemberacademicliteratureview.do?smbi_id=<%=viewsmbi_id%>'>主要学术科普论著</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                      <td width="21%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td><div align="center" class="style14 style17">
                                              <a href='searchsmemberpatentinfoview.do?smbi_id=<%=viewsmbi_id%>'>专利（软件著作权）情况</a></div></td>
                                          </tr>
                                      </table></td>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_WR.jpg" width="10" height="30"></td>
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
                                        <td width="40%"> <div align="center" class="style14">专利（软件著作权）名称</div></td>
                                        <td width="15%"> <div align="center" class="style14">授权日期</div></td>
                                        <td width="15%"> <div align="center" class="style14">专利类型</div></td>
                                        <td width="15%"> <div align="center" class="style14">是否产业化</div></td>
                                        <td width="15%"> <div align="center" class="style14">年产值</div></td>
                                      </tr>
                                      <logic:iterate id="acadewc" name="SEARCHSMEMBERPATENTINFOLIST" type="com.cssrc.bean.admin.Smemberpatentinfo">
                                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                                        <td><div align="center"><bean:write name="acadewc" property="patentname" scope="page"/></div></td>
                                        <td><div align="center"><bean:write name="acadewc" property="patentdate" scope="page" format="yyyy-MM-dd"/></div></td>
                                        <td><div align="center"><bean:write name="acadewc" property="patenttype" scope="page"/></div></td>
                                        <td><div align="center"><bean:write name="acadewc" property="patentisindustrialized" scope="page"/></div></td>
                                        <td><div align="center"><bean:write name="acadewc" property="patentvalue" scope="page"/></div></td>
                                      </tr>
                                      </logic:iterate>
                                    </table>
                       <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                           &nbsp;
                        <input type="button" class="button" value="返回" onclick="location.href='systemquerylist.do'">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                  </td>
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
