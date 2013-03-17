<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
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

function print()
{
	
	
	location.href='reportdownload.do?writeExcelClass=SMEMBERBASEINFOALL'
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

						<%@include file = "/WEB-INF/jsp/navigation/navigation_admin_sysperson.txt"%>

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

                                    <p>  <html:form method="post" action="/notecharge.do?data=old">
	        <input type="hidden" name="searchaction" value="list"/>
           <TBODY>
              <TR vAlign=top>
                <TD>
                  <TABLE cellSpacing=0 cellPadding=0 width="98%" align="center" border=0>
                    <TBODY align="center">
                      <TR>
                        <TD width=150><SPAN class=LgBlueText>年份</SPAN></TD>
                        <TD width=150><SPAN class=LgBlueText>月份</SPAN></TD>
                        <td width="150"></td>
                      </TR>
                      <TR>

                        <td><html:text property="searchvalue1" size="20" name="queryForm"/></td>
                        <TD align="center">
                          <html:select name="queryForm" property="searchitem1">
                          <html:option value="memname">1</html:option>
                           <html:option value="membirthday">2</html:option>
                           <html:option value="memsex">3</html:option>
                           <html:option value="memparty_s">4</html:option>
                           <html:option value="memscholar">5</html:option>
                           <html:option value="memdegree">6</html:option>
                           <html:option value="memrank_s">7</html:option>
                           <html:option value="memnationality_s">8</html:option>
                           <html:option value="memnation_s">9</html:option>
                           <html:option value="isemployee">10</html:option>
                           <html:option value="meminstitute">11</html:option>
                           <html:option value="memskill">12</html:option>
                         </html:select>
                        </TD>
                        <td width="200">&nbsp;</td>
                      </TR>
                      <tr>
                        <TD>&nbsp; </TD>
                         <TD><input  align="right" type="button" class="button" name="strutsButton" value="查询" onclick="submitForm('search')"> </TD>
                         <TD>&nbsp; </TD>
                          <TD><input  align="left" type="button" class="button" name="strutsButton" value="重置" onclick="submitForm('reset')"> </TD>

                        <TD> &nbsp;  </TD>
                      </tr>
                      </tbody>
                      </table>
                      </td>
                      </tr>
	<tr>
                                <td align="left"><font face="华文新魏" size="3"><br><font color="red">学会短信收费统计</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
	<tr>
		<td height="30" align="right">
		</td>
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
                      <td>
                        <div align="center" class="style14" ><b><font face="楷体_GB2312" size="3">学（协）会名称</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">短信发送数量</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">费用统计</font></b></div>
                      </td>
                    </tr>

                    <logic:iterate id="op" name="list" type="com.cssrc.bean.admin.Notecharge">

                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">

                        <td>
                          <div align="center">
                            <bean:write name="op" property="name" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="op" property="num" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="op" property="price" scope="page"/>
                          </div>
                        </td>
                        



                      </tr>

                    </logic:iterate>
                    <tr>
                    <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                       <td>&nbsp;                      </td>
                    </tr>
                    <tr>
                    <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                       <td>&nbsp;                      </td>
                    <td  align="right" colspan="10">
                          <input type="button" class="button" value="下载报表" name="strutsButton" onClick="print()">
                    &nbsp;
                        <input type="button" class="button" value="返回" onclick="location.href='acadgrouplist.do'">
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
