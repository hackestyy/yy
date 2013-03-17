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

                                    <p>  <html:form method="post" action="/systemquerylist.do">
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
                          <html:option value="memname">姓名</html:option>
                           <html:option value="membirthday">年龄</html:option>
                           <html:option value="memsex">性别</html:option>
                           <html:option value="memparty_s">政治面貌</html:option>
                           <html:option value="memscholar">学历</html:option>
                           <html:option value="memdegree">学位</html:option>
                           <html:option value="memrank_s">技术职称</html:option>
                           <html:option value="memnationality_s">国籍</html:option>
                           <html:option value="memnation_s">民族</html:option>
                           <html:option value="isemployee">是否在职</html:option>
                           <html:option value="meminstitute">工作单位</html:option>
                           <html:option value="memskill">主要技术特长</html:option>
                           <html:option value="assoduty_s">科协现任职务</html:option>
                           <html:option value="socialduty1">主要社会职务</html:option>
                           <html:option value="socialhonour1">主要社会荣誉</html:option>
                           <html:option value="sports1">喜欢参加的文体活动</html:option>
                           <html:option value="interduty_s">参加国际性学术社团及任职情况</html:option>
                           <html:option value="nationduty_s">参加全国性学术社团及任职情况</html:option>
                           <html:option value="academyduty1">学会职务</html:option>
                           <html:option value="memtype">会员类别</html:option>
                           <html:option value="belongcommittee1">所在专业委员会</html:option>
                           <html:option value="joindate">入会时间</html:option>
                           <html:option value="isannualregister">年度注册</html:option>
                           <html:option value="prodname">主要科研成果</html:option>
                           <html:option value="litename">主要学术科普论著</html:option>
                           <html:option value="patentname">专利（软件著作权）情况</html:option>
                         </html:select>
                        </TD>
                        <td width="200">&nbsp;</td>
                          <TD>
                            <html:text property="searchvalue2" size="20" name="queryForm"/>
                          </TD>
                          <TD align="center">
                            <html:select name="queryForm" property="searchitem2">
                           <html:option value="memname">姓名</html:option>
                           <html:option value="membirthday">年龄</html:option>
                           <html:option value="memsex">性别</html:option>
                           <html:option value="memparty_s">政治面貌</html:option>
                           <html:option value="memscholar">学历</html:option>
                           <html:option value="memdegree">学位</html:option>
                           <html:option value="memrank_s">技术职称</html:option>
                           <html:option value="memnationality_s">国籍</html:option>
                           <html:option value="memnation_s">民族</html:option>
                           <html:option value="isemployee">是否在职</html:option>
                           <html:option value="meminstitute">工作单位</html:option>
                           <html:option value="memskill">主要技术特长</html:option>
                           <html:option value="assoduty_s">科协现任职务</html:option>
                           <html:option value="socialduty1">主要社会职务</html:option>
                           <html:option value="socialhonour1">主要社会荣誉</html:option>
                           <html:option value="sports1">喜欢参加的文体活动</html:option>
                           <html:option value="interduty_s">参加国际性学术社团及任职情况</html:option>
                           <html:option value="nationduty_s">参加全国性学术社团及任职情况</html:option>
                           <html:option value="academyduty1">学会职务</html:option>
                           <html:option value="memtype">会员类别</html:option>
                           <html:option value="belongcommittee1">所在专业委员会</html:option>
                           <html:option value="joindate">入会时间</html:option>
                           <html:option value="isannualregister">年度注册</html:option>
                           <html:option value="prodname">主要科研成果</html:option>
                           <html:option value="litename">主要学术科普论著</html:option>
                           <html:option value="patentname">专利（软件著作权）情况</html:option>
                         </html:select>
                          </TD>
                      </TR>
                      <TR>
                          <TD>
                            <html:text property="searchvalue3" size="20" name="queryForm"/>
                          </TD>
                          <TD align="center">
                            <html:select name="queryForm" property="searchitem3">
                           <html:option value="memname">姓名</html:option>
                           <html:option value="membirthday">年龄</html:option>
                           <html:option value="memsex">性别</html:option>
                           <html:option value="memparty_s">政治面貌</html:option>
                           <html:option value="memscholar">学历</html:option>
                           <html:option value="memdegree">学位</html:option>
                           <html:option value="memrank_s">技术职称</html:option>
                           <html:option value="memnationality_s">国籍</html:option>
                           <html:option value="memnation_s">民族</html:option>
                           <html:option value="isemployee">是否在职</html:option>
                           <html:option value="meminstitute">工作单位</html:option>
                           <html:option value="memskill">主要技术特长</html:option>
                           <html:option value="assoduty_s">科协现任职务</html:option>
                           <html:option value="socialduty1">主要社会职务</html:option>
                           <html:option value="socialhonour1">主要社会荣誉</html:option>
                           <html:option value="sports1">喜欢参加的文体活动</html:option>
                           <html:option value="interduty_s">参加国际性学术社团及任职情况</html:option>
                           <html:option value="nationduty_s">参加全国性学术社团及任职情况</html:option>
                           <html:option value="academyduty1">学会职务</html:option>
                           <html:option value="memtype">会员类别</html:option>
                           <html:option value="belongcommittee1">所在专业委员会</html:option>
                           <html:option value="joindate">入会时间</html:option>
                           <html:option value="isannualregister">年度注册</html:option>
                           <html:option value="prodname">主要科研成果</html:option>
                           <html:option value="litename">主要学术科普论著</html:option>
                           <html:option value="patentname">专利（软件著作权）情况</html:option>
                            </html:select>
                          </TD>
                             <td width="200">&nbsp;</td>
                          <TD>
                            <html:text property="searchvalue4" size="20" name="queryForm"/>
                          </TD>
                          <TD align="center">
                            <html:select name="queryForm" property="searchitem4">
                           <html:option value="memname">姓名</html:option>
                           <html:option value="membirthday">年龄</html:option>
                           <html:option value="memsex">性别</html:option>
                           <html:option value="memparty_s">政治面貌</html:option>
                           <html:option value="memscholar">学历</html:option>
                           <html:option value="memdegree">学位</html:option>
                           <html:option value="memrank_s">技术职称</html:option>
                           <html:option value="memnationality_s">国籍</html:option>
                           <html:option value="memnation_s">民族</html:option>
                           <html:option value="isemployee">是否在职</html:option>
                           <html:option value="meminstitute">工作单位</html:option>
                           <html:option value="memskill">主要技术特长</html:option>
                           <html:option value="assoduty_s">科协现任职务</html:option>
                           <html:option value="socialduty1">主要社会职务</html:option>
                           <html:option value="socialhonour1">主要社会荣誉</html:option>
                           <html:option value="sports1">喜欢参加的文体活动</html:option>
                           <html:option value="interduty_s">参加国际性学术社团及任职情况</html:option>
                           <html:option value="nationduty_s">参加全国性学术社团及任职情况</html:option>
                           <html:option value="academyduty1">学会职务</html:option>
                           <html:option value="memtype">会员类别</html:option>
                           <html:option value="belongcommittee1">所在专业委员会</html:option>
                           <html:option value="joindate">入会时间</html:option>
                           <html:option value="isannualregister">年度注册</html:option>
                           <html:option value="prodname">主要科研成果</html:option>
                           <html:option value="litename">主要学术科普论著</html:option>
                           <html:option value="patentname">专利（软件著作权）情况</html:option>
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
                                <td align="left"><font face="华文新魏" size="3"><br><font color="red">个人会员信息列表</font></font><br>
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
                        <div align="center" class="style14" ><b><font face="楷体_GB2312" size="3">会员姓名</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">性别</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">工作单位</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">联系电话</font></b></div>
                      </td>

                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">删除</font></b></div>
                      </td>
                      <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">修改</font></b></div>
                      </td>
                       <td>
                        <div align="center" class="style14"><b><font face="楷体_GB2312" size="3">详细</font></b></div>
                      </td>
                    </tr>

                    <logic:iterate id="smemberop" name="SEARCHSMEMBERBASEINFOLIST" type="com.cssrc.bean.admin.Smemberbainforelation">

                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">

                        <td>
                          <div align="center">
                         <logic:equal name="smemberop"  property="isdelete" value="0">
                            <bean:write name="smemberop" property="memname" scope="page"/>
                           </logic:equal>
                             <logic:equal name="smemberop"  property="isdelete" value="1">
                          <font color="red">  <bean:write name="smemberop" property="memname" scope="page"/></font>
                           </logic:equal>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                          <logic:equal name="smemberop"  property="isdelete" value="0">
                            <bean:write name="smemberop" property="memsex" scope="page"/>
                            </logic:equal>
                            <logic:equal name="smemberop"  property="isdelete" value="1">
                           <font color="red"> <bean:write name="smemberop" property="memsex" scope="page"/></font>
                            </logic:equal>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                         <logic:equal name="smemberop"  property="isdelete" value="0">
                            <bean:write name="smemberop" property="meminstitute" scope="page"/>
                            </logic:equal>
                             <logic:equal name="smemberop"  property="isdelete" value="1">
                            <font color="red"> <bean:write name="smemberop" property="meminstitute" scope="page"/></font>
                             </logic:equal>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                         <logic:equal name="smemberop"  property="isdelete" value="0">
                            <bean:write name="smemberop" property="institutetelephone" scope="page"/>
                            </logic:equal>
                           <logic:equal name="smemberop"  property="isdelete" value="1">
                          <font color="red">  <bean:write name="smemberop" property="institutetelephone" scope="page"/></font>
                           </logic:equal>
                          </div>
                        </td>

                        <td>
                          <div align="center">
                            <html:link page="/searchsmemberbaseinfodelete.do" paramId="smbi_id" paramName="smemberop" paramProperty="smbi_id" onclick="return warndelete()">
                              <img src="<%=contextpath%>/images/icon/delete.gif" width="16" height="16" border="0" alt="删除">
                            </html:link>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <html:link page="/searchsmemberbaseinfomodify.do" paramId="smbi_id" paramName="smemberop" paramProperty="smbi_id" >
                              <img src="<%=contextpath%>/images/icon/modify.gif" width="16" height="16" border="0" alt="修改">
                            </html:link>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <html:link page="/searchsmemberbaseinfoview.do" paramId="smbi_id" paramName="smemberop" paramProperty="smbi_id" >
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
