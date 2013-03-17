<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer modifyabi_id = (Integer)session.getAttribute("abi_id");%>
<script language=JavaScript src="<%=contextpath%>/js/Calendar.js" type=""></script>
<html:form method="post" action="/academysearchupdate.do"  onsubmit="return validateAcademybaseinfoForm(this);">
 <html:hidden property="abi_id" name="academybaseinfoForm"/>
 <html:hidden property="shai_id" name="academybaseinfoForm"/>
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
                                <font color="blue"> <b> <font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b></font>
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
                                    <p>&nbsp;</p>
                              </tr>
                              <tr>
                                <td align="left"><font face="华文新魏" size="3">修改<font color="red"><%=(String)request.getSession().getAttribute("acadname")%></font>信息</font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                    <td align="center" valign="top">

                       <p>&nbsp;</p>
                    <tr>
                                <td height="30" align="left">
								<table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                  <tr>
                                    <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_WL.jpg" width="10" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td><div align="center" class="style14 style17">
                                        <a href='academysearchmodify.do?abi_id=<%=modifyabi_id%>'>
                                          基本信息
                                          </a>
                                       </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                        <a href='academysearchprincipalmodify.do?abi_id=<%=modifyabi_id%>'>
                                         负责人信息








                                        </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                        <a href='academysearchcouncilmodify.do?abi_id=<%=modifyabi_id%>'>
                                        理事会








                                        </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="17%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='academysearchorganizationinfomodifylist.do?abi_id=<%=modifyabi_id%>'>
                                          学会组织机构设置
                                           </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='academysearchspecialitycommitteemodifylist.do?abi_id=<%=modifyabi_id%>'>
                                          专业委员会








                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                        <a href='academysearchworkcommitteemodifylist.do?abi_id=<%=modifyabi_id%>'>
                                        工作委员会








                                        </a>
                                         </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='academysearchjournalbrandinfomodifylist.do?abi_id=<%=modifyabi_id%>'>
                                          会刊与品牌建设








                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
					<a href='academysearchpartybuildmodify.do?abi_id=<%=modifyabi_id%>'>
					党建信息
					</a>
					</div></td>
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
                                            <table width="90%" border="0" bordercolor="#000000">
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1"><font color="#FF0000">*</font>学（协）会名称:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="acadname"name="academybaseinfoForm" size="27"/></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1"><font color="#FF0000">*</font>学会代码:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="acadno"name="academybaseinfoForm" size="27"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">登记日期:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="tempregisterdate"name="academybaseinfoForm" readonly="true" size="24"/>
                                                <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempregisterdate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">注册资金:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="registerfund"name="academybaseinfoForm" size="27"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td width="15%" rowspan="2" align="right" bgcolor="#93C0E1">办公地址:</td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">1.</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="address1"name="academybaseinfoForm" size="27"/></td>
                                                <td width="15%" rowspan="2" align="right" bgcolor="#93C0E1">邮政编码:</td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">1.</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="postcode1"name="academybaseinfoForm" size="27"/></td>
                                              </tr>
                                              <tr>
                                                <td width="5%" align="right" bgcolor="#93C0E1">2.</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="address2"name="academybaseinfoForm" size="27"/></td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">2.</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="postcode2"name="academybaseinfoForm" size="27"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">联系人姓名:</td>
                                                <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="contactperson"name="academybaseinfoForm" size="10"/></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1">联系电话:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="contactphone"name="academybaseinfoForm" size="16"/></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1">传真:</td>
                                                <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="contactfax"name="academybaseinfoForm"size="10"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学会星级评定:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:select property="starlevel" name="academybaseinfoForm" >
                                    <html:option value="无"></html:option>
					               <html:option value="1A"></html:option>
					               <html:option value="2A"></html:option>
					               <html:option value="3A"></html:option>
					               <html:option value="4A"></html:option>
					               <html:option value="5A"></html:option>
				                     </html:select></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1"><font color="#FF0000">*</font>主管单位:</td>
                                                <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><html:text property="is311"name="academybaseinfoForm" size="27"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">业务范围:</td>
                                                <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="operationrange"name="academybaseinfoForm" size="83"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">工作人员总数:</td>
                                                <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="staffcount"name="academybaseinfoForm" size="10"/></td>
                                                <td width="15%" height="25" align="left" bgcolor="#93C0E1">人</td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">其中兼职人数:</td>
                                                <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="parttimecount"name="academybaseinfoForm" size="10"/></td>
                                                <td width="15%" height="25" align="left" bgcolor="#93C0E1">人</td>
                                              </tr>

                                            </table>
                                            <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    <input name="submit" type="submit" class="button"
value="更新">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="history.back()" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
            </table>

                              </td>
                           </tr>
                      </TABLE></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </TABLE>

        </td>
        </tr>




</HTML>
</html:form>
<html:javascript formName="academybaseinfoForm"/>
