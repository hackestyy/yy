<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
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

						<%@include file = "/WEB-INF/jsp/navigation/navigation_vip_sys.txt"%>

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
                  <td width="185" height="24" align="left" valign="top"><html:link page="/vipacadgrouplist.do">
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
             <div align="left"> <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
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

                                    <p>  <html:form method="post" action="/vipsysgmemquerylist.do">
	        <input type="hidden" name="searchaction" value="list"/>
           <TBODY>
              <TR vAlign=top>
                <TD>
                  <TABLE cellSpacing=0 cellPadding=0 width="98%" align="center" border=0>
                    <TBODY align="center">
                      <TR>
                        <TD width=150><SPAN class=LgBlueText>检索词</SPAN></TD>
                        <TD width=150><SPAN class=LgBlueText>检索项</SPAN></TD>
                        <td width="150"></td>
                        <TD width=150 align="center"><SPAN class=LgBlueText>检索词</SPAN> </TD>
                        <TD width=150><SPAN class=LgBlueText>检索项</SPAN></TD>
                      </TR>
                      <TR>

                        <td><html:text property="searchvalue1" size="20" name="queryForm"/></td>
                        <TD align="center">
                          <html:select name="queryForm" property="searchitem1">
                          <html:option value="institutename">单位名称</html:option>
                           <html:option value="acadname">所属学会</html:option>
                           <html:option value="institutetype">单位性质</html:option>
                           <html:option value="prodname">主要产品（科研成果）信息</html:option>
                           <html:option value="patentname">专利标准信息</html:option>
                         </html:select>
                        </TD>
                        <td width="200">&nbsp;</td>
                          <TD>
                            <html:text property="searchvalue2" size="20" name="queryForm"/>
                          </TD>
                          <TD align="center">
                            <html:select name="queryForm" property="searchitem2">
                           <html:option value="institutename">单位名称</html:option>
                           <html:option value="acadname">所属学会</html:option>
                           <html:option value="institutetype">单位性质</html:option>
                           <html:option value="prodname">主要产品（科研成果）信息</html:option>
                           <html:option value="patentname">专利标准信息</html:option>
                         </html:select>
                          </TD>
                      </TR>
                      <TR>
                          <TD>
                            <html:text property="searchvalue3" size="20" name="queryForm"/>
                          </TD>
                          <TD align="center">
                            <html:select name="queryForm" property="searchitem3">
                           <html:option value="institutename">单位名称</html:option>
                           <html:option value="acadname">所属学会</html:option>
                           <html:option value="institutetype">单位性质</html:option>
                           <html:option value="prodname">主要产品（科研成果）信息</html:option>
                           <html:option value="patentname">专利标准信息</html:option>
                            </html:select>
                          </TD>
                             <td width="200">&nbsp;</td>
                          <TD>
                            <html:text property="searchvalue4" size="20" name="queryForm"/>
                          </TD>
                          <TD align="center">
                            <html:select name="queryForm" property="searchitem4">
                           <html:option value="institutename">单位名称</html:option>
                           <html:option value="acadname">所属学会</html:option>
                           <html:option value="institutetype">单位性质</html:option>
                           <html:option value="prodname">主要产品（科研成果）信息</html:option>
                           <html:option value="patentname">专利标准信息</html:option>
                            </html:select>
                          </TD>
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
                                <td align="left"><font face="华文新魏" size="3"><br><font color="red">团体会员信息列表</font></font><br>
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
                        <div align="center" class="style14" ><b><font face="楷体_GB2312" size="3">单位名称</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">所属学会</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">办公地址</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">联系电话</font></b></div>
                      </td>

                      
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">详细</font></b></div>
                      </td>
                    </tr>

                    <logic:iterate id="gmemberop" name="SEARCHGMEMBERBASEINFOLIST" type="com.cssrc.bean.admin.Gmemberbaseinforelation">

                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">

                        <td>
                          <div align="center">
                         <logic:equal name="gmemberop"  property="isdelete" value="0">
                            <bean:write name="gmemberop" property="institutename" scope="page"/>
                           </logic:equal>
                             <logic:equal name="gmemberop"  property="isdelete" value="1">
                          <font color="red">  <bean:write name="gmemberop" property="institutename" scope="page"/></font>
                           </logic:equal>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                          <logic:equal name="gmemberop"  property="isdelete" value="0">
                            <bean:write name="gmemberop" property="acadname" scope="page"/>
                            </logic:equal>
                            <logic:equal name="gmemberop"  property="isdelete" value="1">
                           <font color="red"> <bean:write name="gmemberop" property="acadname" scope="page"/></font>
                            </logic:equal>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                         <logic:equal name="gmemberop"  property="isdelete" value="0">
                            <bean:write name="gmemberop" property="contactaddress" scope="page"/>
                            </logic:equal>
                             <logic:equal name="gmemberop"  property="isdelete" value="1">
                            <font color="red"> <bean:write name="gmemberop" property="contactaddress" scope="page"/></font>
                             </logic:equal>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                         <logic:equal name="gmemberop"  property="isdelete" value="0">
                            <bean:write name="gmemberop" property="contacttelephone" scope="page"/>
                            </logic:equal>
                           <logic:equal name="gmemberop"  property="isdelete" value="1">
                          <font color="red">  <bean:write name="gmemberop" property="contacttelephone" scope="page"/></font>
                           </logic:equal>
                          </div>
                        </td>

                        
                        <td>
                          <div align="center">
                            <html:link page="/searchvipsysgmembaseinfoview.do" paramId="agmr_id" paramName="gmemberop" paramProperty="agmr_id" >
                              <img src="<%=contextpath%>/images/icon/view.gif" width="16" height="16" border="0" alt="详细">
                            </html:link>
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
                       
                    </tr>
                    <tr>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                    <td  align="right" colspan="3">
                          <!-- <input type="button" class="button" name="strutsButton" value="添加记录" onclick="location.href='smemberbaseinfoadd.do?abi_id=<%=smemberabi_id%>'">-->
                           &nbsp;
                           <input type="button" class="button" value="下载报表" name="strutsButton" onClick="location.href='reportdownload.do?writeExcelClass=SYSGMEMBERBASEINFO'">
                    &nbsp;
                        <input type="button" class="button" value="返回" onclick="location.href='vipacadgrouplist.do'">
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
