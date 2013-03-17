<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer viewabi_id = (Integer)session.getAttribute("abi_id");%>

<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>
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
             		<div align="left"> <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
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
                                <td align="left"><font face="华文新魏" size="3"><font color="red"><%=(String)request.getSession().getAttribute("acadname")%>详细信息</font></font><br>
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
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">

                                          <a href='systemacademysearchview.do?abi_id=<%=viewabi_id%>'>基本信息</a>

                                          </div>
                                        </td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">

                                          <a href='systemacademysearchprincipalview.do?abi_id=<%=viewabi_id%>'>负责人信息</a>




                                        </div>
                                        </td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">

                                          <a href='systemacademysearchcouncilview.do?abi_id=<%=viewabi_id%>'>理事会</a>




                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="17%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg" ><div align="center" class="style14 style17">
                                          <a href='systemacademysearchorganizationinfoview.do?abi_id=<%=viewabi_id%>'>学会组织机构设置</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchspecialitycommitteeview.do?abi_id=<%=viewabi_id%>'>专业委员会</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg" bgcolor="#F4F4F4"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchworkcommitteeviewlist.do?abi_id=<%=viewabi_id%>'>工作委员会</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                    <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td><div align="center" class="style14 style17">
                                          <a href='systemacademysearchjournalbrandinfoviewlist.do?abi_id=<%=viewabi_id%>'>会刊与品牌建设</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchpartybuildview.do?abi_id=<%=viewabi_id%>'>党建信息</a></div></td>
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

                                          <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                            <tr bgcolor="white">
                                              <td height="20" colspan="5" align="center" bgcolor="#e6f0fa">
                                                <table width="95%" border="0">
                                                  <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                                                    <td width="20%">
                                                      <div align="center" class="style14">会刊名称</div></td>
                                                    <td width="10%">
                                                      <div align="center" class="style14">刊号</div></td>
                                                    <td width="10%">
                                                      <div align="center" class="style14">发行周期</div></td>
                                                    <td width="10%">
                                                      <div align="center" class="style14">发行数量</div></td>
                                                    <td width="10%"><div align="center" class="style14">总编姓名</div></td>
                                                    <td width="20%"><div align="center" class="style14">编辑部地址</div></td>
                                                    <td width="10%"><div align="center" class="style14">联系电话</div></td>
                                                    <td width="10%"><div align="center" class="style14">独立会刊否</div></td>
                                                  </tr>
                                                  <logic:iterate id="acadeop" name="ACADEMYJOURNALINFOLIST" type="com.cssrc.bean.admin.Academyjournalinfo">
                                                  <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                                                    <td>
                                                      <div align="center"> <bean:write name="acadeop" property="journalname" scope="page"/> </div></td>
                                                    <td>
                                                      <div align="center"> <bean:write name="acadeop" property="journalcode" scope="page"/> </div></td>
                                                    <td>
                                                      <div align="center"> <bean:write name="acadeop" property="publishperiod" scope="page"/> </div></td>
                                                    <td>
                                                      <div align="center"> <bean:write name="acadeop" property="publishcount" scope="page"/> </div></td>
                                                    <td><div align="center"> <bean:write name="acadeop" property="editorname" scope="page"/> </div></td>
                                                    <td><div align="center"> <bean:write name="acadeop" property="contactaddress" scope="page"/> </div></td>
                                                    <td><div align="center"> <bean:write name="acadeop" property="contacttelephone" scope="page"/> </div></td>
                                                    <td><div align="center"> <bean:write name="acadeop" property="isself" scope="page"/> </div></td>
                                                  </tr>
                                              </logic:iterate>                                              </table></td>
                                            </tr>
                                          </TABLE>
                                          <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                           &nbsp;
                        

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                  </td>
                </tr>
              </table>

                                        </tr>
<tr>
                                          <td align="center" valign="top">
                                          <p>&nbsp;</p>

                                          <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                            <tr bgcolor="white">
                                              <td height="20" colspan="5" align="center" bgcolor="#e6f0fa">
                                                <table width="95%" border="0">
                                                  <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                                                    <td width="15%">
                                                      <div align="center" class="style14">品牌活动名称</div></td>
                                                    <td width="10%">
                                                      <div align="center" class="style14">活动届期</div></td>
                                                    <td width="75%"><div align="center" class="style14">活动简介</div></td>
                                                  </tr>
                                                  <logic:iterate id="acadebcop" name="ACADEMYBRANDCONSTRUCTLIST" type="com.cssrc.bean.admin.Academybrandconstruct">
                                                  <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                                                    <td>
                                                      <div align="center"> <bean:write name="acadebcop" property="activename" scope="page"/> </div></td>
                                                    <td>
                                                      <div align="center"> <bean:write name="acadebcop" property="activeno" scope="page"/> </div></td>
                                                    <td><div align="center"> <bean:write name="acadebcop" property="activememo" scope="page"/> </div></td>
                                                  </tr>
                                              </logic:iterate>                                              </table></td>
                                            </tr>
                                          </TABLE>
                                          <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                           &nbsp;
                        <input type="button" class="button" value="返回" onclick="location.href='systemacademysearchlist.do'">

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
